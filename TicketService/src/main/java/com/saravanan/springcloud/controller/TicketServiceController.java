package com.saravanan.springcloud.controller;

import java.math.BigDecimal;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.saravanan.springcloud.model.Ticket;
import com.saravanan.springcloud.repos.TicketRepo;

@RestController
@RequestMapping("/ticketapi")
public class TicketServiceController {
	
	@Autowired
	TicketRepo ticketRepo;
	
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
	
	@GetMapping(value = "/tickets/{ticketType}/{ticketCount}")
	public Ticket getPrice(@PathVariable("ticketType") String ticketType, @PathVariable("ticketCount") BigDecimal ticketCount) {
		
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<BigDecimal> entity = new HttpEntity < BigDecimal > (headers);
		String END_Point_Test_API = "http://localhost:9090/priceapi/prices/"+ticketType;
		ResponseEntity<BigDecimal> price = restTemplate().exchange(END_Point_Test_API, HttpMethod.GET, entity, BigDecimal.class);
		
		BigDecimal totalPrice = price.getBody().multiply(ticketCount);
		Ticket ticket = new Ticket();
		ticket.setPrice(price.getBody());
		ticket.setTicketcount(ticketCount);
		ticket.setTickettype(ticketType);
		ticket.setPrice(totalPrice);
		return ticketRepo.save(ticket);
		
	}

}
