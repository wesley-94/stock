package com.wesley.stock.web;

import com.wesley.stock.domain.Member;
import com.wesley.stock.domain.Stock;
import com.wesley.stock.domain.Trade;
import com.wesley.stock.domain.TradeSearch;
import com.wesley.stock.service.MemberService;
import com.wesley.stock.service.StockService;
import com.wesley.stock.service.TradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
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
    public String trade(@RequestParam("memberId") Long memberId, @RequestParam("stockId") Long stockId,
                        @RequestParam("count") int count) {
        tradeService.trade(memberId, stockId, count);
        return "redirect:/trades";
    }

    @GetMapping(value = "/trades")
    public String tradeList(@ModelAttribute("tradeSearch") TradeSearch tradeSearch, Model model) {
        List<Trade> trades = tradeService.findTrades(tradeSearch);
        model.addAttribute("trades", trades);

        return "trade/tradeList";
    }

    @PostMapping(value = "/trades/{tradeId}/cancel")
    public String cancelTrade(@PathVariable("tradeId") Long tradeId) {
        tradeService.cancelTrade(tradeId);
        return "redirect:/trades";
    }

}
