package com.amazonaws.mobileconnectors.appsync;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
class AWSAppSyncDeltaSyncSqlHelper extends SQLiteOpenHelper {
    public static final String COLUMN_DELTA_SYNC_KEY = "delta_sync_key";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_LAST_RUN_TIME = "last_run_time";
    private static final String DATABASE_CREATE = String.format("create table %s( %s integer primary key autoincrement, %s text not null, %s Integer);", new Object[]{"delta_sync", "_id", "delta_sync_key", "last_run_time"});
    private static final String DATABASE_NAME = "appsync_deltasync_db";
    private static final int DATABASE_VERSION = 1;
    public static final String TABLE_DELTA_SYNC = "delta_sync";

    public AWSAppSyncDeltaSyncSqlHelper(Context context) {
        super(context, "appsync_deltasync_db", (SQLiteDatabase.CursorFactory) null, 1);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(DATABASE_CREATE);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS delta_sync");
        onCreate(sQLiteDatabase);
    }

    public AWSAppSyncDeltaSyncSqlHelper(Context context, String str) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
    }
}
