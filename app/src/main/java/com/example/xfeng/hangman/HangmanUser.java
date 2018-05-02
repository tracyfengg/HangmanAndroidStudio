package com.example.xfeng.hangman;
import java.io.BufferedReader;
import java.util.Scanner;

public class HangmanUser extends Hangman {
	@Override
	public int getPlayerId() {
		return 0;
	}

    @Override
    public int compareTo(Game game){
	    return 0;
    }
    public HangmanUser(BufferedReader br){
		super(br);
	}

    @Override
	public char getGuess(String previousGuesses) {
		Scanner scanner = new Scanner(System.in);
		String guessS = scanner.next();
		char guess = guessS.charAt(0); // should error check and make sure at least one letter
		while (previousGuesses.contains(guessS)) {
			System.out.println("you have already guessed that, please try a different letter");
			guessS = scanner.next();
			guess = guessS.charAt(0);
		}
		return guess;
	}

//	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		GamesRecord gamesRecord = new GamesRecord();
//		boolean done = false;
//		while (!done) {
//			System.out.println("want to play a game (y for yes)?");
//			String answer = scanner.nextLine();
//			if (answer.equals("y")) {
//				HangmanUser hangman = new HangmanUser();
//				hangman.readPhrase("C:/Users/xuef3/Desktop/hangPhrases.txt");
//				String phrase = hangman.randomPhrase();
//				hangman.play(phrase);
//				gamesRecord.add(hangman);
//				System.out.println("Average:" + gamesRecord.average());
//			} else {
//				done = true;
//			}
//		}
//	}
}
