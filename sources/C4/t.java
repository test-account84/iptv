package c4;

import android.os.ConditionVariable;
import c4.a;
import d4.B;
import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Random;
import java.util.TreeSet;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class t implements c4.a {
    public static final HashSet l = new HashSet();
    public final File a;
    public final d b;
    public final m c;
    public final f d;
    public final HashMap e;
    public final Random f;
    public final boolean g;
    public long h;
    public long i;
    public boolean j;
    public a.a k;

    public class a extends Thread {
        public final /* synthetic */ ConditionVariable a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, ConditionVariable conditionVariable) {
            super(str);
            this.a = conditionVariable;
        }

        public void run() {
            synchronized (t.this) {
                this.a.open();
                t.k(t.this);
                t.l(t.this).f();
            }
        }
    }

    public t(File file, d dVar) {
        this(file, dVar, null, null, false, true);
    }

    public static /* synthetic */ void k(t tVar) {
        tVar.s();
    }

    public static /* synthetic */ d l(t tVar) {
        return tVar.b;
    }

    public static void o(File file) {
        if (file.mkdirs() || file.isDirectory()) {
            return;
        }
        String str = "Failed to create cache directory: " + file;
        B.d("SimpleCache", str);
        throw new a.a(str);
    }

    public static long p(File file) {
        long nextLong = new SecureRandom().nextLong();
        long abs = nextLong == Long.MIN_VALUE ? 0L : Math.abs(nextLong);
        File file2 = new File(file, Long.toString(abs, 16) + ".uid");
        if (file2.createNewFile()) {
            return abs;
        }
        throw new IOException("Failed to create UID file: " + file2);
    }

    public static long u(File[] fileArr) {
        int length = fileArr.length;
        for (int i = 0; i < length; i++) {
            File file = fileArr[i];
            String name = file.getName();
            if (name.endsWith(".uid")) {
                try {
                    return z(name);
                } catch (NumberFormatException unused) {
                    B.d("SimpleCache", "Malformed UID file: " + file);
                    file.delete();
                }
            }
        }
        return -1L;
    }

    public static synchronized boolean v(File file) {
        boolean add;
        synchronized (t.class) {
            add = l.add(file.getAbsoluteFile());
        }
        return add;
    }

    public static long z(String str) {
        return Long.parseLong(str.substring(0, str.indexOf(46)), 16);
    }

    public final void A(j jVar) {
        l g = this.c.g(jVar.a);
        if (g == null || !g.k(jVar)) {
            return;
        }
        this.i -= jVar.d;
        if (this.d != null) {
            String name = jVar.f.getName();
            try {
                this.d.f(name);
            } catch (IOException unused) {
                B.j("SimpleCache", "Failed to remove file index entry for: " + name);
            }
        }
        this.c.p(g.b);
        x(jVar);
    }

    public final void B() {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.c.h().iterator();
        while (it.hasNext()) {
            Iterator it2 = ((l) it.next()).f().iterator();
            while (it2.hasNext()) {
                j jVar = (j) it2.next();
                if (jVar.f.length() != jVar.d) {
                    arrayList.add(jVar);
                }
            }
        }
        for (int i = 0; i < arrayList.size(); i++) {
            A((j) arrayList.get(i));
        }
    }

    public final u C(String str, u uVar) {
        boolean z;
        if (!this.g) {
            return uVar;
        }
        String name = ((File) d4.a.e(uVar.f)).getName();
        long j = uVar.d;
        long currentTimeMillis = System.currentTimeMillis();
        f fVar = this.d;
        if (fVar != null) {
            try {
                fVar.h(name, j, currentTimeMillis);
            } catch (IOException unused) {
                B.j("SimpleCache", "Failed to update index with new touch timestamp.");
            }
            z = false;
        } else {
            z = true;
        }
        u l2 = this.c.g(str).l(uVar, currentTimeMillis, z);
        y(uVar, l2);
        return l2;
    }

    public synchronized File a(String str, long j, long j2) {
        l g;
        File file;
        try {
            d4.a.g(!this.j);
            n();
            g = this.c.g(str);
            d4.a.e(g);
            d4.a.g(g.h(j, j2));
            if (!this.a.exists()) {
                o(this.a);
                B();
            }
            this.b.e(this, str, j, j2);
            file = new File(this.a, Integer.toString(this.f.nextInt(10)));
            if (!file.exists()) {
                o(file);
            }
        } catch (Throwable th) {
            throw th;
        }
        return u.p(file, g.a, j, System.currentTimeMillis());
    }

    public synchronized o b(String str) {
        d4.a.g(!this.j);
        return this.c.j(str);
    }

    public synchronized long c(String str, long j, long j2) {
        long j3;
        long j4 = j2 == -1 ? Long.MAX_VALUE : j2 + j;
        long j5 = j4 >= 0 ? j4 : Long.MAX_VALUE;
        j3 = 0;
        while (j < j5) {
            long e = e(str, j, j5 - j);
            if (e > 0) {
                j3 += e;
            } else {
                e = -e;
            }
            j += e;
        }
        return j3;
    }

    public synchronized j d(String str, long j, long j2) {
        d4.a.g(!this.j);
        n();
        u r = r(str, j, j2);
        if (r.e) {
            return C(str, r);
        }
        if (this.c.m(str).j(j, r.d)) {
            return r;
        }
        return null;
    }

    public synchronized long e(String str, long j, long j2) {
        l g;
        d4.a.g(!this.j);
        if (j2 == -1) {
            j2 = Long.MAX_VALUE;
        }
        g = this.c.g(str);
        return g != null ? g.c(j, j2) : -j2;
    }

    public synchronized void f(String str, p pVar) {
        d4.a.g(!this.j);
        n();
        this.c.e(str, pVar);
        try {
            this.c.s();
        } catch (IOException e) {
            throw new a.a((Throwable) e);
        }
    }

    public synchronized void g(j jVar) {
        d4.a.g(!this.j);
        l lVar = (l) d4.a.e(this.c.g(jVar.a));
        lVar.m(jVar.c);
        this.c.p(lVar.b);
        notifyAll();
    }

    public synchronized j h(String str, long j, long j2) {
        j d;
        d4.a.g(!this.j);
        n();
        while (true) {
            d = d(str, j, j2);
            if (d == null) {
                wait();
            }
        }
        return d;
    }

    public synchronized void i(File file, long j) {
        d4.a.g(!this.j);
        if (file.exists()) {
            if (j == 0) {
                file.delete();
                return;
            }
            u uVar = (u) d4.a.e(u.l(file, j, this.c));
            l lVar = (l) d4.a.e(this.c.g(uVar.a));
            d4.a.g(lVar.h(uVar.c, uVar.d));
            long a2 = n.a(lVar.d());
            if (a2 != -1) {
                d4.a.g(uVar.c + uVar.d <= a2);
            }
            if (this.d == null) {
                m(uVar);
                this.c.s();
                notifyAll();
                return;
            }
            try {
                this.d.h(file.getName(), uVar.d, uVar.g);
                m(uVar);
                try {
                    this.c.s();
                    notifyAll();
                    return;
                } catch (IOException e) {
                    throw new a.a((Throwable) e);
                }
            } catch (IOException e2) {
                throw new a.a((Throwable) e2);
            }
        }
    }

    public synchronized void j(String str) {
        d4.a.g(!this.j);
        Iterator it = q(str).iterator();
        while (it.hasNext()) {
            A((j) it.next());
        }
    }

    public final void m(u uVar) {
        this.c.m(uVar.a).a(uVar);
        this.i += uVar.d;
        w(uVar);
    }

    public synchronized void n() {
        a.a aVar = this.k;
        if (aVar != null) {
            throw aVar;
        }
    }

    public synchronized NavigableSet q(String str) {
        l g;
        try {
            d4.a.g(!this.j);
            g = this.c.g(str);
        } catch (Throwable th) {
            throw th;
        }
        return (g == null || g.g()) ? new TreeSet() : new TreeSet(g.f());
    }

    public final u r(String str, long j, long j2) {
        u e;
        l g = this.c.g(str);
        if (g == null) {
            return u.n(str, j, j2);
        }
        while (true) {
            e = g.e(j, j2);
            if (!e.e || e.f.length() == e.d) {
                break;
            }
            B();
        }
        return e;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0078 A[Catch: IOException -> 0x0092, TryCatch #2 {IOException -> 0x0092, blocks: (B:12:0x006c, B:14:0x0078, B:23:0x0094), top: B:11:0x006c }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0094 A[Catch: IOException -> 0x0092, TRY_LEAVE, TryCatch #2 {IOException -> 0x0092, blocks: (B:12:0x006c, B:14:0x0078, B:23:0x0094), top: B:11:0x006c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void s() {
        /*
            r7 = this;
            java.io.File r0 = r7.a
            boolean r0 = r0.exists()
            if (r0 != 0) goto L12
            java.io.File r0 = r7.a     // Catch: c4.a.a -> Le
            o(r0)     // Catch: c4.a.a -> Le
            goto L12
        Le:
            r0 = move-exception
            r7.k = r0
            return
        L12:
            java.io.File r0 = r7.a
            java.io.File[] r0 = r0.listFiles()
            java.lang.String r1 = "SimpleCache"
            if (r0 != 0) goto L3a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "Failed to list cache directory files: "
            r0.append(r2)
            java.io.File r2 = r7.a
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            d4.B.d(r1, r0)
            c4.a$a r1 = new c4.a$a
            r1.<init>(r0)
        L37:
            r7.k = r1
            return
        L3a:
            long r2 = u(r0)
            r7.h = r2
            r4 = -1
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 != 0) goto L6c
            java.io.File r2 = r7.a     // Catch: java.io.IOException -> L4f
            long r2 = p(r2)     // Catch: java.io.IOException -> L4f
            r7.h = r2     // Catch: java.io.IOException -> L4f
            goto L6c
        L4f:
            r0 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Failed to create cache UID: "
            r2.append(r3)
            java.io.File r3 = r7.a
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            d4.B.e(r1, r2, r0)
            c4.a$a r1 = new c4.a$a
            r1.<init>(r2, r0)
            goto L37
        L6c:
            c4.m r2 = r7.c     // Catch: java.io.IOException -> L92
            long r3 = r7.h     // Catch: java.io.IOException -> L92
            r2.n(r3)     // Catch: java.io.IOException -> L92
            c4.f r2 = r7.d     // Catch: java.io.IOException -> L92
            r3 = 1
            if (r2 == 0) goto L94
            long r4 = r7.h     // Catch: java.io.IOException -> L92
            r2.e(r4)     // Catch: java.io.IOException -> L92
            c4.f r2 = r7.d     // Catch: java.io.IOException -> L92
            java.util.Map r2 = r2.b()     // Catch: java.io.IOException -> L92
            java.io.File r4 = r7.a     // Catch: java.io.IOException -> L92
            r7.t(r4, r3, r0, r2)     // Catch: java.io.IOException -> L92
            c4.f r0 = r7.d     // Catch: java.io.IOException -> L92
            java.util.Set r2 = r2.keySet()     // Catch: java.io.IOException -> L92
            r0.g(r2)     // Catch: java.io.IOException -> L92
            goto L9a
        L92:
            r0 = move-exception
            goto Lac
        L94:
            java.io.File r2 = r7.a     // Catch: java.io.IOException -> L92
            r4 = 0
            r7.t(r2, r3, r0, r4)     // Catch: java.io.IOException -> L92
        L9a:
            c4.m r0 = r7.c
            r0.r()
            c4.m r0 = r7.c     // Catch: java.io.IOException -> La5
            r0.s()     // Catch: java.io.IOException -> La5
            goto Lab
        La5:
            r0 = move-exception
            java.lang.String r2 = "Storing index file failed"
            d4.B.e(r1, r2, r0)
        Lab:
            return
        Lac:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Failed to initialize cache indices: "
            r2.append(r3)
            java.io.File r3 = r7.a
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            d4.B.e(r1, r2, r0)
            c4.a$a r1 = new c4.a$a
            r1.<init>(r2, r0)
            goto L37
        */
        throw new UnsupportedOperationException("Method not decompiled: c4.t.s():void");
    }

    public final void t(File file, boolean z, File[] fileArr, Map map) {
        long j;
        long j2;
        if (fileArr == null || fileArr.length == 0) {
            if (z) {
                return;
            }
            file.delete();
            return;
        }
        for (File file2 : fileArr) {
            String name = file2.getName();
            if (z && name.indexOf(46) == -1) {
                t(file2, false, file2.listFiles(), map);
            } else if (!z || (!m.o(name) && !name.endsWith(".uid"))) {
                e eVar = map != null ? (e) map.remove(name) : null;
                if (eVar != null) {
                    j2 = eVar.a;
                    j = eVar.b;
                } else {
                    j = -9223372036854775807L;
                    j2 = -1;
                }
                u j3 = u.j(file2, j2, j, this.c);
                if (j3 != null) {
                    m(j3);
                } else {
                    file2.delete();
                }
            }
        }
    }

    public final void w(u uVar) {
        ArrayList arrayList = (ArrayList) this.e.get(uVar.a);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((a.b) arrayList.get(size)).c(this, uVar);
            }
        }
        this.b.c(this, uVar);
    }

    public final void x(j jVar) {
        ArrayList arrayList = (ArrayList) this.e.get(jVar.a);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((a.b) arrayList.get(size)).d(this, jVar);
            }
        }
        this.b.d(this, jVar);
    }

    public final void y(u uVar, j jVar) {
        ArrayList arrayList = (ArrayList) this.e.get(uVar.a);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((a.b) arrayList.get(size)).a(this, uVar, jVar);
            }
        }
        this.b.a(this, uVar, jVar);
    }

    public t(File file, d dVar, T2.b bVar, byte[] bArr, boolean z, boolean z2) {
        this(file, dVar, new m(bVar, file, bArr, z, z2), (bVar == null || z2) ? null : new f(bVar));
    }

    public t(File file, d dVar, m mVar, f fVar) {
        if (!v(file)) {
            throw new IllegalStateException("Another SimpleCache instance uses the folder: " + file);
        }
        this.a = file;
        this.b = dVar;
        this.c = mVar;
        this.d = fVar;
        this.e = new HashMap();
        this.f = new Random();
        this.g = dVar.b();
        this.h = -1L;
        ConditionVariable conditionVariable = new ConditionVariable();
        new a("ExoPlayer:SimpleCacheInit", conditionVariable).start();
        conditionVariable.block();
    }
}
