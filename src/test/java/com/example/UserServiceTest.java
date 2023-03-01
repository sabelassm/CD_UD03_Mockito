package com.example;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    private UserService userService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        userService = new UserService(userRepository);
    }

    @Test
    public void testIsUserAdminWhenUserIsAdmin() {
        // Arrange
        User adminUser = new User("admin", "password", "admin");
        when(userRepository.findByUsername("admin")).thenReturn(adminUser);

        // Act
        boolean result = userService.isUserAdmin("admin");

        // Assert
        assertTrue(result);
    }

    @Test
    public void testIsUserAdminWhenUserIsNotAdmin() {
        // Arrange
        User regularUser = new User("johndoe", "password", "user");
        when(userRepository.findByUsername("johndoe")).thenReturn(regularUser);

        // Act
        boolean result = userService.isUserAdmin("johndoe");

        // Assert
        assertFalse(result);
    }
}
