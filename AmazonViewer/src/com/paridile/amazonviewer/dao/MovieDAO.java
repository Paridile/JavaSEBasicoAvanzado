package com.paridile.amazonviewer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.paridile.amazonviewer.db.IDBConnection;
import com.paridile.amazonviewer.model.Movie;
import static com.paridile.amazonviewer.db.Database.*;

public interface MovieDAO extends IDBConnection{	
	
	default Movie setMovieViewed(Movie movie) {
		return movie;
	} 
	
	default ArrayList<Movie> read() {
		ArrayList<Movie> movies = new ArrayList<>();
		try(Connection connection = connectToDB()) {
			final String QUERY = "SELECT * FROM " + MOVIE;
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				Movie movie= new Movie(rs.getString(MOVIE_TITLE), rs.getString(MOVIE_GENRE), rs.getString(MOVIE_CREATOR), Integer.valueOf(rs.getString(MOVIE_DURATION)), Short.valueOf(rs.getShort(MOVIE_YEAR)));
				movie.setId(Integer.valueOf(rs.getString(MOVIE_ID)));
				movie.setViewed(getMovieViewed(preparedStatement, connection,Integer.valueOf(rs.getString(MOVIE_ID))));
				movies.add(movie);
			}
			
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return movies;
	} 
	
	private boolean getMovieViewed( PreparedStatement preparedStatement, Connection connection, int id_movie) {
		boolean viewed = false;
		final String QUERY = "SELECT * FROM " + VIEWED + 
				" WHERE " + VIEWED_ID_MATERIAL + " =  ? AND "
				+ VIEWED_ID_ELEMENT + " = ?" + 
				" AND " + VIEWED_ID_USER + " = ?";
		ResultSet rs = null;
		try {
			preparedStatement = connection.prepareStatement(QUERY);
			preparedStatement.setInt(1, MATERIAL_ID[0]);
			preparedStatement.setInt(2, id_movie);
			preparedStatement.setInt(3, USER_ID);
			rs = preparedStatement.executeQuery();
			viewed = rs.next();
			
		}catch (Exception e) {
			e.printStackTrace();
		}		
		return viewed;
	}
	
}
