package com.Order.Processing.Fraud.Detection.service;

import org.springframework.stereotype.Service;

import com.Order.Processing.Fraud.Detection.entity.Order;
import com.Order.Processing.Fraud.Detection.kafka.OrderProducer;
import com.Order.Processing.Fraud.Detection.repository.OrderRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {
	private final OrderRepository orderRepository;
	private final OrderProducer orderProducer;

	public OrderService(OrderRepository orderRepository, OrderProducer orderProducer) {
		this.orderRepository = orderRepository;
		this.orderProducer = orderProducer;
    }
	public Order createOrder(Order orders) {
		orders.setOrderStatus("Created");
		Order saveOrder=orderRepository.save(orders);
		orderProducer.publishOrder(saveOrder);
		return saveOrder;
		
	}

}
