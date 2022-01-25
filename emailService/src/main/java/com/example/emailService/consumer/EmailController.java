package com.example.emailService.consumer;

import com.example.emailService.dto.OrderEmailDto;
import com.example.emailService.dto.OtpDto;
import com.example.emailService.service.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmailController {
    @Autowired
    EmailService emailService;

    @RabbitListener(queues = "queue.LoginEmail")
    public void receiveLoginEmail(OtpDto otpDto){
        emailService.sendSimpleMessage(otpDto.getEmail(),"One Time Password ","Your OTP for verification is "+otpDto.getOtp());
    }

    @RabbitListener(queues = "queue.OrderEmail")
    public void receiveOrderEmail(OrderEmailDto orderEmailDto){
        emailService.sendSimpleMessage(orderEmailDto.getEmail(),"Order Confirmation ","Your Order is Confirmed and will be delivered in by Tommorow.");
    }

    @RabbitListener(queues = "queue.MerchantEmail")
    public void receiveMerchantEmail(OtpDto otpDto){
        emailService.sendSimpleMessage(otpDto.getEmail(),"One Time Password ","Your OTP for verification is "+otpDto.getOtp());
    }



}
