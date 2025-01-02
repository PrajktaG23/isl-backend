package com.platform.isl_backend.Service;

import com.platform.isl_backend.Entity.User;

public interface UserService {
    void registerUser(User user);
    User findUserByUsername(String username);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);

    String authenticateUser(String username, String rawPassword);

    void deleteUserByUsername(String username);

}
