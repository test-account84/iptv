package com.amazonaws.mobileconnectors.appsync;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class AppSyncMutationsSqlHelper extends SQLiteOpenHelper {
    public static final String COLUMN_BUCKET = "bucket";
    public static final String COLUMN_CLIENT_STATE = "client_state";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_KEY = "key";
    public static final String COLUMN_LOCAL_URI = "local_uri";
    public static final String COLUMN_MIME_TYPE = "mime_type";
    public static final String COLUMN_RECORD = "record";
    public static final String COLUMN_REGION = "region";
    private static final String DATABASE_NAME = "appsync.mutations.db";
    private static final int DATABASE_VERSION = 2;
    public static final String IDX_RECORDS_KEY = "idx_records_key";
    public static final String RECORD_IDENTIFIER = "record_id";
    public static final String RESPONSE_CLASS = "response_class";
    public static final String TABLE_MUTATION_RECORDS = "mutation_records";
    private static final String DATABASE_CREATE = String.format("create table %s( %s integer primary key autoincrement, %s text not null, %s text not null, %s text not null, %s text not null, %s text, %s text, %s text, %s text, %s text);", new Object[]{"mutation_records", "_id", "record_id", "record", "response_class", "client_state", "bucket", "key", "region", "local_uri", "mime_type"});
    private static final String CREATE_KEY_INDEX = String.format("CREATE INDEX %s ON %s (%s)", new Object[]{"idx_records_key", "mutation_records", "record_id"});

    private AppSyncMutationsSqlHelper(Context context) {
        super(context, "appsync.mutations.db", (SQLiteDatabase.CursorFactory) null, 2);
    }

    public static AppSyncMutationsSqlHelper create(Context context) {
        return new AppSyncMutationsSqlHelper(context);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(DATABASE_CREATE);
        sQLiteDatabase.execSQL(CREATE_KEY_INDEX);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS mutation_records");
        onCreate(sQLiteDatabase);
    }

    public AppSyncMutationsSqlHelper(Context context, String str) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 2);
    }

    public static AppSyncMutationsSqlHelper create(Context context, String str) {
        return new AppSyncMutationsSqlHelper(context, str);
    }
}
