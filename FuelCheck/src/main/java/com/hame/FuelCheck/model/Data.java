package com.hame.FuelCheck.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Data {
	
	@JsonProperty(value="Items")
	private List<Item> items;
	
	@JsonProperty(value="Meta")
	private Meta meta;

}
