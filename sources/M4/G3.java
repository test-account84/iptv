package M4;

import com.google.android.gms.internal.measurement.zzcf;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class g3 implements Runnable {
    public final /* synthetic */ zzcf a;
    public final /* synthetic */ t3 c;

    public g3(t3 t3Var, zzcf zzcfVar) {
        this.c = t3Var;
        this.a = zzcfVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0098 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0086  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            r7 = this;
            M4.t3 r0 = r7.c
            M4.l2 r0 = r0.a
            M4.z4 r0 = r0.M()
            com.google.android.gms.internal.measurement.zzqr.zzc()
            M4.l2 r1 = r0.a
            M4.h r1 = r1.z()
            M4.l1 r2 = M4.m1.w0
            r3 = 0
            boolean r1 = r1.B(r3, r2)
            if (r1 == 0) goto L77
            M4.l2 r1 = r0.a
            M4.P1 r1 = r1.F()
            M4.K2 r1 = r1.q()
            M4.J2 r2 = M4.J2.ANALYTICS_STORAGE
            boolean r1 = r1.j(r2)
            if (r1 != 0) goto L3d
            M4.l2 r0 = r0.a
            M4.z1 r0 = r0.d()
            M4.x1 r0 = r0.x()
            java.lang.String r1 = "Analytics storage consent denied; will not get session id"
        L38:
            r0.a(r1)
        L3b:
            r0 = r3
            goto L84
        L3d:
            M4.l2 r1 = r0.a
            M4.P1 r1 = r1.F()
            M4.l2 r2 = r0.a
            C4.e r2 = r2.a()
            long r4 = r2.a()
            boolean r1 = r1.v(r4)
            if (r1 != 0) goto L3b
            M4.l2 r1 = r0.a
            M4.P1 r1 = r1.F()
            M4.L1 r1 = r1.p
            long r1 = r1.a()
            r4 = 0
            int r6 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r6 != 0) goto L66
            goto L3b
        L66:
            M4.l2 r0 = r0.a
            M4.P1 r0 = r0.F()
            M4.L1 r0 = r0.p
            long r0 = r0.a()
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            goto L84
        L77:
            M4.l2 r0 = r0.a
            M4.z1 r0 = r0.d()
            M4.x1 r0 = r0.x()
            java.lang.String r1 = "getSessionId has been disabled."
            goto L38
        L84:
            if (r0 == 0) goto L98
            M4.t3 r1 = r7.c
            M4.l2 r1 = r1.a
            M4.a5 r1 = r1.N()
            com.google.android.gms.internal.measurement.zzcf r2 = r7.a
            long r3 = r0.longValue()
            r1.J(r2, r3)
            return
        L98:
            com.google.android.gms.internal.measurement.zzcf r0 = r7.a     // Catch: android.os.RemoteException -> L9e
            r0.zze(r3)     // Catch: android.os.RemoteException -> L9e
            return
        L9e:
            r0 = move-exception
            M4.t3 r1 = r7.c
            M4.l2 r1 = r1.a
            M4.z1 r1 = r1.d()
            M4.x1 r1 = r1.r()
            java.lang.String r2 = "getSessionId failed with exception"
            r1.b(r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: M4.g3.run():void");
    }
}
