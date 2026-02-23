package Y3;

import O2.l1;
import android.text.TextUtils;
import d4.M;
import java.util.ArrayList;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class h extends P3.h {
    public final M o;
    public final c p;

    public h() {
        super("WebvttDecoder");
        this.o = new M();
        this.p = new c();
    }

    public static int B(M m) {
        int i = -1;
        int i2 = 0;
        while (i == -1) {
            i2 = m.f();
            String s = m.s();
            i = s == null ? 0 : "STYLE".equals(s) ? 2 : s.startsWith("NOTE") ? 1 : 3;
        }
        m.U(i2);
        return i;
    }

    public static void C(M m) {
        while (!TextUtils.isEmpty(m.s())) {
        }
    }

    public P3.i z(byte[] bArr, int i, boolean z) {
        e m;
        this.o.S(bArr, i);
        ArrayList arrayList = new ArrayList();
        try {
            i.e(this.o);
            while (!TextUtils.isEmpty(this.o.s())) {
            }
            ArrayList arrayList2 = new ArrayList();
            while (true) {
                int B = B(this.o);
                if (B == 0) {
                    return new k(arrayList2);
                }
                if (B == 1) {
                    C(this.o);
                } else if (B == 2) {
                    if (!arrayList2.isEmpty()) {
                        throw new P3.k("A style block was found after the first cue.");
                    }
                    this.o.s();
                    arrayList.addAll(this.p.d(this.o));
                } else if (B == 3 && (m = f.m(this.o, arrayList)) != null) {
                    arrayList2.add(m);
                }
            }
        } catch (l1 e) {
            throw new P3.k((Throwable) e);
        }
    }
}
