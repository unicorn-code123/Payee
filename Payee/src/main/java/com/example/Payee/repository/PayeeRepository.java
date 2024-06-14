package com.example.Payee.repository;

import com.example.Payee.model.Payee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayeeRepository extends JpaRepository<Payee, Long> {
}
