package com.aqualen.application2.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SubscriberService {

  @JmsListener(destination = "${activemq.topic}", containerFactory = "jmsContainerFactory")
  public void receiveMessage(String message) {
    log.info("Message: {} was received by non durable subscriber", message);
  }

  @JmsListener(destination = "${activemq.topic}", containerFactory = "jmsDurableContainerFactory")
  public void receiveMessageDurable(String message) {
    log.info("Message: {} was received by durable subscriber", message);
  }

}
