package com.amplifyframework.auth.cognito;

import com.amplifyframework.auth.AuthProvider;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class AWSCognitoAuthProvider extends AuthProvider {
    private static final String DEVELOPER = "cognito-identity.amazonaws.com";

    private AWSCognitoAuthProvider(String str) {
        super(str);
    }

    public static AuthProvider developer() {
        return new AWSCognitoAuthProvider("cognito-identity.amazonaws.com");
    }
}
