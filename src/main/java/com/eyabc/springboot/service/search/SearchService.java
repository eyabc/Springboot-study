package com.eyabc.springboot.service.search;

public interface SearchService {
    public <T> T getByQuery(String query);
}
