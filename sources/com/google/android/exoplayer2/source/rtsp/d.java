package com.google.android.exoplayer2.source.rtsp;

import K3.o;
import K3.p;
import K3.s;
import K3.t;
import K3.u;
import K3.v;
import K3.w;
import K3.x;
import K3.z;
import O2.l1;
import android.net.Uri;
import android.os.Handler;
import android.util.SparseArray;
import com.google.android.exoplayer2.source.rtsp.RtspMediaSource;
import com.google.android.exoplayer2.source.rtsp.e;
import com.google.android.exoplayer2.source.rtsp.f;
import com.google.android.exoplayer2.source.rtsp.g;
import com.google.android.exoplayer2.source.rtsp.h;
import d4.B;
import d4.k0;
import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.net.SocketFactory;
import r5.q;
import s5.A;
import s5.D;
import s5.y;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class d implements Closeable {
    public final f a;
    public final e c;
    public final String d;
    public final SocketFactory e;
    public final boolean f;
    public Uri j;
    public h.a l;
    public String m;
    public b n;
    public com.google.android.exoplayer2.source.rtsp.c o;
    public boolean q;
    public boolean r;
    public boolean s;
    public final ArrayDeque g = new ArrayDeque();
    public final SparseArray h = new SparseArray();
    public final d i = new d(this, null);
    public g k = new g(new c());
    public long t = -9223372036854775807L;
    public int p = -1;

    public final class b implements Runnable, Closeable {
        public final Handler a = k0.x();
        public final long c;
        public boolean d;

        public b(long j) {
            this.c = j;
        }

        public void a() {
            if (this.d) {
                return;
            }
            this.d = true;
            this.a.postDelayed(this, this.c);
        }

        public void close() {
            this.d = false;
            this.a.removeCallbacks(this);
        }

        public void run() {
            d.e(d.this).e(d.h(d.this), d.w(d.this));
            this.a.postDelayed(this, this.c);
        }
    }

    public final class c implements g.d {
        public final Handler a = k0.x();

        public c() {
        }

        public static /* synthetic */ void d(c cVar, List list) {
            cVar.h(list);
        }

        public /* synthetic */ void a(Exception exc) {
            p.a(this, exc);
        }

        public /* synthetic */ void b(List list, Exception exc) {
            p.b(this, list, exc);
        }

        public void c(List list) {
            this.a.post(new K3.j(this, list));
        }

        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public final void h(List list) {
            d.g0(d.this, list);
            if (h.e(list)) {
                g(list);
            } else {
                f(list);
            }
        }

        public final void f(List list) {
            d.e(d.this).d(Integer.parseInt((String) d4.a.e(h.k(list).c.d("CSeq"))));
        }

        public final void g(List list) {
            y z;
            v l = h.l(list);
            int parseInt = Integer.parseInt((String) d4.a.e(l.b.d("CSeq")));
            u uVar = (u) d.f0(d.this).get(parseInt);
            if (uVar == null) {
                return;
            }
            d.f0(d.this).remove(parseInt);
            int i = uVar.b;
            try {
                try {
                    int i2 = l.a;
                    if (i2 == 200) {
                        switch (i) {
                            case 1:
                            case 3:
                            case 7:
                            case 8:
                            case 9:
                            case 11:
                            case 12:
                                return;
                            case 2:
                                i(new K3.k(l.b, i2, z.b(l.c)));
                                return;
                            case 4:
                                j(new s(i2, h.j(l.b.d("Public"))));
                                return;
                            case 5:
                                k();
                                return;
                            case 6:
                                String d = l.b.d("Range");
                                w d2 = d == null ? w.c : w.d(d);
                                try {
                                    String d3 = l.b.d("RTP-Info");
                                    z = d3 == null ? y.z() : x.a(d3, d.h(d.this));
                                } catch (l1 unused) {
                                    z = y.z();
                                }
                                l(new t(l.a, d2, z));
                                return;
                            case 10:
                                String d4 = l.b.d("Session");
                                String d5 = l.b.d("Transport");
                                if (d4 == null || d5 == null) {
                                    throw l1.c("Missing mandatory session or transport header", null);
                                }
                                m(new i(l.a, h.m(d4), d5));
                                return;
                            default:
                                throw new IllegalStateException();
                        }
                    }
                    if (i2 == 401) {
                        if (d.c0(d.this) == null || d.j(d.this)) {
                            d.e0(d.this, new RtspMediaSource.c(h.t(i) + " " + l.a));
                            return;
                        }
                        y e = l.b.e("WWW-Authenticate");
                        if (e.isEmpty()) {
                            throw l1.c("Missing WWW-Authenticate header in a 401 response.", null);
                        }
                        for (int i3 = 0; i3 < e.size(); i3++) {
                            d.b0(d.this, h.o((String) e.get(i3)));
                            if (d.Y(d.this).a == 2) {
                                break;
                            }
                        }
                        d.e(d.this).b();
                        d.k(d.this, true);
                        return;
                    }
                    if (i2 == 461) {
                        String str = h.t(i) + " " + l.a;
                        d.e0(d.this, (i != 10 || ((String) d4.a.e(uVar.c.d("Transport"))).contains("TCP")) ? new RtspMediaSource.c(str) : new RtspMediaSource.d(str));
                        return;
                    }
                    if (i2 != 301 && i2 != 302) {
                        d.e0(d.this, new RtspMediaSource.c(h.t(i) + " " + l.a));
                        return;
                    }
                    if (d.a(d.this) != -1) {
                        d.d(d.this, 0);
                    }
                    String d6 = l.b.d("Location");
                    if (d6 == null) {
                        d.g(d.this).b("Redirection without new location.", null);
                        return;
                    }
                    Uri parse = Uri.parse(d6);
                    d.i(d.this, h.p(parse));
                    d.d0(d.this, h.n(parse));
                    d.e(d.this).c(d.h(d.this), d.w(d.this));
                } catch (l1 e2) {
                    e = e2;
                    d.e0(d.this, new RtspMediaSource.c((Throwable) e));
                }
            } catch (IllegalArgumentException e3) {
                e = e3;
                d.e0(d.this, new RtspMediaSource.c((Throwable) e));
            }
        }

        public final void i(K3.k kVar) {
            w wVar = w.c;
            String str = (String) kVar.c.a.get("range");
            if (str != null) {
                try {
                    wVar = w.d(str);
                } catch (l1 e) {
                    d.g(d.this).b("SDP format error.", e);
                    return;
                }
            }
            y o = d.o(kVar, d.h(d.this));
            if (o.isEmpty()) {
                d.g(d.this).b("No playable track.", null);
            } else {
                d.g(d.this).f(wVar, o);
                d.p(d.this, true);
            }
        }

        public final void j(s sVar) {
            if (d.l(d.this) != null) {
                return;
            }
            if (d.n(sVar.b)) {
                d.e(d.this).c(d.h(d.this), d.w(d.this));
            } else {
                d.g(d.this).b("DESCRIBE not supported.", null);
            }
        }

        public final void k() {
            d4.a.g(d.a(d.this) == 2);
            d.d(d.this, 1);
            d.t(d.this, false);
            if (d.r(d.this) != -9223372036854775807L) {
                d dVar = d.this;
                dVar.u0(k0.x1(d.r(dVar)));
            }
        }

        public final void l(t tVar) {
            boolean z = true;
            if (d.a(d.this) != 1 && d.a(d.this) != 2) {
                z = false;
            }
            d4.a.g(z);
            d.d(d.this, 2);
            if (d.l(d.this) == null) {
                d dVar = d.this;
                d.m(dVar, dVar.new b(30000L));
                d.l(d.this).a();
            }
            d.s(d.this, -9223372036854775807L);
            d.v(d.this).a(k0.P0(tVar.b.a), tVar.c);
        }

        public final void m(i iVar) {
            d4.a.g(d.a(d.this) != -1);
            d.d(d.this, 1);
            d.T(d.this, iVar.b.a);
            d.q(d.this);
        }
    }

    public final class d {
        public int a;
        public u b;

        public d() {
        }

        public final u a(int i, String str, Map map, Uri uri) {
            String V = d.V(d.this);
            int i2 = this.a;
            this.a = i2 + 1;
            e.b bVar = new e.b(V, str, i2);
            if (d.Y(d.this) != null) {
                d4.a.i(d.c0(d.this));
                try {
                    bVar.b("Authorization", d.Y(d.this).a(d.c0(d.this), uri, i));
                } catch (l1 e) {
                    d.e0(d.this, new RtspMediaSource.c((Throwable) e));
                }
            }
            bVar.d(map);
            return new u(uri, i, bVar.e(), "");
        }

        public void b() {
            d4.a.i(this.b);
            s5.z b = this.b.c.b();
            HashMap hashMap = new HashMap();
            for (String str : b.keySet()) {
                if (!str.equals("CSeq") && !str.equals("User-Agent") && !str.equals("Session") && !str.equals("Authorization")) {
                    hashMap.put(str, (String) D.d(b.get((Object) str)));
                }
            }
            h(a(this.b.b, d.w(d.this), hashMap, this.b.a));
        }

        public void c(Uri uri, String str) {
            h(a(2, str, A.k(), uri));
        }

        public void d(int i) {
            i(new v(405, new e.b(d.V(d.this), d.w(d.this), i).e()));
            this.a = Math.max(this.a, i + 1);
        }

        public void e(Uri uri, String str) {
            h(a(4, str, A.k(), uri));
        }

        public void f(Uri uri, String str) {
            d4.a.g(d.a(d.this) == 2);
            h(a(5, str, A.k(), uri));
            d.t(d.this, true);
        }

        public void g(Uri uri, long j, String str) {
            boolean z = true;
            if (d.a(d.this) != 1 && d.a(d.this) != 2) {
                z = false;
            }
            d4.a.g(z);
            h(a(6, str, A.m("Range", w.b(j)), uri));
        }

        public final void h(u uVar) {
            int parseInt = Integer.parseInt((String) d4.a.e(uVar.c.d("CSeq")));
            d4.a.g(d.f0(d.this).get(parseInt) == null);
            d.f0(d.this).append(parseInt, uVar);
            y q = h.q(uVar);
            d.g0(d.this, q);
            d.c(d.this).h(q);
            this.b = uVar;
        }

        public final void i(v vVar) {
            y r = h.r(vVar);
            d.g0(d.this, r);
            d.c(d.this).h(r);
        }

        public void j(Uri uri, String str, String str2) {
            d.d(d.this, 0);
            h(a(10, str2, A.m("Transport", str), uri));
        }

        public void k(Uri uri, String str) {
            if (d.a(d.this) == -1 || d.a(d.this) == 0) {
                return;
            }
            d.d(d.this, 0);
            h(a(12, str, A.k(), uri));
        }

        public /* synthetic */ d(d dVar, a aVar) {
            this();
        }
    }

    public interface e {
        void a(long j, y yVar);

        void c(RtspMediaSource.c cVar);

        void d();
    }

    public interface f {
        void b(String str, Throwable th);

        void f(w wVar, y yVar);
    }

    public d(f fVar, e eVar, String str, Uri uri, SocketFactory socketFactory, boolean z) {
        this.a = fVar;
        this.c = eVar;
        this.d = str;
        this.e = socketFactory;
        this.f = z;
        this.j = h.p(uri);
        this.l = h.n(uri);
    }

    public static /* synthetic */ String T(d dVar, String str) {
        dVar.m = str;
        return str;
    }

    public static /* synthetic */ String V(d dVar) {
        return dVar.d;
    }

    public static /* synthetic */ com.google.android.exoplayer2.source.rtsp.c Y(d dVar) {
        return dVar.o;
    }

    public static /* synthetic */ int a(d dVar) {
        return dVar.p;
    }

    public static /* synthetic */ com.google.android.exoplayer2.source.rtsp.c b0(d dVar, com.google.android.exoplayer2.source.rtsp.c cVar) {
        dVar.o = cVar;
        return cVar;
    }

    public static /* synthetic */ g c(d dVar) {
        return dVar.k;
    }

    public static /* synthetic */ h.a c0(d dVar) {
        return dVar.l;
    }

    public static /* synthetic */ int d(d dVar, int i) {
        dVar.p = i;
        return i;
    }

    public static /* synthetic */ h.a d0(d dVar, h.a aVar) {
        dVar.l = aVar;
        return aVar;
    }

    public static /* synthetic */ d e(d dVar) {
        return dVar.i;
    }

    public static /* synthetic */ void e0(d dVar, Throwable th) {
        dVar.j0(th);
    }

    public static /* synthetic */ SparseArray f0(d dVar) {
        return dVar.h;
    }

    public static /* synthetic */ f g(d dVar) {
        return dVar.a;
    }

    public static /* synthetic */ void g0(d dVar, List list) {
        dVar.m0(list);
    }

    public static /* synthetic */ Uri h(d dVar) {
        return dVar.j;
    }

    public static y h0(K3.k kVar, Uri uri) {
        y.a aVar = new y.a();
        for (int i = 0; i < kVar.c.b.size(); i++) {
            K3.a aVar2 = (K3.a) kVar.c.b.get(i);
            if (K3.h.c(aVar2)) {
                aVar.a(new o(kVar.a, aVar2, uri));
            }
        }
        return aVar.k();
    }

    public static /* synthetic */ Uri i(d dVar, Uri uri) {
        dVar.j = uri;
        return uri;
    }

    public static /* synthetic */ boolean j(d dVar) {
        return dVar.r;
    }

    public static /* synthetic */ boolean k(d dVar, boolean z) {
        dVar.r = z;
        return z;
    }

    public static /* synthetic */ b l(d dVar) {
        return dVar.n;
    }

    public static /* synthetic */ b m(d dVar, b bVar) {
        dVar.n = bVar;
        return bVar;
    }

    public static /* synthetic */ boolean n(List list) {
        return q0(list);
    }

    public static /* synthetic */ y o(K3.k kVar, Uri uri) {
        return h0(kVar, uri);
    }

    public static /* synthetic */ boolean p(d dVar, boolean z) {
        dVar.q = z;
        return z;
    }

    public static /* synthetic */ void q(d dVar) {
        dVar.i0();
    }

    public static boolean q0(List list) {
        return list.isEmpty() || list.contains(2);
    }

    public static /* synthetic */ long r(d dVar) {
        return dVar.t;
    }

    public static /* synthetic */ long s(d dVar, long j) {
        dVar.t = j;
        return j;
    }

    public static /* synthetic */ boolean t(d dVar, boolean z) {
        dVar.s = z;
        return z;
    }

    public static /* synthetic */ e v(d dVar) {
        return dVar.c;
    }

    public static /* synthetic */ String w(d dVar) {
        return dVar.m;
    }

    public void close() {
        b bVar = this.n;
        if (bVar != null) {
            bVar.close();
            this.n = null;
            this.i.k(this.j, (String) d4.a.e(this.m));
        }
        this.k.close();
    }

    public final void i0() {
        f.d dVar = (f.d) this.g.pollFirst();
        if (dVar == null) {
            this.c.d();
        } else {
            this.i.j(dVar.c(), dVar.d(), this.m);
        }
    }

    public final void j0(Throwable th) {
        RtspMediaSource.c cVar = th instanceof RtspMediaSource.c ? (RtspMediaSource.c) th : new RtspMediaSource.c(th);
        if (this.q) {
            this.c.c(cVar);
        } else {
            this.a.b(q.d(th.getMessage()), th);
        }
    }

    public final Socket k0(Uri uri) {
        d4.a.a(uri.getHost() != null);
        return this.e.createSocket((String) d4.a.e(uri.getHost()), uri.getPort() > 0 ? uri.getPort() : 554);
    }

    public int l0() {
        return this.p;
    }

    public final void m0(List list) {
        if (this.f) {
            B.b("RtspClient", r5.g.g("\n").d(list));
        }
    }

    public void n0(int i, g.b bVar) {
        this.k.g(i, bVar);
    }

    public void o0() {
        try {
            close();
            g gVar = new g(new c());
            this.k = gVar;
            gVar.e(k0(this.j));
            this.m = null;
            this.r = false;
            this.o = null;
        } catch (IOException e2) {
            this.c.c(new RtspMediaSource.c((Throwable) e2));
        }
    }

    public void p0(long j) {
        if (this.p == 2 && !this.s) {
            this.i.f(this.j, (String) d4.a.e(this.m));
        }
        this.t = j;
    }

    public void r0(List list) {
        this.g.addAll(list);
        i0();
    }

    public void s0() {
        this.p = 1;
    }

    public void t0() {
        try {
            this.k.e(k0(this.j));
            this.i.e(this.j, this.m);
        } catch (IOException e2) {
            k0.o(this.k);
            throw e2;
        }
    }

    public void u0(long j) {
        this.i.g(this.j, j, (String) d4.a.e(this.m));
    }
}
