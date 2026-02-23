package com.google.ads.interactivemedia.v3.internal;

import android.os.SystemClock;
import android.text.TextUtils;
import java.io.IOException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class ev extends at {
    public final int c;
    public final String d;
    public final int e;
    public final s f;
    public final int g;
    public final am h;
    final boolean i;

    private ev(int i, Throwable th, int i2) {
        this(i, th, i2, null, -1, null, 4, false);
    }

    public static ev b(Throwable th, String str, int i, s sVar, int i2, boolean z, int i3) {
        return new ev(1, th, i3, str, i, sVar, sVar == null ? 4 : i2, z);
    }

    public static ev c(IOException iOException, int i) {
        return new ev(0, iOException, i);
    }

    public static ev d(RuntimeException runtimeException, int i) {
        return new ev(2, runtimeException, i);
    }

    public final ev a(am amVar) {
        String message = getMessage();
        int i = cq.a;
        return new ev(message, getCause(), this.a, this.c, this.d, this.e, this.f, this.g, amVar, this.b, this.i);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    private ev(int i, Throwable th, int i2, String str, int i3, s sVar, int i4, boolean z) {
        String str2;
        if (i == 0) {
            str2 = "Source error";
        } else if (i != 1) {
            str2 = "Unexpected runtime error";
        } else {
            str2 = str + " error, index=" + i3 + ", format=" + String.valueOf(sVar) + ", format_supported=" + cq.N(i4);
        }
        if (!TextUtils.isEmpty((CharSequence) null)) {
            str2 = str2 + ": " + ((String) null);
        }
        this(str2, th, i2, i, str, i3, sVar, i4, null, SystemClock.elapsedRealtime(), z);
    }

    private ev(String str, Throwable th, int i, int i2, String str2, int i3, s sVar, int i4, am amVar, long j, boolean z) {
        boolean z2;
        super(str, th, i, j);
        int i5 = i2;
        if (!z) {
            z2 = true;
        } else if (i5 == 1) {
            i5 = 1;
            z2 = true;
        } else {
            z2 = false;
        }
        af.u(z2);
        af.u(th != null);
        this.c = i5;
        this.d = str2;
        this.e = i3;
        this.f = sVar;
        this.g = i4;
        this.h = amVar;
        this.i = z;
    }
}
