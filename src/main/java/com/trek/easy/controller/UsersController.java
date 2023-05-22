package com.trek.easy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trek.easy.model.Users;
import com.trek.easy.service.UsersService;

@RestController
@RequestMapping(value = "/users")
public class UsersController implements ControllerCRUD<Users, Integer> {
	@Autowired
	UsersService service;

	@Override
	@PostMapping("/add")
	public int add(@RequestBody Users obj) {
		if(service.findUserByUserName(obj.getUsername()) != null)
			return 400; // user exists
		service.add(obj);
		return 200;
	}

	@Override
	@PostMapping("/update")
	public int update(@RequestBody Users obj) {
		service.update(obj);
		return 200;
	}

	@Override
	@GetMapping("/delete/{id}")
	public int delete(@PathVariable Integer id) {
		return service.delete(id);
	}

	@Override
	@GetMapping("/get/{id}")
	public Users getById(@PathVariable Integer id) {
		return service.get(id);
	}

	@Override
	@GetMapping("/get/all")
	public List<Users> getAll() {
		return service.getAll();
	}
	
	@GetMapping("/login")
	public Users login(@RequestBody Users obj) {
		Users user = service.findUserByUserName(obj.getUsername());
		if(user != null) {
			if(user.getPassword().equals(obj.getPassword())) {
				return user;
			}
		}
		return null;
	}

}
