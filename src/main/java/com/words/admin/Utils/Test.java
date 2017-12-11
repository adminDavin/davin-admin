package com.words.admin.Utils;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.words.admin.config.Constant;
import com.words.admin.words.export.ExportFactory;
import com.words.admin.words.export.ExportService;

import jodd.json.JsonArray;

public class Test {
	public static void main(String[] args) throws Exception {
		ExportService export = ExportFactory.exportBuild("doc");
		export.setTableForWordsExport(Test.getTestData());
		export.docClose();
		Path file = Paths.get(Constant.LOCATION + "test.doc");
		System.out.println(Files.exists(file));
		if (!Files.exists(file)) {
			Files.createFile(file);
		}
		Files.write(file, export.getDocContent());
		System.out.println(export.toString());
	}

	public static JsonArray getTestData() {
		JsonArray t = new JsonArray();
		JsonArray i = new JsonArray();
		i.add("sdfsd");
		i.add("sdfserfdzfffffd");
		i.add("sdfsd");
		i.add("sdfsd");
		i.add("sdfsd");
		i.add("sdfsd");
		i.add("sdfsd");
		i.add("sdfsdsdasds");
		t.add(i);
		return t;
	}
}
