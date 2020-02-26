package com.hame.FuelCheck.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(Include.NON_NULL)
public class Transactions {

	@JsonProperty(value="Error")
	private Error error;
	
	@JsonProperty(value="Data")
	private Data data;

}
