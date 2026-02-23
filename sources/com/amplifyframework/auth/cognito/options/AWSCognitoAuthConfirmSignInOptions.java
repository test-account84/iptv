package com.amplifyframework.auth.cognito.options;

import O.c;
import com.amplifyframework.auth.options.AuthConfirmSignInOptions;
import com.amplifyframework.util.Immutable;
import j$.util.Objects;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class AWSCognitoAuthConfirmSignInOptions extends AuthConfirmSignInOptions {
    private final Map metadata;
    private final List userAttributes;

    public static final class CognitoBuilder extends AuthConfirmSignInOptions.Builder {
        private Map metadata = new HashMap();
        private List userAttributes = new ArrayList();

        public AWSCognitoAuthConfirmSignInOptions build() {
            return new AWSCognitoAuthConfirmSignInOptions(Immutable.of(this.metadata), Immutable.of(this.userAttributes));
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

        public CognitoBuilder userAttributes(List list) {
            Objects.requireNonNull(list);
            this.userAttributes.clear();
            this.userAttributes.addAll(list);
            return getThis();
        }
    }

    public AWSCognitoAuthConfirmSignInOptions(Map map, List list) {
        this.metadata = map;
        this.userAttributes = list;
    }

    public static CognitoBuilder builder() {
        return new CognitoBuilder();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AWSCognitoAuthConfirmSignInOptions.class != obj.getClass()) {
            return false;
        }
        AWSCognitoAuthConfirmSignInOptions aWSCognitoAuthConfirmSignInOptions = (AWSCognitoAuthConfirmSignInOptions) obj;
        return c.a(getMetadata(), aWSCognitoAuthConfirmSignInOptions.getMetadata()) && c.a(getUserAttributes(), aWSCognitoAuthConfirmSignInOptions.getUserAttributes());
    }

    public Map getMetadata() {
        return this.metadata;
    }

    public List getUserAttributes() {
        return this.userAttributes;
    }

    public int hashCode() {
        return c.b(getMetadata(), getUserAttributes());
    }

    public String toString() {
        return "AWSCognitoAuthConfirmSignInOptions{userAttributes=" + getUserAttributes() + ", metadata=" + getMetadata() + '}';
    }
}
