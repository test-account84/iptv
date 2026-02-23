package kotlin.jvm.internal;

import C8.k;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class p extends r implements C8.h {
    public p(Object obj, Class cls, String str, String str2, int i) {
        super(obj, cls, str, str2, i);
    }

    public C8.b computeReflected() {
        return C.e(this);
    }

    public k.a getGetter() {
        ((C8.h) getReflected()).getGetter();
        return null;
    }

    public Object invoke(Object obj) {
        return get(obj);
    }
}
