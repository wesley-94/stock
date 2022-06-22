package com.wesley.stock.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Company {

    @Id @GeneratedValue
    @Column(name = "company_id")
    private Long id;

    @OneToOne(mappedBy = "company", fetch = FetchType.LAZY)
    private Trade trade;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private CompanyStatus status; // [READY(준비), COMPLETE(완료)]

}
