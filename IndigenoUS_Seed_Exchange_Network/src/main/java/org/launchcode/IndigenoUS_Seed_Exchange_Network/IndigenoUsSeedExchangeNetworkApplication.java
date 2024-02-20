package org.launchcode.IndigenoUS_Seed_Exchange_Network;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class IndigenoUsSeedExchangeNetworkApplication implements WebMvcConfigurer{

		public static void main(String[] args) {
			SpringApplication.run(IndigenoUsSeedExchangeNetworkApplication.class, args);
		}
@Override
		public void addViewControllers(ViewControllerRegistry registry) {
			registry.addViewController("/index").setViewName("index.html");
		}
	}