package com.erp.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.List;

public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(List<String> emailIds){

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        try{
            helper.setTo((String[]) emailIds.toArray());
            helper.setText("Please update your timesheet.");
            helper.setSubject("Incomplete/missing timesheet.");
        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("Error sending mail");
        }

        javaMailSender.send(message);
        System.out.println("Mail sent successfully");
    }
}
