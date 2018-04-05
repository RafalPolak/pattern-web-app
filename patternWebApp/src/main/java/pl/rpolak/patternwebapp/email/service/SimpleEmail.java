package pl.rpolak.patternwebapp.email.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

/**
 * Created by Rafal Polak on 05.04.2018.
 */
@Service
public class SimpleEmail {

    private JavaMailSender javaMailSender;

    @Value("email.recipient")
    private String recipientConfig;

    @Autowired
    public SimpleEmail(JavaMailSender javaMailSender){
        this.javaMailSender = javaMailSender;
    }

    public void prepareAndSend(String recipient, String message) {
        MimeMessagePreparator messagePreparator = mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setFrom(recipientConfig);
            messageHelper.setTo(recipient);
            messageHelper.setSubject("Awesome subject");
            messageHelper.setText(message);
        };
        try {
            javaMailSender.send(messagePreparator);
        } catch (MailException e) {
            // runtime exception; compiler will not force you to handle it
        }
    }


}
