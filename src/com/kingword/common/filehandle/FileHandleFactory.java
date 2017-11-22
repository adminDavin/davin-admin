package com.kingword.common.filehandle;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class FileHandleFactory {
	public String getFileHandle(String filePath, String nameType) throws FileNotFoundException{
		String tmpPath="";
		FileHandle fileHandle=null;
		fileHandle=new HandlePdf();
		try {
			tmpPath=fileHandle.fileHandle(filePath, nameType);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return tmpPath;
	}
	public static Map<Integer, Integer> getFileHandleOnHand(String filePath, String nameType,String onHandKingWord) throws FileNotFoundException{
		Map<Integer, Integer> map=new HashMap<Integer, Integer>();
		FileHandle fileHandle=null;

		fileHandle=new HandlePdf();
		try {
			map=fileHandle.fileHandle(filePath, nameType,onHandKingWord);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return map;
	}
}
