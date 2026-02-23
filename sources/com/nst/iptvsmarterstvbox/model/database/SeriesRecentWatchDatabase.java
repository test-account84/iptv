package com.nst.iptvsmarterstvbox.model.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.nst.iptvsmarterstvbox.model.callback.GetEpisdoeDetailsCallback;
import java.util.ArrayList;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class SeriesRecentWatchDatabase extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "iptv_series_recent_watch.db";
    private static final int DATABASE_VERSION = 3;
    private static final String KEY_CAT_ID = "cat_id";
    private static final String KEY_ELAPSED_TIME = "elapsed_time";
    private static final String KEY_SERIES_ID = "series_id";
    private static final String KEY_USER_ID = "user_id_referred";
    private static final String TABLE_SERIES_RECENT_WATCH = "iptv_series_recent_watch";
    private static final String TABLE_SERIES_RECENT_WATCH_ONESTREAM = "iptv_series_recent_watch_onestream";
    private String ALTER_EPISODE_DURATION_SEC_KEY;
    private String ALTER_EPISODE_NUM_KEY;
    private String ALTER_SEASON_NUM_KEY;
    private String ALTER_SERIES_KEY_IS_RECENT_WATCHED;
    private String ALTER_SERIES_MAIN_IMG;
    private String ALTER_SERIES_NAME_KEY;
    private String ALTER_SERIES_NUM_KEY;
    String CREATE_SERIES_RECENT_WATCH;
    String CREATE_SERIES_RECENT_WATCH_ONESTREAM;
    public final String KEY_ADDED;
    public String KEY_ContainerExtension;
    public final String KEY_EPISODE_DURATION_SEC;
    public String KEY_EPISODE_ICON;
    private final String KEY_EPISODE_ID;
    public String KEY_EPISODE_NAME;
    public final String KEY_EPISODE_NUM;
    private final String KEY_ID;
    public final String KEY_IS_RECENT_WATCHED;
    public final String KEY_LINKS;
    public final String KEY_SEASON_NUM;
    public final String KEY_SERIES_NAME;
    public final String KEY_SERIES_NUM;
    public final String SERIES_BACK;
    public final String SERIES_COVER;
    public final String SERIES_MAIN_IMG;
    Context context;
    SQLiteDatabase db;

    public SeriesRecentWatchDatabase(Context context) {
        super(context, "iptv_series_recent_watch.db", (SQLiteDatabase.CursorFactory) null, 3);
        this.KEY_ID = "id";
        this.KEY_EPISODE_ID = "episode_id";
        this.KEY_EPISODE_NAME = "episode_name";
        this.KEY_ContainerExtension = "containerExtension";
        this.KEY_ADDED = "added";
        this.SERIES_COVER = "cover";
        this.SERIES_BACK = "image";
        this.KEY_EPISODE_ICON = "episode_icon";
        this.SERIES_MAIN_IMG = "series_main_image";
        this.KEY_IS_RECENT_WATCHED = "is_recent_watched";
        this.KEY_SERIES_NUM = "series_num";
        this.KEY_SEASON_NUM = "season_num";
        this.KEY_EPISODE_NUM = "episode_num";
        this.KEY_SERIES_NAME = "series_name";
        this.KEY_EPISODE_DURATION_SEC = "episode_duration_sec";
        this.KEY_LINKS = "episode_link";
        this.CREATE_SERIES_RECENT_WATCH_ONESTREAM = "CREATE TABLE IF NOT EXISTS iptv_series_recent_watch_onestream(id INTEGER PRIMARY KEY,episode_id TEXT," + this.KEY_EPISODE_NAME + " TEXT," + this.KEY_ContainerExtension + " TEXT,added TEXT," + this.KEY_EPISODE_ICON + " TEXT,series_id TEXT,user_id_referred TEXT,elapsed_time TEXT,cat_id TEXT,cover TEXT,image TEXT,series_main_image TEXT,is_recent_watched TEXT,series_num TEXT,season_num TEXT,episode_num TEXT,series_name TEXT,episode_duration_sec TEXT,episode_link TEXT)";
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE IF NOT EXISTS iptv_series_recent_watch(id INTEGER PRIMARY KEY,episode_id TEXT,");
        sb.append(this.KEY_EPISODE_NAME);
        sb.append(" TEXT,");
        sb.append(this.KEY_ContainerExtension);
        sb.append(" TEXT,");
        sb.append("added");
        sb.append(" TEXT,");
        sb.append(this.KEY_EPISODE_ICON);
        sb.append(" TEXT,");
        sb.append("series_id");
        sb.append(" TEXT,");
        sb.append("user_id_referred");
        sb.append(" TEXT,");
        sb.append("elapsed_time");
        sb.append(" TEXT,");
        sb.append("cat_id");
        sb.append(" TEXT,");
        sb.append("cover");
        sb.append(" TEXT,");
        sb.append("image");
        sb.append(" TEXT,");
        sb.append("series_main_image");
        sb.append(" TEXT,");
        sb.append("is_recent_watched");
        sb.append(" TEXT,");
        sb.append("series_num");
        sb.append(" TEXT,");
        sb.append("season_num");
        sb.append(" TEXT,");
        sb.append("episode_num");
        sb.append(" TEXT,");
        sb.append("series_name");
        sb.append(" TEXT,");
        sb.append("episode_duration_sec");
        sb.append(" TEXT)");
        this.CREATE_SERIES_RECENT_WATCH = sb.toString();
        this.ALTER_SERIES_MAIN_IMG = "ALTER TABLE iptv_series_recent_watch ADD COLUMN series_main_image TEXT;";
        this.ALTER_SERIES_KEY_IS_RECENT_WATCHED = "ALTER TABLE iptv_series_recent_watch ADD COLUMN is_recent_watched TEXT;";
        this.ALTER_SERIES_NUM_KEY = "ALTER TABLE iptv_series_recent_watch ADD COLUMN series_num TEXT;";
        this.ALTER_SEASON_NUM_KEY = "ALTER TABLE iptv_series_recent_watch ADD COLUMN season_num TEXT;";
        this.ALTER_EPISODE_NUM_KEY = "ALTER TABLE iptv_series_recent_watch ADD COLUMN episode_num TEXT;";
        this.ALTER_SERIES_NAME_KEY = "ALTER TABLE iptv_series_recent_watch ADD COLUMN series_name TEXT;";
        this.ALTER_EPISODE_DURATION_SEC_KEY = "ALTER TABLE iptv_series_recent_watch ADD COLUMN episode_duration_sec TEXT;";
        this.context = context;
    }

    public void addAllSeriesRecentWatch(GetEpisdoeDetailsCallback getEpisdoeDetailsCallback) {
        String str;
        int userID = SharepreferenceDBHandler.getUserID(this.context);
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.beginTransaction();
            ContentValues contentValues = new ContentValues();
            if (getEpisdoeDetailsCallback.getId() != null) {
                contentValues.put("episode_id", getEpisdoeDetailsCallback.getId());
            } else {
                contentValues.put("episode_id", "");
            }
            if (getEpisdoeDetailsCallback.getTitle() != null) {
                contentValues.put(this.KEY_EPISODE_NAME, getEpisdoeDetailsCallback.getTitle());
            } else {
                contentValues.put(this.KEY_EPISODE_NAME, "");
            }
            if (getEpisdoeDetailsCallback.getContainerExtension() != null) {
                contentValues.put(this.KEY_ContainerExtension, getEpisdoeDetailsCallback.getContainerExtension());
            } else {
                contentValues.put(this.KEY_ContainerExtension, "");
            }
            if (getEpisdoeDetailsCallback.getAdded() != null) {
                contentValues.put("added", getEpisdoeDetailsCallback.getAdded());
            } else {
                contentValues.put("added", "");
            }
            if (getEpisdoeDetailsCallback.getElapsed_time() != null) {
                contentValues.put("elapsed_time", getEpisdoeDetailsCallback.getElapsed_time());
            } else {
                contentValues.put("elapsed_time", "");
            }
            if (getEpisdoeDetailsCallback.getSeriesCover() != null) {
                contentValues.put(this.KEY_EPISODE_ICON, getEpisdoeDetailsCallback.getSeriesCover());
            } else {
                contentValues.put(this.KEY_EPISODE_ICON, "");
            }
            contentValues.put("user_id_referred", Integer.valueOf(userID));
            contentValues.put("cat_id", getEpisdoeDetailsCallback.getCategoryId());
            contentValues.put("series_id", getEpisdoeDetailsCallback.getSeriesId());
            if (getEpisdoeDetailsCallback.getImage() != null) {
                contentValues.put("cover", getEpisdoeDetailsCallback.getImage());
            } else {
                contentValues.put("cover", "");
            }
            if (getEpisdoeDetailsCallback.getMovieImage() != null) {
                contentValues.put("image", getEpisdoeDetailsCallback.getMovieImage());
            } else {
                contentValues.put("image", "");
            }
            if (getEpisdoeDetailsCallback.getMainSeriesImg() != null) {
                contentValues.put("series_main_image", getEpisdoeDetailsCallback.getMainSeriesImg());
            } else {
                contentValues.put("series_main_image", "");
            }
            contentValues.put("is_recent_watched", "1");
            if (getEpisdoeDetailsCallback.getSeriesNum() != null) {
                contentValues.put("series_num", getEpisdoeDetailsCallback.getSeriesNum());
            } else {
                contentValues.put("series_num", "");
            }
            if (getEpisdoeDetailsCallback.getSeasonNumber() != null) {
                contentValues.put("season_num", getEpisdoeDetailsCallback.getSeasonNumber());
            } else {
                contentValues.put("season_num", "");
            }
            if (getEpisdoeDetailsCallback.getEpisodeNumber() != null) {
                contentValues.put("episode_num", getEpisdoeDetailsCallback.getEpisodeNumber());
            } else {
                contentValues.put("episode_num", "");
            }
            if (getEpisdoeDetailsCallback.getSeriesName() != null) {
                contentValues.put("series_name", getEpisdoeDetailsCallback.getSeriesName());
            } else {
                contentValues.put("series_name", "");
            }
            if (getEpisdoeDetailsCallback.getDurationSec() != null) {
                contentValues.put("episode_duration_sec", getEpisdoeDetailsCallback.getDurationSec());
            } else {
                contentValues.put("episode_duration_sec", "");
            }
            if (SharepreferenceDBHandler.getCurrentAPPType(this.context).equals("onestream_api")) {
                if (getEpisdoeDetailsCallback.getLinks() != null) {
                    contentValues.put("episode_link", getEpisdoeDetailsCallback.getLinks());
                } else {
                    contentValues.put("episode_link", "");
                }
                str = "iptv_series_recent_watch_onestream";
            } else {
                str = "iptv_series_recent_watch";
            }
            writableDatabase.insert(str, (String) null, contentValues);
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
            writableDatabase.close();
        } catch (SQLiteDatabaseLockedException | SQLiteException unused) {
            Log.w("msg", "exception");
        }
    }

    public void addAllSeriesRecentWatchBackup(ArrayList arrayList) {
        String str;
        int userID = SharepreferenceDBHandler.getUserID(this.context);
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.beginTransaction();
            ContentValues contentValues = new ContentValues();
            for (int i = 0; i < arrayList.size(); i++) {
                contentValues.put("episode_id", ((GetEpisdoeDetailsCallback) arrayList.get(i)).getId());
                contentValues.put(this.KEY_EPISODE_NAME, ((GetEpisdoeDetailsCallback) arrayList.get(i)).getTitle());
                contentValues.put(this.KEY_ContainerExtension, ((GetEpisdoeDetailsCallback) arrayList.get(i)).getContainerExtension());
                contentValues.put("added", ((GetEpisdoeDetailsCallback) arrayList.get(i)).getAdded());
                contentValues.put("elapsed_time", ((GetEpisdoeDetailsCallback) arrayList.get(i)).getElapsed_time());
                contentValues.put(this.KEY_EPISODE_ICON, ((GetEpisdoeDetailsCallback) arrayList.get(i)).getSeriesCover());
                contentValues.put("user_id_referred", Integer.valueOf(userID));
                contentValues.put("cat_id", ((GetEpisdoeDetailsCallback) arrayList.get(i)).getCategoryId());
                contentValues.put("series_id", ((GetEpisdoeDetailsCallback) arrayList.get(i)).getSeriesId());
                contentValues.put("cover", ((GetEpisdoeDetailsCallback) arrayList.get(i)).getImage());
                contentValues.put("image", ((GetEpisdoeDetailsCallback) arrayList.get(i)).getMovieImage());
                contentValues.put("series_main_image", ((GetEpisdoeDetailsCallback) arrayList.get(i)).getMainSeriesImg());
                contentValues.put("is_recent_watched", ((GetEpisdoeDetailsCallback) arrayList.get(i)).getIsRecentlyWatched());
                contentValues.put("series_num", ((GetEpisdoeDetailsCallback) arrayList.get(i)).getSeriesNum());
                contentValues.put("season_num", ((GetEpisdoeDetailsCallback) arrayList.get(i)).getSeasonNumber());
                contentValues.put("episode_num", ((GetEpisdoeDetailsCallback) arrayList.get(i)).getEpisodeNumber());
                contentValues.put("series_name", ((GetEpisdoeDetailsCallback) arrayList.get(i)).getSeriesName());
                contentValues.put("episode_duration_sec", ((GetEpisdoeDetailsCallback) arrayList.get(i)).getDurationSec());
                if (SharepreferenceDBHandler.getCurrentAPPType(this.context).equals("onestream_api")) {
                    contentValues.put("episode_link", ((GetEpisdoeDetailsCallback) arrayList.get(i)).getLinks());
                    str = "iptv_series_recent_watch_onestream";
                } else {
                    str = "iptv_series_recent_watch";
                }
                writableDatabase.insert(str, (String) null, contentValues);
            }
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
            writableDatabase.close();
        } catch (SQLiteDatabaseLockedException | Exception unused) {
            Log.w("msg", "exception");
        }
    }

    public void deleteALLSeriesRecentwatch() {
        SQLiteDatabase sQLiteDatabase;
        String str;
        String str2;
        int userID = SharepreferenceDBHandler.getUserID(this.context);
        this.db = getWritableDatabase();
        if (SharepreferenceDBHandler.getCurrentAPPType(this.context).equals("onestream_api")) {
            sQLiteDatabase = this.db;
            str = "user_id_referred=" + userID + "";
            str2 = "iptv_series_recent_watch_onestream";
        } else {
            sQLiteDatabase = this.db;
            str = "user_id_referred=" + userID + "";
            str2 = "iptv_series_recent_watch";
        }
        sQLiteDatabase.delete(str2, str, (String[]) null);
        this.db.close();
    }

    public void deleteAndRecreateAllTables() {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.execSQL(SharepreferenceDBHandler.getCurrentAPPType(this.context).equals("onestream_api") ? "DROP TABLE IF EXISTS iptv_series_recent_watch_onestream" : "DROP TABLE IF EXISTS iptv_series_recent_watch");
            onCreate(writableDatabase);
            writableDatabase.close();
        } catch (SQLiteDatabaseLockedException | SQLiteException unused) {
            Log.w("msg", "exception");
        }
    }

    public void deleteContinueWatchingAfterUpdate(String str) {
        StringBuilder sb;
        try {
            int userID = SharepreferenceDBHandler.getUserID(this.context);
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (SharepreferenceDBHandler.getCurrentAPPType(this.context).equals("onestream_api")) {
                sb = new StringBuilder();
                sb.append("DELETE FROM iptv_series_recent_watch_onestream WHERE user_id_referred = '");
                sb.append(userID);
                sb.append("' AND ");
                sb.append("series_id");
                sb.append(" IN (");
                sb.append(str);
                sb.append(")");
            } else {
                sb = new StringBuilder();
                sb.append("DELETE FROM iptv_series_recent_watch WHERE user_id_referred = '");
                sb.append(userID);
                sb.append("' AND ");
                sb.append("series_id");
                sb.append(" IN (");
                sb.append(str);
                sb.append(")");
            }
            writableDatabase.execSQL(sb.toString());
        } catch (SQLiteDatabaseLockedException | SQLiteException unused) {
        }
    }

    public void deleteSeriesRecentwatch(String str) {
        SQLiteDatabase sQLiteDatabase;
        String str2;
        StringBuilder sb;
        try {
            int userID = SharepreferenceDBHandler.getUserID(this.context);
            this.db = getWritableDatabase();
            if (SharepreferenceDBHandler.getCurrentAPPType(this.context).equals("onestream_api")) {
                sQLiteDatabase = this.db;
                str2 = "iptv_series_recent_watch_onestream";
                sb = new StringBuilder();
                sb.append("episode_id='");
                sb.append(str);
                sb.append("'  AND  ");
                sb.append("user_id_referred");
                sb.append("=");
                sb.append(userID);
                sb.append("");
            } else {
                sQLiteDatabase = this.db;
                str2 = "iptv_series_recent_watch";
                sb = new StringBuilder();
                sb.append("episode_id='");
                sb.append(str);
                sb.append("'  AND  ");
                sb.append("user_id_referred");
                sb.append("=");
                sb.append(userID);
                sb.append("");
            }
            sQLiteDatabase.delete(str2, sb.toString(), (String[]) null);
            this.db.close();
        } catch (Exception unused) {
        }
    }

    public ArrayList getAllSeriesContinueWatchingSeriesIDs() {
        StringBuilder sb;
        String str;
        if (SharepreferenceDBHandler.getCurrentAPPType(this.context).equals("onestream_api")) {
            sb = new StringBuilder();
            str = "SELECT series_id FROM iptv_series_recent_watch_onestream WHERE user_id_referred=";
        } else {
            sb = new StringBuilder();
            str = "SELECT series_id FROM iptv_series_recent_watch WHERE user_id_referred=";
        }
        sb.append(str);
        sb.append(SharepreferenceDBHandler.getUserID(this.context));
        sb.append(" ");
        try {
            Cursor rawQuery = getReadableDatabase().rawQuery(sb.toString(), (String[]) null);
            ArrayList arrayList = new ArrayList();
            if (rawQuery.moveToFirst()) {
                do {
                    int i = 0;
                    try {
                        i = Integer.parseInt(rawQuery.getString(0));
                    } catch (NumberFormatException unused) {
                    }
                    GetEpisdoeDetailsCallback getEpisdoeDetailsCallback = new GetEpisdoeDetailsCallback();
                    getEpisdoeDetailsCallback.setSeriesId(String.valueOf(i));
                    arrayList.add(getEpisdoeDetailsCallback);
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
            return arrayList;
        } catch (SQLiteDatabaseLockedException | SQLiteException unused2) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0091 A[Catch: SQLiteDatabaseLockedException | SQLiteException -> 0x0153, LOOP:0: B:11:0x0091->B:17:?, LOOP_START, TryCatch #0 {SQLiteDatabaseLockedException | SQLiteException -> 0x0153, blocks: (B:9:0x0083, B:11:0x0091, B:13:0x013d, B:14:0x0146, B:18:0x014f), top: B:8:0x0083 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.ArrayList getAllSeriesContiueWatching(java.lang.String r13, java.lang.String r14) {
        /*
            Method dump skipped, instructions count: 340
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.model.database.SeriesRecentWatchDatabase.getAllSeriesContiueWatching(java.lang.String, java.lang.String):java.util.ArrayList");
    }

    public ArrayList getAllSeriesContiueWatchingforBackup() {
        StringBuilder sb;
        String str;
        ArrayList arrayList;
        int userID = SharepreferenceDBHandler.getUserID(this.context);
        ArrayList arrayList2 = new ArrayList();
        Object obj = "onestream_api";
        if (SharepreferenceDBHandler.getCurrentAPPType(this.context).equals("onestream_api")) {
            sb = new StringBuilder();
            sb.append("SELECT  episode_id,");
            sb.append(this.KEY_EPISODE_NAME);
            sb.append(",");
            sb.append(this.KEY_ContainerExtension);
            sb.append(",");
            sb.append("added");
            sb.append(",");
            sb.append("elapsed_time");
            sb.append(",");
            sb.append("image");
            sb.append(",");
            sb.append("series_main_image");
            sb.append(",");
            sb.append("is_recent_watched");
            sb.append(",");
            sb.append("season_num");
            sb.append(",");
            sb.append("episode_num");
            sb.append(",");
            sb.append("episode_duration_sec");
            sb.append(",");
            sb.append("series_id");
            sb.append(",");
            sb.append("episode_link");
            sb.append(" FROM ");
            sb.append("iptv_series_recent_watch_onestream");
            sb.append(" WHERE ");
            sb.append("user_id_referred");
            sb.append("=");
            sb.append(userID);
            str = "";
        } else {
            sb = new StringBuilder();
            sb.append("SELECT  episode_id,");
            sb.append(this.KEY_EPISODE_NAME);
            sb.append(",");
            sb.append(this.KEY_ContainerExtension);
            sb.append(",");
            sb.append("added");
            sb.append(",");
            sb.append("elapsed_time");
            sb.append(",");
            sb.append("image");
            sb.append(",");
            sb.append("series_main_image");
            sb.append(",");
            sb.append("is_recent_watched");
            sb.append(",");
            sb.append("season_num");
            sb.append(",");
            sb.append("episode_num");
            sb.append(",");
            sb.append("episode_duration_sec");
            sb.append(",");
            sb.append("series_id");
            sb.append(" FROM ");
            sb.append("iptv_series_recent_watch");
            sb.append(" WHERE ");
            sb.append("user_id_referred");
            sb.append("=");
            sb.append(userID);
            str = "";
        }
        sb.append(str);
        try {
            Cursor rawQuery = getReadableDatabase().rawQuery(sb.toString(), (String[]) null);
            if (rawQuery.moveToFirst()) {
                while (true) {
                    GetEpisdoeDetailsCallback getEpisdoeDetailsCallback = new GetEpisdoeDetailsCallback();
                    getEpisdoeDetailsCallback.setId(rawQuery.getString(0));
                    getEpisdoeDetailsCallback.setTitle(rawQuery.getString(1));
                    getEpisdoeDetailsCallback.setContainerExtension(rawQuery.getString(2));
                    getEpisdoeDetailsCallback.setAdded(rawQuery.getString(3));
                    getEpisdoeDetailsCallback.setElapsed_time(rawQuery.getString(4));
                    getEpisdoeDetailsCallback.setMovieImage(rawQuery.getString(5));
                    getEpisdoeDetailsCallback.setMainSeriesImg(rawQuery.getString(6));
                    getEpisdoeDetailsCallback.setIsRecentlyWatched(rawQuery.getString(7));
                    getEpisdoeDetailsCallback.setSeasonNumber(Integer.valueOf(rawQuery.getInt(8)));
                    getEpisdoeDetailsCallback.setEpisodeNum(Integer.valueOf(rawQuery.getInt(9)));
                    getEpisdoeDetailsCallback.setDurationSec(rawQuery.getString(10));
                    getEpisdoeDetailsCallback.setSeriesId(rawQuery.getString(11));
                    Object obj2 = obj;
                    if (SharepreferenceDBHandler.getCurrentAPPType(this.context).equals(obj2)) {
                        getEpisdoeDetailsCallback.setLinks(rawQuery.getString(12));
                    }
                    arrayList = arrayList2;
                    arrayList.add(getEpisdoeDetailsCallback);
                    if (!rawQuery.moveToNext()) {
                        break;
                    }
                    arrayList2 = arrayList;
                    obj = obj2;
                }
            } else {
                arrayList = arrayList2;
            }
            rawQuery.close();
            return arrayList;
        } catch (SQLiteDatabaseLockedException | SQLiteException unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0150 A[Catch: SQLiteDatabaseLockedException | SQLiteException -> 0x0212, LOOP:0: B:14:0x0150->B:20:?, LOOP_START, TryCatch #0 {SQLiteDatabaseLockedException | SQLiteException -> 0x0212, blocks: (B:12:0x0142, B:14:0x0150, B:16:0x01fc, B:17:0x0205, B:21:0x020e), top: B:11:0x0142 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.ArrayList getAllSeriesRecentWatch(java.lang.String r11) {
        /*
            Method dump skipped, instructions count: 531
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.model.database.SeriesRecentWatchDatabase.getAllSeriesRecentWatch(java.lang.String):java.util.ArrayList");
    }

    public ArrayList getRecentWatchedByEpisodeID(String str) {
        StringBuilder sb;
        String str2;
        int userID = SharepreferenceDBHandler.getUserID(this.context);
        ArrayList arrayList = new ArrayList();
        if (SharepreferenceDBHandler.getCurrentAPPType(this.context).equals("onestream_api")) {
            sb = new StringBuilder();
            str2 = "SELECT  * FROM iptv_series_recent_watch_onestream WHERE episode_id='";
        } else {
            sb = new StringBuilder();
            str2 = "SELECT  * FROM iptv_series_recent_watch WHERE episode_id='";
        }
        sb.append(str2);
        sb.append(str);
        sb.append("'  AND  ");
        sb.append("user_id_referred");
        sb.append("=");
        sb.append(userID);
        try {
            Cursor rawQuery = getReadableDatabase().rawQuery(sb.toString(), (String[]) null);
            if (rawQuery.moveToFirst()) {
                do {
                    GetEpisdoeDetailsCallback getEpisdoeDetailsCallback = new GetEpisdoeDetailsCallback();
                    getEpisdoeDetailsCallback.setId(rawQuery.getString(1));
                    getEpisdoeDetailsCallback.setTitle(rawQuery.getString(2));
                    getEpisdoeDetailsCallback.setContainerExtension(rawQuery.getString(3));
                    getEpisdoeDetailsCallback.setAdded(rawQuery.getString(4));
                    getEpisdoeDetailsCallback.setSeriesCover(rawQuery.getString(5));
                    getEpisdoeDetailsCallback.setSeriesId(rawQuery.getString(6));
                    getEpisdoeDetailsCallback.setElapsed_time(rawQuery.getString(8));
                    getEpisdoeDetailsCallback.setCategoryId(rawQuery.getString(9));
                    getEpisdoeDetailsCallback.setImage(rawQuery.getString(10));
                    getEpisdoeDetailsCallback.setMovieImage(rawQuery.getString(11));
                    getEpisdoeDetailsCallback.setMainSeriesImg(rawQuery.getString(12));
                    getEpisdoeDetailsCallback.setIsRecentlyWatched(rawQuery.getString(13));
                    getEpisdoeDetailsCallback.setSeriesNum(rawQuery.getString(14));
                    getEpisdoeDetailsCallback.setSeasonNumber(Integer.valueOf(rawQuery.getInt(15)));
                    getEpisdoeDetailsCallback.setEpisodeNum(Integer.valueOf(rawQuery.getInt(16)));
                    getEpisdoeDetailsCallback.setSeriesName(rawQuery.getString(17));
                    getEpisdoeDetailsCallback.setDurationSec(rawQuery.getString(18));
                    if (SharepreferenceDBHandler.getCurrentAPPType(this.context).equals("onestream_api")) {
                        getEpisdoeDetailsCallback.setLinks(rawQuery.getString(19));
                    }
                    arrayList.add(getEpisdoeDetailsCallback);
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
            return arrayList;
        } catch (SQLiteDatabaseLockedException | SQLiteException unused) {
            return null;
        }
    }

    public ArrayList getRecentWatchedBySeriesID(String str) {
        StringBuilder sb;
        String str2;
        int userID = SharepreferenceDBHandler.getUserID(this.context);
        ArrayList arrayList = new ArrayList();
        if (SharepreferenceDBHandler.getCurrentAPPType(this.context).equals("onestream_api")) {
            sb = new StringBuilder();
            str2 = "SELECT  * FROM iptv_series_recent_watch_onestream WHERE series_id='";
        } else {
            sb = new StringBuilder();
            str2 = "SELECT  * FROM iptv_series_recent_watch WHERE series_id='";
        }
        sb.append(str2);
        sb.append(str);
        sb.append("'  AND  ");
        sb.append("user_id_referred");
        sb.append("=");
        sb.append(userID);
        sb.append(" ORDER BY ");
        sb.append("id");
        sb.append(" DESC LIMIT 1");
        try {
            Cursor rawQuery = getReadableDatabase().rawQuery(sb.toString(), (String[]) null);
            if (rawQuery.moveToFirst()) {
                do {
                    GetEpisdoeDetailsCallback getEpisdoeDetailsCallback = new GetEpisdoeDetailsCallback();
                    getEpisdoeDetailsCallback.setId(rawQuery.getString(1));
                    getEpisdoeDetailsCallback.setTitle(rawQuery.getString(2));
                    getEpisdoeDetailsCallback.setContainerExtension(rawQuery.getString(3));
                    getEpisdoeDetailsCallback.setAdded(rawQuery.getString(4));
                    getEpisdoeDetailsCallback.setSeriesCover(rawQuery.getString(5));
                    getEpisdoeDetailsCallback.setSeriesId(rawQuery.getString(6));
                    getEpisdoeDetailsCallback.setElapsed_time(rawQuery.getString(8));
                    getEpisdoeDetailsCallback.setCategoryId(rawQuery.getString(9));
                    getEpisdoeDetailsCallback.setImage(rawQuery.getString(10));
                    getEpisdoeDetailsCallback.setMovieImage(rawQuery.getString(11));
                    getEpisdoeDetailsCallback.setMainSeriesImg(rawQuery.getString(12));
                    getEpisdoeDetailsCallback.setIsRecentlyWatched(rawQuery.getString(13));
                    getEpisdoeDetailsCallback.setSeriesNum(rawQuery.getString(14));
                    getEpisdoeDetailsCallback.setSeasonNumber(Integer.valueOf(rawQuery.getInt(15)));
                    getEpisdoeDetailsCallback.setEpisodeNum(Integer.valueOf(rawQuery.getInt(16)));
                    getEpisdoeDetailsCallback.setSeriesName(rawQuery.getString(17));
                    getEpisdoeDetailsCallback.setDurationSec(rawQuery.getString(18));
                    if (SharepreferenceDBHandler.getCurrentAPPType(this.context).equals("onestream_api")) {
                        getEpisdoeDetailsCallback.setLinks(rawQuery.getString(19));
                    }
                    arrayList.add(getEpisdoeDetailsCallback);
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
            return arrayList;
        } catch (SQLiteDatabaseLockedException | SQLiteException unused) {
            return null;
        }
    }

    public ArrayList getRecentWatchedBySeriesIDOneSTream(String str) {
        StringBuilder sb;
        String str2;
        int userID = SharepreferenceDBHandler.getUserID(this.context);
        ArrayList arrayList = new ArrayList();
        if (SharepreferenceDBHandler.getCurrentAPPType(this.context).equals("onestream_api")) {
            sb = new StringBuilder();
            str2 = "SELECT  * FROM iptv_series_recent_watch_onestream WHERE series_id='";
        } else {
            sb = new StringBuilder();
            str2 = "SELECT  * FROM iptv_series_recent_watch WHERE series_id='";
        }
        sb.append(str2);
        sb.append(str);
        sb.append("'  AND  ");
        sb.append("user_id_referred");
        sb.append("=");
        sb.append(userID);
        sb.append(" ORDER BY ");
        sb.append("id");
        sb.append(" DESC LIMIT 1");
        try {
            Cursor rawQuery = getReadableDatabase().rawQuery(sb.toString(), (String[]) null);
            if (rawQuery.moveToFirst()) {
                do {
                    GetEpisdoeDetailsCallback getEpisdoeDetailsCallback = new GetEpisdoeDetailsCallback();
                    getEpisdoeDetailsCallback.setId(rawQuery.getString(1));
                    getEpisdoeDetailsCallback.setTitle(rawQuery.getString(2));
                    getEpisdoeDetailsCallback.setContainerExtension(rawQuery.getString(3));
                    getEpisdoeDetailsCallback.setAdded(rawQuery.getString(4));
                    getEpisdoeDetailsCallback.setSeriesCover(rawQuery.getString(5));
                    getEpisdoeDetailsCallback.setSeriesId(rawQuery.getString(6));
                    getEpisdoeDetailsCallback.setElapsed_time(rawQuery.getString(8));
                    getEpisdoeDetailsCallback.setCategoryId(rawQuery.getString(9));
                    getEpisdoeDetailsCallback.setImage(rawQuery.getString(10));
                    getEpisdoeDetailsCallback.setMovieImage(rawQuery.getString(11));
                    getEpisdoeDetailsCallback.setMainSeriesImg(rawQuery.getString(12));
                    getEpisdoeDetailsCallback.setIsRecentlyWatched(rawQuery.getString(13));
                    getEpisdoeDetailsCallback.setSeriesNum(rawQuery.getString(14));
                    getEpisdoeDetailsCallback.setSeasonNumber(Integer.valueOf(rawQuery.getInt(15)));
                    getEpisdoeDetailsCallback.setEpisodeNum(Integer.valueOf(rawQuery.getInt(16)));
                    getEpisdoeDetailsCallback.setSeriesName(rawQuery.getString(17));
                    getEpisdoeDetailsCallback.setDurationSec(rawQuery.getString(18));
                    if (SharepreferenceDBHandler.getCurrentAPPType(this.context).equals("onestream_api")) {
                        getEpisdoeDetailsCallback.setLinks(rawQuery.getString(19));
                    }
                    arrayList.add(getEpisdoeDetailsCallback);
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
            return arrayList;
        } catch (SQLiteDatabaseLockedException | SQLiteException unused) {
            return null;
        }
    }

    public int getSeriesRecentwatchmCount() {
        StringBuilder sb;
        String str;
        int userID = SharepreferenceDBHandler.getUserID(this.context);
        if (SharepreferenceDBHandler.getCurrentAPPType(this.context).equals("onestream_api")) {
            sb = new StringBuilder();
            str = "SELECT  COUNT(*) FROM iptv_series_recent_watch_onestream WHERE user_id_referred=";
        } else {
            sb = new StringBuilder();
            str = "SELECT  COUNT(*) FROM iptv_series_recent_watch WHERE user_id_referred=";
        }
        sb.append(str);
        sb.append(userID);
        sb.append(" AND ");
        sb.append("is_recent_watched");
        sb.append("=1");
        try {
            Cursor rawQuery = getReadableDatabase().rawQuery(sb.toString(), (String[]) null);
            rawQuery.moveToFirst();
            int i = rawQuery.getInt(0);
            rawQuery.close();
            return i;
        } catch (SQLiteDatabaseLockedException | SQLiteException unused) {
            return 0;
        }
    }

    public Long getTotaltime(String str) {
        StringBuilder sb;
        String str2;
        int userID = SharepreferenceDBHandler.getUserID(this.context);
        long j = -1L;
        if (SharepreferenceDBHandler.getCurrentAPPType(this.context).equals("onestream_api")) {
            sb = new StringBuilder();
            sb.append("SELECT  * FROM iptv_series_recent_watch_onestream WHERE user_id_referred=");
            sb.append(userID);
            sb.append(" AND ");
            sb.append("episode_id");
            sb.append("='");
            sb.append(str);
            str2 = "' LIMIT 1";
        } else {
            sb = new StringBuilder();
            sb.append("SELECT  * FROM iptv_series_recent_watch WHERE user_id_referred=");
            sb.append(userID);
            sb.append(" AND ");
            sb.append("episode_id");
            sb.append("=");
            sb.append(str);
            str2 = " LIMIT 1";
        }
        sb.append(str2);
        try {
            Cursor rawQuery = getReadableDatabase().rawQuery(sb.toString(), (String[]) null);
            if (rawQuery.moveToFirst()) {
                do {
                    j = Long.valueOf(Long.parseLong(rawQuery.getString(18)));
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
        } catch (SQLiteDatabaseLockedException | Exception unused) {
        }
        return j;
    }

    public Long gettimeElapsed(String str) {
        StringBuilder sb;
        String str2;
        int userID = SharepreferenceDBHandler.getUserID(this.context);
        long j = -1L;
        if (SharepreferenceDBHandler.getCurrentAPPType(this.context).equals("onestream_api")) {
            sb = new StringBuilder();
            sb.append("SELECT  * FROM iptv_series_recent_watch_onestream WHERE user_id_referred=");
            sb.append(userID);
            sb.append(" AND ");
            sb.append("episode_id");
            sb.append("='");
            sb.append(str);
            str2 = "' LIMIT 1";
        } else {
            sb = new StringBuilder();
            sb.append("SELECT  * FROM iptv_series_recent_watch WHERE user_id_referred=");
            sb.append(userID);
            sb.append(" AND ");
            sb.append("episode_id");
            sb.append("=");
            sb.append(str);
            str2 = " LIMIT 1";
        }
        sb.append(str2);
        try {
            Cursor rawQuery = getReadableDatabase().rawQuery(sb.toString(), (String[]) null);
            if (rawQuery.moveToFirst()) {
                do {
                    j = Long.valueOf(Long.parseLong(rawQuery.getString(8)));
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
        } catch (SQLiteDatabaseLockedException | Exception unused) {
        }
        return j;
    }

    public int isStreamAvailable(String str) {
        StringBuilder sb;
        String str2;
        int userID = SharepreferenceDBHandler.getUserID(this.context);
        if (SharepreferenceDBHandler.getCurrentAPPType(this.context).equals("onestream_api")) {
            sb = new StringBuilder();
            str2 = "SELECT  COUNT(*) FROM iptv_series_recent_watch_onestream WHERE episode_id='";
        } else {
            sb = new StringBuilder();
            str2 = "SELECT  COUNT(*) FROM iptv_series_recent_watch WHERE episode_id='";
        }
        sb.append(str2);
        sb.append(str);
        sb.append("' AND ");
        sb.append("user_id_referred");
        sb.append("='");
        sb.append(userID);
        sb.append("'");
        try {
            Cursor rawQuery = getReadableDatabase().rawQuery(sb.toString(), (String[]) null);
            rawQuery.moveToFirst();
            int i = rawQuery.getInt(0);
            rawQuery.close();
            return i;
        } catch (SQLiteDatabaseLockedException | SQLiteException unused) {
            return 0;
        }
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(this.CREATE_SERIES_RECENT_WATCH);
        sQLiteDatabase.execSQL(this.CREATE_SERIES_RECENT_WATCH_ONESTREAM);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i < 2) {
            sQLiteDatabase.execSQL(this.ALTER_SERIES_MAIN_IMG);
            sQLiteDatabase.execSQL(this.ALTER_SERIES_KEY_IS_RECENT_WATCHED);
            sQLiteDatabase.execSQL(this.ALTER_SERIES_NUM_KEY);
            sQLiteDatabase.execSQL(this.ALTER_SEASON_NUM_KEY);
            sQLiteDatabase.execSQL(this.ALTER_EPISODE_NUM_KEY);
            sQLiteDatabase.execSQL(this.ALTER_SERIES_NAME_KEY);
            sQLiteDatabase.execSQL(this.ALTER_EPISODE_DURATION_SEC_KEY);
        }
        if (i < 3) {
            sQLiteDatabase.execSQL(this.CREATE_SERIES_RECENT_WATCH_ONESTREAM);
        }
    }

    public int updateAllRecordsBySeriesNumRecentWatchDB() {
        String str;
        StringBuilder sb;
        int userID = SharepreferenceDBHandler.getUserID(this.context);
        SQLiteDatabase writableDatabase = getWritableDatabase();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("is_recent_watched", "0");
            if (SharepreferenceDBHandler.getCurrentAPPType(this.context).equals("onestream_api")) {
                str = "iptv_series_recent_watch_onestream";
                sb = new StringBuilder();
                sb.append("user_id_referred=");
                sb.append(userID);
            } else {
                str = "iptv_series_recent_watch";
                sb = new StringBuilder();
                sb.append("user_id_referred=");
                sb.append(userID);
            }
            return writableDatabase.update(str, contentValues, sb.toString(), (String[]) null);
        } catch (Exception unused) {
            return 0;
        }
    }

    public int updateSeriesRecentWatch(String str, Long l) {
        String str2;
        StringBuilder sb;
        int userID = SharepreferenceDBHandler.getUserID(this.context);
        SQLiteDatabase writableDatabase = getWritableDatabase();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("elapsed_time", l);
            if (SharepreferenceDBHandler.getCurrentAPPType(this.context).equals("onestream_api")) {
                str2 = "iptv_series_recent_watch_onestream";
                sb = new StringBuilder();
                sb.append("episode_id='");
                sb.append(str);
                sb.append("' AND ");
                sb.append("user_id_referred");
                sb.append("=");
                sb.append(userID);
            } else {
                str2 = "iptv_series_recent_watch";
                sb = new StringBuilder();
                sb.append("episode_id=");
                sb.append(str);
                sb.append(" AND ");
                sb.append("user_id_referred");
                sb.append("=");
                sb.append(userID);
            }
            return writableDatabase.update(str2, contentValues, sb.toString(), (String[]) null);
        } catch (Exception unused) {
            return 0;
        }
    }

    public int updateAllRecordsBySeriesNumRecentWatchDB(String str) {
        String str2;
        StringBuilder sb;
        int userID = SharepreferenceDBHandler.getUserID(this.context);
        SQLiteDatabase writableDatabase = getWritableDatabase();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("is_recent_watched", "0");
            if (SharepreferenceDBHandler.getCurrentAPPType(this.context).equals("onestream_api")) {
                str2 = "iptv_series_recent_watch_onestream";
                sb = new StringBuilder();
                sb.append("series_id='");
                sb.append(str);
                sb.append("' AND ");
                sb.append("user_id_referred");
                sb.append("=");
                sb.append(userID);
            } else {
                str2 = "iptv_series_recent_watch";
                sb = new StringBuilder();
                sb.append("series_id=");
                sb.append(str);
                sb.append(" AND ");
                sb.append("user_id_referred");
                sb.append("=");
                sb.append(userID);
            }
            return writableDatabase.update(str2, contentValues, sb.toString(), (String[]) null);
        } catch (Exception unused) {
            return 0;
        }
    }
}
