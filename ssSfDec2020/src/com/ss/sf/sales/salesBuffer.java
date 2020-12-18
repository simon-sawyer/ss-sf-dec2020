package com.ss.sf.sales;

// Manages a buffer between a producer and a consumer

public class salesBuffer {
	
	public static void main(String[] args){
		
		BoundedBuffer buffer = new BoundedBuffer(10);
		
		Runnable producer = new Runnable(){
			// Adds 10 products to the buffer, waiting when full
			@Override
			public void run(){
				synchronized(buffer){
					try{
						System.out.println("Producer initiated");
						int i = 1;
						int prodNum = 1;
						while(prodNum < buffer.getBufSize()){
							while(i > 0){
								i = buffer.pushItem(prodNum);
								if(i > 0){
									System.out.println("Product added: "+prodNum);
								}
								prodNum++;
							}
						}
					}catch(Exception e){
						e.printStackTrace();
					}
				}
			}
		};
		
		Runnable consumer = new Runnable(){
			// Removes items from buffer
			@Override
			public void run(){
				synchronized(buffer){
					try{
						System.out.println("Consumer initiated");
						int itemCount = 0;
						while(itemCount < buffer.getBufSize()){
							System.out.println("Block executed");
							for(int i = 0; i < buffer.getBufSize(); i++){
								int num = buffer.pullItem(i);
								System.out.println("Product purchased "+num);
								itemCount++;
							}
						}												
					}catch(Exception e){
						e.printStackTrace();
					}
				}
			}
		};
		new Thread(producer).start();
		new Thread(consumer).start();		
	}	
}
