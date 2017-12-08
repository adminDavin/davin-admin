package com.words.admin.Utils;

import java.awt.Color;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.lowagie.text.Cell;
import com.lowagie.text.Document;
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

public class CreateDoc {
	public void createFile() throws Exception {
		Document doc = new Document(PageSize.A4);
		ByteBuffer b = new ByteBuffer();
		RtfWriter2.getInstance(doc, b);
		doc.open();
		RtfFont titleFont = new RtfFont("仿宋_GB2312", 12, Font.NORMAL, Color.BLACK);
		RtfFont contextFont = new RtfFont("仿宋_GB2312", 9, Font.NORMAL, Color.BLACK);
		Table table = new Table(12, 16);
		int[] withs = { 3, 9, 5, 4, 4, 3, 3, 14, 14, 14, 14, 14 };
		table.setWidths(withs);
		table.setWidth(100);
		table.setAlignment(Element.ALIGN_CENTER);
		table.setAutoFillEmptyCells(true);
		String titleString = "东南大学 ";
		Paragraph title = new Paragraph(titleString);
		title.setAlignment(Element.ALIGN_CENTER);
		title.setFont(titleFont);
		doc.add(title);
		String contextString = "院系:";
		Paragraph context = new Paragraph(contextString);
		context.setAlignment(Element.ALIGN_CENTER);
		context.setFont(contextFont);
		context.setSpacingBefore(10);
		context.setFirstLineIndent(20);
		doc.add(context);
		Cell[] cellHeaders = new Cell[11];
		cellHeaders[0] = new Cell(new Phrase("序号", contextFont));
		cellHeaders[1] = new Cell(new Phrase("课程名称", contextFont));
		cellHeaders[2] = new Cell(new Phrase("教师", contextFont));
		cellHeaders[3] = new Cell(new Phrase("学分", contextFont));
		cellHeaders[4] = new Cell(new Phrase("上课周次", contextFont));
		cellHeaders[5] = new Cell(new Phrase(" ", contextFont));
		cellHeaders[5].setColspan(2);
		cellHeaders[6] = new Cell(new Phrase("星期一", contextFont));
		cellHeaders[7] = new Cell(new Phrase("星期二", contextFont));
		cellHeaders[8] = new Cell(new Phrase("星期三", contextFont));
		cellHeaders[9] = new Cell(new Phrase("星期四", contextFont));
		cellHeaders[10] = new Cell(new Phrase("星期五", contextFont));
		doc.close();
		System.out.println(b.toString());
		Path file = Paths.get(Constant.LOCATION + "test.doc");

	}

	public static void main(String[] args) {
		try {
			new CreateDoc().createFile();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
