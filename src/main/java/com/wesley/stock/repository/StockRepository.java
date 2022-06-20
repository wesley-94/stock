package com.wesley.stock.repository;

import com.wesley.stock.domain.Stock;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class StockRepository {

    private final EntityManager em;

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

}
