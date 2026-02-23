package com.amplifyframework.auth.options;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class AuthConfirmSignUpOptions {

    public static abstract class Builder {
        public abstract AuthConfirmSignUpOptions build();

        public abstract Builder getThis();
    }

    public static final class DefaultAuthConfirmSignUpOptions extends AuthConfirmSignUpOptions {
        private DefaultAuthConfirmSignUpOptions() {
        }

        public boolean equals(Object obj) {
            return obj instanceof DefaultAuthConfirmSignUpOptions;
        }

        public int hashCode() {
            return DefaultAuthConfirmSignUpOptions.class.hashCode();
        }

        public String toString() {
            return DefaultAuthConfirmSignUpOptions.class.getSimpleName();
        }

        public /* synthetic */ DefaultAuthConfirmSignUpOptions(1 r1) {
            this();
        }
    }

    public static DefaultAuthConfirmSignUpOptions defaults() {
        return new DefaultAuthConfirmSignUpOptions(null);
    }
}
