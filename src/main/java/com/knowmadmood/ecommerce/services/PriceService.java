package com.knowmadmood.ecommerce.services;

import com.knowmadmood.ecommerce.model.Price;

import java.time.LocalDateTime;

public interface PriceService {
    Price getPriceForProductAndBrandAndDate(Long brandId, Long productId, LocalDateTime startDate);
}
