package com.alten.prueba;

import com.alten.prueba.models.Price;
import com.alten.prueba.services.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/price")
public class PriceController {


    private PriceService priceService;
    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @GetMapping("/get")
    public ResponseEntity<Price> getPrice(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime applicationDate,
            @RequestParam Long productId,
            @RequestParam Long brandId) {
        Price price = priceService.getPrice(applicationDate, productId, brandId);
        if (price.getPriceList()!=null) {
            return ResponseEntity.ok(price);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
