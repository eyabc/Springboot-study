package com.eyabc.springboot.adapter;

public interface NaverAdapter {
    <T> T callSearch (String target, String query, Class<T> className);
}