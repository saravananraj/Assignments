package com.saravanan.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saravanan.springcloud.model.Coupon;
import com.saravanan.springcloud.repos.CouponRepo;

@RestController
@RequestMapping("/couponapi")
public class CouponServiceController {
	
	@Autowired
	CouponRepo couponRepo;
	
	@PostMapping(value = "/coupons")
	public Coupon create(@RequestBody Coupon coupon) {
		return couponRepo.save(coupon);
	}
	
	@GetMapping(value = "/coupons/{code}")
	public Coupon getCoupon(@PathVariable("code") String code) {
		return couponRepo.findByCode(code);
	}

}
