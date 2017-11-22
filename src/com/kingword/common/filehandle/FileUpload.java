package com.kingword.common.filehandle;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.kingword.controller.kingServ.KingWordServ;
import com.kingword.controller.kingServ.RelDocuWordServ;
import com.kingword.entity.kingword.DocuMessage;
import com.kingword.entity.kingword.KingWord;
import com.kingword.entity.kingword.RelationDocuWord;
public class FileUpload {
	
	@SuppressWarnings("unchecked")
	public  Map<String, String> doPost(HttpServletRequest request, KingWordServ kingWordServ, 
										RelDocuWordServ relationDocuWordServ,
										DocuMessage docuMessage) throws ServletException, IOException {
		
		String fileName = "";
		String nameType="";
		String filePath="";
		String tmpPath="";
		String relativePath="";
		String savePath="";
		int wcount=0;
		@SuppressWarnings("unused")
		String extName = "";
		String name="";
		List<FileItem> fileList = null;
		DiskFileItemFactory fac =null;
		ServletFileUpload upload=null;
		File file = null;
		String newFileName="";
		Map<String, String> map=new HashMap<String, String>();
		//�����ļ����·��
		request.setCharacterEncoding("UTF-8");
		savePath = this.getClass().getClassLoader().getResource("/").
				getPath().replace("/WEB-INF/classes/", "");
		relativePath= "/UploadsFolderUUID/" + UUID.randomUUID().toString().replaceAll("-", "").toUpperCase() +"/";
		savePath = savePath + relativePath;
		
		//�½��ļ�·��
		File f1 = new File(savePath);
		if (!f1.exists()) {
			f1.mkdirs();
		}
		
		fac = new DiskFileItemFactory();
		upload = new ServletFileUpload(fac);
		upload.setHeaderEncoding("utf-8");
		try {
			fileList = upload.parseRequest(request);
		} catch (FileUploadException ex) {
			return map;
		}
		Iterator<FileItem> it = fileList.iterator();
		while (it.hasNext()) {
			FileItem item = it.next();
			if (!item.isFormField()) {
				nameType = item.getContentType();
				fileName = item.getName();
				
				if (fileName == null || fileName.trim().equals("")) {
					continue;
				}
				if (fileName.lastIndexOf(".") >= 0) {
					extName = fileName.substring(fileName.lastIndexOf("."));
				}
				
				
				name = fileName.substring(fileName.lastIndexOf("/")+1);  
				System.out.println(name+"********************************************************s");
				name = name.substring(name.lastIndexOf("\\")+1);  
				System.out.println(name);
				
				Date dt= new Date();
				Long time= dt.getTime();
				newFileName="f"+time.toString()+name.substring(name.lastIndexOf("."));
				System.out.println(newFileName);
				filePath=savePath + newFileName;
				do {
					file = new File(filePath);
				} while (file.exists());

				File saveFile = new File(filePath);
				try {
					item.write(saveFile);
				} catch (Exception e) {
					e.printStackTrace();
				}
				//
				map.put( "relative_path",relativePath);
				map.put("fileName",fileName);
				map.put("newfileName",newFileName);
				map.put("nameType",nameType );
				RelationDocuWord rkd=new RelationDocuWord();
				tmpPath=new FileHandleFactory().getFileHandle(savePath+newFileName,nameType);
				List<KingWord> listKingWord=kingWordServ.findAllKingWord();
				for (KingWord kingWord1 : listKingWord) {
					try {
						rkd=new RelationDocuWord();
						rkd.setDocuMessage(docuMessage);
						rkd.setKingWordId(kingWord1.getKingWordId());
						rkd.setKingWordName(kingWord1.getWordName());
						rkd.setCreateDate(new Timestamp(dt.getTime()));
					    wcount=0;
					    wcount=CountString.count(tmpPath, kingWord1.getWordName());
					    rkd.setKingWordCount((long) wcount);
					    if(wcount!=0){
					    	relationDocuWordServ.save(rkd);
					    }
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		 
		return map; 
	}
}
