package J3;

import java.util.Collections;
import java.util.List;
import z3.C;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class h implements C {
    public final String a;
    public final List b;
    public final boolean c;

    public h(String str, List list, boolean z) {
        this.a = str;
        this.b = Collections.unmodifiableList(list);
        this.c = z;
    }
}
