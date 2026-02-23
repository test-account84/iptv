package K2;

import K2.M;
import android.database.Cursor;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class x implements M.b {
    public final /* synthetic */ M a;
    public final /* synthetic */ List b;
    public final /* synthetic */ C2.p c;

    public /* synthetic */ x(M m, List list, C2.p pVar) {
        this.a = m;
        this.b = list;
        this.c = pVar;
    }

    public final Object apply(Object obj) {
        return M.c0(this.a, this.b, this.c, (Cursor) obj);
    }
}
