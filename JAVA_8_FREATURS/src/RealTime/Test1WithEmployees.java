package RealTime;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Employee{
	private String id;
	private String name;
	private Integer age;
	private String department;
	private Integer salary;
	public Employee(String id, String name, Integer age, String department, Integer salary) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.department = department;
		this.salary = salary;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", department=" + department + ", salary="
				+ salary + "]";
	}
	
}
public class Test1WithEmployees {

	public static void main(String[] args) {
		
		List<Employee> list = Arrays.asList(
				new Employee("101", "siva", 35, "sales", 30000),
				new Employee("102", "bala", 42, "HR", 420000),
				new Employee("103", "ramesh", 23, "Developer", 20000),
				new Employee("104", "devi", 54, "sales", 48000),
				new Employee("105", "ramya", 25, "Developer",22000)
				);
//		1. print employee list using stream
//		==============
//		list.stream().forEach(System.out::println);
		
//		2. find the Employees whose salary greater than 40000
//		==============
		
		List<Employee> collect = list.stream()
				.filter(e->e.getSalary()>40000)
				.collect(Collectors.toList());
//		System.out.println(collect);
		
//		3. print name of employees in sales dep
//		===========
		
		List<String> collect2 = list.stream()
				.filter(e->e.getDepartment()=="sales")
				.map(e->e.getName())
				.collect(Collectors.toList());
//		System.out.println(collect2);
		
//		4. print the name of the highest salary employee
//		=============
		
		Employee max = list.stream()
				.max(Comparator.comparingInt(e->e.getSalary()))
				.get();
//		System.out.println(max.getName());
//		or
		String m = list.stream()
				.collect(Collectors.maxBy(Comparator.comparingInt(e->e.getSalary())))
				.map(Employee::getName)
				.get();
//		System.out.println(m);
		
//		5. print the name of minimum salary employee
//		=================
		
		String min1 = list.stream()
		.min(Comparator.comparing(Employee::getSalary))
		.map(Employee::getName).get();
//		System.out.println(min1);
		
		String min = list.stream()
				.collect(Collectors.minBy(Comparator.comparingInt(e->e.getSalary())))
				.map(Employee::getName)
				.get();
//		System.out.println(min);
		
//		6. Remove the duplicate departments
//		====================
		
		List<String> collect3 = list.stream()
				.map(Employee::getDepartment)
				.distinct().collect(Collectors.toList());	
//		System.out.println(collect3);
		//or
		Set<String> collect4 = list.stream().map(Employee::getDepartment).collect(Collectors.toSet());
//		System.out.println(collect4);
		
//		7. sort the Employees based on the name
//		============
		
		List<String> sorted = list.stream()
				.map(Employee::getName)
				.sorted(Comparator.comparing(Function.identity()))
				.collect(Collectors.toList());//or e->e
//		System.out.println(sorted);
		
		
//		8. sort the Employees based on the name
//		=========
		List<String> sorted1 = list.stream()
				.map(Employee::getName)
				.sorted(Comparator.reverseOrder())
				.collect(Collectors.toList());//or e->e
//		System.out.println(sorted1);
		
//		9. sort the Employees based on  department and name
//		=============
		
		List<Employee> sorted2 = list.stream()
				.sorted(Comparator.comparing(Employee::getDepartment).thenComparing(Employee::getName))
				.collect(Collectors.toList());//or e->e
//		System.out.println(sorted2);
		
//		10. print no of Employees in each department 
//		================
		Map<String, Long> collect5 = list.stream()
				.collect(Collectors.groupingBy(e->e.getDepartment(),Collectors.counting()));
		System.out.println(collect5);
		
//		11. print duplicates departments
//		======================
		
		Map<String, Long> collect6 = list.stream()
				.collect(Collectors.groupingBy(e->e.getDepartment(),Collectors.counting()));
	
	
		List<String> collect7 = collect6
				.entrySet()
				.stream()
				.filter(e->e.getValue()>1)
				.map(e->e.getKey())
				.collect(Collectors.toList());
//		System.out.println(collect7);
		// or
		HashSet<String> se = new HashSet<String>();
		list.stream().map(e->e.getDepartment()).filter(j->!se.add(j)).forEach(System.out::println);;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

}
