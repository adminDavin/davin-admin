package com.words.admin.words.controller;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.multipart.MultipartFile;

import com.web.response.RespUtils;
import com.words.admin.Utils.ReadFile;
import com.words.admin.config.Constant;
import com.words.admin.words.service.WordsAdminService;

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
			e.printStackTrace();
			RespUtils.responseJsonFailed(response, "load file failed!");
			return null;
		}
		if (wordsAdminService.addDocumentInfo(response, name, newName, file.getOriginalFilename()) == null) {
			return null;
		}
		JsonObject result = new JsonObject();
		result.put("name", name);
		result.put("uuID", newName);
		return RespUtils.success(result);
	}

	@RequestMapping("/wordsInfo")
	public String wordsInfo(HttpServletRequest request, HttpServletResponse response) {

		JsonObject result = new JsonObject();
		return RespUtils.success(result);
	}
}
