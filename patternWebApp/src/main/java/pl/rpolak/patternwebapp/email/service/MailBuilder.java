package pl.rpolak.patternwebapp.email.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

/**
 * Created by Rafal Polak on 05.04.2018.
 */
@Service
public class MailBuilder {

    private TemplateEngine templateEngine;

    @Autowired
    public MailBuilder(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    public String build(String message) {
        Context context = new Context();
        context.setVariable("message", message);
        return templateEngine.process("exampleEmail", context);
    }

}
