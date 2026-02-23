package com.google.android.gms.common.api.internal;

import android.os.SystemClock;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class x0 implements OnCompleteListener {
    public final g a;
    public final int b;
    public final b c;
    public final long d;
    public final long e;

    public x0(g gVar, int i, b bVar, long j, long j2, String str, String str2) {
        this.a = gVar;
        this.b = i;
        this.c = bVar;
        this.d = j;
        this.e = j2;
    }

    public static x0 a(g gVar, int i, b bVar) {
        boolean z;
        if (!gVar.d()) {
            return null;
        }
        com.google.android.gms.common.internal.t a = com.google.android.gms.common.internal.s.b().a();
        if (a == null) {
            z = true;
        } else {
            if (!a.J()) {
                return null;
            }
            z = a.K();
            k0 s = gVar.s(bVar);
            if (s != null) {
                if (!(s.s() instanceof com.google.android.gms.common.internal.c)) {
                    return null;
                }
                com.google.android.gms.common.internal.c cVar = (com.google.android.gms.common.internal.c) s.s();
                if (cVar.hasConnectionInfo() && !cVar.isConnecting()) {
                    com.google.android.gms.common.internal.f b = b(s, cVar, i);
                    if (b == null) {
                        return null;
                    }
                    s.E();
                    z = b.L();
                }
            }
        }
        return new x0(gVar, i, bVar, z ? System.currentTimeMillis() : 0L, z ? SystemClock.elapsedRealtime() : 0L, null, null);
    }

    public static com.google.android.gms.common.internal.f b(k0 k0Var, com.google.android.gms.common.internal.c cVar, int i) {
        int[] I;
        int[] J;
        com.google.android.gms.common.internal.f telemetryConfiguration = cVar.getTelemetryConfiguration();
        if (telemetryConfiguration == null || !telemetryConfiguration.K() || ((I = telemetryConfiguration.I()) != null ? !C4.b.a(I, i) : !((J = telemetryConfiguration.J()) == null || !C4.b.a(J, i))) || k0Var.q() >= telemetryConfiguration.H()) {
            return null;
        }
        return telemetryConfiguration;
    }

    public final void onComplete(Task task) {
        k0 s;
        int i;
        int i2;
        int i3;
        int i4;
        int H;
        long j;
        long j2;
        int i5;
        if (this.a.d()) {
            com.google.android.gms.common.internal.t a = com.google.android.gms.common.internal.s.b().a();
            if ((a == null || a.J()) && (s = this.a.s(this.c)) != null && (s.s() instanceof com.google.android.gms.common.internal.c)) {
                com.google.android.gms.common.internal.c cVar = (com.google.android.gms.common.internal.c) s.s();
                boolean z = this.d > 0;
                int gCoreServiceId = cVar.getGCoreServiceId();
                if (a != null) {
                    z &= a.K();
                    int H2 = a.H();
                    int I = a.I();
                    i = a.L();
                    if (cVar.hasConnectionInfo() && !cVar.isConnecting()) {
                        com.google.android.gms.common.internal.f b = b(s, cVar, this.b);
                        if (b == null) {
                            return;
                        }
                        boolean z2 = b.L() && this.d > 0;
                        I = b.H();
                        z = z2;
                    }
                    i2 = H2;
                    i3 = I;
                } else {
                    i = 0;
                    i2 = 5000;
                    i3 = 100;
                }
                g gVar = this.a;
                if (task.isSuccessful()) {
                    i4 = 0;
                    H = 0;
                } else {
                    if (task.isCanceled()) {
                        i4 = 100;
                    } else {
                        Exception exception = task.getException();
                        if (exception instanceof com.google.android.gms.common.api.b) {
                            Status status = ((com.google.android.gms.common.api.b) exception).getStatus();
                            int I2 = status.I();
                            w4.b H3 = status.H();
                            if (H3 == null) {
                                i4 = I2;
                            } else {
                                H = H3.H();
                                i4 = I2;
                            }
                        } else {
                            i4 = 101;
                        }
                    }
                    H = -1;
                }
                if (z) {
                    long j3 = this.d;
                    long j4 = this.e;
                    long currentTimeMillis = System.currentTimeMillis();
                    i5 = (int) (SystemClock.elapsedRealtime() - j4);
                    j = j3;
                    j2 = currentTimeMillis;
                } else {
                    j = 0;
                    j2 = 0;
                    i5 = -1;
                }
                gVar.E(new com.google.android.gms.common.internal.p(this.b, i4, H, j, j2, null, null, gCoreServiceId, i5), i, i2, i3);
            }
        }
    }
}
