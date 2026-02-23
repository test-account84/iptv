package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bsc implements brp {
    private final brs a;
    private final String b;
    private final Object[] c;
    private final int d;

    public bsc(brs brsVar, String str, Object[] objArr) {
        this.a = brsVar;
        this.b = str;
        this.c = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.d = charAt;
            return;
        }
        int i = charAt & 8191;
        int i2 = 13;
        int i3 = 1;
        while (true) {
            int i4 = i3 + 1;
            char charAt2 = str.charAt(i3);
            if (charAt2 < 55296) {
                this.d = i | (charAt2 << i2);
                return;
            } else {
                i |= (charAt2 & 8191) << i2;
                i2 += 13;
                i3 = i4;
            }
        }
    }

    public final brs a() {
        return this.a;
    }

    public final boolean b() {
        return (this.d & 2) == 2;
    }

    public final int c() {
        return (this.d & 1) == 1 ? 1 : 2;
    }

    public final String d() {
        return this.b;
    }

    public final Object[] e() {
        return this.c;
    }
}
