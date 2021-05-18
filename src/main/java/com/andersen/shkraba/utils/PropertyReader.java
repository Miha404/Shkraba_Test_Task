package com.andersen.shkraba.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import lombok.extern.log4j.Log4j2;

@Log4j2
public final class PropertyReader {
    private static String propertiesPath = "/config.properties";
    private static volatile Properties properties;
    private static InputStream inputStream;

    public PropertyReader() {
    }

    private static String getCorrectPath() {
        if (propertiesPath.charAt(0) != '/')
            propertiesPath = "/" + propertiesPath;
        return propertiesPath;
    }

    public static Properties readProperties() {
        properties = new Properties();
        log.info("Read driver properties");
        try {
            inputStream = PropertyReader.class.getResourceAsStream(getCorrectPath());
                properties.load(inputStream);
        } catch (Exception ex) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    log.error(e);
                }
            }
        }
        if (properties.getProperty("config_file") != null) {
            Properties additionalProperties = getProperties(properties.getProperty("config_file"));
            properties.putAll(additionalProperties);
        }
        return properties;
    }

    private static Properties loadProperties() {
        return properties != null ? properties : readProperties();
    }

    public static Properties getProperties(String path) {
        propertiesPath = path;
        return readProperties();
    }

    public static String getProperty(String propertyName) {
        return loadProperties().getProperty(propertyName);
    }
}
