package com.example.Payee.repository;


import com.example.Payee.model.rtgsDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface rtgsRepo extends JpaRepository<rtgsDetails, Long> {
    rtgsDetails findTopByOrderByIdDesc();
}