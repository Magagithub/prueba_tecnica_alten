package com.alten.prueba.services.impl;

import com.alten.prueba.models.Price;
import com.alten.prueba.repositories.PriceRepository;
import com.alten.prueba.services.PriceService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PriceServiceImpl implements PriceService {

    private final PriceRepository priceRepository;
    public PriceServiceImpl(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;

    }
    @Override
    public Price getPrice(LocalDateTime applicationDate, Long productId, Long brandId) {

        return priceRepository.findByProductIdAndBrandIdAndApplicationDate(productId, brandId, applicationDate);
    }
}
