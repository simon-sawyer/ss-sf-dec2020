package com.ss.sf.doubling;

// Doubles all of the integers in a list

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Doubling {

	public List<Integer> doubling(ArrayList<Integer> doubleMe){
		return doubleMe.stream().
				map(e-> e*2).
				collect(Collectors.toList());
		
	}
}
