package com.trek.easy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trek.easy.model.Orders;
import com.trek.easy.service.OrdersService;

@RestController
@RequestMapping(value = "/orders")
public class OrdersController implements ControllerCRUD<Orders, Integer> {
	@Autowired
	OrdersService service;

	@Override
	@PostMapping("/add")
	public int add(@RequestBody Orders obj) {
		service.add(obj);
		return 200;
	}

	@Override
	@PostMapping("/update")
	public int update(@RequestBody Orders obj) {
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
	public Orders getById(@PathVariable Integer id) {
		return service.get(id);
	}

	@Override
	@GetMapping("/get/all")
	public List<Orders> getAll() {
		return service.getAll();
	}

}
