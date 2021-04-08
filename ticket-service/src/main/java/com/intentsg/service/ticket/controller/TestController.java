package com.intentsg.service.ticket.controller;

import com.intentsg.service.ticket.model.Ticket;
import com.intentsg.service.ticket.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
@RequestMapping("/tickets")
public class TestController {

	@Autowired
	TicketService ticketService;
	@GetMapping("/test")
	public ResponseEntity test() {
		return ResponseEntity.ok("ticket-service");
	}

	@GetMapping("/")
	public ResponseEntity<List<Ticket>> getAllTickets() {
		return new ResponseEntity<List<Ticket>>(ticketService.getAllTickets(), HttpStatus.OK);
	}
	@GetMapping("/usertickets/{userId}")
	public ResponseEntity<List<Ticket>> getUserTickets(@PathVariable("userId") int userId) {
		return new ResponseEntity<List<Ticket>>(ticketService.getTicketsByUserId(userId), HttpStatus.OK);
	}

	@GetMapping("/user/{ticketId}")
	public  ResponseEntity<Object> getTicketById(@PathVariable("ticketId") int ticketId){
		RestTemplate restTemplate = new RestTemplate();
		return  restTemplate.getForEntity("http://localhost:8080/users/user/"+ticketService.getTicketById(ticketId).getUserId(),Object.class);
	}
}
