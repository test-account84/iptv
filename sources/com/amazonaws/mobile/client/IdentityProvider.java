package com.amazonaws.mobile.client;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public enum IdentityProvider {
    AMAZON("www.amazon.com"),
    FACEBOOK("graph.facebook.com"),
    GOOGLE("accounts.google.com"),
    TWITTER("api.twitter.com"),
    DEVELOPER("cognito-identity.amazonaws.com");

    private final String key;

    IdentityProvider(String str) {
        this.key = str;
    }

    public boolean equals(String str) {
        return this.key.equals(str);
    }

    public String toString() {
        return this.key;
    }
}
