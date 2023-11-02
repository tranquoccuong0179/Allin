package com.allin.Allin.Service.Implement;

import com.allin.Allin.Entity.Cart;
import com.allin.Allin.Repository.CartRepository;
import com.allin.Allin.Service.CartService;
import com.allin.Allin.dto.Request.CreateCartRequest;
import com.allin.Allin.dto.Response.ResponseObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartRepository cartRepository;

    @Override
    public ResponseEntity<ResponseObj> getAllCart() {
        List<Cart> cartList = cartRepository.findByCartQuantityGreaterThan(0);
        if(cartList.isEmpty())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResponseObj.builder()
                    .message("Null")
                    .status("400")
                    .data(null)
                    .build());
        return ResponseEntity.status(HttpStatus.OK).body(ResponseObj.builder()
                .message("OK")
                .status("200")
                .data(cartList)
                .build());
    }

    @Override
    public ResponseEntity<ResponseObj> createCart(CreateCartRequest createCartRequest) {
        if(createCartRequest == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResponseObj.builder()
                    .message("Null")
                    .status("400")
                    .data(null)
                    .build());

        Cart cart = new Cart();
        cart.setCartPrice(createCartRequest.getCartPrice());
        cart.setCartQuantity(createCartRequest.getCartQuantity());
        cartRepository.save(cart);

        return ResponseEntity.status(HttpStatus.OK).body(ResponseObj.builder()
                .message("OK")
                .status("200")
                .data(createCartRequest)
                .build());
    }

    @Override
    public ResponseEntity<ResponseObj> updateCart(Long id, CreateCartRequest createCartRequest) {
        Optional<Cart> cart = cartRepository.findById(id);
        if(!cart.isPresent())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResponseObj.builder()
                    .message("Null")
                    .status("400")
                    .data(null)
                    .build());
        cart.get().setCartPrice(createCartRequest.getCartPrice());
        cart.get().setCartQuantity(createCartRequest.getCartQuantity());
        cartRepository.save(cart.get());
        return ResponseEntity.status(HttpStatus.OK).body(ResponseObj.builder()
                .message("OK")
                .status("200")
                .data(cart.get())
                .build());
    }

    @Override
    public ResponseEntity<ResponseObj> deleteCart(Long id) {
        Optional<Cart> cart = cartRepository.findById(id);
        if(!cart.isPresent())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResponseObj.builder()
                    .message("Null")
                    .status("400")
                    .data(null)
                    .build());
        cart.get().setCartQuantity(0);
        cartRepository.save(cart.get());
        return ResponseEntity.status(HttpStatus.OK).body(ResponseObj.builder()
                .message("OK")
                .status("200")
                .data(cart.get())
                .build());
    }

    @Override
    public ResponseEntity<ResponseObj> getCartById(Long id) {
        Optional<Cart> cart = cartRepository.findById(id);
        if(!cart.isPresent())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResponseObj.builder()
                    .message("Null")
                    .status("400")
                    .data(null)
                    .build());

        return ResponseEntity.status(HttpStatus.OK).body(ResponseObj.builder()
                .message("Ok")
                .status("200")
                .data(cart.get())
                .build());
    }
}
