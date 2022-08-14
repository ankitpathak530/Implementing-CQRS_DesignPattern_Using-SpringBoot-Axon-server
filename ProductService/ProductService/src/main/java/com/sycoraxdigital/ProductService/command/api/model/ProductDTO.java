package com.sycoraxdigital.ProductService.command.api.model;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDTO {

	private String name;
	private BigDecimal price;
	private Integer quantity;
}
