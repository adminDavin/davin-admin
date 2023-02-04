package com.words.admin.words.export;


import com.fasterxml.jackson.databind.JsonNode;
import com.t.zero.doc.words.config.Constant;

import jodd.json.JsonObject;

public class ExportUtils {
	public static String getRowFormat(JsonObject wordsInfo, String separator, String endswith) {
		String word = wordsInfo.getString(Constant.TEXTCONTENT);
		Integer pageNum = wordsInfo.getInteger(Constant.PAGENUM) + wordsInfo.getInteger(Constant.INITPAGE);
		return String.format("%s" + separator + "%d" + endswith, word, pageNum);
	}
	
	public static String getRowFormat(JsonNode wordsInfo, String separator, String endswith) {
		String word = wordsInfo.get("textcontent").asText();
		Integer pageNum = wordsInfo.get("pagenum").asInt() + wordsInfo.get("initpage").asInt();
		return String.format("%s" + separator + "%d" + endswith, word, pageNum);
	}
}
