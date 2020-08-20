package com.jetherrodrigues.producer.controller;

import com.jetherrodrigues.producer.controller.request.AlertRequest;
import com.jetherrodrigues.producer.domain.Alert;
import com.jetherrodrigues.producer.domain.User;
import com.jetherrodrigues.producer.queue.Producer;
import com.jetherrodrigues.producer.controller.request.UserRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/producer")
public class ProducerController {

    private static final Logger logger = LoggerFactory.getLogger(ProducerController.class);

    @Autowired
    @Qualifier("NotificationProducer")
    private Producer<User> userProducer;

    @Autowired
    @Qualifier("AlertProducer")
    private Producer<Alert> alertProducer;

    @PostMapping("/send-user")
    public ResponseEntity<Void> postUser(@RequestBody @Valid final UserRequest request) {
        logger.info(String.format("UserRequest received: %s", request));
        userProducer.send(request.toUser());
        return ResponseEntity.accepted().build();
    }

    @PostMapping("/send-alert")
    public ResponseEntity<Void> postAlert(@RequestBody @Valid final AlertRequest request) {
        logger.info(String.format("AlertRequest received: %s", request));
        alertProducer.send(request.toAlert());
        return ResponseEntity.accepted().build();
    }

}
