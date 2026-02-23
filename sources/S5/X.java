package s5;

import java.io.Serializable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class x extends e implements Serializable {
    public final Object a;
    public final Object c;

    public x(Object obj, Object obj2) {
        this.a = obj;
        this.c = obj2;
    }

    public final Object getKey() {
        return this.a;
    }

    public final Object getValue() {
        return this.c;
    }

    public final Object setValue(Object obj) {
        throw new UnsupportedOperationException();
    }
}
