package com.trek.easy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trek.easy.model.Activity;
import com.trek.easy.model.Review;
import com.trek.easy.repo.ReviewRepo;
@Service
public class ReviewService implements ServiceCRUD<Review, Integer>{

	@Autowired
	ReviewRepo repo;
	
	@Override
	public void add(Review obj) {
		repo.save(obj);
	}

	@Override
	public void update(Review obj) {
		Review savedObj = repo.findById(obj.getRevid()).get();
		savedObj.setActivity(obj.getActivity());
		savedObj.setDesc(obj.getDesc());
		savedObj.setHotel(obj.getHotel());
		savedObj.setTrek(obj.getTrek());
		savedObj.setUser(obj.getUser());
		savedObj.setLinks(obj.getLinks());
		savedObj.setRating(obj.getRating());
		repo.save(savedObj);
		
	}

	@Override
	public Integer delete(Integer id) {
		repo.deleteById(id);
		return id;
	}

	@Override
	public Review get(Integer id) {
		return repo.findById(id).get();
	}

	@Override
	public List<Review> getAll() {
		return repo.findAll();
	}
	

}
