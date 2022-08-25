package com.aqualen.application1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.connection.SingleConnectionFactory;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.ConnectionFactory;

@EnableJms
@Configuration
public class JmsConfig {

  @Bean
  public DefaultJmsListenerContainerFactory jmsContainerFactory(SingleConnectionFactory connectionFactory) {
    DefaultJmsListenerContainerFactory containerFactory = new DefaultJmsListenerContainerFactory();
    containerFactory.setPubSubDomain(true);
    containerFactory.setConnectionFactory(connectionFactory);
    return containerFactory;
  }

  @Bean
  public JmsTemplate jmsTemplate(ConnectionFactory connectionFactory) {
    JmsTemplate jmsTemplate = new JmsTemplate(connectionFactory);
    jmsTemplate.setPubSubDomain(true);
    return jmsTemplate;
  }
}
