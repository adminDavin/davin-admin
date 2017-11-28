package com.words.admin.Utils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpServletResponse;

import com.web.response.RespUtils;

public class ValiedParams {

	public static Map<String, String[]> checkKeyExist(HttpServletResponse response, Map<String, String[]> map,
			String[] obj) {
		for (String item : obj) {
			if (map.get(item) == null) {
				RespUtils.responseJsonFailed(response, item + " is not exist!");
				return null;
			}
		}
		return map;
	}

	public static Map<String, String[]> checkKeyModify(HttpServletResponse response, Map<String, String[]> map,
			String[] obj) {
		Map<String, String[]> modifiedAttribute = new ConcurrentHashMap<String, String[]>();
		for (String item : obj) {
			if (map.get(item) != null) {
				String[] value = map.get(item);
				if (value == null) {
					RespUtils.responseJsonFailed(response, "modify failed for " + item + " not null!");
					return null;
				} else if (value.length != 2) {
					RespUtils.responseJsonFailed(response, "modify failed for " + item + " value has error!");
					return null;
				} else if (value[0] == value[1]) {
					RespUtils.responseJsonFailed(response, "modify failed for old value equals new value!");
					return null;
				}
				modifiedAttribute.put(item, value);
			}
		}
		RespUtils.responseJsonFailed(response, "modify failed for not exists attribute!");
		return null;
	}

}
