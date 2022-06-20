package com.wesley.stock.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "trade")
@Getter @Setter
public class Trade {

    @Id @GeneratedValue
    @Column(name = "account_id")
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member; // 계좌 회원

    @OneToMany(mappedBy = "trade", cascade = CascadeType.ALL)
    private List<TradeStock> tradeStocks = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company; // 증권사 정보

    private LocalDateTime tradeDate; // 거래 시간

    @Enumerated(EnumType.STRING)
    private TradeStatus status; // 거래 상태 [TRADE, CANCEL]

    // == 연관 관계 메서드 == //
    public void setMember(Member member) {
        this.member = member;
        member.getTrade().add(this);
    }

    public void addTradeStock(TradeStock tradeStock) {
        tradeStocks.add(tradeStock);
        tradeStock.setTrade(this);
    }

    public void setCompany(Company company) {
        this.company = company;
        company.setTrade(this);
    }

}
