package com.wesley.stock.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private Trade trade;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private CompanyStatus status; // [READY(준비), COMPLETE(완료)]

}
