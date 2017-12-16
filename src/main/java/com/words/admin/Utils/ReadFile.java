package com.words.admin.Utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.jodconverter.DocumentConverter;
import org.jodconverter.LocalConverter;
import org.jodconverter.office.OfficeException;
import org.jodconverter.office.OfficeManager;
import org.springframework.web.multipart.MultipartFile;

import com.words.admin.config.Constant;
import com.words.admin.convert.OfficeBuilder;

public class ReadFile {

	public void readToFile(MultipartFile file, Path saveDir, String newName) throws Exception {
		if (!file.isEmpty()) {
			String oldFileName = file.getOriginalFilename();
			String suffix = oldFileName.substring(oldFileName.lastIndexOf(".") + 1);

			Path saveFile = Paths.get(saveDir.toString(), newName + "." + suffix);
			// System.out.println(file.getOriginalFilename());
			// Files.write(saveFile, file.getBytes());
			File saveName = new File(saveFile.toString());
			System.out.println(saveFile.toString());
			file.transferTo(saveName);
			if (!Constant.EXPORTPDF.equals(suffix)) {
				Path otherFile = Paths.get(saveDir.toString(), newName + "." + Constant.EXPORTPDF);
				convert(saveName, new File(otherFile.toString()));
				Files.delete(saveFile);
			}
		}
	}

	public static void readToDB(MultipartFile file, Path saveDir) throws IOException {
		if (!file.isEmpty()) {
			Path saveFile = Paths.get(saveDir.toString(), file.getOriginalFilename());
			Files.write(saveFile, file.getBytes());
			System.out.println("finished");
		}
	}

	private void convert(File file, File save) throws OfficeException {
		OfficeManager officeManager = OfficeBuilder.builder();
		officeManager.start();
		DocumentConverter documentConverter = LocalConverter.make(officeManager);
		documentConverter.convert(file).to(save).execute();
		officeManager.stop();
	}
}
