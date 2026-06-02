package com.Order.Processing.Fraud.Detection.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Order.Processing.Fraud.Detection.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

}
