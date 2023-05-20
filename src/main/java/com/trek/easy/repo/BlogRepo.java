package com.trek.easy.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trek.easy.model.Blog;

public interface BlogRepo extends JpaRepository<Blog, Integer>{

}
