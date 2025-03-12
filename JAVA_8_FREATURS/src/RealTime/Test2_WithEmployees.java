package RealTime;

import java.util.Arrays;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

class Employe{
	private int id;
	private String name;
	private int age;
	private String gender;
	private String department;
	private int yearofjoining;
	private double salary;
	public Employe(int id, String name, int age, String gender, String department, int yearofjoining, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.department = department;
		this.yearofjoining = yearofjoining;
		this.salary = salary;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getYearofjoining() {
		return yearofjoining;
	}
	public void setYearofjoining(int yearofjoining) {
		this.yearofjoining = yearofjoining;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", department="
				+ department + ", yearofjoining=" + yearofjoining + ", salary=" + salary + "]";
	}
}

public class Test2_WithEmployees {

	public static void main(String[] args) {
		List<Employe>  emp = Arrays.asList(
					new Employe(1, "girish", 25, "male","HR", 2019, 25000),
					new Employe(2, "dinesh", 22, "male","sales", 2015, 45000),
					new Employe(3, "ruthvika", 15, "female","HR", 2010, 15000),
					new Employe(4, "pradhu", 28, "male","dev", 2023, 250000),
					new Employe(5, "sukumar", 35, "male","sales", 2005, 30000),
					new Employe(6, "chinni", 24, "female","dev", 2000, 2000)
				);
//		1. how many male and female employees
//		============
		
		Map<String, Long> collect = emp.stream().collect(Collectors.groupingBy(er->er.getGender(),Collectors.counting()));
//		System.out.println(collect);
			//or
		Map<Boolean, Long> collect2 = emp.stream().collect(Collectors.partitioningBy(e->e.getGender()=="male",Collectors.counting()));
//		System.out.println(collect2);
		
//		2. print name of all departments in company
//		===========
		
		List<String> list = emp.stream().map(Employe::getDepartment).distinct().toList();
//		System.out.println(list);
		
//		3. average salary of male and female emp
//		==========
		
		Map<String, Double> collect3 = emp.stream()
				.collect(Collectors.groupingBy(er->er.getGender(),Collectors.averagingDouble(er->er.getSalary()))); // use partitining
//		System.out.println(collect3);
		
//		4. find the employee who has joined after 2015
//		============
		
		List<Employe> list2 = emp.stream().filter(er->er.getYearofjoining()>2015).toList();
//		System.out.println(list2);
		
//		5. get youngest male employee in hr dept
//		==============
		
		Optional<Employe> min = emp.stream().filter(er->er.getDepartment()=="HR" && er.getGender()=="male").min(Comparator.comparingInt(er->er.getAge()));		
//		System.out.println(min.get());
		
//		6. get emp who has highest experience
//		==================
		
		Employe e = emp.stream().min(Comparator.comparingInt(er->er.getYearofjoining())).get();
//		System.out.println(e);
		
		
//		7. List of employees names in each dept
//		==============
		Map<String, List<Employe>> collect4 = emp.stream().collect(Collectors.groupingBy(er->er.getDepartment()));
		collect4.forEach((i,j)-> {
					System.out.println("dept :  "+i);
					for(Employe n :j) {
						System.out.println(n.getName());
					}
		});
		
//		8. what is average and sum  salary of whole organization
		
		DoubleSummaryStatistics c = emp.stream().collect(Collectors.summarizingDouble(es->es.getSalary()));
//		System.out.println(c.getAverage());
//		System.out.println(c.getSum());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
