package com.ucv.electrix.config;

import com.ucv.electrix.utils.implementations.ImageCreatorImpl;
import com.ucv.electrix.utils.interfaces.ImageCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ImageCreator imageCreator(){
        return new ImageCreatorImpl();
    }
}
