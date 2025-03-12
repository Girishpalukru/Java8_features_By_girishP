package LISTS;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class ListSecond {

	public static void main(String[] args) {
		
//		1. find sum of all digits in a number
//		================
		int a = 142;
		IntStream chars = String.valueOf(a).chars();
		int sum = chars.map(e->Character.getNumericValue(e)).sum();// or Character::getNumericValue
//		System.out.println(sum);
		
//		2. given 2 arrays you need t merge the arrays
//		===============
		int[] a1 = {1,5,6}; int[] a2 = {2, 1,4};
		int[] array = IntStream.concat(Arrays.stream(a1), Arrays.stream(a2)).sorted().toArray();
		
//		3. check if any element is negative or not
//		=====================
		List<Integer> a6 = Arrays.asList(5,9,11,2,8,21,1,11,9,5);
		
//		System.out.println(a6.stream().allMatch(e->e>0));
//		System.out.println(a6.stream().noneMatch(e->e<0));
		
//		4. 
//		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

}
