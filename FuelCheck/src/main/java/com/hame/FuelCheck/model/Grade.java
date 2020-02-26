package com.hame.FuelCheck.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Grade {
	
	@JsonProperty(value="GradeNum")
	private int gradeNum;
	
	@JsonProperty(value="Name")
	private String name;

}
