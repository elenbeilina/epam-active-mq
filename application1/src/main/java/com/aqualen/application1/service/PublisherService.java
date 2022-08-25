package com.aqualen.application1.service;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PublisherService {

  private final JmsTemplate jmsTemplate;
  @Value("${activemq.topic}")
  private String topic;

  @SneakyThrows
  public void publishMessage(String message) {
    jmsTemplate.convertAndSend(topic, message);

    log.info("Message: {} was successfully sent to the topic: {}", message, topic);
  }
}
