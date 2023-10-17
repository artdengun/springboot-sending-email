package com.deni.gunawan.springsendingemail.config;

import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Configuration
public class AppProperties {

    private String rabbitMqQueue                        = "emailQueue";
    private String rabbitMqHost                         = "localhost";
    private String rabbitMqUsername                     = "guest";
    private String rabbitMqPassword                     = "guest";
    private int rabbitMqRecoveryInterval                = 5000;
    private int rabbitMqReceiveTimeout                  = 5000;
    private int rabbitMqPort                            = 5672;

    private String cronJobJamEnamPagi                   = "0 6 * * *";
    private String cronJobJamSembilanPagi               = "0 9 * * *";
    private String cronJobJamDuaBelasSiang              = "0 12 * * *";
    private String cronJobJamTujuhBelasSore             = "0 17 * * *";


    /*EMAIL*/
    private String emailHost                            = "smtp.gmail.com";
    private String emailUsername                        = "";
    private String emailPassword                        = "";
    private String emailTransportProtocol               = "mail.transport.protocol";
    private String emailSmtpAuth                        = "mail.smtp.auth";
    private String emailStartTlsEnable                  = "mail.smtp.starttls.enable";
    private String emailStartTlsRequired                = "mail.smtp.starttls.required";
    private int emailPort                               = 587;

    private String emailProtocolType                    = "smtp";
    private String configTrue                           = "true";
    private String configFalse                          = "false"; 
    
}
