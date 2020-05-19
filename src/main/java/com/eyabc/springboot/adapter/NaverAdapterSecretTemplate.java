package com.eyabc.springboot.adapter;

public class NaverAdapterSecretTemplate {

    private NaverAdapterSecretTemplate () {}

    private static final String ClientID = "ClientID";
    private static final String ClientSecret = "ClientSecret";

    public static String getClientID () {
        return ClientID;
    }
    public static String getClientSecret () {
        return ClientSecret;
    }

}
