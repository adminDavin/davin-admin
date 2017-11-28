package com.web.response;

import jodd.json.JsonObject;

public class AppResponseBody<T> extends BaseResponseBody<T> {

	public String result() {
		JsonObject response = new JsonObject();
		response.put("code", this.code);
		response.put("message", this.message);
		response.put("result", this.result);
		return response.toString();
	}
}
