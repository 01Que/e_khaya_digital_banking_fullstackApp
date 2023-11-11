package com.mensarii.e_khaya_digital_bank.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class SmallMediumMicroEnterprise {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String name;
    private String email;
    private String imgURL;
    private String category;
    private String phone;
    private String size;
    private Double monthlyExpenses;
    @Column(nullable = false, updatable = false)
    private String code;
}
