package com.aqualen.application1.controllers;

import com.aqualen.application1.service.PublisherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("publisher")
@RequiredArgsConstructor
public class PublisherController {

  private final PublisherService publisherService;

  @PostMapping("publish")
  ResponseEntity<Void> publishMessage(@RequestBody String message) {
    log.info("Sending message to the ActiveMQ: {}", message);
    publisherService.publishMessage(message);
    return ResponseEntity.ok().build();
  }
}
