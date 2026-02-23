package com.google.android.exoplayer2.source.rtsp;

import B3.C;
import B3.b0;
import B3.s;
import B3.z;
import K3.w;
import O2.H0;
import O2.Q1;
import O2.w0;
import V2.B;
import android.net.Uri;
import b4.F;
import b4.S;
import com.google.android.exoplayer2.source.rtsp.a;
import com.google.android.exoplayer2.source.rtsp.f;
import d4.k0;
import java.io.IOException;
import javax.net.SocketFactory;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class RtspMediaSource extends B3.a {
    public final H0 i;
    public final a.a j;
    public final String k;
    public final Uri l;
    public final SocketFactory m;
    public final boolean n;
    public boolean p;
    public boolean q;
    public long o = -9223372036854775807L;
    public boolean r = true;

    public class a implements f.c {
        public a() {
        }

        public void a() {
            RtspMediaSource.p0(RtspMediaSource.this, false);
            RtspMediaSource.s0(RtspMediaSource.this);
        }

        public void b(w wVar) {
            RtspMediaSource.o0(RtspMediaSource.this, k0.P0(wVar.a()));
            RtspMediaSource.p0(RtspMediaSource.this, !wVar.c());
            RtspMediaSource.q0(RtspMediaSource.this, wVar.c());
            RtspMediaSource.r0(RtspMediaSource.this, false);
            RtspMediaSource.s0(RtspMediaSource.this);
        }
    }

    public class b extends s {
        public b(Q1 q1) {
            super(q1);
        }

        public Q1.b l(int i, Q1.b bVar, boolean z) {
            super.l(i, bVar, z);
            bVar.g = true;
            return bVar;
        }

        public Q1.d t(int i, Q1.d dVar, long j) {
            super.t(i, dVar, j);
            dVar.m = true;
            return dVar;
        }
    }

    public static class c extends IOException {
        public c(String str) {
            super(str);
        }

        public c(String str, Throwable th) {
            super(str, th);
        }

        public c(Throwable th) {
            super(th);
        }
    }

    public static final class d extends c {
        public d(String str) {
            super(str);
        }
    }

    static {
        w0.a("goog.exo.rtsp");
    }

    public RtspMediaSource(H0 h0, a.a aVar, String str, SocketFactory socketFactory, boolean z) {
        this.i = h0;
        this.j = aVar;
        this.k = str;
        this.l = ((H0.h) d4.a.e(h0.c)).a;
        this.m = socketFactory;
        this.n = z;
    }

    public static /* synthetic */ long o0(RtspMediaSource rtspMediaSource, long j) {
        rtspMediaSource.o = j;
        return j;
    }

    public static /* synthetic */ boolean p0(RtspMediaSource rtspMediaSource, boolean z) {
        rtspMediaSource.p = z;
        return z;
    }

    public static /* synthetic */ boolean q0(RtspMediaSource rtspMediaSource, boolean z) {
        rtspMediaSource.q = z;
        return z;
    }

    public static /* synthetic */ boolean r0(RtspMediaSource rtspMediaSource, boolean z) {
        rtspMediaSource.r = z;
        return z;
    }

    public static /* synthetic */ void s0(RtspMediaSource rtspMediaSource) {
        rtspMediaSource.t0();
    }

    private void t0() {
        Q1 b0Var = new b0(this.o, this.p, false, this.q, null, this.i);
        if (this.r) {
            b0Var = new b(b0Var);
        }
        m0(b0Var);
    }

    public z E(C.b bVar, b4.b bVar2, long j) {
        return new f(bVar2, this.j, this.l, new a(), this.k, this.m, this.n);
    }

    public void P() {
    }

    public void Y(z zVar) {
        ((f) zVar).Y();
    }

    public H0 e() {
        return this.i;
    }

    public void l0(S s) {
        t0();
    }

    public void n0() {
    }

    public static final class Factory implements C.a {
        public long a = 8000;
        public String b = "ExoPlayerLib/2.19.0";
        public SocketFactory c = SocketFactory.getDefault();
        public boolean d;
        public boolean e;

        public int[] c() {
            return new int[]{3};
        }

        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public RtspMediaSource b(H0 h0) {
            d4.a.e(h0.c);
            return new RtspMediaSource(h0, this.d ? new k(this.a) : new m(this.a), this.b, this.c, this.e);
        }

        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public Factory d(B b) {
            return this;
        }

        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public Factory a(F f) {
            return this;
        }
    }
}
