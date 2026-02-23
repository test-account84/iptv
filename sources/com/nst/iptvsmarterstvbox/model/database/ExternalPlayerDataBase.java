package com.nst.iptvsmarterstvbox.model.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import com.nst.iptvsmarterstvbox.model.pojo.ExternalPlayerModelClass;
import java.util.ArrayList;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class ExternalPlayerDataBase extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "externalplayerdatabase.db";
    private static final int DATABASE_VERSION = 3;
    private static final String KEY_APP_ICON = "appicon";
    private static final String KEY_APP_NAME = "appname";
    private static final String KEY_ID = "id";
    private static final String KEY_PACKAGE_NAME = "packagename";
    private static final String KEY_USER_ID = "user_id_referred";
    private static final String TABLE_EXTERNAL_PLAYER = "table_external_player";
    String CREATE_EXTERNAL_PLAYER_TABLE;
    private Context context;
    private SQLiteDatabase db;

    public ExternalPlayerDataBase(Context context) {
        super(context, "externalplayerdatabase.db", (SQLiteDatabase.CursorFactory) null, 3);
        this.CREATE_EXTERNAL_PLAYER_TABLE = "CREATE TABLE IF NOT EXISTS table_external_player(id INTEGER PRIMARY KEY,appname TEXT,packagename TEXT,appicon TEXT,user_id_referred TEXT)";
        this.context = context;
    }

    public boolean CheckPlayerExistense(String str) {
        ArrayList arrayList = new ArrayList();
        String str2 = "SELECT  * FROM table_external_player WHERE appname='" + str + "'";
        try {
            SQLiteDatabase readableDatabase = getReadableDatabase();
            this.db = readableDatabase;
            Cursor rawQuery = readableDatabase.rawQuery(str2, (String[]) null);
            if (rawQuery.moveToFirst()) {
                do {
                    ExternalPlayerModelClass externalPlayerModelClass = new ExternalPlayerModelClass();
                    externalPlayerModelClass.setAppname(rawQuery.getString(1));
                    arrayList.add(externalPlayerModelClass);
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
        } catch (SQLiteDatabaseLockedException | SQLiteException unused) {
        }
        return arrayList.size() > 0;
    }

    public void addExternalPlayer(String str, String str2) {
        try {
            this.db = getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("appname", str);
            contentValues.put("packagename", str2);
            this.db.insert("table_external_player", (String) null, contentValues);
            this.db.close();
        } catch (SQLiteDatabaseLockedException | SQLiteException unused) {
        }
    }

    public ArrayList getExternalPlayer() {
        ArrayList arrayList = new ArrayList();
        try {
            SQLiteDatabase readableDatabase = getReadableDatabase();
            this.db = readableDatabase;
            Cursor rawQuery = readableDatabase.rawQuery("SELECT  * FROM table_external_player ", (String[]) null);
            if (rawQuery.moveToFirst()) {
                do {
                    ExternalPlayerModelClass externalPlayerModelClass = new ExternalPlayerModelClass();
                    externalPlayerModelClass.setId(rawQuery.getInt(0));
                    externalPlayerModelClass.setAppname(rawQuery.getString(1));
                    externalPlayerModelClass.setPackagename(rawQuery.getString(2));
                    externalPlayerModelClass.setAppicon(rawQuery.getString(3));
                    arrayList.add(externalPlayerModelClass);
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
        } catch (SQLiteDatabaseLockedException | SQLiteException unused) {
        }
        return arrayList;
    }

    public int getExternalPlayercount() {
        try {
            SQLiteDatabase readableDatabase = getReadableDatabase();
            this.db = readableDatabase;
            Cursor rawQuery = readableDatabase.rawQuery("SELECT  * FROM table_external_player ", (String[]) null);
            int count = rawQuery.moveToFirst() ? rawQuery.getCount() : 0;
            rawQuery.close();
            return count;
        } catch (SQLiteDatabaseLockedException | SQLiteException unused) {
            return 0;
        }
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(this.CREATE_EXTERNAL_PLAYER_TABLE);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void removeAllPlayers() {
        /*
            r4 = this;
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r4.getWritableDatabase()     // Catch: java.lang.Throwable -> L14 android.database.sqlite.SQLiteException -> L19 android.database.sqlite.SQLiteDatabaseLockedException -> L23
            java.lang.String r2 = "table_external_player"
            r1.delete(r2, r0, r0)     // Catch: java.lang.Throwable -> Le android.database.sqlite.SQLiteException -> L10 android.database.sqlite.SQLiteDatabaseLockedException -> L12
        La:
            r1.close()
            goto L2d
        Le:
            r0 = move-exception
            goto L2e
        L10:
            r0 = move-exception
            goto L1d
        L12:
            r0 = move-exception
            goto L27
        L14:
            r1 = move-exception
            r3 = r1
            r1 = r0
            r0 = r3
            goto L2e
        L19:
            r1 = move-exception
            r3 = r1
            r1 = r0
            r0 = r3
        L1d:
            r0.printStackTrace()     // Catch: java.lang.Throwable -> Le
            if (r1 == 0) goto L2d
            goto La
        L23:
            r1 = move-exception
            r3 = r1
            r1 = r0
            r0 = r3
        L27:
            r0.printStackTrace()     // Catch: java.lang.Throwable -> Le
            if (r1 == 0) goto L2d
            goto La
        L2d:
            return
        L2e:
            if (r1 == 0) goto L33
            r1.close()
        L33:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.model.database.ExternalPlayerDataBase.removeAllPlayers():void");
    }

    public int removePlayer(String str) {
        int i = 0;
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            this.db = writableDatabase;
            i = writableDatabase.delete("table_external_player", "appname='" + str + "' ", (String[]) null);
            this.db.close();
            return i;
        } catch (SQLiteDatabaseLockedException | SQLiteException unused) {
            return i;
        }
    }
}
