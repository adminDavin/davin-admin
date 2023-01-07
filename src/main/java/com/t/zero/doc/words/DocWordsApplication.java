package com.t.zero.doc.words;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@MapperScans({@MapperScan("com.t.zero.doc.words")})
@SpringBootApplication
public class DocWordsApplication {
	
	 public static void main(String[] args) {
	        SpringApplication.run(DocWordsApplication.class, args);
	    }

}
