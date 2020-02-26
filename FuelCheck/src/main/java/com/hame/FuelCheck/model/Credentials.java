package com.hame.FuelCheck.model;

import lombok.Data;

@Data
public class Credentials {
	
	private String clientId;
	
	private String clientSecret;
	
	private String tokenStorageMedium;

}
