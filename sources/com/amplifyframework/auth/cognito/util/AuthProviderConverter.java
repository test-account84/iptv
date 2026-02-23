package com.amplifyframework.auth.cognito.util;

import com.amplifyframework.auth.AuthProvider;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class AuthProviderConverter {
    private static final Map CONVERT_AUTH_PROVIDER;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(AuthProvider.amazon(), "LoginWithAmazon");
        hashMap.put(AuthProvider.facebook(), "Facebook");
        hashMap.put(AuthProvider.google(), "Google");
        hashMap.put(AuthProvider.apple(), "SignInWithApple");
        CONVERT_AUTH_PROVIDER = Collections.unmodifiableMap(hashMap);
    }

    private AuthProviderConverter() {
    }

    public static String getIdentityProvider(AuthProvider authProvider) {
        String str = (String) CONVERT_AUTH_PROVIDER.get(authProvider);
        return str != null ? str : authProvider.getProviderKey();
    }
}
