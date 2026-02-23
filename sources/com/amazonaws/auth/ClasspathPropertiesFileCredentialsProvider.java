package com.amazonaws.auth;

import com.amazonaws.AmazonClientException;
import java.io.IOException;
import java.io.InputStream;

@Deprecated
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class ClasspathPropertiesFileCredentialsProvider implements AWSCredentialsProvider {
    private static String defaultPropertiesFile = "AwsCredentials.properties";
    private final String credentialsFilePath;

    public ClasspathPropertiesFileCredentialsProvider() {
        this(defaultPropertiesFile);
    }

    public AWSCredentials getCredentials() {
        InputStream resourceAsStream = getClass().getResourceAsStream(this.credentialsFilePath);
        if (resourceAsStream == null) {
            throw new AmazonClientException("Unable to load AWS credentials from the " + this.credentialsFilePath + " file on the classpath");
        }
        try {
            return new PropertiesCredentials(resourceAsStream);
        } catch (IOException e) {
            throw new AmazonClientException("Unable to load AWS credentials from the " + this.credentialsFilePath + " file on the classpath", e);
        }
    }

    public void refresh() {
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.credentialsFilePath + ")";
    }

    public ClasspathPropertiesFileCredentialsProvider(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Credentials file path cannot be null");
        }
        if (!str.startsWith("/")) {
            str = "/" + str;
        }
        this.credentialsFilePath = str;
    }
}
