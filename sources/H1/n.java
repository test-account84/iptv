package h1;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import h1.b;
import h1.p;
import h1.v;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class n implements Comparable {
    public final v.a a;
    public final int c;
    public final String d;
    public final int e;
    public final Object f;
    public p.a g;
    public Integer h;
    public o i;
    public boolean j;
    public boolean k;
    public boolean l;
    public boolean m;
    public boolean n;
    public r o;
    public b.a p;
    public b q;

    public class a implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ long c;

        public a(String str, long j) {
            this.a = str;
            this.c = j;
        }

        public void run() {
            n.a(n.this).a(this.a, this.c);
            n.a(n.this).b(n.this.toString());
        }
    }

    public interface b {
        void a(n nVar, p pVar);

        void b(n nVar);
    }

    public enum c {
        LOW,
        NORMAL,
        HIGH,
        IMMEDIATE
    }

    public n(int i, String str, p.a aVar) {
        this.a = v.a.c ? new v.a() : null;
        this.f = new Object();
        this.j = true;
        this.k = false;
        this.l = false;
        this.m = false;
        this.n = false;
        this.p = null;
        this.c = i;
        this.d = str;
        this.g = aVar;
        R(new e());
        this.e = o(str);
    }

    public static /* synthetic */ v.a a(n nVar) {
        return nVar.a;
    }

    public static int o(String str) {
        Uri parse;
        String host;
        if (TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null || (host = parse.getHost()) == null) {
            return 0;
        }
        return host.hashCode();
    }

    public String A() {
        return x();
    }

    public abstract c B();

    public r C() {
        return this.o;
    }

    public final int D() {
        return C().c();
    }

    public int E() {
        return this.e;
    }

    public String F() {
        return this.d;
    }

    public boolean G() {
        boolean z;
        synchronized (this.f) {
            z = this.l;
        }
        return z;
    }

    public boolean H() {
        boolean z;
        synchronized (this.f) {
            z = this.k;
        }
        return z;
    }

    public void I() {
        synchronized (this.f) {
            this.l = true;
        }
    }

    public void J() {
        b bVar;
        synchronized (this.f) {
            bVar = this.q;
        }
        if (bVar != null) {
            bVar.b(this);
        }
    }

    public void K(p pVar) {
        b bVar;
        synchronized (this.f) {
            bVar = this.q;
        }
        if (bVar != null) {
            bVar.a(this, pVar);
        }
    }

    public abstract p M(k kVar);

    public void N(int i) {
        o oVar = this.i;
        if (oVar != null) {
            oVar.e(this, i);
        }
    }

    public n O(b.a aVar) {
        this.p = aVar;
        return this;
    }

    public void P(b bVar) {
        synchronized (this.f) {
            this.q = bVar;
        }
    }

    public n Q(o oVar) {
        this.i = oVar;
        return this;
    }

    public n R(r rVar) {
        this.o = rVar;
        return this;
    }

    public final n S(int i) {
        this.h = Integer.valueOf(i);
        return this;
    }

    public final boolean T() {
        return this.j;
    }

    public final boolean U() {
        return this.n;
    }

    public final boolean V() {
        return this.m;
    }

    public void b(String str) {
        if (v.a.c) {
            this.a.a(str, Thread.currentThread().getId());
        }
    }

    public void h() {
        synchronized (this.f) {
            this.k = true;
            this.g = null;
        }
    }

    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public int compareTo(n nVar) {
        c B = B();
        c B2 = nVar.B();
        return B == B2 ? this.h.intValue() - nVar.h.intValue() : B2.ordinal() - B.ordinal();
    }

    public void j(u uVar) {
        p.a aVar;
        synchronized (this.f) {
            aVar = this.g;
        }
        if (aVar != null) {
            aVar.a(uVar);
        }
    }

    public abstract void l(Object obj);

    public final byte[] n(Map map, String str) {
        StringBuilder sb = new StringBuilder();
        try {
            for (Map.Entry entry : map.entrySet()) {
                if (entry.getKey() == null || entry.getValue() == null) {
                    throw new IllegalArgumentException(String.format("Request#getParams() or Request#getPostParams() returned a map containing a null key or value: (%s, %s). All keys and values must be non-null.", new Object[]{entry.getKey(), entry.getValue()}));
                }
                sb.append(URLEncoder.encode((String) entry.getKey(), str));
                sb.append('=');
                sb.append(URLEncoder.encode((String) entry.getValue(), str));
                sb.append('&');
            }
            return sb.toString().getBytes(str);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Encoding not supported: " + str, e);
        }
    }

    public void p(String str) {
        o oVar = this.i;
        if (oVar != null) {
            oVar.c(this);
        }
        if (v.a.c) {
            long id = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new a(str, id));
            } else {
                this.a.a(str, id);
                this.a.b(toString());
            }
        }
    }

    public byte[] q() {
        Map w = w();
        if (w == null || w.size() <= 0) {
            return null;
        }
        return n(w, x());
    }

    public String r() {
        return "application/x-www-form-urlencoded; charset=" + x();
    }

    public b.a s() {
        return this.p;
    }

    public String t() {
        String F = F();
        int v = v();
        if (v == 0 || v == -1) {
            return F;
        }
        return Integer.toString(v) + '-' + F;
    }

    public String toString() {
        String str = "0x" + Integer.toHexString(E());
        StringBuilder sb = new StringBuilder();
        sb.append(H() ? "[X] " : "[ ] ");
        sb.append(F());
        sb.append(" ");
        sb.append(str);
        sb.append(" ");
        sb.append(B());
        sb.append(" ");
        sb.append(this.h);
        return sb.toString();
    }

    public Map u() {
        return Collections.emptyMap();
    }

    public int v() {
        return this.c;
    }

    public Map w() {
        return null;
    }

    public String x() {
        return "UTF-8";
    }

    public byte[] y() {
        Map z = z();
        if (z == null || z.size() <= 0) {
            return null;
        }
        return n(z, A());
    }

    public Map z() {
        return w();
    }

    public u L(u uVar) {
        return uVar;
    }
}
