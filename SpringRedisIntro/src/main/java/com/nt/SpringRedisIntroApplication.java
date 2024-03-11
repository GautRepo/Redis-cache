package com.nt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.nt.mapper")
public class SpringRedisIntroApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRedisIntroApplication.class, args);
	}

}
