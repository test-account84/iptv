package com.amazonaws.mobileconnectors.appsync;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
final class AWSAppSyncDeltaSyncDBOperations {
    private final String[] allColumns = {"_id", "delta_sync_key", "last_run_time"};
    private final SQLiteDatabase database;
    private final SQLiteOpenHelper dbHelper;
    private final SQLiteStatement deleteAllRecordsStatement;
    private final SQLiteStatement deleteStatement;
    private final SQLiteStatement getRecordByID;
    private final SQLiteStatement getRecordByKey;
    private final SQLiteStatement insertStatement;
    private final SQLiteStatement updateLastRunTimeStatement;
    private static final String INSERT_STATEMENT = String.format("INSERT INTO %S ( %s, %s) VALUES (?,?)", new Object[]{"delta_sync", "delta_sync_key", "last_run_time"});
    private static final String DELETE_STATEMENT = String.format("DELETE FROM %s WHERE %s = ?", new Object[]{"delta_sync", "_id"});
    private static final String DELETE_ALL_RECORD_STATEMENT = String.format("DELETE FROM %s", new Object[]{"delta_sync"});
    private static final String UPDATE_LAST_RUN_TIME = String.format("UPDATE %s set %s = ? WHERE %s = ?", new Object[]{"delta_sync", "last_run_time", "_id"});
    private static final String GET_RECORD_BY_ID = String.format("SELECT * FROM %s WHERE %s = ?", new Object[]{"delta_sync", "_id"});
    private static final String GET_RECORD_BY_KEY = String.format("SELECT * FROM %s WHERE %s = ?", new Object[]{"delta_sync", "delta_sync_key"});

    public final class DeltaSyncRecord {
        long id;
        String key;
        long lastRunTimeInMilliSeconds;

        public DeltaSyncRecord() {
        }
    }

    public AWSAppSyncDeltaSyncDBOperations(SQLiteOpenHelper sQLiteOpenHelper) {
        this.dbHelper = sQLiteOpenHelper;
        SQLiteDatabase writableDatabase = sQLiteOpenHelper.getWritableDatabase();
        this.database = writableDatabase;
        this.insertStatement = writableDatabase.compileStatement(INSERT_STATEMENT);
        this.deleteStatement = writableDatabase.compileStatement(DELETE_STATEMENT);
        this.deleteAllRecordsStatement = writableDatabase.compileStatement(DELETE_ALL_RECORD_STATEMENT);
        this.updateLastRunTimeStatement = writableDatabase.compileStatement(UPDATE_LAST_RUN_TIME);
        this.getRecordByID = writableDatabase.compileStatement(GET_RECORD_BY_ID);
        this.getRecordByKey = writableDatabase.compileStatement(GET_RECORD_BY_KEY);
    }

    public void clearDeltaSyncStore() {
        this.deleteAllRecordsStatement.execute();
    }

    public void close() {
        this.dbHelper.close();
    }

    public long createRecord(String str, long j) {
        this.insertStatement.bindString(1, str);
        this.insertStatement.bindLong(2, j);
        return this.insertStatement.executeInsert();
    }

    public boolean deleteRecord(Long l) {
        this.deleteStatement.bindLong(1, l.longValue());
        return this.deleteStatement.executeUpdateDelete() > 0;
    }

    public DeltaSyncRecord getRecordByID(long j) {
        Cursor cursor = null;
        try {
            Cursor query = this.database.query("delta_sync", this.allColumns, "_id = ?", new String[]{"" + j}, (String) null, (String) null, (String) null);
            if (query != null) {
                try {
                    if (query.getCount() > 0 && query.moveToNext()) {
                        query.getLong(query.getColumnIndex("_id"));
                        throw null;
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor = query;
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (query != null && !query.isClosed()) {
                query.close();
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public DeltaSyncRecord getRecordByKey(String str) {
        Throwable th;
        Cursor cursor;
        DeltaSyncRecord deltaSyncRecord = null;
        try {
            cursor = this.database.query("delta_sync", this.allColumns, "delta_sync_key = ?", new String[]{str}, (String) null, (String) null, (String) null);
            if (cursor != null) {
                try {
                    if (cursor.getCount() > 0 && cursor.moveToNext()) {
                        deltaSyncRecord = new DeltaSyncRecord();
                        deltaSyncRecord.id = cursor.getLong(cursor.getColumnIndex("_id"));
                        deltaSyncRecord.key = cursor.getString(cursor.getColumnIndex("delta_sync_key"));
                        deltaSyncRecord.lastRunTimeInMilliSeconds = cursor.getLong(cursor.getColumnIndex("last_run_time"));
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            return deltaSyncRecord;
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
        }
    }

    public void updateLastRunTime(long j, long j2) {
        this.updateLastRunTimeStatement.bindLong(1, j2);
        this.updateLastRunTimeStatement.bindLong(2, j);
        this.updateLastRunTimeStatement.executeUpdateDelete();
    }
}
