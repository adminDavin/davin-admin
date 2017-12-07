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

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.words.admin.config.Constant;

@Service
public class MyTaskService {
	@Autowired(required = true)
	private SqlSessionFactory sqlSessionFactory;

	@Scheduled(cron = "0/10 * * * * ?")
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
							try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
								sqlSession.update("words.updateDocument", uuId);
								sqlSession.commit();
							}
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
					System.out.println(file);
				}
			});
			;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
