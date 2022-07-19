package com.example.week3.service;

import com.example.week3.model.SaleAdvertisement;
import com.example.week3.repository.SaleAdvertisementRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {
    private final SaleAdvertisementRepository saleAdvertisementRepository;

    public KafkaService(SaleAdvertisementRepository saleAdvertisementRepository) {
        this.saleAdvertisementRepository = saleAdvertisementRepository;
    }
    // consume
    @KafkaListener(topics = "sale-topic", groupId = "group-id")
    public void consume(SaleAdvertisement saleAdvertisement) throws InterruptedException {
        Thread.sleep(3*1000);
        saleAdvertisement.setPriceGraphPath("Created by Worker");
        saleAdvertisementRepository.save(saleAdvertisement);
    }
}
