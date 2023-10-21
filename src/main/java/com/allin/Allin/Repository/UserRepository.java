package com.allin.Allin.Repository;

import com.allin.Allin.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllByStatusIsTrue();
}
