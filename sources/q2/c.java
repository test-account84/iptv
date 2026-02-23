package Q2;

import O2.z0;
import java.nio.ByteBuffer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class c {
    public static final int[] a = {2002, 2000, 1920, 1601, 1600, 1001, 1000, 960, 800, 800, 480, 400, 400, 2048};

    public static final class b {
        public final int a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;

        public b(int i, int i2, int i3, int i4, int i5) {
            this.a = i;
            this.c = i2;
            this.b = i3;
            this.d = i4;
            this.e = i5;
        }

        public /* synthetic */ b(int i, int i2, int i3, int i4, int i5, a aVar) {
            this(i, i2, i3, i4, i5);
        }
    }

    public static void a(int i, d4.M m) {
        m.Q(7);
        byte[] e = m.e();
        e[0] = -84;
        e[1] = 64;
        e[2] = -1;
        e[3] = -1;
        e[4] = (byte) ((i >> 16) & 255);
        e[5] = (byte) ((i >> 8) & 255);
        e[6] = (byte) (i & 255);
    }

    public static z0 b(d4.M m, String str, String str2, V2.m mVar) {
        m.V(1);
        return new z0.b().U(str).g0("audio/ac4").J(2).h0(((m.H() & 32) >> 5) == 1 ? 48000 : 44100).O(mVar).X(str2).G();
    }

    public static int c(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[16];
        int position = byteBuffer.position();
        byteBuffer.get(bArr);
        byteBuffer.position(position);
        return d(new d4.L(bArr)).e;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0094  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static Q2.c.b d(d4.L r11) {
        /*
            r0 = 16
            int r1 = r11.h(r0)
            int r0 = r11.h(r0)
            r2 = 65535(0xffff, float:9.1834E-41)
            r3 = 4
            if (r0 != r2) goto L18
            r0 = 24
            int r0 = r11.h(r0)
            r2 = 7
            goto L19
        L18:
            r2 = 4
        L19:
            int r0 = r0 + r2
            r2 = 44097(0xac41, float:6.1793E-41)
            if (r1 != r2) goto L21
            int r0 = r0 + 2
        L21:
            r8 = r0
            r0 = 2
            int r1 = r11.h(r0)
            r2 = 3
            if (r1 != r2) goto L2f
            int r4 = f(r11, r0)
            int r1 = r1 + r4
        L2f:
            r5 = r1
            r1 = 10
            int r1 = r11.h(r1)
            boolean r4 = r11.g()
            if (r4 == 0) goto L45
            int r4 = r11.h(r2)
            if (r4 <= 0) goto L45
            r11.r(r0)
        L45:
            boolean r4 = r11.g()
            r6 = 44100(0xac44, float:6.1797E-41)
            r7 = 48000(0xbb80, float:6.7262E-41)
            if (r4 == 0) goto L55
            r9 = 48000(0xbb80, float:6.7262E-41)
            goto L58
        L55:
            r9 = 44100(0xac44, float:6.1797E-41)
        L58:
            int r11 = r11.h(r3)
            if (r9 != r6) goto L67
            r4 = 13
            if (r11 != r4) goto L67
            int[] r0 = Q2.c.a
            r11 = r0[r11]
            goto L95
        L67:
            if (r9 != r7) goto L94
            int[] r4 = Q2.c.a
            int r6 = r4.length
            if (r11 >= r6) goto L94
            r4 = r4[r11]
            int r1 = r1 % 5
            r6 = 8
            r7 = 1
            if (r1 == r7) goto L8f
            r7 = 11
            if (r1 == r0) goto L8a
            if (r1 == r2) goto L8f
            if (r1 == r3) goto L80
            goto L88
        L80:
            if (r11 == r2) goto L86
            if (r11 == r6) goto L86
            if (r11 != r7) goto L88
        L86:
            int r4 = r4 + 1
        L88:
            r11 = r4
            goto L95
        L8a:
            if (r11 == r6) goto L86
            if (r11 != r7) goto L88
            goto L86
        L8f:
            if (r11 == r2) goto L86
            if (r11 != r6) goto L88
            goto L86
        L94:
            r11 = 0
        L95:
            Q2.c$b r0 = new Q2.c$b
            r6 = 2
            r10 = 0
            r4 = r0
            r7 = r9
            r9 = r11
            r4.<init>(r5, r6, r7, r8, r9, r10)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: Q2.c.d(d4.L):Q2.c$b");
    }

    public static int e(byte[] bArr, int i) {
        int i2 = 7;
        if (bArr.length < 7) {
            return -1;
        }
        int i3 = ((bArr[2] & 255) << 8) | (bArr[3] & 255);
        if (i3 == 65535) {
            i3 = ((bArr[4] & 255) << 16) | ((bArr[5] & 255) << 8) | (bArr[6] & 255);
        } else {
            i2 = 4;
        }
        if (i == 44097) {
            i2 += 2;
        }
        return i3 + i2;
    }

    public static int f(d4.L l, int i) {
        int i2 = 0;
        while (true) {
            int h = i2 + l.h(i);
            if (!l.g()) {
                return h;
            }
            i2 = (h + 1) << i;
        }
    }
}
