
package com.saravanan.springcloud.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saravanan.springcloud.model.Price;

public interface PriceRepo extends JpaRepository<Price, Long>{

	Price findByTicketType(String ticketType);

}
