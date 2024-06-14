package com.example.Payee.repository;


import com.example.Payee.model.neftDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface neftRepo extends JpaRepository<neftDetails, Long> {
    neftDetails findTopByOrderByIdDesc();
}
