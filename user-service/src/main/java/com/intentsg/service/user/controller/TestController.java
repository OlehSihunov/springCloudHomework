package com.intentsg.service.user.controller;

import com.intentsg.model.TicketDTO;
import com.intentsg.service.user.model.User;
import com.intentsg.service.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Controller
@RequestMapping("/users")
public class TestController {
	@Autowired
	private  DiscoveryClient discoveryClient;
	@Autowired
	private UserService userService;
	@GetMapping("/test")
	public ResponseEntity test() {
		return ResponseEntity.ok("user-service");
	}

	@GetMapping("/")
	public ResponseEntity<List<User>> getAllUsers() {
		return new ResponseEntity<List<User>>(userService.getAllUsers(),HttpStatus.OK);
	}
	@GetMapping("/user/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable("userId") int userId){
		return  new ResponseEntity<User>(userService.getUserById(userId), HttpStatus.OK);
	}

	@GetMapping("/tickets/{userId}")
	public ResponseEntity<TicketDTO[]> getUserTickets(@PathVariable("userId") int userId) {
		ServiceInstance serviceInstance = discoveryClient.getInstances("ticket-service").get(0);
		String url = serviceInstance.getUri().toString()+"/tickets/usertickets/"+userId;
		RestTemplate restTemplate = new RestTemplate();
		return   restTemplate.getForEntity(url, TicketDTO[].class);
	}


}
