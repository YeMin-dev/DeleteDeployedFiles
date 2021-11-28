package com.files.deletedeployedfile;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class Loader {

    public Properties loadProperties() throws Exception {
        InputStream inputStream = getClass().getResourceAsStream("/Messages.properties");
        Properties properties = new Properties();

        // Load properties
        properties.load(inputStream);
        return properties;
    }
}
