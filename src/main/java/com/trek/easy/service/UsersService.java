package com.trek.easy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trek.easy.model.Users;
import com.trek.easy.repo.UsersRepo;
@Service
public class UsersService implements ServiceCRUD<Users, Integer>{

	@Autowired
	UsersRepo repo;
	
	@Override
	public void add(Users obj) {
		repo.save(obj);
	}

	@Override
	public void update(Users obj) {
		repo.save(obj);
		
	}

	@Override
	public Integer delete(Integer id) {
		repo.deleteById(id);
		return id;
	}

	@Override
	public Users get(Integer id) {
		return repo.findById(id).get();
	}

	@Override
	public List<Users> getAll() {
		return repo.findAll();
	}
	

}
