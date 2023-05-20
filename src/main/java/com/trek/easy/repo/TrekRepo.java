package com.trek.easy.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trek.easy.model.Trek;

public interface TrekRepo extends JpaRepository<Trek, Integer>{

}
