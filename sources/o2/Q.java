package O2;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class q implements F0 {
    public final b4.t a;
    public final long b;
    public final long c;
    public final long d;
    public final long e;
    public final int f;
    public final boolean g;
    public final long h;
    public final boolean i;
    public int j;
    public boolean k;

    public q() {
        this(new b4.t(true, 65536), 50000, 50000, 2500, 5000, -1, false, 0, false);
    }

    public static void i(int i, int i2, String str, String str2) {
        d4.a.b(i >= i2, str + " cannot be less than " + str2);
    }

    public static int k(int i) {
        switch (i) {
            case -2:
                return 0;
            case -1:
            default:
                throw new IllegalArgumentException();
            case 0:
                return 144310272;
            case 1:
                return 13107200;
            case 2:
                return 131072000;
            case 3:
            case 4:
            case 5:
            case 6:
                return 131072;
        }
    }

    public boolean a() {
        return this.i;
    }

    public long b() {
        return this.h;
    }

    public void c(Q1 q1, B3.A a, C1[] c1Arr, B3.i0 i0Var, Z3.s[] sVarArr) {
        int i = this.f;
        if (i == -1) {
            i = j(c1Arr, sVarArr);
        }
        this.j = i;
        this.a.h(i);
    }

    public b4.b d() {
        return this.a;
    }

    public void e() {
        l(true);
    }

    public void f() {
        l(true);
    }

    public boolean g(Q1 q1, B3.A a, long j, float f, boolean z, long j2) {
        long k0 = d4.k0.k0(j, f);
        long j3 = z ? this.e : this.d;
        if (j2 != -9223372036854775807L) {
            j3 = Math.min(j2 / 2, j3);
        }
        return j3 <= 0 || k0 >= j3 || (!this.g && this.a.f() >= this.j);
    }

    public boolean h(long j, long j2, float f) {
        boolean z = true;
        boolean z2 = this.a.f() >= this.j;
        long j3 = this.b;
        if (f > 1.0f) {
            j3 = Math.min(d4.k0.f0(j3, f), this.c);
        }
        if (j2 < Math.max(j3, 500000L)) {
            if (!this.g && z2) {
                z = false;
            }
            this.k = z;
            if (!z && j2 < 500000) {
                d4.B.j("DefaultLoadControl", "Target buffer size reached with less than 500ms of buffered media data.");
            }
        } else if (j2 >= this.c || z2) {
            this.k = false;
        }
        return this.k;
    }

    public int j(C1[] c1Arr, Z3.s[] sVarArr) {
        int i = 0;
        for (int i2 = 0; i2 < c1Arr.length; i2++) {
            if (sVarArr[i2] != null) {
                i += k(c1Arr[i2].getTrackType());
            }
        }
        return Math.max(13107200, i);
    }

    public final void l(boolean z) {
        int i = this.f;
        if (i == -1) {
            i = 13107200;
        }
        this.j = i;
        this.k = false;
        if (z) {
            this.a.g();
        }
    }

    public void onPrepared() {
        l(false);
    }

    public q(b4.t tVar, int i, int i2, int i3, int i4, int i5, boolean z, int i6, boolean z2) {
        i(i3, 0, "bufferForPlaybackMs", "0");
        i(i4, 0, "bufferForPlaybackAfterRebufferMs", "0");
        i(i, i3, "minBufferMs", "bufferForPlaybackMs");
        i(i, i4, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
        i(i2, i, "maxBufferMs", "minBufferMs");
        i(i6, 0, "backBufferDurationMs", "0");
        this.a = tVar;
        this.b = d4.k0.P0(i);
        this.c = d4.k0.P0(i2);
        this.d = d4.k0.P0(i3);
        this.e = d4.k0.P0(i4);
        this.f = i5;
        this.j = i5 == -1 ? 13107200 : i5;
        this.g = z;
        this.h = d4.k0.P0(i6);
        this.i = z2;
    }
}
