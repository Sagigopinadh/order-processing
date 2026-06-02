package com.Order.Processing.Fraud.Detection.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Order.Processing.Fraud.Detection.entity.Order;
import com.Order.Processing.Fraud.Detection.service.OrderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {
	//@Autowired
	private final OrderService orderService;
	public OrderController(OrderService orderService) {
		this.orderService=orderService;
	}
	@PostMapping("/create")
	public ResponseEntity<Order> createOrder(@RequestBody Order order){
		return ResponseEntity.ok(orderService.createOrder(order));
		
	}
	

}
