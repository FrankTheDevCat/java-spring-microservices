package com.mode.practice.moviecatalogservice.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mode.practice.moviecatalogservice.model.CatalogItem;
import com.mode.practice.moviecatalogservice.model.Movie;
import com.mode.practice.moviecatalogservice.model.Rating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {
	
	@Autowired
	RestTemplate restTemplate;

	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public List<CatalogItem> getCatalog(@PathVariable String userId) {

		

		List<Rating> ratingList = Arrays.asList(new Rating("1234", 4), new Rating("5678", 8));

		return ratingList.stream().map(ratings -> {
			Movie movie = restTemplate.getForObject("http://localhost:8060/movies/" + ratings.getMovieId(),
					Movie.class);
			Rating rating = restTemplate.getForObject("http://localhost:8070/ratings/" + ratings.getMovieId(),
					Rating.class);
			return new CatalogItem(movie.getName(), movie.getDesc(), rating.getRate());
		}).collect(Collectors.toList());
	}

}
