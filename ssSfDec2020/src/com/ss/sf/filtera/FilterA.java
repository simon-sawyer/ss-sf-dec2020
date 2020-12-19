package com.ss.sf.filtera;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FilterA {
	
	public static void main(String[] args){
		FilterA test = new FilterA();
		ArrayList<String> filterMe = new ArrayList<>();
		filterMe.add("apple");
		filterMe.add("Art");
		filterMe.add("cat");
		filterMe.add("ant");
		filterMe.add("gorilla");
		filterMe.add("Articulate");
		System.out.println(test.filterA(filterMe).toString());
	}
	
	public List<String> filterA(ArrayList<String> filterMe){
		List<String> filtered = filterMe.stream().
				filter(str -> str.charAt(0) == 'a' || str.charAt(0) == 'A').
				filter(str -> str.length() == 3).
				collect(Collectors.toList());
		
		return filtered;
	}
}
