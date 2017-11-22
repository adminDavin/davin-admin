package com.kingword.common.filehandle;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

  


 import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;


public class FileUploadHand {
	
 	public  Map<String, String> doPost(HttpServletRequest request) throws ServletException, IOException {
		String fileName = "";
		String nameType="pdf";
 		String relativePath="";
		String savePath="";
		String name="";
 		String newFileName="";
		Map<String, String> map=new HashMap<String, String>();
		//�����ļ����·��
		request.setCharacterEncoding("UTF-8");
		savePath = this.getClass().getClassLoader().getResource("/").
				getPath().replace("/WEB-INF/classes/", "");
		relativePath= "/UploadsFolderUUID/" + UUID.randomUUID().toString().replaceAll("-", "").toUpperCase() +"/";
		savePath = savePath + relativePath;
		File f1 = new File(savePath);
		if (!f1.exists()) {
			f1.mkdirs();
		}
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());  
        //判断 request 是否有文件上传,即多部分请求  
        if(multipartResolver.isMultipart(request)){  
        	System.out.println("开始上传文件"+savePath);
            //转换成多部分request    
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;  
            //取得request中的所有文件名  
            Iterator<String> iter = multiRequest.getFileNames();  
            while(iter.hasNext()){ 
            	
                //记录上传过程起始时的时间，用来计算上传时间  
                int pre = (int) System.currentTimeMillis();  
                //取得上传文件  
                MultipartFile file1 = multiRequest.getFile(iter.next());  
                if(file1 != null){  
                    //取得当前上传文件的文件名称  
                    String myFileName = file1.getOriginalFilename();  
              
                    nameType=file1.getContentType();
                    //如果名称不为“”,说明该文件存在，否则说明该文件不存在  
                    if(myFileName.trim() !=""){  
                        System.out.println(myFileName);  
                        //重命名上传后的文件名  
                        fileName =  file1.getOriginalFilename(); 
         				if (fileName == null || fileName.trim().equals("")) {
         					continue;
         				}
         				if (fileName.lastIndexOf(".") >= 0) {
         					@SuppressWarnings("unused")
							String extName = fileName.substring(fileName.lastIndexOf("."));
         				}
         				name = fileName.substring(fileName.lastIndexOf("/")+1);  
         				name = name.substring(name.lastIndexOf("\\")+1);  
         				
         				Date dt= new Date();
         				Long time= dt.getTime();
         				newFileName="f"+time.toString()+name.substring(name.lastIndexOf("."));
                        //定义上传路径  
                        String path = savePath + newFileName;  
                        File localFile = new File(path);  
                        try {
							file1.transferTo(localFile);
						} catch (IllegalStateException | IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}  
                    }  
                    map.put( "relativePath",relativePath);
					System.out.println("****************************"+relativePath);
					System.out.println("****************************"+savePath);
					System.out.println("****************************"+newFileName);
					System.out.println("****************************"+nameType);
					map.put("fileName",fileName);
					map.put("savePath",savePath);
					map.put("newfileName",newFileName);
					map.put("nameType",nameType );

                }  
                //记录上传该文件后的时间  
                int finaltime = (int) System.currentTimeMillis();  
                System.out.println(finaltime - pre);  
            }  
              
        }  
		
	   	System.out.println("dddddddddddddddddddddddddddd"+relativePath+"ddddddffffffffffffffffffffffffffffffffff");

		
		 
	 
		return map; 
	}
}
