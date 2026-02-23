package com.amazonaws.services.cognitoidentityprovider.model;

import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public enum IdentityProviderTypeType {
    SAML("SAML"),
    Facebook("Facebook"),
    Google("Google"),
    LoginWithAmazon("LoginWithAmazon"),
    SignInWithApple("SignInWithApple"),
    OIDC("OIDC");

    private static final Map enumMap;
    private String value;

    static {
        IdentityProviderTypeType identityProviderTypeType = SAML;
        IdentityProviderTypeType identityProviderTypeType2 = Facebook;
        IdentityProviderTypeType identityProviderTypeType3 = Google;
        IdentityProviderTypeType identityProviderTypeType4 = LoginWithAmazon;
        IdentityProviderTypeType identityProviderTypeType5 = SignInWithApple;
        IdentityProviderTypeType identityProviderTypeType6 = OIDC;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("SAML", identityProviderTypeType);
        hashMap.put("Facebook", identityProviderTypeType2);
        hashMap.put("Google", identityProviderTypeType3);
        hashMap.put("LoginWithAmazon", identityProviderTypeType4);
        hashMap.put("SignInWithApple", identityProviderTypeType5);
        hashMap.put("OIDC", identityProviderTypeType6);
    }

    IdentityProviderTypeType(String str) {
        this.value = str;
    }

    public static IdentityProviderTypeType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map map = enumMap;
        if (map.containsKey(str)) {
            return (IdentityProviderTypeType) map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }

    public String toString() {
        return this.value;
    }
}
