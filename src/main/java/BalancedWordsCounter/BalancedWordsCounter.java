package BalancedWordsCounter;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BalancedWordsCounter {
	
	public static int count(String input) {
		
		checkForCorrectInput(input);
		
		if(input.length() == 0) {
			return 0;
		}
		
		if(input.length() == 1) {
			return 1;
		}
		
		return countBalancedWords(input, input.length());
	}
	
		
	
	private static void checkForCorrectInput(String input) {
		
		 if(input == null) {
			 throw new NullPointerException("Input can not be null");
		 } 
	     if(!input.matches("[a-zA-Z]+") && !input.equals("")) {
	    	 throw new RuntimeException("Input can only contain letters");	    	 
	     } 	
	}
	
	

	private static int countBalancedWords(String word, int subWordLength) {
		int count = 0;

		if(subWordLength == 2) {			
			//All 2 and 1 sized substrings are balanced no need to check them
			return word.length() * 2 - 1;
		}
		
		
		for (int i = 0; i + subWordLength <= word.length(); i++) {
			
			String subWord = word.substring(i, i + subWordLength);
			
			count += (checkIfBalanced(subWord)) ? 1 : 0;

		}

		count += countBalancedWords(word, subWordLength -1);

		return count;
	}
	
	
	
	private static boolean checkIfBalanced(String subWord) {
		
		Map<Character, Integer> charFrequency = subWord.chars()
	               .mapToObj(c -> (char)c)
	               .collect(Collectors.groupingBy( Function.identity(),
	            		   Collectors.summingInt(c -> 1)));

		Set<Integer> uniqueCharOccurance = new HashSet<>(charFrequency.values());
		
		return (uniqueCharOccurance.size() == 1) ? true : false;
		
	}
}
