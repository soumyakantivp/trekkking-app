package com.trek.easy.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Activity {
	private Integer activityid;
	private String description;
	private Double price;
	private Blog blog;
	private List<Review> reviews;
	private String location;
	private String image;
}
