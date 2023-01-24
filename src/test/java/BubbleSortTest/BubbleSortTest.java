package BubbleSortTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import BubbleSort.BubbleSort;

class BubbleSortTest {

	@Test
	void testForNull() {
		
		boolean thrown = false;
		
		  try {
			    BubbleSort.sort(null);
			  } catch (NullPointerException npe) {
			    thrown = true;
			  }
		  
		  assertTrue(thrown);
	}
	
	@Test
	void testForEmptyInput() {
		
		assertEquals(new ArrayList<>() , BubbleSort.sort(new ArrayList<Integer>()));
	}
	
	@Test
	void testForNullValues() {
		assertEquals(Arrays.asList(5.0001) , BubbleSort.sort(Arrays.asList(null,5.0001)));
	}
	
	@Test
	void testForOneValue() {
		assertEquals(Arrays.asList(1) , BubbleSort.sort(Arrays.asList(1)));
	}
	
	@Test
	void testForIntegerValues() {
		assertEquals(Arrays.asList(1,3,4,5,6,8,8) , BubbleSort.sort(Arrays.asList(1,4,5,6,8,3,8)));
	}
	
	
	@Test
	void testForDoubleAndNegativeValues() {
		assertEquals( Arrays.asList(-9.3,0.1,0.2,4.0,5.0,9.0) , BubbleSort.sort(Arrays.asList(-9.3,0.2,4.0,0.1,5.0,9.0)));
	}

}
