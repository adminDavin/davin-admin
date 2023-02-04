package com.words.admin.words.export;

import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.node.ArrayNode;

import jodd.json.JsonArray;

public interface ExportService {
	public static String separator = ";";
	public static String endswith = "\r\n";
	public static String characterSet = "UTF-8";
	public void docClose();

	public void setTableForWordsExport(JsonArray tabCon) throws Exception;
	public void setTableForWordsExport(ArrayNode tabCon) throws Exception;

	public byte[] getDocContent();

	public void setResponse(HttpServletResponse response, String fileName) throws Exception;
}
