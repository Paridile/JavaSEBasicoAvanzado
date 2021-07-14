package com.paridile.amazonviewer.model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * <h1>Film</h1>
 * Film es una clase padre abstracta
 * <p>
 * Esta clase es la base de la familia films, como es 
 * abstracta, no pueden crearse instancias. Contiene el método abstracto
 * {@code view()} que es obligatorio implementar para todo
 * aquel que pertenezca a su familia
 * 
 * @author pablo
 * @version 1.1
 * @since 2021
 * */

public abstract class Film {
	
	private String title;
	private String genre;
	private String creator;
	private int duration;
	private short year;
	private boolean viewed;
	private String dateViewed;
	
	
	
	public Film(String title, String genre, String creator, int duration) {
		super();
		this.title = title;
		this.genre = genre;
		this.creator = creator;
		this.duration = duration;
	}
	
	public Film() {
		
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public short getYear() {
		return year;
	}
	public void setYear(short year) {
		this.year = year;
	}
	public String isViewed() {
		String visto = "";
		if(viewed == true) {
			visto = "Sí";
		}else {
			visto = "No";
		}
		
		return visto;
	}
	
	public boolean getIsViewed() {
		return viewed;
	}
	public void setViewed(boolean viewed) {
		this.viewed = viewed;
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
	 * <h2>view</h2>
	 * {@code
	 * 	view()
	 * }
	 * es un metodo abstracto obligatorio de implementae
	 * */
	public abstract void view();
	
	
	

}
