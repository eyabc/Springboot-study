package com.eyabc.springboot.service;

public interface NaverSearchService {
    public <T> T getByQuery(String query);
}
