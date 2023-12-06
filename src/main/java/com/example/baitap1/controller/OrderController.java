package com.example.baitap1.controller;

import com.example.baitap1.entity.CustomerEntity;
import com.example.baitap1.entity.OrderEntity;
import com.example.baitap1.payload.response.BaseResponse;
import com.example.baitap1.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("")
    public ResponseEntity<?> insert(@RequestParam String orderCode,
                                    @RequestParam double totalAmount,
                                    @RequestParam int customerId){
        String message=orderService.insert(orderCode,totalAmount,customerId);
        BaseResponse baseResponse=new BaseResponse();
        baseResponse.setMessage(message);

        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<?> getAllOrderByCustomer(@PathVariable int customerId){
        try {
            List<OrderEntity> list=orderService.findAllByCustomer(customerId);

            return new ResponseEntity<>(list,HttpStatus.OK);
        }catch (Exception e){
            throw new RuntimeException("Error getAllOrderByCustomer: "+e.getMessage());
        }
    }
}
