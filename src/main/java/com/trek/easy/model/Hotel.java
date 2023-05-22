package com.trek.easy.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
public class Hotel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer hotelid;
	private String name;
	private Double price;
	@OneToMany
	@JsonIgnore
	private List<Review> reviews;
	private String location;
	private String image;
	private String blog;
	private Double rating;
}
