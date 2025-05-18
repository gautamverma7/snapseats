package com.mindframe.snapseat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        System.out.println("Received user: " + user);
        User saved = userService.save(user);
        System.out.println("Saved user: " + saved);
        return ResponseEntity.ok(saved);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.findAll();
    }
}
