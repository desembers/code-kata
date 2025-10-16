package com.example.investing.domain.user.service;

import com.example.investing.domain.common.exception.InValidException;
import com.example.investing.domain.user.dto.request.UserRuleChangeRequest;
import com.example.investing.domain.user.entity.Users;
import com.example.investing.domain.user.enums.UserRule;
import com.example.investing.domain.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserAdminService {
     private final UserRepository userRepository;

     @Transactional
     public void changeUserRule(long userId, UserRuleChangeRequest userRuleChangeRequest) {
         Users users = userRepository.findById(userId).orElseThrow(
                 () -> new InValidException("유저가 발견되지 않았습니다."));
         users.UpdateRule(UserRule.of(userRuleChangeRequest.getRule()));
     }

}
