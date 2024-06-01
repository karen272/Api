package com.example.demo.dtos;

import lombok.Data;

import java.util.List;

@Data
public class StocksResponse {
    private List<StockResponse>stocks;
}
