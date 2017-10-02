package com.design.ipod;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Playlist implements MediaPlayer{
	private String playlistName;
	private List<Song> songsList;
	private int currentIndex;
	private boolean shuffle;
	private Random random = new Random();
	
	public Playlist(String playlistName) {
		this.playlistName = playlistName;
		this.songsList = new ArrayList<>();
		this.currentIndex = -1;
		this.shuffle = false;
	}

	public Playlist(String playlistName, List<Song> songsList) {
		this.playlistName = playlistName;
		this.songsList = songsList;
		this.currentIndex = 0;
		this.shuffle = false;
	}
	
	public String getPlaylistName() {
		return playlistName;
	}

	public void setPlaylistName(String playlistName) {
		this.playlistName = playlistName;
	}

	public Song getSong(int songIndex) {
		//when user clicks on particular song
		this.currentIndex = songIndex;
		return songsList.get(songIndex);
	}
	
	public Song getNextSong() {
		if(songsList.size() == 0) {
			return null;
		}
		if(shuffle) {
			int newSongIndex = random.nextInt(songsList.size());
			//until new and old songs are not the same we need to generate random songs
			while(currentIndex == newSongIndex ){
				newSongIndex = random.nextInt(songsList.size());
			}
			this.currentIndex = newSongIndex;
			return songsList.get(newSongIndex);
		} else {
			if(currentIndex == (songsList.size() - 1)) {
				this.currentIndex = -1;
			}
			return songsList.get(++currentIndex);
		}	
	}
	
	public Song getPreviousSong() {
		if(songsList.size() == 0) {
			return null;
		}
		if(shuffle) {
			int newSongIndex = random.nextInt(songsList.size());
			//until new and old songs are the same we need to generate random songs
			while(currentIndex == newSongIndex ){
				newSongIndex = random.nextInt(songsList.size());
			}
			this.currentIndex = newSongIndex;
			return songsList.get(newSongIndex);
		} else {
			if(currentIndex == 0) {
				this.currentIndex = songsList.size();
			}
			return songsList.get(--currentIndex);
		}
	}
	
	public void addSong(Song song) {
		songsList.add(song);
	}
	
	public void removeSong(int songIndex) {
		if(songsList.size() != 0) {
			songsList.remove(songIndex);
		}
	}

	public boolean isShuffle() {
		return shuffle;
	}

	public void setShuffle(boolean shuffle) {
		this.shuffle = shuffle;
	}
}
