package BubbleSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;


public class BubbleSort {
	
	public static <T extends Comparable<T>> List<T> sort(List<T> input){
		
		checkForCorrectInput(input);
		
		input = removeAllNullValuesFromList(input);
		
		input = bubbleSort(input);

		return input;
	}
	
	
	
	private static void checkForCorrectInput(List<?> input) {
		
		if(input == null) {
			throw new NullPointerException("Input can not be null");
		} 
	}	
	
	
	
	private static <T> List<T> removeAllNullValuesFromList(List<T> input){
		return input.stream()
				.filter(Objects::nonNull)
				.toList();
	}
	
	
	
	private static <T extends Comparable<T>> List<T> bubbleSort(List<T> input) {
		
		List<T> numbers = new ArrayList<>(input);
		
		boolean swapped = false;
		
		do {
			swapped = false;
			for (int i = 0; i < numbers.size() - 1; i++) {
				if (numbers.get(i).compareTo(numbers.get(i + 1)) == 1) {
					Collections.swap(numbers, i, i+1);
					swapped = true;
				}
			}
		}while (swapped);
		
		return numbers;

	}
}