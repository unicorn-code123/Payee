package com.example.Payee.repository;


import com.example.Payee.model.impsDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface impsRepo extends JpaRepository<impsDetails, Integer> {
    impsDetails findTopByOrderByIdDesc();
}
