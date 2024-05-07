package com.knowmadmood.ecommerce.dto;

import com.knowmadmood.ecommerce.model.Price;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
public class PriceDTO {
    private final Long productId;
    private final Long brandId;
    private final Integer priceList;
    private final LocalDateTime startDate;
    private final LocalDateTime endDate;
    private final BigDecimal price;
    private final String currency;
    private final Integer priority;

    public PriceDTO(Price price) {
        this.productId = price.getProductId();
        this.brandId = price.getBrandId();
        this.priceList = price.getPriceList();
        this.startDate = price.getStartDate();
        this.endDate = price.getEndDate();
        this.price = price.getPrice();
        this.currency = price.getCurrency();
        this.priority = price.getPriority();
    }
}
