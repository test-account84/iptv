package com.amplifyframework.auth.result;

import O.c;
import com.amplifyframework.auth.AuthException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class AuthSessionResult {
    private final AuthException error;
    private final Type type;
    private final Object value;

    public enum Type {
        SUCCESS,
        FAILURE
    }

    private AuthSessionResult(Object obj, AuthException authException, Type type) {
        this.value = obj;
        this.error = authException;
        this.type = type;
    }

    public static AuthSessionResult failure(AuthException authException) {
        return new AuthSessionResult(null, authException, Type.FAILURE);
    }

    public static AuthSessionResult success(Object obj) {
        return new AuthSessionResult(obj, null, Type.SUCCESS);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AuthSessionResult)) {
            return false;
        }
        AuthSessionResult authSessionResult = (AuthSessionResult) obj;
        return c.a(getValue(), authSessionResult.getValue()) && c.a(getError(), authSessionResult.getError()) && c.a(getType(), authSessionResult.getType());
    }

    public AuthException getError() {
        return this.error;
    }

    public Type getType() {
        return this.type;
    }

    public Object getValue() {
        return this.value;
    }

    public int hashCode() {
        return c.b(getValue(), getError(), getType());
    }

    public String toString() {
        return "AuthSessionResult{value=" + getValue() + ", error=" + getError() + ", type=" + getType() + '}';
    }
}
