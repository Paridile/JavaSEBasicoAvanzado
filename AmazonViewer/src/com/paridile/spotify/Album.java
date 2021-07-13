package com.paridile.spotify;

import java.util.ArrayList;

public class Album {
	private ArrayList<Song> songs;
			
	public Album() {		
				
	}


	public ArrayList<Song> getSongs() {
		return songs;
	}


	public void setSongs(ArrayList<Song> songs) {
		this.songs = songs;
	}


	private static class Song {
		protected String title;
		protected String duration;
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getDuration() {
			return duration;
		}
		public void setDuration(String duration) {
			this.duration = duration;
		}
		
	}
	
	
}
