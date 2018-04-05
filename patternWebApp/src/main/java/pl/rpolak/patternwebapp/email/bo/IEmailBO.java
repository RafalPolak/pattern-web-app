package pl.rpolak.patternwebapp.email.bo;

/**
 * Created by Rafal Polak on 05.04.2018.
 */
public interface IEmailBO {

    void sendSimpleMail(String recipient, String message);
    void sendAdvancedMail(String recipient, String message);

}
