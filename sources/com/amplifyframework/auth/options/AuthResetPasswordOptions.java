package com.amplifyframework.auth.options;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class AuthResetPasswordOptions {

    public static abstract class Builder {
        public abstract AuthResetPasswordOptions build();

        public abstract Builder getThis();
    }

    public static final class DefaultAuthResetPasswordOptions extends AuthResetPasswordOptions {
        private DefaultAuthResetPasswordOptions() {
        }

        public boolean equals(Object obj) {
            return obj instanceof DefaultAuthResetPasswordOptions;
        }

        public int hashCode() {
            return DefaultAuthResetPasswordOptions.class.hashCode();
        }

        public String toString() {
            return DefaultAuthResetPasswordOptions.class.getSimpleName();
        }

        public /* synthetic */ DefaultAuthResetPasswordOptions(1 r1) {
            this();
        }
    }

    public static DefaultAuthResetPasswordOptions defaults() {
        return new DefaultAuthResetPasswordOptions(null);
    }
}
