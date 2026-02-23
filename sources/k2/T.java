package K2;

import F2.a;
import K2.M;
import android.database.sqlite.SQLiteDatabase;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class t implements M.b {
    public final /* synthetic */ M a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Map c;
    public final /* synthetic */ a.a d;

    public /* synthetic */ t(M m, String str, Map map, a.a aVar) {
        this.a = m;
        this.b = str;
        this.c = map;
        this.d = aVar;
    }

    public final Object apply(Object obj) {
        return M.e0(this.a, this.b, this.c, this.d, (SQLiteDatabase) obj);
    }
}
