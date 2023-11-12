package com.example.undergrad.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Component
public class ApplicationConfig {
    @Value("${fireBase.dbBaseUrl}")
    private String dbBaseUrl;
    @Value("${fireBase.collection}")
    private String collectionName;
    @Value("${fireBase.authFileLocation}")
    private String authFileLocation;

    public String getDbBaseUrl() {
        return dbBaseUrl;
    }

    public void setDbBaseUrl(String dbBaseUrl) {
        this.dbBaseUrl = dbBaseUrl;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public String getAuthFileLocation() {
        return authFileLocation;
    }

    public void setAuthFileLocation(String authFileLocation) {
        this.authFileLocation = authFileLocation;
    }
}
