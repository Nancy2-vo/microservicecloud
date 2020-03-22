package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
//类似于注册器【物业公司】
@SpringBootApplication
@EnableConfigServer
public class Config_3344_StartSpringCloud_App {
	public static void main(String[] args) {
		SpringApplication.run(Config_3344_StartSpringCloud_App.class, args);
	}
}
