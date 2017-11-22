package com.kingword.common.filehandle;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

 
public class FileUploadHandWord {

	private Map<String, String> map;

	public Map<String, String> dofilehand(HttpServletRequest request) throws ServletException, IOException {
		String relativePath="";
		String savePath="";
		savePath = this.getClass().getClassLoader().getResource("/").getPath().replace("/WEB-INF/classes/", "");
		relativePath= "/UploadsFolderUUID/" + UUID.randomUUID().toString().replaceAll("-", "").toUpperCase() +"/";
		savePath = savePath + relativePath;
		FileUploadToLocal fileUploadToLocal=new FileUploadToLocal();
		fileUploadToLocal.fileDirCheck(savePath);
		System.out.println("存放文件的目录为："+savePath);
		map=fileUploadToLocal.uploadFile(request,savePath,relativePath);
		for (Entry<String, String> entry : map.entrySet()) {  
		    System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());  				  
		}
		System.out.println("------------------------------------------------------------");
		map=fileUploadToLocal.fileTrunfer("pdf",map);
		for (Entry<String, String> entry : map.entrySet()) {  
		    System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());  				  
		}
		return map; 

	}

}
