package com.trek.easy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trek.easy.model.Activity;
import com.trek.easy.model.Trek;
import com.trek.easy.repo.TrekRepo;
@Service
public class TrekService implements ServiceCRUD<Trek, Integer>{

	@Autowired
	TrekRepo repo;
	
	@Override
	public void add(Trek obj) {
		repo.save(obj);
	}

	@Override
	public void update(Trek obj) {
		Trek savedObj = repo.findById(obj.getTrekid()).get();
		savedObj.setBlog(obj.getBlog());
		savedObj.setImage(obj.getImage());
		savedObj.setLocation(obj.getLocation());
		savedObj.setReviews(obj.getReviews());
		savedObj.setTags(obj.getTags());
		repo.save(savedObj);
		
	}

	@Override
	public Integer delete(Integer id) {
		repo.deleteById(id);
		return id;
	}

	@Override
	public Trek get(Integer id) {
		return repo.findById(id).get();
	}

	@Override
	public List<Trek> getAll() {
		return repo.findAll();
	}
	

}
