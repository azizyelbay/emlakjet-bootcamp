package com.example.week3.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleAdvertisementDto {
    private String title;
    private String photo;
    private String detailMessage;

}
