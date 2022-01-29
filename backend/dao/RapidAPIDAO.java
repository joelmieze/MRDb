package com.app.mrdb.dao;

import com.app.mrdb.dao.entity.ReponseMovieAPIEntity;
import com.app.mrdb.dao.entity.ReponseSearchAPIEntity;

public interface RapidAPIDAO {

	public ReponseSearchAPIEntity getListeSearch(String search);

	public ReponseMovieAPIEntity getInfoMovie(String imdbid);
}
