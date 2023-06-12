package com.spotify.oauth2.utils;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {

    private final Properties properties;
    private static ConfigLoader configLoader;

    private ConfigLoader() {
        properties = PropertyUtlis.propertyLoader("src/test/resources/config.properties");
    }

    public static ConfigLoader getInstance() {
        if (configLoader == null) {
            configLoader = new ConfigLoader(); // It calls the default constructor ConfigLoader() and loads the properties
        }
        return configLoader;
    }

    //client_id
    public String getClientId() {
        String prop = properties.getProperty("client_id");
        if (prop != null) return prop;
        else throw new RuntimeException("property client_id is not specified in the config properties file");
    }

    public String getClientSecret() {
        {
            String prop = properties.getProperty("client_secret");
            if (prop != null) return prop;  // get the client secret value
            else throw new RuntimeException("property client_secret is not specified in the config properties file");
        }
    }


    public String getRefreshToken() {
        {
            String prop = properties.getProperty("refresh_token");
            if (prop != null) return prop;
            else throw new RuntimeException("property refresh_token is not specified in the config properties file");
        }
    }

    public String getGrantType() {
        {
            String prop = properties.getProperty("grant_type");
            if (prop != null) return prop;
            else throw new RuntimeException("property grant_type is not specified in the config properties file");
        }
    }

    public String getUserId() {
        {
            String prop = properties.getProperty("user_id");
            if (prop != null) return prop;
            else throw new RuntimeException("property user_id is not specified in the config properties file");
        }
    }
}
