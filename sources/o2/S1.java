package O2;

import O2.n;
import android.os.Bundle;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class s1 implements n {
    public static final s1 e = new s1(1.0f);
    public static final String f = d4.k0.A0(0);
    public static final String g = d4.k0.A0(1);
    public static final n.a h = new r1();
    public final float a;
    public final float c;
    public final int d;

    public s1(float f2) {
        this(f2, 1.0f);
    }

    public static /* synthetic */ s1 a(Bundle bundle) {
        return c(bundle);
    }

    public static /* synthetic */ s1 c(Bundle bundle) {
        return new s1(bundle.getFloat(f, 1.0f), bundle.getFloat(g, 1.0f));
    }

    public long b(long j) {
        return j * this.d;
    }

    public s1 d(float f2) {
        return new s1(f2, this.c);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || s1.class != obj.getClass()) {
            return false;
        }
        s1 s1Var = (s1) obj;
        return this.a == s1Var.a && this.c == s1Var.c;
    }

    public Bundle h() {
        Bundle bundle = new Bundle();
        bundle.putFloat(f, this.a);
        bundle.putFloat(g, this.c);
        return bundle;
    }

    public int hashCode() {
        return ((527 + Float.floatToRawIntBits(this.a)) * 31) + Float.floatToRawIntBits(this.c);
    }

    public String toString() {
        return d4.k0.D("PlaybackParameters(speed=%.2f, pitch=%.2f)", Float.valueOf(this.a), Float.valueOf(this.c));
    }

    public s1(float f2, float f3) {
        d4.a.a(f2 > 0.0f);
        d4.a.a(f3 > 0.0f);
        this.a = f2;
        this.c = f3;
        this.d = Math.round(f2 * 1000.0f);
    }
}
