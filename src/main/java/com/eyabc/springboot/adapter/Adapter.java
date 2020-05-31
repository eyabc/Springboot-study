package com.eyabc.springboot.adapter;

public interface Adapter {
    public abstract <T> T callSearch (String target, String query, Class<T> className);
}