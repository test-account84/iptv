package com.amplifyframework.auth;

import O.c;
import j$.util.Objects;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class AuthUser {
    private String userId;
    private String username;

    public AuthUser(String str, String str2) {
        Objects.requireNonNull(str);
        this.userId = str;
        Objects.requireNonNull(str2);
        this.username = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AuthUser.class != obj.getClass()) {
            return false;
        }
        AuthUser authUser = (AuthUser) obj;
        return c.a(getUserId(), authUser.getUserId()) && c.a(getUsername(), authUser.getUsername());
    }

    public String getUserId() {
        return this.userId;
    }

    public String getUsername() {
        return this.username;
    }

    public int hashCode() {
        return c.b(getUserId(), getUsername());
    }

    public String toString() {
        return "AuthUser{userId='" + this.userId + "', username='" + this.username + "'}";
    }
}
