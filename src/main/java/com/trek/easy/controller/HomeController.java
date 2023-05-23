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
import com.trek.easy.model.Weather;
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
	
	@GetMapping("/weather")
	public Weather getWeather() {
		String tags[] = {"sunny","overcast","rainy","snow"};
		String images[] = {"https://images.unsplash.com/photo-1533324268742-60b233802eef?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1170&q=80",
				"https://images.unsplash.com/photo-1499956827185-0d63ee78a910?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1170&q=80",
				"https://images.unsplash.com/photo-1433863448220-78aaa064ff47?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1931&q=80",
				"https://images.unsplash.com/photo-1609700930660-8573f28f8e2f?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1170&q=80"};
		double temp = 20 + (Math.random()*20);
		Weather weather = new Weather();
		weather.setTemperature(temp);
		weather.setHumidity(Math.random()*100);
		int rand = (int)(4*Math.random());
		weather.setImage(images[rand]);
		weather.setTag(tags[rand]);
		return weather;
	}

	@GetMapping("/check/order/{userid}/{trekid}")
	public boolean checkIfOrderPresentForUserAndTrek(@PathVariable Integer userid, @PathVariable Integer trekid) {
		Users user = userService.get(userid);
		return user.getOrders().stream().filter(o->o.getTrek()!=null).anyMatch(o->o.getTrek().getTrekid().equals(trekid));

	}
	
	// admin
	@GetMapping("/admin/approve/{orderid}")
	public int approve(@PathVariable Integer orderid) {
		Orders order = orderService.get(orderid);
		if(order == null)
			return 400;
		order.setStatus("approved");
		orderService.update(order);
		return 200;
	}
}
