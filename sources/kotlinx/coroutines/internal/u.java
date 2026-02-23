package kotlinx.coroutines.internal;

import G8.P;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class u {
    public abstract c a();

    public final boolean b(u uVar) {
        c a;
        c a2 = a();
        return (a2 == null || (a = uVar.a()) == null || a2.f() >= a.f()) ? false : true;
    }

    public abstract Object c(Object obj);

    public String toString() {
        return P.a(this) + '@' + P.b(this);
    }
}
