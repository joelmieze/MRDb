package com.app.mrdb.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.mrdb.models.Search;
import com.app.mrdb.services.SearchService;

@RestController
public class SearchController {

	@Autowired
	private SearchService searchService;

	// @CrossOrigin("http://localhost:4200")
	@RequestMapping(path = "/api/search", method = RequestMethod.POST)
	public List<Search> getListeSearch(@RequestParam("search") String search) {
		return searchService.getListSearch(search);
	}

}
