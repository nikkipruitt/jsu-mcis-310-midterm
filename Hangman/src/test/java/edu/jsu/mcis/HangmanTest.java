package edu.jsu.mcis;

import org.junit.*;
import static org.junit.Assert.*;

public class HangmanTest {

    // Exam Question 1
    // Implement the Hangman available() method to make this 
    // unit test pass correctly.
    @Test
    public void testAllLettersAvailableAtBeginning() {
        Hangman h = new Hangman();
        h.setWord("inconceivable");
        String allLetters = "abcdefghijklmnopqrstuvwxyz";
        for(int i = 0; i < allLetters.length(); i++) {
            assertTrue(h.available(allLetters.charAt(i)));
        }
    }

    // Exam Question 2
    // Implement the Hangman available() method to make this 
    // unit test pass correctly.
    @Test
    public void testGuessLetterMakesItUnavailable() {
        Hangman h = new Hangman();
        h.setWord("inconceivable");
        boolean eIsAvailable = h.available('e');
        assertTrue(eIsAvailable);
        int numOccurrences = h.guess('e');
        eIsAvailable = h.available('e');
        assertFalse(eIsAvailable);
    }
    
    // Exam Question 3
    // Implement the Hangman guess() method to make this 
    // unit test pass correctly.
    @Test
    public void testGuessLetterReturnsCorrectOccurrences() {
        Hangman h = new Hangman();
        h.setWord("inconceivable");
        int numOccurrences = h.guess('e');
        assertEquals(2, numOccurrences);
    }
    
    // Exam Question 4
    // Implement this unit test to ensure that six or more missed
    // letters before the word is guessed results in a loss. Then,
    // implement the Hangman class methods required to make the 
    // test pass correctly.
    @Test
    public void testSixOrMoreMissesCausesALoss() {
		Hangman h = new Hangman();
		h.setWord("inconceivable");
		h.guess('t');
		assertEquals(1, h.getNumTurns());
		h.guess('k');
		assertEquals(2, h.getNumTurns());
		h.guess('z');
		assertEquals(3, h.getNumTurns());
		h.guess('y');
		assertEquals(4, h.getNumTurns());
		h.guess('j');
		assertEquals(5, h.getNumTurns());
		h.guess('x');
		assertEquals(6, h.getNumTurns());
        assertEquals("LOSE", h.getResult().toString());
    }
   
    // Exam Question 5
    // Implement this unit test to ensure that guessing all the 
    // letters correctly before six misses results in a win. Then,
    // implement the Hangman class methods required to make the 
    // test pass correctly.
    @Test
    public void testGuessingEveryLetterBeforeSixMissesCausesAWin() {
        Hangman h = new Hangman();
		h.setWord("snap");
		h.guess('e');
		assertEquals(1, h.getNumMisses());
		h.guess('p');
		h.guess('a');
		h.guess('n');
		h.guess('s');
		assertEquals("WIN", h.getResult().toString());
    }
   
}
