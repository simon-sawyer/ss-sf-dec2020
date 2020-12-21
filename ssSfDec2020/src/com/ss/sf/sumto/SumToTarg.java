package com.ss.sf.sumto;

import java.util.Arrays;

public class SumToTarg {
	
	public static void main(String[] args){
		SumToTarg test1 = new SumToTarg();
		int[] testList = new int[] {1, 2, 3, 4};
		System.out.println(test1.sumToTarg(testList, 11));
		
	}

	public boolean sumToTarg(int[] toSum, int targ){
		toSum = clumpAlike(toSum);
		
		for(int e : toSum){
			if(e == targ){
				return true;
			}
		}
		
		int[][] sumK = new int[toSum.length][toSum.length];
		for(int i = 0; i < toSum.length; i++){
			for(int j = i; j < toSum.length; j++){
				sumK[i][j] += toSum[i];
			}
		}
		
		for(int k = 1; k < toSum.length; k++){
			for(int i = 0; i < toSum.length-k; i++){
				for(int j = i + 1; j < toSum.length; j++){
					try{
						sumK[i][j] += toSum[j + k - 1];
					}catch(ArrayIndexOutOfBoundsException e){
						sumK[i][j] += toSum[i + 2 + k - j];
					}
					if(sumK[i][j] == targ){
						System.out.println(Arrays.deepToString(sumK));
						return true;
					}
					System.out.println(Arrays.deepToString(sumK));
					System.out.println("i: "+ i + " j: " + j + " k: " + k);
				}

			}

		}
		
		return false;
	}
	
	public int[] clumpAlike(int[] toSum){
		int window = 0;
		if(toSum.length == 1){
			return toSum;
		}
		for(int i = 0; i < toSum.length; i++){
			if(i + 1 < toSum.length){
				if(toSum[i+1] == toSum[i]){
					window ++;
				}else{
					for(int j = 0; j < window; j++){
						toSum[i-window] += toSum[i-j];
						toSum[i-j] = 0;
					}
					window = 0;
				}
			}else{
				if(toSum[i] == toSum[i-1]){
					for(int j = 0; j < window; j++){
						toSum[i-window] += toSum[i-j];
						toSum[i-j] = 0;
					}
				}else{
					for(int j = 0; j < window; j++){
						toSum[i-window-1] += toSum[i-j-1];
						toSum[i-j-1] = 0;
					}
				}
			}
		}
		return toSum;
	}
}
