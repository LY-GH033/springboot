package com.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.mybatis.mapper") // 扫描 Mapper 接口所在包
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
