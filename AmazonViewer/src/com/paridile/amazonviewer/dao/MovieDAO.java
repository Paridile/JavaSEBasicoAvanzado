package com.paridile.amazonviewer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.paridile.amazonviewer.db.IDBConnection;
import com.paridile.amazonviewer.model.Movie;
import static com.paridile.amazonviewer.db.Database.*;

public interface MovieDAO extends IDBConnection{	
	
	default Movie setMovieViewed(Movie movie) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateFormatted = sdf.format(new Date());
		try (Connection connection = connectToDB()) {
			Statement statement = connection.createStatement();
			String query = "INSERT INTO " + VIEWED + "( " 
					+ VIEWED_ID_MATERIAL + ", " + 
					VIEWED_ID_ELEMENT + ", " +
					VIEWED_ID_USER + ", "
					+ VIEWED_DATETIME +
					" )" + " VALUES(" + MATERIAL_ID[0]
					+ ", " + movie.getId() + ", " + USER_ID + ",'" + dateFormatted +  "')";			
			if (statement.executeUpdate(query) > 0) {
				System.out.println("Se marcó en visto");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
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
				PreparedStatement ps;
				String movieViewed = getMovieViewed(preparedStatement, connection, Integer.valueOf(rs.getString(MOVIE_ID)));				
				movie.setViewed(movieViewed.length() > 0);				
				movie.setDateViewed(movieViewed);
				movies.add(movie);
			}
			
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return movies;
	} 
	
	private String getMovieViewed( PreparedStatement preparedStatement, Connection connection, int id_movie) {
		String date="";
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
			while(rs.next()) {
				date = rs.getString(VIEWED_DATETIME);
			}		
			
		}catch (Exception e) {
			e.printStackTrace();
		}		
		return date;
	}
	
}
