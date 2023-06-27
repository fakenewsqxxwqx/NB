package com.example._weizhinote_;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example._weizhinote_.mapper")
public class WeiZhiNoteApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeiZhiNoteApplication.class, args);
	}

}
