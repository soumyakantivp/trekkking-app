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
public class Trek {
	private Integer trekid;
	private String location;
	private List<String> tags;
	private Blog blog;
	private String image;
	private List<Review> reviews;
}
