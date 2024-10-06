package com.mode.practice.ratingsdataservice.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mode.practice.ratingsdataservice.model.Rating;
import com.mode.practice.ratingsdataservice.model.UserRating;

@RestController
@RequestMapping("/ratings")
public class RatingController {
	
	@RequestMapping(value="/{movieId}", method=RequestMethod.GET)
	public Rating getRating(@PathVariable String movieId) {
		return new Rating("1234", 10);
	}
	
	@RequestMapping(value="/users/{userId}", method=RequestMethod.GET)
	public UserRating getUserRating(@PathVariable String userId) {
		List<Rating> ratingList = Arrays.asList(new Rating("1234", 4), new Rating("5678", 8));
		UserRating userRating = new UserRating();
		userRating.setUserRating(ratingList);
		return userRating;
	}

}
