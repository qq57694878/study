package com.ljl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ljl.study.mapper")
public class VjspdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(VjspdemoApplication.class, args);
	}
}
