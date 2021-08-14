package com.stackroute.controller;


import com.stackroute.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @GetMapping("sentmail")
    public String sendMail(){
        return emailService.sentMail();
    }

   /* @GetMapping("/sendEmailwithAttachment")
    public String sendEmailwithAttachment() {
        return emailService.sendEmailwithAttachment();
    }*/


}
