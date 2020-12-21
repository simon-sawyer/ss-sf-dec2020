package com.ss.sf.removechar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// Removes all instances of the letter 'x' from a list of strings

public class RemoveX {
	
	public List<String> remove(ArrayList<String> toRemove){
		
		return toRemove.stream().
				map(e -> removeStr(e)).
				collect(Collectors.toList());		
	}
	
	public String removeStr(String toRemove){
		for(int i = 0; i < toRemove.length(); i++){
			if(toRemove.charAt(i) == 'x'){
				if(i+1 == toRemove.length()){
					return toRemove.substring(0, i);
				}
				toRemove = toRemove.substring(0, i) + toRemove.substring(i+1, toRemove.length());
			}
		}
		return toRemove;
	}
}
