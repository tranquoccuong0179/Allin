package com.allin.Allin.Service;

import com.allin.Allin.Entity.CartDetail;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CartService {
    ResponseEntity<List<CartDetail>> getAllCart();
}
