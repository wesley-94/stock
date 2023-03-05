package com.wesley.stock.web;

import com.wesley.stock.domain.Member;
import com.wesley.stock.domain.Stock;
import com.wesley.stock.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class StockController {

    private final StockService stockService;

    @GetMapping(value = "/stocks/new")
    public String createForm(Model model) {
        model.addAttribute("form", new StockForm());

        return "stocks/createStockForm";
    }

    @PostMapping(value = "/stocks/new")
    public void create(@RequestBody StockForm form) {

        Stock stock = new Stock();
        stock.setStockName(form.getStockName());
        stock.setSector(form.getSector());
        stock.setCurrentPrice(form.getCurrentPrice());
        stock.setAllTimeHighPrice(form.getAllTimeHighPrice());
        stock.setAllTimeLowPrice(form.getAllTimeLowPrice());
        stock.setPriceEarningRatio(form.getPriceEarningRatio());
        stock.setEstimatePER(form.getEstimatePER());
        stock.setPriceBookValueRatio(form.getPriceBookValueRatio());
        stock.setDividendRate(form.getDividendRate());
        stock.setQuantity(form.getQuantity());

        stockService.saveStock(stock);
//        return "redirect:/stocks";
    }

    /**
     * 주식 종목 목록
     */
    @PostMapping(value = "/stocks")
    public Map list(Model model, @RequestBody Map parameterMap) {
        Map returnMap = new HashMap();
        // 전체 주식 종목 건수 count
        Long count = stockService.count();
        returnMap.put("count", count);
        if (count > 0) {
            List<Stock> stocks = stockService.findStocks(parameterMap);
            model.addAttribute("stocks", stocks);
            returnMap.put("stocks", stocks);
        }
        return returnMap;
    }

    @PostMapping(value = "/stocks/id")
    public Stock selectStockById(Model model, @RequestBody Map parameterMap) {
        Long stockId = Long.valueOf((int) parameterMap.get("stockId"));
        Stock stock = stockService.findOne(stockId);
        model.addAttribute("stock", stock);

        return stock;
    }

    /**
     * 주식 종목 수정 폼
     */
    @GetMapping(value = "/stocks/update/{stockId}")
    public void updateStockForm(@PathVariable("stockId") Long stockId, Model model) {
        Stock stock = (Stock) stockService.findOne(stockId);

        StockForm form = new StockForm();
        form.setId(stock.getId());
        form.setStockName(stock.getStockName());
        form.setCurrentPrice(stock.getCurrentPrice());
        form.setAllTimeHighPrice(stock.getAllTimeHighPrice());
        form.setAllTimeLowPrice(stock.getAllTimeLowPrice());
        form.setPriceEarningRatio(stock.getPriceEarningRatio());
        form.setEstimatePER(stock.getEstimatePER());
        form.setPriceBookValueRatio(stock.getPriceBookValueRatio());
        form.setDividendRate(stock.getDividendRate());
        form.setQuantity(stock.getQuantity());

        model.addAttribute("form", form);
//        return "stocks/updateStockForm";
    }

    /**
     * 주식 종목 수정
     */
    @PostMapping(value = "/stocks/update")
//    public void updateStock(@ModelAttribute("form") StockForm form) {
    public void updateStock(@RequestBody StockForm form) {
        Stock stock = new Stock();
        stock.setId(form.getId());
        stock.setStockName(form.getStockName());
        stock.setSector(form.getSector());
        stock.setCurrentPrice(form.getCurrentPrice());
        stock.setAllTimeHighPrice(form.getAllTimeHighPrice());
        stock.setAllTimeLowPrice(form.getAllTimeLowPrice());
        stock.setPriceEarningRatio(form.getPriceEarningRatio());
        stock.setEstimatePER(form.getEstimatePER());
        stock.setPriceBookValueRatio(form.getPriceBookValueRatio());
        stock.setDividendRate(form.getDividendRate());
        stock.setQuantity(form.getQuantity());

        stockService.saveStock(stock);
//        return "redirect:/stocks";
    }

    @PostMapping(value = "/stocks/delete")
    public void deleteStock(@RequestBody Map parameterMap) {
        Long stockId = Long.valueOf((int) parameterMap.get("stockId"));
        stockService.deleteStock(stockId);
    }

}
