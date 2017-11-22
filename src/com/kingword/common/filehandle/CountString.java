package com.kingword.common.filehandle;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountString {
	public static int count(String filename, String target) throws FileNotFoundException, IOException {  
		   InputStreamReader isr;
		   isr = new InputStreamReader(new FileInputStream(filename), "utf-8"); 
		   BufferedReader br = new BufferedReader(isr); 
		   StringBuilder strb = new StringBuilder();  
		   while (true) {  
			    String line = br.readLine();  
			    if (line == null) {  
			    	break;  
			    }  
			    strb.append(line);  
		   }  
		   String result = strb.toString();  
		   int count = 0;  
		   int index = 0;  
		   while (true) {  
		    index = result.indexOf(target, index + 1);  
		    if (index > 0) {  
		     count++;  
		    } else {  
		     break;  
		    }  
		   }  
		   br.close();  
		   return count;  
	}  
}
