package I8;

import kotlinx.coroutines.internal.y;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class m extends a {
    public m(w8.l lVar) {
        super(lVar);
    }

    public Object m(Object obj) {
        p o;
        do {
            Object m = super.m(obj);
            y yVar = b.b;
            if (m == yVar) {
                return yVar;
            }
            if (m != b.c) {
                if (m instanceof i) {
                    return m;
                }
                throw new IllegalStateException(("Invalid offerInternal result " + m).toString());
            }
            o = o(obj);
            if (o == null) {
                return yVar;
            }
        } while (!(o instanceof i));
        return o;
    }

    public final boolean v() {
        return true;
    }

    public final boolean w() {
        return true;
    }
}
