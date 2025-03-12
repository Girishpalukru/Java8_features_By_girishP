package RealTime;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.ToIntFunction;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class Dish {
	String name;
	int calories;
	boolean isVeg;
	String type;
	int price;
	public Dish(String name, int calories, boolean isVeg, String type, int price) {
		super();
		this.name = name;
		this.calories = calories;
		this.isVeg = isVeg;
		this.type = type;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	public boolean isVeg() {
		return isVeg;
	}

	public void setVeg(boolean isVeg) {
		this.isVeg = isVeg;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Dish [name=" + name + ", calories=" + calories + ", isVeg=" + isVeg + ", type=" + type + ", price=" + price
				+ "]";
	}
}

public class Test4_Dish {
	public static void main(String[] args) {
		Dish d1 = new Dish("chicken biriyani",500,false,"village style",400);
		Dish d2 = new Dish("Fish curry",300,false,"Restaurant style",300);
		Dish d3 = new Dish("mutton curry",650,false,"village style",700);
		Dish d4 = new Dish("veg rice",200,true,"Restaurant style",250);
		Dish d5 = new Dish("dosa",120,true,"village style",150);
		Dish d6 = new Dish("Juices",80,true,"Processed style",65);


		List<Dish> dishes = Arrays.asList(d1,d2,d3,d4,d5,d6);
		
//		1. print dish names from 4th heightest calories dish
//		dishes.stream().sorted(Comparator.comparing(Dish::getCalories).reversed()).skip(3).map(i-> i.name).forEach(System.out::println);

//		2. print first veg dish
		dishes.stream().filter(i->i.isVeg).findAny().ifPresent(System.out::println);

		List<Integer> l = Arrays.asList(1,2,3,5,1,5,6,7,8,9,20,10);
//		3. 
		


	}

}


