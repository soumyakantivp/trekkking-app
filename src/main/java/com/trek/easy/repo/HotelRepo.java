package com.trek.easy.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trek.easy.model.Hotel;

public interface HotelRepo extends JpaRepository<Hotel, Integer>{

	List<Hotel> findHotelByLocation(String location);

}
