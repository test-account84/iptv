package com.amplifyframework.auth;

import O.c;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class AuthUserAttribute {
    private AuthUserAttributeKey key;
    private String value;

    public AuthUserAttribute(AuthUserAttributeKey authUserAttributeKey, String str) {
        this.key = authUserAttributeKey;
        this.value = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AuthUserAttribute.class != obj.getClass()) {
            return false;
        }
        AuthUserAttribute authUserAttribute = (AuthUserAttribute) obj;
        return c.a(getKey(), authUserAttribute.getKey()) && c.a(getValue(), authUserAttribute.getValue());
    }

    public AuthUserAttributeKey getKey() {
        return this.key;
    }

    public String getValue() {
        return this.value;
    }

    public int hashCode() {
        return c.b(getKey(), getValue());
    }

    public String toString() {
        return "AuthUserAttribute {key=" + this.key + ", value=" + this.value + '}';
    }
}
