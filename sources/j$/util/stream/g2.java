package j$.util.stream;

import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
final class G2 extends C2 {
    private V2 c;

    public final void accept(int i) {
        this.c.accept(i);
    }

    public final void l() {
        int[] iArr = (int[]) this.c.e();
        Arrays.sort(iArr);
        long length = iArr.length;
        q2 q2Var = this.a;
        q2Var.m(length);
        int i = 0;
        if (this.b) {
            int length2 = iArr.length;
            while (i < length2) {
                int i2 = iArr[i];
                if (q2Var.o()) {
                    break;
                }
                q2Var.accept(i2);
                i++;
            }
        } else {
            int length3 = iArr.length;
            while (i < length3) {
                q2Var.accept(iArr[i]);
                i++;
            }
        }
        q2Var.l();
    }

    public final void m(long j) {
        if (j >= 2147483639) {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
        this.c = j > 0 ? new V2((int) j) : new V2();
    }
}
