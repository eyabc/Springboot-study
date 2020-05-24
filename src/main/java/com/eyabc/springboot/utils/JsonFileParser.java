package com.eyabc.springboot.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import java.io.IOException;

@Slf4j
@UtilityClass
public class JsonFileParser {
    public static <T> T parse (String path, Class<T> className) {
        try {
            ClassPathResource resource = new ClassPathResource("mock/" + path + ".json");
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(resource.getInputStream(), className);
        } catch (IOException e) {
            log.error("JsonFileParser.parse() {}", e);
        }
        return null;
    }
}
