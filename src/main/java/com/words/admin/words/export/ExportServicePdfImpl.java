package com.words.admin.words.export;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.ByteBuffer;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.t.zero.doc.words.config.Constant;

import jodd.json.JsonArray;

public class ExportServicePdfImpl implements ExportService {
	private Document doc;
	private ByteBuffer content;

	public ExportServicePdfImpl() {
		super();
		docInit();
		docOpen();

	}

	public void docOpen() {
		doc.open();
	}

	@Override
	public void docClose() {
		doc.close();
	}

	private void docInit() {
		doc = new Document(PageSize.A4);
		content = new ByteBuffer();
		try {
			PdfWriter.getInstance(doc, content);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void setTableForWordsExport(JsonArray tabCon) throws Exception {
		PdfPTable table = new PdfPTable(8);
		table.setWidthPercentage(100);
		List<List<String>> dataset = getData();
		for (List<String> record : dataset) {
			for (String field : record) {
				table.addCell(field);
			}
		}
		doc.add(table);
	}

	public List<List<String>> getData() {
		List<List<String>> data = new ArrayList<List<String>>();
		String[] tableTitleList = { " Title", " (Re)set", " Obs", " Mean", " Std.Dev", " Min", " Max", "Unit" };
		data.add(Arrays.asList(tableTitleList));
		for (int i = 0; i < 10;) {
			List<String> dataLine = new ArrayList<String>();
			i++;
			for (int j = 0; j < tableTitleList.length; j++) {
				dataLine.add(tableTitleList[j] + " " + i);
			}
			data.add(dataLine);
		}
		return data;
	}

	@Override
	public byte[] getDocContent() {
		return content.getBuffer();
	}

	public JsonArray getTestData() {
		JsonArray t = new JsonArray();
		JsonArray i = new JsonArray();
		i.add("sdfsd");
		i.add("sdfsd");
		i.add("sdfsd");
		i.add("sdfsd");
		i.add("sdfsd");
		i.add("sdfsd");
		i.add("sdfsd");
		i.add("sdfsdsdasds");
		t.add(i);
		return t;
	}

	public static void main(String[] args) {
		try {
			ExportServicePdfImpl b = new ExportServicePdfImpl();
			b.setTableForWordsExport(b.getTestData());
			b.docClose();
			Path file = Paths.get(Constant.LOCATION + "test.doc");
			// System.out.println(Files.exists(file));
			if (!Files.exists(file)) {
				Files.createFile(file);
			}
			Files.write(file, b.getDocContent());
			// System.out.println(b.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ByteBuffer getContent() {
		return content;
	}

	public void setContent(ByteBuffer content) {
		this.content = content;
	}

	public Document getDoc() {
		return doc;
	}

	public void setDoc(Document doc) {
		this.doc = doc;
	}
 

	@Override
	public void setResponse(HttpServletResponse response, String fileName) {
		// TODO Auto-generated method stub
		
	}

}
