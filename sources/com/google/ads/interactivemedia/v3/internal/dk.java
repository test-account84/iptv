package com.google.ads.interactivemedia.v3.internal;

import android.system.ErrnoException;
import android.system.OsConstants;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class dk {
    public static /* bridge */ /* synthetic */ boolean a(Throwable th) {
        return b(th);
    }

    private static boolean b(Throwable th) {
        return (th instanceof ErrnoException) && ((ErrnoException) th).errno == OsConstants.EACCES;
    }
}
