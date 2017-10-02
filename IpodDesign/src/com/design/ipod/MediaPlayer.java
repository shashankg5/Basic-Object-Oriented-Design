package com.design.ipod;

public interface MediaPlayer {
	
	public Song getSong(int songIndex);
	public Song getNextSong();
	public Song getPreviousSong();
	public void addSong(Song song);
	public void removeSong(int songIndex);
	public boolean isShuffle();
	public void setShuffle(boolean shuffle);
}
