package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.os.Build;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class anh {
    private NetworkCapabilities a;

    public anh(ConnectivityManager connectivityManager) {
        if (connectivityManager == null || Build.VERSION.SDK_INT < 24) {
            return;
        }
        try {
            X0.f.a(connectivityManager, new ang(this));
        } catch (RuntimeException unused) {
            synchronized (anh.class) {
                this.a = null;
            }
        }
    }

    public static anh c(Context context) {
        if (context != null) {
            return new anh((ConnectivityManager) context.getSystemService("connectivity"));
        }
        return null;
    }

    public static /* bridge */ /* synthetic */ void d(anh anhVar, NetworkCapabilities networkCapabilities) {
        anhVar.a = networkCapabilities;
    }

    public final long a() {
        synchronized (anh.class) {
            try {
                NetworkCapabilities networkCapabilities = this.a;
                if (networkCapabilities != null) {
                    if (networkCapabilities.hasTransport(4)) {
                        return 2L;
                    }
                    if (this.a.hasTransport(1)) {
                        return 1L;
                    }
                    if (this.a.hasTransport(0)) {
                        return 0L;
                    }
                }
                return -1L;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final NetworkCapabilities b() {
        return this.a;
    }
}
