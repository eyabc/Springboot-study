package com.eyabc.springboot.adapter;

public interface Adapter {
    public abstract <T> T callSearch (String service, String target, String query, Class<T> className);
}