package com.trek.easy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trek.easy.model.Blog;
import com.trek.easy.service.BlogService;

@RestController
@RequestMapping(value = "/blog")
public class BlogController implements ControllerCRUD<Blog, Integer> {
	@Autowired
	BlogService service;

	@Override
	@PostMapping("/add")
	public int add(@RequestBody Blog obj) {
		service.add(obj);
		return 200;
	}

	@Override
	@PostMapping("/update")
	public int update(@RequestBody Blog obj) {
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
	public Blog getById(@PathVariable Integer id) {
		return service.get(id);
	}

	@Override
	@GetMapping("/get/all")
	public List<Blog> getAll() {
		return service.getAll();
	}

}
