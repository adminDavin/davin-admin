package com.words.admin.Utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.web.multipart.MultipartFile;

public class ReadFile {

	public static void readToFile(MultipartFile file, Path saveDir) throws IOException {
		if (!file.isEmpty()) {
			Path saveFile = Paths.get(saveDir.toString(), file.getOriginalFilename());
			Files.write(saveFile, file.getBytes());
			System.out.println("finished");
		}
	}

}
