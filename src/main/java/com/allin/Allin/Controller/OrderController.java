package com.allin.Allin.Controller;


import com.allin.Allin.Service.OrderService;
import com.allin.Allin.dto.Request.CreateOrderRequest;
import com.allin.Allin.dto.Response.ResponseObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/getAllOrder")
    public ResponseEntity<ResponseObj> getAllOrder(){
        return orderService.getAllOrder();
    }

    @PostMapping("/createOrder")
    public ResponseEntity<ResponseObj> createOrder(@RequestBody CreateOrderRequest createOrderRequest){
        return orderService.createOrder(createOrderRequest);
    }

    @PatchMapping("/updateOrder/{id}")
    public ResponseEntity<ResponseObj> updateOrder(@PathVariable Long id, @RequestBody CreateOrderRequest createOrderRequest){
        return orderService.updateOrder(id, createOrderRequest);
    }

    @PatchMapping("/deleteOrder/{id}")
    public ResponseEntity<ResponseObj> deleteOrder(@PathVariable Long id){
        return orderService.deleteOrder(id);
    }

}
