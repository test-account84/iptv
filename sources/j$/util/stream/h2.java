package j$.util.stream;

import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
final class H2 extends D2 {
    private X2 c;

    public final void accept(long j) {
        this.c.accept(j);
    }

    public final void l() {
        long[] jArr = (long[]) this.c.e();
        Arrays.sort(jArr);
        long length = jArr.length;
        q2 q2Var = this.a;
        q2Var.m(length);
        int i = 0;
        if (this.b) {
            int length2 = jArr.length;
            while (i < length2) {
                long j = jArr[i];
                if (q2Var.o()) {
                    break;
                }
                q2Var.accept(j);
                i++;
            }
        } else {
            int length3 = jArr.length;
            while (i < length3) {
                q2Var.accept(jArr[i]);
                i++;
            }
        }
        q2Var.l();
    }

    public final void m(long j) {
        if (j >= 2147483639) {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
        this.c = j > 0 ? new X2((int) j) : new X2();
    }
}
