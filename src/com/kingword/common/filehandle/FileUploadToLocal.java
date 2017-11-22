package com.kingword.common.filehandle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.ConnectException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.artofsolving.jodconverter.DocumentConverter;
import com.artofsolving.jodconverter.openoffice.connection.OpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.connection.SocketOpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.converter.OpenOfficeDocumentConverter;

public class FileUploadToLocal {
	// 文件上传处理
	public Map<String, String> uploadFile(HttpServletRequest request,
			String savePath, String relativePath)
			throws UnsupportedEncodingException {
		String myFileName = "";
		String fileName = "";
		String extName = "";
		String nameType = "pdf";
		int finaltime = 0;
		int pre = 0;
		String name = "";
		String newFileName = "";
		Date dt = new Date();
		Long time = dt.getTime();

		Map<String, String> map = new HashMap<String, String>();
		request.setCharacterEncoding("UTF-8");
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		if (multipartResolver.isMultipart(request)) {
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			Iterator<String> iter = multiRequest.getFileNames();
			while (iter.hasNext()) {
				// 记录上传过程起始时的时间，用来计算上传时间
				pre = (int) System.currentTimeMillis();
				// 取得上传文件
				MultipartFile file1 = multiRequest.getFile(iter.next());
				if (file1 != null) {
					// 取得当前上传文件的文件名称
					myFileName = file1.getOriginalFilename();
					nameType = file1.getContentType();
					// 如果名称不为“”,说明该文件存在，否则说明该文件不存在
					if (myFileName.trim() != "") {
						// 重命名上传后的文件名
						fileName = file1.getOriginalFilename();
						System.out.println("文件的名字：" + fileName);
						if (fileName == null || fileName.trim().equals("")) {
							continue;
						}
						if (fileName.lastIndexOf(".") >= 0) {
							extName = fileName.substring(fileName
									.lastIndexOf("."));
							System.out.println("文件的后缀名：" + extName);
						}
						name = fileName
								.substring(fileName.lastIndexOf("/") + 1);
						name = name.substring(name.lastIndexOf("\\") + 1);
						// 修改上传文件的名字
						newFileName = "f" + time.toString() + extName;
						File localFile = new File(savePath + newFileName);
						try {
							file1.transferTo(localFile);
						} catch (IllegalStateException | IOException e) {
							System.out.println("文件上传失败！");
							e.printStackTrace();
						}
					}

				}
				// 记录上传该文件后的时间
				finaltime = (int) System.currentTimeMillis();
			}
		}
		map.put("relativePath", relativePath);
		map.put("fileName", fileName);
		map.put("savePath", savePath);
		map.put("newfileName", newFileName);
		map.put("nameType", nameType);
		map.put("finaltime", Integer.toString(finaltime - pre));
		map.put("trunsferflag", Integer.toString(0));
		System.out.println(extName + "-------------------------------------"
				+ extName.equals(".doc"));
		if (extName.equals(".doc")) {
			System.out.println("word文档转 为pdf文档");
			map.put("trunsferflag", Integer.toString(1));
			newFileName = office2PDF(
					map.get("savePath") + map.get("newfileName"),
					map.get("savePath") + "f" + time.toString() + ".pdf");
			if (newFileName != Integer.toString(-1)
					&& newFileName != Integer.toString(0)) {
				map.put("newfileName",
						newFileName.substring(newFileName.lastIndexOf("/") + 1));
				System.out.println("word文档转换为pdf文档成功" + map.get("newfileName"));
			} else {
				System.out.println("文档转换失败");
			}
		} else if (extName.equals(".docx")) {
			System.out.println("word文档转 为pdf文档");
			map.put("trunsferflag", Integer.toString(1));
			newFileName = office2PDF(
					map.get("savePath") + map.get("newfileName"),
					map.get("savePath") + "f" + time.toString() + ".pdf");
			if (newFileName != Integer.toString(-1)
					&& newFileName != Integer.toString(0)) {
				map.put("newfileName",
						newFileName.substring(newFileName.lastIndexOf("/") + 1));
				System.out.println("word文档转换为pdf文档成功" + map.get("newfileName"));
			} else {
				System.out.println("文档转换失败");
			}
		}
		for (Entry<String, String> entry : map.entrySet()) {
			System.out.println("Key = " + entry.getKey() + ", Value = "
					+ entry.getValue());
		}
		return map;
	}

	// 文件路径检查
	public void fileDirCheck(String savePath) {
		File f1 = new File(savePath);
		if (!f1.exists()) {
			f1.mkdirs();
		}
	}

	public Map<String, String> fileTrunfer(String string,
			Map<String, String> map) {
		System.out.println(map.get("savePath") + map.get("newfileName"));
		return map;
	}

	public static String office2PDF(String sourceFile, String destFile) {
		try {
			File inputFile = new File(sourceFile);
			if (!inputFile.exists()) {
				return Integer.toString(-1);// 找不到源文件, 则返回-1
			}

			// 如果目标路径不存在, 则新建该路径
			File outputFile = new File(destFile);
			if (!outputFile.getParentFile().exists()) {
				outputFile.getParentFile().mkdirs();
			}

			String OpenOffice_HOME = "C:/Program Files (x86)/OpenOffice 4/";// 这里是OpenOffice的安装目录,
																			// 在我的项目中,为了便于拓展接口,没有直接写成这个样子,但是这样是绝对没问题的
			// 如果从文件中读取的URL地址最后一个字符不是 '\'，则添加'\'
			if (OpenOffice_HOME.charAt(OpenOffice_HOME.length() - 1) != '\\') {
				OpenOffice_HOME += "\\";
			}
			// 启动OpenOffice的服务
			String command = OpenOffice_HOME
					+ "program\\soffice.exe -headless -accept=\"socket,host=127.0.0.1,port=8100;urp;\"";
			Process pro = Runtime.getRuntime().exec(command);
			// connect to an OpenOffice.org instance running on port 8100
			OpenOfficeConnection connection = new SocketOpenOfficeConnection(
					"127.0.0.1", 8100);
			connection.connect();

			// convert
			DocumentConverter converter = new OpenOfficeDocumentConverter(
					connection);
			converter.convert(inputFile, outputFile);

			// close the connection
			connection.disconnect();
			// 关闭OpenOffice服务的进程
			pro.destroy();

			return destFile;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return Integer.toString(-1);
		} catch (ConnectException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return destFile;
	}

}
