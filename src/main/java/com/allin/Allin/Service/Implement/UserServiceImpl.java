package com.allin.Allin.Service.Implement;

import com.allin.Allin.Entity.User;
import com.allin.Allin.Repository.UserRepository;
import com.allin.Allin.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public ResponseEntity<List<User>> getAllUser() {
     List<User> userList =  userRepository.findAllByStatusIsTrue();
     if (userList.isEmpty())
         return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
     else
         return ResponseEntity.status(HttpStatus.OK).body(userList);
    }

    @Override
    public ResponseEntity<User> createUser(User user) {
        userRepository.save(user);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @Override
    public ResponseEntity<User> deleteUser(Long id) {
        User user = userRepository.findById(id).get();
        if(user == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        else {
            user.setStatus(false);
            userRepository.save(user);
            return ResponseEntity.status(HttpStatus.OK).body(user);
        }

    }

    @Override
    public ResponseEntity<User> getUserById(Long id) {
        Optional<User> user =  userRepository.findById(id);
        if (!user.isPresent())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        else
            return ResponseEntity.status(HttpStatus.OK).body(user.get());
    }

    @Override
    public ResponseEntity<User> updateUser(User userUpdate,Long id) {
        User userCurrent = userRepository.findById(id).get();
        if (userCurrent == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        else {

            userCurrent.setFirstname(userUpdate.getFirstname());
            userCurrent.setLastname(userUpdate.getLastname());
            userCurrent.setPassword(userUpdate.getPassword());
            userCurrent.setPhone(userUpdate.getPhone());
            userCurrent.setEmail(userUpdate.getEmail());
            userCurrent.setRole(userUpdate.getRole());
            userCurrent.setStatus(userUpdate.getStatus());
            userRepository.save(userCurrent);
            return ResponseEntity.status(HttpStatus.OK).body(userCurrent);
        }
    }


}
