package com.trek.easy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trek.easy.model.Blog;
import com.trek.easy.repo.BlogRepo;
@Service
public class BlogService implements ServiceCRUD<Blog, Integer>{

	@Autowired
	BlogRepo repo;
	
	@Override
	public void add(Blog obj) {
		repo.save(obj);
	}

	@Override
	public void update(Blog obj) {
		repo.save(obj);
		
	}

	@Override
	public Integer delete(Integer id) {
		repo.deleteById(id);
		return id;
	}

	@Override
	public Blog get(Integer id) {
		return repo.findById(id).get();
	}

	@Override
	public List<Blog> getAll() {
		return repo.findAll();
	}
	

}
