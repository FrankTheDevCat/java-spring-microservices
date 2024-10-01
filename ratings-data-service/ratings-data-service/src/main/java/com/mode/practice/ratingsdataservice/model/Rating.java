package com.mode.practice.ratingsdataservice.model;

public class Rating {
	
	private String movieId;
	private int rate;
	
	public Rating() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Rating(String movieId, int rate) {
		super();
		this.movieId = movieId;
		this.rate = rate;
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}
	
	
}
