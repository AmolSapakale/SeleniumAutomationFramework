package com.ajs.utils;

import com.ajs.constants.FrameworkConstants;
import com.ajs.enums.ConfigProperties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public final class ReadPropertyFileUtils {

    private ReadPropertyFileUtils() {
    }

    static Properties property = new Properties();
    static HashMap<String, String> map = new HashMap<>();

    static {

        try (FileInputStream fis = new FileInputStream(FrameworkConstants.getConfigPropertyFilePath())) {
            property.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
        for (Map.Entry<Object, Object> entry : property.entrySet()) {

            map.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()).trim());
        }
        System.out.println(map);

    }

    public static String getValueFromPropertyFile(ConfigProperties configProperties) {

        if (Objects.isNull(configProperties.name().toLowerCase()) || Objects.isNull(map.get(configProperties.name().toLowerCase()))) {
            try {
                throw new Exception("Property name " + configProperties + " is not found. Please check config.properties file.");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("****** Fetching " + configProperties + " value from config file *********");
            System.out.println("Key required is : " + configProperties);
            System.out.println("Retrieved value is : " + map.get(configProperties.name().toLowerCase()));
            return map.get(configProperties.name().toLowerCase());
        }

    }

}
