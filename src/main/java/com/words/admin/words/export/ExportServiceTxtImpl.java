package com.words.admin.words.export;
 
import com.lowagie.text.pdf.ByteBuffer;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;

import jodd.json.JsonArray;
import jodd.json.JsonObject;

public class ExportServiceTxtImpl implements ExportService {
	private ByteBuffer content;
	private String type;

	
	public ExportServiceTxtImpl(String type) {
		super();
		this.type = type;

	}
 

	@Override
	public void docClose() {
		
	}

	@Override
	public void setTableForWordsExport(JsonArray tabCon) throws Exception {
        for (Object item : tabCon) {
        	JsonObject wordsInfo = (JsonObject) item;
        	String row = ExportUtils.getRowFormat(wordsInfo, separator, endswith);
        	content.append(row.getBytes(characterSet));
        }
	}
	
	@Override
	public byte[] getDocContent() {
		return content.getBuffer();
	}
 
	public ByteBuffer getContent() {
		return content;
	}

	public void setContent(ByteBuffer content) {
		this.content = content;
	}

	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	@Override
	public void setResponse(HttpServletResponse response, String fileName) throws Exception {
		response.setContentType("text/plain");
		String fileNameEncode = URLEncoder.encode(fileName+ ".txt", characterSet);
		response.setHeader("content-disposition", "attachment;filename=" + fileNameEncode);
 		FileCopyUtils.copy(content.getBuffer(), response.getOutputStream());
	}
}
