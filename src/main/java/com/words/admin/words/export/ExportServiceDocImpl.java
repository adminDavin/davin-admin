package com.words.admin.words.export;

import java.awt.Color;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.ByteBuffer;
import com.lowagie.text.rtf.RtfWriter2;
import com.lowagie.text.rtf.style.RtfFont;
import com.words.admin.config.Constant;

import jodd.json.JsonArray;
import jodd.json.JsonObject;

public class ExportServiceDocImpl implements ExportService {
	private Document doc;
	private ByteBuffer content;

	public ExportServiceDocImpl() {
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
		RtfWriter2.getInstance(doc, content);
	}

	public void setDocTitle(String titleString) throws DocumentException {
		RtfFont titleFont = new RtfFont("仿宋_GB2312", 24, Font.NORMAL, Color.BLACK);
		Paragraph title = new Paragraph(titleString);
		title.setAlignment(Element.ALIGN_CENTER);
		title.setFont(titleFont);
		doc.add(title);
	}

	public void setDocPara(String ParaString) throws DocumentException {
		RtfFont contextFont = new RtfFont("仿宋_GB2312", 9, Font.NORMAL, Color.BLACK);
		Paragraph context = new Paragraph(ParaString);
		context.setFont(contextFont);
		context.setSpacingBefore(10);
		context.setFirstLineIndent(20);
		doc.add(context);
	}

	@Override
	public void setTableForWordsExport(JsonArray tabCon) throws Exception {
		// RtfFont titleFont = new RtfFont("仿宋_GB2312", 12, Font.NORMAL, Color.BLACK);
		// /** 正文字体 */
		Table table = new Table(3);
		int width[] = { 20, 50, 20 };// 设置每列宽度比例
		table.setWidths(width);
		table.setWidth(90);// 占页面宽度比例
		table.setAlignment(Element.ALIGN_CENTER);// 居中
		table.setAlignment(Element.ALIGN_MIDDLE);// 垂直居中
		table.setAutoFillEmptyCells(true);// 自动填满
		table.setBorderWidth(1);// 边框宽度
		int index = 1;
		for (Object item : tabCon) {
			JsonObject words = (JsonObject) item;
			table.addCell(getCell(String.valueOf(index)));
			table.addCell(getCell(words.getValue(Constant.TEXTCONTENT)));
			int init = Integer.parseInt(words.getValue(Constant.INITPAGE));
			int page = Integer.parseInt(words.getValue(Constant.PAGENUM));
			table.addCell(getCell(String.valueOf(page + init)));
			index++;
		}
		doc.add(table);
	}

	public Cell getCell(String name) throws BadElementException {
		RtfFont contextFont = new RtfFont("仿宋_GB2312", 12, Font.NORMAL, Color.BLACK);
		Cell cell = new Cell(new Phrase(name, contextFont));
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		// cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		// cell.setBorderColor(new Color(189, 22, 33));
		// cell.setBackgroundColor(new Color(58, 137, 20));
		return cell;

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
			ExportServiceDocImpl b = new ExportServiceDocImpl();
			b.setTableForWordsExport(b.getTestData());
			b.docClose();
			Path file = Paths.get(Constant.LOCATION + "test.doc");
			System.out.println(Files.exists(file));
			if (!Files.exists(file)) {
				Files.createFile(file);
			}
			Files.write(file, b.getDocContent());
			System.out.println(b.toString());
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

}
