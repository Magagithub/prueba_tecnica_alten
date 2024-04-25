package com.alten.prueba;

import com.alten.prueba.models.Price;
import com.alten.prueba.repositories.PriceRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Component
public class DataInitializer {

    private PriceRepository priceRepository;
    public DataInitializer(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @PostConstruct
    public void init() {
        Price price1 = new Price();
        price1.setBrandId(1L);
        price1.setStartDate(LocalDateTime.parse("2020-06-14T00:00:00"));
        price1.setEndDate(LocalDateTime.parse("2020-12-31T23:59:59"));
        price1.setPriceList(1L);
        price1.setProductId(35455L);
        price1.setPriority(0);
        price1.setPrice(new BigDecimal("35.50"));
        price1.setCurrency("EUR");
        priceRepository.save(price1);

        Price price2 = new Price();
        price2.setBrandId(1L);
        price2.setStartDate(LocalDateTime.parse("2020-06-14T15:00:00"));
        price2.setEndDate(LocalDateTime.parse("2020-06-14T18:30:00"));
        price2.setPriceList(2L);
        price2.setProductId(35455L);
        price2.setPriority(1);
        price2.setPrice(new BigDecimal("25.45"));
        price2.setCurrency("EUR");
        priceRepository.save(price2);

        Price price3 = new Price();
        price3.setBrandId(1L);
        price3.setStartDate(LocalDateTime.parse("2020-06-15T00:00:00"));
        price3.setEndDate(LocalDateTime.parse("2020-06-15T11:00:00"));
        price3.setPriceList(3L);
        price3.setProductId(35455L);
        price3.setPriority(1);
        price3.setPrice(new BigDecimal("30.50"));
        price3.setCurrency("EUR");
        priceRepository.save(price3);

        Price price4 = new Price();
        price4.setBrandId(1L);
        price4.setStartDate(LocalDateTime.parse("2020-06-15T16:00:00"));
        price4.setEndDate(LocalDateTime.parse("2020-12-31T23:59:59"));
        price4.setPriceList(4L);
        price4.setProductId(35455L);
        price4.setPriority(1);
        price4.setPrice(new BigDecimal("38.95"));
        price4.setCurrency("EUR");
        priceRepository.save(price4);
    }
}