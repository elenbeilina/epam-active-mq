package com.aqualen.application1.service;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.command.ActiveMQObjectMessage;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class PublisherService {

  private final JmsTemplate jmsTemplate;
  @Value("${activemq.queue}")
  private String queue;

  @SneakyThrows
  public void publishMessage(String message) {
    MessageCreator creator = (session) -> (session.createTextMessage(message));

    // Send and receive a message. A temporary queue is automatically added as replyTo address.
    ActiveMQTextMessage activeMQMessage = (ActiveMQTextMessage) jmsTemplate.sendAndReceive(queue, creator);

    String status = Optional.ofNullable(activeMQMessage.getText())
        .orElse("UNDEFINED");

    log.info("Message: {} was sent to the queue: {} with status: {}", message, queue, status);
  }
}
