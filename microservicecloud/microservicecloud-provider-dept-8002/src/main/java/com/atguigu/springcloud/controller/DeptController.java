package com.atguigu.springcloud.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.springcloud.entities.Dept;
import com.atguigu.springcloud.service.DeptService;
//微服务
//返回JSON格式
@RestController
public class DeptController {
	@Autowired
	private DeptService deptservice;
	@Autowired
	private DiscoveryClient client;
	
	@RequestMapping(value="/dept/add",method=RequestMethod.POST)
	public boolean add(@RequestBody Dept dept) {
		return deptservice.addDept(dept);
	}
	
	@RequestMapping(value="/dept/get/{id}",method=RequestMethod.GET)
	public Dept findById(@PathVariable("id") Long id) {
		return deptservice.findById(id);
	}
	
	
	@RequestMapping(value="/dept/list",method=RequestMethod.GET)
	public List<Dept> list() {
		return deptservice.findAll();
	}
	
	@RequestMapping(value="/dept/discovery",method=RequestMethod.GET)
	public Object discovery(){
		List<String> list=client.getServices();//盘点总共有多少个微服务
		System.out.println("********"+list);
		List<ServiceInstance> sList=client.getInstances("MISCROSERVICECLOUD-DEPT");
		for (ServiceInstance serviceInstance : sList) {//打印出微服务的端口等等信息
			System.out.println(serviceInstance.getServiceId()+"\t"+serviceInstance.getHost()+"\t"+serviceInstance.getPort()+"\t"+serviceInstance.getUri());
		}
		return this.client;
	}
	
	
}
