package com.trek.easy.model;

import java.util.List;

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
public class Activity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer activityid;
	private String description;
	private Double price;
	@OneToOne
	private Blog blog;
	@OneToMany
	private List<Review> reviews;
	private String location;
	private String image;
}
