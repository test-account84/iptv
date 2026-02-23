package k1;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class c {
    public static c e;
    public d a = d.UNKNOWN;
    public int b = 0;
    public int c = 0;
    public int d = 0;

    public static c a() {
        if (e == null) {
            synchronized (c.class) {
                try {
                    if (e == null) {
                        e = new c();
                    }
                } finally {
                }
            }
        }
        return e;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0066 A[Catch: all -> 0x003f, TRY_LEAVE, TryCatch #0 {all -> 0x003f, blocks: (B:9:0x001f, B:11:0x0035, B:19:0x0041, B:21:0x0045, B:22:0x0047, B:24:0x0066, B:28:0x004e, B:31:0x0055, B:34:0x005c, B:36:0x0061), top: B:8:0x001f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void b(long r4, long r6) {
        /*
            r3 = this;
            monitor-enter(r3)
            r0 = 0
            int r2 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r2 == 0) goto L6f
            r0 = 20000(0x4e20, double:9.8813E-320)
            int r2 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r2 < 0) goto L6f
            double r4 = (double) r4
            r0 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r4 = r4 * r0
            double r6 = (double) r6
            double r4 = r4 / r6
            r6 = 4620693217682128896(0x4020000000000000, double:8.0)
            double r4 = r4 * r6
            r6 = 4621819117588971520(0x4024000000000000, double:10.0)
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 >= 0) goto L1f
            goto L6f
        L1f:
            int r6 = r3.b     // Catch: java.lang.Throwable -> L3f
            int r7 = r3.c     // Catch: java.lang.Throwable -> L3f
            int r6 = r6 * r7
            double r0 = (double) r6     // Catch: java.lang.Throwable -> L3f
            double r0 = r0 + r4
            int r4 = r7 + 1
            double r4 = (double) r4     // Catch: java.lang.Throwable -> L3f
            double r0 = r0 / r4
            int r4 = (int) r0     // Catch: java.lang.Throwable -> L3f
            r3.b = r4     // Catch: java.lang.Throwable -> L3f
            int r7 = r7 + 1
            r3.c = r7     // Catch: java.lang.Throwable -> L3f
            r5 = 5
            if (r7 == r5) goto L41
            k1.d r6 = r3.a     // Catch: java.lang.Throwable -> L3f
            k1.d r0 = k1.d.UNKNOWN     // Catch: java.lang.Throwable -> L3f
            if (r6 != r0) goto L6b
            r6 = 2
            if (r7 != r6) goto L6b
            goto L41
        L3f:
            r4 = move-exception
            goto L6d
        L41:
            r3.d = r4     // Catch: java.lang.Throwable -> L3f
            if (r4 > 0) goto L4a
            k1.d r4 = k1.d.UNKNOWN     // Catch: java.lang.Throwable -> L3f
        L47:
            r3.a = r4     // Catch: java.lang.Throwable -> L3f
            goto L64
        L4a:
            r6 = 150(0x96, float:2.1E-43)
            if (r4 >= r6) goto L51
            k1.d r4 = k1.d.POOR     // Catch: java.lang.Throwable -> L3f
            goto L47
        L51:
            r6 = 550(0x226, float:7.71E-43)
            if (r4 >= r6) goto L58
            k1.d r4 = k1.d.MODERATE     // Catch: java.lang.Throwable -> L3f
            goto L47
        L58:
            r6 = 2000(0x7d0, float:2.803E-42)
            if (r4 >= r6) goto L5f
            k1.d r4 = k1.d.GOOD     // Catch: java.lang.Throwable -> L3f
            goto L47
        L5f:
            if (r4 <= r6) goto L64
            k1.d r4 = k1.d.EXCELLENT     // Catch: java.lang.Throwable -> L3f
            goto L47
        L64:
            if (r7 != r5) goto L6b
            r4 = 0
            r3.b = r4     // Catch: java.lang.Throwable -> L3f
            r3.c = r4     // Catch: java.lang.Throwable -> L3f
        L6b:
            monitor-exit(r3)
            return
        L6d:
            monitor-exit(r3)
            throw r4
        L6f:
            monitor-exit(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: k1.c.b(long, long):void");
    }
}
