package com.amplifyframework.auth.options;

import O.c;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class AuthSignOutOptions {
    private final boolean globalSignOut;

    public static abstract class Builder {
        private boolean globalSignOut = false;

        public AuthSignOutOptions build() {
            return new AuthSignOutOptions(this.globalSignOut);
        }

        public abstract Builder getThis();

        public Builder globalSignOut(boolean z) {
            this.globalSignOut = z;
            return getThis();
        }

        public boolean isGlobalSignOut() {
            return this.globalSignOut;
        }
    }

    public static final class CoreBuilder extends Builder {
        public CoreBuilder getThis() {
            return this;
        }
    }

    public AuthSignOutOptions(boolean z) {
        this.globalSignOut = z;
    }

    public static Builder builder() {
        return new CoreBuilder();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return c.a(Boolean.valueOf(isGlobalSignOut()), Boolean.valueOf(((AuthSignOutOptions) obj).isGlobalSignOut()));
    }

    public int hashCode() {
        return c.b(Boolean.valueOf(isGlobalSignOut()));
    }

    public boolean isGlobalSignOut() {
        return this.globalSignOut;
    }

    public String toString() {
        return "AuthSignOutOptions{globalSignOut=" + isGlobalSignOut() + '}';
    }
}
