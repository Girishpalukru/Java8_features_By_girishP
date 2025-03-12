package LISTS;

import java.util.List;
import java.util.stream.Stream;

public class MoveZeroToRight {

	public static void main(String[] args) {
		
//		1. move all zeros to right of List and having positive and negative
		
		List<Integer> of = List.of(1,0,-3,0,5,-2,0,8,0,-4);
		
		List<Integer> list = Stream.concat(of.stream().filter(n->n!=0), of.stream().filter(n->n==0)).toList();
		System.out.println(list);
	}

}
