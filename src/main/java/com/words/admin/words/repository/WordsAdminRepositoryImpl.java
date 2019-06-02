package com.words.admin.words.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.words.admin.words.bean.DocumentInfo;
import com.words.admin.words.bean.WordsInfo;

@Repository("wordsAdminRepository")
public class WordsAdminRepositoryImpl implements WordsAdminRepository {
	@Autowired
	private SqlSessionFactory sqlSessionFactory;

	public Map<String, String[]> getUserInfo() throws Exception {
		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
			return sqlSession.selectOne("manage.getAppName");
		}
	}

	@Override
	public int insertDocumentInfo(DocumentInfo documentInfo) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
			sqlSession.insert("words.insertDocumentInfo", documentInfo);
			sqlSession.commit();
			return documentInfo.getDocId();
		}
	}

	@Override
	public WordsInfo getWordsInfoText(WordsInfo wordsInfo) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
			return sqlSession.selectOne("words.getWordsInfoText", wordsInfo);
		}
	}

	@Override
	public int insertWordsInfo(WordsInfo wordsInfo) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
			sqlSession.insert("words.insertWordsInfo", wordsInfo);
			sqlSession.commit();
			return wordsInfo.getWordsId();
		}
	}

	@Override
	public int deleteWordsById(int wordsId) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
			int docuId = sqlSession.delete("words.deleteWordsById", wordsId);
			sqlSession.commit();
			return docuId;
		}
	}

	@Override
	public int getDocuCountByUuid(String uuid) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
			return sqlSession.selectOne("words.getDocuCountByUuid", uuid);
		}
	}

	@Override
	public List<WordsInfo> getWordsInfoList(WordsInfo wordsInfo) {
		if (wordsInfo.getState() == 5) {
			try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
				return sqlSession.selectList("words.getWordsInfoListAll", wordsInfo);
			}
		} else {
			try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
				return sqlSession.selectList("words.getWordsInfoList", wordsInfo);
			}
		}
	}

	@Override
	public List<DocumentInfo> getDocuInfoList(DocumentInfo beanInfo) {
		if (beanInfo.getState() == 5) {
			try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
				return sqlSession.selectList("words.getDocuInfoListAll", beanInfo);
			}
		} else {
			try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
				return sqlSession.selectList("words.getDocuInfoList", beanInfo);
			}
		}
	}
	
	@Override
	public void updateDocumentStatus(String uuId) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
			sqlSession.update("words.updateDocument", uuId);
			sqlSession.commit();
		}
	}

}
