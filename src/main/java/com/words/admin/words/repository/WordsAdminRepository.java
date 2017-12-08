package com.words.admin.words.repository;

import java.util.List;
import java.util.Map;

import com.words.admin.words.bean.DocumentInfo;
import com.words.admin.words.bean.WordsInfo;

public interface WordsAdminRepository {
	public Map<String, String[]> getUserInfo() throws Exception;

	public int insertDocumentInfo(DocumentInfo documentInfo);

	public WordsInfo getWordsInfoText(WordsInfo wordsInfo);

	public int insertWordsInfo(WordsInfo wordsInfo);

	public int deleteWordsById(int wordsId);

	public int getDocuCountByUuid(String uuid);

	public List<WordsInfo> getWordsInfoList(WordsInfo wordsInfo);

}
