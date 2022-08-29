/**
 * 
 */
package com.saravanan.springcloud.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saravanan.springcloud.model.Ticket;

/**
 * @author NEW
 *
 */
public interface TicketRepo extends JpaRepository<Ticket, Long> {

	Ticket findByTickettype(String ticketType);

}
