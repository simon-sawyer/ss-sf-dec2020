package com.ss.sf.append;

// Appends text to a file
import java.io.IOException;
import java.io.FileWriter;

public class AppendText {
	
	public static void main(String[] args){
		try{
			FileWriter writeTo = new FileWriter("myFile.txt", true);
			writeTo.write("And here's more text in the file!");
			writeTo.close();
		}catch(IOException e){
			System.out.println("An error occurred");
			e.printStackTrace();
		}
		
	}
}
