package com.ss.sf.clump;

// Converts list to a string with markers to indicate evenness/oddness

import java.util.ArrayList;
import java.util.stream.Collectors;

public class ClumpInts {

	public static void main(String[] args){
		ClumpInts test = new ClumpInts();
		ArrayList<Integer> clumpMe = new ArrayList<>();
		clumpMe.add(1);
		clumpMe.add(4);
		clumpMe.add(8);
		clumpMe.add(3);
		clumpMe.add(72);
		System.out.println(test.clump(clumpMe).toString());
	}
	
	public String clump(ArrayList<Integer> intList){
		String intStr = intList.stream().
				map(e -> e%2 == 0 ? "e"+e : "o"+e).
				collect(Collectors.joining(","))
				;
		
		return intStr;
	}
}
