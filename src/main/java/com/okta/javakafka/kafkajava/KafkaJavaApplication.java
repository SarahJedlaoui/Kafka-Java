package com.okta.javakafka.kafkajava;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@SpringBootApplication
//@ComponentScan({"com.okta.javakafka.controller"})
@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})
public class KafkaJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaJavaApplication.class, args);
	}

}
