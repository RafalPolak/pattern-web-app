package pl.rpolak.patternwebapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
public class WebMvcConfigurator extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        if (!registry.hasMappingForPattern("/css/**")) {
            registry.addResourceHandler("/css/**")
                    .addResourceLocations("classpath:/static/css/");
        }

        if (!registry.hasMappingForPattern("/js/**")) {
            registry.addResourceHandler("/js/**")
                    .addResourceLocations("classpath:/static/js/");
        }

        if (!registry.hasMappingForPattern("/fonts/**")) {
            registry.addResourceHandler("/fonts/**")
                    .addResourceLocations("classpath:/static/fonts/");
        }

        if (!registry.hasMappingForPattern("/img/**")) {
            registry.addResourceHandler("/img/**")
                    .addResourceLocations("classpath:/static/img/");
        }

        if (!registry.hasMappingForPattern("/images/**")) {
            registry.addResourceHandler("/images/**")
                    .addResourceLocations("classpath:/static/img/");
        }
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/documentation").setViewName("docs/index");
    }

}
