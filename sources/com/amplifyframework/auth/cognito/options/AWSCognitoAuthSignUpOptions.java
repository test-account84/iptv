package com.amplifyframework.auth.cognito.options;

import O.c;
import com.amplifyframework.auth.options.AuthSignUpOptions;
import com.amplifyframework.util.Immutable;
import j$.util.Objects;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class AWSCognitoAuthSignUpOptions extends AuthSignUpOptions {
    private final Map clientMetadata;
    private final Map validationData;

    public static final class CognitoBuilder extends AuthSignUpOptions.Builder {
        private Map validationData = new HashMap();
        private Map clientMetadata = new HashMap();

        public AWSCognitoAuthSignUpOptions build() {
            return new AWSCognitoAuthSignUpOptions(Immutable.of(super.getUserAttributes()), Immutable.of(this.validationData), Immutable.of(this.clientMetadata));
        }

        public CognitoBuilder clientMetadata(Map map) {
            Objects.requireNonNull(map);
            this.clientMetadata.clear();
            this.clientMetadata.putAll(map);
            return getThis();
        }

        public CognitoBuilder getThis() {
            return this;
        }

        public CognitoBuilder validationData(Map map) {
            Objects.requireNonNull(map);
            this.validationData.clear();
            this.validationData.putAll(map);
            return getThis();
        }
    }

    public AWSCognitoAuthSignUpOptions(List list, Map map, Map map2) {
        super(list);
        this.validationData = map;
        this.clientMetadata = map2;
    }

    public static CognitoBuilder builder() {
        return new CognitoBuilder();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AWSCognitoAuthSignUpOptions.class != obj.getClass()) {
            return false;
        }
        AWSCognitoAuthSignUpOptions aWSCognitoAuthSignUpOptions = (AWSCognitoAuthSignUpOptions) obj;
        return c.a(getUserAttributes(), aWSCognitoAuthSignUpOptions.getUserAttributes()) && c.a(getValidationData(), aWSCognitoAuthSignUpOptions.getValidationData()) && c.a(getClientMetadata(), aWSCognitoAuthSignUpOptions.getClientMetadata());
    }

    public Map getClientMetadata() {
        return this.clientMetadata;
    }

    public Map getValidationData() {
        return this.validationData;
    }

    public int hashCode() {
        return c.b(getUserAttributes(), getValidationData(), getClientMetadata());
    }

    public String toString() {
        return "AWSCognitoAuthSignUpOptions{userAttributes=" + getUserAttributes() + ", validationData=" + getValidationData() + ", clientMetadata=" + getClientMetadata() + '}';
    }
}
