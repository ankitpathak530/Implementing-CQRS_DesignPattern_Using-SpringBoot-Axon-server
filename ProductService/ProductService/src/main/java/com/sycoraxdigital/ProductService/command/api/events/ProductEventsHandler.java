package com.sycoraxdigital.ProductService.command.api.events;


import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.sycoraxdigital.ProductService.command.api.data.Product;
import com.sycoraxdigital.ProductService.command.api.repo.ProductRepository;

import lombok.NoArgsConstructor;

@Component
@NoArgsConstructor
@ProcessingGroup("product")
public class ProductEventsHandler {

	
	private ProductRepository productRepository;
	

    public ProductEventsHandler(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
	
    
    
	@EventHandler
	public void on( ProductCreatedEvent productCreatedEvent) {
		Product product = new Product();
		BeanUtils.copyProperties(productCreatedEvent, product);
		productRepository.save(product);
	}
}
