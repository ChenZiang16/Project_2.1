package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MqProducer {

	@Autowired
    private DefaultMQProducer defaultMQProducer;
	
	@RequestMapping("/send")
	public void send(HttpServletRequest request,HttpServletResponse response) {
		
		String msg = request.getParameter("msg");
		
		if(StringUtils.isBlank(msg)) {
			msg = "Hello Word !";
		}
		
		Message message = new Message("DemoTopic","DemoTag",msg.getBytes());
		
		try {
			SendResult result = defaultMQProducer.send(message);
			System.out.println("消息发送响应信息：" + result.toString());
		} catch (MQClientException | RemotingException | MQBrokerException | InterruptedException e) {
			System.out.println("send fail ....");
			e.printStackTrace();
		}
		
		
	}
	
}
