package com.amazonaws.mobileconnectors.appsync;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import java.util.LinkedList;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class AppSyncMutationSqlCacheOperations {
    private final String[] allColumns = {"_id", "record_id", "record", "response_class", "client_state", "bucket", "key", "region", "local_uri", "mime_type"};
    SQLiteDatabase database;
    private final SQLiteOpenHelper dbHelper;
    private final SQLiteStatement deleteAllRecordsStatement;
    private final SQLiteStatement deleteStatement;
    private final SQLiteStatement insertStatement;
    private static final String INSERT_STATEMENT = String.format("INSERT INTO %s (%s,%s,%s,%s,%s,%s,%s,%s,%s) VALUES (?,?,?,?,?,?,?,?,?)", new Object[]{"mutation_records", "record_id", "record", "response_class", "client_state", "bucket", "key", "region", "local_uri", "mime_type"});
    private static final String DELETE_STATEMENT = String.format("DELETE FROM %s WHERE %s=?", new Object[]{"mutation_records", "record_id"});
    private static final String DELETE_ALL_RECORD_STATEMENT = String.format("DELETE FROM %s", new Object[]{"mutation_records"});

    public AppSyncMutationSqlCacheOperations(SQLiteOpenHelper sQLiteOpenHelper) {
        this.dbHelper = sQLiteOpenHelper;
        SQLiteDatabase writableDatabase = sQLiteOpenHelper.getWritableDatabase();
        this.database = writableDatabase;
        this.insertStatement = writableDatabase.compileStatement(INSERT_STATEMENT);
        this.deleteStatement = this.database.compileStatement(DELETE_STATEMENT);
        this.deleteAllRecordsStatement = this.database.compileStatement(DELETE_ALL_RECORD_STATEMENT);
    }

    public void clearCurrentCache() {
        this.deleteAllRecordsStatement.execute();
    }

    public void close() {
        this.dbHelper.close();
    }

    public long createRecord(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        this.insertStatement.bindString(1, str);
        this.insertStatement.bindString(2, str2);
        this.insertStatement.bindString(3, str3);
        this.insertStatement.bindString(4, str4);
        SQLiteStatement sQLiteStatement = this.insertStatement;
        if (str5 == null) {
            str5 = "";
        }
        sQLiteStatement.bindString(5, str5);
        SQLiteStatement sQLiteStatement2 = this.insertStatement;
        if (str6 == null) {
            str6 = "";
        }
        sQLiteStatement2.bindString(6, str6);
        SQLiteStatement sQLiteStatement3 = this.insertStatement;
        if (str7 == null) {
            str7 = "";
        }
        sQLiteStatement3.bindString(7, str7);
        SQLiteStatement sQLiteStatement4 = this.insertStatement;
        if (str8 == null) {
            str8 = "";
        }
        sQLiteStatement4.bindString(8, str8);
        SQLiteStatement sQLiteStatement5 = this.insertStatement;
        if (str9 == null) {
            str9 = "";
        }
        sQLiteStatement5.bindString(9, str9);
        return this.insertStatement.executeInsert();
    }

    public boolean deleteRecord(String str) {
        this.deleteStatement.bindString(1, str);
        return this.deleteStatement.executeUpdateDelete() > 0;
    }

    public List fetchAllRecords() {
        LinkedList linkedList = new LinkedList();
        Cursor cursor = null;
        try {
            cursor = this.database.query("mutation_records", this.allColumns, (String) null, (String[]) null, (String) null, (String) null, "_id");
            if (cursor != null && cursor.moveToFirst()) {
                if (cursor.moveToFirst()) {
                    while (!cursor.isAfterLast()) {
                        linkedList.add(new PersistentOfflineMutationObject(cursor.getString(cursor.getColumnIndex("record_id")), cursor.getString(cursor.getColumnIndex("record")), cursor.getString(cursor.getColumnIndex("response_class")), cursor.getString(cursor.getColumnIndex("client_state")), cursor.getString(cursor.getColumnIndex("bucket")), cursor.getString(cursor.getColumnIndex("key")), cursor.getString(cursor.getColumnIndex("region")), cursor.getString(cursor.getColumnIndex("local_uri")), cursor.getString(cursor.getColumnIndex("mime_type"))));
                        cursor.moveToNext();
                    }
                }
                if (!cursor.isClosed()) {
                    cursor.close();
                }
                return linkedList;
            }
            return linkedList;
        } finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        }
    }
}
