package com.amazonaws.services.s3.model;

import java.util.Arrays;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class CORSRule {
    private List allowedHeaders;
    private List allowedMethods;
    private List allowedOrigins;
    private List exposedHeaders;
    private String id;
    private int maxAgeSeconds;

    public enum AllowedMethods {
        GET("GET"),
        PUT("PUT"),
        HEAD("HEAD"),
        POST("POST"),
        DELETE("DELETE");

        private final String AllowedMethod;

        AllowedMethods(String str) {
            this.AllowedMethod = str;
        }

        public static AllowedMethods fromValue(String str) throws IllegalArgumentException {
            for (AllowedMethods allowedMethods : values()) {
                String allowedMethods2 = allowedMethods.toString();
                if (allowedMethods2 == null && str == null) {
                    return allowedMethods;
                }
                if (allowedMethods2 != null && allowedMethods2.equals(str)) {
                    return allowedMethods;
                }
            }
            throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
        }

        public String toString() {
            return this.AllowedMethod;
        }
    }

    public List getAllowedHeaders() {
        return this.allowedHeaders;
    }

    public List getAllowedMethods() {
        return this.allowedMethods;
    }

    public List getAllowedOrigins() {
        return this.allowedOrigins;
    }

    public List getExposedHeaders() {
        return this.exposedHeaders;
    }

    public String getId() {
        return this.id;
    }

    public int getMaxAgeSeconds() {
        return this.maxAgeSeconds;
    }

    public void setAllowedHeaders(List list) {
        this.allowedHeaders = list;
    }

    public void setAllowedMethods(List list) {
        this.allowedMethods = list;
    }

    public void setAllowedOrigins(List list) {
        this.allowedOrigins = list;
    }

    public void setExposedHeaders(List list) {
        this.exposedHeaders = list;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setMaxAgeSeconds(int i) {
        this.maxAgeSeconds = i;
    }

    public CORSRule withAllowedHeaders(List list) {
        this.allowedHeaders = list;
        return this;
    }

    public CORSRule withAllowedMethods(List list) {
        this.allowedMethods = list;
        return this;
    }

    public CORSRule withAllowedOrigins(List list) {
        this.allowedOrigins = list;
        return this;
    }

    public CORSRule withExposedHeaders(List list) {
        this.exposedHeaders = list;
        return this;
    }

    public CORSRule withId(String str) {
        this.id = str;
        return this;
    }

    public CORSRule withMaxAgeSeconds(int i) {
        this.maxAgeSeconds = i;
        return this;
    }

    public void setAllowedHeaders(String... strArr) {
        this.allowedHeaders = Arrays.asList(strArr);
    }

    public void setAllowedMethods(AllowedMethods... allowedMethodsArr) {
        this.allowedMethods = Arrays.asList(allowedMethodsArr);
    }

    public void setAllowedOrigins(String... strArr) {
        this.allowedOrigins = Arrays.asList(strArr);
    }

    public void setExposedHeaders(String... strArr) {
        this.exposedHeaders = Arrays.asList(strArr);
    }
}
