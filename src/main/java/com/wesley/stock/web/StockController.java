package com.wesley.stock.web;

import com.wesley.stock.domain.Stock;
import com.wesley.stock.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class StockController {

    private final StockService stockService;

    @GetMapping(value = "/stocks/new")
    public String createForm(Model model) {
        model.addAttribute("form", new StockForm());

        return "stocks/createStockForm";
    }

    @PostMapping(value = "/stocks/new")
    public String create(StockForm form) {

        Stock stock = new Stock();
        stock.setStockName(form.getStockName());
        stock.setCurrentPrice(form.getCurrentPrice());
        stock.setAllTimeHighPrice(form.getAllTimeHighPrice());
        stock.setAllTimeLowPrice(form.getAllTimeLowPrice());
        stock.setPriceEarningRatio(form.getPriceEarningRatio());
        stock.setEstimatePER(form.getEstimatePER());
        stock.setPriceBookValueRatio(form.getPriceBookValueRatio());
        stock.setDividendRate(form.getDividendRate());
//        stock.setQuantity(form.getQuantity());

        stockService.saveStock(stock);
        return "redirect:/stocks";
    }

    /**
     * 주식 종목 목록
     */
    @GetMapping(value = "/stocks")
    public String list(Model model) {
        List<Stock> stocks = stockService.findStocks();
        model.addAttribute("stocks", stocks);
        return "stocks/stockList";
    }

    /**
     * 주식 종목 수정 폼
     */
    @GetMapping(value = "/stocks/update/{stockId}")
    public String updateStockForm(@PathVariable("stockId") Long stockId, Model model) {
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

        model.addAttribute("form", form);
        return "stocks/updateStockForm";
    }

    /**
     * 주식 종목 수정
     */
    @PostMapping(value = "/stocks/update/{stockId}")
    public String updateStock(@ModelAttribute("form") StockForm form) {
        Stock stock = new Stock();
        stock.setStockName(form.getStockName());
        stock.setCurrentPrice(form.getCurrentPrice());
        stock.setAllTimeHighPrice(form.getAllTimeHighPrice());
        stock.setAllTimeLowPrice(form.getAllTimeLowPrice());
        stock.setPriceEarningRatio(form.getPriceEarningRatio());
        stock.setEstimatePER(form.getEstimatePER());
        stock.setPriceBookValueRatio(form.getPriceBookValueRatio());
        stock.setDividendRate(form.getDividendRate());

        stockService.saveStock(stock);
        return "redirect:/stocks";
    }

}
