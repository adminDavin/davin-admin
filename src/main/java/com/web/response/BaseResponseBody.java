package com.web.response;

public class BaseResponseBody<T> {
	/**
	 * @Fields rspCode :响应码
	 */
	protected String code;

	/**
	 * @Fields rspMsg :响应消息
	 */
	protected String message;

	/**
	 * @Fields val :返回报文信息
	 */
	protected T result;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}
}
