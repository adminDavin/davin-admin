package com.words.admin.TaskScheduler;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.time.Duration;
import java.time.Instant;
import java.util.function.Consumer;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.t.zero.doc.words.config.Constant;
import com.words.admin.words.repository.WordsAdminRepository;

@Component
@Configurable
@EnableScheduling
public class MyTaskService {
	@Autowired(required = true)
	private WordsAdminRepository wordsAdminRepository;
	
	@Scheduled(cron = "0 0 23 * * ?")
	public void reportCurrentTime() {
		Path pdfDir = Paths.get(Constant.PDFPATH);
		try (Stream<Path> files = Files.list(pdfDir)) {
			files.forEach(new Consumer<Path>() {
				@Override
				public void accept(Path file) {
					try {
						FileTime createTime = Files.getLastModifiedTime(pdfDir);
						int diffDay = (int) Duration.between(createTime.toInstant(), Instant.now()).toMinutes();
						if (diffDay > Constant.FILESAVEDAYS) {
							String uuId = file.getFileName().toString().split("\\.")[0];
							Files.delete(file);
							wordsAdminRepository.updateDocumentStatus(uuId);
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			});
			;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
