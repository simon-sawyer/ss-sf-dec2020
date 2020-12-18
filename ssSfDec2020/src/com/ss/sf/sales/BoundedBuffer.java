package com.ss.sf.sales;

// Bounded Buffer for salesBuffer class

public class BoundedBuffer {
	private static int[] buffer;
	private static int bufSize;
	
	public BoundedBuffer(int size){
		bufSize = size;
		buffer = new int[bufSize];
	}
	
	public int getItem(int idx){
		if(idx > bufSize){
			return buffer[idx];
		}
		else{
			return -1;
		}
	}
	
	public int pullItem(int idx){
		if(idx < bufSize){
			int temp = buffer[idx];
			buffer[idx] = 0;
			return temp;
		}
		else{
			return -1;
		}
	}
	
	public int pushItem(int itemNum){
		for(int i = 0; i < bufSize; i++){
			if(buffer[i] == 0){
				buffer[i] = itemNum;
				return 1;
			}
		}
		return -1;
	}
	public int getBufSize(){
		return bufSize;
	}
	
}
