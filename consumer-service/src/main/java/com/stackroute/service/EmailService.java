package com.stackroute.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public String sentMail(){
        try {
            SimpleMailMessage message = new SimpleMailMessage();

            message.setFrom("thorat.paju@gmail.com");
            message.setTo("thorat.paju@gmail.com");
            message.setSubject("Welcome To SurveyAugur");
            message.setText("You are successfully Login our Application ");
            javaMailSender.send(message);

            return "Mail sent successfully";
        }catch (Exception e){
            return "mail sent failed";
        }
    }


/*    public String sendEmailwithAttachment() {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();

            MimeMessageHelper messageHelper =
                    new MimeMessageHelper(message, true);

            messageHelper.setFrom("");
            messageHelper.setTo("");
            messageHelper.setSubject("Test Subject");
            messageHelper.setText("Test Body");

            File file = new File("Path To File");

            messageHelper.addAttachment(file.getName(), file);

            javaMailSender.send(message);

            return "Mail sent successfully";

        } catch (Exception e) {
            return "Mail sent failed";
        }
    }*/
}
