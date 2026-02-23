package com.amplifyframework.auth.cognito;

import com.amplifyframework.auth.cognito.AWSCognitoAuthPlugin;
import com.amplifyframework.auth.result.AuthSignInResult;
import com.amplifyframework.core.Action;
import com.amplifyframework.core.Consumer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final /* synthetic */ class e implements Action {
    public final /* synthetic */ Consumer a;
    public final /* synthetic */ AuthSignInResult b;

    public /* synthetic */ e(Consumer consumer, AuthSignInResult authSignInResult) {
        this.a = consumer;
        this.b = authSignInResult;
    }

    public final void call() {
        AWSCognitoAuthPlugin.5.a(this.a, this.b);
    }
}
