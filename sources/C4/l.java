package c4;

import d4.B;
import java.io.File;
import java.util.ArrayList;
import java.util.TreeSet;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class l {
    public final int a;
    public final String b;
    public final TreeSet c;
    public final ArrayList d;
    public q e;

    public static final class a {
        public final long a;
        public final long b;

        public a(long j, long j2) {
            this.a = j;
            this.b = j2;
        }

        public boolean a(long j, long j2) {
            long j3 = this.b;
            if (j3 == -1) {
                return j >= this.a;
            }
            if (j2 == -1) {
                return false;
            }
            long j4 = this.a;
            return j4 <= j && j + j2 <= j4 + j3;
        }

        public boolean b(long j, long j2) {
            long j3 = this.a;
            if (j3 > j) {
                return j2 == -1 || j + j2 > j3;
            }
            long j4 = this.b;
            return j4 == -1 || j3 + j4 > j;
        }
    }

    public l(int i, String str) {
        this(i, str, q.c);
    }

    public void a(u uVar) {
        this.c.add(uVar);
    }

    public boolean b(p pVar) {
        this.e = this.e.e(pVar);
        return !r2.equals(r0);
    }

    public long c(long j, long j2) {
        d4.a.a(j >= 0);
        d4.a.a(j2 >= 0);
        u e = e(j, j2);
        if (e.b()) {
            return -Math.min(e.h() ? Long.MAX_VALUE : e.d, j2);
        }
        long j3 = j + j2;
        long j4 = j3 >= 0 ? j3 : Long.MAX_VALUE;
        long j5 = e.c + e.d;
        if (j5 < j4) {
            for (u uVar : this.c.tailSet(e, false)) {
                long j6 = uVar.c;
                if (j6 > j5) {
                    break;
                }
                j5 = Math.max(j5, j6 + uVar.d);
                if (j5 >= j4) {
                    break;
                }
            }
        }
        return Math.min(j5 - j, j2);
    }

    public q d() {
        return this.e;
    }

    public u e(long j, long j2) {
        u o = u.o(this.b, j);
        u uVar = (u) this.c.floor(o);
        if (uVar != null && uVar.c + uVar.d > j) {
            return uVar;
        }
        u uVar2 = (u) this.c.ceiling(o);
        if (uVar2 != null) {
            long j3 = uVar2.c - j;
            j2 = j2 == -1 ? j3 : Math.min(j3, j2);
        }
        return u.n(this.b, j, j2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || l.class != obj.getClass()) {
            return false;
        }
        l lVar = (l) obj;
        return this.a == lVar.a && this.b.equals(lVar.b) && this.c.equals(lVar.c) && this.e.equals(lVar.e);
    }

    public TreeSet f() {
        return this.c;
    }

    public boolean g() {
        return this.c.isEmpty();
    }

    public boolean h(long j, long j2) {
        for (int i = 0; i < this.d.size(); i++) {
            if (((a) this.d.get(i)).a(j, j2)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (((this.a * 31) + this.b.hashCode()) * 31) + this.e.hashCode();
    }

    public boolean i() {
        return this.d.isEmpty();
    }

    public boolean j(long j, long j2) {
        for (int i = 0; i < this.d.size(); i++) {
            if (((a) this.d.get(i)).b(j, j2)) {
                return false;
            }
        }
        this.d.add(new a(j, j2));
        return true;
    }

    public boolean k(j jVar) {
        if (!this.c.remove(jVar)) {
            return false;
        }
        File file = jVar.f;
        if (file == null) {
            return true;
        }
        file.delete();
        return true;
    }

    public u l(u uVar, long j, boolean z) {
        d4.a.g(this.c.remove(uVar));
        File file = (File) d4.a.e(uVar.f);
        if (z) {
            File p = u.p((File) d4.a.e(file.getParentFile()), this.a, uVar.c, j);
            if (file.renameTo(p)) {
                file = p;
            } else {
                B.j("CachedContent", "Failed to rename " + file + " to " + p);
            }
        }
        u i = uVar.i(file, j);
        this.c.add(i);
        return i;
    }

    public void m(long j) {
        for (int i = 0; i < this.d.size(); i++) {
            if (((a) this.d.get(i)).a == j) {
                this.d.remove(i);
                return;
            }
        }
        throw new IllegalStateException();
    }

    public l(int i, String str, q qVar) {
        this.a = i;
        this.b = str;
        this.e = qVar;
        this.c = new TreeSet();
        this.d = new ArrayList();
    }
}
