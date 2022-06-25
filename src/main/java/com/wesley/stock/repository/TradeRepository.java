package com.wesley.stock.repository;

import com.wesley.stock.domain.Trade;
import com.wesley.stock.domain.TradeSearch;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
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
//        // ... 검색 로직
//    }

    // 우선 JPQL 로 처리 (-> 향후에 QueryDsl 로 변경 예정)
    public List<Trade> findAllByString(TradeSearch tradeSearch) {
        // language = JPQL
        String jpql = "select t from Trade t join t.member m";
        boolean isFirstCondition = true;

        // 거래 상태 검색
        if (tradeSearch.getTradeStatus() != null) {
            if (isFirstCondition) {
                jpql += "where";
                isFirstCondition = false;
            } else {
                jpql += "and";
            }
            jpql += " t.status = :status";
        }

        // 회원 이름 검색
        if (StringUtils.hasText(tradeSearch.getMemberName())) {
            if (isFirstCondition) {
                jpql += "where";
                isFirstCondition = false;
            } else {
                jpql += "and";
            }
            jpql += " m.name like :name";
        }

        TypedQuery<Trade> query = em.createQuery(jpql, Trade.class)
                .setMaxResults(1000);// 최대 1000건

        if (tradeSearch.getTradeStatus() != null) {
            query = query.setParameter("status", tradeSearch.getTradeStatus());
        }
        if (StringUtils.hasText(tradeSearch.getMemberName())) {
            query = query.setParameter("name", tradeSearch.getMemberName());
        }

        return query.getResultList();
    }
}
