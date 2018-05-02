package com.example.xfeng.hangman;

public interface Game extends Comparable<Game>{

	public float getScore();
	public int getPlayerId();

	@Override
	public int compareTo(Game game);

}