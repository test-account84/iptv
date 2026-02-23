package com.amazonaws.auth;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.services.cognitoidentity.AmazonCognitoIdentity;
import com.amazonaws.services.cognitoidentity.AmazonCognitoIdentityClient;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class AWSEnhancedCognitoIdentityProvider extends AWSAbstractCognitoIdentityProvider {
    public AWSEnhancedCognitoIdentityProvider(String str, String str2) {
        this(str, str2, new ClientConfiguration());
    }

    public String getProviderName() {
        return "Cognito";
    }

    public String refresh() {
        getIdentityId();
        return null;
    }

    public AWSEnhancedCognitoIdentityProvider(String str, String str2, ClientConfiguration clientConfiguration) {
        this(str, str2, new AmazonCognitoIdentityClient(new AnonymousAWSCredentials(), clientConfiguration));
    }

    public AWSEnhancedCognitoIdentityProvider(String str, String str2, AmazonCognitoIdentity amazonCognitoIdentity) {
        super(str, str2, amazonCognitoIdentity);
    }
}
