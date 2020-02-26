package com.hame.FuelCheck.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table
public class TransactionEntity {

	@Id
	@Column(name = "")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transaction_sq")
	@SequenceGenerator(name = "transaction_sq", sequenceName = "pruebas.transaction_sq", initialValue = 1, allocationSize = 1)
	private long id;
	
	@Column(name="card_number")
	private String cardNumber;
	
	
}
