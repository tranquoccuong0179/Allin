package com.allin.Allin.Repository;

import com.allin.Allin.Entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long> {
    List<Cart> findByCartQuantityGreaterThan(int quantity);
}
