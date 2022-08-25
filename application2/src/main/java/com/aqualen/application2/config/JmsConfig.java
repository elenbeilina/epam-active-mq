package com.aqualen.application2.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;

import javax.jms.ConnectionFactory;

@EnableJms
@Configuration
public class JmsConfig {

  @Value("${spring.activemq.broker-url}")
  private String brokerUrl;

  @Value("${spring.activemq.user}")
  private String user;

  @Value("${spring.activemq.password}")
  private String password;


  @Bean
  public DefaultJmsListenerContainerFactory jmsContainerFactory(ConnectionFactory connectionFactory) {
    DefaultJmsListenerContainerFactory containerFactory = new DefaultJmsListenerContainerFactory();
    containerFactory.setPubSubDomain(true);
    containerFactory.setConnectionFactory(connectionFactory);
    return containerFactory;
  }

  @Bean
  public DefaultJmsListenerContainerFactory jmsDurableContainerFactory(ConnectionFactory connectionFactory) {
    DefaultJmsListenerContainerFactory containerFactory = new DefaultJmsListenerContainerFactory();
    containerFactory.setPubSubDomain(true);
    containerFactory.setSubscriptionDurable(true);
    containerFactory.setClientId("durableSubscriber");
    containerFactory.setConnectionFactory(connectionFactory);
    return containerFactory;
  }

  @Bean
  public ConnectionFactory connectionFactory() {
    return new ActiveMQConnectionFactory(user, password, brokerUrl);
  }
}
