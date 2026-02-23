package y6;

import x6.c;
import x6.m;
import x6.o;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class b implements m {
    public o a(c cVar) {
        return b(cVar, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0060 A[LOOP:0: B:25:0x005e->B:26:0x0060, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public x6.o b(x6.c r11, java.util.Map r12) {
        /*
            r10 = this;
            A6.a r0 = new A6.a
            D6.b r11 = r11.a()
            r0.<init>(r11)
            r11 = 0
            r1 = 0
            y6.a r2 = r0.a(r11)     // Catch: x6.g -> L25 x6.k -> L28
            x6.q[] r3 = r2.b()     // Catch: x6.g -> L25 x6.k -> L28
            z6.a r4 = new z6.a     // Catch: x6.g -> L21 x6.k -> L23
            r4.<init>()     // Catch: x6.g -> L21 x6.k -> L23
            D6.e r2 = r4.c(r2)     // Catch: x6.g -> L21 x6.k -> L23
            r4 = r3
            r3 = r1
            r1 = r2
            r2 = r3
            goto L31
        L21:
            r2 = move-exception
            goto L2b
        L23:
            r2 = move-exception
            goto L2f
        L25:
            r2 = move-exception
            r3 = r1
            goto L2b
        L28:
            r2 = move-exception
            r3 = r1
            goto L2f
        L2b:
            r4 = r3
            r3 = r2
            r2 = r1
            goto L31
        L2f:
            r4 = r3
            r3 = r1
        L31:
            if (r1 != 0) goto L45
            r1 = 1
            y6.a r0 = r0.a(r1)     // Catch: x6.g -> L47 x6.k -> L49
            x6.q[] r4 = r0.b()     // Catch: x6.g -> L47 x6.k -> L49
            z6.a r1 = new z6.a     // Catch: x6.g -> L47 x6.k -> L49
            r1.<init>()     // Catch: x6.g -> L47 x6.k -> L49
            D6.e r1 = r1.c(r0)     // Catch: x6.g -> L47 x6.k -> L49
        L45:
            r6 = r4
            goto L51
        L47:
            r11 = move-exception
            goto L4a
        L49:
            r11 = move-exception
        L4a:
            if (r2 != 0) goto L50
            if (r3 == 0) goto L4f
            throw r3
        L4f:
            throw r11
        L50:
            throw r2
        L51:
            if (r12 == 0) goto L68
            x6.e r0 = x6.e.NEED_RESULT_POINT_CALLBACK
            java.lang.Object r12 = r12.get(r0)
            x6.r r12 = (x6.r) r12
            if (r12 == 0) goto L68
            int r0 = r6.length
        L5e:
            if (r11 >= r0) goto L68
            r2 = r6[r11]
            r12.a(r2)
            int r11 = r11 + 1
            goto L5e
        L68:
            x6.o r11 = new x6.o
            java.lang.String r3 = r1.h()
            byte[] r4 = r1.e()
            int r5 = r1.c()
            x6.a r7 = x6.a.AZTEC
            long r8 = java.lang.System.currentTimeMillis()
            r2 = r11
            r2.<init>(r3, r4, r5, r6, r7, r8)
            java.util.List r12 = r1.a()
            if (r12 == 0) goto L8b
            x6.p r0 = x6.p.BYTE_SEGMENTS
            r11.h(r0, r12)
        L8b:
            java.lang.String r12 = r1.b()
            if (r12 == 0) goto L96
            x6.p r0 = x6.p.ERROR_CORRECTION_LEVEL
            r11.h(r0, r12)
        L96:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: y6.b.b(x6.c, java.util.Map):x6.o");
    }

    public void reset() {
    }
}
