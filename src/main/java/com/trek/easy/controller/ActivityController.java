package com.trek.easy.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trek.easy.model.Activity;
import com.trek.easy.service.ActivityService;

@RestController
@RequestMapping(value = "/activity")
public class ActivityController implements ControllerCRUD<Activity, Integer> {
	ActivityService service;

	@Override
	@GetMapping("/add")
	public int add(@RequestBody Activity obj) {
		service.add(obj);
		return 200;
	}

	@Override
	@GetMapping("/update")
	public int update(@RequestBody Activity obj) {
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
	public Activity getById(@PathVariable Integer id) {
		return service.get(id);
	}

	@Override
	@GetMapping("/get/all")
	public List<Activity> getAll() {
		return service.getAll();
	}

}
