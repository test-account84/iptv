package com.amplifyframework.auth.cognito.options;

import O.c;
import com.amplifyframework.auth.options.AuthSignOutOptions;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class AWSCognitoAuthSignOutOptions extends AuthSignOutOptions {
    private final String browserPackage;

    public static final class CognitoBuilder extends AuthSignOutOptions.Builder {
        private String browserPackage;

        public CognitoBuilder browserPackage(String str) {
            this.browserPackage = str;
            return this;
        }

        public AWSCognitoAuthSignOutOptions build() {
            return new AWSCognitoAuthSignOutOptions(super.isGlobalSignOut(), this.browserPackage);
        }

        public CognitoBuilder getThis() {
            return this;
        }
    }

    public AWSCognitoAuthSignOutOptions(boolean z, String str) {
        super(z);
        this.browserPackage = str;
    }

    public static CognitoBuilder builder() {
        return new CognitoBuilder();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AWSCognitoAuthSignOutOptions.class != obj.getClass()) {
            return false;
        }
        AWSCognitoAuthSignOutOptions aWSCognitoAuthSignOutOptions = (AWSCognitoAuthSignOutOptions) obj;
        return c.a(Boolean.valueOf(isGlobalSignOut()), Boolean.valueOf(aWSCognitoAuthSignOutOptions.isGlobalSignOut())) && c.a(getBrowserPackage(), aWSCognitoAuthSignOutOptions.getBrowserPackage());
    }

    public String getBrowserPackage() {
        return this.browserPackage;
    }

    public int hashCode() {
        return c.b(Boolean.valueOf(isGlobalSignOut()), getBrowserPackage());
    }

    public String toString() {
        return "AWSCognitoAuthSignOutOptions{isGlobalSignOut=" + isGlobalSignOut() + ", browserPackage=" + getBrowserPackage() + '}';
    }
}
