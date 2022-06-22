package com.wesley.stock.repository;

import com.wesley.stock.domain.Trade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class TradeRepository {

    private final EntityManager em;

    public void save(Trade trade) {
        em.persist(trade);
    }

    public Trade findOne(Long id) {
        return em.find(Trade.class, id);
    }

//    public List<Trade> findAll(TradeSearch tradeSearch) {
//
//    }

}
