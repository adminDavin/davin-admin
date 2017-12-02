package com.words.admin.words.repository;

import java.util.Map;

import com.words.admin.words.bean.DocumentInfo;

public interface WordsAdminRepository {
	public Map<String, String[]> getUserInfo() throws Exception;

	public int insertDocumentInfo(DocumentInfo documentInfo);

}
