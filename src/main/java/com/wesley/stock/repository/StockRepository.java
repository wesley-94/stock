package com.wesley.stock.repository;

import com.wesley.stock.domain.Stock;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class StockRepository {

    private final EntityManager em;

    public long count() {
        return em.createQuery("select count(*) from Stock s", Long.class)
                .getSingleResult();
    };

    public void save(Stock stock) {
        if (stock.getId() == null) {
            em.persist(stock);
        } else {
            em.merge(stock);
        }
    }

    public Stock findOne(Long id) {
        return em.find(Stock.class, id);
    }

    public List<Stock> findAll() {
        return em.createQuery("select s from Stock s", Stock.class).getResultList();
    }

    public List<Stock> selectStockByPaging(Map parameterMap) {
        int pageLimit = (int) parameterMap.get("pageLimit");
        int startIdx = ((int) parameterMap.get("currentPage") - 1) * pageLimit;

        return em.createQuery("select s from Stock s", Stock.class)
                .setFirstResult(startIdx)
                .setMaxResults(pageLimit)
                .getResultList();
    }

}
