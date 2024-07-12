package com.kunal_debug_png.MailSender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {
    @Autowired
    private JavaMailSender  mailSender;
    /*public void sendEmail(String toEmail,String subject,String body){
        SimpleMailMessage message=new SimpleMailMessage();
        message.setFrom("kunal.chhablani.2003@gmail.com");
        message.setTo(toEmail);
        message.setSubject(subject);
        message.setText(body);



        mailSender.send(message);

    }*/

    public void sendEmail(mailBody body) {

        String recipientName = body.getFname()+" "+body.getLname();
        String companyName = body.getCompanyName();
        SimpleMailMessage message=new SimpleMailMessage();
        String messageToSend = "Dear " + recipientName + ",\n\n" +
                "I hope this message finds you well. My name is Kunal Chhablani, and I am currently pursuing a Bachelor's degree in Artificial Intelligence and Data Science at Thadomal Shahani Engineering College, with a cumulative CGPA of 9.01. I am writing to express my interest in the opportunity for a Backend Developer Internship at " + companyName + ".\n\n" +
                "Throughout my academic journey, I have gained proficiency in various programming languages including C, C++, Java, Python, and Kotlin. I have hands-on experience in web development using HTML, JavaScript, and React, with a focus on backend development utilizing Java and Spring Boot. My coursework and practical projects have equipped me with the skills necessary to contribute effectively to your team.\n\n" +
                "You can view my AI-based resume video on YouTube: https://youtube.com/watch?v=ikbZEhVNpBw&t=13s and explore more about my work on my portfolio: https://kunal-debug-png.github.io/.\n\n" +
                "Link to my resume for your review : https://drive.google.com/file/d/1fGvVnEL_EQbUB60Fb0_y6H3fEdHbR389/view?usp=sharing . I am enthusiastic about the opportunity to discuss how my background and skills align with the internship role at " + companyName + ". Thank you for considering my application. I look forward to the possibility of contributing to your team.\n\n" +
                "Best regards,\n\n" +
                "Kunal Chhablani";

        String subjectToSend = "Regarding opportunity to work as intern at" + companyName;


        message.setFrom("kunal.chhablani.2003@gmail.com");
        message.setTo(body.getTo());
        message.setSubject(subjectToSend);
        message.setText(messageToSend);

        mailSender.send(message);




    }
}
