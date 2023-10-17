package com.deni.gunawan.springsendingemail.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class EmailConfig {

    @Autowired
    private AppProperties appProperties;
    @Bean
    public JavaMailSender emailConfiguration(){
        JavaMailSenderImpl configEmailSender = new JavaMailSenderImpl();
        configEmailSender.setHost(appProperties.getEmailHost());
        configEmailSender.setPort(appProperties.getEmailPort());
        configEmailSender.setUsername(appProperties.getEmailUsername());

        Properties configMailProtocol = configEmailSender.getJavaMailProperties();
        configMailProtocol.put(appProperties.getEmailTransportProtocol(), appProperties.getEmailProtocolType());
        configMailProtocol.put(appProperties.getEmailSmtpAuth(), appProperties.getConfigTrue());
        configMailProtocol.put(appProperties.getEmailStartTlsEnable(), appProperties.getConfigTrue());
        configMailProtocol.put(appProperties.getEmailStartTlsRequired(), appProperties.getConfigTrue());
        configEmailSender.setJavaMailProperties(configMailProtocol);
        return configEmailSender;
    }

}
