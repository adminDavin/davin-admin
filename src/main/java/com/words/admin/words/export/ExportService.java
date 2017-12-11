package com.words.admin.words.export;

import jodd.json.JsonArray;

public interface ExportService {
	public void docClose();

	public void setTableForWordsExport(JsonArray tabCon) throws Exception;

	public byte[] getDocContent();
}
