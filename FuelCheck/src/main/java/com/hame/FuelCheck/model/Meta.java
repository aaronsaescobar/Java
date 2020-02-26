package com.hame.FuelCheck.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Meta {
	
	@JsonProperty(value="TotalRecords")
	private int totalRecords;
	
	@JsonProperty(value="Title")
	private String title;
	
	@JsonProperty(value="Endpoint")
	private String endpoint;
	
}
