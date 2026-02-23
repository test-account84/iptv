package com.amplifyframework.auth.options;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class AuthConfirmResetPasswordOptions {

    public static abstract class Builder {
        public abstract AuthConfirmResetPasswordOptions build();

        public abstract Builder getThis();
    }

    public static final class DefaultAuthConfirmResetPasswordOptions extends AuthConfirmResetPasswordOptions {
        private DefaultAuthConfirmResetPasswordOptions() {
        }

        public boolean equals(Object obj) {
            return obj instanceof DefaultAuthConfirmResetPasswordOptions;
        }

        public int hashCode() {
            return DefaultAuthConfirmResetPasswordOptions.class.hashCode();
        }

        public String toString() {
            return DefaultAuthConfirmResetPasswordOptions.class.getSimpleName();
        }

        public /* synthetic */ DefaultAuthConfirmResetPasswordOptions(1 r1) {
            this();
        }
    }

    public static DefaultAuthConfirmResetPasswordOptions defaults() {
        return new DefaultAuthConfirmResetPasswordOptions(null);
    }
}
