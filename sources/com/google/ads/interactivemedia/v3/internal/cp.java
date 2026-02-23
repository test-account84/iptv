package com.google.ads.interactivemedia.v3.internal;

import java.util.concurrent.ThreadFactory;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class cp implements ThreadFactory {
    public final /* synthetic */ String a;

    public /* synthetic */ cp(String str) {
        this.a = str;
    }

    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, this.a);
    }
}
