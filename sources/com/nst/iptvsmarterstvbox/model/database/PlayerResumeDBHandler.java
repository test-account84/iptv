package com.nst.iptvsmarterstvbox.model.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class PlayerResumeDBHandler extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "iptv_smarters_tv_box_resume_player.db";
    private static final int DATABASE_VERSION = 1;
    private static final String KEY_ID = "id";
    private static final String KEY_STREAM_DURATION = "stream_duration";
    private static final String KEY_STREAM_FINISH = "stream_finish";
    private static final String KEY_STREAM_ID = "streamID";
    private static final String KEY_STREAM_TIME_ELAPSED = "stream_time_elapsed";
    private static final String KEY_TYPE = "type";
    private static final String TABLE_IPTV_RESUME_PLAYER = "iptv_resume_player";
    String CREATE_RESUME_PLAYER_TABLE;
    Context context;
    SQLiteDatabase db;

    public PlayerResumeDBHandler(Context context) {
        super(context, "iptv_smarters_tv_box_resume_player.db", (SQLiteDatabase.CursorFactory) null, 1);
        this.CREATE_RESUME_PLAYER_TABLE = "CREATE TABLE IF NOT EXISTS iptv_resume_player(id INTEGER PRIMARY KEY,type TEXT,streamID TEXT,stream_finish TEXT,stream_time_elapsed TEXT,stream_duration TEXT)";
        this.context = context;
    }

    public void addToResumePlayer(PlayerResumeDBModel playerResumeDBModel, String str) {
        this.db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("type", str);
        contentValues.put("streamID", playerResumeDBModel.getStreamId());
        contentValues.put("stream_finish", Boolean.valueOf(playerResumeDBModel.isStreamFinish()));
        contentValues.put("stream_time_elapsed", Boolean.valueOf(playerResumeDBModel.isStreamFinish()));
        contentValues.put("stream_duration", Boolean.valueOf(playerResumeDBModel.isStreamFinish()));
        this.db.insert("iptv_resume_player", (String) null, contentValues);
        this.db.close();
    }

    public void deleteAndRecreateAllTables() {
        try {
            getReadableDatabase();
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.execSQL("DROP TABLE IF EXISTS iptv_resume_player");
            onCreate(writableDatabase);
            writableDatabase.close();
        } catch (SQLiteDatabaseLockedException | SQLiteException unused) {
            Log.w("msg", "exception");
        }
    }

    public PlayerResumeDBModel getStreamStatus(String str, String str2) {
        try {
            Cursor rawQuery = getReadableDatabase().rawQuery("SELECT * FROM iptv_resume_player WHERE streamID = '" + str + "' AND type = '" + str2 + "'", (String[]) null);
            PlayerResumeDBModel playerResumeDBModel = new PlayerResumeDBModel();
            if (rawQuery.moveToFirst()) {
                do {
                    playerResumeDBModel.setIdAuto(Integer.parseInt(rawQuery.getString(0)));
                    playerResumeDBModel.setEventType(rawQuery.getString(1));
                    playerResumeDBModel.setStreamId(rawQuery.getString(2));
                    playerResumeDBModel.setStreamFinish(Boolean.parseBoolean(rawQuery.getString(3)));
                    playerResumeDBModel.setTimeElapsed(rawQuery.getLong(4));
                    playerResumeDBModel.setStreamDuration(rawQuery.getLong(5));
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
            return playerResumeDBModel;
        } catch (SQLiteDatabaseLockedException | SQLiteException unused) {
            return null;
        }
    }

    public int isStreamAvailable(String str, String str2) {
        try {
            Cursor rawQuery = getReadableDatabase().rawQuery("SELECT  COUNT(*) FROM iptv_resume_player WHERE streamID='" + str + "' AND type='" + str2 + "'", (String[]) null);
            rawQuery.moveToFirst();
            int i = rawQuery.getInt(0);
            rawQuery.close();
            return i;
        } catch (SQLiteDatabaseLockedException | SQLiteException unused) {
            return 0;
        }
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(this.CREATE_RESUME_PLAYER_TABLE);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0071 A[Catch: SQLiteException -> 0x00a8, SQLiteDatabaseLockedException -> 0x00ac, TryCatch #2 {SQLiteException -> 0x00a8, SQLiteDatabaseLockedException -> 0x00ac, blocks: (B:3:0x0005, B:6:0x003e, B:8:0x0044, B:12:0x006b, B:14:0x0071, B:16:0x009e, B:20:0x00a4, B:24:0x005d, B:26:0x0061), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00a2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean updateResumePlayerStatuTimes(java.lang.String r8, java.lang.String r9, boolean r10, long r11, long r13) {
        /*
            r7 = this;
            java.lang.String r0 = "exception"
            java.lang.String r1 = "msg"
            r2 = 0
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: android.database.sqlite.SQLiteException -> La8 android.database.sqlite.SQLiteDatabaseLockedException -> Lac
            r3.<init>()     // Catch: android.database.sqlite.SQLiteException -> La8 android.database.sqlite.SQLiteDatabaseLockedException -> Lac
            java.lang.String r4 = "SELECT rowid FROM iptv_resume_player WHERE type = '"
            r3.append(r4)     // Catch: android.database.sqlite.SQLiteException -> La8 android.database.sqlite.SQLiteDatabaseLockedException -> Lac
            r3.append(r9)     // Catch: android.database.sqlite.SQLiteException -> La8 android.database.sqlite.SQLiteDatabaseLockedException -> Lac
            java.lang.String r9 = "' AND "
            r3.append(r9)     // Catch: android.database.sqlite.SQLiteException -> La8 android.database.sqlite.SQLiteDatabaseLockedException -> Lac
            java.lang.String r9 = "streamID"
            r3.append(r9)     // Catch: android.database.sqlite.SQLiteException -> La8 android.database.sqlite.SQLiteDatabaseLockedException -> Lac
            java.lang.String r9 = " = '"
            r3.append(r9)     // Catch: android.database.sqlite.SQLiteException -> La8 android.database.sqlite.SQLiteDatabaseLockedException -> Lac
            r3.append(r8)     // Catch: android.database.sqlite.SQLiteException -> La8 android.database.sqlite.SQLiteDatabaseLockedException -> Lac
            java.lang.String r8 = "'"
            r3.append(r8)     // Catch: android.database.sqlite.SQLiteException -> La8 android.database.sqlite.SQLiteDatabaseLockedException -> Lac
            java.lang.String r8 = r3.toString()     // Catch: android.database.sqlite.SQLiteException -> La8 android.database.sqlite.SQLiteDatabaseLockedException -> Lac
            r7.getReadableDatabase()     // Catch: android.database.sqlite.SQLiteException -> La8 android.database.sqlite.SQLiteDatabaseLockedException -> Lac
            android.database.sqlite.SQLiteDatabase r9 = r7.getWritableDatabase()     // Catch: android.database.sqlite.SQLiteException -> La8 android.database.sqlite.SQLiteDatabaseLockedException -> Lac
            r3 = 0
            android.database.Cursor r8 = r9.rawQuery(r8, r3)     // Catch: android.database.sqlite.SQLiteException -> La8 android.database.sqlite.SQLiteDatabaseLockedException -> Lac
            r3 = 1
            java.lang.String r4 = ""
            if (r8 == 0) goto L5d
            boolean r5 = r8.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> La8 android.database.sqlite.SQLiteDatabaseLockedException -> Lac
            if (r5 == 0) goto L6a
        L44:
            java.lang.String r5 = "id"
            int r5 = r8.getColumnIndex(r5)     // Catch: android.database.sqlite.SQLiteException -> La8 android.database.sqlite.SQLiteDatabaseLockedException -> Lac
            java.lang.String r5 = r8.getString(r5)     // Catch: android.database.sqlite.SQLiteException -> La8 android.database.sqlite.SQLiteDatabaseLockedException -> Lac
            int r5 = java.lang.Integer.parseInt(r5)     // Catch: android.database.sqlite.SQLiteException -> La8 android.database.sqlite.SQLiteDatabaseLockedException -> Lac
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch: android.database.sqlite.SQLiteException -> La8 android.database.sqlite.SQLiteDatabaseLockedException -> Lac
            boolean r6 = r8.moveToNext()     // Catch: android.database.sqlite.SQLiteException -> La8 android.database.sqlite.SQLiteDatabaseLockedException -> Lac
            if (r6 != 0) goto L44
            goto L6b
        L5d:
            android.content.Context r5 = r7.context     // Catch: android.database.sqlite.SQLiteException -> La8 android.database.sqlite.SQLiteDatabaseLockedException -> Lac
            if (r5 == 0) goto L6a
            java.lang.String r6 = "cursor is null"
            android.widget.Toast r5 = android.widget.Toast.makeText(r5, r6, r3)     // Catch: android.database.sqlite.SQLiteException -> La8 android.database.sqlite.SQLiteDatabaseLockedException -> Lac
            r5.show()     // Catch: android.database.sqlite.SQLiteException -> La8 android.database.sqlite.SQLiteDatabaseLockedException -> Lac
        L6a:
            r5 = r4
        L6b:
            boolean r4 = r5.equals(r4)     // Catch: android.database.sqlite.SQLiteException -> La8 android.database.sqlite.SQLiteDatabaseLockedException -> Lac
            if (r4 != 0) goto La2
            android.content.ContentValues r4 = new android.content.ContentValues     // Catch: android.database.sqlite.SQLiteException -> La8 android.database.sqlite.SQLiteDatabaseLockedException -> Lac
            r4.<init>()     // Catch: android.database.sqlite.SQLiteException -> La8 android.database.sqlite.SQLiteDatabaseLockedException -> Lac
            java.lang.String r6 = "stream_finish"
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r10)     // Catch: android.database.sqlite.SQLiteException -> La8 android.database.sqlite.SQLiteDatabaseLockedException -> Lac
            r4.put(r6, r10)     // Catch: android.database.sqlite.SQLiteException -> La8 android.database.sqlite.SQLiteDatabaseLockedException -> Lac
            java.lang.String r10 = "stream_time_elapsed"
            java.lang.Long r13 = java.lang.Long.valueOf(r13)     // Catch: android.database.sqlite.SQLiteException -> La8 android.database.sqlite.SQLiteDatabaseLockedException -> Lac
            r4.put(r10, r13)     // Catch: android.database.sqlite.SQLiteException -> La8 android.database.sqlite.SQLiteDatabaseLockedException -> Lac
            java.lang.String r10 = "stream_duration"
            java.lang.Long r11 = java.lang.Long.valueOf(r11)     // Catch: android.database.sqlite.SQLiteException -> La8 android.database.sqlite.SQLiteDatabaseLockedException -> Lac
            r4.put(r10, r11)     // Catch: android.database.sqlite.SQLiteException -> La8 android.database.sqlite.SQLiteDatabaseLockedException -> Lac
            java.lang.String r10 = "iptv_resume_player"
            java.lang.String r11 = "id= ?"
            java.lang.String[] r12 = new java.lang.String[]{r5}     // Catch: android.database.sqlite.SQLiteException -> La8 android.database.sqlite.SQLiteDatabaseLockedException -> Lac
            r9.update(r10, r4, r11, r12)     // Catch: android.database.sqlite.SQLiteException -> La8 android.database.sqlite.SQLiteDatabaseLockedException -> Lac
            if (r8 == 0) goto La1
            r8.close()     // Catch: android.database.sqlite.SQLiteException -> La8 android.database.sqlite.SQLiteDatabaseLockedException -> Lac
        La1:
            return r3
        La2:
            if (r8 == 0) goto La7
            r8.close()     // Catch: android.database.sqlite.SQLiteException -> La8 android.database.sqlite.SQLiteDatabaseLockedException -> Lac
        La7:
            return r2
        La8:
            android.util.Log.w(r1, r0)
            return r2
        Lac:
            android.util.Log.w(r1, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.model.database.PlayerResumeDBHandler.updateResumePlayerStatuTimes(java.lang.String, java.lang.String, boolean, long, long):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0071 A[Catch: SQLiteException -> 0x009f, SQLiteDatabaseLockedException -> 0x00a3, TryCatch #2 {SQLiteException -> 0x009f, SQLiteDatabaseLockedException -> 0x00a3, blocks: (B:3:0x0005, B:6:0x003e, B:8:0x0044, B:12:0x006b, B:14:0x0071, B:16:0x0095, B:20:0x009b, B:24:0x005d, B:26:0x0061), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0099  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean updateResumePlayerStatus(java.lang.String r8, java.lang.String r9, boolean r10, long r11) {
        /*
            r7 = this;
            java.lang.String r0 = "exception"
            java.lang.String r1 = "msg"
            r2 = 0
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: android.database.sqlite.SQLiteException -> L9f android.database.sqlite.SQLiteDatabaseLockedException -> La3
            r3.<init>()     // Catch: android.database.sqlite.SQLiteException -> L9f android.database.sqlite.SQLiteDatabaseLockedException -> La3
            java.lang.String r4 = "SELECT rowid FROM iptv_resume_player WHERE type = '"
            r3.append(r4)     // Catch: android.database.sqlite.SQLiteException -> L9f android.database.sqlite.SQLiteDatabaseLockedException -> La3
            r3.append(r9)     // Catch: android.database.sqlite.SQLiteException -> L9f android.database.sqlite.SQLiteDatabaseLockedException -> La3
            java.lang.String r9 = "' AND "
            r3.append(r9)     // Catch: android.database.sqlite.SQLiteException -> L9f android.database.sqlite.SQLiteDatabaseLockedException -> La3
            java.lang.String r9 = "streamID"
            r3.append(r9)     // Catch: android.database.sqlite.SQLiteException -> L9f android.database.sqlite.SQLiteDatabaseLockedException -> La3
            java.lang.String r9 = " = '"
            r3.append(r9)     // Catch: android.database.sqlite.SQLiteException -> L9f android.database.sqlite.SQLiteDatabaseLockedException -> La3
            r3.append(r8)     // Catch: android.database.sqlite.SQLiteException -> L9f android.database.sqlite.SQLiteDatabaseLockedException -> La3
            java.lang.String r8 = "'"
            r3.append(r8)     // Catch: android.database.sqlite.SQLiteException -> L9f android.database.sqlite.SQLiteDatabaseLockedException -> La3
            java.lang.String r8 = r3.toString()     // Catch: android.database.sqlite.SQLiteException -> L9f android.database.sqlite.SQLiteDatabaseLockedException -> La3
            r7.getReadableDatabase()     // Catch: android.database.sqlite.SQLiteException -> L9f android.database.sqlite.SQLiteDatabaseLockedException -> La3
            android.database.sqlite.SQLiteDatabase r9 = r7.getWritableDatabase()     // Catch: android.database.sqlite.SQLiteException -> L9f android.database.sqlite.SQLiteDatabaseLockedException -> La3
            r3 = 0
            android.database.Cursor r8 = r9.rawQuery(r8, r3)     // Catch: android.database.sqlite.SQLiteException -> L9f android.database.sqlite.SQLiteDatabaseLockedException -> La3
            r3 = 1
            java.lang.String r4 = ""
            if (r8 == 0) goto L5d
            boolean r5 = r8.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L9f android.database.sqlite.SQLiteDatabaseLockedException -> La3
            if (r5 == 0) goto L6a
        L44:
            java.lang.String r5 = "id"
            int r5 = r8.getColumnIndex(r5)     // Catch: android.database.sqlite.SQLiteException -> L9f android.database.sqlite.SQLiteDatabaseLockedException -> La3
            java.lang.String r5 = r8.getString(r5)     // Catch: android.database.sqlite.SQLiteException -> L9f android.database.sqlite.SQLiteDatabaseLockedException -> La3
            int r5 = java.lang.Integer.parseInt(r5)     // Catch: android.database.sqlite.SQLiteException -> L9f android.database.sqlite.SQLiteDatabaseLockedException -> La3
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch: android.database.sqlite.SQLiteException -> L9f android.database.sqlite.SQLiteDatabaseLockedException -> La3
            boolean r6 = r8.moveToNext()     // Catch: android.database.sqlite.SQLiteException -> L9f android.database.sqlite.SQLiteDatabaseLockedException -> La3
            if (r6 != 0) goto L44
            goto L6b
        L5d:
            android.content.Context r5 = r7.context     // Catch: android.database.sqlite.SQLiteException -> L9f android.database.sqlite.SQLiteDatabaseLockedException -> La3
            if (r5 == 0) goto L6a
            java.lang.String r6 = "cursor is null"
            android.widget.Toast r5 = android.widget.Toast.makeText(r5, r6, r3)     // Catch: android.database.sqlite.SQLiteException -> L9f android.database.sqlite.SQLiteDatabaseLockedException -> La3
            r5.show()     // Catch: android.database.sqlite.SQLiteException -> L9f android.database.sqlite.SQLiteDatabaseLockedException -> La3
        L6a:
            r5 = r4
        L6b:
            boolean r4 = r5.equals(r4)     // Catch: android.database.sqlite.SQLiteException -> L9f android.database.sqlite.SQLiteDatabaseLockedException -> La3
            if (r4 != 0) goto L99
            android.content.ContentValues r4 = new android.content.ContentValues     // Catch: android.database.sqlite.SQLiteException -> L9f android.database.sqlite.SQLiteDatabaseLockedException -> La3
            r4.<init>()     // Catch: android.database.sqlite.SQLiteException -> L9f android.database.sqlite.SQLiteDatabaseLockedException -> La3
            java.lang.String r6 = "stream_finish"
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r10)     // Catch: android.database.sqlite.SQLiteException -> L9f android.database.sqlite.SQLiteDatabaseLockedException -> La3
            r4.put(r6, r10)     // Catch: android.database.sqlite.SQLiteException -> L9f android.database.sqlite.SQLiteDatabaseLockedException -> La3
            java.lang.String r10 = "stream_time_elapsed"
            java.lang.Long r11 = java.lang.Long.valueOf(r11)     // Catch: android.database.sqlite.SQLiteException -> L9f android.database.sqlite.SQLiteDatabaseLockedException -> La3
            r4.put(r10, r11)     // Catch: android.database.sqlite.SQLiteException -> L9f android.database.sqlite.SQLiteDatabaseLockedException -> La3
            java.lang.String r10 = "iptv_resume_player"
            java.lang.String r11 = "id= ?"
            java.lang.String[] r12 = new java.lang.String[]{r5}     // Catch: android.database.sqlite.SQLiteException -> L9f android.database.sqlite.SQLiteDatabaseLockedException -> La3
            r9.update(r10, r4, r11, r12)     // Catch: android.database.sqlite.SQLiteException -> L9f android.database.sqlite.SQLiteDatabaseLockedException -> La3
            if (r8 == 0) goto L98
            r8.close()     // Catch: android.database.sqlite.SQLiteException -> L9f android.database.sqlite.SQLiteDatabaseLockedException -> La3
        L98:
            return r3
        L99:
            if (r8 == 0) goto L9e
            r8.close()     // Catch: android.database.sqlite.SQLiteException -> L9f android.database.sqlite.SQLiteDatabaseLockedException -> La3
        L9e:
            return r2
        L9f:
            android.util.Log.w(r1, r0)
            return r2
        La3:
            android.util.Log.w(r1, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.model.database.PlayerResumeDBHandler.updateResumePlayerStatus(java.lang.String, java.lang.String, boolean, long):boolean");
    }
}
