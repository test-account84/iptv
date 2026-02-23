package com.google.ads.interactivemedia.v3.internal;

import android.net.Uri;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class dc {
    public final Uri a;
    public final int b;
    public final byte[] c;
    public final Map d;
    public final long e;
    public final long f;
    public final String g;
    public final int h;

    static {
        aj.b("media3.datasource");
    }

    private dc(Uri uri, int i, byte[] bArr, Map map, long j, long j2, String str, int i2) {
        boolean z = false;
        boolean z2 = j >= 0;
        af.u(z2);
        af.u(z2);
        if (j2 > 0) {
            z = true;
        } else if (j2 == -1) {
            j2 = -1;
            z = true;
        }
        af.u(z);
        this.a = uri;
        this.b = i;
        this.c = (bArr == null || bArr.length == 0) ? null : bArr;
        this.d = Collections.unmodifiableMap(new HashMap(map));
        this.e = j;
        this.f = j2;
        this.g = str;
        this.h = i2;
    }

    public static String c(int i) {
        if (i == 1) {
            return "GET";
        }
        if (i == 2) {
            return "POST";
        }
        throw new IllegalStateException();
    }

    public final db a() {
        return new db(this);
    }

    public final dc b(long j) {
        long j2 = this.f;
        long j3 = j2 != -1 ? j2 - j : -1L;
        long j4 = 0;
        if (j != 0) {
            j4 = j;
        } else if (j2 == j3) {
            return this;
        }
        return new dc(this.a, this.b, this.c, this.d, this.e + j4, j3, this.g, this.h);
    }

    public final boolean d(int i) {
        return (this.h & i) == i;
    }

    public final String toString() {
        return "DataSpec[" + c(this.b) + " " + String.valueOf(this.a) + ", " + this.e + ", " + this.f + ", " + this.g + ", " + this.h + "]";
    }

    public /* synthetic */ dc(Uri uri, int i, byte[] bArr, Map map, long j, long j2, String str, int i2, byte[] bArr2) {
        this(uri, i, bArr, map, j, j2, str, i2);
    }

    public dc(Uri uri, long j, long j2) {
        this(uri, 1, null, Collections.emptyMap(), j, j2, null, 0);
    }
}
