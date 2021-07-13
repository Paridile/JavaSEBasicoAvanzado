package com.paridile.amazonviewer.db;

public class Database {
	public static final String URL = "jdbc:mysql://localhost:3306/";
	public static final String TIME_ZONE = "?serverTimezone=UTC";
	public static final String DB = "amazonviewer";
	public static final String USER = "amazonviewer";
	public static final String PASSWORD = "amazonviewer";
	
	public static final String MOVIE = "movie";
	public static final String MOVIE_ID = "id";
	public static final String MOVIE_TITLE = "title";
	public static final String MOVIE_GENRE = "genre";
	public static final String MOVIE_CREATOR = "creator";
	public static final String MOVIE_DURATION = "duration";
	public static final String MOVIE_YEAR = "year";
	
	public static final String MATERIAL = "material";
	public static final int MATERIAL_ID[] = {1,2,3,4};
	public static final String MATERIAL_NAME = "name";
		
	public static final String TUSER = "user";
	public static final int USER_ID = 1;
	public static final String USER_NAME = "name";
	
	public static final String VIEWED = "viewed";
	public static final String VIEWED_ID = "id";
	public static final String VIEWED_ID_MATERIAL = "id_material";
	public static final String VIEWED_ID_ELEMENT = "id_element";
	public static final String VIEWED_ID_USER = "id_user";
		 
	
}
