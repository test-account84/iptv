package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class hl {
    public static final hl a;
    public static final hl b;
    public final long c;
    public final long d;

    static {
        hl hlVar = new hl(0L, 0L);
        a = hlVar;
        new hl(Long.MAX_VALUE, Long.MAX_VALUE);
        new hl(Long.MAX_VALUE, 0L);
        new hl(0L, Long.MAX_VALUE);
        b = hlVar;
    }

    public hl(long j, long j2) {
        af.u(j >= 0);
        af.u(j2 >= 0);
        this.c = j;
        this.d = j2;
    }

    public final long a(long j, long j2, long j3) {
        long j4 = this.c;
        if (j4 == 0 && this.d == 0) {
            return j;
        }
        long aw = cq.aw(j, j4);
        long an = cq.an(j, this.d);
        boolean z = aw <= j2 && j2 <= an;
        boolean z2 = aw <= j3 && j3 <= an;
        return (z && z2) ? Math.abs(j2 - j) <= Math.abs(j3 - j) ? j2 : j3 : z ? j2 : z2 ? j3 : aw;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && hl.class == obj.getClass()) {
            hl hlVar = (hl) obj;
            if (this.c == hlVar.c && this.d == hlVar.d) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (((int) this.c) * 31) + ((int) this.d);
    }
}
