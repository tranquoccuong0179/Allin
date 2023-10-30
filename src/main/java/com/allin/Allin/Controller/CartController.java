package com.allin.Allin.Controller;

import com.allin.Allin.Entity.CartDetail;
import com.allin.Allin.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    @Autowired
    CartService cartService;

    @GetMapping("/getCarts")
    public ResponseEntity<List<CartDetail>> getAllCart(){
        return cartService.getAllCart();
    }
}
