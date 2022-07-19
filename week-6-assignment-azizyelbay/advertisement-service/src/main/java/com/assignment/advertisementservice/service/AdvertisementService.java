package com.assignment.advertisementservice.service;

import com.assignment.advertisementservice.dto.AdvertisementDto;
import com.assignment.advertisementservice.dto.CreateAdvertisementRequest;
import com.assignment.advertisementservice.dto.converter.AdvertisementDtoConverter;
import com.assignment.advertisementservice.model.Advertisement;
import com.assignment.advertisementservice.repository.AdvertisementRepository;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AdvertisementService {

    private final AdvertisementRepository advertisementRepository;
    private final AdvertisementDtoConverter converter;
    private final KafkaTemplate<String, Advertisement> kafkaAdvertisementTemplate;

    public AdvertisementService(AdvertisementRepository advertisementRepository, AdvertisementDtoConverter converter, KafkaTemplate<String, Advertisement> kafkaAdvertisementTemplate) {
        this.advertisementRepository = advertisementRepository;
        this.converter = converter;
        this.kafkaAdvertisementTemplate = kafkaAdvertisementTemplate;
    }

    public AdvertisementDto createSaleAdvertisement(CreateAdvertisementRequest createAdvertisementRequest) {


        Advertisement advertisement = new Advertisement();
        advertisement.setTitle(createAdvertisementRequest.getTitle());
        advertisement.setDetailMessage(createAdvertisementRequest.getDetailMessage());
        advertisement.setPrice(createAdvertisementRequest.getPrice());
        advertisement.setUserId(createAdvertisementRequest.getUserId());
        advertisement.setCreatedAt(LocalDateTime.now());

        Advertisement saveToDB = advertisementRepository.save(advertisement);
        kafkaAdvertisementTemplate.send("advertisement-topic", saveToDB);
        return converter.convert(saveToDB);
    }
}
