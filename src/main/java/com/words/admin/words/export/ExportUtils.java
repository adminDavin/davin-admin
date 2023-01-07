package com.words.admin.words.export;


import com.t.zero.doc.words.config.Constant;

import jodd.json.JsonObject;

public class ExportUtils {
	public static String getRowFormat(JsonObject wordsInfo, String separator, String endswith) {
		String word = wordsInfo.getString(Constant.TEXTCONTENT);
		Integer pageNum = wordsInfo.getInteger(Constant.PAGENUM) + wordsInfo.getInteger(Constant.INITPAGE);
		return String.format("%s" + separator + "%d" + endswith, word, pageNum);
	}
}
