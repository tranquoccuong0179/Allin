package com.allin.Allin.Repository;

import com.allin.Allin.Entity.CartDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<CartDetail, Long> {
}
