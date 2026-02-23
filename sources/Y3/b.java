package Y3;

import java.util.Collections;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class b implements P3.i {
    public final List a;

    public b(List list) {
        this.a = Collections.unmodifiableList(list);
    }

    public int a(long j) {
        return j < 0 ? 0 : -1;
    }

    public List b(long j) {
        return j >= 0 ? this.a : Collections.emptyList();
    }

    public long c(int i) {
        d4.a.a(i == 0);
        return 0L;
    }

    public int h() {
        return 1;
    }
}
