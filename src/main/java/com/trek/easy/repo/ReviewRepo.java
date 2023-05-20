package com.trek.easy.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trek.easy.model.Review;

public interface ReviewRepo extends JpaRepository<Review, Integer>{

}
