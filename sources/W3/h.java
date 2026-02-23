package W3;

import P3.i;
import d4.k0;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class h implements i {
    public final d a;
    public final long[] c;
    public final Map d;
    public final Map e;
    public final Map f;

    public h(d dVar, Map map, Map map2, Map map3) {
        this.a = dVar;
        this.e = map2;
        this.f = map3;
        this.d = map != null ? Collections.unmodifiableMap(map) : Collections.emptyMap();
        this.c = dVar.j();
    }

    public int a(long j) {
        int e = k0.e(this.c, j, false, false);
        if (e < this.c.length) {
            return e;
        }
        return -1;
    }

    public List b(long j) {
        return this.a.h(j, this.d, this.e, this.f);
    }

    public long c(int i) {
        return this.c[i];
    }

    public int h() {
        return this.c.length;
    }
}
