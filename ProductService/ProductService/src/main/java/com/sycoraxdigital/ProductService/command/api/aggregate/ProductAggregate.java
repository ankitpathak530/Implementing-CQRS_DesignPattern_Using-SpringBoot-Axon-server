package com.sycoraxdigital.ProductService.command.api.aggregate;

import java.math.BigDecimal;
 
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import com.sycoraxdigital.ProductService.command.api.commands.CreateProductCommand;
import com.sycoraxdigital.ProductService.command.api.events.ProductCreatedEvent;


@Aggregate
public class ProductAggregate {

	@AggregateIdentifier
    private String productId;
	private String name;
	private BigDecimal price;
	private Integer quantity;
	
	
	public ProductAggregate(){};
	

	@CommandHandler
	public ProductAggregate(CreateProductCommand createProductCommand) {
		
		// We can perform all the validation here
		ProductCreatedEvent productCreatedEvent = new ProductCreatedEvent();
		BeanUtils.copyProperties(createProductCommand, productCreatedEvent);
		
		//Publish the event
		AggregateLifecycle.apply(productCreatedEvent);
		
	}
	
	@EventSourcingHandler
	public void on(ProductCreatedEvent productCreatedEvent) {
		this.productId = productCreatedEvent.getProductId();
		this.name = productCreatedEvent.getName();
		this.price = productCreatedEvent.getPrice();
		this.quantity =productCreatedEvent.getQuantity();
	}
}
