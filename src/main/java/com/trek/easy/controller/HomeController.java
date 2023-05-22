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

import com.trek.easy.model.Activity;
import com.trek.easy.model.Hotel;
import com.trek.easy.model.Orders;
import com.trek.easy.model.Review;
import com.trek.easy.model.Trek;
import com.trek.easy.model.Users;
import com.trek.easy.service.ActivityService;
import com.trek.easy.service.HotelService;
import com.trek.easy.service.OrdersService;
import com.trek.easy.service.ReviewService;
import com.trek.easy.service.TrekService;
import com.trek.easy.service.UsersService;

@RestController
@RequestMapping(value = "/home")
public class HomeController {
	@Autowired
	HotelService hotelService;

	@Autowired
	TrekService trekService;
	
	@Autowired
	ReviewService reviewService;
	
	@Autowired
	ActivityService activityService;
	
	@Autowired
	UsersService userService;
	
	@Autowired
	OrdersService orderService;

	@GetMapping("/get/hotel/{trekid}")
	public List<Hotel> getHotelForATrek(@PathVariable Integer trekid) {
		Trek trek = trekService.get(trekid);
		String location = "";
		if (trek != null)
			location = trek.getLocation();
		return hotelService.findHotelsByLocation(location);
	}
	
	@GetMapping("/get/activity/{trekid}")
	public List<Activity> getActivityForATrek(@PathVariable Integer trekid) {
		Trek trek = trekService.get(trekid);
		String location = "";
		if (trek != null)
			location = trek.getLocation();
		return activityService.findActivitiesByLocation(location);
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
	
	@PostMapping("/order/{userid}")
	public int addOrderForTrek(@PathVariable Integer userid, @RequestBody Orders order) {
		Users user = userService.get(userid);
		if (user != null) {
			order.setUser(user);
			List<Orders> orders = user.getOrders();
			if(orders == null)
				orders = new ArrayList<Orders>();
			orders.add(order);
			orderService.add(order);
			userService.update(user);
			return 200;
		}
		return 400;
	}
	
	@GetMapping("/get/orders/{userid}")
	public List<Orders> getAllOrders(@PathVariable Integer userid) {
		Users user = userService.get(userid);
		return user.getOrders();
	}

}
