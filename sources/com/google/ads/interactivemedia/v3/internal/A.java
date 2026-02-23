package com.google.ads.interactivemedia.v3.internal;

import android.net.Uri;
import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class a {
    public final long a;
    public final int b;
    public final Uri[] c;
    public final int[] d;
    public final long[] e;
    public final long f;
    public final boolean g;

    public a() {
        this(-1, new int[0], new Uri[0], new long[0]);
    }

    public final int a() {
        return b(-1);
    }

    public final int b(int i) {
        int i2;
        int i3 = i + 1;
        while (true) {
            int[] iArr = this.d;
            if (i3 >= iArr.length || (i2 = iArr[i3]) == 0 || i2 == 1) {
                break;
            }
            i3++;
        }
        return i3;
    }

    public final a c() {
        int[] iArr = this.d;
        int length = iArr.length;
        int max = Math.max(0, length);
        int[] copyOf = Arrays.copyOf(iArr, max);
        Arrays.fill(copyOf, length, max, 0);
        long[] jArr = this.e;
        int length2 = jArr.length;
        int max2 = Math.max(0, length2);
        long[] copyOf2 = Arrays.copyOf(jArr, max2);
        Arrays.fill(copyOf2, length2, max2, -9223372036854775807L);
        return new a(0, copyOf, (Uri[]) Arrays.copyOf(this.c, 0), copyOf2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && a.class == obj.getClass()) {
            a aVar = (a) obj;
            if (this.b == aVar.b && Arrays.equals(this.c, aVar.c) && Arrays.equals(this.d, aVar.d) && Arrays.equals(this.e, aVar.e)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((this.b * 961) + Arrays.hashCode(this.c)) * 31) + Arrays.hashCode(this.d)) * 31) + Arrays.hashCode(this.e)) * 961;
    }

    private a(int i, int[] iArr, Uri[] uriArr, long[] jArr) {
        af.u(iArr.length == uriArr.length);
        this.a = 0L;
        this.b = i;
        this.d = iArr;
        this.c = uriArr;
        this.e = jArr;
        this.f = 0L;
        this.g = false;
    }
}
