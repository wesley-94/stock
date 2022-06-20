package com.wesley.stock.service;

import com.wesley.stock.domain.Stock;
import com.wesley.stock.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class StockService {

    private final StockRepository stockRepository;

    @Transactional
    public void saveStock(Stock stock) {
        stockRepository.save(stock);
    }

    public List<Stock> findStocks() {
        return stockRepository.findAll();
    }

    public Stock findOne(Long stockId) {
        return stockRepository.findOne(stockId);
    }

}
