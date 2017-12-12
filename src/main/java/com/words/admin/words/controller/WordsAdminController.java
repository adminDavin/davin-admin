package com.words.admin.words.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.multipart.MultipartFile;

import com.web.response.RespUtils;
import com.words.admin.Utils.ReadFile;
import com.words.admin.Utils.Utils;
import com.words.admin.Utils.ValiedParams;
import com.words.admin.config.Constant;
import com.words.admin.words.export.ExportFactory;
import com.words.admin.words.export.ExportService;
import com.words.admin.words.service.WordsAdminService;

import jodd.json.JsonArray;
import jodd.json.JsonObject;

@SessionScope
@RestController
public class WordsAdminController {

	@Autowired(required = true)
	private WordsAdminService wordsAdminService;

	@RequestMapping("/wordsTest")
	public String handle(HttpServletRequest request) {
		JsonObject result = new JsonObject();
		wordsAdminService.getServiceTest();
		result.put("login", "True");
		return RespUtils.success(result);
	}

	@RequestMapping(value = "/loadDocument", method = RequestMethod.POST)
	public String loadDocument(@RequestParam("file") MultipartFile file, HttpServletRequest request,
			HttpServletResponse response) {
		String name = request.getParameter("name");
		String newName = UUID.randomUUID().toString().replace("-", "");
		try {
			ReadFile.readToFile(file, Paths.get(Constant.PDFPATH), newName + ".pdf");
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			RespUtils.responseJsonFailed(response, "load file failed!");
			return null;
		}
		String docId = wordsAdminService.addDocumentInfo(response, name, newName, file.getOriginalFilename());
		if (docId == null) {
			return null;
		}

		JsonObject result = new JsonObject();
		result.put("name", name);
		result.put("uuID", newName);
		result.put("docId", docId);
		return RespUtils.success(result);
	}

	@RequestMapping(value = "/downloadFile/{userId}/{uuid}.{type}", method = RequestMethod.GET)
	public void downloadFile(HttpServletRequest request, @PathVariable("uuid") String uuid,
			@PathVariable("userId") String userId, @PathVariable("type") String type, HttpServletResponse response) {
		// String userId = request.getParameter(Constant.USERID);
		if (userId == null) {
			RespUtils.responseJsonFailed(response, "userId is required!");
			return;
		}
		if (!Utils.arrayContains(Constant.DOCUTYTE, type)) {
			RespUtils.responseJsonFailed(response, "document type is not surport!");
			return;
		}
		if (!wordsAdminService.getDocuByUuid(uuid)) {
			RespUtils.responseJsonFailed(response, "document is expire or not exists!");
			return;
		}

		Path path = Paths.get(Constant.PDFPATH + uuid + "." + type);
		try {
			// response.setContentType("application/octet-stream;charset=UTF-8");
			FileCopyUtils.copy(Files.readAllBytes(path), response.getOutputStream());
		} catch (IOException e) {
			RespUtils.responseJsonFailed(response, "read file failed!");
			return;
		}
	}

	@RequestMapping("/exportWords")
	public void exportWords(HttpServletRequest request, HttpServletResponse response) {
		Map<String, String[]> exportWordsMap = ValiedParams.checkKeyExist(response, request.getParameterMap(),
				Constant.EXPORTWORDS);
		if (exportWordsMap == null) {
			return;
		}
		try {
			String type = exportWordsMap.get(Constant.EXPORTTYPE)[0];
			ExportService export = ExportFactory.exportBuild(type);
			if (export == null) {
				RespUtils.responseJsonFailed(response, "export file type is not surport!");
				return;
			}
			JsonArray wordsInfo = wordsAdminService.getWordsInfo(response, exportWordsMap, 0);
			if (wordsInfo == null) {
				return;
			}
			export.setTableForWordsExport(wordsInfo);
			export.docClose();
			String fileName = exportWordsMap.get(Constant.EXPORTNAME)[0];
			String fileNameEncode = URLEncoder.encode(fileName, "UTF-8") + "." + type;
			response.setContentType("application/octet-stream;charset=UTF-8");
			response.setHeader("content-disposition", "attachment;filename=" + fileNameEncode);
			FileCopyUtils.copy(export.getDocContent(), response.getOutputStream());

		} catch (Exception e) {
			e.printStackTrace();
			RespUtils.responseJsonFailed(response, "words export failed!");
			return;
		}
	}

	@RequestMapping("/listWords")
	public void listWords(HttpServletRequest request, HttpServletResponse response) {
		String docId = request.getParameter(Constant.WORDSDOCID);
		String userId = request.getParameter(Constant.USERID);
		if (userId == null) {
			RespUtils.responseJsonFailed(response, "userId is required!");
			return;
		}
		JsonArray wordsInfo = null;

		try {
			if (docId == null) {
				wordsInfo = wordsAdminService.getListWords(response, Integer.parseInt(userId), 0, 5);
			} else {
				wordsInfo = wordsAdminService.getListWords(response, Integer.parseInt(userId), Integer.parseInt(docId),
						0);
			}
		} catch (Exception e) {
			RespUtils.responseJsonFailed(response, "params is invalied!");
			return;
		}
		if (wordsInfo == null) {
			return;
		}
	}

	@RequestMapping("/listDocument")
	public void listDocument(HttpServletRequest request, HttpServletResponse response) {
		String state = request.getParameter(Constant.STATE);
		String userId = request.getParameter(Constant.USERID);
		if (userId == null) {
			RespUtils.responseJsonFailed(response, "userId is required!");
			return;
		}
		JsonArray wordsInfo = null;

		try {
			if (state == null) {
				wordsInfo = wordsAdminService.listDocument(response, Integer.parseInt(userId), 5);
			} else {
				wordsInfo = wordsAdminService.listDocument(response, Integer.parseInt(userId), Integer.parseInt(state));
			}
		} catch (Exception e) {
			RespUtils.responseJsonFailed(response, "params is invalied!");
			return;
		}
		if (wordsInfo == null) {
			return;
		}
	}

	@RequestMapping("/wordsInfo")
	public void wordsInfo(HttpServletRequest request, HttpServletResponse response) {
		JsonObject result = new JsonObject();
		RespUtils.success(result);
	}

	@RequestMapping("/addWords")
	public void addWords(HttpServletRequest request, HttpServletResponse response) {
		Map<String, String[]> wordsInfoMap = ValiedParams.checkKeyExist(response, request.getParameterMap(),
				Constant.WORDSINFO);
		if (wordsInfoMap == null) {
			return;
		}
		String wordsId = wordsAdminService.addWordsInfo(response, wordsInfoMap);
		if (wordsId == null) {
			return;
		}
		JsonObject result = new JsonObject();
		JsonObject data = new JsonObject();
		data.put("wordsId", wordsId);
		result.put("data", data);
		result.put("message", "words add success");
		RespUtils.responseJsonSuccess(response, result);
	}

	@RequestMapping("/deleteWords")
	public void deleteWords(HttpServletRequest request, HttpServletResponse response) {
		int wordsId = 0;
		r
		try {
			String wordsIds = request.getParameter("wordsId");
			wordsId = Integer.parseInt(wordsIds);
		} catch (Exception e) {
			RespUtils.responseJsonFailed(response, "wordsId is required!");
			return;
		}
		String res = wordsAdminService.deleteWordsById(response, wordsId);
		if (res == null) {
			return;
		}
		JsonObject result = new JsonObject();
		result.put("message", "删除成功");
		RespUtils.responseJsonSuccess(response, result);
	}

}
