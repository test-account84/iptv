package com.amplifyframework.auth.cognito.options;

import O.c;
import com.amplifyframework.auth.options.AuthWebUISignInOptions;
import com.amplifyframework.util.Immutable;
import java.util.List;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class AWSCognitoAuthWebUISignInOptions extends AuthWebUISignInOptions {
    private final String browserPackage;
    private final String federationProviderName;
    private final String idpIdentifier;

    public static final class CognitoBuilder extends AuthWebUISignInOptions.Builder {
        private String browserPackage;
        private String federationProviderName;
        private String idpIdentifier;

        public CognitoBuilder browserPackage(String str) {
            this.browserPackage = str;
            return this;
        }

        public AWSCognitoAuthWebUISignInOptions build() {
            return new AWSCognitoAuthWebUISignInOptions(Immutable.of(super.getScopes()), Immutable.of(super.getSignInQueryParameters()), Immutable.of(super.getSignOutQueryParameters()), Immutable.of(super.getTokenQueryParameters()), this.idpIdentifier, this.federationProviderName, this.browserPackage);
        }

        public CognitoBuilder federationProviderName(String str) {
            this.federationProviderName = str;
            return getThis();
        }

        public CognitoBuilder getThis() {
            return this;
        }

        public CognitoBuilder idpIdentifier(String str) {
            this.idpIdentifier = str;
            return getThis();
        }
    }

    public AWSCognitoAuthWebUISignInOptions(List list, Map map, Map map2, Map map3, String str, String str2, String str3) {
        super(list, map, map2, map3);
        this.idpIdentifier = str;
        this.federationProviderName = str2;
        this.browserPackage = str3;
    }

    public static CognitoBuilder builder() {
        return new CognitoBuilder();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AWSCognitoAuthWebUISignInOptions.class != obj.getClass()) {
            return false;
        }
        AWSCognitoAuthWebUISignInOptions aWSCognitoAuthWebUISignInOptions = (AWSCognitoAuthWebUISignInOptions) obj;
        return c.a(getScopes(), aWSCognitoAuthWebUISignInOptions.getScopes()) && c.a(getSignInQueryParameters(), aWSCognitoAuthWebUISignInOptions.getSignInQueryParameters()) && c.a(getSignOutQueryParameters(), aWSCognitoAuthWebUISignInOptions.getSignOutQueryParameters()) && c.a(getTokenQueryParameters(), aWSCognitoAuthWebUISignInOptions.getTokenQueryParameters()) && c.a(getIdpIdentifier(), aWSCognitoAuthWebUISignInOptions.getIdpIdentifier()) && c.a(getFederationProviderName(), aWSCognitoAuthWebUISignInOptions.getFederationProviderName()) && c.a(getBrowserPackage(), aWSCognitoAuthWebUISignInOptions.getBrowserPackage());
    }

    public String getBrowserPackage() {
        return this.browserPackage;
    }

    public String getFederationProviderName() {
        return this.federationProviderName;
    }

    public String getIdpIdentifier() {
        return this.idpIdentifier;
    }

    public int hashCode() {
        return c.b(getScopes(), getSignInQueryParameters(), getSignOutQueryParameters(), getTokenQueryParameters(), getIdpIdentifier(), getFederationProviderName(), getBrowserPackage());
    }

    public String toString() {
        return "AWSCognitoAuthWebUISignInOptions{scopes=" + getScopes() + ", signInQueryParameters=" + getSignInQueryParameters() + ", signOutQueryParameters=" + getSignOutQueryParameters() + ", tokenQueryParameters=" + getTokenQueryParameters() + ", idpIdentifier=" + getIdpIdentifier() + ", federationProviderName=" + getFederationProviderName() + ", browserPackage=" + getBrowserPackage() + '}';
    }
}
