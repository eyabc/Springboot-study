package com.eyabc.springboot.property;

public interface SecretProperty {
    String getClientId();
    String getClientSecret();
    void setClientId(String clientId);
    void setClientSecret(String clientSecret);
}
