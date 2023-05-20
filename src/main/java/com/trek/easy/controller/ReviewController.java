package com.trek.easy.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trek.easy.model.Review;
import com.trek.easy.service.ReviewService;

@RestController
@RequestMapping(value = "/review")
public class ReviewController implements ControllerCRUD<Review, Integer> {
	ReviewService service;

	@Override
	@PostMapping("/add")
	public int add(@RequestBody Review obj) {
		service.add(obj);
		return 200;
	}

	@Override
	@PostMapping("/update")
	public int update(@RequestBody Review obj) {
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
	public Review getById(@PathVariable Integer id) {
		return service.get(id);
	}

	@Override
	@GetMapping("/get/all")
	public List<Review> getAll() {
		return service.getAll();
	}

}
