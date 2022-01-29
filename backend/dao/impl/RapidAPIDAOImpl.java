package com.app.mrdb.dao.impl;

import com.app.mrdb.dao.RapidAPIDAO;
import com.app.mrdb.dao.entity.ReponseMovieAPIEntity;
import com.app.mrdb.dao.entity.ReponseSearchAPIEntity;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class RapidAPIDAOImpl implements RapidAPIDAO {

	private static final String URL_API_MOVIE_DATABASE = "";// TODO
	private static final String RAPIDAPI_KEY = "";// TODO

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public ReponseSearchAPIEntity getListeSearch(String search) {

		HttpHeaders headers = new HttpHeaders();

		headers.set("x-rapidapi-host", URL_API_MOVIE_DATABASE);
		headers.set("x-rapidapi-key", RAPIDAPI_KEY);

		HttpEntity<String> request = new HttpEntity<String>(headers);

		StringBuilder builder = new StringBuilder("https://" + URL_API_MOVIE_DATABASE);
		builder.append("?r=json");
		try {
			builder.append("&s=" + URLEncoder.encode(search, StandardCharsets.UTF_8.toString()));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		URI uri = URI.create(builder.toString());

		ResponseEntity<ReponseSearchAPIEntity> response = restTemplate.exchange(uri, HttpMethod.GET, request,
				ReponseSearchAPIEntity.class);

		return response.getBody();
	}

	@Override
	public ReponseMovieAPIEntity getInfoMovie(String imdbid) {

		HttpHeaders headers = new HttpHeaders();

		headers.set("x-rapidapi-host", URL_API_MOVIE_DATABASE);
		headers.set("x-rapidapi-key", RAPIDAPI_KEY);

		HttpEntity<String> request = new HttpEntity<String>(headers);

		StringBuilder builder = new StringBuilder("https://" + URL_API_MOVIE_DATABASE);
		builder.append("?r=json");
		builder.append("&i=" + imdbid);
		URI uri = URI.create(builder.toString());

		ResponseEntity<ReponseMovieAPIEntity> response = restTemplate.exchange(uri, HttpMethod.GET, request,
				ReponseMovieAPIEntity.class);

		return response.getBody();
	}

}
