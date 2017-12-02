package com.words.admin.words.service;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import com.web.response.RespUtils;
import com.words.admin.words.bean.DocumentInfo;
import com.words.admin.words.repository.WordsAdminRepository;

@SessionScope
@Service("wordsAdminService")
public class WordsAdminServiceImpl implements WordsAdminService {
	@Autowired(required = true)
	private WordsAdminRepository wordsAdminRepository;

	@Override
	public void getServiceTest() {
		System.out.println("test is success");

	}

	@Override
	public String addDocumentInfo(HttpServletResponse response, String name, String newName, String orginalFileName) {
		DocumentInfo documentInfo = new DocumentInfo();
		documentInfo.setName(name);
		documentInfo.setOriginalName(orginalFileName);
		documentInfo.setUuid(newName);
		// if (userId == 0) {
		// RespUtils.responseJsonFailed(response, "user is not login!");
		// return null;
		// } else {
		// documentInfo.setUserId(userId);
		// }
		try {
			return String.valueOf(wordsAdminRepository.insertDocumentInfo(documentInfo));
		} catch (Exception e) {
			e.printStackTrace();
			RespUtils.responseJsonFailed(response, "user is register failed for insert database!");
			return null;
		}

	}

}
