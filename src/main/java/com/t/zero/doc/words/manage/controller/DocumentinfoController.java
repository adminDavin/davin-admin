package com.t.zero.doc.words.manage.controller;

import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.t.zero.doc.words.components.RequestParamsConvert;
import com.t.zero.doc.words.dao.auto.UserinfoMapper;
import com.t.zero.doc.words.dao.manu.DocumentinfoFilters;
import com.t.zero.doc.words.manage.service.DocumentinfoService;
import com.t.zero.doc.words.model.auto.Documentinfo;
import com.t.zero.doc.words.model.auto.Wordsinfo;
import com.t.zero.doc.words.response.RespUtils;
import com.words.admin.Utils.ReadFile;
import com.words.admin.words.export.ExportFactory;
import com.words.admin.words.export.ExportService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RequestScope
@RestController
@RequestMapping("/document")
public class DocumentinfoController {
	@Value("${doc-words.files.uploadpath}")
	private String uploadpath;
	@Autowired
	private ObjectMapper mapper;

	@Autowired
	private RequestParamsConvert requestParamsConvert;

	@Autowired
	private DocumentinfoService documentinfoService;

	@Autowired
	private UserinfoMapper userinfoMapper;

	@RequestMapping("/list")
	public void login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			var params = requestParamsConvert.json(request);
			var userId = params.get("userId").asInt();
			var user = userinfoMapper.selectByPrimaryKey(userId);
			var selectAll = user.getState() == 5;
			var iFilter = mapper.convertValue(params, DocumentinfoFilters.class);
			ObjectNode result = mapper.createObjectNode();
			result.set("data", mapper.convertValue(documentinfoService.list(iFilter, userId, selectAll), ObjectNode.class));
			result.put("code", 0);
			RespUtils.responseJsonSuccess(response, result);
		} catch (Exception e) {
			log.error("request failed", e);
			throw e;
		}
	}

	@RequestMapping(value = "/loadDocument", method = RequestMethod.POST)
	public void loadDocument(@RequestParam("file") MultipartFile file, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			String name = request.getParameter("name");
			Integer userId = Integer.parseInt(request.getParameter("userid"));
			String newName = UUID.randomUUID().toString().replace("-", "");
			new ReadFile().readToFile(file, Paths.get(uploadpath), newName);
			Documentinfo documentInfo = new Documentinfo();
			documentInfo.setName(name);
			documentInfo.setOriginalname(file.getOriginalFilename());
			documentInfo.setUuid(newName);
			documentInfo.setUserid(userId);
			documentInfo.setCreatetime(LocalDateTime.now());
			documentInfo.setState(0);
			documentInfo.setUpdatetime(LocalDateTime.now());
			var docId = documentinfoService.addDocumentInfo(response, documentInfo);
			ObjectNode result = mapper.createObjectNode();
			result.put("code", 0);
			result.set("data", mapper.convertValue(docId, ObjectNode.class));
			RespUtils.responseJsonSuccess(response, result);
		} catch (Exception e) {
			log.error("loadDocument failed", e);
			throw e;
		}
	}
	

	@RequestMapping(value = "/deleteDocument", method = RequestMethod.POST)
	public void deleteDocument(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			var params = requestParamsConvert.json(request);
			var docid = params.get("docid").asInt();
			var doc = documentinfoService.deleteDocument(docid);
			ObjectNode result = mapper.createObjectNode();
			result.put("code", 0);
			result.set("data", mapper.convertValue(doc, ObjectNode.class));
			RespUtils.responseJsonSuccess(response, result);
		} catch (Exception e) {
			log.error("loadDocument failed", e);
			throw e;
		}
	}


	@RequestMapping("/addWords")
	public void addWords(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			var params = requestParamsConvert.json(request);
			var wordsId = documentinfoService.addWordsInfo(response, mapper.convertValue(params, Wordsinfo.class));
			ObjectNode result = mapper.createObjectNode();
			result.put("code", 0);
			result.set("data", mapper.convertValue(wordsId, ObjectNode.class));
			RespUtils.responseJsonSuccess(response, result);
		} catch (Exception e) {
			log.error("loadDocument failed", e);
			throw e;
		}
	}

	@RequestMapping("/deleteWords")
	public void deleteWords(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			var params = requestParamsConvert.json(request);
			var wordsId = documentinfoService.deleteWords(response, mapper.convertValue(params, Wordsinfo.class));
			ObjectNode result = mapper.createObjectNode();
			result.put("code", 0);
			result.set("data", mapper.convertValue(wordsId, ObjectNode.class));
			RespUtils.responseJsonSuccess(response, result);
		} catch (Exception e) {
			log.error("loadDocument failed", e);
			throw e;
		}
	}

	@RequestMapping("/listWords")
	public void listWords(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			var params = requestParamsConvert.json(request);
			var w = mapper.convertValue(params, Wordsinfo.class);
			List<Wordsinfo> wordsInfo = documentinfoService.listWords(w.getDocid());

			ObjectNode result = mapper.createObjectNode();
			result.put("code", 0);
			result.set("data", mapper.convertValue(wordsInfo, ArrayNode.class));
			RespUtils.responseJsonSuccess(response, result);
		} catch (Exception e) {
			log.error("loadDocument failed", e);
			throw e;
		}
	}

	@RequestMapping("/exportWords")
	public void exportWords(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			var params = requestParamsConvert.json(request);
			List<Wordsinfo> wordsInfo = documentinfoService.listWords(params.get("docid").asText());
			wordsInfo = wordsInfo.stream().sorted(Comparator.comparing(Wordsinfo::getCreatetime)).collect(Collectors.toList());

			ExportService export = ExportFactory.exportBuild(params.get("type").asText());
			export.setTableForWordsExport(mapper.convertValue(wordsInfo, ArrayNode.class));

			export.setResponse(response, params.get("filename").asText());
			export.docClose();
		} catch (Exception e) {
			log.error("loadDocument failed", e);
			throw e;
		}
	}

}
