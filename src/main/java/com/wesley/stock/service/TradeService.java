package com.wesley.stock.service;

import com.wesley.stock.domain.*;
import com.wesley.stock.repository.MemberRepository;
import com.wesley.stock.repository.StockRepository;
import com.wesley.stock.repository.TradeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TradeService {

    private final MemberRepository memberRepository;
    private final TradeRepository tradeRepository;
    private final StockRepository stockRepository;

    /**
     * 전체 거래 건수 count
     */
    public long count(Map parameterMap) {
        return tradeRepository.count(parameterMap);
    }

    /**
     * 거래
     */
    @Transactional
    public Long trade(Long memberId, Long stockId, int count) {

        // 엔티티 조회
        Member member = memberRepository.findOne(memberId);
        Stock stock = stockRepository.findOne(stockId);

        // 증권사 정보 생성
        Company company = new Company();
        company.setAddress(member.getAddress());
        company.setStatus(CompanyStatus.READY);

        // 거래 주식 종목 생성
        TradeStock tradeStock = TradeStock.createTradeStock(stock, stock.getCurrentPrice(), count);

        // 거래 생성
        Trade trade = Trade.createTrade(member, company, tradeStock);

        // 거래 저장
        tradeRepository.save(trade);
        return trade.getId();

    }

    /**
     * 거래 취소
     */
    @Transactional
    public void cancelTrade(Long tradeId) {

        // 거래 엔티티 조회
        Trade trade = tradeRepository.findOne(tradeId);
        // 거래 취소
        trade.cancel();

    }

    /**
     * 거래 검색
     */
//    public List<Trade> findTrades(TradeSearch tradeSearch) {
//        return tradeRepository.findAll(tradeSearch);
//    }

//    public List<Trade> findTrades(TradeSearch tradeSearch) {
//        return tradeRepository.findAllByString(tradeSearch);
//    }

    public List findTrades(Map parameterMap) {
//        return tradeRepository.findAllByString(tradeSearch);
        return tradeRepository.selectTradeByPaging(parameterMap);
    }

}
