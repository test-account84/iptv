package com.amplifyframework.auth.cognito;

import com.amazonaws.mobile.client.UserStateDetails;
import com.amplifyframework.auth.cognito.AWSCognitoAuthPlugin;
import com.amplifyframework.core.Action;
import com.amplifyframework.core.Consumer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final /* synthetic */ class d implements Action {
    public final /* synthetic */ Consumer a;
    public final /* synthetic */ UserStateDetails b;

    public /* synthetic */ d(Consumer consumer, UserStateDetails userStateDetails) {
        this.a = consumer;
        this.b = userStateDetails;
    }

    public final void call() {
        AWSCognitoAuthPlugin.23.a(this.a, this.b);
    }
}
