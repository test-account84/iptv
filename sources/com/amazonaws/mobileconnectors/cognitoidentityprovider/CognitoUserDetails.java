package com.amazonaws.mobileconnectors.cognitoidentityprovider;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class CognitoUserDetails {
    private CognitoUserAttributes cognitoUserAttributes;
    private CognitoUserSettings cognitoUserSettings;

    public CognitoUserDetails(CognitoUserAttributes cognitoUserAttributes, CognitoUserSettings cognitoUserSettings) {
        this.cognitoUserAttributes = cognitoUserAttributes;
        this.cognitoUserSettings = cognitoUserSettings;
    }

    public CognitoUserAttributes getAttributes() {
        return this.cognitoUserAttributes;
    }

    public CognitoUserSettings getSettings() {
        return this.cognitoUserSettings;
    }
}
