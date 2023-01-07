package com.t.zero.doc.words.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.words.admin.manage.controller.HelloController;


@Component//注入ioc容器
@WebFilter(filterName = "caFilter",urlPatterns = "/*")//配置拦截路径
public class AuthCAFilter implements Filter {

	Logger logger = LogManager.getLogger(HelloController.class.getName());

	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
        chain.doFilter(request,response);
	}

	@Override
	public void destroy() {
		
	}

}
