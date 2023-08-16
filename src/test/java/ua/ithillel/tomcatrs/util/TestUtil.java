package ua.ithillel.tomcatrs.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ua.ithillel.tomcatrs.model.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestUtil {
    public static List<User> getMockUsers() {
        InputStream inputStream = TestUtil.class.getClassLoader().getResourceAsStream("users.json");
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(inputStream, new TypeReference<List<User>>() {});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
