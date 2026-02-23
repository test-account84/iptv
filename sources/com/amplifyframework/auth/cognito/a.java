package com.amplifyframework.auth.cognito;

import com.amazonaws.mobile.client.UserStateDetails;
import com.amazonaws.mobile.client.UserStateListener;
import com.amplifyframework.auth.cognito.AWSCognitoAuthPlugin;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final /* synthetic */ class a implements UserStateListener {
    public final /* synthetic */ AWSCognitoAuthPlugin.1 a;

    public /* synthetic */ a(AWSCognitoAuthPlugin.1 r1) {
        this.a = r1;
    }

    public final void onUserStateChanged(UserStateDetails userStateDetails) {
        AWSCognitoAuthPlugin.1.b(this.a, userStateDetails);
    }
}
