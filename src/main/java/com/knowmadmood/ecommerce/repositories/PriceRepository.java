package com.knowmadmood.ecommerce.repositories;

import com.knowmadmood.ecommerce.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {
    Price findFirstByBrandIdAndProductIdAndAndStartDate(Long brandId, Long productId, LocalDateTime startDate);
}
