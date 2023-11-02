package com.allin.Allin.Controller;

import com.allin.Allin.Service.CartService;
import com.allin.Allin.dto.Request.CreateCartRequest;
import com.allin.Allin.dto.Response.ResponseObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    @Autowired
    CartService cartService;

    @GetMapping("/getCarts")
    public ResponseEntity<ResponseObj> getAllCart(){
        return cartService.getAllCart();
    }

    @PostMapping("/createCart")
    public ResponseEntity<ResponseObj> createCart(@RequestBody CreateCartRequest createCartRequest){
        return cartService.createCart(createCartRequest);
    }

    @PatchMapping("/updateCart/{id}")
    public ResponseEntity<ResponseObj> updateCart(@PathVariable Long id, @RequestBody CreateCartRequest createCartRequest){
        return cartService.updateCart(id, createCartRequest);
    }

    @PatchMapping("/deleteCart/{id}")
    public ResponseEntity<ResponseObj> deleteCart(@PathVariable Long id){
        return cartService.deleteCart(id);
    }

    @GetMapping("/getCartById/{id}")
    public ResponseEntity<ResponseObj> getCartById(@PathVariable Long id){
        return cartService.getCartById(id);
    }
}
