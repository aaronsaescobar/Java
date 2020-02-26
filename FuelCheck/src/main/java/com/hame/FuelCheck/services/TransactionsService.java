package com.hame.FuelCheck.services;

import java.util.List;
import java.util.Map;

import com.hame.FuelCheck.entity.TransactionEntity;
import com.hame.FuelCheck.model.Response;

public interface TransactionsService {

	String getAccessToken();

	Map<String, String> getBatchNumber();

	void toStockTransactions(List<TransactionEntity> transactions);

	Response requestTransaction();

}
