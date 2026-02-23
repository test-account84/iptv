package com.google.android.exoplayer2.source.rtsp;

import K3.o;
import android.os.Handler;
import b4.G;
import b4.r;
import com.google.android.exoplayer2.source.rtsp.a;
import d3.t;
import d4.k0;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class b implements G.e {
    public final int a;
    public final o c;
    public final a d;
    public final d3.k e;
    public final a.a g;
    public com.google.android.exoplayer2.source.rtsp.a h;
    public K3.d i;
    public d3.c j;
    public volatile boolean k;
    public volatile long m;
    public final Handler f = k0.x();
    public volatile long l = -9223372036854775807L;

    public interface a {
        void a(String str, com.google.android.exoplayer2.source.rtsp.a aVar);
    }

    public b(int i, o oVar, a aVar, d3.k kVar, a.a aVar2) {
        this.a = i;
        this.c = oVar;
        this.d = aVar;
        this.e = kVar;
        this.g = aVar2;
    }

    public static /* synthetic */ void b(b bVar, String str, com.google.android.exoplayer2.source.rtsp.a aVar) {
        bVar.d(str, aVar);
    }

    public void a() {
        if (this.k) {
            this.k = false;
        }
        try {
            if (this.h == null) {
                com.google.android.exoplayer2.source.rtsp.a a2 = this.g.a(this.a);
                this.h = a2;
                this.f.post(new K3.c(this, a2.c(), this.h));
                this.j = new d3.c((b4.k) d4.a.e(this.h), 0L, -1L);
                K3.d dVar = new K3.d(this.c.a, this.a);
                this.i = dVar;
                dVar.b(this.e);
            }
            while (!this.k) {
                if (this.l != -9223372036854775807L) {
                    ((K3.d) d4.a.e(this.i)).a(this.m, this.l);
                    this.l = -9223372036854775807L;
                }
                if (((K3.d) d4.a.e(this.i)).d((d3.j) d4.a.e(this.j), new t()) == -1) {
                    break;
                }
            }
            this.k = false;
            if (((com.google.android.exoplayer2.source.rtsp.a) d4.a.e(this.h)).i()) {
                r.a(this.h);
                this.h = null;
            }
        } catch (Throwable th) {
            if (((com.google.android.exoplayer2.source.rtsp.a) d4.a.e(this.h)).i()) {
                r.a(this.h);
                this.h = null;
            }
            throw th;
        }
    }

    public void c() {
        this.k = true;
    }

    public final /* synthetic */ void d(String str, com.google.android.exoplayer2.source.rtsp.a aVar) {
        this.d.a(str, aVar);
    }

    public void e() {
        ((K3.d) d4.a.e(this.i)).f();
    }

    public void f(long j, long j2) {
        this.l = j;
        this.m = j2;
    }

    public void g(int i) {
        if (((K3.d) d4.a.e(this.i)).e()) {
            return;
        }
        this.i.g(i);
    }

    public void h(long j) {
        if (j == -9223372036854775807L || ((K3.d) d4.a.e(this.i)).e()) {
            return;
        }
        this.i.i(j);
    }
}
