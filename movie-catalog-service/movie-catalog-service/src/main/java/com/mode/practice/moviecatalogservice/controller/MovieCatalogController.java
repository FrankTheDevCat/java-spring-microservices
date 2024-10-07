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
import org.springframework.web.reactive.function.client.WebClient;

import com.mode.practice.moviecatalogservice.model.CatalogItem;
import com.mode.practice.moviecatalogservice.model.Movie;
import com.mode.practice.moviecatalogservice.model.Rating;
import com.mode.practice.moviecatalogservice.model.UserRating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	WebClient.Builder builder;

	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public List<CatalogItem> getCatalog(@PathVariable String userId) {

		UserRating ratingList = restTemplate.getForObject("http://rating-data-service/ratings/users/" + userId, UserRating.class);

		return ratingList.getUserRating().stream().map(ratings -> {
			Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + ratings.getMovieId(),
					Movie.class);
//			
//			Movie movie = builder.build()
//				.get()
//				.uri("http://localhost:8060/movies/" + ratings.getMovieId())
//				.retrieve()
//				.bodyToMono(Movie.class)
//				.block();
//			
			Rating rating = restTemplate.getForObject("http://rating-data-service/ratings/" + ratings.getMovieId(),
					Rating.class);
			
//			Rating rating = builder.build()
//					.get()
//					.uri("http://localhost:8070/ratings/" + ratings.getMovieId())
//					.retrieve()
//					.bodyToMono(Rating.class)
//					.block();
			
			return new CatalogItem(movie.getName(), movie.getDesc(), rating.getRate());
		}).collect(Collectors.toList());
	}

}
