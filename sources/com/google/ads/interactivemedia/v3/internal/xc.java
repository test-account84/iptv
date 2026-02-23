package com.google.ads.interactivemedia.v3.internal;

import android.os.Looper;
import android.os.SystemClock;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class xc implements xd {
    public static final wv a = n(false, -9223372036854775807L);
    public static final wv b = new wv(2, -9223372036854775807L, null);
    public static final wv c = new wv(3, -9223372036854775807L, null);
    private final ExecutorService d;
    private wx e;
    private IOException f;

    public xc(String str) {
        this.d = cq.R("ExoPlayer:Loader:".concat(str));
    }

    public static /* bridge */ /* synthetic */ wx c(xc xcVar) {
        return xcVar.e;
    }

    public static /* bridge */ /* synthetic */ ExecutorService d(xc xcVar) {
        return xcVar.d;
    }

    public static /* bridge */ /* synthetic */ void e(xc xcVar, wx wxVar) {
        xcVar.e = wxVar;
    }

    public static /* bridge */ /* synthetic */ void f(xc xcVar, IOException iOException) {
        xcVar.f = iOException;
    }

    public static wv n(boolean z, long j) {
        return new wv(z ? 1 : 0, j, null);
    }

    public final void a() throws IOException {
        i(Integer.MIN_VALUE);
    }

    public final long b(wy wyVar, ww wwVar, int i) {
        Looper myLooper = Looper.myLooper();
        af.t(myLooper);
        this.f = null;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        new wx(this, myLooper, wyVar, wwVar, i, elapsedRealtime).c(0L);
        return elapsedRealtime;
    }

    public final void g() {
        wx wxVar = this.e;
        af.t(wxVar);
        wxVar.a(false);
    }

    public final void h() {
        this.f = null;
    }

    public final void i(int i) throws IOException {
        IOException iOException = this.f;
        if (iOException != null) {
            throw iOException;
        }
        wx wxVar = this.e;
        if (wxVar != null) {
            if (i == Integer.MIN_VALUE) {
                i = wxVar.a;
            }
            wxVar.b(i);
        }
    }

    public final void j() {
        k(null);
    }

    public final void k(wz wzVar) {
        wx wxVar = this.e;
        if (wxVar != null) {
            wxVar.a(true);
        }
        if (wzVar != null) {
            this.d.execute(new xa(wzVar));
        }
        this.d.shutdown();
    }

    public final boolean l() {
        return this.f != null;
    }

    public final boolean m() {
        return this.e != null;
    }
}
