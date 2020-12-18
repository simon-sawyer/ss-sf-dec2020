package com.ss.sf.deadlock;

// Creates a deadlock between Thread1 and Thread2

public class Deadlock {

	public static void main(String[] args){
		Integer sum1 = new Integer(0);
		Integer sum2 = new Integer(0);
		
		Runnable t1 = new Runnable(){
			@Override
			public void run(){
				try{
					synchronized(sum1){
						System.out.println("Thread 1 locked sum1");
						Thread.sleep(100);
						synchronized(sum2){
							System.out.println("Tread 1 accessed sum2");
						}
					}
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		};
		
		Runnable t2 = new Runnable(){
			@Override
			public void run(){
				try{
					synchronized(sum2){
						System.out.println("Thread 2 locked sum2");
						Thread.sleep(100);
						synchronized(sum1){
							System.out.println("Tread 2 accessed sum1");
						}
					}
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		};
		new Thread(t1).start();
		new Thread(t2).start();

	}
	
}
