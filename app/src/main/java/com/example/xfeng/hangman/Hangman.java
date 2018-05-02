package com.example.xfeng.hangman;

import com.example.xfeng.hangman.Game;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public abstract class Hangman implements Game {
	ArrayList<String> phraseList = new ArrayList<String>();
	private int totalGuesses = 0;

	public abstract char getGuess(String previousGuesses);

	public abstract int compareTo(Game game);

	@Override
	public float getScore() {
		return totalGuesses;
	}
	public Hangman(BufferedReader br){
		readPhrase(br);
	}
	public String randomPhrase() {
		Random randomWord = new Random();
		int randomNum = randomWord.nextInt(10);
		String phrase = phraseList.get(randomNum);
		return phrase.toLowerCase();
	}

	public String generateHiddenPhrase(String phrase) {
		String hiddenWord = "";
		for (int i = 0; i < phrase.length(); i++) {
			char temp = phrase.charAt(i);
			if (temp != ' ') {
				temp = '*';
				hiddenWord = hiddenWord + temp;
			} else {
				temp = ' ';
				hiddenWord = hiddenWord + temp;
			}
		}
		return hiddenWord;
	}

	public boolean processGuess(char guess, String phrase, StringBuilder hiddenPhrase) {
		boolean match = false;
		int i = 0;
		while (i < phrase.length()) {

			if (guess == phrase.charAt(i)) {
				match = true;
				hiddenPhrase.setCharAt(i, guess);

			}
			i = i + 1;
		}
		return match;
	}

	public char AListGuess() {
		char ch = 0;
		int j = 0;
		String AList = "zjqxkvbpgwyfmculdhrsnioate";
		while (j < AList.length()) {
			ch = AList.charAt(j);
			j++;
			ch = AList.charAt(j);
			System.out.println(ch);
		}
		return ch;
	}

	public void readPhrase(BufferedReader breader) {
		try {
			StringBuffer stringBuffer = new StringBuffer();
			String Line;
			while ((Line = breader.readLine())!=null) {
				this.phraseList.add(Line.toLowerCase());
			}
		} catch (IOException IOEe) {
			System.out.println("File not found.");
		}
	}

	public int numPhrasees() {
		return phraseList.size();
	}

	public void play(String phrase) {

		// generate the hidden phrase by replacing all non-space with *
		StringBuilder hiddenPhrase = new StringBuilder(this.generateHiddenPhrase(phrase));

		System.out.println(phrase);
		System.out.println(hiddenPhrase);

		String previousGuesses = "";

		// guess
		boolean gameOver = false;
		int wrongGuesses = 0;
		totalGuesses = 0;
		while (!gameOver) {

			char guess = this.getGuess(previousGuesses);
			System.out.println("guess:" + guess);
			previousGuesses = previousGuesses + guess;

			boolean match = this.processGuess(guess, phrase, hiddenPhrase);
			totalGuesses++;
			if (match == false) {
				wrongGuesses++;
			} else if (phrase.equals(hiddenPhrase.toString())) {
				System.out.println("YOU WIN");
				System.out.println("Wrong Guesses:" + wrongGuesses);
				System.out.println("Total Guesses:" + totalGuesses);

				gameOver = true;

			}
			if (!gameOver) {
				System.out.println("Wrong Guesses:" + wrongGuesses);
				System.out.println("Total Guesses:" + totalGuesses);
				System.out.println(hiddenPhrase);
			}
		}
	}



}