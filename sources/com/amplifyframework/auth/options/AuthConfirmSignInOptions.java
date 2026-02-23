package com.amplifyframework.auth.options;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class AuthConfirmSignInOptions {

    public static abstract class Builder {
        public abstract AuthConfirmSignInOptions build();

        public abstract Builder getThis();
    }

    public static final class DefaultAuthConfirmSignInOptions extends AuthConfirmSignInOptions {
        private DefaultAuthConfirmSignInOptions() {
        }

        public boolean equals(Object obj) {
            return obj instanceof DefaultAuthConfirmSignInOptions;
        }

        public int hashCode() {
            return DefaultAuthConfirmSignInOptions.class.hashCode();
        }

        public String toString() {
            return DefaultAuthConfirmSignInOptions.class.getSimpleName();
        }

        public /* synthetic */ DefaultAuthConfirmSignInOptions(1 r1) {
            this();
        }
    }

    public static DefaultAuthConfirmSignInOptions defaults() {
        return new DefaultAuthConfirmSignInOptions(null);
    }
}
