package com.trek.easy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trek.easy.model.Activity;
import com.trek.easy.repo.ActivityRepo;
@Service
public class ActivityService implements ServiceCRUD<Activity, Integer>{

	@Autowired
	ActivityRepo repo;
	
	@Override
	public void add(Activity obj) {
		repo.save(obj);
	}

	@Override
	public void update(Activity obj) {
		repo.save(obj);
		
	}

	@Override
	public Integer delete(Integer id) {
		repo.deleteById(id);
		return id;
	}

	@Override
	public Activity get(Integer id) {
		return repo.findById(id).get();
	}

	
	@Override
	public List<Activity> getAll() {
		return repo.findAll();
	}
	

}
