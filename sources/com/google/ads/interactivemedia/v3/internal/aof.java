package com.google.ads.interactivemedia.v3.internal;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Build;
import java.util.concurrent.Executor;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class aof {
    private static final String[] a = {"android:establish_vpn_service", "android:establish_vpn_manager"};
    private long b = 0;
    private long c = 0;
    private long d = -1;
    private boolean e = false;

    public aof(Context context, Executor executor, String[] strArr) {
        if (Build.VERSION.SDK_INT < 30) {
            return;
        }
        try {
            A.a((AppOpsManager) context.getSystemService("appops"), strArr, executor, new aoe(this));
        } catch (NoSuchMethodError | IllegalArgumentException unused) {
        }
    }

    public static /* bridge */ /* synthetic */ long a(aof aofVar) {
        return aofVar.c;
    }

    public static aof d(Context context, Executor executor) {
        return new aof(context, executor, a);
    }

    public static /* bridge */ /* synthetic */ void e(aof aofVar, long j) {
        aofVar.d = j;
    }

    public static /* bridge */ /* synthetic */ void f(aof aofVar, boolean z) {
        aofVar.e = z;
    }

    public static /* bridge */ /* synthetic */ void g(aof aofVar, long j) {
        aofVar.b = j;
    }

    public final long b() {
        long j = this.d;
        this.d = -1L;
        return j;
    }

    public final long c() {
        if (this.e) {
            return this.c - this.b;
        }
        return -1L;
    }

    public final void h() {
        if (this.e) {
            this.c = System.currentTimeMillis();
        }
    }
}
