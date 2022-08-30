package com.saravanan.springcloud.restclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.saravanan.springcloud.model.Price;

@FeignClient("ZUUL-GATEWAY-SERVICE")
public interface PriceClient {

	@GetMapping("/priceapi/prices/{ticketType}")
	Price getPrice(@PathVariable("ticketType") String ticketType);
}
