package com.trek.easy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trek.easy.model.Orders;
import com.trek.easy.repo.OrderRepo;
@Service
public class OrdersService implements ServiceCRUD<Orders, Integer>{

	@Autowired
	OrderRepo repo;
	
	@Override
	public void add(Orders obj) {
		repo.save(obj);
	}

	@Override
	public void update(Orders obj) {
		repo.save(obj);
		
	}

	@Override
	public Integer delete(Integer id) {
		repo.deleteById(id);
		return id;
	}

	@Override
	public Orders get(Integer id) {
		return repo.findById(id).get();
	}

	@Override
	public List<Orders> getAll() {
		return repo.findAll();
	}
	

}
