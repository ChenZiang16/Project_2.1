package com;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;

@MapperScan(basePackages = {"com.dao"})
@EnableDubboConfiguration
@SpringBootApplication
public class SpringStarter {

	/**
	 * spring启动类
	 */
	
	public static void main(String[] args) {
		
		SpringApplication.run(SpringStarter.class, args);
	}

}
