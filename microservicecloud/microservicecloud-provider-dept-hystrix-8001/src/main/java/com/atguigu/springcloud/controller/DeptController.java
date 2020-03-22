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
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
//微服务---带熔断的微服务（微服务不可用或响应时间过长，进行熔断，快速返回错误的返回信息，防止雪崩）
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
	//一旦调用服务方法失败并抛出了错误信息后，会自动调用@HystrixCommand标注好的fallbackMethos调用类中的指定方法
	@HystrixCommand(fallbackMethod="processHystrix_Get")//有异常进入这个方法
	public Dept findById(@PathVariable("id") Long id) {
		Dept dept=deptservice.findById(id);
		System.out.println(dept);
		//当返回为空，抛出异常--向调用方（消费者）返回处理异常
		if(dept==null) {
			throw new RuntimeException(id+"没有对应的信息");
		}
		return dept;
	}
	
	//调用该方法
	public Dept processHystrix_Get(@PathVariable("id") Long id ) {
		return new Dept().setDepton(id).setDname(id+"没有对应的信息 =---null --@HystrixConand").setDname("aaaaa").setDb_souceString("进入熔断器");
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
