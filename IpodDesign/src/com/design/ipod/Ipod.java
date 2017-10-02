package com.design.ipod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Ipod implements MediaPlayer{
	private List<Song> songs;
	private List<Playlist> playlists;
	//currentIndex provides the index of currently playing song
	private int currentIndex;
	private boolean shuffle;
	private Random random = new Random();
	
	public Ipod() {
		this.songs = new ArrayList<>();
		this.playlists = new ArrayList<>();
		this.currentIndex = -1;
		this.shuffle = false;
	}

	public Ipod(List<Song> songs) {
		this.songs = songs;
		this.playlists = new ArrayList<>();
		this.currentIndex = 0;
		this.shuffle = false;
	}

	public Song getSong(int mySongIndex) {
		//when user clicks on particular song
		this.currentIndex = mySongIndex;
		return songs.get(mySongIndex);
	}
	
	public void createPlaylist(String playlistName, List<Song> songs) {
		Playlist myPlaylist = new Playlist(playlistName, songs);
		playlists.add(myPlaylist);
	}
	
	public void createEmptyPlaylist(String playlistName) {
		Playlist myPlaylist = new Playlist(playlistName);
		playlists.add(myPlaylist);
	}
	
	public Playlist getPlaylist(int myPlaylistIndex) {
		//when user clicks on particular playlist
		return playlists.get(myPlaylistIndex);
	}
	
	public Song getNextSong() {
		if(songs.size() == 0) {
			return null;
		}
		if(shuffle) {
			int newSongIndex = random.nextInt(songs.size());
			//until new and old songs are the same we need to generate random songs
			while(currentIndex == newSongIndex){
				newSongIndex = random.nextInt(songs.size());
			}
			this.currentIndex = newSongIndex;
			return songs.get(newSongIndex);
		} else {
			if(currentIndex == (songs.size() - 1)) {
				this.currentIndex = -1;
			}
			return songs.get(++currentIndex);
		}	
	}
	
	public Song getPreviousSong() {
		if(songs.size() == 0) {
			return null;
		}
		if(shuffle) {
			int newSongIndex = random.nextInt(songs.size());
			//until new and old songs are the same we need to generate random songs
			while(currentIndex == newSongIndex ){
				newSongIndex = random.nextInt(songs.size());
			}
			this.currentIndex = newSongIndex;
			return songs.get(newSongIndex);
		} else {
			if(currentIndex == 0) {
				this.currentIndex = songs.size();
			}
			return songs.get(--currentIndex);
		}
	}
	
	public void sortBySongName() {
		Collections.sort(this.songs);
	}
	
	public void addSong(Song song) {
		songs.add(song);
		sortBySongName();
	}
	
	public void removeSong(int songIndex) {
		if(songs.size() != 0) {
			songs.remove(songIndex);
		}
	}
	
	public boolean isShuffle() {
		return shuffle;
	}

	public void setShuffle(boolean shuffle) {
		this.shuffle = shuffle;
	}
	
}
