package com.example.investing.domain.auth.service;

import com.example.investing.config.JwtUtil;
import com.example.investing.config.PasswordEncoder;
import com.example.investing.domain.auth.dto.SignRequestDto;
import com.example.investing.domain.auth.dto.SignResponsetDto;
import com.example.investing.domain.auth.exception.AuthException;
import com.example.investing.domain.common.exception.InValidException;
import com.example.investing.domain.user.enums.UserRule;
import com.example.investing.domain.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private JwtUtil jwtUtil;

    @Transactional
    public SignResponsetDto sign(SignRequestDto requestDto) {
        String password = passwordEncoder.encode(requestDto.getPassword());

        UserRule userRule = UserRule.of(requestDto.getUserRule());

        if(userRepository.existsByEmail(requestDto.getEmail())) {
            throw new InValidException("이미 존재하는 이메일입니다.");
        }

        User newUser = new User(
                requestDto.getEmail(),
                password,
                userRule
        );
        User savedUser = userRepository.save(newUser);

        String bearerToken = jwtUtil.createToken(savedUser.getId(), savedUser.getEmail(), userRule);

        return new SignResponsetDto(bearerToken);
    }

   @Transactional
   public SignResponsetDto logout(SignRequestDto requestDto) {
        User users = userRepository.findByEmail(requestDto.getEmail()).orElseThrow(
                () -> new InValidException("가입되지 않은 유저입니다."));

       // 로그인 시 이메일과 비밀번호가 일치하지 않을 경우 401을 반환합니다.
       if(!passwordEncoder.matche(requestDto.getPassword(), users.getPassword())) {
           throw new AuthException("잘못된 비밀번호 입니다.");
       }

       String bearerToken = jwtUtil.createToken(users.getId(), users.getEmail(), users.getRule());
       return new SignResponsetDto(bearerToken);
   }

}
