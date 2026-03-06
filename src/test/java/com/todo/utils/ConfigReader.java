package com.todo.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    static {
        try {
            InputStream stream = ConfigReader.class
                .getClassLoader()
                .getResourceAsStream("config.properties");
            if (stream == null) {
                throw new RuntimeException("config.properties not found in classpath");
            }
            properties = new Properties();
            properties.load(stream);
            stream.close();
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }

    public static String get(String key) {
        String value = properties.getProperty(key);
        if (value == null) {
            throw new RuntimeException("Property '" + key + "' not found");
        }
        return value;
    }

    public static int getInt(String key) {
        return Integer.parseInt(get(key));
    }
}