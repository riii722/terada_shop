package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EntityScan(basePackages = {"com.example.demo.accessingdatamysql"})
//@EnableJpaRepositories(basePackages = {"com.example.sbci.repository"})
//@EnableTransactionManagement(proxyTargetClass = true)
public class TeradaShop2Application {

	public static void main(String[] args) {
		SpringApplication.run(TeradaShop2Application.class, args);
	}

}