package o8;

import kotlin.jvm.internal.l;
import o8.g;
import w8.p;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class a implements g.b {
    public final g.c a;

    public a(g.c key) {
        l.e(key, "key");
        this.a = key;
    }

    public g V(g gVar) {
        return g.b.a.d(this, gVar);
    }

    public g.b a(g.c cVar) {
        return g.b.a.b(this, cVar);
    }

    public g.c getKey() {
        return this.a;
    }

    public Object l(Object obj, p pVar) {
        return g.b.a.a(this, obj, pVar);
    }

    public g w(g.c cVar) {
        return g.b.a.c(this, cVar);
    }
}
