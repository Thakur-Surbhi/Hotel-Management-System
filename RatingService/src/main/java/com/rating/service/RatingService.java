package com.rating.service;

import java.util.List;

import com.rating.entity.Rating;

public interface RatingService {
	
	//create
	Rating create(Rating rating);
	
	List<Rating> getRating();
	
	//get all by userId
	List<Rating> getRatingByUserId(String userId);
	
	//get all by hotel
	List<Rating> getRatingByHotelId(String hotelId);

}
