package com.hame.FuelCheck.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hame.FuelCheck.model.Response;
import com.hame.FuelCheck.services.TransactionsService;

@CrossOrigin
@RestController
@RequestMapping("/apptransaction")
public class TransactionRest {
	
	@Autowired
	 private TransactionsService transactionService;
 
	 @GetMapping(value = "/transaction")
	 public ResponseEntity<Response> getBatchNumber(){
		 Response res = transactionService.requestTransaction();
		 
		 return new ResponseEntity<Response>(res,HttpStatus.OK);
	 }

}
