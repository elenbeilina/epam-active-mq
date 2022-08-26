package com.aqualen.application2.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ConsumerService {

  @JmsListener(destination = "Consumer.Consumer1." + "${activemq.virtual.topic}")
  public void receiveMessageConsumer1(String message) {
    log.info("Message: {} was received by consumer 1.", message);
  }

  @JmsListener(destination = "Consumer.Consumer2." + "${activemq.virtual.topic}")
  public void receiveMessageConsumer2(String message) {
    log.info("Message: {} was received by consumer 2.", message);
  }

}
