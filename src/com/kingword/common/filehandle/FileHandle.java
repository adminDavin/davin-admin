package com.kingword.common.filehandle;

import java.io.IOException;
import java.util.Map;




public interface FileHandle {

	String fileHandle(String filePathName, String fileType)  throws IOException ;

	Map<Integer, Integer> fileHandle(String filePath, String nameType, String onHandKingWord) throws IOException ;

}
