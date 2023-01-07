package com.words.admin.words.export;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.ByteBuffer;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.t.zero.doc.words.config.Constant;

import jodd.json.JsonArray;
import jodd.json.JsonObject;

public class ExportServiceDocImpl implements ExportService {
	private Document doc;
	private ByteBuffer content;

	public ExportServiceDocImpl(String type) throws DocumentException {
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

	private void docInit() throws DocumentException {
		doc = new Document(PageSize.A4);
		content = new ByteBuffer();
		PdfWriter.getInstance(doc, content);
	}

	public void setDocTitle(String titleString) throws DocumentException {
		Font titleFont = FontFactory.getFont(FontFactory.HELVETICA , 12, Font.UNDERLINE);
		PdfPCell cell = new PdfPCell();
		cell.setPhrase(new Phrase(titleString, titleFont));
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		Paragraph title = new Paragraph(titleString);
		title.setAlignment(Element.ALIGN_CENTER);
		title.setFont(titleFont);
		doc.add(title);
	}

	public void setDocPara(String ParaString) throws DocumentException {
		Font titleFont = FontFactory.getFont(FontFactory.HELVETICA , 12, Font.UNDERLINE);
		Paragraph context = new Paragraph(ParaString);
		context.setFont(titleFont);
		context.setSpacingBefore(10);
		context.setFirstLineIndent(20);
		doc.add(context);
	}

	@Override
	public void setTableForWordsExport(JsonArray tabCon) throws Exception {
		// RtfFont titleFont = new RtfFont("仿宋_GB2312", 12, Font.NORMAL, Color.BLACK);
		// /** 正文字体 */
		PdfPTable table = new PdfPTable(3);
		int width[] = { 20, 50, 20 };// 设置每列宽度比例
		table.setWidths(width);
		table.setWidthPercentage(90);// 占页面宽度比例
//		table.setAlignment(Element.ALIGN_CENTER);// 居中
//		table.setAlignment(Element.ALIGN_MIDDLE);// 垂直居中
//		table.setAutoFillEmptyCells(true);// 自动填满
//		table.setBorderWidth(1);// 边框宽度
		int index = 1;
		for (Object item : tabCon) {
			JsonObject words = (JsonObject) item;
			table.addCell(getCell(String.valueOf(index)));
			table.addCell(getCell(words.getString(Constant.TEXTCONTENT)));

			int init = words.getInteger(Constant.INITPAGE);
			int page = words.getInteger(Constant.PAGENUM);
			table.addCell(getCell(String.valueOf(page + init)));
			index++;
		}
		doc.add(table);
	}

	public PdfPCell getCell(String name) throws BadElementException {
		Font contextFont = FontFactory.getFont(FontFactory.HELVETICA , 12, Font.UNDERLINE);
		PdfPCell cell = new PdfPCell();
		 cell.setPhrase(new Phrase(name, contextFont));
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
			ExportServiceDocImpl b = new ExportServiceDocImpl("doc");
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
