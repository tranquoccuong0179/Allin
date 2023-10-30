package com.allin.Allin.Service.Implement;

import com.allin.Allin.Entity.CartDetail;
import com.allin.Allin.Repository.CartRepository;
import com.allin.Allin.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartRepository cartRepository;

    @Override
    public ResponseEntity<List<CartDetail>> getAllCart() {
        List<CartDetail> cartList =  cartRepository.findAll();
        if (cartList.isEmpty())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        else
            return ResponseEntity.status(HttpStatus.OK).body(cartList);
    }

}
