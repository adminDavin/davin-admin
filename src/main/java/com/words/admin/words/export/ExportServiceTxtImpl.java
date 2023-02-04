package com.words.admin.words.export;
 
import java.net.URLEncoder;

import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.itextpdf.text.pdf.ByteBuffer;

import jodd.json.JsonArray;
import jodd.json.JsonObject;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ExportServiceTxtImpl implements ExportService {
	
	private ByteBuffer content;
	private String type;

	
	public ExportServiceTxtImpl(String type) {
		super();
		this.type = type;
		content = new ByteBuffer();
	}
 

	@Override
	public void docClose() {
		
	}

	@Override
	public void setTableForWordsExport(JsonArray tabCon) throws Exception {
		var i = 0;
		for (Object item : tabCon) {
        	var t = tabCon.size() == i ? "": endswith;
        	i++;
        	JsonObject wordsInfo = (JsonObject) item;
        	String row = ExportUtils.getRowFormat(wordsInfo, separator, t);
        	log.info(wordsInfo);
        	if (row == null) {
        		continue;
        	}
        	content.append(row.getBytes(characterSet));
        }
	}
	@Override
	public void setTableForWordsExport(ArrayNode tabCon) throws Exception {
		var i = 0;
        for (JsonNode item : tabCon) {
        	var t = tabCon.size() == i ? "": endswith;
        	i++;
        	String row = ExportUtils.getRowFormat(item, separator, t);
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
