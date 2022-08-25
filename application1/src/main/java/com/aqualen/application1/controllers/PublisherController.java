package com.aqualen.application1.controllers;

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

  @PostMapping("publish")
  ResponseEntity<Void> publishMessage(@RequestBody String message) {
    log.info("Sending message to the ActiveMQ: {}", message);
    return ResponseEntity.ok().build();
  }
}
