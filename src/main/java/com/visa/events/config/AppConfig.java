package com.visa.events.config;


import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.client.RestTemplate;

/**
 * App configuration customization can be available here
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

    /**
     * @return restTemplate
     */
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


}
