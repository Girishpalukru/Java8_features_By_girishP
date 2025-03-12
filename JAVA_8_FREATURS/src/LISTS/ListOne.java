package LISTS;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListOne {

	public static void main(String[] args) {

//		1. find min in an array or list
//		===============
		int[] ar= {5,9,11,2,8,21,1};
		List<Integer> a = Arrays.asList(5,9,11,2,8,21,1);
		
		//using list
//		System.out.println(a.stream().min(Comparator.comparing(Integer::valueOf)).get());
		//using array
		int asInt = Arrays.stream(ar).min().getAsInt();
//		System.out.println(asInt);
		
//		2. find max in an array or list
//		====================
		int[] ar1= {5,9,11,2,8,21,1};
		List<Integer> a1 = Arrays.asList(5,9,11,2,8,21,1);
		
		//using list
//		System.out.println(a1.stream().max(Comparator.comparing(Integer::valueOf)).get());
		//using array
		int asInt2 = Arrays.stream(ar1).max().getAsInt();
//		System.out.println(asInt2);
		//or
		Integer re = a1.stream().collect(Collectors.maxBy(Comparator.comparing(Integer::valueOf))).get();
//		System.out.println(re);
		
//		3. find second highest number in an array or list
//		==============================
		int[] ar2= {5,9,11,2,8,21,1};
		List<Integer> a2 = Arrays.asList(5,9,11,2,8,21,1);
		Integer i = Arrays.stream(ar2).boxed().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
		Integer i1 = a2.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
//		System.out.println(i);

//		4. find second lowest number in an array or list
//		===============================
		Integer i2 = Arrays.stream(ar).boxed().sorted().skip(1).findFirst().get();
		Integer i3 = a2.stream().sorted().skip(1).findFirst().get();
//		System.out.println(i2);
		
//		5. Add all elements in list or array
//		=======================
		int[] ar3 = {5,9,11,2,8,21,1};
		List<Integer> a3 = Arrays.asList(5,9,11,2,8,21,1);
//		System.out.println(a3.stream().reduce(0,(b1,b)->b1+b));// or reduce((b1,b)->b1+b)  //or reduce(Integer::sum).get()
//		System.out.println(Arrays.stream(ar3).sum());
				//or
//		System.out.println(a3.stream().collect(Collectors.reducing(0,(b1,b)->b1+b)));
		
//		6. average  of all elements 
//		====================,
		int[] ar4 = {5,9,11,2,8,21,1};
		List<Integer> a4 = Arrays.asList(5,9,11,2,8,21,1);
//		System.out.println(Arrays.stream(ar4).average().getAsDouble());
				//using list
//		System.out.println(a.stream().mapToInt(Integer::intValue).average().getAsDouble());
		
//		System.out.println(a.stream().collect(Collectors.averagingDouble(e->e)));
		
		
//		7.  square the elements and check greater than 200 or not and print average
//		=================
		
		//System.out.println(a4.stream().map(e->e*e).filter(e->e>200).mapToInt(e->e).average().getAsDouble());
		
//		8. print even numbers and odd numbers
//		=====================
		int[] ar5 = {5,9,11,2,8,21,1};
		List<Integer> a5 = Arrays.asList(5,9,11,2,8,21,1);
		
//		System.out.println(a5.stream().collect(Collectors.groupingBy(e->e%2==0)));
//		System.out.println(a5.stream().collect(Collectors.partitioningBy(r->r%2==0)));
		
//		9. print number whose start with 2
//		=====================
		List<String> k= a5.stream().map(e->e+"").filter(e->e.startsWith("2")).map(String::valueOf).collect(Collectors.toList());// e->String.valueOf(e); or Integer::valueOf
//		System.out.println(k);
		
//		10. print duplicates number in List
//		=========================
		List<Integer> a6 = Arrays.asList(5,9,11,2,8,21,1,11,9,5);
		
		Set<Integer> set = new HashSet<>();
		List<Integer> c7 = a6.stream().filter(e->!set.add(e)).collect(Collectors.toList());
//		System.out.println(c7);
		
				//or
		Set<Integer> c8 = a6.stream().filter(x->Collections.frequency(a6, x)>1).collect(Collectors.toSet());
//		System.out.println(c8);
		

		
		
	}
	

}
