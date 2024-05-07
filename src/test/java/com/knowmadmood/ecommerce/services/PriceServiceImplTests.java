package com.knowmadmood.ecommerce.services;

import com.knowmadmood.ecommerce.model.Price;
import com.knowmadmood.ecommerce.repositories.PriceRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PriceServiceImplTests {

    @Mock
    private PriceRepository priceRepository;

    @InjectMocks
    private PriceServiceImpl priceService;

    @Test
    public void testGetPriceForProductAndBrandAndDate_Success() {
        String startDate = "2024-05-06T10:00:00";
        String endDate = "2020-12-31T23:59:59";
        LocalDateTime startLocalDateTime = LocalDateTime.parse(startDate);
        LocalDateTime endLocalDateTime = LocalDateTime.parse(endDate);
        Price mockPrice = new Price(1L,1L, startLocalDateTime, endLocalDateTime, 1, 35455L, 0, new BigDecimal("35.50"), "EUR");
        when(priceRepository.findFirstByBrandIdAndProductIdAndAndStartDate(anyLong(), anyLong(), any(LocalDateTime.class)))
                .thenReturn(mockPrice);

        Long brandId = 1L;
        Long productId = 35455L;
        LocalDateTime start = LocalDateTime.of(2024, 5, 6, 10, 0, 0);
        Price result = priceService.getPriceForProductAndBrandAndDate(brandId, productId, start);

        assertEquals(mockPrice, result);
    }
}