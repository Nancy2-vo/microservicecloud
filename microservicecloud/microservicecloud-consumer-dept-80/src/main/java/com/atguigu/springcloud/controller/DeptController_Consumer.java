package com.atguigu.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//消费端、客户端
import org.springframework.web.client.RestTemplate;

import com.atguigu.springcloud.entities.Dept;

@RestController
public class DeptController_Consumer {
	
	//面向微服务编程
//	private static final String REST_URL_PREFIX="http://localhost:8001";
	private static final String REST_URL_PREFIX="http://MICROSERVICECLOUD-DEPT";
	
	//提供了多种边界访问远程Http服务的方法---客户端模板工具集
	//（URL、requestMap,ResponseBean.class）
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping(value="/consumer/dept/add")
	public boolean add(Dept dept) {
		return restTemplate.postForObject(REST_URL_PREFIX+"/dept/add", dept, Boolean.class);
	}
	
	
	@RequestMapping(value="/consumer/dept/get/{id}")
	public Dept get(@PathVariable("id") Long id) {
		return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/"+id,Dept.class);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/consumer/dept/list")
	public List<Dept> list() {
		return restTemplate.getForObject(REST_URL_PREFIX+"/dept/list",List.class);
	}
	
	//消费者可以调用服务清单
	@RequestMapping(value="/consumer/dept/discovery")
	public Object discovery(){
		return restTemplate.getForObject(REST_URL_PREFIX+"/dept/discovery",Object.class);
	}
}
