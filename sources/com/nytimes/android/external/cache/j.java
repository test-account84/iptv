package com.nytimes.android.external.cache;

import java.util.concurrent.Executor;
import java.util.concurrent.Future;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public interface j extends Future {
    void addListener(Runnable runnable, Executor executor);
}
