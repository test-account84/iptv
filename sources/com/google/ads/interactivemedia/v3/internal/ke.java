package com.google.ads.interactivemedia.v3.internal;

import android.os.SystemClock;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class ke implements js {
    final /* synthetic */ kh a;

    public /* synthetic */ ke(kh khVar) {
        this.a = khVar;
    }

    public final void a(long j) {
        cd.e("DefaultAudioSink", "Ignoring impossibly large audio latency: " + j);
    }

    public final void b(long j) {
        kh khVar = this.a;
        if (kh.D(khVar) != null) {
            kn.U(((km) kh.D(khVar)).a).r(j);
        }
    }

    public final void c(long j, long j2, long j3, long j4) {
        cd.e("DefaultAudioSink", "Spurious audio timestamp (frame position mismatch): " + j + ", " + j2 + ", " + j3 + ", " + j4 + ", " + kh.z(this.a) + ", " + kh.A(this.a));
    }

    public final void d(long j, long j2, long j3, long j4) {
        cd.e("DefaultAudioSink", "Spurious audio timestamp (system clock mismatch): " + j + ", " + j2 + ", " + j3 + ", " + j4 + ", " + kh.z(this.a) + ", " + kh.A(this.a));
    }

    public final void e(int i, long j) {
        if (kh.D(this.a) != null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            kh khVar = this.a;
            kn.U(((km) kh.D(khVar)).a).t(i, j, elapsedRealtime - kh.y(khVar));
        }
    }
}
