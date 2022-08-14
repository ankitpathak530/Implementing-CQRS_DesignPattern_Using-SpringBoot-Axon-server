package com.sycoraxdigital.ProductService.command.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sycoraxdigital.ProductService.command.api.data.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

}
