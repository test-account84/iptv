package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import org.jetbrains.annotations.NotNull;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class o {

    @NotNull
    private volatile /* synthetic */ Object _next = null;

    @NotNull
    private volatile /* synthetic */ long _state = 0;
    public final int a;
    public final boolean b;
    public final int c;
    public /* synthetic */ AtomicReferenceArray d;
    public static final a e = new a(null);
    public static final y h = new y("REMOVE_FROZEN");
    public static final /* synthetic */ AtomicReferenceFieldUpdater f = AtomicReferenceFieldUpdater.newUpdater(o.class, Object.class, "_next");
    public static final /* synthetic */ AtomicLongFieldUpdater g = AtomicLongFieldUpdater.newUpdater(o.class, "_state");

    public static final class a {
        public a() {
        }

        public final int a(long j) {
            return (j & 2305843009213693952L) != 0 ? 2 : 1;
        }

        public final long b(long j, int i) {
            return d(j, 1073741823L) | i;
        }

        public final long c(long j, int i) {
            return d(j, 1152921503533105152L) | (i << 30);
        }

        public final long d(long j, long j2) {
            return j & (~j2);
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    public static final class b {
        public final int a;

        public b(int i) {
            this.a = i;
        }
    }

    public o(int i, boolean z) {
        this.a = i;
        this.b = z;
        int i2 = i - 1;
        this.c = i2;
        this.d = new AtomicReferenceArray(i);
        if (i2 > 1073741823) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if ((i & i2) != 0) {
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x004a, code lost:
    
        return 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int a(java.lang.Object r12) {
        /*
            r11 = this;
        L0:
            long r2 = r11._state
            r0 = 3458764513820540928(0x3000000000000000, double:1.727233711018889E-77)
            long r0 = r0 & r2
            r6 = 0
            int r4 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r4 == 0) goto L12
            kotlinx.coroutines.internal.o$a r12 = kotlinx.coroutines.internal.o.e
            int r12 = r12.a(r2)
            return r12
        L12:
            r0 = 1073741823(0x3fffffff, double:5.304989472E-315)
            long r0 = r0 & r2
            int r1 = (int) r0
            r4 = 1152921503533105152(0xfffffffc0000000, double:1.2882296003504729E-231)
            long r4 = r4 & r2
            r0 = 30
            long r4 = r4 >> r0
            int r8 = (int) r4
            int r9 = r11.c
            int r0 = r8 + 2
            r0 = r0 & r9
            r4 = r1 & r9
            r5 = 1
            if (r0 != r4) goto L2c
            return r5
        L2c:
            boolean r0 = r11.b
            r4 = 1073741823(0x3fffffff, float:1.9999999)
            if (r0 != 0) goto L4b
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r11.d
            r10 = r8 & r9
            java.lang.Object r0 = r0.get(r10)
            if (r0 == 0) goto L4b
            int r0 = r11.a
            r2 = 1024(0x400, float:1.435E-42)
            if (r0 < r2) goto L4a
            int r8 = r8 - r1
            r1 = r8 & r4
            int r0 = r0 >> 1
            if (r1 <= r0) goto L0
        L4a:
            return r5
        L4b:
            int r0 = r8 + 1
            r0 = r0 & r4
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = kotlinx.coroutines.internal.o.g
            kotlinx.coroutines.internal.o$a r4 = kotlinx.coroutines.internal.o.e
            long r4 = r4.c(r2, r0)
            r0 = r1
            r1 = r11
            boolean r0 = r0.compareAndSet(r1, r2, r4)
            if (r0 == 0) goto L0
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r11.d
            r1 = r8 & r9
            r0.set(r1, r12)
            r0 = r11
        L66:
            long r1 = r0._state
            r3 = 1152921504606846976(0x1000000000000000, double:1.2882297539194267E-231)
            long r1 = r1 & r3
            int r3 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r3 == 0) goto L79
            kotlinx.coroutines.internal.o r0 = r0.i()
            kotlinx.coroutines.internal.o r0 = r0.e(r8, r12)
            if (r0 != 0) goto L66
        L79:
            r12 = 0
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.o.a(java.lang.Object):int");
    }

    public final o b(long j) {
        o oVar = new o(this.a * 2, this.b);
        int i = (int) (1073741823 & j);
        int i2 = (int) ((1152921503533105152L & j) >> 30);
        while (true) {
            int i3 = this.c;
            if ((i & i3) == (i2 & i3)) {
                oVar._state = e.d(j, 1152921504606846976L);
                return oVar;
            }
            Object obj = this.d.get(i3 & i);
            if (obj == null) {
                obj = new b(i);
            }
            oVar.d.set(oVar.c & i, obj);
            i++;
        }
    }

    public final o c(long j) {
        while (true) {
            o oVar = (o) this._next;
            if (oVar != null) {
                return oVar;
            }
            t.b.a(f, this, (Object) null, b(j));
        }
    }

    public final boolean d() {
        long j;
        do {
            j = this._state;
            if ((j & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & j) != 0) {
                return false;
            }
        } while (!g.compareAndSet(this, j, j | 2305843009213693952L));
        return true;
    }

    public final o e(int i, Object obj) {
        Object obj2 = this.d.get(this.c & i);
        if (!(obj2 instanceof b) || ((b) obj2).a != i) {
            return null;
        }
        this.d.set(i & this.c, obj);
        return this;
    }

    public final int f() {
        long j = this._state;
        return 1073741823 & (((int) ((j & 1152921503533105152L) >> 30)) - ((int) (1073741823 & j)));
    }

    public final boolean g() {
        long j = this._state;
        return ((int) (1073741823 & j)) == ((int) ((j & 1152921503533105152L) >> 30));
    }

    public final long h() {
        long j;
        long j2;
        do {
            j = this._state;
            if ((j & 1152921504606846976L) != 0) {
                return j;
            }
            j2 = j | 1152921504606846976L;
        } while (!g.compareAndSet(this, j, j2));
        return j2;
    }

    public final o i() {
        return c(h());
    }

    public final Object j() {
        while (true) {
            long j = this._state;
            if ((1152921504606846976L & j) != 0) {
                return h;
            }
            int i = (int) (1073741823 & j);
            int i2 = (int) ((1152921503533105152L & j) >> 30);
            int i3 = this.c;
            if ((i2 & i3) == (i & i3)) {
                return null;
            }
            Object obj = this.d.get(i3 & i);
            if (obj == null) {
                if (this.b) {
                    return null;
                }
            } else {
                if (obj instanceof b) {
                    return null;
                }
                int i4 = (i + 1) & 1073741823;
                if (g.compareAndSet(this, j, e.b(j, i4))) {
                    this.d.set(this.c & i, (Object) null);
                    return obj;
                }
                if (this.b) {
                    o oVar = this;
                    do {
                        oVar = oVar.k(i, i4);
                    } while (oVar != null);
                    return obj;
                }
            }
        }
    }

    public final o k(int i, int i2) {
        long j;
        int i3;
        do {
            j = this._state;
            i3 = (int) (1073741823 & j);
            if ((1152921504606846976L & j) != 0) {
                return i();
            }
        } while (!g.compareAndSet(this, j, e.b(j, i2)));
        this.d.set(i3 & this.c, (Object) null);
        return null;
    }
}
