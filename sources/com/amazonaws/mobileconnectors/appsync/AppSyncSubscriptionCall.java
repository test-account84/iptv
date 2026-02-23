package com.amazonaws.mobileconnectors.appsync;

import B1.b;
import M1.a;
import v1.i;
import v1.t;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public interface AppSyncSubscriptionCall extends a {

    public interface Callback {
        void onCompleted();

        void onFailure(b bVar);

        void onResponse(i iVar);
    }

    public interface Factory {
        AppSyncSubscriptionCall subscribe(t tVar);
    }

    public interface StartedCallback extends Callback {
        void onStarted();
    }

    /* synthetic */ void cancel();

    AppSyncSubscriptionCall clone();

    void execute(Callback callback);

    /* synthetic */ boolean isCanceled();
}
