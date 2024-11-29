package com.teachCode.ecommerce.services;

import com.teachCode.ecommerce.dto.request.NotificationDto;
import com.teachCode.ecommerce.dto.response.DtoNotification;

import java.util.List;

public interface NotificationService {

    String addNotification(NotificationDto notificationDto);

    List<DtoNotification> getNotificationsByIdOrGeneral(String userId);
}
