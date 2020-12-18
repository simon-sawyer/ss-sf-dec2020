package com.ss.sf.singleton;

// Demonstrates use of singleton class with double checked locking

public class Singleton {

	private static volatile Singleton instance;
	
	public static Singleton getInstance(){
		if(instance != null){
			return instance;
		}else{
			synchronized(Singleton.class){
				instance = new Singleton();
				return instance;
			}
		}
	}
}