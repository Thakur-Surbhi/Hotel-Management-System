package com.user.service.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="user_ratings")
public class Rating {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String ratingId;
	private String userId;
	private String hotelId;
	private int rating;
	private String feedback;

	@Transient
	private Hotel hotel;
}
