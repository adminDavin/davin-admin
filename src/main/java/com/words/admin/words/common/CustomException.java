package com.words.admin.words.common;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class CustomException extends Exception {
	private int errCode = 504;
	private String message;

	// 无参构造方法
	public CustomException() {
		super();
	}

	// 有参的构造方法
	public CustomException(String message) {
		super(message);
		this.message = message;

	}

	public int getErrCode() {
		return errCode;
	}

	public void setErrCode(int errCode) {
		this.errCode = errCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	// 有参的构造方法
	public CustomException(int errCode, String message, HttpServletResponse response) {
		super(message);
		this.errCode = errCode;
		this.message = message;
	}

	public void sendResponse(HttpServletResponse response, String message) {
		response.setContentType("application/json; charset=utf-8");
		try (PrintWriter out = response.getWriter()) {
			out.append(message);
			out.flush();
		} catch (IOException e) {
			System.out.println("系统错误");
			e.printStackTrace();
		}

	}

	// 用指定的详细信息和原因构造一个新的异常
	public CustomException(String message, Throwable cause) {
		super(message, cause);
	}

	// 用指定原因构造一个新的异常
	public CustomException(int errCode, Throwable cause) {
		super(cause);
	}

}
