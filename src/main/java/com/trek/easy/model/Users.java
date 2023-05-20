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
public class Users {
	private Integer id;
	private String username;
	private String password;
	private String roles;
	private List<Orders> orders;
	private Double wallet;
}
