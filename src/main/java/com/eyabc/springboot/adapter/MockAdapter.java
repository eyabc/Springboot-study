package com.eyabc.springboot.adapter;

import com.eyabc.springboot.utils.JsonFileParser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
@Profile("test")
public class MockAdapter implements Adapter {

    @Override
    public <T> T callSearch (String service, String target, String query, Class<T> className) {
        return JsonFileParser.parse(service, target, className);
    }
}