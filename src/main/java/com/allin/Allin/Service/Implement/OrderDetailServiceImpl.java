package com.allin.Allin.Service.Implement;

import com.allin.Allin.Repository.OrderRepository;
import com.allin.Allin.Service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {
    @Autowired
    OrderRepository orderRepository;
}
