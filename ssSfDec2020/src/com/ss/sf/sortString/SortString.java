package com.ss.sf.sortString;

// Sorts a list of strings in various ways

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortString {
	public static void main(String[] args){
		List<String> sortMe = new ArrayList<>();
		sortMe.add("Nikola");
		sortMe.add("Thomas");
		sortMe.add("Albert");
		sortMe.add("Edgar");
		sortMe.add("Pramod");
		
		Comparator<String> byLen = (str1, str2) -> str1.length() - str2.length();
		List<String> sortLen = sortMe.stream().
				sorted(byLen).
				collect(Collectors.toList());
		System.out.println(sortLen.toString());
		
		List<String> sortLenReverse = sortMe.stream().
				sorted(byLen.reversed()).
				collect(Collectors.toList());
		System.out.println(sortLenReverse.toString());
		
		Comparator<String> byChar = (str1, str2) -> str1.charAt(0) - str2.charAt(0);
		List<String> sortChar = sortMe.stream().
				sorted(byChar).
				collect(Collectors.toList());
		System.out.println(sortChar.toString());
		
		Comparator<String> byE = (str1, str2) -> str1.charAt(0) == 'e' || str1.charAt(0) ==  'E'? -1 : 1;
		List<String> sortE = sortMe.stream().
				sorted(byE).
				collect(Collectors.toList());
		System.out.println(sortE.toString());
		
		List<String> sortEAgain = sortMe.stream().
				collect(Collectors.toList());
		sortEAgain.sort(byE);
		System.out.println(sortEAgain.toString());		
	}
}
