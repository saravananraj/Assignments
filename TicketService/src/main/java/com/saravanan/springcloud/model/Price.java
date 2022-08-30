/**
 * 
 */
package com.saravanan.springcloud.model;

import java.math.BigDecimal;

/**
 * @author NEW
 *
 */
public class Price {
	
	private Long id;
	private String ticketType;
	private BigDecimal price;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getTicketType() {
		return ticketType;
	}
	public void setTicketType(String ticketType) {
		this.ticketType = ticketType;
	}
	
	
	
}
