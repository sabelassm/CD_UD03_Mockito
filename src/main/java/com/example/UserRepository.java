package com.example; 

public interface UserRepository {
    User findByUsername(String username);
}
