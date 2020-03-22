package com.atguigu.springcloud.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.atguigu.springcloud.entities.Dept;

import feign.hystrix.FallbackFactory;

@Component//不要忘记添加
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService>{

	@Override
	public DeptClientService create(Throwable cause) {
		// TODO Auto-generated method stub
		return new DeptClientService() {

			@Override
			public boolean add(Dept dept) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public Dept findById(Long id) {
				// TODO Auto-generated method stub
				return new Dept().setDepton(id).setDname(id+"没有对应的信息 =---null --已经关闭").setDb_souceString("进入熔断器");
			}

			@Override
			public List<Dept> list() {
				// TODO Auto-generated method stub
				return null;
			}
		
		};
	}

}
