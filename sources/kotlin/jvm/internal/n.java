package kotlin.jvm.internal;

import C8.g;
import C8.i;
import C8.j;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class n extends r implements C8.g {
    public n(Object obj, Class cls, String str, String str2, int i) {
        super(obj, cls, str, str2, i);
    }

    public C8.b computeReflected() {
        return C.d(this);
    }

    public Object getDelegate() {
        return ((C8.g) getReflected()).getDelegate();
    }

    public /* bridge */ /* synthetic */ i.a getGetter() {
        getGetter();
        return null;
    }

    public /* bridge */ /* synthetic */ C8.f getSetter() {
        getSetter();
        return null;
    }

    public Object invoke() {
        return get();
    }

    public j.a getGetter() {
        ((C8.g) getReflected()).getGetter();
        return null;
    }

    public g.a getSetter() {
        ((C8.g) getReflected()).getSetter();
        return null;
    }
}
