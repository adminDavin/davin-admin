package com.words.admin.Utils;

public class Utils {
	public static boolean arrayContains(String[] arr, String value) {
		for (String item : arr) {
			if (item.equals(value)) {
				return true;
			}
		}
		return false;
	}
}
