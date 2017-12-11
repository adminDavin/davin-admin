package com.words.admin.words.service;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import jodd.json.JsonArray;

public interface WordsAdminService {
	public void getServiceTest();

	public String addDocumentInfo(HttpServletResponse response, String name, String newName, String orginalFileName);

	public String addWordsInfo(HttpServletResponse response, Map<String, String[]> wordsInfoMap);

	public String deleteWordsById(HttpServletResponse response, int wordsId);

	public boolean getDocuByUuid(String uuid);

	public JsonArray getWordsInfo(HttpServletResponse response, Map<String, String[]> exportWordsMap, int state);

	public JsonArray getListWords(HttpServletResponse response, int userId, int docId, int state);

	public JsonArray listDocument(HttpServletResponse response, int userId, int state);
}
