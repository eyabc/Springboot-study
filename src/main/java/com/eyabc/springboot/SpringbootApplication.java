package com.eyabc.springboot;

import com.eyabc.springboot.config.HttpHostsConfiguration;
import com.eyabc.springboot.property.NaverSecretProperty;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({NaverSecretProperty.class, HttpHostsConfiguration.class})
public class SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }

}
