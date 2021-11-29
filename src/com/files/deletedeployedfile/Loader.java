package com.files.deletedeployedfile;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class Loader {

    /**
     * Load properties from property file */
    public Properties loadProperties() throws Exception {
        // Reading properties file with getResourceAsStream() to be readable from JAR
        InputStream inputStream = getClass().getResourceAsStream("/Messages.properties");
        Properties properties = new Properties();

        // Load properties
        properties.load(inputStream);
        assert inputStream != null;
        inputStream.close();

        return properties;
    }
}
