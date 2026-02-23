package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class tz implements wl {
    public long a;
    public long b;
    public tz c;
    public bdz d;

    public tz(long j) {
        d(j);
    }

    public final int a(long j) {
        long j2 = this.a;
        int i = this.d.b;
        return (int) (j - j2);
    }

    public final tz b() {
        this.d = null;
        tz tzVar = this.c;
        this.c = null;
        return tzVar;
    }

    public final wl c() {
        tz tzVar = this.c;
        if (tzVar == null || tzVar.d == null) {
            return null;
        }
        return tzVar;
    }

    public final void d(long j) {
        af.w(this.d == null);
        this.a = j;
        this.b = j + 65536;
    }

    public final bdz e() {
        bdz bdzVar = this.d;
        af.s(bdzVar);
        return bdzVar;
    }
}
