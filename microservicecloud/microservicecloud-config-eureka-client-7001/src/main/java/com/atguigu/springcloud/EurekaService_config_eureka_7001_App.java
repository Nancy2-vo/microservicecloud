package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
//类似于注册器【物业公司】
@SpringBootApplication
@EnableEurekaServer   
public class EurekaService_config_eureka_7001_App {
	public static void main(String[] args) {
		SpringApplication.run(EurekaService_config_eureka_7001_App.class, args);
	}
}
