package com.amplifyframework.auth.options;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class AuthSignInOptions {

    public static abstract class Builder {
        public abstract AuthSignInOptions build();

        public abstract Builder getThis();
    }

    public static final class DefaultAuthSignInOptions extends AuthSignInOptions {
        private DefaultAuthSignInOptions() {
        }

        public boolean equals(Object obj) {
            return obj instanceof DefaultAuthSignInOptions;
        }

        public int hashCode() {
            return DefaultAuthSignInOptions.class.hashCode();
        }

        public String toString() {
            return DefaultAuthSignInOptions.class.getSimpleName();
        }

        public /* synthetic */ DefaultAuthSignInOptions(1 r1) {
            this();
        }
    }

    public static DefaultAuthSignInOptions defaults() {
        return new DefaultAuthSignInOptions(null);
    }
}
