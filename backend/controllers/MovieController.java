package com.app.mrdb.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.mrdb.models.Movie;
import com.app.mrdb.services.MovieService;

@RestController
public class MovieController {

	@Autowired
	private MovieService movieService;

	// @CrossOrigin("http://localhost:4200")
	@RequestMapping(path = "/api/movie", method = RequestMethod.POST)
	public List<Movie> getMovie(@RequestParam("imdbid") String imdbid) {
		return movieService.getInfoMovie(imdbid);
	}
}
