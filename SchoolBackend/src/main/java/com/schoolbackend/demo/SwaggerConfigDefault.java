package com.schoolbackend.demo;

import io.swagger.models.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spring.web.plugins.Docket;

public interface SwaggerConfigDefault {
    io.swagger.models.Contact DEFAULT_CONTACT = new Contact();
    ApiInfo DEFAULT_API_INFO = new ApiInfo("API Documentation", "Api Documentation", "1.0", "urn:tos", DEFAULT_CONTACT.toString(), "Apache 2.0", "https://www.apache.org/licenses/LICENSE-2.0");

    @Bean
    Docket apiDocket();

    void addViewControllers(ViewControllerRegistry registry);

    void addResourceHandlers(ResourceHandlerRegistry registry);
}
