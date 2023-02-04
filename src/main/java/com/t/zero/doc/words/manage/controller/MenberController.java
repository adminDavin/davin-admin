package com.t.zero.doc.words.manage.controller;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.t.zero.doc.words.components.RequestParamsConvert;
import com.t.zero.doc.words.dao.manu.UserinfoFilters;
import com.t.zero.doc.words.manage.service.MenberService;
import com.t.zero.doc.words.model.auto.Userinfo;
import com.t.zero.doc.words.response.RespUtils;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RequestScope
@RestController
@RequestMapping("/menber")
public class MenberController {
	
	@Autowired
	private ObjectMapper mapper;

	@Autowired
	private RequestParamsConvert requestParamsConvert;

	@Autowired
	private MenberService menberService;

	@RequestMapping("/list")
	public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		var params = requestParamsConvert.json(request);
		var iFilter = mapper.convertValue(params, UserinfoFilters.class);
		ObjectNode result = mapper.createObjectNode();
		result.set("data", mapper.convertValue(menberService.list(iFilter), ObjectNode.class));
		result.put("code", 0);
		RespUtils.responseJsonSuccess(response, result);
	}
	
	@RequestMapping("/updateUserStatus")
	public void updateUserStatus(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			var params = requestParamsConvert.json(request);
			var userinfo = mapper.convertValue(params, Userinfo.class);
			userinfo.setAcceptdate(LocalDateTime.now());
			menberService.updateUserStatus(userinfo);
			ObjectNode result = mapper.createObjectNode();
			result.set("data", mapper.convertValue(userinfo, ObjectNode.class));
			result.put("code", 0);
			RespUtils.responseJsonSuccess(response, result);
		} catch(Exception e) {
			log.error("request failed", e);
			throw e;
		}
	} 
	@RequestMapping("/deleteUser")
	public void deleteUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			var params = requestParamsConvert.json(request);
			var userinfo = mapper.convertValue(params, Userinfo.class);
			userinfo.setAcceptdate(LocalDateTime.now());
			menberService.deleteUser(userinfo);
			ObjectNode result = mapper.createObjectNode();
			result.set("data", mapper.convertValue(userinfo, ObjectNode.class));
			result.put("code", 0);
			RespUtils.responseJsonSuccess(response, result);
		} catch(Exception e) {
			log.error("request failed", e);
			throw e;
		}
	} 


}
