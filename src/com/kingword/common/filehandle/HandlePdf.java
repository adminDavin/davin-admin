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
		    // �Ƿ�����
			boolean sort = false;
			// pdf�ļ���
			String pdfFile = filePathName;
			// �����ı��ļ�����
			String textFile = null;
			// ���뷽ʽ
			String encoding = "UTF-8";
			// ��ʼ��ȡҳ��
			int startPage = 1;
			// ������ȡҳ��
			int endPage = Integer.MAX_VALUE;
			// �ļ��������������ı��ļ�
			Writer output = null;
			// �ڴ��д洢��PDF Document
			PDDocument document = null;
			try {
				document = PDDocument.load(pdfFile);
				if (pdfFile.length() > 4) {
					textFile = pdfFile.substring(0, pdfFile.length() - 4) + ".txt";
				}
				// �ļ���������д���ļ���textFile
				output = new OutputStreamWriter(new FileOutputStream(textFile),encoding);
				
				// PDFTextStripper����ȡ�ı�
				PDFTextStripper stripper = null;
				stripper = new PDFTextStripper();
				// �����Ƿ�����
				stripper.setSortByPosition(sort);
				// ������ʼҳ
				stripper.setStartPage(startPage);
				// ���ý���ҳ
				stripper.setEndPage(endPage);
				// ����PDFTextStripper��writeText��ȡ������ı�
				stripper.writeText(document, output);
				System.out.println(textFile);
			} finally {
				if (output != null) {
					// �ر������
					output.close();
				}
				if (document != null) {
					// �ر�PDF Document
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
	 	PrintWriter writer = new PrintWriter(new FileOutputStream(realpath+".txt"));//txt�ļ�д����
	 	System.out.println(realpath+".txt");
        String string = realpath;//pdf�ļ�·��
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();

        map=inspect(writer,string,onHandKingWord); //���ö�ȡ����

        writer.close(); 
		return map;
	}
	public static Map<Integer, Integer> inspect(PrintWriter writer, String filename, String onHandKingWord)

	        throws IOException {
			String content = "";  //��Ŷ�ȡ�����ĵ�����
			int countnum = 0;  //��Ŷ�ȡ�����ĵ�����
	        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
	        System.out.println(filename);
	        System.out.println("-----------------------------------------------------------------------------------------");
	        PdfReader reader = new PdfReader(filename);
	        int num = reader.getNumberOfPages();// ���ҳ��
	        System.out.println("Total Page: " + num);
	        for (int i = 1; i <= num; i++) {
	            // ��ȡ��iҳ���ĵ�����
	        	content = PdfTextExtractor.getTextFromPage(reader, i); 
	            countnum=StrUtils.countstringoftext(content,onHandKingWord);
	            if(countnum==0){
	            	continue;
	            }
	            writer.write("��"+i+"ҳ�����ֵĴ�����"+countnum+"content:"+content);//д���ļ�����
	            map.put(i, countnum);
	         }
	        reader.close();
	        writer.write(content);//д���ļ�����
	        writer.flush();
	        writer.close();
	        return map;
	    } 
	
	
}
