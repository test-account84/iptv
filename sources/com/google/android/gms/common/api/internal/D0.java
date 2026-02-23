package com.google.android.gms.common.api.internal;

import com.google.android.gms.internal.base.zat;
import java.util.concurrent.ExecutorService;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class d0 {
    public static final ExecutorService a = zat.zaa().zac(2, new D4.c("GAC_Executor"), 2);

    public static ExecutorService a() {
        return a;
    }
}
