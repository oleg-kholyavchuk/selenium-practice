package ru.buttonone.utils;

import java.io.IOException;
import java.util.Properties;

public class Props {
    private static final Properties properties = new Properties();

    static {
        try {
            properties.load(Props.class.getClassLoader()
                    .getResourceAsStream("test.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        String property = System.getProperty(key);
        return property == null ? properties.getProperty(key): property;
    }
}
