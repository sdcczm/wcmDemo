package com.sdczzm.wcmDemo;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * 
 * @author QiHuifang
 *
 */
//@Component
public class UserInitializer implements CommandLineRunner {
	
	private final userRepository repository;
	
	public UserInitializer(userRepository repository) {
		this.repository = repository;
	}



	public void run(String... arg0) throws Exception {	
	/*	Stream.of("sdczzm","tom","gary","aimee").forEach(name -> repository.save(new User(name,"001",name)));
		repository.findAll().forEach(System.out::println);*/
//		repository.save(new User("sdczzm","001","sdczzm"));
//		repository.save(new User("gary","001","gary"));
//		repository.save(new User("aimee","001","aimee"));
	}
	

}
