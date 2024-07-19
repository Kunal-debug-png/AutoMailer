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
        String role=body.getRole();
        String person=body.getPerson();
        SimpleMailMessage message=new SimpleMailMessage();
        String jobId="";
        String jobUrl="";

        String subjectToSend;

        String messageToSend =
                "Dear " + recipientName + ",\n\n" +
                        "I hope this message finds you well. My name is Kunal Chhablani, and I am currently pursuing a Bachelor's degree in Artificial Intelligence and Data Science at Thadomal Shahani Engineering College, with a cumulative CGPA of 9.01. I am writing to express my interest in the opportunity for "+ role + " at " + companyName + ".\n\n" +
                        "Throughout my academic journey, I have gained proficiency in various programming languages including C, C++, Java, Python, and Kotlin. I have hands-on experience in web development using HTML, JavaScript, and React, with a focus on backend development utilizing Java and Spring Boot. My coursework and practical projects have equipped me with the skills necessary to contribute effectively to your team.\n\n" ;

        if(person.equals("HR")){
            //hr
            subjectToSend = "Regarding opportunity to work as "+ role +" at" + companyName;

        }
        else
        {
            subjectToSend="Request for Referral to "+role+" Position at "+companyName;
            jobId=body.getJobId();
            jobUrl=body.getJobUrl();
            String refferal=
                    "I am reaching out to inquire if you might be willing to refer me for a "+role+" position at "+companyName+". I am very impressed with the work being done at "+companyName+" and am confident that my skills and academic background align well with the needs of the team. If you would like, we can have a formal or informal chat to discuss my skills and experiences in more detail before making any referral decisions.\n\n";
            messageToSend=messageToSend+refferal+"\nJob Url:"+jobUrl+"\n"+jobId+"\n";

        }

        String outro=
                "You can view my AI-based resume video on YouTube: https://youtube.com/watch?v=ikbZEhVNpBw&t=13s and explore more about my work on my portfolio: https://kunal-debug-png.github.io/.\n\n" +
                        "Link to my resume for your review : https://drive.google.com/file/d/11SSiDWXJkasiBmfssAZdvf0_MH7dL0IG/view?usp=sharing . \n\nI am enthusiastic about the opportunity to discuss how my background and skills align with the "+ role +" at " + companyName + ". Thank you for considering my application. I look forward to the possibility of contributing to your team.\n\n" ;
          String regards=
                "Best regards,\n" +
                "Kunal Chhablani\n"+
                  "kunal.chhablani.2003@gmail.com";


          String finalMessage=messageToSend+outro+regards;
          //String subjectToSend = "Regarding opportunity to work as "+ role +" at" + companyName;


        message.setFrom("kunal.chhablani.2003@gmail.com");
        message.setTo(body.getTo());
        message.setSubject(subjectToSend);
        message.setText(finalMessage);

        mailSender.send(message);




    }
}
