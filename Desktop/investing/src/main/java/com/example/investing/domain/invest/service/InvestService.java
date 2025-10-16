package com.example.investing.domain.invest.service;


import com.example.investing.domain.common.exception.InValidException;
import com.example.investing.domain.invest.dto.response.InvetResponse;
import com.example.investing.domain.invest.entity.Invest;
import com.example.investing.domain.invest.repository.InvestRepository;
import com.example.investing.domain.user.dto.response.UserResponse;
import com.example.investing.domain.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InvestService {

    private InvestRepository investRepository;

    @Transactional
    public Page<InvetResponse> getInvests(int pages, int sizes) {
        Pageable pageable = PageRequest.of(pages, sizes);

        Page<Invest> invests = investRepository.findAllByOrderDesc(pageable);

        return invests.map(invest -> new InvetResponse(
                invest.getId(),
                invest.getInvest(),
                invest.getContents(),
                invest.getCondition(),
                new UserResponse(invest.getUsers().getId(), invest.getUsers().getEmail()),
                invest.getCreatedAt(),
                invest.getUpdatedAt()
        ));

    }

    @Transactional
    public InvetResponse getInvest(Long investId) {
        Invest invest = investRepository.findByInvestUserId(investId).orElseThrow(
                () -> new InValidException("유저가 존재하지 않습니다"));


    }

}
