package com.app.mrdb.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.mrdb.dao.RapidAPIDAO;
import com.app.mrdb.dao.entity.RatingEntity;
import com.app.mrdb.dao.entity.ReponseMovieAPIEntity;
import com.app.mrdb.models.Movie;
import com.app.mrdb.services.MovieService;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	public RapidAPIDAO rapidAPIDAO;

	@Override
	public List<Movie> getInfoMovie(String imdbid) {
		ReponseMovieAPIEntity reponse = rapidAPIDAO.getInfoMovie(imdbid);
		return transformEntityToModel(reponse);
	}

	private List<Movie> transformEntityToModel(ReponseMovieAPIEntity reponse) {

		try {

			List<Movie> resultat = new ArrayList<Movie>();

			Movie movie = new Movie();

			movie.setTitle(reponse.getTitle());
			movie.setYear(reponse.getYear());
			movie.setRated(reponse.getRated());
			movie.setReleased(reponse.getReleased());
			movie.setRuntime(reponse.getRuntime());
			movie.setGenre(reponse.getGenre());
			movie.setDirector(reponse.getDirector());
			movie.setWriter(reponse.getWriter());
			movie.setActors(reponse.getActors());
			movie.setPlot(reponse.getPlot());
			movie.setCountry(reponse.getCountry());
			movie.setAwards(reponse.getAwards());
			movie.setPoster(reponse.getPoster());
			movie.setMetascore(reponse.getMetascore());
			movie.setImdbID(reponse.getImdbID());
			movie.setImdbRating(reponse.getImdbRating());
			movie.setImdbVotes(reponse.getImdbVotes());
			movie.setType(reponse.getType());

			for (RatingEntity rating : reponse.getRatings()) {
				switch (rating.getSource()) {
				case "Rotten Tomatoes": {
					movie.setRottenTomatoes(rating.getValue());
				}
				case "Metacritic": {
					movie.setMetacritic(rating.getValue());
				}
				}
			}

			resultat.add(movie);

			return resultat;

		} catch (Exception e) {
			return null;
		}
	}
}
