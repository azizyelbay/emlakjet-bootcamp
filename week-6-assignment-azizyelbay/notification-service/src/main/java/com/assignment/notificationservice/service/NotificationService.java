package com.assignment.notificationservice.service;

import com.assignment.notificationservice.model.Advertisement;
import com.assignment.notificationservice.model.Notification;
import com.assignment.notificationservice.repository.NotificationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;

@Service
public class NotificationService {
    private final Logger logger = LoggerFactory.getLogger(NotificationService.class);
    private final NotificationRepository notificationRepository;


    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @KafkaListener(
            topics = "advertisement-topic",
            groupId = "group-id",
            containerFactory = "advertisementKafkaListenerContainerFactory"
    )
    public void consumeAdvertisement(Advertisement advertisement) throws InterruptedException {
        Notification notification = new Notification();
        notification.setAdvertisementId(advertisement.getId());
        notification.setMessage("notification message!!!!!!!!!");
        notification.setUserId(advertisement.getUserId());
        notification.setState("SENT");
        notification.setDate(LocalDateTime.now());

        logger.info(" advertisement id = " + notification.getAdvertisementId() +
                " message = " + notification.getMessage() +
                " user id = " + notification.getUserId() +
                " state = " + notification.getState());

        notificationRepository.save(notification);
    }
}
