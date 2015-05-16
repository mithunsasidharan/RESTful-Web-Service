package com.rest.webservices;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	private static final List<User> users = new ArrayList<User>();
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping(value ="/user", method=RequestMethod.POST)
	public @ResponseBody String createUser(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam("age") int age) {
		User user = new User(counter.incrementAndGet(),firstName, lastName, age);
		users.add(user);
		return "User has been created !!";
	}

	@RequestMapping(value ="/user/{id}", method=RequestMethod.GET)
	public @ResponseBody User getUser(@PathVariable("id") long id) {
		for(User user : users)  
			if(user.getId() == id) { 
				return user;
			}
		return null;
	}
}
