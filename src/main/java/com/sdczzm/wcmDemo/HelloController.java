package com.sdczzm.wcmDemo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {
	@Autowired
	private userRepository repository;
	
	@GetMapping("/")
	public String hello(){
		return "hello sdczzm";
	}
	
}
