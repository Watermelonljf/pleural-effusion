package org.bysj.pleural;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("org.bysj.pleural.mapper")
public class UserPlatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserPlatformApplication.class, args);
	}

}
