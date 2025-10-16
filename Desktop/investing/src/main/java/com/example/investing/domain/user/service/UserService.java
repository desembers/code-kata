package com.example.investing.domain.user.service;

import com.example.investing.config.PasswordEncoder;
import com.example.investing.domain.common.exception.InValidException;
import com.example.investing.domain.user.dto.request.UserChangePassword;
import com.example.investing.domain.user.dto.response.UserResponse;
import com.example.investing.domain.user.entity.Users;
import com.example.investing.domain.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
     private final UserRepository userRepository;
     private final PasswordEncoder passwordEncoder;

     @Transactional
     public UserResponse getUsers(long userId) {
         Users users = userRepository.findById(userId).orElseThrow(
                 () -> new InValidException("유저가 발견되지 않았습니다."));
         return new UserResponse(users.getId(), users.getEmail());
     }

     @Transactional
     public void chagnePasswords(long userId, UserChangePassword userChangePassword) {
         if(userChangePassword.getNowPassword().length() < 10 ||
            !userChangePassword.getNowPassword().matches("\\.d*") ||
            !userChangePassword.getNowPassword().matches("(?=.*[!@#$%^&*()_+-=\\\\[\\\\]{};':\\\"\\\\\\\\|,.<>/?])")) {
             throw new InValidException("비밀번호는 10자 미만이면 숫자아 특수문자가 포함되어야합니다");
         }

         Users users = userRepository.findById(userId).orElseThrow(
                 () -> new InValidException("유저가 발건되지 않았습니다")
         );

         if (passwordEncoder.matche(userChangePassword.getNowPassword(), users.getPassword())) {
             throw new InValidException("새비밀번호와 기존비밀번호가 같습니다.");
         }

         if(!passwordEncoder.matche(userChangePassword.getPastPassword(), users.getPassword())) {
             throw new InValidException("잘못된 비밀번호 입니다");
         }

         users.changePasswords(passwordEncoder.encode(userChangePassword.getNowPassword()));

         if(passwordEncoder.matche(userChangePassword.getPastPassword(), users.getPassword())) {
             throw new InValidException("기존 비밀번호와 같습니다");
         }
     }

}
