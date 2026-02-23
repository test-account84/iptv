package com.amplifyframework.auth;

import O.c;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class AuthProvider {
    private static final String AMAZON = "amazon";
    private static final String APPLE = "apple";
    private static final String FACEBOOK = "facebook";
    private static final String GOOGLE = "google";
    private final String providerKey;

    public AuthProvider(String str) {
        this.providerKey = str;
    }

    public static AuthProvider amazon() {
        return new AuthProvider("amazon");
    }

    public static AuthProvider apple() {
        return new AuthProvider("apple");
    }

    public static AuthProvider custom(String str) {
        return new AuthProvider(str);
    }

    public static AuthProvider facebook() {
        return new AuthProvider("facebook");
    }

    public static AuthProvider google() {
        return new AuthProvider("google");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return c.a(getProviderKey(), ((AuthProvider) obj).getProviderKey());
    }

    public String getProviderKey() {
        return this.providerKey;
    }

    public int hashCode() {
        return c.b(getProviderKey());
    }

    public String toString() {
        return "AuthProvider{providerKey=" + this.providerKey + '}';
    }
}
