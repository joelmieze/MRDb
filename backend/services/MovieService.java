package com.app.mrdb.services;

import java.util.List;

import com.app.mrdb.models.Movie;

public interface MovieService {

	public List<Movie> getInfoMovie(String imdbid);
}
