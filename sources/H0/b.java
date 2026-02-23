package H0;

import G0.c;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import java.io.File;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class b implements G0.c {
    public final Context a;
    public final String c;
    public final c.a d;
    public final boolean e;
    public final Object f = new Object();
    public a g;
    public boolean h;

    public static class a extends SQLiteOpenHelper {
        public final H0.a[] a;
        public final c.a c;
        public boolean d;

        public class a implements DatabaseErrorHandler {
            public final /* synthetic */ c.a a;
            public final /* synthetic */ H0.a[] b;

            public a(c.a aVar, H0.a[] aVarArr) {
                this.a = aVar;
                this.b = aVarArr;
            }

            public void onCorruption(SQLiteDatabase sQLiteDatabase) {
                this.a.c(a.c(this.b, sQLiteDatabase));
            }
        }

        public a(Context context, String str, H0.a[] aVarArr, c.a aVar) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, aVar.a, new a(aVar, aVarArr));
            this.c = aVar;
            this.a = aVarArr;
        }

        public static H0.a c(H0.a[] aVarArr, SQLiteDatabase sQLiteDatabase) {
            H0.a aVar = aVarArr[0];
            if (aVar == null || !aVar.a(sQLiteDatabase)) {
                aVarArr[0] = new H0.a(sQLiteDatabase);
            }
            return aVarArr[0];
        }

        public H0.a a(SQLiteDatabase sQLiteDatabase) {
            return c(this.a, sQLiteDatabase);
        }

        public synchronized void close() {
            super.close();
            this.a[0] = null;
        }

        public synchronized G0.b d() {
            this.d = false;
            SQLiteDatabase writableDatabase = super.getWritableDatabase();
            if (!this.d) {
                return a(writableDatabase);
            }
            close();
            return d();
        }

        public void onConfigure(SQLiteDatabase sQLiteDatabase) {
            this.c.b(a(sQLiteDatabase));
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            this.c.d(a(sQLiteDatabase));
        }

        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            this.d = true;
            this.c.e(a(sQLiteDatabase), i, i2);
        }

        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            if (this.d) {
                return;
            }
            this.c.f(a(sQLiteDatabase));
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            this.d = true;
            this.c.g(a(sQLiteDatabase), i, i2);
        }
    }

    public b(Context context, String str, c.a aVar, boolean z) {
        this.a = context;
        this.c = str;
        this.d = aVar;
        this.e = z;
    }

    public final a a() {
        a aVar;
        synchronized (this.f) {
            try {
                if (this.g == null) {
                    H0.a[] aVarArr = new H0.a[1];
                    if (Build.VERSION.SDK_INT < 23 || this.c == null || !this.e) {
                        this.g = new a(this.a, this.c, aVarArr, this.d);
                    } else {
                        this.g = new a(this.a, new File(this.a.getNoBackupFilesDir(), this.c).getAbsolutePath(), aVarArr, this.d);
                    }
                    this.g.setWriteAheadLoggingEnabled(this.h);
                }
                aVar = this.g;
            } catch (Throwable th) {
                throw th;
            }
        }
        return aVar;
    }

    public void close() {
        a().close();
    }

    public String getDatabaseName() {
        return this.c;
    }

    public G0.b getWritableDatabase() {
        return a().d();
    }

    public void setWriteAheadLoggingEnabled(boolean z) {
        synchronized (this.f) {
            try {
                a aVar = this.g;
                if (aVar != null) {
                    aVar.setWriteAheadLoggingEnabled(z);
                }
                this.h = z;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
