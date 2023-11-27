package com.allin.Allin.Controller;

import com.allin.Allin.Entity.User;
import com.allin.Allin.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@PreAuthorize("hasRole('ADMIN')")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/getUsers")
    @PreAuthorize("hasAnyAuthority('admin:read')")
    public ResponseEntity<List<User>> getAllUser() {

        return userService.getAllUser();
    }

    @GetMapping("/getUser/{id}")
    @PreAuthorize("hasAnyAuthority('admin:read')")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping("/createUser")
    @PreAuthorize("hasAnyAuthority('admin:create')")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PatchMapping("/deleteUser/{id}")
    @PreAuthorize("hasAnyAuthority('admin:delete')")
    public ResponseEntity<User> deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id);
    }

    @PatchMapping("/updateUser/{id}")
    @PreAuthorize("hasAnyAuthority('admin:update')")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser(user, id);
    }


}
