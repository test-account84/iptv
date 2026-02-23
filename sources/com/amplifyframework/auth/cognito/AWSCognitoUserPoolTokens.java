package com.amplifyframework.auth.cognito;

import j$.util.Objects;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class AWSCognitoUserPoolTokens {
    private final String accessToken;
    private final String idToken;
    private final String refreshToken;

    public AWSCognitoUserPoolTokens(String str, String str2, String str3) {
        Objects.requireNonNull(str);
        this.accessToken = str;
        Objects.requireNonNull(str2);
        this.idToken = str2;
        Objects.requireNonNull(str3);
        this.refreshToken = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AWSCognitoUserPoolTokens.class != obj.getClass()) {
            return false;
        }
        AWSCognitoUserPoolTokens aWSCognitoUserPoolTokens = (AWSCognitoUserPoolTokens) obj;
        return O.c.a(getAccessToken(), aWSCognitoUserPoolTokens.getAccessToken()) && O.c.a(getIdToken(), aWSCognitoUserPoolTokens.getIdToken()) && O.c.a(getRefreshToken(), aWSCognitoUserPoolTokens.getRefreshToken());
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public String getIdToken() {
        return this.idToken;
    }

    public String getRefreshToken() {
        return this.refreshToken;
    }

    public int hashCode() {
        return O.c.b(getAccessToken(), getIdToken(), getRefreshToken());
    }

    public String toString() {
        return "AWSCognitoUserPoolTokens{accessToken=" + getAccessToken() + ", idToken=" + getIdToken() + ", refreshToken=" + getRefreshToken() + '}';
    }
}
