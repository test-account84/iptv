package com.amplifyframework.auth.cognito.options;

import O.c;
import com.amplifyframework.auth.options.AuthResendUserAttributeConfirmationCodeOptions;
import com.amplifyframework.util.Immutable;
import j$.util.Objects;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class AWSCognitoAuthResendUserAttributeConfirmationCodeOptions extends AuthResendUserAttributeConfirmationCodeOptions {
    private final Map metadata;

    public static final class CognitoBuilder extends AuthResendUserAttributeConfirmationCodeOptions.Builder {
        private Map metadata = new HashMap();

        public AWSCognitoAuthResendUserAttributeConfirmationCodeOptions build() {
            return new AWSCognitoAuthResendUserAttributeConfirmationCodeOptions(Immutable.of(this.metadata));
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

    public AWSCognitoAuthResendUserAttributeConfirmationCodeOptions(Map map) {
        this.metadata = map;
    }

    public static CognitoBuilder builder() {
        return new CognitoBuilder();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AWSCognitoAuthResendUserAttributeConfirmationCodeOptions.class != obj.getClass()) {
            return false;
        }
        return c.a(getMetadata(), ((AWSCognitoAuthResendUserAttributeConfirmationCodeOptions) obj).getMetadata());
    }

    public Map getMetadata() {
        return this.metadata;
    }

    public int hashCode() {
        return c.b(getMetadata());
    }

    public String toString() {
        return "AWSCognitoAuthResendUserAttributeConfirmationCodeOptions{metadata=" + this.metadata + '}';
    }
}
