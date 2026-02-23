package b4;

import android.content.Context;
import android.net.Uri;
import b4.o;
import b4.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class w implements o {
    public final Context a;
    public final List b = new ArrayList();
    public final o c;
    public o d;
    public o e;
    public o f;
    public o g;
    public o h;
    public o i;
    public o j;
    public o k;

    public static final class a implements o.a {
        public final Context a;
        public final o.a b;
        public S c;

        public a(Context context) {
            this(context, new x.b());
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public w a() {
            w wVar = new w(this.a, this.b.a());
            S s = this.c;
            if (s != null) {
                wVar.g(s);
            }
            return wVar;
        }

        public a(Context context, o.a aVar) {
            this.a = context.getApplicationContext();
            this.b = aVar;
        }
    }

    public w(Context context, o oVar) {
        this.a = context.getApplicationContext();
        this.c = (o) d4.a.e(oVar);
    }

    public final void A(o oVar, S s) {
        if (oVar != null) {
            oVar.g(s);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long a(b4.s r3) {
        /*
            r2 = this;
            b4.o r0 = r2.k
            if (r0 != 0) goto L6
            r0 = 1
            goto L7
        L6:
            r0 = 0
        L7:
            d4.a.g(r0)
            android.net.Uri r0 = r3.a
            java.lang.String r0 = r0.getScheme()
            android.net.Uri r1 = r3.a
            boolean r1 = d4.k0.F0(r1)
            if (r1 == 0) goto L2e
            android.net.Uri r0 = r3.a
            java.lang.String r0 = r0.getPath()
            if (r0 == 0) goto L29
            java.lang.String r1 = "/android_asset/"
            boolean r0 = r0.startsWith(r1)
            if (r0 == 0) goto L29
            goto L36
        L29:
            b4.o r0 = r2.w()
            goto L3a
        L2e:
            java.lang.String r1 = "asset"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L3d
        L36:
            b4.o r0 = r2.t()
        L3a:
            r2.k = r0
            goto L8a
        L3d:
            java.lang.String r1 = "content"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L4a
            b4.o r0 = r2.u()
            goto L3a
        L4a:
            java.lang.String r1 = "rtmp"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L57
            b4.o r0 = r2.y()
            goto L3a
        L57:
            java.lang.String r1 = "udp"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L64
            b4.o r0 = r2.z()
            goto L3a
        L64:
            java.lang.String r1 = "data"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L71
            b4.o r0 = r2.v()
            goto L3a
        L71:
            java.lang.String r1 = "rawresource"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L85
            java.lang.String r1 = "android.resource"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L82
            goto L85
        L82:
            b4.o r0 = r2.c
            goto L3a
        L85:
            b4.o r0 = r2.x()
            goto L3a
        L8a:
            b4.o r0 = r2.k
            long r0 = r0.a(r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: b4.w.a(b4.s):long");
    }

    public void close() {
        o oVar = this.k;
        if (oVar != null) {
            try {
                oVar.close();
            } finally {
                this.k = null;
            }
        }
    }

    public Map e() {
        o oVar = this.k;
        return oVar == null ? Collections.emptyMap() : oVar.e();
    }

    public void g(S s) {
        d4.a.e(s);
        this.c.g(s);
        this.b.add(s);
        A(this.d, s);
        A(this.e, s);
        A(this.f, s);
        A(this.g, s);
        A(this.h, s);
        A(this.i, s);
        A(this.j, s);
    }

    public Uri getUri() {
        o oVar = this.k;
        if (oVar == null) {
            return null;
        }
        return oVar.getUri();
    }

    public final void j(o oVar) {
        for (int i = 0; i < this.b.size(); i++) {
            oVar.g((S) this.b.get(i));
        }
    }

    public int read(byte[] bArr, int i, int i2) {
        return ((o) d4.a.e(this.k)).read(bArr, i, i2);
    }

    public final o t() {
        if (this.e == null) {
            c cVar = new c(this.a);
            this.e = cVar;
            j(cVar);
        }
        return this.e;
    }

    public final o u() {
        if (this.f == null) {
            j jVar = new j(this.a);
            this.f = jVar;
            j(jVar);
        }
        return this.f;
    }

    public final o v() {
        if (this.i == null) {
            l lVar = new l();
            this.i = lVar;
            j(lVar);
        }
        return this.i;
    }

    public final o w() {
        if (this.d == null) {
            B b = new B();
            this.d = b;
            j(b);
        }
        return this.d;
    }

    public final o x() {
        if (this.j == null) {
            L l = new L(this.a);
            this.j = l;
            j(l);
        }
        return this.j;
    }

    public final o y() {
        if (this.g == null) {
            try {
                int i = b3.a.g;
                o oVar = (o) b3.a.class.getConstructor((Class[]) null).newInstance((Object[]) null);
                this.g = oVar;
                j(oVar);
            } catch (ClassNotFoundException unused) {
                d4.B.j("DefaultDataSource", "Attempting to play RTMP stream without depending on the RTMP extension");
            } catch (Exception e) {
                throw new RuntimeException("Error instantiating RTMP extension", e);
            }
            if (this.g == null) {
                this.g = this.c;
            }
        }
        return this.g;
    }

    public final o z() {
        if (this.h == null) {
            T t = new T();
            this.h = t;
            j(t);
        }
        return this.h;
    }
}
