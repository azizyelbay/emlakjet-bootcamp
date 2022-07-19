package com.assignment.advertisementservice.dto.converter;

import com.assignment.advertisementservice.dto.AdvertisementDto;
import com.assignment.advertisementservice.model.Advertisement;
import org.springframework.stereotype.Component;

@Component
public class AdvertisementDtoConverter {
    public AdvertisementDto convert(Advertisement from) {
        return new AdvertisementDto(from.getId(),
                from.getTitle(),
                from.getPrice(),
                from.getDetailMessage(),
                from.getUserId()
        );
    }
}
