package com.trek.easy.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Orders {
	private Integer orderid;
	private String date;
	private Double price;
	private String status;
	private Trek trek;
	private Hotel hotel;
	private Activity activity;
	private String fromDate;
	private String toDate;
	private Integer count; // order count 
}
