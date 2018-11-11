package com.dubbo.provider;


import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.biz.common.Connect;
@Service(interfaceClass=Connect.class)
@Component
public class ConnectImpl implements Connect {

	@Override
	public String sayHello(String name) {
		return "hello "+ name +",this is my first dubbo project.";
	}

}
