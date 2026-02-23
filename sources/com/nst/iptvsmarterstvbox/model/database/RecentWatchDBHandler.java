package com.nst.iptvsmarterstvbox.model.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.nst.iptvsmarterstvbox.model.LiveStreamsDBModel;
import com.nst.iptvsmarterstvbox.model.pojo.PanelAvailableChannelsPojo;
import java.util.ArrayList;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class RecentWatchDBHandler extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "iptv_movie_streams_recent_watch.db";
    private static final int DATABASE_VERSION = 4;
    private static final String KEY_ADDED = "added";
    private static final String KEY_AVAIL_CHANNEL_CATEGORY_NAME = "category_name";
    private static final String KEY_AVAIL_CHANNEL_CONTAINER_EXTENSION = "container_extension";
    private static final String KEY_AVAIL_CHANNEL_LINK = "movie_links";
    private static final String KEY_AVAIL_CHANNEL_LIVE = "live";
    private static final String KEY_AVAIL_CHANNEL_RATING_FROM_FIVE = "rating_from_five";
    private static final String KEY_AVAIL_CHANNEL_RATING_FROM_TEN = "rating_from_ten";
    private static final String KEY_AVAIL_CHANNEL_SERIES_NO = "series_no";
    private static final String KEY_AVAIL_CHANNEL_TYPE_NAME = "type_name";
    private static final String KEY_CATEGORY_ID_LIVE_STREAMS = "categoryID";
    private static final String KEY_CUSTOMER_SID = "custom_sid";
    private static final String KEY_DIRECT_SOURCE = "direct_source";
    private static final String KEY_EPG_CHANNEL_ID = "epg_channel_id";
    private static final String KEY_ID_LIVE_STREAMS = "id";
    private static final String KEY_IS_RECENT_WATCHED = "is_watched";
    private static final String KEY_MOVIE_DURTION = "movie_duration";
    private static final String KEY_MOVIE_ELAPSED_TIME = "movie_elapsed_time";
    private static final String KEY_NAME = "name";
    private static final String KEY_NUM_LIVE_STREAMS = "num";
    private static final String KEY_STREAM_ICON = "stream_icon";
    private static final String KEY_STREAM_ID = "stream_id";
    private static final String KEY_STRESM_TYPE = "stream_type";
    private static final String KEY_TV_ARCHIVE = "tv_archive";
    private static final String KEY_TV_ARCHIVE_DURATION = "tv_archive_duration";
    private static final String KEY_USER_ID = "user_id_referred";
    private static final String TABLE_IPTV_AVAILABLE_CHANNNELS = "iptv_movie_streams_recent_watch";
    private static final String TABLE_IPTV_AVAILABLE_CHANNNELS_ONE_STREAM = "iptv_movie_streams_recent_watch_one_stream";
    private String ALTER_MOVIE_KEY_IS_RECENT_WATCHED;
    private String ALTER_RATING_COLUMN1;
    private String ALTER_RATING_COLUMN2;
    String CREATE_LIVE_AVAILABLE_CHANELS;
    String CREATE_LIVE_AVAILABLE_CHANELS_ONE_STREAM;
    Context context;
    SQLiteDatabase db;

    public RecentWatchDBHandler(Context context) {
        super(context, "iptv_movie_streams_recent_watch.db", (SQLiteDatabase.CursorFactory) null, 4);
        this.CREATE_LIVE_AVAILABLE_CHANELS_ONE_STREAM = "CREATE TABLE IF NOT EXISTS iptv_movie_streams_recent_watch_one_stream(id INTEGER PRIMARY KEY,num TEXT,name TEXT,stream_type TEXT,stream_id TEXT,stream_icon TEXT,epg_channel_id TEXT,added TEXT,categoryID TEXT,custom_sid TEXT,tv_archive TEXT,direct_source TEXT,tv_archive_duration TEXT,type_name TEXT,category_name TEXT,series_no TEXT,live TEXT,container_extension TEXT,user_id_referred TEXT,movie_elapsed_time TEXT,movie_duration TEXT,is_watched TEXT,rating_from_ten TEXT,rating_from_five TEXT,movie_links TEXT)";
        this.CREATE_LIVE_AVAILABLE_CHANELS = "CREATE TABLE IF NOT EXISTS iptv_movie_streams_recent_watch(id INTEGER PRIMARY KEY,num TEXT,name TEXT,stream_type TEXT,stream_id TEXT,stream_icon TEXT,epg_channel_id TEXT,added TEXT,categoryID TEXT,custom_sid TEXT,tv_archive TEXT,direct_source TEXT,tv_archive_duration TEXT,type_name TEXT,category_name TEXT,series_no TEXT,live TEXT,container_extension TEXT,user_id_referred TEXT,movie_elapsed_time TEXT,movie_duration TEXT,is_watched TEXT,rating_from_ten TEXT,rating_from_five TEXT)";
        this.ALTER_MOVIE_KEY_IS_RECENT_WATCHED = "ALTER TABLE iptv_movie_streams_recent_watch ADD COLUMN is_watched TEXT;";
        this.ALTER_RATING_COLUMN1 = "ALTER TABLE iptv_movie_streams_recent_watch ADD COLUMN rating_from_ten TEXT;";
        this.ALTER_RATING_COLUMN2 = "ALTER TABLE iptv_movie_streams_recent_watch ADD COLUMN rating_from_five TEXT;";
        this.context = context;
    }

    public void addAllAvailableChannel(PanelAvailableChannelsPojo panelAvailableChannelsPojo) {
        String str;
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.beginTransaction();
            ContentValues contentValues = new ContentValues();
            if (panelAvailableChannelsPojo.getNum() != null) {
                contentValues.put("num", String.valueOf(panelAvailableChannelsPojo.getNum()));
            } else {
                contentValues.put("num", "");
            }
            if (panelAvailableChannelsPojo.getName() != null) {
                contentValues.put("name", panelAvailableChannelsPojo.getName());
            } else {
                contentValues.put("name", "");
            }
            if (panelAvailableChannelsPojo.getStreamType() != null) {
                contentValues.put("stream_type", panelAvailableChannelsPojo.getStreamType());
            } else {
                contentValues.put("stream_type", "");
            }
            if (panelAvailableChannelsPojo.getStreamId() != null) {
                contentValues.put("stream_id", panelAvailableChannelsPojo.getStreamId());
            } else {
                contentValues.put("stream_id", "");
            }
            if (panelAvailableChannelsPojo.getStreamIcon() != null) {
                contentValues.put("stream_icon", panelAvailableChannelsPojo.getStreamIcon());
            } else {
                contentValues.put("stream_icon", "");
            }
            if (panelAvailableChannelsPojo.getEpgChannelId() != null) {
                contentValues.put("epg_channel_id", panelAvailableChannelsPojo.getEpgChannelId());
            } else {
                contentValues.put("epg_channel_id", "");
            }
            if (panelAvailableChannelsPojo.getAdded() != null) {
                contentValues.put("added", panelAvailableChannelsPojo.getAdded());
            } else {
                contentValues.put("added", "");
            }
            if (panelAvailableChannelsPojo.getCategoryId() != null) {
                contentValues.put("categoryID", panelAvailableChannelsPojo.getCategoryId());
            } else {
                contentValues.put("categoryID", "");
            }
            if (panelAvailableChannelsPojo.getCustomSid() != null) {
                contentValues.put("custom_sid", panelAvailableChannelsPojo.getCustomSid());
            } else {
                contentValues.put("custom_sid", "");
            }
            if (panelAvailableChannelsPojo.getTvArchive() != null) {
                contentValues.put("tv_archive", panelAvailableChannelsPojo.getTvArchive());
            } else {
                contentValues.put("tv_archive", "");
            }
            if (panelAvailableChannelsPojo.getDirectSource() != null) {
                contentValues.put("direct_source", panelAvailableChannelsPojo.getDirectSource());
            } else {
                contentValues.put("direct_source", "");
            }
            if (panelAvailableChannelsPojo.getTvArchiveDuration() != null) {
                contentValues.put("tv_archive_duration", panelAvailableChannelsPojo.getTvArchiveDuration());
            } else {
                contentValues.put("tv_archive_duration", "");
            }
            if (panelAvailableChannelsPojo.getTypeName() != null) {
                contentValues.put("type_name", String.valueOf(panelAvailableChannelsPojo.getTypeName()));
            } else {
                contentValues.put("type_name", "");
            }
            if (panelAvailableChannelsPojo.getCategoryName() != null) {
                contentValues.put("category_name", panelAvailableChannelsPojo.getCategoryName());
            } else {
                contentValues.put("category_name", "");
            }
            if (panelAvailableChannelsPojo.getSeriesNo() != null) {
                contentValues.put("series_no", String.valueOf(panelAvailableChannelsPojo.getSeriesNo()));
            } else {
                contentValues.put("series_no", "");
            }
            if (panelAvailableChannelsPojo.getLive() != null) {
                contentValues.put("series_no", String.valueOf(panelAvailableChannelsPojo.getSeriesNo()));
            } else {
                contentValues.put("series_no", "");
            }
            if (panelAvailableChannelsPojo.getLive() != null) {
                contentValues.put("live", panelAvailableChannelsPojo.getLive());
            } else {
                contentValues.put("live", "");
            }
            if (panelAvailableChannelsPojo.getContainerExtension() != null) {
                contentValues.put("container_extension", String.valueOf(panelAvailableChannelsPojo.getContainerExtension()));
            } else {
                contentValues.put("container_extension", "");
            }
            contentValues.put("user_id_referred", panelAvailableChannelsPojo.getUserIdReferred() != -1 ? Integer.valueOf(panelAvailableChannelsPojo.getUserIdReferred()) : -1);
            if (panelAvailableChannelsPojo.getMovieElapsedTime() != -1) {
                contentValues.put("movie_elapsed_time", Long.valueOf(panelAvailableChannelsPojo.getMovieElapsedTime()));
            } else {
                contentValues.put("movie_elapsed_time", -1);
            }
            if (panelAvailableChannelsPojo.getMovieDuration() != -1) {
                contentValues.put("movie_duration", Long.valueOf(panelAvailableChannelsPojo.getMovieDuration()));
            } else {
                contentValues.put("movie_duration", -1);
            }
            contentValues.put("is_watched", "1");
            if (panelAvailableChannelsPojo.getRatingFromTen() != null) {
                contentValues.put("rating_from_ten", panelAvailableChannelsPojo.getRatingFromTen());
            } else {
                contentValues.put("rating_from_ten", "");
            }
            if (panelAvailableChannelsPojo.getRatingFromFive() != null) {
                contentValues.put("rating_from_five", String.valueOf(panelAvailableChannelsPojo.getRatingFromFive()));
            } else {
                contentValues.put("rating_from_five", "");
            }
            if (SharepreferenceDBHandler.getCurrentAPPType(this.context).equals("onestream_api")) {
                if (panelAvailableChannelsPojo.getUrl() != null) {
                    contentValues.put("movie_links", String.valueOf(panelAvailableChannelsPojo.getUrl()));
                } else {
                    contentValues.put("movie_links", "");
                }
                str = "iptv_movie_streams_recent_watch_one_stream";
            } else {
                str = "iptv_movie_streams_recent_watch";
            }
            writableDatabase.insert(str, (String) null, contentValues);
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
            writableDatabase.close();
        } catch (SQLiteDatabaseLockedException | SQLiteException unused) {
            Log.w("msg", "exception");
        }
    }

    public void addMoviesWatchedFromBackup(ArrayList arrayList) {
        String str;
        try {
            int userID = SharepreferenceDBHandler.getUserID(this.context);
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.beginTransaction();
            ContentValues contentValues = new ContentValues();
            for (int i = 0; i < arrayList.size(); i++) {
                contentValues.put("num", ((LiveStreamsDBModel) arrayList.get(i)).getNum());
                contentValues.put("name", ((LiveStreamsDBModel) arrayList.get(i)).getName());
                contentValues.put("stream_type", ((LiveStreamsDBModel) arrayList.get(i)).getStreamType());
                contentValues.put("stream_id", ((LiveStreamsDBModel) arrayList.get(i)).getStreamId());
                contentValues.put("stream_icon", ((LiveStreamsDBModel) arrayList.get(i)).getStreamIcon());
                contentValues.put("epg_channel_id", "");
                contentValues.put("added", ((LiveStreamsDBModel) arrayList.get(i)).getAdded());
                contentValues.put("categoryID", ((LiveStreamsDBModel) arrayList.get(i)).getCategoryId());
                contentValues.put("custom_sid", "");
                contentValues.put("tv_archive", "");
                contentValues.put("direct_source", "");
                contentValues.put("tv_archive_duration", "");
                contentValues.put("type_name", "");
                contentValues.put("category_name", "");
                contentValues.put("series_no", "");
                contentValues.put("live", "");
                contentValues.put("container_extension", ((LiveStreamsDBModel) arrayList.get(i)).getContaiinerExtension());
                contentValues.put("user_id_referred", Integer.valueOf(userID));
                contentValues.put("movie_elapsed_time", Long.valueOf(((LiveStreamsDBModel) arrayList.get(i)).getMovieElapsedTime()));
                contentValues.put("movie_duration", Long.valueOf(((LiveStreamsDBModel) arrayList.get(i)).getMovieDuraton()));
                contentValues.put("is_watched", ((LiveStreamsDBModel) arrayList.get(i)).getIsRecentlyWatched());
                contentValues.put("rating_from_ten", ((LiveStreamsDBModel) arrayList.get(i)).getRatingFromTen());
                contentValues.put("rating_from_five", ((LiveStreamsDBModel) arrayList.get(i)).getRatingFromFive());
                if (SharepreferenceDBHandler.getCurrentAPPType(this.context).equals("onestream_api")) {
                    contentValues.put("movie_links", ((LiveStreamsDBModel) arrayList.get(i)).getLinks());
                    str = "iptv_movie_streams_recent_watch_one_stream";
                } else {
                    str = "iptv_movie_streams_recent_watch";
                }
                writableDatabase.insert(str, (String) null, contentValues);
            }
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
            writableDatabase.close();
        } catch (SQLiteDatabaseLockedException | SQLiteException unused) {
            Log.w("msg", "exception");
        }
    }

    public void deletRecentWatchForThisUser(int i) {
        SQLiteDatabase sQLiteDatabase;
        String str;
        StringBuilder sb;
        try {
            this.db = getWritableDatabase();
            if (SharepreferenceDBHandler.getCurrentAPPType(this.context).equals("onestream_api")) {
                sQLiteDatabase = this.db;
                str = "iptv_movie_streams_recent_watch_one_stream";
                sb = new StringBuilder();
                sb.append("user_id_referred='");
                sb.append(i);
                sb.append("'");
            } else {
                sQLiteDatabase = this.db;
                str = "iptv_movie_streams_recent_watch";
                sb = new StringBuilder();
                sb.append("user_id_referred='");
                sb.append(i);
                sb.append("'");
            }
            sQLiteDatabase.delete(str, sb.toString(), (String[]) null);
            this.db.close();
        } catch (SQLiteDatabaseLockedException | SQLiteException unused) {
        }
    }

    public void deleteALLRecentwatch(String str, int i) {
        SQLiteDatabase sQLiteDatabase;
        String str2;
        String str3;
        this.db = getWritableDatabase();
        if (SharepreferenceDBHandler.getCurrentAPPType(this.context).equals("onestream_api")) {
            sQLiteDatabase = this.db;
            str2 = "stream_type='" + str + "' AND user_id_referred=" + i + "";
            str3 = "iptv_movie_streams_recent_watch_one_stream";
        } else {
            sQLiteDatabase = this.db;
            str2 = "stream_type='" + str + "' AND user_id_referred=" + i + "";
            str3 = "iptv_movie_streams_recent_watch";
        }
        sQLiteDatabase.delete(str3, str2, (String[]) null);
        this.db.close();
    }

    public void deleteAndRecreateAllTables() {
        try {
            getReadableDatabase();
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.execSQL(SharepreferenceDBHandler.getCurrentAPPType(this.context).equals("onestream_api") ? "DROP TABLE IF EXISTS iptv_movie_streams_recent_watch_one_stream" : "DROP TABLE IF EXISTS iptv_movie_streams_recent_watch");
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
                sb.append("DELETE FROM iptv_movie_streams_recent_watch_one_stream WHERE user_id_referred = '");
                sb.append(userID);
                sb.append("' AND ");
                sb.append("stream_id");
                sb.append(" IN (");
                sb.append(str);
                sb.append(")");
            } else {
                sb = new StringBuilder();
                sb.append("DELETE FROM iptv_movie_streams_recent_watch WHERE user_id_referred = '");
                sb.append(userID);
                sb.append("' AND ");
                sb.append("stream_id");
                sb.append(" IN (");
                sb.append(str);
                sb.append(")");
            }
            writableDatabase.execSQL(sb.toString());
        } catch (SQLiteDatabaseLockedException | SQLiteException unused) {
        }
    }

    public void deleteMovieRecentWatch(String str) {
        SQLiteDatabase sQLiteDatabase;
        String str2;
        StringBuilder sb;
        try {
            int userID = SharepreferenceDBHandler.getUserID(this.context);
            this.db = getWritableDatabase();
            if (SharepreferenceDBHandler.getCurrentAPPType(this.context).equals("onestream_api")) {
                sQLiteDatabase = this.db;
                str2 = "iptv_movie_streams_recent_watch_one_stream";
                sb = new StringBuilder();
                sb.append("stream_id='");
                sb.append(str);
                sb.append("'  AND  ");
                sb.append("user_id_referred");
                sb.append("=");
                sb.append(userID);
                sb.append("");
            } else {
                sQLiteDatabase = this.db;
                str2 = "iptv_movie_streams_recent_watch";
                sb = new StringBuilder();
                sb.append("stream_id='");
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

    public void deleteRecentwatch(int i, String str) {
        SQLiteDatabase sQLiteDatabase;
        String str2;
        StringBuilder sb;
        try {
            int userID = SharepreferenceDBHandler.getUserID(this.context);
            this.db = getWritableDatabase();
            if (SharepreferenceDBHandler.getCurrentAPPType(this.context).equals("onestream_api")) {
                sQLiteDatabase = this.db;
                str2 = "iptv_movie_streams_recent_watch_one_stream";
                sb = new StringBuilder();
                sb.append("stream_id='");
                sb.append(i);
                sb.append("'  AND ");
                sb.append("stream_type");
                sb.append("='");
                sb.append(str);
                sb.append("' AND ");
                sb.append("user_id_referred");
                sb.append("=");
                sb.append(userID);
                sb.append("");
            } else {
                sQLiteDatabase = this.db;
                str2 = "iptv_movie_streams_recent_watch";
                sb = new StringBuilder();
                sb.append("stream_id='");
                sb.append(i);
                sb.append("'  AND ");
                sb.append("stream_type");
                sb.append("='");
                sb.append(str);
                sb.append("' AND ");
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

    public ArrayList getAllLiveStreasWithCategoryId(String str, int i, String str2) {
        ArrayList arrayList;
        Object obj;
        String str3;
        StringBuilder sb;
        ArrayList arrayList2;
        StringBuilder sb2;
        ArrayList arrayList3 = new ArrayList();
        if (str2.equals("getalldata")) {
            String vODSubCatSort = SharepreferenceDBHandler.getVODSubCatSort(this.context);
            arrayList = arrayList3;
            if (SharepreferenceDBHandler.getCurrentAPPType(this.context).equals("onestream_api")) {
                if (vODSubCatSort.equals("0")) {
                    sb2 = new StringBuilder();
                } else if (vODSubCatSort.equals("1")) {
                    sb2 = new StringBuilder();
                    sb2.append("SELECT  * FROM iptv_movie_streams_recent_watch_one_stream WHERE user_id_referred=");
                    sb2.append(i);
                    sb2.append(" ORDER BY ");
                    sb2.append("id");
                    sb2.append(" DESC");
                    str3 = sb2.toString();
                    obj = "onestream_api";
                } else if (vODSubCatSort.equals("2")) {
                    sb2 = new StringBuilder();
                    sb2.append("SELECT  * FROM iptv_movie_streams_recent_watch_one_stream WHERE user_id_referred=");
                    sb2.append(i);
                    sb2.append(" ORDER BY ");
                    sb2.append("name");
                    sb2.append(" ASC");
                    str3 = sb2.toString();
                    obj = "onestream_api";
                } else if (vODSubCatSort.equals("3")) {
                    sb2 = new StringBuilder();
                    sb2.append("SELECT  * FROM iptv_movie_streams_recent_watch_one_stream WHERE user_id_referred=");
                    sb2.append(i);
                    sb2.append(" ORDER BY ");
                    sb2.append("name");
                    sb2.append(" DESC");
                    str3 = sb2.toString();
                    obj = "onestream_api";
                } else {
                    sb2 = new StringBuilder();
                }
                sb2.append("SELECT  * FROM iptv_movie_streams_recent_watch_one_stream WHERE user_id_referred=");
                sb2.append(i);
                sb2.append("");
                str3 = sb2.toString();
                obj = "onestream_api";
            } else {
                if (vODSubCatSort.equals("0")) {
                    sb2 = new StringBuilder();
                } else if (vODSubCatSort.equals("1")) {
                    sb2 = new StringBuilder();
                    sb2.append("SELECT  * FROM iptv_movie_streams_recent_watch WHERE user_id_referred=");
                    sb2.append(i);
                    sb2.append(" ORDER BY ");
                    sb2.append("id");
                    sb2.append(" DESC");
                    str3 = sb2.toString();
                    obj = "onestream_api";
                } else if (vODSubCatSort.equals("2")) {
                    sb2 = new StringBuilder();
                    sb2.append("SELECT  * FROM iptv_movie_streams_recent_watch WHERE user_id_referred=");
                    sb2.append(i);
                    sb2.append(" ORDER BY ");
                    sb2.append("name");
                    sb2.append(" ASC");
                    str3 = sb2.toString();
                    obj = "onestream_api";
                } else if (vODSubCatSort.equals("3")) {
                    sb2 = new StringBuilder();
                    sb2.append("SELECT  * FROM iptv_movie_streams_recent_watch WHERE user_id_referred=");
                    sb2.append(i);
                    sb2.append(" ORDER BY ");
                    sb2.append("name");
                    sb2.append(" DESC");
                    str3 = sb2.toString();
                    obj = "onestream_api";
                } else {
                    sb2 = new StringBuilder();
                }
                sb2.append("SELECT  * FROM iptv_movie_streams_recent_watch WHERE user_id_referred=");
                sb2.append(i);
                sb2.append("");
                str3 = sb2.toString();
                obj = "onestream_api";
            }
        } else {
            arrayList = arrayList3;
            if (str2.equals("getOnedata")) {
                obj = "onestream_api";
                if (SharepreferenceDBHandler.getCurrentAPPType(this.context).equals(obj)) {
                    sb = new StringBuilder();
                    sb.append("SELECT  * FROM iptv_movie_streams_recent_watch_one_stream WHERE user_id_referred=");
                } else {
                    sb = new StringBuilder();
                    sb.append("SELECT  * FROM iptv_movie_streams_recent_watch WHERE user_id_referred=");
                }
                sb.append(i);
                sb.append(" ORDER BY ");
                sb.append("added");
                sb.append(" ASC LIMIT 1");
                str3 = sb.toString();
            } else {
                obj = "onestream_api";
                str3 = null;
            }
        }
        try {
            try {
                Cursor rawQuery = getReadableDatabase().rawQuery(str3, (String[]) null);
                if (rawQuery.moveToFirst()) {
                    while (true) {
                        LiveStreamsDBModel liveStreamsDBModel = new LiveStreamsDBModel();
                        try {
                            liveStreamsDBModel.setIdAuto(Integer.parseInt(rawQuery.getString(0)));
                        } catch (NumberFormatException unused) {
                        }
                        liveStreamsDBModel.setNum(rawQuery.getString(1));
                        liveStreamsDBModel.setName(rawQuery.getString(2));
                        liveStreamsDBModel.setStreamType(rawQuery.getString(3));
                        liveStreamsDBModel.setStreamIdOneStream(rawQuery.getString(4));
                        liveStreamsDBModel.setStreamId(rawQuery.getString(4));
                        liveStreamsDBModel.setStreamIcon(rawQuery.getString(5));
                        liveStreamsDBModel.setEpgChannelId(rawQuery.getString(6));
                        liveStreamsDBModel.setAdded(rawQuery.getString(7));
                        liveStreamsDBModel.setCategoryId(rawQuery.getString(8));
                        liveStreamsDBModel.setCustomSid(rawQuery.getString(9));
                        liveStreamsDBModel.setTvArchive(rawQuery.getString(10));
                        liveStreamsDBModel.setDirectSource(rawQuery.getString(11));
                        liveStreamsDBModel.setTvArchiveDuration(rawQuery.getString(12));
                        liveStreamsDBModel.setTypeName(rawQuery.getString(13));
                        liveStreamsDBModel.setCategoryName(rawQuery.getString(14));
                        liveStreamsDBModel.setSeriesNo(rawQuery.getString(15));
                        liveStreamsDBModel.setLive(rawQuery.getString(16));
                        liveStreamsDBModel.setContaiinerExtension(rawQuery.getString(17));
                        liveStreamsDBModel.setUserIdReffered(rawQuery.getInt(18));
                        liveStreamsDBModel.setMovieElapsedTime(rawQuery.getLong(19));
                        liveStreamsDBModel.setMovieDuraton(rawQuery.getLong(20));
                        liveStreamsDBModel.setIsRecentlyWatched(rawQuery.getString(21));
                        liveStreamsDBModel.setRatingFromTen(rawQuery.getString(22));
                        liveStreamsDBModel.setRatingFromFive(rawQuery.getString(23));
                        if (SharepreferenceDBHandler.getCurrentAPPType(this.context).equals(obj)) {
                            liveStreamsDBModel.setLinks(rawQuery.getString(24));
                        }
                        arrayList2 = arrayList;
                        arrayList2.add(liveStreamsDBModel);
                        if (!rawQuery.moveToNext()) {
                            break;
                        }
                        arrayList = arrayList2;
                    }
                } else {
                    arrayList2 = arrayList;
                }
                rawQuery.close();
                return arrayList2;
            } catch (SQLiteDatabaseLockedException unused2) {
                return null;
            } catch (SQLiteException unused3) {
                return null;
            }
        } catch (SQLiteDatabaseLockedException unused4) {
            return null;
        } catch (SQLiteException unused5) {
            return null;
        }
    }

    public ArrayList getAllMoviesContinueWatchingStreamIDs() {
        StringBuilder sb;
        String str;
        int i;
        SharepreferenceDBHandler.getUserID(this.context);
        if (SharepreferenceDBHandler.getCurrentAPPType(this.context).equals("onestream_api")) {
            sb = new StringBuilder();
            str = "SELECT stream_id FROM iptv_movie_streams_recent_watch_one_stream WHERE stream_type LIKE '%movie%' AND user_id_referred=";
        } else {
            sb = new StringBuilder();
            str = "SELECT stream_id FROM iptv_movie_streams_recent_watch WHERE stream_type LIKE '%movie%' AND user_id_referred=";
        }
        sb.append(str);
        sb.append(SharepreferenceDBHandler.getUserID(this.context));
        sb.append(" ");
        try {
            Cursor rawQuery = getReadableDatabase().rawQuery(sb.toString(), (String[]) null);
            ArrayList arrayList = new ArrayList();
            if (rawQuery.moveToFirst()) {
                do {
                    LiveStreamsDBModel liveStreamsDBModel = new LiveStreamsDBModel();
                    String str2 = "";
                    try {
                        i = Integer.parseInt(rawQuery.getString(0));
                    } catch (NumberFormatException unused) {
                        i = 0;
                    }
                    try {
                        str2 = rawQuery.getString(0);
                    } catch (Exception unused2) {
                    }
                    liveStreamsDBModel.setStreamId(String.valueOf(i));
                    liveStreamsDBModel.setStreamIdOneStream(str2);
                    arrayList.add(liveStreamsDBModel);
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
            return arrayList;
        } catch (SQLiteDatabaseLockedException | SQLiteException unused3) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0091 A[Catch: SQLiteDatabaseLockedException | SQLiteException -> 0x0193, LOOP:0: B:11:0x0091->B:22:?, LOOP_START, TRY_LEAVE, TryCatch #1 {SQLiteDatabaseLockedException | SQLiteException -> 0x0193, blocks: (B:9:0x0083, B:11:0x0091, B:14:0x0097, B:14:0x0097, B:16:0x00a3, B:16:0x00a3, B:18:0x017d, B:18:0x017d, B:19:0x0186, B:19:0x0186, B:25:0x018f, B:25:0x018f), top: B:8:0x0083 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.ArrayList getAllVodContiueWatching(java.lang.String r13, java.lang.String r14) {
        /*
            Method dump skipped, instructions count: 404
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.model.database.RecentWatchDBHandler.getAllVodContiueWatching(java.lang.String, java.lang.String):java.util.ArrayList");
    }

    public ArrayList getAllVodContiueWatchingforBackup() {
        StringBuilder sb;
        String str;
        int userID = SharepreferenceDBHandler.getUserID(this.context);
        ArrayList arrayList = new ArrayList();
        if (SharepreferenceDBHandler.getCurrentAPPType(this.context).equals("onestream_api")) {
            sb = new StringBuilder();
            str = "SELECT  movie_elapsed_time,movie_duration,is_watched,stream_id FROM iptv_movie_streams_recent_watch_one_stream WHERE user_id_referred=";
        } else {
            sb = new StringBuilder();
            str = "SELECT  movie_elapsed_time,movie_duration,is_watched,stream_id FROM iptv_movie_streams_recent_watch WHERE user_id_referred=";
        }
        sb.append(str);
        sb.append(userID);
        try {
            Cursor rawQuery = getReadableDatabase().rawQuery(sb.toString(), (String[]) null);
            if (rawQuery.moveToFirst()) {
                do {
                    LiveStreamsDBModel liveStreamsDBModel = new LiveStreamsDBModel();
                    liveStreamsDBModel.setMovieElapsedTime(rawQuery.getLong(0));
                    liveStreamsDBModel.setMovieDuraton(rawQuery.getLong(1));
                    liveStreamsDBModel.setIsRecentlyWatched(rawQuery.getString(2));
                    liveStreamsDBModel.setStreamId(rawQuery.getString(3));
                    liveStreamsDBModel.setStreamIdOneStream(rawQuery.getString(3));
                    arrayList.add(liveStreamsDBModel);
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
            return arrayList;
        } catch (SQLiteDatabaseLockedException | SQLiteException unused) {
            return null;
        }
    }

    public int getLiveStreamsCount(int i) {
        StringBuilder sb;
        String str;
        if (SharepreferenceDBHandler.getCurrentAPPType(this.context).equals("onestream_api")) {
            sb = new StringBuilder();
            str = "SELECT  COUNT(*) FROM iptv_movie_streams_recent_watch_one_stream WHERE user_id_referred='";
        } else {
            sb = new StringBuilder();
            str = "SELECT  COUNT(*) FROM iptv_movie_streams_recent_watch WHERE user_id_referred='";
        }
        sb.append(str);
        sb.append(i);
        sb.append("'");
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

    public ArrayList getRecentWatchedByStreamID(int i) {
        StringBuilder sb;
        String str;
        int userID = SharepreferenceDBHandler.getUserID(this.context);
        if (SharepreferenceDBHandler.getCurrentAPPType(this.context).equals("onestream_api")) {
            sb = new StringBuilder();
            str = "SELECT * FROM iptv_movie_streams_recent_watch_one_stream WHERE stream_id = '";
        } else {
            sb = new StringBuilder();
            str = "SELECT * FROM iptv_movie_streams_recent_watch WHERE stream_id = '";
        }
        sb.append(str);
        sb.append(i);
        sb.append("' AND ");
        sb.append("user_id_referred");
        sb.append(" = '");
        sb.append(userID);
        sb.append("' ORDER BY ");
        sb.append("id");
        sb.append(" DESC LIMIT 1");
        try {
            Cursor rawQuery = getReadableDatabase().rawQuery(sb.toString(), (String[]) null);
            ArrayList arrayList = new ArrayList();
            if (rawQuery.moveToFirst()) {
                do {
                    LiveStreamsDBModel liveStreamsDBModel = new LiveStreamsDBModel();
                    try {
                        liveStreamsDBModel.setIdAuto(Integer.parseInt(rawQuery.getString(0)));
                    } catch (NumberFormatException unused) {
                    }
                    liveStreamsDBModel.setNum(rawQuery.getString(1));
                    liveStreamsDBModel.setName(rawQuery.getString(2));
                    liveStreamsDBModel.setStreamType(rawQuery.getString(3));
                    liveStreamsDBModel.setStreamId(rawQuery.getString(4));
                    liveStreamsDBModel.setStreamIdOneStream(rawQuery.getString(4));
                    liveStreamsDBModel.setStreamIcon(rawQuery.getString(5));
                    liveStreamsDBModel.setEpgChannelId(rawQuery.getString(6));
                    liveStreamsDBModel.setAdded(rawQuery.getString(7));
                    liveStreamsDBModel.setCategoryId(rawQuery.getString(8));
                    liveStreamsDBModel.setCustomSid(rawQuery.getString(9));
                    liveStreamsDBModel.setTvArchive(rawQuery.getString(10));
                    liveStreamsDBModel.setDirectSource(rawQuery.getString(11));
                    liveStreamsDBModel.setTvArchiveDuration(rawQuery.getString(12));
                    liveStreamsDBModel.setTypeName(rawQuery.getString(13));
                    liveStreamsDBModel.setCategoryName(rawQuery.getString(14));
                    liveStreamsDBModel.setSeriesNo(rawQuery.getString(15));
                    liveStreamsDBModel.setLive(rawQuery.getString(16));
                    liveStreamsDBModel.setContaiinerExtension(rawQuery.getString(17));
                    liveStreamsDBModel.setUserIdReffered(rawQuery.getInt(18));
                    liveStreamsDBModel.setMovieElapsedTime(rawQuery.getLong(19));
                    liveStreamsDBModel.setMovieDuraton(rawQuery.getLong(20));
                    liveStreamsDBModel.setIsRecentlyWatched(rawQuery.getString(21));
                    liveStreamsDBModel.setRatingFromTen(rawQuery.getString(22));
                    liveStreamsDBModel.setRatingFromFive(rawQuery.getString(23));
                    if (SharepreferenceDBHandler.getCurrentAPPType(this.context).equals("onestream_api")) {
                        liveStreamsDBModel.setLinks(rawQuery.getString(24));
                    }
                    arrayList.add(liveStreamsDBModel);
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
            return arrayList;
        } catch (SQLiteDatabaseLockedException | SQLiteException unused2) {
            return null;
        }
    }

    public ArrayList getRecentWatchedByStreamIDOneStream(String str) {
        StringBuilder sb;
        String str2;
        int userID = SharepreferenceDBHandler.getUserID(this.context);
        if (SharepreferenceDBHandler.getCurrentAPPType(this.context).equals("onestream_api")) {
            sb = new StringBuilder();
            str2 = "SELECT * FROM iptv_movie_streams_recent_watch_one_stream WHERE stream_id = '";
        } else {
            sb = new StringBuilder();
            str2 = "SELECT * FROM iptv_movie_streams_recent_watch WHERE stream_id = '";
        }
        sb.append(str2);
        sb.append(str);
        sb.append("' AND ");
        sb.append("user_id_referred");
        sb.append(" = '");
        sb.append(userID);
        sb.append("' ORDER BY ");
        sb.append("id");
        sb.append(" DESC LIMIT 1");
        try {
            Cursor rawQuery = getReadableDatabase().rawQuery(sb.toString(), (String[]) null);
            ArrayList arrayList = new ArrayList();
            if (rawQuery.moveToFirst()) {
                do {
                    LiveStreamsDBModel liveStreamsDBModel = new LiveStreamsDBModel();
                    try {
                        liveStreamsDBModel.setIdAuto(Integer.parseInt(rawQuery.getString(0)));
                    } catch (NumberFormatException unused) {
                    }
                    liveStreamsDBModel.setNum(rawQuery.getString(1));
                    liveStreamsDBModel.setName(rawQuery.getString(2));
                    liveStreamsDBModel.setStreamType(rawQuery.getString(3));
                    liveStreamsDBModel.setStreamId(rawQuery.getString(4));
                    liveStreamsDBModel.setStreamIdOneStream(rawQuery.getString(4));
                    liveStreamsDBModel.setStreamIcon(rawQuery.getString(5));
                    liveStreamsDBModel.setEpgChannelId(rawQuery.getString(6));
                    liveStreamsDBModel.setAdded(rawQuery.getString(7));
                    liveStreamsDBModel.setCategoryId(rawQuery.getString(8));
                    liveStreamsDBModel.setCustomSid(rawQuery.getString(9));
                    liveStreamsDBModel.setTvArchive(rawQuery.getString(10));
                    liveStreamsDBModel.setDirectSource(rawQuery.getString(11));
                    liveStreamsDBModel.setTvArchiveDuration(rawQuery.getString(12));
                    liveStreamsDBModel.setTypeName(rawQuery.getString(13));
                    liveStreamsDBModel.setCategoryName(rawQuery.getString(14));
                    liveStreamsDBModel.setSeriesNo(rawQuery.getString(15));
                    liveStreamsDBModel.setLive(rawQuery.getString(16));
                    liveStreamsDBModel.setContaiinerExtension(rawQuery.getString(17));
                    liveStreamsDBModel.setUserIdReffered(rawQuery.getInt(18));
                    liveStreamsDBModel.setMovieElapsedTime(rawQuery.getLong(19));
                    liveStreamsDBModel.setMovieDuraton(rawQuery.getLong(20));
                    liveStreamsDBModel.setIsRecentlyWatched(rawQuery.getString(21));
                    liveStreamsDBModel.setRatingFromTen(rawQuery.getString(22));
                    liveStreamsDBModel.setRatingFromFive(rawQuery.getString(23));
                    if (SharepreferenceDBHandler.getCurrentAPPType(this.context).equals("onestream_api")) {
                        liveStreamsDBModel.setLinks(rawQuery.getString(24));
                    }
                    arrayList.add(liveStreamsDBModel);
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
            return arrayList;
        } catch (SQLiteDatabaseLockedException | SQLiteException unused2) {
            return null;
        }
    }

    public int getRecentwatchmoviesCount(int i) {
        StringBuilder sb;
        String str;
        if (SharepreferenceDBHandler.getCurrentAPPType(this.context).equals("onestream_api")) {
            sb = new StringBuilder();
            str = "SELECT  COUNT(*) FROM iptv_movie_streams_recent_watch_one_stream WHERE user_id_referred=";
        } else {
            sb = new StringBuilder();
            str = "SELECT  COUNT(*) FROM iptv_movie_streams_recent_watch WHERE user_id_referred=";
        }
        sb.append(str);
        sb.append(i);
        sb.append("");
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

    public ArrayList getStreamStatus(String str, int i) {
        StringBuilder sb;
        String str2;
        if (SharepreferenceDBHandler.getCurrentAPPType(this.context).equals("onestream_api")) {
            sb = new StringBuilder();
            str2 = "SELECT * FROM iptv_movie_streams_recent_watch_one_stream WHERE stream_id = '";
        } else {
            sb = new StringBuilder();
            str2 = "SELECT * FROM iptv_movie_streams_recent_watch WHERE stream_id = '";
        }
        sb.append(str2);
        sb.append(str);
        sb.append("' AND ");
        sb.append("user_id_referred");
        sb.append(" = '");
        sb.append(i);
        sb.append("' LIMIT 1");
        try {
            Cursor rawQuery = getReadableDatabase().rawQuery(sb.toString(), (String[]) null);
            ArrayList arrayList = new ArrayList();
            if (rawQuery.moveToFirst()) {
                do {
                    LiveStreamsDBModel liveStreamsDBModel = new LiveStreamsDBModel();
                    try {
                        liveStreamsDBModel.setIdAuto(Integer.parseInt(rawQuery.getString(0)));
                    } catch (NumberFormatException unused) {
                    }
                    liveStreamsDBModel.setNum(rawQuery.getString(1));
                    liveStreamsDBModel.setName(rawQuery.getString(2));
                    liveStreamsDBModel.setStreamType(rawQuery.getString(3));
                    liveStreamsDBModel.setStreamId(rawQuery.getString(4));
                    liveStreamsDBModel.setStreamIdOneStream(rawQuery.getString(4));
                    liveStreamsDBModel.setStreamIcon(rawQuery.getString(5));
                    liveStreamsDBModel.setEpgChannelId(rawQuery.getString(6));
                    liveStreamsDBModel.setAdded(rawQuery.getString(7));
                    liveStreamsDBModel.setCategoryId(rawQuery.getString(8));
                    liveStreamsDBModel.setCustomSid(rawQuery.getString(9));
                    liveStreamsDBModel.setTvArchive(rawQuery.getString(10));
                    liveStreamsDBModel.setDirectSource(rawQuery.getString(11));
                    liveStreamsDBModel.setTvArchiveDuration(rawQuery.getString(12));
                    liveStreamsDBModel.setTypeName(rawQuery.getString(13));
                    liveStreamsDBModel.setCategoryName(rawQuery.getString(14));
                    liveStreamsDBModel.setSeriesNo(rawQuery.getString(15));
                    liveStreamsDBModel.setLive(rawQuery.getString(16));
                    liveStreamsDBModel.setContaiinerExtension(rawQuery.getString(17));
                    liveStreamsDBModel.setUserIdReffered(rawQuery.getInt(18));
                    liveStreamsDBModel.setMovieElapsedTime(rawQuery.getLong(19));
                    liveStreamsDBModel.setMovieDuraton(rawQuery.getLong(20));
                    liveStreamsDBModel.setIsRecentlyWatched(rawQuery.getString(21));
                    liveStreamsDBModel.setRatingFromTen(rawQuery.getString(22));
                    liveStreamsDBModel.setRatingFromFive(rawQuery.getString(23));
                    if (SharepreferenceDBHandler.getCurrentAPPType(this.context).equals("onestream_api")) {
                        liveStreamsDBModel.setLinks(rawQuery.getString(24));
                    }
                    arrayList.add(liveStreamsDBModel);
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
            return arrayList;
        } catch (SQLiteDatabaseLockedException | SQLiteException unused2) {
            return null;
        }
    }

    public int getUncatCount(String str, String str2) {
        StringBuilder sb;
        String str3;
        if (SharepreferenceDBHandler.getCurrentAPPType(this.context).equals("onestream_api")) {
            sb = new StringBuilder();
            str3 = "SELECT  COUNT(*) FROM iptv_movie_streams_recent_watch_one_stream WHERE ( stream_type LIKE '%";
        } else {
            sb = new StringBuilder();
            str3 = "SELECT  COUNT(*) FROM iptv_movie_streams_recent_watch WHERE ( stream_type LIKE '%";
        }
        sb.append(str3);
        sb.append(str2);
        sb.append("%' OR ");
        sb.append("stream_type");
        sb.append(" LIKE '%radio%' )  AND ");
        sb.append("categoryID");
        sb.append("='");
        sb.append(str);
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

    public int getVodRecentwatchmCount() {
        StringBuilder sb;
        String str;
        int userID = SharepreferenceDBHandler.getUserID(this.context);
        if (SharepreferenceDBHandler.getCurrentAPPType(this.context).equals("onestream_api")) {
            sb = new StringBuilder();
            str = "SELECT  COUNT(*) FROM iptv_movie_streams_recent_watch_one_stream WHERE user_id_referred=";
        } else {
            sb = new StringBuilder();
            str = "SELECT  COUNT(*) FROM iptv_movie_streams_recent_watch WHERE user_id_referred=";
        }
        sb.append(str);
        sb.append(userID);
        sb.append(" AND ");
        sb.append("is_watched");
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

    public int isStreamAvailable(String str, int i) {
        StringBuilder sb;
        String str2;
        if (SharepreferenceDBHandler.getCurrentAPPType(this.context).equals("onestream_api")) {
            sb = new StringBuilder();
            str2 = "SELECT  COUNT(*) FROM iptv_movie_streams_recent_watch_one_stream WHERE stream_id='";
        } else {
            sb = new StringBuilder();
            str2 = "SELECT  COUNT(*) FROM iptv_movie_streams_recent_watch WHERE stream_id='";
        }
        sb.append(str2);
        sb.append(str);
        sb.append("' AND ");
        sb.append("user_id_referred");
        sb.append("='");
        sb.append(i);
        sb.append("'");
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
        sQLiteDatabase.execSQL(this.CREATE_LIVE_AVAILABLE_CHANELS);
        sQLiteDatabase.execSQL(this.CREATE_LIVE_AVAILABLE_CHANELS_ONE_STREAM);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i < 2) {
            sQLiteDatabase.execSQL(this.ALTER_MOVIE_KEY_IS_RECENT_WATCHED);
        }
        if (i < 3) {
            sQLiteDatabase.execSQL(this.ALTER_RATING_COLUMN1);
            sQLiteDatabase.execSQL(this.ALTER_RATING_COLUMN2);
        }
    }

    public int updateAllRecordsRecentWatchDB() {
        String str;
        StringBuilder sb;
        int userID = SharepreferenceDBHandler.getUserID(this.context);
        SQLiteDatabase writableDatabase = getWritableDatabase();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("is_watched", "0");
            if (SharepreferenceDBHandler.getCurrentAPPType(this.context).equals("onestream_api")) {
                str = "iptv_movie_streams_recent_watch_one_stream";
                sb = new StringBuilder();
                sb.append("user_id_referred=");
                sb.append(userID);
            } else {
                str = "iptv_movie_streams_recent_watch";
                sb = new StringBuilder();
                sb.append("user_id_referred=");
                sb.append(userID);
            }
            return writableDatabase.update(str, contentValues, sb.toString(), (String[]) null);
        } catch (Exception unused) {
            return 0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00bd A[Catch: SQLiteException -> 0x0101, SQLiteDatabaseLockedException -> 0x0105, TRY_LEAVE, TryCatch #3 {SQLiteDatabaseLockedException -> 0x0105, SQLiteException -> 0x0101, blocks: (B:3:0x000e, B:6:0x0024, B:7:0x0049, B:8:0x0077, B:11:0x0088, B:29:0x008e, B:30:0x00a2, B:14:0x00b7, B:16:0x00bd, B:19:0x00e2, B:21:0x00f7, B:24:0x00ec, B:26:0x00fd, B:37:0x00a9, B:39:0x00ad, B:40:0x0051), top: B:2:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00fb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean updateResumePlayerStatuTimes(java.lang.String r16, java.lang.String r17, boolean r18, long r19, long r21, int r23) {
        /*
            Method dump skipped, instructions count: 265
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.model.database.RecentWatchDBHandler.updateResumePlayerStatuTimes(java.lang.String, java.lang.String, boolean, long, long, int):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x009c A[Catch: SQLiteException -> 0x00d7, SQLiteDatabaseLockedException -> 0x00db, TRY_LEAVE, TryCatch #3 {SQLiteException -> 0x00d7, SQLiteDatabaseLockedException -> 0x00db, blocks: (B:3:0x0007, B:6:0x001b, B:7:0x0034, B:8:0x0056, B:11:0x0067, B:29:0x006d, B:30:0x0081, B:14:0x0096, B:16:0x009c, B:19:0x00b8, B:21:0x00cd, B:24:0x00c2, B:26:0x00d3, B:37:0x0088, B:39:0x008c, B:40:0x003c), top: B:2:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00d1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean updateResumePlayerStatus(java.lang.String r10, java.lang.String r11, boolean r12, long r13) {
        /*
            r9 = this;
            java.lang.String r12 = "exception"
            java.lang.String r0 = "msg"
            java.lang.String r1 = "onestream_api"
            r2 = 0
            android.content.Context r3 = r9.context     // Catch: android.database.sqlite.SQLiteException -> Ld7 android.database.sqlite.SQLiteDatabaseLockedException -> Ldb
            java.lang.String r3 = com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler.getCurrentAPPType(r3)     // Catch: android.database.sqlite.SQLiteException -> Ld7 android.database.sqlite.SQLiteDatabaseLockedException -> Ldb
            boolean r3 = r3.equals(r1)     // Catch: android.database.sqlite.SQLiteException -> Ld7 android.database.sqlite.SQLiteDatabaseLockedException -> Ldb
            java.lang.String r4 = "'"
            java.lang.String r5 = " = '"
            java.lang.String r6 = "stream_id"
            java.lang.String r7 = "' AND "
            if (r3 == 0) goto L3c
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: android.database.sqlite.SQLiteException -> Ld7 android.database.sqlite.SQLiteDatabaseLockedException -> Ldb
            r3.<init>()     // Catch: android.database.sqlite.SQLiteException -> Ld7 android.database.sqlite.SQLiteDatabaseLockedException -> Ldb
            java.lang.String r8 = "SELECT rowid FROM iptv_movie_streams_recent_watch_one_stream WHERE stream_type = '"
            r3.append(r8)     // Catch: android.database.sqlite.SQLiteException -> Ld7 android.database.sqlite.SQLiteDatabaseLockedException -> Ldb
            r3.append(r11)     // Catch: android.database.sqlite.SQLiteException -> Ld7 android.database.sqlite.SQLiteDatabaseLockedException -> Ldb
            r3.append(r7)     // Catch: android.database.sqlite.SQLiteException -> Ld7 android.database.sqlite.SQLiteDatabaseLockedException -> Ldb
            r3.append(r6)     // Catch: android.database.sqlite.SQLiteException -> Ld7 android.database.sqlite.SQLiteDatabaseLockedException -> Ldb
            r3.append(r5)     // Catch: android.database.sqlite.SQLiteException -> Ld7 android.database.sqlite.SQLiteDatabaseLockedException -> Ldb
            r3.append(r10)     // Catch: android.database.sqlite.SQLiteException -> Ld7 android.database.sqlite.SQLiteDatabaseLockedException -> Ldb
        L34:
            r3.append(r4)     // Catch: android.database.sqlite.SQLiteException -> Ld7 android.database.sqlite.SQLiteDatabaseLockedException -> Ldb
            java.lang.String r10 = r3.toString()     // Catch: android.database.sqlite.SQLiteException -> Ld7 android.database.sqlite.SQLiteDatabaseLockedException -> Ldb
            goto L56
        L3c:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: android.database.sqlite.SQLiteException -> Ld7 android.database.sqlite.SQLiteDatabaseLockedException -> Ldb
            r3.<init>()     // Catch: android.database.sqlite.SQLiteException -> Ld7 android.database.sqlite.SQLiteDatabaseLockedException -> Ldb
            java.lang.String r8 = "SELECT rowid FROM iptv_movie_streams_recent_watch WHERE stream_type = '"
            r3.append(r8)     // Catch: android.database.sqlite.SQLiteException -> Ld7 android.database.sqlite.SQLiteDatabaseLockedException -> Ldb
            r3.append(r11)     // Catch: android.database.sqlite.SQLiteException -> Ld7 android.database.sqlite.SQLiteDatabaseLockedException -> Ldb
            r3.append(r7)     // Catch: android.database.sqlite.SQLiteException -> Ld7 android.database.sqlite.SQLiteDatabaseLockedException -> Ldb
            r3.append(r6)     // Catch: android.database.sqlite.SQLiteException -> Ld7 android.database.sqlite.SQLiteDatabaseLockedException -> Ldb
            r3.append(r5)     // Catch: android.database.sqlite.SQLiteException -> Ld7 android.database.sqlite.SQLiteDatabaseLockedException -> Ldb
            r3.append(r10)     // Catch: android.database.sqlite.SQLiteException -> Ld7 android.database.sqlite.SQLiteDatabaseLockedException -> Ldb
            goto L34
        L56:
            r9.getReadableDatabase()     // Catch: android.database.sqlite.SQLiteException -> Ld7 android.database.sqlite.SQLiteDatabaseLockedException -> Ldb
            android.database.sqlite.SQLiteDatabase r11 = r9.getWritableDatabase()     // Catch: android.database.sqlite.SQLiteException -> Ld7 android.database.sqlite.SQLiteDatabaseLockedException -> Ldb
            r3 = 0
            android.database.Cursor r10 = r11.rawQuery(r10, r3)     // Catch: android.database.sqlite.SQLiteException -> Ld7 android.database.sqlite.SQLiteDatabaseLockedException -> Ldb
            r3 = 1
            java.lang.String r4 = ""
            if (r10 == 0) goto L88
            boolean r5 = r10.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> Ld7 android.database.sqlite.SQLiteDatabaseLockedException -> Ldb
            if (r5 == 0) goto L95
        L6d:
            java.lang.String r5 = "id"
            int r5 = r10.getColumnIndex(r5)     // Catch: java.lang.NumberFormatException -> L80 android.database.sqlite.SQLiteException -> Ld7 android.database.sqlite.SQLiteDatabaseLockedException -> Ldb
            java.lang.String r5 = r10.getString(r5)     // Catch: java.lang.NumberFormatException -> L80 android.database.sqlite.SQLiteException -> Ld7 android.database.sqlite.SQLiteDatabaseLockedException -> Ldb
            int r5 = java.lang.Integer.parseInt(r5)     // Catch: java.lang.NumberFormatException -> L80 android.database.sqlite.SQLiteException -> Ld7 android.database.sqlite.SQLiteDatabaseLockedException -> Ldb
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch: java.lang.NumberFormatException -> L80 android.database.sqlite.SQLiteException -> Ld7 android.database.sqlite.SQLiteDatabaseLockedException -> Ldb
            goto L81
        L80:
            r5 = r4
        L81:
            boolean r6 = r10.moveToNext()     // Catch: android.database.sqlite.SQLiteException -> Ld7 android.database.sqlite.SQLiteDatabaseLockedException -> Ldb
            if (r6 != 0) goto L6d
            goto L96
        L88:
            android.content.Context r5 = r9.context     // Catch: android.database.sqlite.SQLiteException -> Ld7 android.database.sqlite.SQLiteDatabaseLockedException -> Ldb
            if (r5 == 0) goto L95
            java.lang.String r6 = "cursor is null"
            android.widget.Toast r5 = android.widget.Toast.makeText(r5, r6, r3)     // Catch: android.database.sqlite.SQLiteException -> Ld7 android.database.sqlite.SQLiteDatabaseLockedException -> Ldb
            r5.show()     // Catch: android.database.sqlite.SQLiteException -> Ld7 android.database.sqlite.SQLiteDatabaseLockedException -> Ldb
        L95:
            r5 = r4
        L96:
            boolean r4 = r5.equals(r4)     // Catch: android.database.sqlite.SQLiteException -> Ld7 android.database.sqlite.SQLiteDatabaseLockedException -> Ldb
            if (r4 != 0) goto Ld1
            android.content.ContentValues r4 = new android.content.ContentValues     // Catch: android.database.sqlite.SQLiteException -> Ld7 android.database.sqlite.SQLiteDatabaseLockedException -> Ldb
            r4.<init>()     // Catch: android.database.sqlite.SQLiteException -> Ld7 android.database.sqlite.SQLiteDatabaseLockedException -> Ldb
            java.lang.String r6 = "movie_elapsed_time"
            java.lang.Long r13 = java.lang.Long.valueOf(r13)     // Catch: android.database.sqlite.SQLiteException -> Ld7 android.database.sqlite.SQLiteDatabaseLockedException -> Ldb
            r4.put(r6, r13)     // Catch: android.database.sqlite.SQLiteException -> Ld7 android.database.sqlite.SQLiteDatabaseLockedException -> Ldb
            android.content.Context r13 = r9.context     // Catch: android.database.sqlite.SQLiteException -> Ld7 android.database.sqlite.SQLiteDatabaseLockedException -> Ldb
            java.lang.String r13 = com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler.getCurrentAPPType(r13)     // Catch: android.database.sqlite.SQLiteException -> Ld7 android.database.sqlite.SQLiteDatabaseLockedException -> Ldb
            boolean r13 = r13.equals(r1)     // Catch: android.database.sqlite.SQLiteException -> Ld7 android.database.sqlite.SQLiteDatabaseLockedException -> Ldb
            java.lang.String r14 = "id= ?"
            if (r13 == 0) goto Lc2
            java.lang.String r13 = "iptv_movie_streams_recent_watch_one_stream"
            java.lang.String[] r1 = new java.lang.String[]{r5}     // Catch: android.database.sqlite.SQLiteException -> Ld7 android.database.sqlite.SQLiteDatabaseLockedException -> Ldb
            r11.update(r13, r4, r14, r1)     // Catch: android.database.sqlite.SQLiteException -> Ld7 android.database.sqlite.SQLiteDatabaseLockedException -> Ldb
            goto Lcb
        Lc2:
            java.lang.String r13 = "iptv_movie_streams_recent_watch"
            java.lang.String[] r1 = new java.lang.String[]{r5}     // Catch: android.database.sqlite.SQLiteException -> Ld7 android.database.sqlite.SQLiteDatabaseLockedException -> Ldb
            r11.update(r13, r4, r14, r1)     // Catch: android.database.sqlite.SQLiteException -> Ld7 android.database.sqlite.SQLiteDatabaseLockedException -> Ldb
        Lcb:
            if (r10 == 0) goto Ld0
            r10.close()     // Catch: android.database.sqlite.SQLiteException -> Ld7 android.database.sqlite.SQLiteDatabaseLockedException -> Ldb
        Ld0:
            return r3
        Ld1:
            if (r10 == 0) goto Ld6
            r10.close()     // Catch: android.database.sqlite.SQLiteException -> Ld7 android.database.sqlite.SQLiteDatabaseLockedException -> Ldb
        Ld6:
            return r2
        Ld7:
            android.util.Log.w(r0, r12)
            return r2
        Ldb:
            android.util.Log.w(r0, r12)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.model.database.RecentWatchDBHandler.updateResumePlayerStatus(java.lang.String, java.lang.String, boolean, long):boolean");
    }

    public int updateAllRecordsRecentWatchDB(String str) {
        String str2;
        StringBuilder sb;
        int userID = SharepreferenceDBHandler.getUserID(this.context);
        SQLiteDatabase writableDatabase = getWritableDatabase();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("is_watched", "0");
            if (SharepreferenceDBHandler.getCurrentAPPType(this.context).equals("onestream_api")) {
                str2 = "iptv_movie_streams_recent_watch_one_stream";
                sb = new StringBuilder();
                sb.append("stream_id='");
                sb.append(str);
                sb.append("' AND ");
                sb.append("user_id_referred");
                sb.append("=");
                sb.append(userID);
            } else {
                str2 = "iptv_movie_streams_recent_watch";
                sb = new StringBuilder();
                sb.append("stream_id=");
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
