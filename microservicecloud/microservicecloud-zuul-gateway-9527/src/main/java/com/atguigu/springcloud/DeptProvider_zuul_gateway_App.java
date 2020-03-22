package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class DeptProvider_zuul_gateway_App {

		public static void main(String[] args) {
			SpringApplication.run(DeptProvider_zuul_gateway_App.class, args);
		}
}
