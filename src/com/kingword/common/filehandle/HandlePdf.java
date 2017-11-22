package com.kingword.common.filehandle;


import java.io.FileOutputStream;
import java.io.IOException;


import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;

import com.itextpdf.text.pdf.PdfReader;  
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import com.kingword.common.StrUtils;
  



public class HandlePdf implements FileHandle{

	@Override
	public String  fileHandle( String filePathName,String fileType) throws IOException  {
		    // 是否排序
			boolean sort = false;
			// pdf文件名
			String pdfFile = filePathName;
			// 输入文本文件名称
			String textFile = null;
			// 编码方式
			String encoding = "UTF-8";
			// 开始提取页数
			int startPage = 1;
			// 结束提取页数
			int endPage = Integer.MAX_VALUE;
			// 文件输入流，生成文本文件
			Writer output = null;
			// 内存中存储的PDF Document
			PDDocument document = null;
			try {
				document = PDDocument.load(pdfFile);
				if (pdfFile.length() > 4) {
					textFile = pdfFile.substring(0, pdfFile.length() - 4) + ".txt";
				}
				// 文件输入流，写入文件倒textFile
				output = new OutputStreamWriter(new FileOutputStream(textFile),encoding);
				
				// PDFTextStripper来提取文本
				PDFTextStripper stripper = null;
				stripper = new PDFTextStripper();
				// 设置是否排序
				stripper.setSortByPosition(sort);
				// 设置起始页
				stripper.setStartPage(startPage);
				// 设置结束页
				stripper.setEndPage(endPage);
				// 调用PDFTextStripper的writeText提取并输出文本
				stripper.writeText(document, output);
				System.out.println(textFile);
			} finally {
				if (output != null) {
					// 关闭输出流
					output.close();
				}
				if (document != null) {
					// 关闭PDF Document
					document.close();
				}
		    } 
		return textFile;
       
		  
		}

	@Override
	public Map<Integer, Integer> fileHandle(String filePath, String nameType,
		String onHandKingWord) throws IOException {
		String savepath = this.getClass().getClassLoader().getResource("/").getPath().replace("/WEB-INF/classes/", "");
		String realpath = savepath+filePath;
	 	PrintWriter writer = new PrintWriter(new FileOutputStream(realpath+".txt"));//txt文件写入流
	 	System.out.println(realpath+".txt");
        String string = realpath;//pdf文件路径
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();

        map=inspect(writer,string,onHandKingWord); //调用读取方法

        writer.close(); 
		return map;
	}
	public static Map<Integer, Integer> inspect(PrintWriter writer, String filename, String onHandKingWord)

	        throws IOException {
			String content = "";  //存放读取出的文档内容
			int countnum = 0;  //存放读取出的文档内容
	        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
	        System.out.println(filename);
	        System.out.println("-----------------------------------------------------------------------------------------");
	        PdfReader reader = new PdfReader(filename);
	        int num = reader.getNumberOfPages();// 获得页数
	        System.out.println("Total Page: " + num);
	        for (int i = 1; i <= num; i++) {
	            // 读取第i页的文档内容
	        	content = PdfTextExtractor.getTextFromPage(reader, i); 
	            countnum=StrUtils.countstringoftext(content,onHandKingWord);
	            if(countnum==0){
	            	continue;
	            }
	            writer.write("第"+i+"页：出现的次数是"+countnum+"content:"+content);//写入文件内容
	            map.put(i, countnum);
	         }
	        reader.close();
	        writer.write(content);//写入文件内容
	        writer.flush();
	        writer.close();
	        return map;
	    } 
	
	
}
