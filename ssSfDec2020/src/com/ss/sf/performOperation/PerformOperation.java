package com.ss.sf.performOperation;

// Uses lambda functions to perform specific operations on 

import java.util.stream.IntStream;

public class PerformOperation {
	
	public getOdd refOdd(){		
		return (n) -> n % 2 == 1;
	}
	
	public getPrime refPrime(){
		return (n) -> (n > 1 &&
				IntStream.range(2, (int)Math.sqrt(n) + 1).
				filter((m) -> n % m == 0).
				count() == 0);
	}
	
	public getPalindrome refPalindrome(){
		return (n) -> {
			String nStr = n.toString();
			for(int i = 0; i < nStr.length()/2; i ++){
				if(nStr.charAt(i) != nStr.charAt(nStr.length() - 1 - i)){
					return false;
				}
			}
			return true;
		};
	}

}
