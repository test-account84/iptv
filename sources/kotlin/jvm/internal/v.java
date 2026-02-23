package kotlin.jvm.internal;

import C8.l;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class v extends x implements C8.l {
    public v(Class cls, String str, String str2, int i) {
        super(c.NO_RECEIVER, cls, str, str2, i);
    }

    public C8.b computeReflected() {
        return C.g(this);
    }

    public l.a getGetter() {
        ((C8.l) getReflected()).getGetter();
        return null;
    }

    public Object invoke(Object obj, Object obj2) {
        return g(obj, obj2);
    }
}
