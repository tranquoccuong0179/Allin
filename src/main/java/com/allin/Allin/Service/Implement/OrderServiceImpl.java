package com.allin.Allin.Service.Implement;

import com.allin.Allin.Entity.Order;
import com.allin.Allin.Repository.OrderRepository;
import com.allin.Allin.Service.OrderService;
import com.allin.Allin.dto.Request.CreateOrderRequest;
import com.allin.Allin.dto.Response.ResponseObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Override
    public ResponseEntity<ResponseObj> getAllOrder() {
        List<Order> orderList = orderRepository.findByOrOrderStatusNotLike("Đã hủy");
        if(orderList.isEmpty())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResponseObj.builder()
                    .message("Null")
                    .status("400")
                    .data(null)
                    .build());
        return ResponseEntity.status(HttpStatus.OK).body(ResponseObj.builder()
                .message("OK")
                .status("400")
                .data(orderList)
                .build());
    }

    @Override
    public ResponseEntity<ResponseObj> createOrder(CreateOrderRequest createOrderRequest) {
        if(createOrderRequest == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResponseObj.builder()
                    .message("Null")
                    .status("400")
                    .data(null)
                    .build());
        Order order = new Order();
        order.setOrderStatus(createOrderRequest.getOrderStatus());
        order.setOrderTotalPrice(createOrderRequest.getOrderTotalPrice());
        orderRepository.save(order);
        return ResponseEntity.status(HttpStatus.OK).body(ResponseObj.builder()
                .message("OK")
                .status("200")
                .data(createOrderRequest)
                .build());
    }

    @Override
    public ResponseEntity<ResponseObj> updateOrder(Long id, CreateOrderRequest createOrderRequest) {
        Optional<Order> order = orderRepository.findById(id);
        if(!order.isPresent())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResponseObj.builder()
                    .message("Null")
                    .status("400")
                    .data(null)
                    .build());
        order.get().setOrderStatus(createOrderRequest.getOrderStatus());
        order.get().setOrderTotalPrice(createOrderRequest.getOrderTotalPrice());
        orderRepository.save(order.get());
        return ResponseEntity.status(HttpStatus.OK).body(ResponseObj.builder()
                .message("OK")
                .status("200")
                .data(order.get())
                .build());
    }

    @Override
    public ResponseEntity<ResponseObj> deleteOrder(Long id) {
        Optional<Order> order = orderRepository.findById(id);
        if(!order.isPresent())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResponseObj.builder()
                    .message("Null")
                    .status("400")
                    .data(null)
                    .build());
        order.get().setOrderStatus("Đã Hủy");
        orderRepository.save(order.get());
        return ResponseEntity.status(HttpStatus.OK).body(ResponseObj.builder()
                .message("OK")
                .status("200")
                .data(order.get())
                .build());

    }
}
