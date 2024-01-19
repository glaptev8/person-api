package org.person.service;

import org.leantech.notification.NotificationDto;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RegisterNotificationProducer {
  private final KafkaTemplate<String, NotificationDto> kafkaTemplate;
  private static final String TOPIC_NAME = "notification-topic";

  public void sendEvent(NotificationDto event) {
    kafkaTemplate.send(TOPIC_NAME, event);
  }
}
