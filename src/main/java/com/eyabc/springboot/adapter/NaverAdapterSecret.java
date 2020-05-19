package com.eyabc.springboot.adapter;

public class NaverAdapterSecret {

    private NaverAdapterSecret () {}

    private static final String ClientID = "CIaYbeixNk6tua3vl4wr";
    private static final String ClientSecret = "BIQelnJoCq";

    public static String getClientID () {
        return ClientID;
    }
    public static String getClientSecret () {
        return ClientSecret;
    }

}
