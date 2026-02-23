package r3;

import d4.L;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import q3.e;
import q3.h;
import r5.d;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class b extends h {
    public static q3.a c(L l) {
        l.r(12);
        int d = (l.d() + l.h(12)) - 4;
        l.r(44);
        l.s(l.h(12));
        l.r(16);
        ArrayList arrayList = new ArrayList();
        while (true) {
            String str = null;
            if (l.d() >= d) {
                break;
            }
            l.r(48);
            int h = l.h(8);
            l.r(4);
            int d2 = l.d() + l.h(12);
            String str2 = null;
            while (l.d() < d2) {
                int h2 = l.h(8);
                int h3 = l.h(8);
                int d3 = l.d() + h3;
                if (h2 == 2) {
                    int h4 = l.h(16);
                    l.r(8);
                    if (h4 == 3) {
                        while (l.d() < d3) {
                            str = l.l(l.h(8), d.a);
                            int h5 = l.h(8);
                            for (int i = 0; i < h5; i++) {
                                l.s(l.h(8));
                            }
                        }
                    }
                } else if (h2 == 21) {
                    str2 = l.l(h3, d.a);
                }
                l.p(d3 * 8);
            }
            l.p(d2 * 8);
            if (str != null && str2 != null) {
                arrayList.add(new a(h, str + str2));
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new q3.a((List) arrayList);
    }

    public q3.a b(e eVar, ByteBuffer byteBuffer) {
        if (byteBuffer.get() == 116) {
            return c(new L(byteBuffer.array(), byteBuffer.limit()));
        }
        return null;
    }
}
