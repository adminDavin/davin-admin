package com.t.zero.doc.words.response;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class AppResponseBody<T> extends BaseResponseBody<T> {

	public String result() {
		var mapper =new ObjectMapper();
		ObjectNode response = mapper.createObjectNode();
		response.put("code", this.code);
		response.put("message", this.message);
		response.set("result", mapper.convertValue(this.result, JsonNode.class));
		return response.toString();
	}
}
