package com.example.investing.domain.invest.repository;

import com.example.investing.domain.invest.entity.Invest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface InvestRepository {
    @Query("SELECT I FROM Invest I LEFT JOIN FETCH I.users u ORDER BY I.updatedAt DESC")
    Page<Invest> findAllByOrderDesc(Pageable pageable);

    @Query("select I from Invest I" + "left join fetch I.user" + "Where I.id = :investId")
    Optional<Invest> findByInvestUserId(@Param("investId") Long investId);

    int countById(Long investId);

    Invest finById(Long investId);

}
