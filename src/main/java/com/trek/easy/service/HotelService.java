package com.trek.easy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trek.easy.model.Activity;
import com.trek.easy.model.Hotel;
import com.trek.easy.repo.HotelRepo;
@Service
public class HotelService implements ServiceCRUD<Hotel, Integer>{

	@Autowired
	HotelRepo repo;
	
	@Override
	public void add(Hotel obj) {
		repo.save(obj);
	}

	@Override
	public void update(Hotel obj) {
		Hotel savedObj = repo.findById(obj.getHotelid()).get();
		savedObj.setBlog(obj.getBlog());
		savedObj.setImage(obj.getImage());
		savedObj.setLocation(obj.getLocation());
		savedObj.setName(obj.getName());
		savedObj.setPrice(obj.getPrice());
		savedObj.setReviews(obj.getReviews());
		
		repo.save(savedObj);
		
	}

	@Override
	public Integer delete(Integer id) {
		repo.deleteById(id);
		return id;
	}

	@Override
	public Hotel get(Integer id) {
		return repo.findById(id).get();
	}

	@Override
	public List<Hotel> getAll() {
		return repo.findAll();
	}
	

}
