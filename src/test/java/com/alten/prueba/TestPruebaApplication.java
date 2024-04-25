package com.alten.prueba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestPruebaApplication {

	public static void main(String[] args) {
		SpringApplication.from(PruebaApplication::main).with(TestPruebaApplication.class).run(args);
	}

}
