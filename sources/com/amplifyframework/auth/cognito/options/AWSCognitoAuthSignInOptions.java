package com.amplifyframework.auth.cognito.options;

import O.c;
import com.amplifyframework.auth.options.AuthSignInOptions;
import com.amplifyframework.util.Immutable;
import j$.util.Objects;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class AWSCognitoAuthSignInOptions extends AuthSignInOptions {
    private final AuthFlowType authFlowType;
    private final Map metadata;

    public static final class CognitoBuilder extends AuthSignInOptions.Builder {
        private AuthFlowType authFlowType;
        private Map metadata = new HashMap();

        public CognitoBuilder authFlowType(AuthFlowType authFlowType) {
            this.authFlowType = authFlowType;
            return getThis();
        }

        public AWSCognitoAuthSignInOptions build() {
            return new AWSCognitoAuthSignInOptions(Immutable.of(this.metadata), this.authFlowType);
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

    public AWSCognitoAuthSignInOptions(Map map, AuthFlowType authFlowType) {
        this.metadata = map;
        this.authFlowType = authFlowType;
    }

    public static CognitoBuilder builder() {
        return new CognitoBuilder();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AWSCognitoAuthSignInOptions.class != obj.getClass()) {
            return false;
        }
        return c.a(getMetadata(), ((AWSCognitoAuthSignInOptions) obj).getMetadata());
    }

    public AuthFlowType getAuthFlowType() {
        return this.authFlowType;
    }

    public Map getMetadata() {
        return this.metadata;
    }

    public int hashCode() {
        return c.b(getMetadata());
    }

    public String toString() {
        return "AWSCognitoAuthSignInOptions{metadata=" + this.metadata + '}';
    }
}
