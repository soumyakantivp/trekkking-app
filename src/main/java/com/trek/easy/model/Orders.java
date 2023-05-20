package com.trek.easy.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer orderid;
	private String date;
	private Double price;
	private String status;
	@OneToOne
	private Trek trek;
	@OneToOne
	private Hotel hotel;
	@OneToOne
	private Activity activity;
	private String fromDate;
	private String toDate;
	private Integer count; // order count 
}
