package com.amazonaws.mobileconnectors.appsync;

import D1.a;
import D1.b;
import android.util.Log;
import java.util.concurrent.Executor;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
class InMemoryOfflineMutationObject {
    private static final String TAG = "InMemoryOfflineMutationObject";
    final a.a callBack;
    final b chain;
    final Executor dispatcher;
    final String recordIdentifier;
    final a.c request;

    public InMemoryOfflineMutationObject(String str, a.c cVar, b bVar, Executor executor, a.a aVar) {
        this.recordIdentifier = str;
        this.request = cVar;
        this.chain = bVar;
        this.dispatcher = executor;
        this.callBack = aVar;
    }

    public void execute() {
        Log.v(TAG, "Thread:[" + Thread.currentThread().getId() + "]: Executing mutation by proceeding with the chain.");
        this.chain.a(this.request, this.dispatcher, this.callBack);
    }
}
