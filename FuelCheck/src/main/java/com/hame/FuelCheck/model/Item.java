package com.hame.FuelCheck.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Item {

	@JsonProperty(value="SiteNumber")
	private String siteNumber;
	
	@JsonProperty(value="DateTime")
	private String dateTime;
	
	@JsonProperty(value="CardNumber")
	private String cardNumber;
	
	@JsonProperty(value="MapCode")
	private int mapCode;
	
	@JsonProperty(value="Reference")
	private int reference;
	
	@JsonProperty(value="CustomerReferenceNumber")
	private String customerReferenceNumber;
	
	@JsonProperty(value="Quantity")
	private int quantity;
	
	@JsonProperty(value="UnitPrice")
	private float unitPrice;
	
	@JsonProperty(value="Amount")
	private float amount;
	
	@JsonProperty(value="ActivityCardNumber")
	private String activityCardNumber;
	
	@JsonProperty(value="Discount")
	private float discount;
	
	@JsonProperty(value="Surcharge")
	private float surcharge;
	
	@JsonProperty(value="Grade")
	private Grade grade;
	
	@JsonProperty(value="Pump")
	private int pump;
	
	@JsonProperty(value="Hose")
	private int hose;
	
	@JsonProperty(value="UserID")
	private String userID;
	
	@JsonProperty(value="Odometer")
	private float odometer;
	
	@JsonProperty(value="TotalEngineHours")
	private float totalEngineHours;
	
	@JsonProperty(value="UnderLoadHours")
	private float underLoadHours;
	
	@JsonProperty(value="PLU")
	private String plu;
	
	@JsonProperty(value="SKU")
	private String sku;
	
	@JsonProperty(value="PromotionCode")
	private String promotionCode;
	
	@JsonProperty(value="rowNumber")
	private int RowNumber;
	
	@JsonProperty(value="AccessToken")
	private String accessToken;
	
	@JsonProperty(value="NewBatchNumber")
	private int newBatchNumber;
}
	
