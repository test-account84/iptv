package com.nst.iptvsmarterstvbox.model.database;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.nst.iptvsmarterstvbox.model.MultiUserDBModel;
import java.util.ArrayList;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class MultiUserDBHandler extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "iptv_smarters_multi_user.db";
    private static final int DATABASE_VERSION = 7;
    private static final String KEY_AUTO_ID = "auto_id";
    private static final String KEY_CREATED_AT = "user_created";
    private static final String KEY_EPGURL = "epgurl";
    private static final String KEY_LOGGED_IN_USING = "logged_in_using";
    private static final String KEY_MAC_ADDRESS = "mac_address";
    private static final String KEY_MAGPORTAL = "magportal";
    private static final String KEY_MAGPORTAL2 = "magportal2";
    private static final String KEY_NAME = "name";
    private static final String KEY_PASSWORD = "password";
    private static final String KEY_SERVER_URL = "server_url";
    private static final String KEY_TYPE = "type";
    private static final String KEY_TYPE_OF_M3U = "type_of_m3u";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_USER_ID = "user_id";
    private static final String TABLE_LOGIN = "login_user";
    private static final String TABLE_MULTI_USER = "multi_user";
    private static final String TABLE_MULTI_USER_EPG_M3U = "multi_user_epg_m3u";
    private static final String TABLE_MULTI_USER_M3U = "multi_user_m3u";
    private static final String TABLE_MULTI_USER_STALKER = "multi_user_stalker";
    private String ALTERED_TABLE_MULTIUSER;
    private String ALTERED_TABLE_MULTIUSER2;
    String CREATE_LOGIN_TABLE;
    String CREATE_MULTIUSER_EPG_TABLE;
    String CREATE_MULTIUSER_STALKER_TABLE;
    String CREATE_MULTIUSER_TABLE;
    String CREATE_MULTIUSER_TABLE_M3U;
    Context context;
    SQLiteDatabase db;

    public MultiUserDBHandler(Context context) {
        super(context, "iptv_smarters_multi_user.db", (SQLiteDatabase.CursorFactory) null, 7);
        this.CREATE_LOGIN_TABLE = "CREATE TABLE IF NOT EXISTS login_user(server_url TEXT,user_created TEXT)";
        this.CREATE_MULTIUSER_TABLE = "CREATE TABLE IF NOT EXISTS multi_user(auto_id INTEGER PRIMARY KEY,name TEXT,username TEXT,password TEXT,magportal TEXT,magportal2 TEXT,logged_in_using TEXT)";
        this.CREATE_MULTIUSER_STALKER_TABLE = "CREATE TABLE IF NOT EXISTS multi_user_stalker(auto_id INTEGER PRIMARY KEY,name TEXT,magportal TEXT,mac_address TEXT)";
        this.ALTERED_TABLE_MULTIUSER = "ALTER TABLE multi_user ADD COLUMN magportal2 TEXT;";
        this.ALTERED_TABLE_MULTIUSER2 = "ALTER TABLE multi_user ADD COLUMN logged_in_using TEXT;";
        this.CREATE_MULTIUSER_TABLE_M3U = "CREATE TABLE IF NOT EXISTS multi_user_m3u(auto_id INTEGER PRIMARY KEY,name TEXT,username TEXT,password TEXT,magportal TEXT,type_of_m3u TEXT)";
        this.CREATE_MULTIUSER_EPG_TABLE = "CREATE TABLE IF NOT EXISTS multi_user_epg_m3u(auto_id INTEGER PRIMARY KEY,user_id TEXT,epgurl TEXT)";
        this.context = context;
    }

    public void addmultiusers(String str, String str2, String str3, String str4, String str5, String str6) {
        try {
            this.db = getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("name", str.replaceAll("'", ""));
            contentValues.put("username", str2);
            contentValues.put("password", str3);
            contentValues.put("magportal", str4);
            contentValues.put("magportal2", str5);
            contentValues.put("logged_in_using", str6);
            this.db.insert("multi_user", (String) null, contentValues);
            this.db.close();
        } catch (SQLiteException | SQLiteDatabaseLockedException e) {
            e.printStackTrace();
        }
    }

    public void addmultiusersEPG(String str, String str2) {
        try {
            this.db = getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("user_id", str);
            contentValues.put("epgurl", str2);
            this.db.execSQL("DELETE FROM multi_user_epg_m3u WHERE user_id='" + str + "'");
            this.db.insert("multi_user_epg_m3u", (String) null, contentValues);
            this.db.close();
        } catch (SQLiteDatabaseLockedException | SQLiteException unused) {
        }
    }

    public void addmultiusersM3U(String str, String str2, String str3, String str4, String str5) {
        try {
            this.db = getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("name", str.replaceAll("'", ""));
            contentValues.put("username", str2);
            contentValues.put("password", str3);
            contentValues.put("magportal", str4);
            contentValues.put("type_of_m3u", str5);
            this.db.insert("multi_user_m3u", (String) null, contentValues);
            this.db.close();
        } catch (SQLiteDatabaseLockedException | SQLiteException unused) {
        }
    }

    public void addmultiusersStalker(String str, String str2, String str3) {
        try {
            this.db = getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("name", str.replaceAll("'", ""));
            contentValues.put("magportal", str2);
            contentValues.put("mac_address", str3);
            this.db.insert("multi_user_stalker", (String) null, contentValues);
            this.db.close();
        } catch (SQLiteDatabaseLockedException | Exception unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x015c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x015e A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean checkregistration(java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23) {
        /*
            Method dump skipped, instructions count: 352
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.model.database.MultiUserDBHandler.checkregistration(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0158 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x015a A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean checkregistrationForMultiuserAapter(java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, java.lang.String r24) {
        /*
            Method dump skipped, instructions count: 348
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.model.database.MultiUserDBHandler.checkregistrationForMultiuserAapter(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String):boolean");
    }

    public void deleteSaveLogin() {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        this.db = writableDatabase;
        writableDatabase.execSQL("DELETE FROM login_user");
        this.db.close();
    }

    public void deleteUserAPI(int i) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        this.db = writableDatabase;
        writableDatabase.execSQL("DELETE FROM multi_user WHERE auto_id='" + i + "'");
        this.db.close();
    }

    public void deleteUserM3U(int i) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        this.db = writableDatabase;
        writableDatabase.execSQL("DELETE FROM multi_user_m3u WHERE auto_id='" + i + "'");
        this.db.execSQL("DELETE FROM multi_user_epg_m3u WHERE user_id='" + i + "'");
        this.db.close();
    }

    public void editmultiusersEPG(String str, String str2) {
        this.db = getWritableDatabase();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("epgurl", str2);
            this.db.update("multi_user_epg_m3u", contentValues, "user_id = ?", new String[]{String.valueOf(str)});
            this.db.close();
        } catch (SQLiteDatabaseLockedException | SQLiteException unused) {
        }
    }

    public ArrayList getAllUsers() {
        ArrayList arrayList = new ArrayList();
        try {
            SQLiteDatabase readableDatabase = getReadableDatabase();
            this.db = readableDatabase;
            Cursor rawQuery = readableDatabase.rawQuery("SELECT  * FROM multi_user ORDER BY auto_id DESC", (String[]) null);
            if (rawQuery.moveToFirst()) {
                do {
                    MultiUserDBModel multiUserDBModel = new MultiUserDBModel();
                    multiUserDBModel.setname(rawQuery.getString(1));
                    multiUserDBModel.setusername(rawQuery.getString(2));
                    multiUserDBModel.setpassword(rawQuery.getString(3));
                    multiUserDBModel.setmagportal(rawQuery.getString(4));
                    multiUserDBModel.setmagportal2(rawQuery.getString(5));
                    multiUserDBModel.setLogged_in_using(rawQuery.getString(6));
                    arrayList.add(multiUserDBModel);
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
        } catch (SQLiteDatabaseLockedException | SQLiteException unused) {
        }
        return arrayList;
    }

    public boolean getAllUsersCount() {
        ArrayList arrayList = new ArrayList();
        try {
            SQLiteDatabase readableDatabase = getReadableDatabase();
            this.db = readableDatabase;
            Cursor rawQuery = readableDatabase.rawQuery("SELECT  * FROM multi_user ORDER BY auto_id DESC", (String[]) null);
            if (rawQuery.moveToFirst()) {
                do {
                    MultiUserDBModel multiUserDBModel = new MultiUserDBModel();
                    multiUserDBModel.setname(rawQuery.getString(1));
                    arrayList.add(multiUserDBModel);
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
        } catch (SQLiteDatabaseLockedException | SQLiteException unused) {
        }
        return arrayList.size() > 0;
    }

    public ArrayList getAllUsersM3U() {
        ArrayList arrayList = new ArrayList();
        try {
            SQLiteDatabase readableDatabase = getReadableDatabase();
            this.db = readableDatabase;
            Cursor rawQuery = readableDatabase.rawQuery("SELECT  * FROM multi_user_m3u ORDER BY auto_id DESC", (String[]) null);
            if (rawQuery.moveToFirst()) {
                do {
                    MultiUserDBModel multiUserDBModel = new MultiUserDBModel();
                    multiUserDBModel.setname(rawQuery.getString(1));
                    multiUserDBModel.setusername(rawQuery.getString(2));
                    multiUserDBModel.setpassword(rawQuery.getString(3));
                    multiUserDBModel.setmagportal(rawQuery.getString(4));
                    multiUserDBModel.setM3uType(rawQuery.getString(5));
                    arrayList.add(multiUserDBModel);
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
        } catch (SQLiteDatabaseLockedException | SQLiteException unused) {
        }
        return arrayList;
    }

    public ArrayList getAllUsersStalker() {
        ArrayList arrayList = new ArrayList();
        try {
            SQLiteDatabase readableDatabase = getReadableDatabase();
            this.db = readableDatabase;
            Cursor rawQuery = readableDatabase.rawQuery("SELECT  * FROM multi_user_stalker ORDER BY auto_id DESC", (String[]) null);
            if (rawQuery.moveToFirst()) {
                do {
                    MultiUserDBModel multiUserDBModel = new MultiUserDBModel();
                    multiUserDBModel.setname(rawQuery.getString(1));
                    multiUserDBModel.setmagportal(rawQuery.getString(2));
                    multiUserDBModel.setmacAddress(rawQuery.getString(3));
                    arrayList.add(multiUserDBModel);
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
        } catch (SQLiteDatabaseLockedException | SQLiteException unused) {
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x017c A[Catch: Exception -> 0x002e, SQLiteDatabaseLockedException -> 0x0033, TryCatch #4 {Exception -> 0x002e, SQLiteDatabaseLockedException -> 0x0033, blocks: (B:24:0x0173, B:26:0x017c, B:28:0x0182), top: B:23:0x0173 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0135 A[Catch: Exception -> 0x002c, SQLiteDatabaseLockedException -> 0x0031, TryCatch #3 {Exception -> 0x002c, SQLiteDatabaseLockedException -> 0x0031, blocks: (B:3:0x000a, B:10:0x0022, B:19:0x0065, B:20:0x00b9, B:21:0x016d, B:41:0x00bf, B:42:0x0102, B:43:0x0135, B:45:0x0036, B:48:0x003e), top: B:2:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int getAutoIdLoggedInUser(java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, java.lang.String r24) {
        /*
            Method dump skipped, instructions count: 404
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.model.database.MultiUserDBHandler.getAutoIdLoggedInUser(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String):int");
    }

    @SuppressLint({"Range"})
    public int getAutoIdLoggedInUseroneStream(String str, String str2, String str3, String str4, String str5, String str6) {
        StringBuilder sb;
        Cursor rawQuery;
        try {
            if (str5.equals("m3u")) {
                sb = new StringBuilder();
                sb.append("SELECT auto_id FROM multi_user_m3u WHERE name='");
                sb.append(str);
                sb.append("' AND ");
                sb.append("username");
                sb.append("='");
                sb.append(str2);
                sb.append("' AND ");
                sb.append("password");
                sb.append("='");
                sb.append(str3);
                sb.append("' AND ");
                sb.append("magportal");
                sb.append(" LIKE '%");
                sb.append(str4);
            } else {
                if (!str5.equals("onestream_api")) {
                    sb = new StringBuilder();
                    sb.append("SELECT auto_id FROM multi_user WHERE name='");
                    sb.append(str);
                    sb.append("' AND ");
                    sb.append("username");
                    sb.append("='");
                    sb.append(str2);
                    sb.append("' AND ");
                    sb.append("password");
                    sb.append("='");
                    sb.append(str3);
                    sb.append("' AND (");
                    sb.append("magportal");
                    sb.append(" LIKE '%");
                    sb.append(str4);
                    sb.append("%' OR ");
                    sb.append("magportal2");
                    sb.append(" LIKE '%");
                    sb.append(str6);
                    sb.append("%' )");
                    String sb2 = sb.toString();
                    SQLiteDatabase readableDatabase = getReadableDatabase();
                    this.db = readableDatabase;
                    rawQuery = readableDatabase.rawQuery(sb2, (String[]) null);
                    if (rawQuery == null && rawQuery.moveToFirst()) {
                        int i = rawQuery.getInt(rawQuery.getColumnIndex("auto_id"));
                        rawQuery.close();
                        return i;
                    }
                }
                sb = new StringBuilder();
                sb.append("SELECT auto_id FROM multi_user WHERE name='");
                sb.append(str);
                sb.append("' AND ");
                sb.append("username");
                sb.append("='");
                sb.append(str2);
                sb.append("' AND ");
                sb.append("password");
                sb.append("='");
                sb.append(str3);
                sb.append("' AND ");
                sb.append("magportal");
                sb.append(" LIKE '%");
                sb.append(str4);
            }
            sb.append("%'");
            String sb22 = sb.toString();
            SQLiteDatabase readableDatabase2 = getReadableDatabase();
            this.db = readableDatabase2;
            rawQuery = readableDatabase2.rawQuery(sb22, (String[]) null);
            return rawQuery == null ? -1 : -1;
        } catch (SQLiteDatabaseLockedException | SQLiteException unused) {
            return -1;
        }
    }

    public ArrayList getSaveLoginDate() {
        ArrayList arrayList = new ArrayList();
        SQLiteDatabase readableDatabase = getReadableDatabase();
        this.db = readableDatabase;
        Cursor rawQuery = readableDatabase.rawQuery("SELECT * FROM login_user", (String[]) null);
        if (rawQuery.moveToFirst()) {
            MultiUserDBModel multiUserDBModel = new MultiUserDBModel();
            multiUserDBModel.setServerUrl(rawQuery.getString(0));
            multiUserDBModel.setDate(rawQuery.getString(1));
            arrayList.add(multiUserDBModel);
            rawQuery.close();
        }
        return arrayList;
    }

    public ArrayList getUserDetails(int i) {
        ArrayList arrayList = new ArrayList();
        try {
            SQLiteDatabase readableDatabase = getReadableDatabase();
            this.db = readableDatabase;
            Cursor rawQuery = readableDatabase.rawQuery("SELECT  * FROM multi_user_m3u WHERE auto_id ='" + i + "'", (String[]) null);
            if (rawQuery.moveToFirst()) {
                do {
                    MultiUserDBModel multiUserDBModel = new MultiUserDBModel();
                    multiUserDBModel.setname(rawQuery.getString(1));
                    multiUserDBModel.setusername(rawQuery.getString(2));
                    multiUserDBModel.setpassword(rawQuery.getString(3));
                    multiUserDBModel.setmagportal(rawQuery.getString(4));
                    multiUserDBModel.setM3uType(rawQuery.getString(5));
                    arrayList.add(multiUserDBModel);
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
        } catch (SQLiteDatabaseLockedException | SQLiteException unused) {
        }
        return arrayList;
    }

    public ArrayList getUserDetailsAPI(String str, String str2, String str3, String str4, String str5) {
        ArrayList arrayList = new ArrayList();
        try {
            String str6 = "SELECT  * FROM multi_user WHERE name ='" + str + "' AND username ='" + str2 + "' AND password ='" + str3 + "' AND (magportal LIKE '%" + str4 + "%' OR magportal2 LIKE '%" + str5 + "%' )";
            SQLiteDatabase readableDatabase = getReadableDatabase();
            this.db = readableDatabase;
            Cursor rawQuery = readableDatabase.rawQuery(str6, (String[]) null);
            if (rawQuery.moveToFirst()) {
                do {
                    MultiUserDBModel multiUserDBModel = new MultiUserDBModel();
                    multiUserDBModel.setname(rawQuery.getString(1));
                    multiUserDBModel.setusername(rawQuery.getString(2));
                    multiUserDBModel.setpassword(rawQuery.getString(3));
                    multiUserDBModel.setmagportal(rawQuery.getString(4));
                    multiUserDBModel.setmagportal2(rawQuery.getString(5));
                    arrayList.add(multiUserDBModel);
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
        } catch (SQLiteDatabaseLockedException | SQLiteException unused) {
        }
        return arrayList;
    }

    public ArrayList getUserDetailsM3U(String str, String str2, String str3, String str4) {
        ArrayList arrayList = new ArrayList();
        try {
            String str5 = "SELECT  * FROM multi_user_m3u WHERE name ='" + str + "' AND username ='" + str2 + "' AND password ='" + str3 + "' AND magportal LIKE '%" + str4 + "%'";
            SQLiteDatabase readableDatabase = getReadableDatabase();
            this.db = readableDatabase;
            Cursor rawQuery = readableDatabase.rawQuery(str5, (String[]) null);
            if (rawQuery.moveToFirst()) {
                do {
                    MultiUserDBModel multiUserDBModel = new MultiUserDBModel();
                    multiUserDBModel.setname(rawQuery.getString(1));
                    multiUserDBModel.setusername(rawQuery.getString(2));
                    multiUserDBModel.setpassword(rawQuery.getString(3));
                    multiUserDBModel.setmagportal(rawQuery.getString(4));
                    multiUserDBModel.setM3uType(rawQuery.getString(5));
                    arrayList.add(multiUserDBModel);
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
        } catch (SQLiteDatabaseLockedException | SQLiteException unused) {
        }
        return arrayList;
    }

    public ArrayList getUserDetailsStalkerAPI(int i) {
        ArrayList arrayList = new ArrayList();
        try {
            SQLiteDatabase readableDatabase = getReadableDatabase();
            this.db = readableDatabase;
            Cursor rawQuery = readableDatabase.rawQuery("SELECT  * FROM multi_user_stalker WHERE auto_id ='" + i + "'", (String[]) null);
            if (rawQuery.moveToFirst()) {
                do {
                    MultiUserDBModel multiUserDBModel = new MultiUserDBModel();
                    multiUserDBModel.setname(rawQuery.getString(1));
                    multiUserDBModel.setmagportal(rawQuery.getString(2));
                    multiUserDBModel.setmacAddress(rawQuery.getString(3));
                    arrayList.add(multiUserDBModel);
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
        } catch (SQLiteDatabaseLockedException | SQLiteException unused) {
        }
        return arrayList;
    }

    public String getUserEPG(int i) {
        String str;
        String str2 = "SELECT  * FROM multi_user_epg_m3u WHERE user_id ='" + i + "'";
        try {
            SQLiteDatabase readableDatabase = getReadableDatabase();
            this.db = readableDatabase;
            Cursor rawQuery = readableDatabase.rawQuery(str2, (String[]) null);
            if (rawQuery.getCount() > 0) {
                rawQuery.moveToFirst();
                str = rawQuery.getString(rawQuery.getColumnIndex("epgurl"));
            } else {
                str = "";
            }
            rawQuery.close();
            return str;
        } catch (SQLiteDatabaseLockedException | Exception unused) {
            return "";
        }
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(this.CREATE_MULTIUSER_TABLE);
        sQLiteDatabase.execSQL(this.CREATE_MULTIUSER_EPG_TABLE);
        sQLiteDatabase.execSQL(this.CREATE_MULTIUSER_TABLE_M3U);
        sQLiteDatabase.execSQL(this.CREATE_LOGIN_TABLE);
        sQLiteDatabase.execSQL(this.CREATE_MULTIUSER_STALKER_TABLE);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i < 2) {
            sQLiteDatabase.execSQL(this.CREATE_MULTIUSER_EPG_TABLE);
            sQLiteDatabase.execSQL(this.CREATE_MULTIUSER_TABLE_M3U);
        }
        if (i < 3) {
            sQLiteDatabase.execSQL(this.ALTERED_TABLE_MULTIUSER);
        }
        if (i < 4) {
            sQLiteDatabase.execSQL(this.CREATE_LOGIN_TABLE);
        }
        if (i < 5) {
            sQLiteDatabase.execSQL(this.CREATE_MULTIUSER_STALKER_TABLE);
        }
        if (i < 6) {
            sQLiteDatabase.execSQL(this.ALTERED_TABLE_MULTIUSER2);
        }
    }

    public void saveLoginData(String str, String str2) {
        StringBuilder sb;
        try {
            this.db = getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("server_url", str);
            contentValues.put("user_created", str2);
            this.db.insert("login_user", (String) null, contentValues);
            this.db.close();
        } catch (SQLiteDatabaseLockedException e) {
            e = e;
            sb = new StringBuilder();
            sb.append("");
            sb.append(e);
            Log.d("", sb.toString());
        } catch (SQLiteException e2) {
            e = e2;
            sb = new StringBuilder();
            sb.append("");
            sb.append(e);
            Log.d("", sb.toString());
        }
    }

    public void updateEditMultiUserdetails(int i, String str, String str2, String str3, String str4, String str5) {
        this.db = getWritableDatabase();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("name", str);
            contentValues.put("username", str2);
            contentValues.put("password", str3);
            contentValues.put("magportal", str4);
            contentValues.put("magportal2", str5);
            this.db.update("multi_user", contentValues, "auto_id = ?", new String[]{String.valueOf(i)});
            this.db.close();
        } catch (SQLiteDatabaseLockedException | SQLiteException unused) {
        }
    }

    public void updateMultiUser(int i, String str) {
        this.db = getWritableDatabase();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("magportal2", str);
            this.db.update("multi_user", contentValues, "auto_id = ?", new String[]{String.valueOf(i)});
            this.db.close();
        } catch (SQLiteDatabaseLockedException | SQLiteException unused) {
        }
    }

    public void updateMultiUserNew(int i, String str, String str2) {
        this.db = getWritableDatabase();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("magportal", str);
            contentValues.put("magportal2", str2);
            this.db.update("multi_user", contentValues, "auto_id = ?", new String[]{String.valueOf(i)});
            this.db.close();
        } catch (SQLiteDatabaseLockedException | SQLiteException unused) {
        }
    }

    public void updatemultiusersM3U(int i, String str, String str2, String str3, String str4, String str5) {
        this.db = getWritableDatabase();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("name", str.replaceAll("'", ""));
            contentValues.put("username", str2);
            contentValues.put("password", str3);
            contentValues.put("magportal", str4);
            contentValues.put("type_of_m3u", str5);
            this.db.update("multi_user_m3u", contentValues, "auto_id = ?", new String[]{String.valueOf(i)});
            this.db.close();
        } catch (SQLiteDatabaseLockedException | SQLiteException unused) {
        }
    }
}
