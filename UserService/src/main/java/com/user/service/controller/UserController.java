package com.user.service.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.service.entity.User;
import com.user.service.service.UserService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private Logger logger = LoggerFactory.getLogger(UserController.class);

	//create
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user){
		User user1= userService.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(user1);
	}

	int retryCount =1;
	//singleUser
	@GetMapping("/{userId}")
	@CircuitBreaker(name="ratingHotelBreaker", fallbackMethod="ratingHotelFallback")
	//@Retry(name="ratingHotelService", fallbackMethod="ratingHotelFallback")
	//@RateLimiter(name="userRateLimiter", fallbackMethod="ratingHotelFallback")
	public ResponseEntity<User> getSingleUser(@PathVariable String userId){
		logger.info("Get single user handler: UserController");
		logger.info("Retrycount: {}", retryCount);
		retryCount++;
		User user= userService.getUser(userId);
		return ResponseEntity.ok(user);
	}

	
	//creating fallback method for circuitBreaker
	//fallback() n main() means uper walika return type same hona chahiye and parameters bhi
	
	  public ResponseEntity<User> ratingHotelFallback(String userId, Exception ex){
		//logger.info("fallback is executed because service id down", ex.getMessage());
		User user = User.builder()
			  .email("dummy@gmail.com")
			  .name("Dummy")
			  .about("This users is created dummy bz some service is down")
	          .userID("123445")
	          .build(); 
	  return new ResponseEntity<>(user, HttpStatus.OK);
	  }
	 
	
	//all user get

	@GetMapping()
	public ResponseEntity<List<User>> getAllUser(){
		List<User> allUser= userService.getAllUser();
		return ResponseEntity.ok(allUser);
	}

	//delete user by id
	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable String userId){
		userService.deleteUser(userId);;
		ResponseEntity<String> response =ResponseEntity.ok("User "+userId+" deleted...!");
		return response;
	}

	
	//update User
	@PutMapping("/modify")
	public ResponseEntity<String> updateUser(@RequestBody User user){
		userService.updateUser(user);
		ResponseEntity<String> response  = ResponseEntity.ok("User "+user.getUserID()+" updated...!");
		return response;
	}
	}
