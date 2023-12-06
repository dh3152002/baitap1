package com.example.baitap1.service;

import com.example.baitap1.entity.CustomerEntity;
import com.example.baitap1.entity.OrderEntity;
import com.example.baitap1.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public String insert(String orderCode, double totalAmount, int customerId){
        String message="";
        OrderEntity orderEntity=new OrderEntity();
        orderEntity.setOrderCode(orderCode);
        orderEntity.setTotalAmount(totalAmount);

        CustomerEntity customerEntity=new CustomerEntity();
        customerEntity.setId(customerId);
        orderEntity.setCustomer(customerEntity);

        try {
            orderRepository.save(orderEntity);
            message="insert success";
        }catch (Exception e){
            throw new RuntimeException("Error insert order: "+e.getMessage());
        }

        return message;
    }

    public List<OrderEntity> findAllByCustomer(int customerId){
        CustomerEntity customerEntity=new CustomerEntity();
        customerEntity.setId(customerId);

        return orderRepository.findAllByCustomer(customerEntity);
    }
}
