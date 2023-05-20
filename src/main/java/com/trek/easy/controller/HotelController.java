package com.trek.easy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trek.easy.model.Hotel;
import com.trek.easy.service.HotelService;

@RestController
@RequestMapping(value = "/hotel")
public class HotelController implements ControllerCRUD<Hotel, Integer> {
	@Autowired
	HotelService service;

	@Override
	@PostMapping("/add")
	public int add(@RequestBody Hotel obj) {
		service.add(obj);
		return 200;
	}

	@Override
	@PostMapping("/update")
	public int update(@RequestBody Hotel obj) {
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
	public Hotel getById(@PathVariable Integer id) {
		return service.get(id);
	}

	@Override
	@GetMapping("/get/all")
	public List<Hotel> getAll() {
		return service.getAll();
	}

}
