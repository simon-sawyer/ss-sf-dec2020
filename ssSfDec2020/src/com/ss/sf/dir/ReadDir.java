package com.ss.sf.dir;

// Lists all of the files in a directory

import java.io.File;
import java.util.Arrays;

public class ReadDir {
	
	public static void main(String[] args){
		ReadDir cur = new ReadDir();
		System.out.println(Arrays.toString(cur.dirList()));
		
	}
	public String[] dirList(String dirPath){
		//Lists the files in the specified directory
		File folder = new File(dirPath);
		return folder.list();
	}
	
	public String[] dirList(){
		//Lists the files in working directory
		String dirPath = System.getProperty("user.dir");
		File folder = new File(dirPath);
		return folder.list();
	}
}
