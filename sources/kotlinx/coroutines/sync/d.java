package kotlinx.coroutines.sync;

import kotlinx.coroutines.internal.y;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class d {
    public static final y a = new y("LOCK_FAIL");
    public static final y b = new y("UNLOCK_FAIL");
    public static final y c;
    public static final y d;
    public static final a e;
    public static final a f;

    static {
        y yVar = new y("LOCKED");
        c = yVar;
        y yVar2 = new y("UNLOCKED");
        d = yVar2;
        e = new a(yVar);
        f = new a(yVar2);
    }

    public static final b a(boolean z) {
        return new c(z);
    }

    public static /* synthetic */ b b(boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return a(z);
    }

    public static final /* synthetic */ a c() {
        return e;
    }

    public static final /* synthetic */ a d() {
        return f;
    }

    public static final /* synthetic */ y e() {
        return c;
    }

    public static final /* synthetic */ y f() {
        return d;
    }

    public static final /* synthetic */ y g() {
        return b;
    }
}
