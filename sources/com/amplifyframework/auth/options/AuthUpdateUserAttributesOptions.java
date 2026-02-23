package com.amplifyframework.auth.options;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class AuthUpdateUserAttributesOptions {

    public static abstract class Builder {
        public abstract AuthUpdateUserAttributesOptions build();

        public abstract Builder getThis();
    }

    public static final class DefaultAuthUpdateUserAttributesOptions extends AuthUpdateUserAttributesOptions {
        private DefaultAuthUpdateUserAttributesOptions() {
        }

        public boolean equals(Object obj) {
            return obj instanceof DefaultAuthUpdateUserAttributesOptions;
        }

        public int hashCode() {
            return DefaultAuthUpdateUserAttributesOptions.class.hashCode();
        }

        public String toString() {
            return DefaultAuthUpdateUserAttributesOptions.class.getSimpleName();
        }

        public /* synthetic */ DefaultAuthUpdateUserAttributesOptions(1 r1) {
            this();
        }
    }

    public static DefaultAuthUpdateUserAttributesOptions defaults() {
        return new DefaultAuthUpdateUserAttributesOptions(null);
    }
}
