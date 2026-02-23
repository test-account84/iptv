package H0;

import G0.f;
import android.database.sqlite.SQLiteStatement;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class e extends d implements f {
    public final SQLiteStatement c;

    public e(SQLiteStatement sQLiteStatement) {
        super(sQLiteStatement);
        this.c = sQLiteStatement;
    }

    public int E() {
        return this.c.executeUpdateDelete();
    }

    public long O() {
        return this.c.executeInsert();
    }
}
