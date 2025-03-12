package RealTime;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Test3_Emp_complx {

	public static void main(String[] args) {
		
		List<Employee> emps = Arrays.asList(
				new Employee("1", "giri", 25, "HR", 20000),
				new Employee("1", "giri", 25, "HR", 20000),
				new Employee("2", "avinash", 24, "dev", 30000)
				
				);

		
//		1.convert list of employees to map and handle duplicate keys(like remove duplicate rows )
		Map<String, Employee> collect = emps.stream().collect(Collectors.toMap(Employee::getName, e->e,(old,newv)->newv));
		collect.entrySet().stream().forEach(enty->{
//			System.out.print("key = "+enty.getKey()+"  ");
//			System.out.println("value = "+enty.getValue());
			
		});
		
//		2. convert a list of integer into a map by considering duplicated keys and values as number of occurrence of element
		
		List<Integer> arr = Arrays.asList(1,2,5,1,2,5,3,4);
		Map<Integer, Integer> collect2 = arr.stream().collect(Collectors.toMap(element->element, element -> 1 ,Integer::sum));
				//or
		Map<Integer, Long> collect3 = arr.stream().collect(Collectors.groupingBy(e->e ,Collectors.counting()));//function.identityl
		collect3.forEach((key,val)->{
			System.out.print("key = "+key+"  ");
			System.out.println("value = "+val);
		});
		
//		3.find  first longest subString without repeating character 
		
		String s = "pwwkew";
		
		
		
//		4. How to count the number of occurrences of a given word in a List of strings 
		
		List<String> as = Arrays.asList(
					"hello world",
					"hello java",
					"hello python"
				);
		
		String sa = "hello";
		
		long count = as.stream().flatMap(c->Arrays.stream(c.split(" "))).filter(e->sa.equals(e)).count();
//		System.out.println(count);
		
//		5. print common elements from 2 arrays
		
		int[] ar1 = {4,6,7,9,5}; int[] ar2 = {5,8,3,6,7};
		List<Integer> list = Arrays.stream(ar1).boxed().toList();
		List<Integer> collect4 = Arrays.stream(ar2).boxed().filter(e->list.contains(e)).collect(Collectors.toList());
//		System.out.println(collect4);
		
		
//		6. how to find missing number from an array
		
		int[] ar3 = {4,-1,3,1};
		int[] sum = Arrays.stream(ar3).filter(i->i>0).distinct().toArray();
		int n = sum.length+1;
		int tota = n*(n+1)/2;
		int sum2 = Arrays.stream(sum).sum();
		System.out.println(tota-sum2);
		
		
//		7. 
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
