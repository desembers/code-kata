package com.example.investing.domain.confirm.service;

import com.example.investing.domain.common.dto.AuthUser;
import com.example.investing.domain.common.exception.InValidException;
import com.example.investing.domain.confirm.dto.request.ConfirmSaveRequest;
import com.example.investing.domain.confirm.dto.response.ConfirmResponse;
import com.example.investing.domain.confirm.entity.Confirm;
import com.example.investing.domain.confirm.repository.ConfromRepository;
import com.example.investing.domain.invest.entity.Invest;
import com.example.investing.domain.invest.repository.InvestRepository;
import com.example.investing.domain.user.dto.response.UserResponse;
import com.example.investing.domain.user.entity.Users;
import com.example.investing.domain.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ConfirmService {
    private final ConfromRepository confromRepository;
    private final UserRepository userRepository;
    private InvestRepository investRepository;

    @Transactional
    public ConfirmResponse saveConfirm(AuthUser authUser, Long investId, ConfirmSaveRequest request) {
         Users users = Users.fromAuthUsers(authUser);
         Invest invest = investRepository.finById(investId).orElseThrow(
                 () -> new InValidException("투자가 되지 않았습니다."));

         if(!ObjectUtils.nullSafeEquals(users.getId(), invest.getId())) {
             throw new InValidException("확인자가 지정할수 있습니다.");
         }

         Users users2 = userRepository.findById(request.getConfirmuserId()).orElseThrow(
                 () -> new InValidException("투자 담당자로 등록할수 없습니다")
         );

         if(ObjectUtils.nullSafeEquals(users.getId(), users2.getId())) {
             throw new InValidException("본인 투자 담당자로 등록할수 없습니다.");
         }

        Confirm nowconfirm = new Confirm(users, invest);
        Confirm saveconfirm = confromRepository.save(nowconfirm);

        return new ConfirmResponse(
           saveconfirm.getId(),
           new UserResponse(users.getId(), users.getEmail())
        );
    }

    @Transactional
    public List<ConfirmResponse> getConfirm(long investId) {
        Invest invest = investRepository.findById(investId)
                .orElseThrow(() -> new InValidException("유저가 존재하지 않습니다"));

        List<ConfirmResponse> confirmList = confromRepository.findByInvestIdWithUser(investId);

        List<ConfirmResponse> dtoList = new ArrayList<>();
        for (Confirm confirm : confirmList) {
            Users users = confirm.getUsers();
            dtoList.add(new ConfirmResponse(
                    confirm.getId(),
                    new UserResponse(users.getId(), users.getEmail())
            ));
        }
        return dtoList;
    }

    @Transactional
    public void deleteManager(long userId, long todoId, long managerId) {
        Users user = userRepository.findById(userId)
                .orElseThrow(() -> new InValidException("User not found"));

        Invest todo = InvestRepository.findById(todoId)
                .orElseThrow(() -> new InValidException("Todo not found"));

        if (todo.getUsers() == null || !ObjectUtils.nullSafeEquals(user.getId(), todo.getUsers().getId())) {
            throw new InValidException("해당 일정을 만든 유저가 유효하지 않습니다.");
        }

        Confirm confirm = confromRepository.findById(managerId)
                .orElseThrow(() -> new InValidException("Manager not found"));

        if (!ObjectUtils.nullSafeEquals(todo.getId(), confirm.getInvest().getId())) {
            throw new InValidException("해당 일정에 등록된 담당자가 아닙니다.");
        }

        confromRepository.delete(confirm);
    }

}
