package com.sycoraxdigital.ProductService.command.api.data;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;


@Data
@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String productId;
	private String name;
	private BigDecimal price;
	private Integer quantity;
}
