package com.example.week3.controller;

import com.example.week3.dto.SaleAdvertisementDto;
import com.example.week3.model.SaleAdvertisement;
import com.example.week3.service.SaleAdvertisementService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sale-advertisements")
public class SaleAdvertisementController {
    private final SaleAdvertisementService saleAdvertisementService;

    public SaleAdvertisementController(SaleAdvertisementService saleAdvertisementService) {
        this.saleAdvertisementService = saleAdvertisementService;
    }

    @PostMapping
    public SaleAdvertisement createSaleAdvertisement(@RequestBody SaleAdvertisementDto saleAdvertisementDto){
        return saleAdvertisementService.createSaleAdvertisement(saleAdvertisementDto);
    }

    @GetMapping
    public List<SaleAdvertisement> getAll(){
        return saleAdvertisementService.getAll();
    }
}
