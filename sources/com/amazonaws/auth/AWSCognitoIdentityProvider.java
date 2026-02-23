package com.amazonaws.auth;

import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public interface AWSCognitoIdentityProvider extends AWSIdentityProvider {
    void clearListeners();

    String getIdentityId();

    String getIdentityPoolId();

    Map getLogins();

    void identityChanged(String str);

    boolean isAuthenticated();

    void registerIdentityChangedListener(IdentityChangedListener identityChangedListener);

    void setLogins(Map map);

    void unregisterIdentityChangedListener(IdentityChangedListener identityChangedListener);
}
