package com.example.baitap1.repository;

import com.example.baitap1.entity.CustomerEntity;
import com.example.baitap1.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity,Integer> {
    List<OrderEntity> findAllByCustomer(CustomerEntity customerEntity);
}
