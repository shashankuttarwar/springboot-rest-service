/**
 * 
 */
package com.alp.policymanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alp.policymanagement.model.User;
import com.alp.policymanagement.service.UserService;

/**
 * @author lenovo
 *
 */
@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping("/users")
    public User list(@RequestParam(value="name", defaultValue="World") String name) {
    	User user = null;
    			//userService;    	
    	return user;
    }
	
	@GetMapping("/login/{userId}")
    public String login(@PathVariable String userId, @RequestParam(value="password", defaultValue="") String password) {
    	String validUser = userService.checkLogin(userId, password); 	
    	return validUser;
    }
	
	@GetMapping("/users/{userId}")
    public User get(@PathVariable String userId) {
    	User user = userService.getUserDetails(userId);    	
    	return user;
    }
	
	@PostMapping("/users")
    public String add(@RequestBody User user) {
    	String userId = userService.addUser(user);    	
    	return userId;
    }
}
