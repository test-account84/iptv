package com.amplifyframework.auth.options;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class AuthUpdateUserAttributeOptions {

    public static abstract class Builder {
        public abstract AuthUpdateUserAttributeOptions build();

        public abstract Builder getThis();
    }

    public static final class DefaultAuthUpdateUserAttributeOptions extends AuthUpdateUserAttributeOptions {
        private DefaultAuthUpdateUserAttributeOptions() {
        }

        public boolean equals(Object obj) {
            return obj instanceof DefaultAuthUpdateUserAttributeOptions;
        }

        public int hashCode() {
            return DefaultAuthUpdateUserAttributeOptions.class.hashCode();
        }

        public String toString() {
            return DefaultAuthUpdateUserAttributeOptions.class.getSimpleName();
        }

        public /* synthetic */ DefaultAuthUpdateUserAttributeOptions(1 r1) {
            this();
        }
    }

    public static DefaultAuthUpdateUserAttributeOptions defaults() {
        return new DefaultAuthUpdateUserAttributeOptions(null);
    }
}
