package com.amazonaws.mobileconnectors.s3.transferutility;

import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.text.TextUtils;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
class TransferDBBase {
    private static final String BASE_PATH = "transfers";
    private static final int TRANSFERS = 10;
    private static final int TRANSFER_ID = 20;
    private static final int TRANSFER_PART = 30;
    private static final int TRANSFER_STATE = 40;
    private final Uri contentUri;
    private final Context context;
    private SQLiteDatabase database;
    private final TransferDatabaseHelper databaseHelper;
    private final UriMatcher uriMatcher;
    private static final Log LOGGER = LogFactory.getLog(TransferDBBase.class);
    private static final Object LOCK = new Object();

    public TransferDBBase(Context context) {
        this.context = context;
        String packageName = context.getApplicationContext().getPackageName();
        TransferDatabaseHelper transferDatabaseHelper = new TransferDatabaseHelper(context);
        this.databaseHelper = transferDatabaseHelper;
        this.database = transferDatabaseHelper.getWritableDatabase();
        this.contentUri = Uri.parse("content://" + packageName + "/transfers");
        UriMatcher uriMatcher = new UriMatcher(-1);
        this.uriMatcher = uriMatcher;
        uriMatcher.addURI(packageName, "transfers", 10);
        uriMatcher.addURI(packageName, "transfers/#", 20);
        uriMatcher.addURI(packageName, "transfers/part/#", 30);
        uriMatcher.addURI(packageName, "transfers/state/*", 40);
    }

    private void ensureDatabaseOpen() {
        synchronized (LOCK) {
            try {
                if (!this.database.isOpen()) {
                    this.database = this.databaseHelper.getWritableDatabase();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public int bulkInsert(Uri uri, ContentValues[] contentValuesArr) {
        int match = this.uriMatcher.match(uri);
        ensureDatabaseOpen();
        if (match != 10) {
            throw new IllegalArgumentException("Unknown URI: " + uri);
        }
        int i = 0;
        try {
            try {
                this.database.beginTransaction();
                i = (int) this.database.insertOrThrow("awstransfer", (String) null, contentValuesArr[0]);
                for (int i2 = 1; i2 < contentValuesArr.length; i2++) {
                    contentValuesArr[i2].put("main_upload_id", Integer.valueOf(i));
                    this.database.insertOrThrow("awstransfer", (String) null, contentValuesArr[i2]);
                }
                this.database.setTransactionSuccessful();
            } catch (Exception e) {
                LOGGER.error("bulkInsert error : ", e);
            }
            this.database.endTransaction();
            return i;
        } catch (Throwable th) {
            this.database.endTransaction();
            throw th;
        }
    }

    public void closeDBHelper() {
        this.databaseHelper.close();
    }

    public int delete(Uri uri, String str, String[] strArr) {
        int match = this.uriMatcher.match(uri);
        ensureDatabaseOpen();
        if (match == 10) {
            return this.database.delete("awstransfer", str, strArr);
        }
        if (match != 20) {
            throw new IllegalArgumentException("Unknown URI: " + uri);
        }
        String lastPathSegment = uri.getLastPathSegment();
        if (TextUtils.isEmpty(str)) {
            return this.database.delete("awstransfer", "_id=" + lastPathSegment, (String[]) null);
        }
        return this.database.delete("awstransfer", "_id=" + lastPathSegment + " and " + str, strArr);
    }

    public Uri getContentUri() {
        return this.contentUri;
    }

    public SQLiteDatabase getDatabase() {
        SQLiteDatabase sQLiteDatabase;
        synchronized (LOCK) {
            sQLiteDatabase = this.database;
        }
        return sQLiteDatabase;
    }

    public TransferDatabaseHelper getDatabaseHelper() {
        return this.databaseHelper;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        int match = this.uriMatcher.match(uri);
        ensureDatabaseOpen();
        if (match != 10) {
            throw new IllegalArgumentException("Unknown URI: " + uri);
        }
        return Uri.parse("transfers/" + this.database.insertOrThrow("awstransfer", (String) null, contentValues));
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        String str3;
        StringBuilder sb;
        String str4;
        SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
        sQLiteQueryBuilder.setTables("awstransfer");
        int match = this.uriMatcher.match(uri);
        if (match != 10) {
            if (match == 20) {
                sb = new StringBuilder();
                str4 = "_id=";
            } else {
                if (match != 30) {
                    if (match == 40) {
                        sQLiteQueryBuilder.appendWhere("state=");
                        sQLiteQueryBuilder.appendWhereEscapeString(uri.getLastPathSegment());
                        ensureDatabaseOpen();
                        return sQLiteQueryBuilder.query(this.database, strArr, str, strArr2, (String) null, (String) null, str2);
                    }
                    throw new IllegalArgumentException("Unknown URI: " + uri);
                }
                sb = new StringBuilder();
                str4 = "main_upload_id=";
            }
            sb.append(str4);
            sb.append(uri.getLastPathSegment());
            str3 = sb.toString();
        } else {
            str3 = "part_num=0";
        }
        sQLiteQueryBuilder.appendWhere(str3);
        ensureDatabaseOpen();
        return sQLiteQueryBuilder.query(this.database, strArr, str, strArr2, (String) null, (String) null, str2);
    }

    public synchronized int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        int update;
        try {
            int match = this.uriMatcher.match(uri);
            ensureDatabaseOpen();
            if (match == 10) {
                update = this.database.update("awstransfer", contentValues, str, strArr);
            } else {
                if (match != 20) {
                    throw new IllegalArgumentException("Unknown URI: " + uri);
                }
                String lastPathSegment = uri.getLastPathSegment();
                if (TextUtils.isEmpty(str)) {
                    update = this.database.update("awstransfer", contentValues, "_id=" + lastPathSegment, (String[]) null);
                } else {
                    update = this.database.update("awstransfer", contentValues, "_id=" + lastPathSegment + " and " + str, strArr);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return update;
    }
}
