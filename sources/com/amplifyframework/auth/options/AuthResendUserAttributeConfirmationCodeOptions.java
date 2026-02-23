package com.amplifyframework.auth.options;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class AuthResendUserAttributeConfirmationCodeOptions {

    public static abstract class Builder {
        public abstract AuthResendUserAttributeConfirmationCodeOptions build();

        public abstract Builder getThis();
    }

    public static final class DefaultAuthResendUserAttributeConfirmationCodeOptions extends AuthResendUserAttributeConfirmationCodeOptions {
        private DefaultAuthResendUserAttributeConfirmationCodeOptions() {
        }

        public boolean equals(Object obj) {
            return obj instanceof DefaultAuthResendUserAttributeConfirmationCodeOptions;
        }

        public int hashCode() {
            return DefaultAuthResendUserAttributeConfirmationCodeOptions.class.hashCode();
        }

        public String toString() {
            return DefaultAuthResendUserAttributeConfirmationCodeOptions.class.getSimpleName();
        }

        public /* synthetic */ DefaultAuthResendUserAttributeConfirmationCodeOptions(1 r1) {
            this();
        }
    }

    public static DefaultAuthResendUserAttributeConfirmationCodeOptions defaults() {
        return new DefaultAuthResendUserAttributeConfirmationCodeOptions(null);
    }
}
