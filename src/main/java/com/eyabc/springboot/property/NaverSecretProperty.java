package com.eyabc.springboot.property;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "naver-search")
@Getter
@Setter
@NoArgsConstructor
public class NaverSecretProperty {
    private String clientId;
    private String clientSecret;
}
