package com.app.mrdb.services.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.mrdb.dao.RapidAPIDAO;
import com.app.mrdb.dao.entity.ReponseSearchAPIEntity;
import com.app.mrdb.dao.entity.SearchEntity;
import com.app.mrdb.models.Search;
import com.app.mrdb.services.SearchService;

@Service
public class SearchServiceImpl implements SearchService {

	@Autowired
	public RapidAPIDAO rapidAPIDAO;

	@Override
	public List<Search> getListSearch(String search) {
		ReponseSearchAPIEntity reponse = rapidAPIDAO.getListeSearch(search);
		return transformEntityToModel(reponse);
	}

	private List<Search> transformEntityToModel(ReponseSearchAPIEntity reponse) {

		try {

			List<Search> resultat = new ArrayList<Search>();

			ArrayList<String> movies = new ArrayList<String>();

			for (SearchEntity search : reponse.getSearch()) {

				if (!movies.contains(search.getImdbID())
						&& (search.getType().equals("movie") || search.getType().equals("series"))) {

					movies.add(search.getImdbID());

					Search movie = new Search();
					movie.setTitle(search.getTitle());
					movie.setYear(search.getYear());
					movie.setImdbid(search.getImdbID());
					movie.setType(search.getType());
					movie.setPoster(search.getPoster());
					resultat.add(movie);

				}
			}

			Collections.sort(resultat, Comparator.comparing(Search::getYear).reversed());

			return resultat;

		} catch (Exception e) {
			return null;
		}
	}

}
