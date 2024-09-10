package com.SpringCourse.Startup.wallet;

import jakarta.persistence.*;

@Entity
public class Wallet {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "wallet_id"
    )
    @SequenceGenerator(
            allocationSize = 1,
            name = "wallet_id",
            sequenceName = "wallet_id"
    )
    private Integer id;
    private String bankAccountNumber;
}
