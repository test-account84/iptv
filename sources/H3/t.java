package H3;

import android.util.SparseArray;
import d4.Z;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class t {
    public final SparseArray a = new SparseArray();

    public Z a(int i) {
        Z z = (Z) this.a.get(i);
        if (z != null) {
            return z;
        }
        Z z2 = new Z(9223372036854775806L);
        this.a.put(i, z2);
        return z2;
    }

    public void b() {
        this.a.clear();
    }
}
