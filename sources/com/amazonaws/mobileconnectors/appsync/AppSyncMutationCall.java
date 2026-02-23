package com.amazonaws.mobileconnectors.appsync;

import u1.c;
import v1.e;
import v1.f;
import v1.g;
import v1.h;
import y1.a;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public interface AppSyncMutationCall extends c {

    public interface Factory {
        AppSyncMutationCall mutate(e eVar);

        AppSyncMutationCall mutate(e eVar, f.a aVar);
    }

    AppSyncMutationCall cacheHeaders(a aVar);

    /* synthetic */ c cacheHeaders(a aVar);

    /* synthetic */ void cancel();

    AppSyncMutationCall clone();

    /* synthetic */ c clone();

    /* synthetic */ void enqueue(c.a aVar);

    /* synthetic */ boolean isCanceled();

    /* synthetic */ f operation();

    AppSyncMutationCall refetchQueries(g... gVarArr);

    AppSyncMutationCall refetchQueries(h... hVarArr);
}
