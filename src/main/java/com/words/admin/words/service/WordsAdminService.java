package com.words.admin.words.service;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

public interface WordsAdminService {
	public void getServiceTest();

	public String addDocumentInfo(HttpServletResponse response, String name, String newName, String orginalFileName);

	public String addWordsInfo(HttpServletResponse response, Map<String, String[]> wordsInfoMap);

	public String deleteWordsById(HttpServletResponse response, int wordsId);
}
