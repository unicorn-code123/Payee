package com.example.Payee.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class rtgsDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String fromAccount;
    private String toAccount;
    private String amount;
    private String date;
    private String instruction;
    private String remark;

    @Override
    public String toString() {
        return "rtgsDetails{" +
                "id=" + id +
                ", fromAccount='" + fromAccount + '\'' +
                ", toAccount='" + toAccount + '\'' +
                ", amount='" + amount + '\'' +
                ", date='" + date + '\'' +
                ", instruction='" + instruction + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}