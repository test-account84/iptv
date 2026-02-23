package c4;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class f {
    public static final String[] c = {"name", "length", "last_touch_timestamp"};
    public final T2.b a;
    public String b;

    public f(T2.b bVar) {
        this.a = bVar;
    }

    public static void a(SQLiteDatabase sQLiteDatabase, String str) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str);
    }

    public static String d(String str) {
        return "ExoPlayerCacheFileMetadata" + str;
    }

    public Map b() {
        try {
            Cursor c2 = c();
            try {
                HashMap hashMap = new HashMap(c2.getCount());
                while (c2.moveToNext()) {
                    hashMap.put((String) d4.a.e(c2.getString(0)), new e(c2.getLong(1), c2.getLong(2)));
                }
                c2.close();
                return hashMap;
            } finally {
            }
        } catch (SQLException e) {
            throw new T2.a(e);
        }
    }

    public final Cursor c() {
        d4.a.e(this.b);
        return this.a.getReadableDatabase().query(this.b, c, (String) null, (String[]) null, (String) null, (String) null, (String) null);
    }

    public void e(long j) {
        try {
            String hexString = Long.toHexString(j);
            this.b = d(hexString);
            if (T2.e.b(this.a.getReadableDatabase(), 2, hexString) != 1) {
                SQLiteDatabase writableDatabase = this.a.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                try {
                    T2.e.d(writableDatabase, 2, hexString, 1);
                    a(writableDatabase, this.b);
                    writableDatabase.execSQL("CREATE TABLE " + this.b + " (name TEXT PRIMARY KEY NOT NULL,length INTEGER NOT NULL,last_touch_timestamp INTEGER NOT NULL)");
                    writableDatabase.setTransactionSuccessful();
                    writableDatabase.endTransaction();
                } catch (Throwable th) {
                    writableDatabase.endTransaction();
                    throw th;
                }
            }
        } catch (SQLException e) {
            throw new T2.a(e);
        }
    }

    public void f(String str) {
        d4.a.e(this.b);
        try {
            this.a.getWritableDatabase().delete(this.b, "name = ?", new String[]{str});
        } catch (SQLException e) {
            throw new T2.a(e);
        }
    }

    public void g(Set set) {
        d4.a.e(this.b);
        try {
            SQLiteDatabase writableDatabase = this.a.getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
            try {
                Iterator it = set.iterator();
                while (it.hasNext()) {
                    writableDatabase.delete(this.b, "name = ?", new String[]{(String) it.next()});
                }
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
            } catch (Throwable th) {
                writableDatabase.endTransaction();
                throw th;
            }
        } catch (SQLException e) {
            throw new T2.a(e);
        }
    }

    public void h(String str, long j, long j2) {
        d4.a.e(this.b);
        try {
            SQLiteDatabase writableDatabase = this.a.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("name", str);
            contentValues.put("length", Long.valueOf(j));
            contentValues.put("last_touch_timestamp", Long.valueOf(j2));
            writableDatabase.replaceOrThrow(this.b, (String) null, contentValues);
        } catch (SQLException e) {
            throw new T2.a(e);
        }
    }
}
