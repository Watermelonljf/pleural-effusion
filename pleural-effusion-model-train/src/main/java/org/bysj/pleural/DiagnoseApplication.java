package org.bysj.pleural;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableEurekaClient
@EnableAsync
@MapperScan("org.bysj.pleural.mapper")
public class DiagnoseApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiagnoseApplication.class, args);
	}
}
