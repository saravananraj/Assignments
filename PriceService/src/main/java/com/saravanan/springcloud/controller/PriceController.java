package com.saravanan.springcloud.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saravanan.springcloud.model.Price;
import com.saravanan.springcloud.repos.PriceRepo;

@RestController
@RequestMapping("/priceapi")
public class PriceController {

	@Autowired
	PriceRepo priceRepo;
	
	@PostMapping(value = "/prices")
	public Price create(@RequestBody Price priceDetails) {
		return priceRepo.save(priceDetails);
	}
	
	@GetMapping(value = "/prices/{ticketType}")
	public Price getPrice(@PathVariable("ticketType") String ticketType) {
		return priceRepo.findByTicketType(ticketType);
	}

	
}

