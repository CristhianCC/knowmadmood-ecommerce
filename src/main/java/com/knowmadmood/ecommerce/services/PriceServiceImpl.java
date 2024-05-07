package com.knowmadmood.ecommerce.services;

import com.knowmadmood.ecommerce.model.Price;
import com.knowmadmood.ecommerce.repositories.PriceRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PriceServiceImpl implements PriceService {

    private final PriceRepository priceRepository;

    public PriceServiceImpl(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Override
    public Price getPriceForProductAndBrandAndDate(Long brandId, Long productId, LocalDateTime startDate) {
       return priceRepository.findFirstByBrandIdAndProductIdAndAndStartDate(brandId, productId, startDate);
    }
}
