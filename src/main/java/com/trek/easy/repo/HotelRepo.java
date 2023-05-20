package com.trek.easy.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trek.easy.model.Hotel;

public interface HotelRepo extends JpaRepository<Hotel, Integer>{

}
