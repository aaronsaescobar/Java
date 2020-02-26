package com.hame.FuelCheck.model;

import lombok.Data;

@Data
public class Parameters {
	
	private String accessToken;
	
	private String filterTaggedTransactions;
	
	private int batchNumber;
	
	private String startRecord;
	
	private String endRecord;

}
