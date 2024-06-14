package com.example.Payee.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class impsDetails {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String From_Account;
    private String To_Account;
    private String Amount;
    private String Date;
    private String Instruction;
    private String Remark;


    @Override
    public String toString() {
        return "imps{" +
                "id=" + id +
                ", From_Account='" + From_Account + '\'' +
                ", To_Account='" + To_Account + '\'' +
                ", Amount='" + Amount + '\'' +
                ", Date='" + Date + '\'' +
                ", Instruction='" + Instruction + '\'' +
                ", Remark='" + Remark + '\'' +
                '}';
    }
}