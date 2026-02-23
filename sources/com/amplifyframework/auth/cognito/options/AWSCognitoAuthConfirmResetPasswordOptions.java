package com.amplifyframework.auth.cognito.options;

import O.c;
import com.amplifyframework.auth.options.AuthConfirmResetPasswordOptions;
import com.amplifyframework.util.Immutable;
import j$.util.Objects;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class AWSCognitoAuthConfirmResetPasswordOptions extends AuthConfirmResetPasswordOptions {
    private final Map metadata;

    public static final class CognitoBuilder extends AuthConfirmResetPasswordOptions.Builder {
        private Map metadata = new HashMap();

        public AWSCognitoAuthConfirmResetPasswordOptions build() {
            return new AWSCognitoAuthConfirmResetPasswordOptions(Immutable.of(this.metadata));
        }

        public CognitoBuilder getThis() {
            return this;
        }

        public CognitoBuilder metadata(Map map) {
            Objects.requireNonNull(map);
            this.metadata.clear();
            this.metadata.putAll(map);
            return getThis();
        }
    }

    public AWSCognitoAuthConfirmResetPasswordOptions(Map map) {
        this.metadata = map;
    }

    public static CognitoBuilder builder() {
        return new CognitoBuilder();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AWSCognitoAuthConfirmResetPasswordOptions.class != obj.getClass()) {
            return false;
        }
        return c.a(getMetadata(), ((AWSCognitoAuthConfirmResetPasswordOptions) obj).getMetadata());
    }

    public Map getMetadata() {
        return this.metadata;
    }

    public int hashCode() {
        return c.b(getMetadata());
    }

    public String toString() {
        return "AWSCognitoAuthConfirmResetPasswordOptions{metadata=" + this.metadata + '}';
    }
}
