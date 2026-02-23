package com.amazonaws.mobile.client;

import com.amazonaws.auth.AWSAbstractCognitoIdentityProvider;
import com.amazonaws.services.cognitoidentity.AmazonCognitoIdentity;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
class AWSMobileClientCognitoIdentityProvider extends AWSAbstractCognitoIdentityProvider {
    boolean isDeveloperAuthenticated;

    public AWSMobileClientCognitoIdentityProvider(String str, String str2, AmazonCognitoIdentity amazonCognitoIdentity) {
        super(str, str2, amazonCognitoIdentity);
    }

    public String getProviderName() {
        return "Cognito";
    }

    public String getUserAgent() {
        return "AWSMobileClient";
    }

    public String refresh() {
        if (this.isDeveloperAuthenticated) {
            return this.token;
        }
        getIdentityId();
        return null;
    }

    public void setDeveloperAuthenticated(String str, String str2) {
        super.setIdentityId(str);
        super.setToken(str2);
        this.isDeveloperAuthenticated = true;
    }

    public void setNotDeveloperAuthenticated() {
        this.isDeveloperAuthenticated = false;
    }
}
