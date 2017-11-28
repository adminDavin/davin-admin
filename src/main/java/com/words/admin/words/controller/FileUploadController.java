package com.words.admin.words.controller;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.words.admin.Utils.ReadFile;

@Controller
public class FileUploadController {
	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	@ResponseBody
	public String uploadFileHandler(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
		String rootPath = System.getProperty("catalina.home");
		System.out.println(file.getOriginalFilename());
		Path saveDir = Paths.get(rootPath);
		try {
			ReadFile.readToFile(file, saveDir);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = "/uploadMulti", method = RequestMethod.POST)
	@ResponseBody
	public String multiFileUploadHandler(@RequestParam("files") MultipartFile[] files,
			RedirectAttributes redirectAttributes) {
		String rootPath = System.getProperty("catalina.home");
		try {
			for (MultipartFile file : files) {
				Path saveDir = Paths.get(rootPath);
				ReadFile.readToFile(file, saveDir);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
