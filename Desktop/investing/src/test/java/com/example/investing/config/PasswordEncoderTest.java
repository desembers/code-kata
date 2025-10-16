package com.example.investing.config;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
public class PasswordEncoderTest {
    @InjectMocks
    private PasswordEncoder passwordEncoder;

    @Test
    void matchs_메서드() {
        String password = "testPassword";
        String encoderPassword = passwordEncoder.encode(password);

        boolean matchs = passwordEncoder.matche(encoderPassword, password);

        assertTrue(matchs);
    }

}
