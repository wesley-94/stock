package com.wesley.stock.service;

import com.wesley.stock.domain.Stock;
import com.wesley.stock.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class StockService {

    private final StockRepository stockRepository;

    /**
     * 전체 회원 건수 count
     */
    public long count() {
        return stockRepository.count();
    }

    @Transactional
    public void saveStock(Stock stock) {
        stockRepository.save(stock);
    }

    @Transactional
    public void deleteStock(Long stockId) {
        stockRepository.delete(stockId);
    }

    public List<Stock> findStocks() {
        return stockRepository.findAll();
    }

    public List<Stock> findStocks(Map parameterMap) {
//        return stockRepository.findAll();
        if (parameterMap.get("pageLimit") == null) {
            return stockRepository.findAll();
        } else {
            return stockRepository.selectStockByPaging(parameterMap);
        }
    }

    public Stock findOne(Long stockId) {
        return stockRepository.findOne(stockId);
    }

}
