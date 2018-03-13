package org.bysj.pleural;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.bysj.pleural.mapper")
public class UserPlatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserPlatformApplication.class, args);
	}
}
