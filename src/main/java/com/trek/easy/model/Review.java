package com.trek.easy.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Review {
	private Integer revid;
	private String desc;
	private String links;
	private Trek trek;
	private Activity activity;
	private Hotel hotel;
	private Integer rating;
	private Users user;
}
