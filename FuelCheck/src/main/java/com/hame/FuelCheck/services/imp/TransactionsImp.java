package com.hame.FuelCheck.services.imp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.hame.FuelCheck.entity.TransactionEntity;
import com.hame.FuelCheck.model.Credentials;
import com.hame.FuelCheck.model.Item;
import com.hame.FuelCheck.model.Parameters;
import com.hame.FuelCheck.model.Response;
import com.hame.FuelCheck.model.Transactions;
import com.hame.FuelCheck.repository.TransactionRepository;
import com.hame.FuelCheck.services.TransactionsService;

@Service
public class TransactionsImp implements TransactionsService {

	@Value("${config.getAccessToken}")
	private String urlAccessToken;

	@Value("${config.getTransactionBatcNumber}")
	private String urlTransactionBatcNumber;

	@Value("${config.getTransaction}")
	private String urlTransaction;

	@Value("${config.getClientId}")
	private String clientId;

	@Value("${config.getClientSecret}")
	private String clientSecret;

	@Value("${config.getTokenStorageMedium}")
	private String tokenStorageMedium;

	@Value("${config.getFilterTaggedTransactions}")
	private String filterTaggedTransactions;
	
	@Autowired
	private TransactionRepository transactionRepo;

	private String token;

	public String getAccessToken() {
		RestTemplate restTemplate = new RestTemplate();

		Credentials credentials = new Credentials();
		credentials.setClientId(clientId);
		credentials.setClientSecret(clientSecret);
		credentials.setTokenStorageMedium(tokenStorageMedium);

		Transactions trans = restTemplate.postForObject(urlAccessToken, credentials, Transactions.class);

		return trans.getData().getItems().get(0).getAccessToken();
	}

	@Override
	public Map<String, String> getBatchNumber() {
		token = "";
		Map<String, String> values = new HashMap<String, String>();

		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();

		token = getAccessToken(); // manda a llamar token

		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
		map.add("accessToken", token);

		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(map, headers);
		Transactions transBatch = restTemplate.postForObject(urlTransactionBatcNumber, entity, Transactions.class);

		values.put("totalRecords", String.valueOf(transBatch.getData().getMeta().getTotalRecords()));
		values.put("batchNumber", String.valueOf(transBatch.getData().getItems().get(0).getNewBatchNumber()));

		return values;
	}

	@Override
	public void toStockTransactions(List<TransactionEntity> transactions) {
		transactionRepo.saveAll(transactions);
	}

	@Override
	public Response requestTransaction() {
		Response res = new Response();
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		Parameters parameters = new Parameters();
		String batch = getBatchNumber().get("batchNumber"); // llamada a servicio que obtiene el batch

		parameters.setAccessToken(token);
		parameters.setFilterTaggedTransactions(filterTaggedTransactions);
		parameters.setBatchNumber(Integer.parseInt(batch));
		parameters.setStartRecord("1");
		parameters.setEndRecord("100");

		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
		map.add("accessToken", parameters.getAccessToken());
		map.add("filterTaggedTransactions", parameters.getFilterTaggedTransactions());
		map.add("batchNumber", batch);
		map.add("startRecord", parameters.getStartRecord());
		map.add("endRecord", parameters.getEndRecord());

		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(map, headers);

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Transactions transactions = restTemplate.postForObject(urlTransaction, entity, Transactions.class);

		List<TransactionEntity> listEntityTran = new ArrayList<>();
		
		for(Item item: transactions.getData().getItems()) {
			TransactionEntity tranEntity = new TransactionEntity();
			tranEntity.setCardNumber(item.getCardNumber());
			listEntityTran.add(tranEntity);
		}
		
		toStockTransactions(listEntityTran);
		
		res.setCode(200);
		res.setMsg("ok");
		return res;
	}
	

	

}
