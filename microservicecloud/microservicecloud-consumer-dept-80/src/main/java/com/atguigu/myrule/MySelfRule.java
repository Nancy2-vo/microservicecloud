package com.atguigu.myrule;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

@Configuration
//自定义
public class MySelfRule {
	
	@Bean
	public IRule myIRule() {
		return new RandomRule();
	}
}
