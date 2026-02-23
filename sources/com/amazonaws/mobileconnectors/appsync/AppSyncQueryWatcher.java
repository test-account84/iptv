package com.amazonaws.mobileconnectors.appsync;

import M1.a;
import u1.c;
import v1.f;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public interface AppSyncQueryWatcher extends a {
    void cancel();

    AppSyncQueryWatcher enqueueAndWatch(c.a aVar);

    /* synthetic */ boolean isCanceled();

    f operation();

    void refetch();

    AppSyncQueryWatcher refetchResponseFetcher(C1.a aVar);
}
