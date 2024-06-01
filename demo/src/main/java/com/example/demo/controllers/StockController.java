package com.example.demo.controllers;

import com.example.demo.dtos.StocksResponse;
import com.example.demo.models.Stock;
import com.example.demo.services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/stock")
public class StockController {

    @Autowired
    StockService stockService;

    @GetMapping("/getAll")
    public StocksResponse getStocks(){
        return stockService.getStocks();
    }

    @PostMapping("/new")
    public ResponseEntity saveStock(@RequestBody Stock stock){
        return this.stockService.saveStock(stock);
    }
    @GetMapping("{id}")
    public Optional<Stock> getStockById(@PathVariable("id") Long id){
        return stockService.getById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateStockById(@PathVariable("id") Long id, @RequestBody Stock request ){
        return stockService.updateById(request, id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStockById(@PathVariable("id") Long id){
        boolean ok = stockService.deleteStockById(id);
        if (ok){
            return ResponseEntity.ok("Registro eliminado");
        }else{
            return ResponseEntity.badRequest().body("No se pudo eliminar el registro.");
        }
    }


}
