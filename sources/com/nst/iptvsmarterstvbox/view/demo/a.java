package com.nst.iptvsmarterstvbox.view.demo;

import B3.g0;
import B3.i0;
import O2.G1;
import O2.H0;
import O2.V1;
import O2.z0;
import V2.V;
import V2.o;
import V2.w;
import Z3.u;
import Z3.z;
import a7.j;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.AsyncTask;
import android.widget.Toast;
import androidx.fragment.app.m;
import b4.o;
import com.nst.iptvsmarterstvbox.view.demo.b;
import d4.B;
import d4.k0;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import z3.n;
import z3.p;
import z3.s;
import z3.u;
import z3.w;
import z3.x;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class a {
    public final Context a;
    public final o.a b;
    public final CopyOnWriteArraySet c = new CopyOnWriteArraySet();
    public final HashMap d = new HashMap();
    public final p e;
    public d f;

    public class b implements s.d {
        public b() {
        }

        public void a(s sVar, z3.c cVar, Exception exc) {
            a.a(a.this).put(cVar.a.c, cVar);
            Iterator it = a.b(a.this).iterator();
            while (it.hasNext()) {
                ((c) it.next()).Y0();
            }
        }

        public /* synthetic */ void b(s sVar, A3.c cVar, int i) {
            u.e(this, sVar, cVar, i);
        }

        public /* synthetic */ void c(s sVar) {
            u.c(this, sVar);
        }

        public void d(s sVar, z3.c cVar) {
            a.a(a.this).remove(cVar.a.c);
            Iterator it = a.b(a.this).iterator();
            while (it.hasNext()) {
                ((c) it.next()).Y0();
            }
        }

        public /* synthetic */ void e(s sVar, boolean z) {
            u.b(this, sVar, z);
        }

        public /* synthetic */ void f(s sVar, boolean z) {
            u.f(this, sVar, z);
        }

        public /* synthetic */ void g(s sVar) {
            u.d(this, sVar);
        }

        public /* synthetic */ b(a aVar, a aVar2) {
            this();
        }
    }

    public interface c {
        void Y0();
    }

    public final class d implements n.c, b.b, DialogInterface.OnDismissListener {
        public final m a;
        public final n c;
        public final H0 d;
        public com.nst.iptvsmarterstvbox.view.demo.b e;
        public e f;
        public byte[] g;

        public d(m mVar, n nVar, H0 h0) {
            this.a = mVar;
            this.c = nVar;
            this.d = h0;
            nVar.H(this);
        }

        public static /* synthetic */ void d(d dVar, o.a aVar) {
            dVar.k(aVar);
        }

        public static /* synthetic */ void e(d dVar, n nVar, byte[] bArr) {
            dVar.j(nVar, bArr);
        }

        public void a(n nVar, IOException iOException) {
            boolean z = iOException instanceof n.f;
            int i = z ? j.Z0 : j.c1;
            String str = z ? "Downloading live content unsupported" : "Failed to start download";
            Toast.makeText(a.c(a.this), i, 1).show();
            B.e("DownloadTracker", str, iOException);
        }

        public void b(z zVar) {
            for (int i = 0; i < this.c.u(); i++) {
                this.c.m(i);
                this.c.j(i, zVar);
            }
            w f = f();
            if (f.e.isEmpty()) {
                return;
            }
            n(f);
        }

        public void c(n nVar) {
            z0 g = g(nVar);
            if (g == null) {
                i(nVar);
                return;
            }
            if (k0.a < 18) {
                Toast.makeText(a.c(a.this), j.J1, 1).show();
                B.d("DownloadTracker", "Downloading DRM protected content is not supported on API versions below 18");
            } else if (!h(g.p)) {
                Toast.makeText(a.c(a.this), j.d1, 1).show();
                B.d("DownloadTracker", "Downloading content where DRM scheme data is not located in the manifest is not supported");
            } else {
                e eVar = new e(g, this.d.c.d, a.d(a.this), this, nVar);
                this.f = eVar;
                eVar.execute(new Void[0]);
            }
        }

        public final w f() {
            return this.c.s(k0.s0((String) r5.m.k(this.d.f.a.toString()))).a(this.g);
        }

        public final z0 g(n nVar) {
            for (int i = 0; i < nVar.u(); i++) {
                u.a t = nVar.t(i);
                for (int i2 = 0; i2 < t.d(); i2++) {
                    i0 f = t.f(i2);
                    for (int i3 = 0; i3 < f.a; i3++) {
                        g0 b = f.b(i3);
                        for (int i4 = 0; i4 < b.a; i4++) {
                            z0 c = b.c(i4);
                            if (c.p != null) {
                                return c;
                            }
                        }
                    }
                }
            }
            return null;
        }

        public final boolean h(V2.m mVar) {
            for (int i = 0; i < mVar.e; i++) {
                if (mVar.f(i).d()) {
                    return true;
                }
            }
            return false;
        }

        public final void i(n nVar) {
            if (nVar.u() == 0) {
                B.b("DownloadTracker", "No periods found. Downloading entire stream.");
                m();
                this.c.I();
                return;
            }
            V1 w = this.c.w(0);
            if (com.nst.iptvsmarterstvbox.view.demo.b.c0(w)) {
                com.nst.iptvsmarterstvbox.view.demo.b S = com.nst.iptvsmarterstvbox.view.demo.b.S(S2.a.b, w, n.q(a.c(a.this)), false, true, this, this);
                this.e = S;
                S.show(this.a, (String) null);
            } else {
                B.b("DownloadTracker", "No dialog content. Downloading entire stream.");
                m();
                this.c.I();
            }
        }

        public final void j(n nVar, byte[] bArr) {
            this.g = bArr;
            i(nVar);
        }

        public final void k(o.a aVar) {
            Toast.makeText(a.c(a.this), j.d1, 1).show();
            B.e("DownloadTracker", "Failed to fetch offline DRM license", aVar);
        }

        public void l() {
            this.c.I();
            com.nst.iptvsmarterstvbox.view.demo.b bVar = this.e;
            if (bVar != null) {
                bVar.dismiss();
            }
            e eVar = this.f;
            if (eVar != null) {
                eVar.cancel(false);
            }
        }

        public final void m() {
            n(f());
        }

        public final void n(w wVar) {
            x.x(a.c(a.this), r7.a.class, wVar, false);
        }

        public void onDismiss(DialogInterface dialogInterface) {
            this.e = null;
            this.c.I();
        }
    }

    public static final class e extends AsyncTask {
        public final z0 a;
        public final H0.f b;
        public final o.a c;
        public final d d;
        public final n e;
        public byte[] f;
        public o.a g;

        public e(z0 z0Var, H0.f fVar, o.a aVar, d dVar, n nVar) {
            this.a = z0Var;
            this.b = fVar;
            this.c = aVar;
            this.d = dVar;
            this.e = nVar;
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(Void... voidArr) {
            String uri = this.b.d.toString();
            H0.f fVar = this.b;
            V m = V.m(uri, fVar.i, this.c, fVar.f, new w.a());
            try {
                try {
                    this.f = m.h(this.a);
                } catch (o.a e) {
                    this.g = e;
                }
                return null;
            } finally {
                m.n();
            }
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Void r3) {
            o.a aVar = this.g;
            if (aVar != null) {
                d.d(this.d, aVar);
            } else {
                d.e(this.d, this.e, (byte[]) r5.m.k(this.f));
            }
        }
    }

    public a(Context context, o.a aVar, s sVar) {
        this.a = context.getApplicationContext();
        this.b = aVar;
        this.e = sVar.f();
        sVar.d(new b(this, null));
        h();
    }

    public static /* synthetic */ HashMap a(a aVar) {
        return aVar.d;
    }

    public static /* synthetic */ CopyOnWriteArraySet b(a aVar) {
        return aVar.c;
    }

    public static /* synthetic */ Context c(a aVar) {
        return aVar.a;
    }

    public static /* synthetic */ o.a d(a aVar) {
        return aVar.b;
    }

    public void e(c cVar) {
        this.c.add((c) r5.m.k(cVar));
    }

    public z3.w f(Uri uri) {
        z3.c cVar = (z3.c) this.d.get(uri);
        if (cVar == null || cVar.b == 4) {
            return null;
        }
        return cVar.a;
    }

    public boolean g(H0 h0) {
        z3.c cVar = (z3.c) this.d.get(((H0.h) r5.m.k(h0.c)).a);
        return (cVar == null || cVar.b == 4) ? false : true;
    }

    public final void h() {
        try {
            z3.e d2 = this.e.d(new int[0]);
            while (d2.a0()) {
                try {
                    z3.c J = d2.J();
                    this.d.put(J.a.c, J);
                } finally {
                }
            }
            d2.close();
        } catch (IOException e2) {
            B.k("DownloadTracker", "Failed to query downloads", e2);
        }
    }

    public void i(c cVar) {
        this.c.remove(cVar);
    }

    public void j(m mVar, H0 h0, G1 g1) {
        z3.c cVar = (z3.c) this.d.get(((H0.h) r5.m.k(h0.c)).a);
        if (cVar != null && cVar.b != 4) {
            x.y(this.a, r7.a.class, cVar.a.a, false);
            return;
        }
        d dVar = this.f;
        if (dVar != null) {
            dVar.l();
        }
        this.f = new d(mVar, n.p(this.a, h0, g1, this.b), h0);
    }
}
