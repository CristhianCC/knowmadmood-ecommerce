package com.knowmadmood.ecommerce.controllers;

import com.knowmadmood.ecommerce.dto.PriceDTO;
import com.knowmadmood.ecommerce.model.Price;
import com.knowmadmood.ecommerce.services.PriceService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class PriceController {
    private final PriceService priceService;

    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @GetMapping("/price")
    public ResponseEntity<PriceDTO> getPrice(@RequestParam Long brandId,
                                             @RequestParam Long productId,
                                             @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime startDate) {
        Price price = priceService.getPriceForProductAndBrandAndDate(brandId, productId, startDate);

        if (price == null || price.getId() == null) {
            return ResponseEntity.notFound().build();
        }

        PriceDTO priceDTO = new PriceDTO(price);

        return ResponseEntity.ok(priceDTO);
    }
}
