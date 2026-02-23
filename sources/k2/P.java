package K2;

import K2.M;
import android.database.sqlite.SQLiteDatabase;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class p implements M.b {
    public final /* synthetic */ long a;
    public final /* synthetic */ C2.p b;

    public /* synthetic */ p(long j, C2.p pVar) {
        this.a = j;
        this.b = pVar;
    }

    public final Object apply(Object obj) {
        return M.o(this.a, this.b, (SQLiteDatabase) obj);
    }
}
