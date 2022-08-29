/**
 * 
 */
package com.saravanan.springcloud.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saravanan.springcloud.model.Coupon;

/**
 * @author NEW
 *
 */
public interface CouponRepo extends JpaRepository<Coupon, Long> {

	Coupon findByCode(String code);

}
