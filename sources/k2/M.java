package K2;

import K2.M;
import android.database.sqlite.SQLiteDatabase;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class m implements M.b {
    public final /* synthetic */ M a;
    public final /* synthetic */ C2.p b;

    public /* synthetic */ m(M m, C2.p pVar) {
        this.a = m;
        this.b = pVar;
    }

    public final Object apply(Object obj) {
        return M.h(this.a, this.b, (SQLiteDatabase) obj);
    }
}
