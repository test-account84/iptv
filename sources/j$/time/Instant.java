package j$.time;

import j$.time.format.DateTimeFormatter;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public final class Instant implements j$.time.temporal.m, j$.time.temporal.p, Comparable, Serializable {
    public static final Instant c = new Instant(0, 0);
    private static final long serialVersionUID = -665713676816604388L;
    private final long a;
    private final int b;

    static {
        F(-31557014167219200L, 0L);
        F(31556889864403199L, 999999999L);
    }

    private Instant(long j, int i) {
        this.a = j;
        this.b = i;
    }

    private static Instant C(long j, int i) {
        if ((i | j) == 0) {
            return c;
        }
        if (j < -31557014167219200L || j > 31556889864403199L) {
            throw new c("Instant exceeds minimum or maximum instant");
        }
        return new Instant(j, i);
    }

    public static Instant E(long j) {
        long j2 = 1000;
        return C(j$.com.android.tools.r8.a.n(j, j2), ((int) j$.com.android.tools.r8.a.m(j, j2)) * 1000000);
    }

    public static Instant F(long j, long j2) {
        return C(j$.com.android.tools.r8.a.i(j, j$.com.android.tools.r8.a.n(j2, 1000000000L)), (int) j$.com.android.tools.r8.a.m(j2, 1000000000L));
    }

    private Instant G(long j, long j2) {
        if ((j | j2) == 0) {
            return this;
        }
        return F(j$.com.android.tools.r8.a.i(j$.com.android.tools.r8.a.i(this.a, j), j2 / 1000000000), this.b + (j2 % 1000000000));
    }

    public static Instant now() {
        a.b.getClass();
        return E(System.currentTimeMillis());
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new s((byte) 2, this);
    }

    public final int D() {
        return this.b;
    }

    /* renamed from: H, reason: merged with bridge method [inline-methods] */
    public final Instant e(long j, j$.time.temporal.u uVar) {
        if (!(uVar instanceof j$.time.temporal.b)) {
            return (Instant) uVar.i(this, j);
        }
        switch (f.b[((j$.time.temporal.b) uVar).ordinal()]) {
            case 1:
                return G(0L, j);
            case 2:
                return G(j / 1000000, (j % 1000000) * 1000);
            case 3:
                return G(j / 1000, (j % 1000) * 1000000);
            case 4:
                return G(j, 0L);
            case 5:
                return G(j$.com.android.tools.r8.a.o(j, 60), 0L);
            case 6:
                return G(j$.com.android.tools.r8.a.o(j, 3600), 0L);
            case 7:
                return G(j$.com.android.tools.r8.a.o(j, 43200), 0L);
            case 8:
                return G(j$.com.android.tools.r8.a.o(j, 86400), 0L);
            default:
                throw new j$.time.temporal.v("Unsupported unit: " + uVar);
        }
    }

    final void I(DataOutput dataOutput) {
        dataOutput.writeLong(this.a);
        dataOutput.writeInt(this.b);
    }

    public OffsetDateTime atOffset(ZoneOffset zoneOffset) {
        return OffsetDateTime.D(this, zoneOffset);
    }

    public final int compareTo(Object obj) {
        Instant instant = (Instant) obj;
        int compare = Long.compare(this.a, instant.a);
        return compare != 0 ? compare : this.b - instant.b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x003f, code lost:
    
        if (r7 != r2) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0049, code lost:
    
        if (r7 != r2) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final j$.time.temporal.m d(long r6, j$.time.temporal.r r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof j$.time.temporal.a
            if (r0 == 0) goto L53
            r0 = r8
            j$.time.temporal.a r0 = (j$.time.temporal.a) r0
            r0.C(r6)
            int[] r1 = j$.time.f.a
            int r0 = r0.ordinal()
            r0 = r1[r0]
            r1 = 1
            int r2 = r5.b
            long r3 = r5.a
            if (r0 == r1) goto L4c
            r1 = 2
            if (r0 == r1) goto L46
            r1 = 3
            if (r0 == r1) goto L39
            r1 = 4
            if (r0 != r1) goto L2d
            int r8 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r8 == 0) goto L2b
            j$.time.Instant r6 = C(r6, r2)
            goto L59
        L2b:
            r6 = r5
            goto L59
        L2d:
            j$.time.temporal.v r6 = new j$.time.temporal.v
            java.lang.String r7 = "Unsupported field: "
            java.lang.String r7 = j$.time.d.a(r7, r8)
            r6.<init>(r7)
            throw r6
        L39:
            int r7 = (int) r6
            r6 = 1000000(0xf4240, float:1.401298E-39)
            int r7 = r7 * r6
            if (r7 == r2) goto L2b
        L41:
            j$.time.Instant r6 = C(r3, r7)
            goto L59
        L46:
            int r7 = (int) r6
            int r7 = r7 * 1000
            if (r7 == r2) goto L2b
            goto L41
        L4c:
            long r0 = (long) r2
            int r8 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r8 == 0) goto L2b
            int r7 = (int) r6
            goto L41
        L53:
            j$.time.temporal.m r6 = r8.q(r5, r6)
            j$.time.Instant r6 = (j$.time.Instant) r6
        L59:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.Instant.d(long, j$.time.temporal.r):j$.time.temporal.m");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Instant)) {
            return false;
        }
        Instant instant = (Instant) obj;
        return this.a == instant.a && this.b == instant.b;
    }

    public final boolean f(j$.time.temporal.r rVar) {
        return rVar instanceof j$.time.temporal.a ? rVar == j$.time.temporal.a.INSTANT_SECONDS || rVar == j$.time.temporal.a.NANO_OF_SECOND || rVar == j$.time.temporal.a.MICRO_OF_SECOND || rVar == j$.time.temporal.a.MILLI_OF_SECOND : rVar != null && rVar.l(this);
    }

    public long getEpochSecond() {
        return this.a;
    }

    public final int hashCode() {
        long j = this.a;
        return (this.b * 51) + ((int) (j ^ (j >>> 32)));
    }

    public final int i(j$.time.temporal.r rVar) {
        if (!(rVar instanceof j$.time.temporal.a)) {
            return j$.time.temporal.n.d(this, rVar).a(rVar.k(this), rVar);
        }
        int i = f.a[((j$.time.temporal.a) rVar).ordinal()];
        int i2 = this.b;
        if (i == 1) {
            return i2;
        }
        if (i == 2) {
            return i2 / 1000;
        }
        if (i == 3) {
            return i2 / 1000000;
        }
        if (i == 4) {
            j$.time.temporal.a.INSTANT_SECONDS.y(this.a);
        }
        throw new j$.time.temporal.v(d.a("Unsupported field: ", rVar));
    }

    public final j$.time.temporal.m k(h hVar) {
        return (Instant) j$.time.chrono.i.a(hVar, this);
    }

    public final j$.time.temporal.w l(j$.time.temporal.r rVar) {
        return j$.time.temporal.n.d(this, rVar);
    }

    public final long q(j$.time.temporal.r rVar) {
        int i;
        if (!(rVar instanceof j$.time.temporal.a)) {
            return rVar.k(this);
        }
        int i2 = f.a[((j$.time.temporal.a) rVar).ordinal()];
        int i3 = this.b;
        if (i2 == 1) {
            return i3;
        }
        if (i2 == 2) {
            i = i3 / 1000;
        } else {
            if (i2 != 3) {
                if (i2 == 4) {
                    return this.a;
                }
                throw new j$.time.temporal.v(d.a("Unsupported field: ", rVar));
            }
            i = i3 / 1000000;
        }
        return i;
    }

    public final Object t(j$.time.temporal.t tVar) {
        if (tVar == j$.time.temporal.n.i()) {
            return j$.time.temporal.b.NANOS;
        }
        if (tVar == j$.time.temporal.n.e() || tVar == j$.time.temporal.n.k() || tVar == j$.time.temporal.n.j() || tVar == j$.time.temporal.n.h() || tVar == j$.time.temporal.n.f() || tVar == j$.time.temporal.n.g()) {
            return null;
        }
        return tVar.a(this);
    }

    public long toEpochMilli() {
        long o;
        int i;
        int i2 = this.b;
        long j = this.a;
        if (j >= 0 || i2 <= 0) {
            o = j$.com.android.tools.r8.a.o(j, 1000);
            i = i2 / 1000000;
        } else {
            o = j$.com.android.tools.r8.a.o(j + 1, 1000);
            i = (i2 / 1000000) - 1000;
        }
        return j$.com.android.tools.r8.a.i(o, i);
    }

    public final String toString() {
        return DateTimeFormatter.f.a(this);
    }

    public final j$.time.temporal.m u(j$.time.temporal.m mVar) {
        return mVar.d(this.a, j$.time.temporal.a.INSTANT_SECONDS).d(this.b, j$.time.temporal.a.NANO_OF_SECOND);
    }

    public final j$.time.temporal.m y(long j, j$.time.temporal.u uVar) {
        return j == Long.MIN_VALUE ? e(Long.MAX_VALUE, uVar).e(1L, uVar) : e(-j, uVar);
    }
}
