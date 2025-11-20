package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Hotel;

public interface HotelService {

	//create
	Hotel create(Hotel hotel);
	
	//getall
	List<Hotel> getAll();
	
	//getSingle
	Hotel get(String id);
}
