package com.trek.easy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		repo.save(obj);
		
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
