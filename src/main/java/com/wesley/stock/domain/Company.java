package com.wesley.stock.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Company {

    @Id @GeneratedValue
    @Column(name = "company_id")
    private Long id;

    @OneToOne(mappedBy = "company", fetch = FetchType.LAZY)
    private Trade trade;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private CompanyStatus status; // [READY(준비), OPEN(개설)]

}
