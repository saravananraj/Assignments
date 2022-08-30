package com.saravanan.springcloud.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.saravanan.springcloud.model.Price;
import com.saravanan.springcloud.model.Ticket;
import com.saravanan.springcloud.repos.TicketRepo;
import com.saravanan.springcloud.restclients.PriceClient;

@RestController
@RequestMapping("/ticketapi")
public class TicketServiceController {
	
	@Autowired
	TicketRepo ticketRepo;
	
	@Autowired
	PriceClient priceClient;
	
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
	
	@GetMapping(value = "/tickets/{ticketType}/{ticketCount}")
	public Ticket getPrice(@PathVariable("ticketType") String ticketType, @PathVariable("ticketCount") BigDecimal ticketCount) {
		Price priceDao = priceClient.getPrice(ticketType);
		System.out.println(" ticket type= " + ticketType);
		System.out.println(" ticketCount= " + ticketCount);
		System.out.println(" price= " + priceDao);
		BigDecimal totalCost = priceDao.getPrice().multiply(ticketCount);
		Ticket ticket = new Ticket();
		ticket.setTicketCount(ticketCount);
		ticket.setTotalCost(totalCost);
		return ticketRepo.save(ticket);
		
	}

}
