package com.allin.Allin.Service;

import com.allin.Allin.dto.Request.CreateCartRequest;
import com.allin.Allin.dto.Response.ResponseObj;
import org.springframework.http.ResponseEntity;

public interface CartService {
    ResponseEntity<ResponseObj> getAllCart();

    ResponseEntity<ResponseObj> createCart(CreateCartRequest createCartRequest);

    ResponseEntity<ResponseObj> updateCart(Long id, CreateCartRequest createCartRequest);

    ResponseEntity<ResponseObj> deleteCart(Long id);

    ResponseEntity<ResponseObj> getCartById(Long id);


}
