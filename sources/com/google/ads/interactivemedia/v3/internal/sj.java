package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class sj implements uh {
    protected final uh[] a;

    public sj(uh[] uhVarArr) {
        this.a = uhVarArr;
    }

    public final long bo() {
        long j = Long.MAX_VALUE;
        for (uh uhVar : this.a) {
            long bo = uhVar.bo();
            if (bo != Long.MIN_VALUE) {
                j = Math.min(j, bo);
            }
        }
        if (j == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j;
    }

    public final long c() {
        long j = Long.MAX_VALUE;
        for (uh uhVar : this.a) {
            long c = uhVar.c();
            if (c != Long.MIN_VALUE) {
                j = Math.min(j, c);
            }
        }
        if (j == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j;
    }

    public final void l(long j) {
        for (uh uhVar : this.a) {
            uhVar.l(j);
        }
    }

    public final boolean o(long j) {
        boolean z;
        boolean z2 = false;
        do {
            long c = c();
            if (c == Long.MIN_VALUE) {
                break;
            }
            z = false;
            for (uh uhVar : this.a) {
                long c2 = uhVar.c();
                boolean z3 = c2 != Long.MIN_VALUE && c2 <= j;
                if (c2 == c || z3) {
                    z |= uhVar.o(j);
                }
            }
            z2 |= z;
        } while (z);
        return z2;
    }

    public final boolean p() {
        for (uh uhVar : this.a) {
            if (uhVar.p()) {
                return true;
            }
        }
        return false;
    }
}
