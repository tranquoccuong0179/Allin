package com.allin.Allin.Service;

import com.allin.Allin.dto.Request.CreateOrderRequest;
import com.allin.Allin.dto.Response.ResponseObj;
import org.springframework.http.ResponseEntity;

public interface OrderService {

    ResponseEntity<ResponseObj> getAllOrder();

    ResponseEntity<ResponseObj> createOrder(CreateOrderRequest createOrderRequest);

    ResponseEntity<ResponseObj> updateOrder(Long id, CreateOrderRequest createOrderRequest);

    ResponseEntity<ResponseObj> deleteOrder(Long id);
}
