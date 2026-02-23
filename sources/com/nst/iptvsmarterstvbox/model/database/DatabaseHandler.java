package com.nst.iptvsmarterstvbox.model.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.nst.iptvsmarterstvbox.model.FavouriteDBModel;
import com.nst.iptvsmarterstvbox.model.LiveStreamsDBModel;
import java.util.ArrayList;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class DatabaseHandler extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "iptv_smarters_tv.db";
    private static final int DATABASE_VERSION = 4;
    private static final String KEY_CATEGORY_ID = "categoryID";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_NUM_LIVE_STREAMS = "num";
    private static final String KEY_STREAM_ID = "streamID";
    private static final String KEY_TYPE = "type";
    private static final String KEY_USER_ID = "user_id_referred";
    private static final String TABLE_IPTV_AVAILABLE_CHANNNELS = "iptv_live_streams";
    private static final String TABLE_IPTV_FAVOURITES = "iptv_favourites";
    private static final String TABLE_ONESTREAM_IPTV_FAVOURITES = "onestream_iptv_favourites";
    private String ALTER_PRODUCTS_TABLE_1;
    private String ALTER_PRODUCTS_TABLE_2;
    private String ALTER_PRODUCTS_TABLE_3;
    String CREATE_ONESTREAM_PRODUCTS_TABLE;
    String CREATE_PRODUCTS_TABLE;
    Context context;
    SQLiteDatabase db;

    public DatabaseHandler(Context context) {
        super(context, "iptv_smarters_tv.db", (SQLiteDatabase.CursorFactory) null, 4);
        this.CREATE_PRODUCTS_TABLE = "CREATE TABLE IF NOT EXISTS iptv_favourites(id INTEGER PRIMARY KEY,type TEXT,streamID TEXT,categoryID TEXT,name TEXT,user_id_referred TEXT,num TEXT)";
        this.CREATE_ONESTREAM_PRODUCTS_TABLE = "CREATE TABLE IF NOT EXISTS onestream_iptv_favourites(id INTEGER PRIMARY KEY,type TEXT,streamID TEXT,categoryID TEXT,name TEXT,user_id_referred TEXT,num TEXT)";
        this.ALTER_PRODUCTS_TABLE_1 = "ALTER TABLE iptv_favourites ADD COLUMN name TEXT;";
        this.ALTER_PRODUCTS_TABLE_2 = "ALTER TABLE iptv_favourites ADD COLUMN user_id_referred TEXT;";
        this.ALTER_PRODUCTS_TABLE_3 = "ALTER TABLE iptv_favourites ADD COLUMN num TEXT;";
        this.context = context;
    }

    public void addFavouritesFromBackup(ArrayList arrayList) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.beginTransaction();
        int userID = SharepreferenceDBHandler.getUserID(this.context);
        try {
            ContentValues contentValues = new ContentValues();
            String currentAPPType = SharepreferenceDBHandler.getCurrentAPPType(this.context);
            for (int i = 0; i < arrayList.size(); i++) {
                contentValues.put("type", ((LiveStreamsDBModel) arrayList.get(i)).getStreamType().equals("movie") ? "vod" : ((LiveStreamsDBModel) arrayList.get(i)).getStreamType());
                contentValues.put("streamID", ((LiveStreamsDBModel) arrayList.get(i)).getStreamId());
                contentValues.put("categoryID", ((LiveStreamsDBModel) arrayList.get(i)).getCategoryId());
                contentValues.put("name", ((LiveStreamsDBModel) arrayList.get(i)).getName());
                contentValues.put("user_id_referred", Integer.valueOf(userID));
                contentValues.put("num", ((LiveStreamsDBModel) arrayList.get(i)).getNum());
                writableDatabase.insert(currentAPPType.equals("onestream_api") ? "onestream_iptv_favourites" : "iptv_favourites", (String) null, contentValues);
            }
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
            writableDatabase.close();
        } catch (SQLiteDatabaseLockedException | Exception unused) {
            writableDatabase.endTransaction();
            Log.w("msg", "exception");
        }
    }

    public void addToFavourite(FavouriteDBModel favouriteDBModel, String str) {
        SQLiteDatabase sQLiteDatabase;
        String str2;
        try {
            this.db = getWritableDatabase();
            String currentAPPType = SharepreferenceDBHandler.getCurrentAPPType(this.context);
            ContentValues contentValues = new ContentValues();
            contentValues.put("type", str);
            if (currentAPPType.equals("onestream_api")) {
                contentValues.put("streamID", favouriteDBModel.getStreamIDOneStream());
            } else {
                contentValues.put("streamID", Integer.valueOf(favouriteDBModel.getStreamID()));
            }
            contentValues.put("categoryID", favouriteDBModel.getCategoryID());
            contentValues.put("name", favouriteDBModel.getName());
            contentValues.put("user_id_referred", Integer.valueOf(favouriteDBModel.getUserID()));
            contentValues.put("num", favouriteDBModel.getNum());
            if (currentAPPType.equals("onestream_api")) {
                sQLiteDatabase = this.db;
                str2 = "onestream_iptv_favourites";
            } else {
                sQLiteDatabase = this.db;
                str2 = "iptv_favourites";
            }
            sQLiteDatabase.insert(str2, (String) null, contentValues);
            this.db.close();
        } catch (SQLiteDatabaseLockedException | SQLiteException unused) {
        }
    }

    public ArrayList checkFavourite(int i, String str, String str2, int i2, String str3) {
        String str4;
        String str5;
        String str6;
        String sb;
        int i3;
        ArrayList arrayList = new ArrayList();
        try {
            try {
                if (SharepreferenceDBHandler.getCurrentAPPType(this.context).equals("onestream_api")) {
                    try {
                        StringBuilder sb2 = new StringBuilder();
                        str6 = "msg";
                        sb2.append("SELECT  * FROM onestream_iptv_favourites WHERE streamID='");
                        sb2.append(str3);
                        sb2.append("' AND ");
                        sb2.append("categoryID");
                        sb2.append("='");
                        sb2.append(str);
                        sb2.append("' AND ");
                        sb2.append("type");
                        sb2.append(" LIKE '%");
                        sb2.append(str2);
                        sb2.append("%'  AND ");
                        sb2.append("user_id_referred");
                        sb2.append("=");
                        sb2.append(i2);
                        sb2.append("");
                        sb = sb2.toString();
                    } catch (SQLiteDatabaseLockedException | Exception unused) {
                        str5 = "msg";
                        str4 = "exception";
                        Log.w(str5, str4);
                        return arrayList;
                    }
                } else {
                    str6 = "msg";
                    sb = "SELECT  * FROM iptv_favourites WHERE streamID='" + i + "' AND categoryID='" + str + "' AND type LIKE '%" + str2 + "%'  AND user_id_referred=" + i2 + "";
                }
                SQLiteDatabase readableDatabase = getReadableDatabase();
                this.db = readableDatabase;
                Cursor rawQuery = readableDatabase.rawQuery(sb, (String[]) null);
                if (rawQuery.moveToFirst()) {
                    do {
                        try {
                            i3 = Integer.parseInt(rawQuery.getString(2));
                        } catch (NumberFormatException unused2) {
                            i3 = -1;
                        }
                        String string = rawQuery.getString(2);
                        FavouriteDBModel favouriteDBModel = new FavouriteDBModel();
                        favouriteDBModel.setId(Integer.parseInt(rawQuery.getString(0)));
                        favouriteDBModel.setType(rawQuery.getString(1));
                        favouriteDBModel.setStreamID(i3);
                        favouriteDBModel.setStreamIDOneStream(string);
                        favouriteDBModel.setCategoryID(rawQuery.getString(3));
                        arrayList.add(favouriteDBModel);
                    } while (rawQuery.moveToNext());
                }
                rawQuery.close();
                return arrayList;
            } catch (SQLiteDatabaseLockedException | Exception unused3) {
                str4 = "exception";
                str5 = str6;
            }
        } catch (SQLiteDatabaseLockedException | Exception unused4) {
            str4 = "exception";
            str5 = "msg";
        }
    }

    public void deleteAndRecreateAllTables() {
        SQLiteDatabase sQLiteDatabase;
        String str;
        this.db = getWritableDatabase();
        if (SharepreferenceDBHandler.getCurrentAPPType(this.context).equals("onestream_api")) {
            sQLiteDatabase = this.db;
            str = "DROP TABLE IF EXISTS onestream_iptv_favourites";
        } else {
            sQLiteDatabase = this.db;
            str = "DROP TABLE IF EXISTS iptv_favourites";
        }
        sQLiteDatabase.execSQL(str);
        onCreate(this.db);
        this.db.close();
    }

    public void deleteDataForUser(int i) {
        SQLiteDatabase sQLiteDatabase;
        String str;
        StringBuilder sb;
        try {
            this.db = getWritableDatabase();
            if (SharepreferenceDBHandler.getCurrentAPPType(this.context).equals("onestream_api")) {
                sQLiteDatabase = this.db;
                str = "onestream_iptv_favourites";
                sb = new StringBuilder();
                sb.append("user_id_referred='");
                sb.append(i);
                sb.append("'");
            } else {
                sQLiteDatabase = this.db;
                str = "iptv_favourites";
                sb = new StringBuilder();
                sb.append("user_id_referred='");
                sb.append(i);
                sb.append("'");
            }
            sQLiteDatabase.delete(str, sb.toString(), (String[]) null);
            this.db.close();
        } catch (SQLiteDatabaseLockedException | Exception unused) {
        }
    }

    public void deleteFavAfterUpdate(String str) {
        StringBuilder sb;
        try {
            int userID = SharepreferenceDBHandler.getUserID(this.context);
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (SharepreferenceDBHandler.getCurrentAPPType(this.context).equals("onestream_api")) {
                sb = new StringBuilder();
                sb.append("DELETE FROM onestream_iptv_favourites WHERE user_id_referred = '");
                sb.append(userID);
                sb.append("' AND ");
                sb.append("streamID");
                sb.append(" IN (");
                sb.append(str);
                sb.append(")");
            } else {
                sb = new StringBuilder();
                sb.append("DELETE FROM iptv_favourites WHERE user_id_referred = '");
                sb.append(userID);
                sb.append("' AND ");
                sb.append("streamID");
                sb.append(" IN (");
                sb.append(str);
                sb.append(")");
            }
            writableDatabase.execSQL(sb.toString());
        } catch (SQLiteDatabaseLockedException | SQLiteException unused) {
        }
    }

    public void deleteFavourite(int i, String str, String str2, String str3, int i2, String str4) {
        try {
            this.db = getWritableDatabase();
            if (SharepreferenceDBHandler.getCurrentAPPType(this.context).equals("onestream_api")) {
                this.db.delete("onestream_iptv_favourites", "streamID='" + str4 + "' AND user_id_referred=" + i2, (String[]) null);
            } else {
                this.db.delete("iptv_favourites", "streamID='" + i + "' AND user_id_referred=" + i2, (String[]) null);
            }
            this.db.close();
        } catch (SQLiteDatabaseLockedException | SQLiteException unused) {
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:81:0x01f7. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x00a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.ArrayList getAllFavourites(java.lang.String r34, int r35) {
        /*
            Method dump skipped, instructions count: 898
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.model.database.DatabaseHandler.getAllFavourites(java.lang.String, int):java.util.ArrayList");
    }

    public ArrayList getAllFavouritesIDString() {
        StringBuilder sb;
        String str;
        int userID = SharepreferenceDBHandler.getUserID(this.context);
        if (SharepreferenceDBHandler.getCurrentAPPType(this.context).equals("onestream_api")) {
            sb = new StringBuilder();
            str = "SELECT GROUP_CONCAT(streamID) AS streamID , type FROM onestream_iptv_favourites WHERE user_id_referred=";
        } else {
            sb = new StringBuilder();
            str = "SELECT GROUP_CONCAT(streamID) AS streamID , type FROM iptv_favourites WHERE user_id_referred=";
        }
        sb.append(str);
        sb.append(userID);
        sb.append(" GROUP BY ");
        sb.append("type");
        String sb2 = sb.toString();
        ArrayList arrayList = new ArrayList();
        try {
            SQLiteDatabase readableDatabase = getReadableDatabase();
            this.db = readableDatabase;
            Cursor rawQuery = readableDatabase.rawQuery(sb2, (String[]) null);
            if (rawQuery.moveToFirst()) {
                do {
                    FavouriteDBModel favouriteDBModel = new FavouriteDBModel();
                    favouriteDBModel.setCommaSeparatedStreamIDs(rawQuery.getString(0));
                    favouriteDBModel.setType(rawQuery.getString(1));
                    arrayList.add(favouriteDBModel);
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
        } catch (SQLiteDatabaseLockedException | SQLiteException unused) {
        }
        return arrayList;
    }

    public ArrayList getAllFavouritesStreamIDs(String str) {
        StringBuilder sb;
        String str2;
        ArrayList arrayList = new ArrayList();
        if (SharepreferenceDBHandler.getCurrentAPPType(this.context).equals("onestream_api")) {
            sb = new StringBuilder();
            str2 = "SELECT  streamID FROM onestream_iptv_favourites WHERE type LIKE '%";
        } else {
            sb = new StringBuilder();
            str2 = "SELECT  streamID FROM iptv_favourites WHERE type LIKE '%";
        }
        sb.append(str2);
        sb.append(str);
        sb.append("%' AND ");
        sb.append("user_id_referred");
        sb.append("=");
        sb.append(SharepreferenceDBHandler.getUserID(this.context));
        sb.append(" ");
        String sb2 = sb.toString();
        try {
            SQLiteDatabase readableDatabase = getReadableDatabase();
            this.db = readableDatabase;
            Cursor rawQuery = readableDatabase.rawQuery(sb2, (String[]) null);
            if (rawQuery.moveToFirst()) {
                do {
                    String str3 = "";
                    FavouriteDBModel favouriteDBModel = new FavouriteDBModel();
                    int i = 0;
                    try {
                        int parseInt = Integer.parseInt(rawQuery.getString(0));
                        str3 = rawQuery.getString(0);
                        i = parseInt;
                    } catch (NumberFormatException unused) {
                    }
                    favouriteDBModel.setStreamID(i);
                    favouriteDBModel.setStreamIDOneStream(str3);
                    arrayList.add(favouriteDBModel);
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
        } catch (SQLiteDatabaseLockedException | SQLiteException unused2) {
        }
        return arrayList;
    }

    public int getFavouriteCount(String str, int i) {
        StringBuilder sb;
        String str2;
        if (SharepreferenceDBHandler.getCurrentAPPType(this.context).equals("onestream_api")) {
            sb = new StringBuilder();
            str2 = "SELECT  COUNT(*) FROM onestream_iptv_favourites WHERE type LIKE '%";
        } else {
            sb = new StringBuilder();
            str2 = "SELECT  COUNT(*) FROM iptv_favourites WHERE type LIKE '%";
        }
        sb.append(str2);
        sb.append(str);
        sb.append("%' AND ");
        sb.append("user_id_referred");
        sb.append("=");
        sb.append(i);
        sb.append("  ");
        try {
            Cursor rawQuery = getReadableDatabase().rawQuery(sb.toString(), (String[]) null);
            rawQuery.moveToFirst();
            int i2 = rawQuery.getInt(0);
            rawQuery.close();
            return i2;
        } catch (SQLiteDatabaseLockedException | SQLiteException unused) {
            return 0;
        }
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        Log.e("fav_oncreate", "asdfasdfsadfa");
        sQLiteDatabase.execSQL(this.CREATE_PRODUCTS_TABLE);
        sQLiteDatabase.execSQL(this.CREATE_ONESTREAM_PRODUCTS_TABLE);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i2 >= 3) {
            sQLiteDatabase.execSQL(this.ALTER_PRODUCTS_TABLE_1);
            sQLiteDatabase.execSQL(this.ALTER_PRODUCTS_TABLE_2);
            sQLiteDatabase.execSQL(this.ALTER_PRODUCTS_TABLE_3);
        }
        if (i < 4) {
            sQLiteDatabase.execSQL(this.CREATE_ONESTREAM_PRODUCTS_TABLE);
        }
    }
}
