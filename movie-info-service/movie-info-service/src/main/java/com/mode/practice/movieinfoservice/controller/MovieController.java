package com.mode.practice.movieinfoservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mode.practice.movieinfoservice.model.Movie;

@RestController
@RequestMapping("/movies")
public class MovieController {
	
	@RequestMapping(value="/{movieId}", method=RequestMethod.GET)
	public Movie getMovie(String movieId) {
		return new Movie("1234", "Title Movie", "Description of the Movie");
	}

}
