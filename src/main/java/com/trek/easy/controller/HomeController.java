package com.trek.easy.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trek.easy.model.Hotel;
import com.trek.easy.model.Review;
import com.trek.easy.model.Trek;
import com.trek.easy.service.HotelService;
import com.trek.easy.service.ReviewService;
import com.trek.easy.service.TrekService;

@RestController
@RequestMapping(value = "/home")
public class HomeController {
	@Autowired
	HotelService hotelService;

	@Autowired
	TrekService trekService;
	
	@Autowired
	ReviewService reviewService;

	@GetMapping("/get/hotel/{trekid}")
	public List<Hotel> getHotelForATrek(@PathVariable Integer trekid) {
		Trek trek = trekService.get(trekid);
		String location = "";
		if (trek != null)
			location = trek.getLocation();
		return hotelService.findHotelsByLocation(location);
	}

	@PostMapping("/review/trek/{trekid}")
	public int addReviewForATrek(@PathVariable Integer trekid, @RequestBody Review review) {
		Trek trek = trekService.get(trekid);
		if (trek != null) {
			List<Review> reviews = trek.getReviews();
			if (reviews == null)
				reviews = new ArrayList<Review>();
			reviews.add(review);
			trek.setReviews(reviews);
			reviewService.add(review);
			return 200;
		}
		return 400;
	}
	
	@GetMapping("/trek/reviews/{trekid}")
	public List<Review> getAllReviewsForHotel(@PathVariable Integer trekid) {
		Trek trek = trekService.get(trekid);
		return trek.getReviews();
	}

}
