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
public class Hotel {
	private Integer hotelid;
	private String name;
	private Double price;
	private List<Review> reviews;
	private String location;
	private String image;
	private Blog blog;
}
