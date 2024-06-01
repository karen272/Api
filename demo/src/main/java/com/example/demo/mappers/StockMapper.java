package com.example.demo.mappers;

import com.example.demo.dtos.StockResponse;
import com.example.demo.dtos.StocksResponse;
import com.example.demo.models.Stock;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StockMapper {
    public StocksResponse ListStocksToStocksResponse(List<Stock> stocks){
        StocksResponse c = new StocksResponse();
        List<StockResponse> stockResponseList = new ArrayList<>();
        for (Stock stock:stocks) {

            stockResponseList.add(StockToStockResponse(stock));
        }
        c.setStocks(stockResponseList);
        return  c;
    }
    public StockResponse StockToStockResponse(Stock stock){
        StockResponse stockResponse = new StockResponse();
        stockResponse.setCantidad(stock.getCantidad());
        return  stockResponse;
    }
}
