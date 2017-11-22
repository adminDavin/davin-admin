package com.kingword.common.filehandle;

import java.io.IOException;

public class DemoTest {
	
	public static void main(String[] args) {
		FileHandle fileHandle=new HandlePdf();
		try {
			String textPath=fileHandle.fileHandle("E:\\oracle\\kingword\\WebRoot\\KW\\123.pdf", null);
			System.out.println("------------------------------------------------------");
			System.out.println("------------------------------------------------------");
			System.out.println("------------------------------------------------------");
			System.out.println("------------------------------------------------------");
			System.out.println("------------------------------------------------------");
			System.out.println("------------------------------------------------------"+textPath);
			System.out.println(CountString.count(textPath, "½è"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
