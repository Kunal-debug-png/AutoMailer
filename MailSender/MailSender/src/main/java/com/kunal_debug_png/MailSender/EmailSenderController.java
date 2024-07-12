package com.kunal_debug_png.MailSender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailSenderController
{

    @Autowired
    EmailSenderService emailSenderService;
    @PostMapping("/sendEmail")
    public String SendEmail(@RequestBody mailBody body){
        emailSenderService.sendEmail(body);
        return "Success";
    }





}
