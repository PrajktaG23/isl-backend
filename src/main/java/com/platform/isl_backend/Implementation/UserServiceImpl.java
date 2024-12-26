package com.platform.isl_backend.Implementation;

import com.platform.isl_backend.Config.JwtTokenGenerator;
import com.platform.isl_backend.Entity.User;
import com.platform.isl_backend.Repository.UserRepository;
import com.platform.isl_backend.Service.EmailService;
import com.platform.isl_backend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenGenerator jwtTokenGenerator;

    @Autowired
    private EmailService emailService;

    @Override
    public void registerUser(User user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(true);
        userRepository.save(user);

        // Send a welcome email
        emailService.sendWelcomeEmail(user.getEmail(), user.getUsername());
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

    }

    @Override
    public boolean existsByUsername(String username) {
        return userRepository.findByUsername(username).isPresent();
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

    @Override
    public String authenticateUser(String username, String rawPassword) {
        User user = findUserByUsername(username);

        if (passwordEncoder.matches(rawPassword, user.getPassword())) {
            return jwtTokenGenerator.generateToken(username); // Use JwtTokenGenerator
        }

        throw new BadCredentialsException("Invalid username or password.");
    }
}
