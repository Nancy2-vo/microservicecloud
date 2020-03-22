package com.atguigu.springcloud.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//类似于注册器【物业公司】
@RestController
public class ConfigClientRest {
	@Value("${spring.application.name}")
	private String applicationName;
	
	@Value("${eureka.client.service-url.defaultZone}")	
	private String eurekaServers;
	
	@Value("${server.port}")	
	private String port;
	
	@RequestMapping("/config")	
	public  String getConfig() {
		String str="applicationName:"+applicationName+"\t eurekaServices:"+eurekaServers+"\t port"+port;
		System.out.println("********"+str);
		return "applicationName:"+applicationName+"\t eurekaServices:"+eurekaServers+"\t port"+port;
	}
	
}
