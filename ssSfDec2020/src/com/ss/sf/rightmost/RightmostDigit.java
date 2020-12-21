package com.ss.sf.rightmost;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// Modifies a list of integers to include only the rightmost digit

public class RightmostDigit {
	
	public List<Integer> rightMost(ArrayList<Integer> modMe){
		List<Integer> right = modMe.stream().
				map(e -> (e % (Integer)10)).
				collect(Collectors.toList());
		return right;
	}
	
}
