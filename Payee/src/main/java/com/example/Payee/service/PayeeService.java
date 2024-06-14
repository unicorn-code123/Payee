package com.example.Payee.service;

import com.example.Payee.model.Payee;
import com.example.Payee.repository.PayeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PayeeService {

    private final PayeeRepository payeeRepo;

    @Autowired
    public PayeeService(PayeeRepository payeeRepo){
        this.payeeRepo=payeeRepo;
    }

    public Payee savePayee(Payee payee){
        return payeeRepo.save(payee);
    }
}
