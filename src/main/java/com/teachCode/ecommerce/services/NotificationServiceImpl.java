package com.teachCode.ecommerce.services;

import com.teachCode.ecommerce.dto.request.NotificationDto;
import com.teachCode.ecommerce.dto.response.DtoNotification;
import com.teachCode.ecommerce.entities.Notification;
import com.teachCode.ecommerce.repositories.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotificationServiceImpl implements NotificationService{

    @Autowired
    NotificationRepository notificationRepository;
    @Override
    public String addNotification(NotificationDto notificationDto) {
        if(notificationDto != null) {
            if(notificationDto.message() != null && notificationDto.userId() != null) {
                Notification notification = Notification.builder().
                        datePosted(LocalDate.now()).
                        message(notificationDto.message()).
                        userId(notificationDto.userId()).
                        status(notificationDto.status()).
                        build();
                notificationRepository.save(notification);
                return "Notification added successfully";
            }else{
                return "required fields message";
            }
        }else{
            return "fields null";
        }

    }

    @Override
    public List<DtoNotification> getNotificationsByIdOrGeneral(String userId) {
        return notificationRepository.findByIdAndByAll(userId).orElse(Collections.emptyList())
                .stream()
                .map(n -> DtoNotification.builder()
                        .userId(n.getUserId())
                        .datePosted(n.getDatePosted())
                        .message(n.getMessage())
                        .status(n.isStatus()).build())
                .collect(Collectors.toList());
    }
}
