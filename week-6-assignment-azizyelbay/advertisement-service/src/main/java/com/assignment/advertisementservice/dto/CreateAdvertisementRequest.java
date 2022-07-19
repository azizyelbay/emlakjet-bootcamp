package com.assignment.advertisementservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateAdvertisementRequest {
    private String title;
    private BigDecimal price;
    private String detailMessage;
    private Long userId;
}
