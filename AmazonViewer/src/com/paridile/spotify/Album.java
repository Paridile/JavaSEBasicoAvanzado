package com.paridile.spotify;

import java.util.ArrayList;

public class Album {
	private ArrayList<Song> songs;
			
	public Album() {		
				
	}


	private static class Song {
		protected String title;
		protected String duration;				
	}
}
