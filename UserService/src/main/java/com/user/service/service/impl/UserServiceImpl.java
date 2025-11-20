package com.user.service.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.user.service.entity.Hotel;
import com.user.service.entity.Rating;
import com.user.service.entity.User;
import com.user.service.exception.ResourceNotFoundException;
import com.user.service.external.services.HotelService;
import com.user.service.repository.UserRepository;
import com.user.service.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private HotelService hotelService;

	//@Autowired
	//private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public User saveUser(User user) {

		// generate unique userId
		String randomUserId = UUID.randomUUID().toString();
		user.setUserID(randomUserId);
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {

		ArrayList<Rating> ratingsOfUser = restTemplate.getForObject("http://localhost:8083/ratings", ArrayList.class);
		return userRepository.findAll();
	}

	@Override
	public User getUser(String userId) {
		
		// get user from DB with the help of user repo
		User user = userRepository.findById(userId).orElseThrow(
				() -> new ResourceNotFoundException("User with given id is not found on server  " + userId));

		// fetch rating of the above user from Rating service
		// http://localhost:8083/ratings/users/301fb7b8-85ab-4feb-8f30-4cc1e1028d83
       Rating[] ratingsOfUser = restTemplate
				.getForObject("http://localhost:8083/ratings/users/" + user.getUserID(), Rating[].class);
		// logger.info("{}", ratingsOfUser);
       
		List<Rating> ratings= Arrays.stream(ratingsOfUser).toList();

		List<Rating> ratingList = ratings.stream().map(rating -> {
			
			// api call to hotel service to get the hotel
			// http://localhost:8082/hotels/5fa2f427-ee97-4918-9190-15a50b581576
			
			//With help of restTemplate -- Surbhi
			/*
			 * ResponseEntity<Hotel> forEntity = restTemplate
			 * .getForEntity("http://HOTELSERVICE/hotels/" + rating.getHotelId(),
			 * Hotel.class); Hotel hotel = forEntity.getBody();
			 */
			
			
			//with help of FeignClient-- Surbhi
			Hotel hotel=hotelService.getHotel(rating.getHotelId());
			
			//logger.info("response status code : {} ", forEntity.getStatusCode());

			// see the hotel to rating
			rating.setHotel(hotel);

			// return the rating
			return rating;
		})
				.collect(Collectors.toList());

		user.setRatings(ratingList);
		return user;
	}

	@Override
	public void deleteUser(String userID) {
		userRepository.deleteById(userID);
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		// return null;
	}

}
