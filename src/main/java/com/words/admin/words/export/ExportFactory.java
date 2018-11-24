package com.words.admin.words.export;

import com.words.admin.config.Constant;

public class ExportFactory {
	public static ExportService exportBuild(String type) {
		if (type.equals(Constant.EXPORTDOC)) {
			return new ExportServiceTxtImpl(type);
		} else {
			return new ExportServiceDocImpl(type);
		}
		 

	}
}
