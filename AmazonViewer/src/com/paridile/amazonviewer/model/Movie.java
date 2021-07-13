package com.paridile.amazonviewer.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.paridile.amazonviewer.dao.MovieDAO;

/**
 * Hereda de {@link Film}
 * Implementa de {@link IVisualizable}
 * 
 * */

public class Movie extends Film implements IVisualizable,MovieDAO {
	
	private int id;
	private int timeViewed;
	private String dateViewed;
	
	
	public Movie(String title, String genre, String creator, int duration, short year) {
		super(title, genre, creator, duration);
		setYear(year);
	}

	public Movie() {
		
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	
	public int getTimeViewed() {
		return timeViewed;
	}
	public void setTimeViewed(int timeViewed) {
		this.timeViewed = timeViewed;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return  "\n :: MOVIE ::" + 
				"\n Title: " + getTitle() +
				"\n Genero: " + getGenre() + 
				"\n Year: " + getYear() + 
				"\n Creator: " + getCreator() +
				"\n Duration: " + getDuration() + 
				"\n Watched: " + getDateViewed();
	}
	
	
	public String getDateViewed() {		
		if( dateViewed.length() == 0 && this.getIsViewed() == true) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			dateViewed = sdf.format(new Date());
		}
		return dateViewed;
	}

	public void setDateViewed(String dateViewed) {
		this.dateViewed = dateViewed;
	}

	/**
	 * {@inheritDoc} 
	 * */
	@Override
	public Date startToSee(Date dateI) {
		// TODO Auto-generated method stub
		return dateI;
	}
	/**
	 * {@inheritDoc} 
	 * */
	@Override
	public void stopToSee(Date dateI, Date dateF) {
		// TODO Auto-generated method stub
		
		if (dateF.getTime() > dateI.getTime()) {
			setTimeViewed((int)(dateF.getTime() - dateI.getTime()));
		}else {
			setTimeViewed(0);
		}
		
		
	}
	
	public static ArrayList<Movie> makeMoviesList() {				
		Movie movie = new Movie();		
		return movie.read();
	}

	
	/**
	 * {@inheritDoc} 
	 * */
	@Override
	public void view() {
		startToSee(new Date());		
		Movie movie = new Movie();
		setViewed(true);
				
		movie.setMovieViewed(this);
		
		Date dateI = startToSee(new Date());
		
		for (int i = 0; i < 100000; i++) {
			System.out.println("..........");
		}
		
		//Termine de verla
		stopToSee(dateI, new Date());
		System.out.println();
		System.out.println("Viste: " + toString());
		System.out.println("Por: " + getTimeViewed() + " milisegundos");
		
	}
	
}







