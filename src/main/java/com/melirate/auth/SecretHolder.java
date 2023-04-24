package com.melirate.auth;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SecretHolder {

    Properties props;
    InputStream is;
    String secret;

    public SecretHolder(String secretName) {
        this.props = new Properties();
        this.is = getClass().getClassLoader().getResourceAsStream("application.properties");
        try {
            this.props.load(is);
            this.secret = props.getProperty(secretName);
        } catch(IOException e) {
            throw new IllegalArgumentException("No secret for 'secretName'");
        }
    }

    public String getSecret() {
        return secret;
    }
}
