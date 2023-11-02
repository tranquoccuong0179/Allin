package com.allin.Allin.Repository;

import com.allin.Allin.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByOrOrderStatusNotLike(String status);
}
