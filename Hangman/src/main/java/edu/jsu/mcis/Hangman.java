package edu.jsu.mcis;

import java.util.*;

public class Hangman {
    public enum Result { WIN, LOSE, NONE };
    private String word;
    private List<Character> usedLetters;
	private int maxMisses = 0;
	private boolean letterPresent = false;
	private int numMisses = 0;
    
    public Hangman() {
        word = "";
        usedLetters = new ArrayList<Character>();
		maxMisses = 6;
		
    }
    
    public void setWord(String word) {
        this.word = word;
    }
    
    public boolean available(char c) {
		if(usedLetters.isEmpty()) {
			usedLetters.add(c);
			return true;
		}
        else {
			if(usedLetters.contains(c)) {
				return false;
			}
			else {
				usedLetters.add(c);
				return true;
			}
		}		
    }

	private boolean letterPresent(char c) {
		for(int i = 0; i < word.length(); i++) {
			if(c == word.charAt(i)){
				letterPresent = true;
			}
			else{
				letterPresent = false;
			}
		}
		
		return letterPresent;
	}
    
    public int guess(char c) {
		int numOccur = 0;
		letterPresent(c);
		if(letterPresent == true && numMisses < maxMisses) {
			for(int i = 0; i < word.length(); i++) {
				if(c == word.charAt(i)) {
					numOccur = numOccur + 1;
				}
			}
		}
		else {
			numMisses = numMisses + 1;
		}
        return numOccur;
    }

	
    public Result getResult() {
		if(numMisses < maxMisses) {
			for(int i = 0; i < word.length(); i++) {
				if(usedLetters.contains(word.charAt(i))) {
					return Result.WIN;
				}
				else {
					return Result.NONE;
				}
			}
		}
		
		if(numMisses == maxMisses) {
			return Result.LOSE;
		}
        
		return Result.NONE;
    }

	public int getNumTurns() {
		return turn;
	}
	
	public int getNumMisses(){
		return numMisses;
	}    
}












