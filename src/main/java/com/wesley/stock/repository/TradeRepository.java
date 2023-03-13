package com.wesley.stock.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.wesley.stock.annotation.Trace;
import com.wesley.stock.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public long count(Map parameterMap) {
        // language = JPQL
        String jpql = "select count(t) from Trade t join t.member m";
        boolean isFirstCondition = true;

        // 거래 상태 검색
        if ((String) parameterMap.get("status") != null) {
            if (isFirstCondition) {
                jpql += " where";
                isFirstCondition = false;
            } else {
                jpql += " and";
            }
            jpql += " t.status = :status";
        }

        // 회원 이름 검색
        if ((String) parameterMap.get("name") != null) {
            if (isFirstCondition) {
                jpql += "where";
                isFirstCondition = false;
            } else {
                jpql += " and";
            }
            jpql += " m.name like :name";
        }

        TypedQuery<Long> query = em.createQuery(jpql, Long.class);
//                .setMaxResults(1000);// 최대 1000건

        if ((String) parameterMap.get("status") != null) {
            if ("TRADE".equals((String) parameterMap.get("status"))) {
                query = query.setParameter("status", TradeStatus.TRADE);
            } else {
                query = query.setParameter("status", TradeStatus.CANCEL);
            }
        }
        if ((String) parameterMap.get("name") != null) {
            query = query.setParameter("name", (String) parameterMap.get("name"));
        }

        return query.getSingleResult();
    }

    public List selectTradeByPaging(Map parameterMap) {
        // language = JPQL
        String jpql = "select t.id, m.name, s.stockName, ts.tradePrice, ts.count, t.status " +
                "from Trade t join t.member m join t.tradeStocks ts join ts.stock s";
        boolean isFirstCondition = true;

        int pageLimit = (int) parameterMap.get("pageLimit");
        int startIdx = ((int) parameterMap.get("currentPage") - 1) * pageLimit;

        // 거래 상태 검색
        if ((String) parameterMap.get("status") != null) {
            if (isFirstCondition) {
                jpql += " where";
                isFirstCondition = false;
            } else {
                jpql += " and";
            }
            jpql += " t.status = :status";
        }

        // 회원 이름 검색
        if ((String) parameterMap.get("name") != null) {
            if (isFirstCondition) {
                jpql += "where";
                isFirstCondition = false;
            } else {
                jpql += " and";
            }
            jpql += " m.name like :name";
        }

        Query query = em.createQuery(jpql)
                .setFirstResult(startIdx)
                .setMaxResults(pageLimit);
//                .setMaxResults(1000);// 최대 1000건

        if ((String) parameterMap.get("status") != null) {
            if ("TRADE".equals((String) parameterMap.get("status"))) {
                query = query.setParameter("status", TradeStatus.TRADE);
            } else {
                query = query.setParameter("status", TradeStatus.CANCEL);
            }
        }
        if ((String) parameterMap.get("name") != null) {
            query = query.setParameter("name", (String) parameterMap.get("name"));
        }

        return query.getResultList();
    }

    // QueryDsl 활용
    public List tradeWithQueryDsl(Map parameterMap) {

        int pageLimit = (int) parameterMap.get("pageLimit");
        int startIdx = ((int) parameterMap.get("currentPage") - 1) * pageLimit;

        JPAQueryFactory queryFactory = new JPAQueryFactory(em);

        QTrade trade = QTrade.trade;
        QMember member = QMember.member;
        QTradeStock tradeStock = QTradeStock.tradeStock;
        QStock stock = QStock.stock;

        BooleanBuilder builder = new BooleanBuilder();

        // 거래 상태 검색
        if ((String) parameterMap.get("status") != null) {
            if ("TRADE".equals((String) parameterMap.get("status"))) {
                builder.and(trade.status.eq(TradeStatus.TRADE));
            } else {
                builder.and(trade.status.eq(TradeStatus.CANCEL));
            }
        }

        // 회원 이름 검색
        if ((String) parameterMap.get("name") != null) {
            builder.and(member.name.eq((String) parameterMap.get("name")));
        }

        List<Tuple> result = queryFactory.select(trade.id, member.name, stock.stockName,
                        tradeStock.tradePrice, tradeStock.count, trade.status)
                .from(trade)
                .join(trade.member, member)
                .join(trade.tradeStocks, tradeStock)
                .join(tradeStock.stock, stock)
                .where(builder)
                .offset(startIdx)
                .limit(pageLimit)
                .fetch();

        List finalList = new ArrayList();
        for (Tuple row : result) {
            Map tempMap = new HashMap();
            tempMap.put("id", row.get(trade.id));
            tempMap.put("memberName", row.get(member.name));
            tempMap.put("stockName", row.get(stock.stockName));
            tempMap.put("tradePrice", row.get(tradeStock.tradePrice));
            tempMap.put("quantity", row.get(tradeStock.count));
            tempMap.put("status", row.get(trade.status));
            finalList.add(tempMap);
        }

        return finalList;
    }

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
                jpql += " and";
            }
            jpql += " t.status = :status";
        }

        // 회원 이름 검색
        if (StringUtils.hasText(tradeSearch.getMemberName())) {
            if (isFirstCondition) {
                jpql += "where";
                isFirstCondition = false;
            } else {
                jpql += " and";
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
