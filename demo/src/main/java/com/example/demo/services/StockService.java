package com.example.demo.services;

import com.example.demo.dtos.StocksResponse;
import com.example.demo.mappers.StockMapper;
import com.example.demo.models.Stock;
import com.example.demo.repositories.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StockService {
    @Autowired
    StockRepository stockRepository;

    @Autowired
    StockMapper stockMapper;

    public StocksResponse getStocks(){
        return stockMapper.ListStocksToStocksResponse(stockRepository.findAll());
    }

    public Optional<Stock> getById(Long id){
        return (Optional<Stock>) stockRepository.findById(id);
    }

    public ResponseEntity saveStock(Stock stock){
        stockRepository.save(stock);
        return ResponseEntity.ok("Registro guardado");
    }

    public ResponseEntity updateById(Stock request, Long id){
        Stock stock = stockRepository.findById(id).get();
        stock.setCantidad(request.getCantidad());
        stock.setProductos(request.getProductos());
        saveStock(stock);
        return ResponseEntity.ok("Registro actualizado");

    }

    public boolean deleteStockById(Long id){
        try{
            stockRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }


}
