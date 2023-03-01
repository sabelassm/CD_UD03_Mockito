
package com.example; 

public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean isUserAdmin(String username) {
        User user = userRepository.findByUsername(username);
        return user != null && user.getRole().equals("admin");
    }
}
