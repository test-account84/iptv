package B8;

import l8.y;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class d implements Iterable, x8.a {
    public static final a e = new a(null);
    public final long a;
    public final long c;
    public final long d;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    public d(long j, long j2, long j3) {
        if (j3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (j3 == Long.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
        }
        this.a = j;
        this.c = r8.c.d(j, j2, j3);
        this.d = j3;
    }

    public final long d() {
        return this.a;
    }

    public final long f() {
        return this.c;
    }

    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public y iterator() {
        return new e(this.a, this.c, this.d);
    }
}
