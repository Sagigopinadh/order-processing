package com.Order.Processing.Fraud.Detection.kafka;


import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.Order.Processing.Fraud.Detection.entity.Order;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
@Slf4j
public class OrderProducer {
	private static final String TOPIC = "orders-topic";
	private static final Logger log = LoggerFactory.getLogger(OrderProducer.class);
	  
	private final KafkaTemplate<String, Order> kafkaTemplate; 
	
	public OrderProducer(KafkaTemplate kafkatemplate) {
		this.kafkaTemplate=kafkatemplate;
	}
	public void publishOrder(Order orders) {
		log.info("publishing order event : {} ",orders);
		kafkaTemplate.send(TOPIC,orders);
	}
}
