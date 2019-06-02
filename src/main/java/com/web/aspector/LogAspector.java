package com.web.aspector;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.jfree.util.Log;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSON;
import com.words.admin.manage.controller.HelloController;

@Aspect
@Component
@Order(1)
public class LogAspector {
	Logger logger = LogManager.getLogger(HelloController.class.getName());
    ThreadLocal<Long> startTime = new ThreadLocal<>();

	

@Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping) && execution(public * *(..))")
   	public void recordLog() {
	}
    @Before( "recordLog()")
	public void doBefore(JoinPoint joinPoint) throws Throwable {
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        logger.info("request address: " + request.getRequestURL().toString() + ", source ip: " + request.getRemoteAddr());
        String actionMethod = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
        logger.info("action method:" + actionMethod + ", request params : " + JSON.toJSONString(request.getParameterNames()));
	}
	 
	@AfterReturning(returning = "ret", pointcut = "recordLog()")
    public void doAfterReturning(Object ret) throws Throwable {
//		if (ret != null) {
//			logger.info("reuturn data: " + ret);
//	        logger.info("SPEND TIME : " + (System.currentTimeMillis() - startTime.get()));
//		} else {
//			logger.error("request failed.");
//		}         
    }
}
