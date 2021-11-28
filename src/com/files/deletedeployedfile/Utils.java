package com.files.deletedeployedfile;

import java.io.File;
import java.io.FileInputStream;
import java.text.MessageFormat;
import java.util.Properties;

public class Utils {

    private static Properties properties;

    public static Properties getProperties() {
        return properties;
    }

    public static void setProperties(Properties properties) {
        Utils.properties = properties;
    }

    public static void print(String key, Object... params) {
        String message = "";
        if (params != null) {
            message = MessageFormat.format(properties.getProperty(key), params);
        } else {
            message = properties.getProperty(key);
        }
        System.out.println(message);
    }

    public static String getRelevantPath(String path) {

        if (!path.contains("standalone")
                && path.contains("jboss")
                && new File(path + "\\standalone").exists()) {
            path = path + "\\standalone";
            return path;
        }

        return path;
    }

    public static boolean isCorrectPath(String path) {

        return path.contains("standalone")
                && path.contains("jboss")
                && new File(path).exists();
    }
}
