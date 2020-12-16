// Calculates the maximum value in a 2D array
package com.ss.sf.maxdd;

import java.util.Arrays;

public class Max2D {
	
	public static void main(String[] args){
		Max2D ex1 = new Max2D();
		int[][] arr = ex1.RandArray(3,3);	
		int[] maxList = ex1.calcMax(arr);
		System.out.println("The maximum value is: "+maxList[0]+" at position ("+maxList[1]+", "+maxList[2]+")");
		
	}
	
	public int[] calcMax(int[][] arr){
		int max = arr[0][0];
		int idx1  = 0;
		int idx2 = 0;
		for(int i = 0; i < arr.length; i++){
			for(int j = 0; j < arr[i].length; j++){
				if(arr[i][j] > max){
					max = arr[i][j];
					idx1 = i;
					idx2 = j;
				}
			}
		}
		int[] maxList = {max, idx1, idx2};
		return maxList;
	}
	public int[][] RandArray(int m, int n){
		// Creates a random 2D array with specified dimensions
		int[][] arr = new int[m][n];
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				arr[i][j] = (int)(Math.random()*10);
			}
		}		
		return arr;
	}
}
