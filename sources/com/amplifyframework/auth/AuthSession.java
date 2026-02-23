package com.amplifyframework.auth;

import O.c;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class AuthSession {
    private final boolean isSignedIn;

    public AuthSession(boolean z) {
        this.isSignedIn = z;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return c.a(Boolean.valueOf(isSignedIn()), Boolean.valueOf(((AuthSession) obj).isSignedIn()));
    }

    public int hashCode() {
        return c.b(Boolean.valueOf(isSignedIn()));
    }

    public boolean isSignedIn() {
        return this.isSignedIn;
    }

    public String toString() {
        return "AuthSession{isSignedIn=" + this.isSignedIn + '}';
    }
}
