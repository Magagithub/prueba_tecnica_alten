package com.alten.prueba.repositories;

import com.alten.prueba.models.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {
    // TODO tambien se podria comprobar la prioridad o las fechas por java pero por consulta es mucho mas rapido :)

    @Query("SELECT p FROM Price p " +
            "WHERE p.brandId = :brandId " +
            "AND p.productId = :productId " +
            "AND :applicationDate BETWEEN p.startDate AND p.endDate " +
            "AND p.priority = (SELECT MAX(p2.priority) FROM Price p2 " +
            "                  WHERE p2.brandId = :brandId " +
            "                  AND p2.productId = :productId " +
            "                  AND :applicationDate BETWEEN p2.startDate AND p2.endDate)")
    Price findByProductIdAndBrandIdAndApplicationDate(@Param("productId") Long productId, @Param("brandId") Long brandId, @Param("applicationDate") LocalDateTime applicationDate);

}
