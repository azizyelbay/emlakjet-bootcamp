package com.assignment.advertisementservice.repository;

import com.assignment.advertisementservice.model.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdvertisementRepository extends JpaRepository<Advertisement, Long> {
}
