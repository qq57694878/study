package cn.com.jldata.search.spmsearch;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.com.jldata.search.spmsearch.mapper")
public class SpmsearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpmsearchApplication.class, args);
	}
}
