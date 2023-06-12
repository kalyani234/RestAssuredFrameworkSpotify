package com.spotify.oauth2.utils;


import java.util.Properties;

public class DataLoader {

    private final Properties properties;
    private static DataLoader dataLoader;

    private DataLoader() {
        properties = PropertyUtlis.propertyLoader("src/test/resources/data.properties");
    }

    public static DataLoader getInstance() {
        if (dataLoader == null) {
            dataLoader = new DataLoader(); // It calls the default constructor ConfigLoader() and loads the properties
        }
        return dataLoader;
    }

    //get_playlist_id
    public String getPlaylistId() {
        String prop = properties.getProperty("get_playlist_id");
        if (prop != null) return prop;
        else throw new RuntimeException("property get_playlist_id is not specified in the config properties file");
    }

    //update_playlist_id
    public String updatePlayListId() {
        {
            String prop = properties.getProperty("update_playlist_id");
            if (prop != null) return prop;  // get the client secret value
            else throw new RuntimeException("property update_playlist_id is not specified in the config properties file");
        }
    }



}
