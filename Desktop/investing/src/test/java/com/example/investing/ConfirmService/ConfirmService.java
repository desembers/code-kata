package com.example.investing.ConfirmService;

import com.example.investing.domain.auth.dto.SignRequestDto;
import com.example.investing.domain.auth.dto.SignResponsetDto;
import com.example.investing.domain.common.dto.AuthUser;
import com.example.investing.domain.common.exception.InValidException;
import com.example.investing.domain.confirm.entity.Confirm;
import com.example.investing.domain.confirm.repository.ConfromRepository;
import com.example.investing.domain.invest.entity.Invest;
import com.example.investing.domain.invest.repository.InvestRepository;
import com.example.investing.domain.user.enums.UserRule;
import com.example.investing.domain.user.repository.UserRepository;
import org.apache.catalina.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.List;
import java.util.Optional;

import static jdk.jfr.internal.jfc.model.Constraint.any;
import static org.awaitility.Awaitility.given;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ConfirmService {

    @Mock
    private ConfromRepository confromRepository;
    @Mock
    private UserRepository userRepository;
    @Mock
    private InvestRepository investRepository;
    @InjectMocks
    private ConfirmService confirmService;

    @Test
    public void confirm_조회시_confirm이없다면_NPE던져라() {
        long investId = 1L;
        given(investRepository.finById(investId)).willReturn(Optional.empty());

        InValidException exception = assertThrows(InValidException.class, () -> investRepository.Confirm(investId));
        assertEquals("Manager not found", exception.getMessage());

        @Test
        void todo의_user가_null인_경우_예외가_발생한다() {
            // given
            AuthUser authUser = new AuthUser(1L, "a@a.com", UserRule.USER);
            long todoId = 1L;
            long managerUserId = 2L;

            Invest todo = new Invest();
            ReflectionTestUtils.setField(todo, "user", null);

            SignRequestDto managerSaveRequest = new SignRequestDto(managerUserId);

            given(investRepository.findById(todoId)).willReturn(Optional.of(todo));

            // when & then
            InValidException exception = assertThrows(InValidException.class, () ->
                    investService.saveManager(authUser, todoId, managerSaveRequest)
            );

            assertEquals("일정을 생성한 유저만 담당자를 지정할 수 있습니다.", exception.getMessage());
        }

        @Test // 테스트코드 샘플
        public void manager_목록_조회에_성공한다() {
            // given
            long todoId = 1L;
            User user = new User("user1@example.com", "password", UserRule.USER);
            Invest todo = new Invest("Title", "Contents", "Sunny", user);
            ReflectionTestUtils.setField(todo, "id", todoId);

            Confirm mockManager = new Confirm(todo.getUsers(), todo);
            List<Confirm> managerList = List.of(mockManager);

            given(investRepository.findById(todoId)).willReturn(Optional.of(todo));
            given(confromRepository.findByTodoIdWithUser(todoId)).willReturn(managerList);

            // when
            List<SignResponsetDto> managerResponses = confromService.getManagers(todoId);

            // then
            assertEquals(1, managerResponses.size());
            assertEquals(mockManager.getId(), managerResponses.get(0).getId());
            assertEquals(mockManager.getUsers().getEmail(), managerResponses.get(0).getUsers().getEmail());
        }

        @Test // 테스트코드 샘플
        void todo가_정상적으로_등록된다() {
            // given
            AuthUser authUser = new AuthUser(1L, "a@a.com", UserRule.USER);
            User user = User.fromAuthUser(authUser);  // 일정을 만든 유저

            long todoId = 1L;
            Confirm todo = new Confirm("Test Title", "Test Contents", "Sunny", user);

            long managerUserId = 2L;
            User managerUser = new User("b@b.com", "password", UserRule.USER);  // 매니저로 등록할 유저
            ReflectionTestUtils.setField(managerUser, "id", managerUserId);

            SignRequestDto managerSaveRequest = new SignRequestDto(managerUserId); // request dto 생성

            given(confromRepository.findById(todoId)).willReturn(Optional.of(todo));
            given(userRepository.findById(managerUserId)).willReturn(Optional.of(managerUser));
            given(confromRepository.save(any(Confirm.class))).willAnswer(invocation -> invocation.getArgument(0));

            // when
            SignResponsetDto response = confirmService.saveManager(authUser, todoId, managerSaveRequest);

            // then
            assertNotNull(response);
            assertEquals(managerUser.getId(), response.getUsers().getId());
            assertEquals(managerUser.getEmail(), response.getUsers().getEmail());
        }

    }

}
