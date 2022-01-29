package com.app.mrdb.dao.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReponseMovieAPIEntity {

	@JsonProperty(value = "Title")
	private String Title;

	@JsonProperty(value = "Year")
	private String Year;

	@JsonProperty(value = "Rated")
	private String Rated;

	@JsonProperty(value = "Released")
	private String Released;

	@JsonProperty(value = "Runtime")
	private String Runtime;

	@JsonProperty(value = "Genre")
	private String Genre;

	@JsonProperty(value = "Director")
	private String Director;

	@JsonProperty(value = "Writer")
	private String Writer;

	@JsonProperty(value = "Actors")
	private String Actors;

	@JsonProperty(value = "Plot")
	private String Plot;

	@JsonProperty(value = "Country")
	private String Country;

	@JsonProperty(value = "Awards")
	private String Awards;

	@JsonProperty(value = "Poster")
	private String Poster;

	@JsonProperty(value = "Metascore")
	private String Metascore;

	@JsonProperty(value = "imdbID")
	private String imdbID;

	@JsonProperty(value = "imdbRating")
	private String imdbRating;

	@JsonProperty(value = "imdbVotes")
	private String imdbVotes;

	@JsonProperty(value = "Type")
	private String Type;

	@JsonProperty(value = "Ratings")
	private List<RatingEntity> ratings;

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getYear() {
		return Year;
	}

	public void setYear(String year) {
		Year = year;
	}

	public String getRated() {
		return Rated;
	}

	public void setRated(String rated) {
		Rated = rated;
	}

	public String getReleased() {
		return Released;
	}

	public void setReleased(String released) {
		Released = released;
	}

	public String getRuntime() {
		return Runtime;
	}

	public void setRuntime(String runtime) {
		Runtime = runtime;
	}

	public String getGenre() {
		return Genre;
	}

	public void setGenre(String genre) {
		Genre = genre;
	}

	public String getDirector() {
		return Director;
	}

	public void setDirector(String director) {
		Director = director;
	}

	public String getWriter() {
		return Writer;
	}

	public void setWriter(String writer) {
		Writer = writer;
	}

	public String getActors() {
		return Actors;
	}

	public void setActors(String actors) {
		Actors = actors;
	}

	public String getPlot() {
		return Plot;
	}

	public void setPlot(String plot) {
		Plot = plot;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public String getAwards() {
		return Awards;
	}

	public void setAwards(String awards) {
		Awards = awards;
	}

	public String getPoster() {
		return Poster;
	}

	public void setPoster(String poster) {
		Poster = poster;
	}

	public String getMetascore() {
		return Metascore;
	}

	public void setMetascore(String metascore) {
		Metascore = metascore;
	}

	public String getImdbID() {
		return imdbID;
	}

	public void setImdbID(String imdbID) {
		this.imdbID = imdbID;
	}

	public String getImdbRating() {
		return imdbRating;
	}

	public void setImdbRating(String imdbRating) {
		this.imdbRating = imdbRating;
	}

	public String getImdbVotes() {
		return imdbVotes;
	}

	public void setImdbVotes(String imdbVotes) {
		this.imdbVotes = imdbVotes;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public List<RatingEntity> getRatings() {
		return ratings;
	}

	public void setRatings(List<RatingEntity> ratings) {
		this.ratings = ratings;
	}

}
