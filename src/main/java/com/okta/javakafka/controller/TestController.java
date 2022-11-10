package com.okta.javakafka.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@RequestMapping("/welcome")
	public String welcomepage() {
		return "Welcome to Yawin Tutor";
	}

}