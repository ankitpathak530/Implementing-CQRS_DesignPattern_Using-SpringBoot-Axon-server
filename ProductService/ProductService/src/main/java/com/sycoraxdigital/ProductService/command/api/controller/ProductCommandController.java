package com.sycoraxdigital.ProductService.command.api.controller;

import java.util.UUID;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sycoraxdigital.ProductService.command.api.commands.CreateProductCommand;
import com.sycoraxdigital.ProductService.command.api.model.ProductDTO;


@RestController
@RequestMapping("/products")
public class ProductCommandController {
	
    private CommandGateway commandGateway;

    public ProductCommandController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }
	 
     
	@PostMapping("/")
	public String addProduct(@RequestBody ProductDTO product) {
		
		CreateProductCommand command = CreateProductCommand.builder() 
														   .productId(UUID.randomUUID().toString())
				                                           .name(product.getName())
				                                           .price(product.getPrice())
				                                           .build();
		String	result = commandGateway.sendAndWait(command);		                                           
		return result;
	}
}
