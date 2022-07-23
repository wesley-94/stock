package com.wesley.stock.service;

import com.wesley.stock.domain.*;
import com.wesley.stock.exception.NotEnoughStockException;
import com.wesley.stock.repository.TradeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class TradeServiceTest {

    @PersistenceContext
    EntityManager em;

    @Autowired
    TradeService tradeService;

    @Autowired
    TradeRepository tradeRepository;

//    @Test
//    public void tradeStock() throws Exception {
//        // given
//        Member member = createMember();
//        Stock stock = createStock("현대차", 180000, 10); // stock class 내용대로 생성 ?
//        int tradeCount = 2;
//
//        // when
//        Long tradeId = tradeService.trade(member.getId(), stock.getId(), tradeCount);
//
//        // then
//        Trade getTrade = tradeRepository.findOne(tradeId);
//
//        assertEquals("종목 주문시 상태는 TRADE", TradeStatus.TRADE, getTrade.getStatus());
//        assertEquals("거래한 주식 종목 수가 정확해야 한다.", 1, getTrade.getTradeStocks().size());
//        assertEquals("거래 가격은 가격 * 수량이다.", 180000 * 2, getTrade.getTotalPrice());
//        assertEquals("거래 수량만큼 미 거래 수량이 줄어야 한다.", 8, stock.getQuantity());
//    }

//    @Test(expected = NotEnoughStockException.class)
//    public void overTrade() throws Exception {
//        // given
//        Member member = createMember();
//        Stock stock = createStock("현대차", 180000, 10); // stock class 내용대로 생성 ?
//        int tradeCount = 11; // 미 거래 수량보다 많은 수량
//
//        // when
//        tradeService.trade(member.getId(), stock.getId(), tradeCount);
//
//        // then
//        fail("미 거래 수량 부족 예외가 발생해야 한다.");
//    }

//    @Test
//    public void cancelTrade() {
//        // given
//        Member member = createMember();
//        Stock stock = createStock("현대차", 180000, 10); // stock class 내용대로 생성 ?
//        int tradeCount = 2;
//
//        Long tradeId = tradeService.trade(member.getId(), stock.getId(), tradeCount);
//
//        // when
//        tradeService.cancelTrade(tradeId);
//
//        // then
//        Trade getTrade = tradeRepository.findOne(tradeId);
//
//        assertEquals("거래 취소시 상태는 CANCEL 이다.", TradeStatus.CANCEL, getTrade.getStatus());
//        assertEquals("거래가 취소된 상품은 그만큼 미거래 수량이 증가해야 한다.", 10, stock.getQuantity());
//
//    }

    private Member createMember() {
        Member member = new Member();
        member.setName("회원1");
        member.setAddress(new Address("서울", "여의도", "123-123"));
        em.persist(member);
        return member;
    }

    private Stock createStock(String stockName, String sector, int currentPrice, int allTimeHighPrice, int allTimeLowPrice,
                              double priceEarningRatio, double estimatePER, double priceBookValueRatio, double dividendRate,
                              int quantity) {
        Stock stock = new Stock();
        stock.setStockName(stockName);
        stock.setSector(sector);
        stock.setCurrentPrice(currentPrice);
        stock.setAllTimeHighPrice(allTimeHighPrice);
        stock.setAllTimeLowPrice(allTimeLowPrice);
        stock.setPriceEarningRatio(priceEarningRatio);
        stock.setEstimatePER(estimatePER);
        stock.setPriceBookValueRatio(priceBookValueRatio);
        stock.setDividendRate(dividendRate);
        stock.setQuantity(quantity);
        em.persist(stock);
        return stock;
    }

}
