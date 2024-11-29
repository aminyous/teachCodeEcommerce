package com.teachCode.ecommerce.controllers;

import com.teachCode.ecommerce.dto.request.NotificationDto;
import com.teachCode.ecommerce.dto.response.DtoNotification;
import com.teachCode.ecommerce.services.NotificationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/notification")
@AllArgsConstructor
public class NotificationController {

    @Autowired
    NotificationService notificationService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public String addNotification(@RequestBody NotificationDto notificationDto) {
        return notificationService.addNotification(notificationDto);
    }

    @GetMapping
    public List<DtoNotification> getNotifications(@RequestParam("userId") String userId) {
        return notificationService.getNotificationsByIdOrGeneral(userId);
    }
}
