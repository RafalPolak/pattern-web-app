package pl.rpolak.patternwebapp.email.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.rpolak.patternwebapp.email.service.AdvancedEmail;
import pl.rpolak.patternwebapp.email.service.SimpleEmail;

/**
 * Created by Rafal Polak on 05.04.2018.
 */
@Component
public class EmailBO implements IEmailBO {

    @Autowired
    SimpleEmail simpleEmail;

    @Autowired
    AdvancedEmail advancedEmail;

    @Override
    public void sendSimpleMail(String recipient, String message) {
        simpleEmail.prepareAndSend(recipient, message);
    }

    @Override
    public void sendAdvancedMail(String recipient, String message){
        advancedEmail.prepareAndSend(recipient, message);
    }

}
