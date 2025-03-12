package STRINGS;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class One {

	public static void main(String[] args) {
		
//		1. find occurrence of each character 
//		=====================================
		
		String s = "helloworld";
//		Map<Integer, Long> c = s.chars().boxed().collect(Collectors.groupingBy(e->e,Collectors.counting()));
//		c.forEach((character ,count)->System.out.print((char)character.intValue()+" - "+count+ ", "));
		
				// ( or )
//		Map<Object, Long> c1 = s.chars().mapToObj(ch->(char)ch).collect(Collectors.groupingBy(e->e,Collectors.counting()));
//		for(Object str : c1.keySet()) {
//			System.out.println(str+"-"+c1.get(str));
//		}
		
		Map<String, Long> c2 = Arrays.stream(s.split("")).collect(Collectors.groupingBy(e->e,Collectors.counting()));
		// or
		Map<String, Long> c3 = Arrays.stream(s.split("")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
//		System.out.println(c3);
	
		
//		2. print duplicate characters
//		====================================
		Map<String, Long> ch = Arrays.stream(s.split("")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
//		ch.entrySet().stream().filter(e->e.getValue()>1).map(r->r.getKey()).forEach(System.out::println);

		// or
		Set<String> set = new HashSet<>();
		Set<String> collect = Arrays.stream(s.split("")).filter(e->!set.add(e)).collect(Collectors.toSet());
//		System.out.println(collect);
		   			//or
		Set<Character> set1 = new HashSet<>();
//		s.chars().mapToObj(c->(char)c).filter(e->!set1.add(e)).distinct().forEach(System.out::println);
		
		
//		3. find first non repeating character in string(first find unique elements)
//		=========================================
		Map<String, Long> che = Arrays.stream(s.split("")).collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()));
		String st = che.entrySet().stream().filter(e->e.getValue()==1).findFirst().get().getKey();
//		System.out.println(st);
		
		LinkedHashMap<Character, Long> in = s.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()));
		Character key = in.entrySet().stream().filter(e->e.getValue()==1).findFirst().get().getKey();
//		System.out.println(key);
		
//		4. reverse each word of a string
//		=================================
		
		String str = "hello world i am girish";
		List<String> collect2 = Arrays.stream(str.split(" ")).map(e->new StringBuilder(e).reverse().toString()).collect(Collectors.toList());
//		System.out.println(collect2);
	
		// reverse the words 
		Optional<String> reduce2 = Arrays.stream(str.split(" ")).reduce((s1,s2)->s2+" "+s1);
//		System.out.println(reduce2.get());
		
		
//		5. print last element of a list of string
//		=========================================

		List<String> l = Arrays.asList("hi", "hello","word","girish");
		String sr = l.stream().skip(l.size()-1).findFirst().get();
//		System.out.println(sr);
		
		
//		6. concat 2 String into one String
//		==================================
		String s1 = "hi";
		String s2 = "girish";
		String collect3 = Stream.of(s1,s2).collect(Collectors.joining(" "));
//		System.out.println(collect3);
		
//		7. return non empty String count in list of Strings
//		===============================
		
		List<String> l1 = Arrays.asList("hi","","heo","","");
		long count = l1.stream().filter(e->e.isEmpty()).count();
//		System.out.println(l1.size()-count);
			//or
		Predicate<String> st1 = String::isEmpty;
		long count1 = l1.stream().filter(st1.negate()).count();
//		System.out.println(count1);
		
//		8. find the Longest String
//		=================
		
		List<String> l2 = Arrays.asList("hi", "hello","word","girish");
		String t = l2.stream().max(Comparator.comparing(String::length)).get();
//		System.out.println(t);
		
		String collect4 = l2.stream().collect(Collectors.maxBy(Comparator.comparing(e->e.length()))).get();
//		System.out.println(collect4);
		
		String s3 = "hi i am girish palukuru";
		String d = Arrays.stream(s3.split(" ")).sorted(Comparator.comparing(e->e.length(),Comparator.reverseOrder())).findFirst().get();
//		System.out.println(d);
		
		String d1 = Arrays.stream(s3.split(" ")).max(Comparator.comparing(e->e.length())).get();
//		System.out.println(d1);
		
		
//		9. print  palindromes in list of strings
//		======================
		
		List<String> l3 = Arrays.asList("hi", "mam","bob","girish");
//		l3.stream().filter(e->e.equals(new StringBuilder(e).reverse().toString())).forEach(System.out::println);
		
		
//		10. given 2 list of strings concate and remove duplicates
//		==========================
		
		List<String> l4 = Arrays.asList("hi", "mam","bob");
		List<String> l5 = Arrays.asList("hi", "mamdam","bob");
//		Stream.concat(l4.stream(), l5.stream()).distinct().forEach(System.out::println);
		
//		11. sort the list of strings according to increase order of length
//		======================
		
		List<String> l6 = Arrays.asList("hi", "mamdam","bob");
		List<String> collect5 = l6.stream().sorted(Comparator.comparing(e->e.length())).collect(Collectors.toList());
//		System.out.println(collect5);
		
//		12. filter the strings contains a specific character
//		====================
		
		List<String> l7 = Arrays.asList("hai", "mamdam","bob");
		List<String> collect6 = l7.stream().filter(e->e.contains("a")).collect(Collectors.toList());
//		System.out.println(collect6);
		
//		13. find the most frequent element in list
//		====================
		
		List<String> l8 = Arrays.asList("hi", "mamdam","bob", "hi", "madam","hi");
		
		Map<String, Long> collect7 = l8.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		Long long1 = collect7.values().stream().max(Comparator.comparing(e->e)).get();
		collect7.entrySet().stream().filter(e-> e.getValue()== long1).map(Map.Entry::getKey).forEach(System.out::println);
		//or we can use this also
		String key2 = collect7.entrySet().stream().filter(e-> e.getValue()== long1).findFirst().get().getKey();
		System.out.println(key2);
		
		
		String strs= "ijvh hcui  ih ih ih ji ji kl kl ";
		HashMap<String, Long> m = new HashMap<String, Long>();
		String[] ss = strs.split(" ");
		for(String sss : ss) {
			if(m.containsKey(sss)) {
				m.put(sss, m.get(sss)+1L);
				
			}
			else {
				m.put(sss, 1L);
			}
		}
		List<String> coll = m.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed()).limit(3).map(e->e.getKey()).collect(Collectors.toList());
		
		
	}

}
