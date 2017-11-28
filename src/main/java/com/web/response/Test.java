package com.web.response;

import jodd.json.JsonObject;

public class Test {
	public static void main(String[] args) {
		AppResponseBody<JsonObject> a = new AppResponseBody<JsonObject>();
		a.setCode("200");
		a.setMessage("success");
		a.setResult(new JsonObject());
		System.out.println(a.result());

	}
}
