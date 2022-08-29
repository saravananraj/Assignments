
package com.saravanan.springcloud.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saravanan.springcloud.model.Product;

public interface ProductRepo extends JpaRepository<Product, Long>{

}
