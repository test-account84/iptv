package j$.util.stream;

import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
final class F2 extends B2 {
    private T2 c;

    public final void accept(double d) {
        this.c.accept(d);
    }

    public final void l() {
        double[] dArr = (double[]) this.c.e();
        Arrays.sort(dArr);
        long length = dArr.length;
        q2 q2Var = this.a;
        q2Var.m(length);
        int i = 0;
        if (this.b) {
            int length2 = dArr.length;
            while (i < length2) {
                double d = dArr[i];
                if (q2Var.o()) {
                    break;
                }
                q2Var.accept(d);
                i++;
            }
        } else {
            int length3 = dArr.length;
            while (i < length3) {
                q2Var.accept(dArr[i]);
                i++;
            }
        }
        q2Var.l();
    }

    public final void m(long j) {
        if (j >= 2147483639) {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
        this.c = j > 0 ? new T2((int) j) : new T2();
    }
}
