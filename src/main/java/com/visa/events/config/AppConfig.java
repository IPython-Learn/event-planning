package com.visa.events.config;


import org.springframework.boot.autoconfigure.http.HttpProperties;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import sun.plugin2.message.Message;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Customization configuration can be available here
 *
 * @author ThirupathiReddy Vajjala
 */
@Configuration
public class AppConfig {


    /**
     * MessageSource to read the validation messages
     *
     * @return messageSource {@link MessageSource}
     */
    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:messages");
        messageSource.setDefaultEncoding("utf-8");
        return messageSource;
    }


    /**
     * {@link LocalValidatorFactoryBean } to customize validation messages
     *
     * @return validatorFactory LocalValidatorFactoryBean
     */
    @Bean
    public LocalValidatorFactoryBean validatorFactory() {
        LocalValidatorFactoryBean factoryBean = new LocalValidatorFactoryBean();
        factoryBean.setValidationMessageSource(messageSource());
        return factoryBean;
    }



}
