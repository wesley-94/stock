package com.wesley.stock.web;

import com.querydsl.core.Tuple;
import com.wesley.stock.domain.*;
import com.wesley.stock.service.MemberService;
import com.wesley.stock.service.StockService;
import com.wesley.stock.service.TradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.querydsl.core.types.Projections.tuple;

@RestController
@RequiredArgsConstructor
public class TradeController {

    private final TradeService tradeService;
    private final MemberService memberService;
    private final StockService stockService;

    @GetMapping(value = "/trade")
    public String createForm(Model model) {
        List<Member> members = memberService.findMembers();
        List<Stock> stocks = stockService.findStocks();

        model.addAttribute("members", members);
        model.addAttribute("stocks", stocks);

        return "trade/tradeForm";
    }

    @PostMapping(value = "/trade")
    public void trade(@RequestBody TradeForm form) {
        // parameter 값 추출
        Long memberId = form.getMemberId();
        Long stockId = form.getStockId();
        int count = form.getCount();

        tradeService.trade(memberId, stockId, count);
//        return "redirect:/trades";
    }

    @PostMapping(value = "/trades")
    public Map tradeList(Model model, @RequestBody Map parameterMap) {
        Map returnMap = new HashMap();
        // 전체 거래 건수 count
        Long count = tradeService.count(parameterMap);
        returnMap.put("count", count);
        if (count > 0) {
            List trades = tradeService.findTrades(parameterMap);
            model.addAttribute("trades", trades);
            returnMap.put("trades", trades);

        } else {
            returnMap.put("trades", null);
        }
        return returnMap;
    }

    @PostMapping(value = "/trades/{tradeId}/cancel")
    public String cancelTrade(@PathVariable("tradeId") Long tradeId) {
        tradeService.cancelTrade(tradeId);
        return "redirect:/trades";
    }

}
