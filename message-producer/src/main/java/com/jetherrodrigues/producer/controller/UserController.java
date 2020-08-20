package com.jetherrodrigues.producer.controller;

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
@RequestMapping("/api/users")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private Producer<User> producer;

    @PostMapping
    public ResponseEntity<Void> postMessage(@RequestBody @Valid final UserRequest request) {
        producer.send(request.toUser());
        return ResponseEntity.accepted().build();
    }
}
