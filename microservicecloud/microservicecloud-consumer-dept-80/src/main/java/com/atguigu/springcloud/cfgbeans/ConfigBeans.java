package com.atguigu.springcloud.cfgbeans;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
//import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;

//类applicationContext.xml=ConfigBeans
@Configuration
public class ConfigBeans {
	
	@Bean
	@LoadBalanced  //Ribbon基于客户端，默认的方法 
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	public IRule myIRule() {
		return new RoundRobinRule();//达到的目的，用我们重新选择的随机算法，非默认轮训
	}
}
