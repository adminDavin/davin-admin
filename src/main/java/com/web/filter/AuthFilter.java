package com.web.filter;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.words.admin.config.Constant;
import com.words.admin.manage.service.ManageService;

public class AuthFilter extends HandlerInterceptorAdapter {
	
	@Autowired
	private ManageService manageService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println(request.getRequestURI());
		String userId = request.getParameter(Constant.USERID);
//		Boolean isValied = manageService.checkUserIsValid(Integer.parseInt(userId));
//		if (isValied) {
//			Boolean isManager =  checkUserIsManager(Integer.parseInt(userId));
//			request.setAttribute("IsManager", isManager);
//			return true;
//		}
		return false;
	}

}
