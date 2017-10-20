package com.sdczzm.wcmDemo;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class UserController {
	
	@Autowired
	private userRepository repository;
	
	
	@GetMapping("/user")
	public ModelAndView users(){
		List<User> userList=repository.findAll();
		return new ModelAndView("user/userList","userList",userList);
	}
	
	
	@GetMapping("/user/new")
	public ModelAndView newUserForm() {
	    return new ModelAndView("user/userForm", "user", new User());
	}

	@PostMapping("/user/new")
	public String createUser(@Valid User user) {
	    repository.save(user);
	    return "redirect:/user";
	}

	@GetMapping("/user/{id}/edit")
	public ModelAndView editUserForm(@PathVariable("id") Long id) {
	    return new ModelAndView("user/userForm", "user", repository.findOne(id));
	}

	@PostMapping("/user/{id}/edit")
	public String updateUser(@PathVariable("id") Long id, @Valid User user) {
	    User orgUser = repository.findOne(id);
	    orgUser.setFullName(user.getFullName());
	    orgUser.setUsername(user.getUsername());
	    if (!StringUtils.isEmpty(user.getPassword())) {
	        orgUser.setPassword(user.getPassword());
	    }
	    repository.save(orgUser);
	    return "redirect:/user";
	}

	@DeleteMapping("/user/{id}")
	public String deleteUser(@PathVariable Long id) {
	    repository.delete(id);
	    return "redirect:/user";
	}
	
	
	

}
