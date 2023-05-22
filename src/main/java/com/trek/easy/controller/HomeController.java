package com.trek.easy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trek.easy.model.Hotel;
import com.trek.easy.model.Trek;
import com.trek.easy.service.HotelService;
import com.trek.easy.service.TrekService;

@RestController
@RequestMapping(value = "/home")
public class HomeController {
	@Autowired
	HotelService hotelService;
	
	@Autowired
	TrekService trekService;
	
	@GetMapping("/get/hotel/{trekid}")
	public List<Hotel> getHotelForATrek(@PathVariable Integer trekid) {
		Trek trek = trekService.get(trekid);
		String location = "";
		if(trek != null)
			location = trek.getLocation();
		return hotelService.findHotelsByLocation(location);
	}
}
