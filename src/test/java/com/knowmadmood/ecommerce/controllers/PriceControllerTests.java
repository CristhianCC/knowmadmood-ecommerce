package com.knowmadmood.ecommerce.controllers;

import com.knowmadmood.ecommerce.model.Price;
import com.knowmadmood.ecommerce.services.PriceService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class PriceControllerTests {

    @Mock
    private PriceService priceService;

    @InjectMocks
    private PriceController priceController;

    @Test
    void testGetPrice_Success() throws Exception {
        String startDate = "2024-05-06T10:00:00";
        String endDate = "2020-12-31T23:59:59";
        LocalDateTime startLocalDateTime = LocalDateTime.parse(startDate);
        LocalDateTime endLocalDateTime = LocalDateTime.parse(endDate);

        when(priceService.getPriceForProductAndBrandAndDate(anyLong(), anyLong(), any(LocalDateTime.class)))
                .thenReturn(new Price(1L,1L, startLocalDateTime, endLocalDateTime, 1, 35455L, 0, new BigDecimal("35.50"), "EUR"));

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(priceController).build();

        mockMvc.perform(get("/price")
                        .param("brandId", "1")
                        .param("productId", "35455")
                        .param("startDate", "2024-05-06 10:00:00")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.productId").value(35455));
    }

    @Test
    void testGetPriceNotFound_thenReturnNotFoundStatus() throws Exception {
        when(priceService.getPriceForProductAndBrandAndDate(anyLong(), anyLong(), any(LocalDateTime.class)))
                .thenReturn(new Price());

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(priceController).build();

        mockMvc.perform(get("/price")
                        .param("brandId", "1")
                        .param("productId", "1") //Wrong ProductId
                        .param("startDate", "2024-05-06 10:00:00")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}
