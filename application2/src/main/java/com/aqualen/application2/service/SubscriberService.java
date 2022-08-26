package com.aqualen.application2.service;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;

@Slf4j
@Service
@RequiredArgsConstructor
public class SubscriberService {

  private final JmsTemplate jmsTemplate;

  @SneakyThrows
  @JmsListener(destination = "${activemq.topic}")
  public void receiveMessage(Message jmsMessage) {
    try {
      String message = ((ActiveMQTextMessage) jmsMessage).getText();
      jmsTemplate.convertAndSend(jmsMessage.getJMSReplyTo(), "SUCCESS");
      log.info("Message: {} was received subscriber", message);

    } catch (JMSException e) {
      jmsTemplate.convertAndSend(jmsMessage.getJMSReplyTo(), "FAILED");
      log.error("Exception happened during processing: " + e);
    }
  }

}
