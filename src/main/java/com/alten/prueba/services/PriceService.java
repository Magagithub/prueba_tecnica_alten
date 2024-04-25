package com.alten.prueba.services;

import com.alten.prueba.models.Price;

import java.time.LocalDateTime;

public interface PriceService {
    Price getPrice(LocalDateTime applicationDate, Long productId, Long brandId);
}