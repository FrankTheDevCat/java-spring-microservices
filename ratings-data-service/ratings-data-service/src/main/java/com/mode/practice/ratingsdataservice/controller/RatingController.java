package com.mode.practice.ratingsdataservice.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mode.practice.ratingsdataservice.model.Rating;

@RestController
@RequestMapping("/ratings")
public class RatingController {
	
	@RequestMapping(value="/{movieId}", method=RequestMethod.GET)
	public Rating getRating(@PathVariable String movieId) {
		return new Rating("1234", 10);
	}

}
