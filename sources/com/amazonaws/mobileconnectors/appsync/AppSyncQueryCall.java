package com.amazonaws.mobileconnectors.appsync;

import u1.c;
import v1.f;
import v1.h;
import w1.b;
import y1.a;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public interface AppSyncQueryCall extends c {

    public interface Factory {
        AppSyncQueryCall query(h hVar);
    }

    AppSyncQueryCall cacheHeaders(a aVar);

    /* synthetic */ c cacheHeaders(a aVar);

    /* synthetic */ void cancel();

    AppSyncQueryCall clone();

    /* synthetic */ c clone();

    /* synthetic */ void enqueue(c.a aVar);

    AppSyncQueryCall httpCachePolicy(b.c cVar);

    /* synthetic */ boolean isCanceled();

    /* synthetic */ f operation();

    AppSyncQueryCall responseFetcher(C1.a aVar);

    AppSyncQueryWatcher watcher();
}
