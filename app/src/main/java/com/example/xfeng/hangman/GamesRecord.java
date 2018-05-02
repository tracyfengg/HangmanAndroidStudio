package com.example.xfeng.hangman;

import com.example.xfeng.hangman.Game;

import java.util.ArrayList;
import java.util.Collections;

import java.util.ArrayList;
import java.util.Collections;

public class GamesRecord {
	ArrayList<Game> gameList = new ArrayList<Game>();

	public void add(Game game) {
		gameList.add(game);
	}

	public float average() {
		float totalScore = 0;
		for (Game game: gameList) {
			totalScore += game.getScore();
		}
		float average = totalScore/gameList.size();
		return average;
	}

	public float average(int playId) {
		float totalScore = 0;
		int count = 0;
		for (Game game: gameList) {
			if (playId == game.getPlayerId()){
				totalScore += game.getScore();
				count++;
			}
		}
		float average = totalScore/count;
		return average;
	}

	public ArrayList<Float> highGameList(int n) {
		Collections.sort(gameList);
		ArrayList<Float> topScores = new ArrayList<Float>();
		for (Game game: gameList) {
			for (int i = 0; i < n; i++) {
				topScores.add(game.getScore());
			}
		}
		return topScores;
	}
}