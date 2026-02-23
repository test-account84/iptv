package kotlinx.coroutines.flow;

import kotlinx.coroutines.internal.y;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class m {
    public static final y a = new y("NONE");
    public static final y b = new y("PENDING");

    public static final j a(Object obj) {
        if (obj == null) {
            obj = J8.h.a;
        }
        return new l(obj);
    }

    public static final /* synthetic */ y b() {
        return a;
    }

    public static final /* synthetic */ y c() {
        return b;
    }
}
