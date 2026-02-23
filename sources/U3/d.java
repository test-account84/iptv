package U3;

import P3.i;
import d4.k0;
import java.util.Collections;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class d implements i {
    public final List a;
    public final List c;

    public d(List list, List list2) {
        this.a = list;
        this.c = list2;
    }

    public int a(long j) {
        int d = k0.d(this.c, Long.valueOf(j), false, false);
        if (d < this.c.size()) {
            return d;
        }
        return -1;
    }

    public List b(long j) {
        int g = k0.g(this.c, Long.valueOf(j), true, false);
        return g == -1 ? Collections.emptyList() : (List) this.a.get(g);
    }

    public long c(int i) {
        d4.a.a(i >= 0);
        d4.a.a(i < this.c.size());
        return ((Long) this.c.get(i)).longValue();
    }

    public int h() {
        return this.c.size();
    }
}
