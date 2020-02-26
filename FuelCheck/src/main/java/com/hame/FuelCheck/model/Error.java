package com.hame.FuelCheck.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Error {

	@JsonProperty(value="Code")
	private int code;
	
	@JsonProperty(value="Status")
	private String status;
}
