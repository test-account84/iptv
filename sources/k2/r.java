package K2;

import F2.c;
import K2.M;
import android.database.sqlite.SQLiteDatabase;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class r implements M.b {
    public final /* synthetic */ String a;
    public final /* synthetic */ c.b b;
    public final /* synthetic */ long c;

    public /* synthetic */ r(String str, c.b bVar, long j) {
        this.a = str;
        this.b = bVar;
        this.c = j;
    }

    public final Object apply(Object obj) {
        return M.V(this.a, this.b, this.c, (SQLiteDatabase) obj);
    }
}
