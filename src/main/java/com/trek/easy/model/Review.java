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
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer revid;
	private String desc;
	private String links;
	@OneToOne
	private Trek trek;
	@OneToOne
	private Activity activity;
	@OneToOne
	private Hotel hotel;
	private Integer rating;
	@OneToOne
	private Users user;
}
