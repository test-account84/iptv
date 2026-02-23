package com.amplifyframework.auth.options;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class AuthResendSignUpCodeOptions {

    public static abstract class Builder {
        public abstract AuthResendSignUpCodeOptions build();

        public abstract Builder getThis();
    }

    public static final class DefaultAuthResendSignUpCodeOptions extends AuthResendSignUpCodeOptions {
        private DefaultAuthResendSignUpCodeOptions() {
        }

        public boolean equals(Object obj) {
            return obj instanceof DefaultAuthResendSignUpCodeOptions;
        }

        public int hashCode() {
            return DefaultAuthResendSignUpCodeOptions.class.hashCode();
        }

        public String toString() {
            return DefaultAuthResendSignUpCodeOptions.class.getSimpleName();
        }

        public /* synthetic */ DefaultAuthResendSignUpCodeOptions(1 r1) {
            this();
        }
    }

    public static DefaultAuthResendSignUpCodeOptions defaults() {
        return new DefaultAuthResendSignUpCodeOptions(null);
    }
}
