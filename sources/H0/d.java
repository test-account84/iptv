package H0;

import android.database.sqlite.SQLiteProgram;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class d implements G0.d {
    public final SQLiteProgram a;

    public d(SQLiteProgram sQLiteProgram) {
        this.a = sQLiteProgram;
    }

    public void A(int i, long j) {
        this.a.bindLong(i, j);
    }

    public void S(int i, byte[] bArr) {
        this.a.bindBlob(i, bArr);
    }

    public void X(int i) {
        this.a.bindNull(i);
    }

    public void close() {
        this.a.close();
    }

    public void f(int i, double d) {
        this.a.bindDouble(i, d);
    }

    public void x(int i, String str) {
        this.a.bindString(i, str);
    }
}
