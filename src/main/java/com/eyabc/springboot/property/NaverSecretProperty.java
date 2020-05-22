package com.eyabc.springboot.property;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(NaverSecretProperty.class)
@ConfigurationProperties(prefix = "naver-search")
@Getter
@NoArgsConstructor
public class NaverSecretProperty {
    private String clientID;
    private String clientSecret;
}
