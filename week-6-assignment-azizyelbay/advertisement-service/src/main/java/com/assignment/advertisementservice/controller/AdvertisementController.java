package com.assignment.advertisementservice.controller;

import com.assignment.advertisementservice.dto.AdvertisementDto;
import com.assignment.advertisementservice.dto.CreateAdvertisementRequest;
import com.assignment.advertisementservice.service.AdvertisementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/advertisement")
public class AdvertisementController {
    private final AdvertisementService advertisementService;

    public AdvertisementController(AdvertisementService advertisementService) {
        this.advertisementService = advertisementService;
    }

    @PostMapping
    public ResponseEntity<AdvertisementDto> createSaleAdvertisement(@RequestBody CreateAdvertisementRequest request){
        return ResponseEntity.ok(advertisementService.createSaleAdvertisement(request));
    }


}
