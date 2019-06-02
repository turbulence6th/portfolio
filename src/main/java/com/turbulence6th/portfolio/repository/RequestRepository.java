package com.turbulence6th.portfolio.repository;

import com.turbulence6th.portfolio.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface RequestRepository extends JpaRepository<Request, Long> {
    Optional<Request> findByIpAndDate(String ip, LocalDate date);
}
