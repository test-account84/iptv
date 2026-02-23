package com.google.android.gms.internal.location;

import android.os.Looper;
import com.google.android.gms.common.internal.r;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzbj {
    public static Looper zza(Looper looper) {
        return looper != null ? looper : zzb();
    }

    public static Looper zzb() {
        r.q(Looper.myLooper() != null, "Can't create handler inside thread that has not called Looper.prepare()");
        return Looper.myLooper();
    }
}
