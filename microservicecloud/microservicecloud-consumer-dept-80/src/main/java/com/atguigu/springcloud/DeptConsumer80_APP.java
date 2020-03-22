package com.atguigu.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import com.atguigu.myrule.MySelfRule;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name="MICROSERVICECLOUD-DEPT",configuration=MySelfRule.class)  
//MySelfRule:自己定义的MySelfRule 类不能在@ComponentScan他的父类已经子类下面，另外建一个包
public class DeptConsumer80_APP {
	public static void main(String[] args) {
		SpringApplication.run(DeptConsumer80_APP.class, args);
	}
	
}
