package com.allin.Allin.Repository;

import com.allin.Allin.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByProductQuantityGreaterThan(int quantity);
}
