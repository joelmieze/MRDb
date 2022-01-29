package com.app.mrdb.dao.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReponseSearchAPIEntity {

	@JsonProperty(value = "Search")
	private List<SearchEntity> search;

	public List<SearchEntity> getSearch() {
		return search;
	}

	public void setSearch(List<SearchEntity> search) {
		this.search = search;
	}
}
