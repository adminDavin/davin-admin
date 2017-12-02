package com.words.admin.words.repository;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.words.admin.words.bean.DocumentInfo;

@Repository("wordsAdminRepository")
public class WordsAdminRepositoryImpl implements WordsAdminRepository {
	@Autowired(required = true)
	private SqlSessionFactory sqlSessionFactory;

	public Map<String, String[]> getUserInfo() throws Exception {
		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
			return sqlSession.selectOne("manage.getAppName");
		}
	}

	@Override
	public int insertDocumentInfo(DocumentInfo documentInfo) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
			int docuId = sqlSession.insert("words.insertDocumentInfo", documentInfo);
			sqlSession.commit();
			return docuId;
		}
	}

}
