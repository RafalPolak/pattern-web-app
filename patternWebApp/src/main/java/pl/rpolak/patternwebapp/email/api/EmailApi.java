package pl.rpolak.patternwebapp.email.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.rpolak.patternwebapp.email.bo.EmailBO;


/**
 * Created by Rafal Polak on 05.04.2018.
 */

@RestController
@RequestMapping(path = "api/email")
public class EmailApi {

    @Autowired
    EmailBO emailBO;

    @RequestMapping(value = "/test",
                    method = RequestMethod.GET)
    public void test (@RequestParam("emailAddress") String emailAddress ){

        emailBO.sendSimpleMail(emailAddress, "test it is");
        emailBO.sendAdvancedMail(emailAddress, "This is for thymeleaf");

    }

}
