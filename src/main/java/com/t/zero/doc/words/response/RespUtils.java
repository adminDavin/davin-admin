package com.t.zero.doc.words.response;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import jodd.json.JsonObject;

public class RespUtils implements HandlerExceptionResolver {
	private static String contentType = "application/json; charset=utf-8";

	public static String success(JsonObject result) {
		AppResponseBody<JsonObject> success = new AppResponseBody<JsonObject>();
		success.setCode("200");
		success.setMessage("success");
		success.setResult(result);
		return success.result();
	}

	public static String failed(String reason) {
		AppResponseBody<String> failed = new AppResponseBody<String>();
		failed.setCode("503");
		failed.setMessage("failed");
		failed.setResult(reason);
		return failed.result();
	}

	public static void responseJsonSuccess(HttpServletResponse response, JsonObject result) {
		response.setContentType(contentType);
		try (PrintWriter out = response.getWriter()) {
			out.append(success(result));
		} catch (IOException e) {
			System.out.println("系统错误");
			e.printStackTrace();
		}

	}

	public static void responseJsonFailed(HttpServletResponse response, String reason) {
		response.setContentType(contentType);
		try (PrintWriter out = response.getWriter()) {
			out.append(failed(reason));
			out.flush();
		} catch (IOException e) {
			System.out.println("系统错误");
			e.printStackTrace();
		}
	}

	@Override
	public ModelAndView resolveException(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2,
			Exception arg3) {
		return null;
	}
}
