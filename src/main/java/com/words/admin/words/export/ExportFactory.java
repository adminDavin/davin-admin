package com.words.admin.words.export;

import com.itextpdf.text.DocumentException;
import com.t.zero.doc.words.config.Constant;

public class ExportFactory {
	public static ExportService exportBuild(String type) throws DocumentException {
		if (type.equals(Constant.EXPORTDOC)) {
			return new ExportServiceTxtImpl(type);
		} else {
			return new ExportServiceDocImpl(type);
		}
		 

	}
}
