package com.words.admin.words.service;

import javax.servlet.http.HttpServletResponse;

public interface WordsAdminService {
	public void getServiceTest();

	public String addDocumentInfo(HttpServletResponse response, String name, String newName, String orginalFileName);
}
