package O2;

import O2.n;
import android.os.Bundle;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class n1 extends A1 {
    public static final String e = d4.k0.A0(1);
    public static final n.a f = new m1();
    public final float d;

    public n1() {
        this.d = -1.0f;
    }

    public static /* synthetic */ n1 c(Bundle bundle) {
        return d(bundle);
    }

    public static n1 d(Bundle bundle) {
        d4.a.a(bundle.getInt(A1.a, -1) == 1);
        float f2 = bundle.getFloat(e, -1.0f);
        return f2 == -1.0f ? new n1() : new n1(f2);
    }

    public boolean equals(Object obj) {
        return (obj instanceof n1) && this.d == ((n1) obj).d;
    }

    public Bundle h() {
        Bundle bundle = new Bundle();
        bundle.putInt(A1.a, 1);
        bundle.putFloat(e, this.d);
        return bundle;
    }

    public int hashCode() {
        return r5.j.b(Float.valueOf(this.d));
    }

    public n1(float f2) {
        d4.a.b(f2 >= 0.0f && f2 <= 100.0f, "percent must be in the range of [0, 100]");
        this.d = f2;
    }
}
