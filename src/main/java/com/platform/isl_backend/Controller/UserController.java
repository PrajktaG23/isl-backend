package com.platform.isl_backend.Controller;

import com.platform.isl_backend.Entity.User;
import com.platform.isl_backend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        if (userService.existsByEmail(user.getEmail())) {
            return ResponseEntity.status(409).body("Email already exists. Please log in.");
        }
        userService.registerUser(user);
        return ResponseEntity.ok("User registered successfully.");
    }

//    @PostMapping("/login")
//    public ResponseEntity<String> loginUser(@RequestBody User user) {
//        User existingUser = userService.findUserByUsername(user.getUsername());
//        if (existingUser != null && existingUser.isEnabled()) {
//            return ResponseEntity.ok("Login successful.");
//        }
//
//        return ResponseEntity.badRequest().body("Invalid username or password.");
//    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody User user) {
        try {
            String token = userService.authenticateUser(user.getUsername(), user.getPassword());
            return ResponseEntity.ok("Login successful. Token: " + token);
        } catch (BadCredentialsException e) {
            return ResponseEntity.badRequest().body("Invalid username or password.");
        } catch (UsernameNotFoundException e) {
            return ResponseEntity.badRequest().body("User not found. Please register.");
        }
    }

}
