package com.trek.easy.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trek.easy.model.Activity;

public interface ActivityRepo extends JpaRepository<Activity, Integer>{

	List<Activity> findActivityByLocation(String location);

}
