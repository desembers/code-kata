package com.example.investing.domain.confirm.repository;

import com.example.investing.domain.confirm.dto.response.ConfirmResponse;
import com.example.investing.domain.confirm.entity.Confirm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ConfromRepository extends JpaRepository<Confirm, Long> {

    @Query("select c from Confirm c Join Fetch c.users  where c.invest.id = :investId")
    List<ConfirmResponse> findByInvestIdWithUser(@Param("investId") Long investId);
}
