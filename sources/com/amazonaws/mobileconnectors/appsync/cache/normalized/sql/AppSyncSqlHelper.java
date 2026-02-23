package com.amazonaws.mobileconnectors.appsync.cache.normalized.sql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class AppSyncSqlHelper extends SQLiteOpenHelper {
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_KEY = "key";
    public static final String COLUMN_RECORD = "record";
    private static final String DATABASE_NAME = "appsync.db";
    private static final int DATABASE_VERSION = 1;
    public static final String IDX_RECORDS_KEY = "idx_records_key";
    public static final String TABLE_RECORDS = "records";
    private static final String TAG = "AppSyncSqlHelper";
    private static final String DATABASE_CREATE = String.format("create table %s( %s integer primary key autoincrement, %s text not null, %s text not null);", new Object[]{"records", "_id", "key", "record"});
    private static final String CREATE_KEY_INDEX = String.format("CREATE INDEX %s ON %s (%s)", new Object[]{"idx_records_key", "records", "key"});

    private AppSyncSqlHelper(Context context) {
        super(context, "appsync.db", (SQLiteDatabase.CursorFactory) null, 1);
    }

    public static AppSyncSqlHelper create(Context context) {
        return new AppSyncSqlHelper(context);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        Log.d(TAG, "In onCreate for [appsync.db]. Will create tables now");
        sQLiteDatabase.execSQL(DATABASE_CREATE);
        sQLiteDatabase.execSQL(CREATE_KEY_INDEX);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        Log.d(TAG, "In onUpgrade for [appsync.db]. Will drop tables now");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS records");
        onCreate(sQLiteDatabase);
    }

    public AppSyncSqlHelper(Context context, String str) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
    }

    public static AppSyncSqlHelper create(Context context, String str) {
        return new AppSyncSqlHelper(context, str);
    }
}
