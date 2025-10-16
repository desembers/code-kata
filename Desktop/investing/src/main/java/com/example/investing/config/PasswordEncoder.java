package com.example.investing.config;

import at.favre.lib.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncoder {
       public String encode(String RawPassword) {
          return  BCrypt.withDefaults().hashToString(BCrypt.MIN_COST, RawPassword.toCharArray());
       }

       public boolean matche(String rawPassword, String encodedPassword) {
           BCrypt.Result result = BCrypt.verifyer().verify(rawPassword.toCharArray(), encodedPassword);
           return result.verified;
       }

}
