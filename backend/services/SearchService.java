package com.app.mrdb.services;

import java.util.List;

import com.app.mrdb.models.Search;

public interface SearchService {

	public List<Search> getListSearch(String search);

}
