package com.smiley.smileybackend._00_common.config;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.nio.charset.StandardCharsets;

@Configuration
public class PropertyConfig {

    // properties 한글 깨짐 해결을 위한 properties config

    @Bean
    public PropertiesFactoryBean member() throws Exception {
        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
        ClassPathResource classPathResource = new ClassPathResource("application.properties");

        propertiesFactoryBean.setLocation(classPathResource);
        propertiesFactoryBean.setFileEncoding(StandardCharsets.UTF_8.toString());;

        return  propertiesFactoryBean;
    }

}
