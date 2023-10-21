package com.allin.Allin.Service;

import com.allin.Allin.Entity.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

    ResponseEntity<List<User>> getAllUser();

    ResponseEntity<User> getUserById(Long id);

    ResponseEntity<User> createUser(User user);

    ResponseEntity<User> deleteUser(Long id);

    ResponseEntity<User> updateUser(User user,Long id);
}
