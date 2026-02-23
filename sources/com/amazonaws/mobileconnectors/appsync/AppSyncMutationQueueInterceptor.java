package com.amazonaws.mobileconnectors.appsync;

import D1.a;
import D1.b;
import java.util.Map;
import java.util.concurrent.Executor;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class AppSyncMutationQueueInterceptor implements a {
    Map mutationMap;

    public AppSyncMutationQueueInterceptor(Map map) {
        this.mutationMap = map;
    }

    public void dispose() {
    }

    public void interceptAsync(a.c cVar, b bVar, Executor executor, a.a aVar) {
        this.mutationMap.containsKey(cVar.b.operationId());
    }
}
