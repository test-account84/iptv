package T2;

import O2.w0;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import d4.k0;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class e {
    static {
        w0.a("goog.exo.database");
    }

    public static String[] a(int i, String str) {
        return new String[]{Integer.toString(i), str};
    }

    public static int b(SQLiteDatabase sQLiteDatabase, int i, String str) {
        try {
            if (!k0.o1(sQLiteDatabase, "ExoPlayerVersions")) {
                return -1;
            }
            Cursor query = sQLiteDatabase.query("ExoPlayerVersions", new String[]{"version"}, "feature = ? AND instance_uid = ?", a(i, str), (String) null, (String) null, (String) null);
            try {
                if (query.getCount() == 0) {
                    query.close();
                    return -1;
                }
                query.moveToNext();
                int i2 = query.getInt(0);
                query.close();
                return i2;
            } finally {
            }
        } catch (SQLException e) {
            throw new a(e);
        }
    }

    public static void c(SQLiteDatabase sQLiteDatabase, int i, String str) {
        try {
            if (k0.o1(sQLiteDatabase, "ExoPlayerVersions")) {
                sQLiteDatabase.delete("ExoPlayerVersions", "feature = ? AND instance_uid = ?", a(i, str));
            }
        } catch (SQLException e) {
            throw new a(e);
        }
    }

    public static void d(SQLiteDatabase sQLiteDatabase, int i, String str, int i2) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS ExoPlayerVersions (feature INTEGER NOT NULL,instance_uid TEXT NOT NULL,version INTEGER NOT NULL,PRIMARY KEY (feature, instance_uid))");
            ContentValues contentValues = new ContentValues();
            contentValues.put("feature", Integer.valueOf(i));
            contentValues.put("instance_uid", str);
            contentValues.put("version", Integer.valueOf(i2));
            sQLiteDatabase.replaceOrThrow("ExoPlayerVersions", (String) null, contentValues);
        } catch (SQLException e) {
            throw new a(e);
        }
    }
}
