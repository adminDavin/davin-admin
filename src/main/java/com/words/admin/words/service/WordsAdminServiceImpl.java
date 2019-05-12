package com.words.admin.words.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import com.web.response.RespUtils;
import com.words.admin.config.Constant;
import com.words.admin.words.bean.DocumentInfo;
import com.words.admin.words.bean.WordsInfo;
import com.words.admin.words.repository.WordsAdminRepository;

import jodd.json.JsonArray;
import jodd.json.JsonObject;

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
	public String addDocumentInfo(HttpServletResponse response, int userId, String name, String newName,
			String orginalFileName) {
		DocumentInfo documentInfo = new DocumentInfo();
		documentInfo.setName(name);
		documentInfo.setOriginalName(orginalFileName);
		documentInfo.setUuid(newName);
		documentInfo.setUserId(userId);
		try {
			return String.valueOf(wordsAdminRepository.insertDocumentInfo(documentInfo));
		} catch (Exception e) {
			e.printStackTrace();
			RespUtils.responseJsonFailed(response, "user is register failed for insert database!");
			return null;
		}
	}

	@Override
	public String addWordsInfo(HttpServletResponse response, Map<String, String[]> map) {
		WordsInfo wordsInfo = new WordsInfo();
		try {
			String docId = map.get(Constant.WORDSDOCID)[0];
			wordsInfo.setDocId(Integer.parseInt(docId));
			String userId = map.get(Constant.USERID)[0];
			wordsInfo.setUserId(Integer.parseInt(userId));
			String initPage = map.get(Constant.INITPAGE)[0];
			wordsInfo.setInitPage(Integer.parseInt(initPage));
			String pageNum = map.get(Constant.PAGENUM)[0];
			wordsInfo.setPageNum(Integer.parseInt(pageNum));
			wordsInfo.setTextContent(map.get(Constant.TEXTCONTENT)[0]);
		} catch (Exception e) {
			e.printStackTrace();
			RespUtils.responseJsonFailed(response, "words add failed for error message!");
			return null;
		}

		try {
			WordsInfo words = wordsAdminRepository.getWordsInfoText(wordsInfo);
			if (words == null) {
				int wordsId = wordsAdminRepository.insertWordsInfo(wordsInfo);
				return String.valueOf(wordsId);
			} else {
				JsonObject result = new JsonObject();
				result.put("data", words.getJsonInfo());
				result.put("existsFlag", true);
				result.put("message", "words add success");
				RespUtils.responseJsonSuccess(response, result);
			}
		} catch (Exception e) {
			e.printStackTrace();
			RespUtils.responseJsonFailed(response, "words is add failed for user is invalid!");
			return null;
		}
		return null;
	}

	@Override
	public String deleteWordsById(HttpServletResponse response, int wordsId) {
		try {
			int words = wordsAdminRepository.deleteWordsById(wordsId);
			return String.valueOf(words);
		} catch (Exception e) {
			e.printStackTrace();
			RespUtils.responseJsonFailed(response, "words is add failed for user is invalid!");
			return null;
		}

	}

	@Override
	public boolean getDocuByUuid(String uuid) {
		try {
			if (wordsAdminRepository.getDocuCountByUuid(uuid) == 0) {
				return false;
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public JsonArray getWordsInfo(HttpServletResponse response, Map<String, String[]> map, int state) {
		WordsInfo wordsInfo = new WordsInfo();
		try {
			String docId = map.get(Constant.WORDSDOCID)[0];
			wordsInfo.setDocId(Integer.parseInt(docId));
			String userId = map.get(Constant.USERID)[0];
			wordsInfo.setUserId(Integer.parseInt(userId));
			wordsInfo.setState(state);
		} catch (Exception e) {
			e.printStackTrace();
			RespUtils.responseJsonFailed(response, "words exports for error message!");
			return null;
		}
		try {
			List<WordsInfo> words = wordsAdminRepository.getWordsInfoList(wordsInfo);
			JsonArray jsonArray = new JsonArray();
			for (WordsInfo item : words) {
				item.setPageNum((item.getPageNum() + item.getInitPage()));
				jsonArray.add(item.getJsonInfo());
			}
			if (jsonArray.size() == 0) {
				RespUtils.responseJsonFailed(response, "words list is empty!");
				return null;
			}
			return jsonArray;
		} catch (Exception e) {
			e.printStackTrace();
			RespUtils.responseJsonFailed(response, "words list failed for database failed!");
			return null;
		}
	}

	@Override
	public JsonArray getListWords(HttpServletResponse response, int userId, int docId, int state) {
		WordsInfo wordsInfo = new WordsInfo();
		try {
			wordsInfo.setDocId(docId);
			wordsInfo.setUserId(userId);
			wordsInfo.setState(state);
		} catch (Exception e) {
			e.printStackTrace();
			RespUtils.responseJsonFailed(response, "words exports for error message!");
			return null;
		}
		try {

			List<WordsInfo> words = wordsAdminRepository.getWordsInfoList(wordsInfo);
			JsonArray jsonArray = new JsonArray();
			for (WordsInfo item : words) {
				jsonArray.add(item.getJsonInfo());
			}
			return jsonArray;
		} catch (Exception e) {
			e.printStackTrace();
			RespUtils.responseJsonFailed(response, "words list failed for database failed!");
			return null;
		}
	}

	@Override
	public JsonArray listDocument(HttpServletResponse response, int userId, int state) {
		// TODO Auto-generated method stub
		DocumentInfo beanInfo = new DocumentInfo();
		try {
			beanInfo.setUserId(userId);
			beanInfo.setState(state);
		} catch (Exception e) {
			e.printStackTrace();
			RespUtils.responseJsonFailed(response, "params has error for error message!");
			return null;
		}
		try {
			List<DocumentInfo> words = wordsAdminRepository.getDocuInfoList(beanInfo);
			JsonArray jsonArray = new JsonArray();
			for (DocumentInfo item : words) {
				jsonArray.add(item.getJsonInfo());
			}
			if (jsonArray.size() == 0) {
				RespUtils.responseJsonFailed(response, "docu list is empty!");
				return null;
			}
			return jsonArray;
		} catch (Exception e) {
			e.printStackTrace();
			RespUtils.responseJsonFailed(response, "words list failed for database failed!");
			return null;
		}
	}

}
