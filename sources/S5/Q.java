package s5;

import java.util.Comparator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class q {
    public static final q a = new a();
    public static final q b = new b(-1);
    public static final q c = new b(1);

    public class a extends q {
        public a() {
            super(null);
        }

        public q d(int i, int i2) {
            return k(w5.f.e(i, i2));
        }

        public q e(long j, long j2) {
            return k(w5.h.a(j, j2));
        }

        public q f(Object obj, Object obj2, Comparator comparator) {
            return k(comparator.compare(obj, obj2));
        }

        public q g(boolean z, boolean z2) {
            return k(w5.a.a(z, z2));
        }

        public q h(boolean z, boolean z2) {
            return k(w5.a.a(z2, z));
        }

        public int i() {
            return 0;
        }

        public q k(int i) {
            return i < 0 ? q.a() : i > 0 ? q.b() : q.c();
        }
    }

    public q() {
    }

    public static /* synthetic */ q a() {
        return b;
    }

    public static /* synthetic */ q b() {
        return c;
    }

    public static /* synthetic */ q c() {
        return a;
    }

    public static q j() {
        return a;
    }

    public abstract q d(int i, int i2);

    public abstract q e(long j, long j2);

    public abstract q f(Object obj, Object obj2, Comparator comparator);

    public abstract q g(boolean z, boolean z2);

    public abstract q h(boolean z, boolean z2);

    public abstract int i();

    public /* synthetic */ q(a aVar) {
        this();
    }

    public static final class b extends q {
        public final int d;

        public b(int i) {
            super(null);
            this.d = i;
        }

        public int i() {
            return this.d;
        }

        public q d(int i, int i2) {
            return this;
        }

        public q e(long j, long j2) {
            return this;
        }

        public q g(boolean z, boolean z2) {
            return this;
        }

        public q h(boolean z, boolean z2) {
            return this;
        }

        public q f(Object obj, Object obj2, Comparator comparator) {
            return this;
        }
    }
}
