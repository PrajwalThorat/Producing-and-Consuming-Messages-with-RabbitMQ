package com.stackroute.controller;

import com.stackroute.domain.Employee;
import com.stackroute.service.RabbitMqSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * RestController annotation is used to create Restful web services using Spring MVC
 */
@RestController

/**
 * RequestMapping annotation maps HTTP requests to handler methods
 */
@RequestMapping(value = "/api/v1/")
public class ProducerController {

    private RabbitMqSender rabbitMqSender;

    /*
     * Add code to autowire RabbitMQSender
     */

    @Autowired
    public ProducerController(RabbitMqSender rabbitMqSender) {
        this.rabbitMqSender = rabbitMqSender;
    }

    /**
     * To get the property values
     */
    @Value("${app.message}")
    private String message;


    @PostMapping(value = "employee")
    public String publishEmployeeDetails(@RequestBody Employee employee) {
        /*
         * Add code to send employee object to RabbitMQ
         */
        rabbitMqSender.send(employee);
        return message;
    }

}
