package BalancedWordsCounterTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import BalancedWordsCounter.BalancedWordsCounter;

public class BalancedWordsCounterTest {
	
	@Test
	void testForNull() {
		
		boolean thrown = false;
		
		  try {
			    BalancedWordsCounter.count(null);
			  } catch (NullPointerException npe) {
			    thrown = true;
			  }
		  
		  assertTrue(thrown);
	}
	
	@Test
	void testForInputWithNumbers() {
		
		boolean thrown = false;
		
		  try {
			    BalancedWordsCounter.count("abababa1");
			  } catch (RuntimeException re) {
			    thrown = true;
			  }
		  
		  assertTrue(thrown);
	}
	
	@Test
	void testforEmptyString() {
		
		assertEquals(0, BalancedWordsCounter.count(""));
	}
	
	@Test
	void testForInputLength1() {
		
		assertEquals(1, BalancedWordsCounter.count("a"));
	}
	
	@Test
	void testForInputLength2() {
		
		assertEquals(3, BalancedWordsCounter.count("ab"));
	}
	
	@Test
	void testForInputLength3WithSixBalancedWords() {
		
		assertEquals(6, BalancedWordsCounter.count("abc"));
	}
	
	@Test
	void testForInputLength3WithFiveBalancedWords() {
		
		assertEquals(5, BalancedWordsCounter.count("aab"));
	}
	
	@Test
	void testForAverageInput() {
		
		assertEquals(28, BalancedWordsCounter.count("aabbabcccba"));
	}

	
}
