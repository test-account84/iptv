package com.nst.iptvsmarterstvbox.model.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteClosable;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.AsyncTask;
import android.util.Log;
import com.nst.iptvsmarterstvbox.model.FavouriteDBModel;
import com.nst.iptvsmarterstvbox.model.FavouriteM3UModel;
import com.nst.iptvsmarterstvbox.model.LiveStreamCategoryIdDBModel;
import com.nst.iptvsmarterstvbox.model.LiveStreamsDBModel;
import com.nst.iptvsmarterstvbox.model.M3UCategoriesModel;
import com.nst.iptvsmarterstvbox.model.OneStreamLiveStreamDataModel;
import com.nst.iptvsmarterstvbox.model.OneStreamMovieStreamDataModel;
import com.nst.iptvsmarterstvbox.model.OneStreamSeriesStreamDataModel;
import com.nst.iptvsmarterstvbox.model.callback.GetEpisdoeDetailsCallback;
import com.nst.iptvsmarterstvbox.model.callback.GetSeriesStreamCallback;
import com.nst.iptvsmarterstvbox.model.callback.GetSeriesStreamCategoriesCallback;
import com.nst.iptvsmarterstvbox.model.callback.LiveStreamCategoriesCallback;
import com.nst.iptvsmarterstvbox.model.callback.LiveStreamsCallback;
import com.nst.iptvsmarterstvbox.model.callback.SeriesDBModel;
import com.nst.iptvsmarterstvbox.model.callback.StalkerGetGenresCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerGetSeriesCategoriesCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerGetVodCategoriesCallback;
import com.nst.iptvsmarterstvbox.model.callback.VodCategoriesCallback;
import com.nst.iptvsmarterstvbox.model.callback.VodStreamsCallback;
import com.nst.iptvsmarterstvbox.model.pojo.LiveDataModel;
import com.nst.iptvsmarterstvbox.model.pojo.PanelAvailableChannelsPojo;
import com.nst.iptvsmarterstvbox.model.pojo.StalkerGetAllChannelsPojo2;
import com.nst.iptvsmarterstvbox.model.pojo.StalkerGetGenresPojo;
import com.nst.iptvsmarterstvbox.model.pojo.StalkerGetSeriesCategoriesPojo;
import com.nst.iptvsmarterstvbox.model.pojo.StalkerGetVodCategoriesPojo;
import com.nst.iptvsmarterstvbox.model.pojo.XMLTVProgrammePojo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import m7.w;
import u7.a;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class LiveStreamDBHandler extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "iptv_live_streams_tv.db";
    private static final int DATABASE_VERSION = 12;
    private static final String KEY_ADDED = "added";
    private static final String KEY_ADDED_VOD = "added";
    private static final String KEY_APP_TYPE = "app_type";
    private static final String KEY_AUTO_ID = "auto_id";
    private static final String KEY_AVAIL_CHANNEL_CATEGORY_NAME = "category_name";
    private static final String KEY_AVAIL_CHANNEL_CONTAINER_EXTENSION = "container_extension";
    private static final String KEY_AVAIL_CHANNEL_IS_ADULT = "is_adult";
    private static final String KEY_AVAIL_CHANNEL_LINKS = "links";
    private static final String KEY_AVAIL_CHANNEL_LIVE = "live";
    private static final String KEY_AVAIL_CHANNEL_RATING_FROM_FIVE = "rating_from_five";
    private static final String KEY_AVAIL_CHANNEL_RATING_FROM_TEN = "rating_from_ten";
    private static final String KEY_AVAIL_CHANNEL_SERIES_NO = "series_no";
    private static final String KEY_AVAIL_CHANNEL_TYPE_NAME = "type_name";
    private static final String KEY_AVAIL_CHANNEL_URL = "url";
    private static final String KEY_AVAIL_CHANNEL_URL_FIRE_DB = "url_fire_db";
    private static final String KEY_BACKDROPE = "backdrop";
    private static final String KEY_CAST = "cast_series_stream_v2";
    private static final String KEY_CATEGORY_ALIAS_LIVE = "category_alias_live";
    private static final String KEY_CATEGORY_ALIAS_MOVIE = "category_alias_movie";
    private static final String KEY_CATEGORY_ALIAS_SERIES = "category_alias_series_v2";
    private static final String KEY_CATEGORY_CENSORED_LIVE = "category_censored_live";
    private static final String KEY_CATEGORY_CENSORED_MOVIE = "category_censored_movie";
    private static final String KEY_CATEGORY_CENSORED_SERIES = "category_censored_series_v2";
    private static final String KEY_CATEGORY_ID = "categoryID";
    private static final String KEY_CATEGORY_ID_LIVE = "categoryID_live";
    private static final String KEY_CATEGORY_ID_LIVE_STREAMS = "categoryID";
    private static final String KEY_CATEGORY_ID_MOVIE = "categoryID_movie";
    private static final String KEY_CATEGORY_ID_S = "category_id_series_stream_v2";
    private static final String KEY_CATEGORY_ID_SERIES = "category_id_series_v2";
    private static final String KEY_CATEGORY_ID_VOD = "categoryId";
    private static final String KEY_CATEGORY_NAME = "categoryname";
    private static final String KEY_CATEGORY_NAME_LIVE = "categoryname_live";
    private static final String KEY_CATEGORY_NAME_MOVIE = "categoryname_movie";
    private static final String KEY_CATEGORY_NAME_SERIES = "category_name_series_v2";
    private static final String KEY_CHANNEL_ID = "channel_id";
    private static final String KEY_CMD = "cmd";
    private static final String KEY_CONTAINER_EXT_VOD = "containerExtension";
    private static final String KEY_COVER = "stream_cover_series_stream_v2";
    private static final String KEY_CUSTOMER_SID = "custom_sid";
    private static final String KEY_CUSTOM_SID_VOD = "customSid";
    private static final String KEY_DATE_IMPORT_STATUS = "date";
    private static final String KEY_DB_CATEGORY = "iptv_db_updated_status_category";
    private static final String KEY_DB_CATEGORY_ID = "iptv_db_updated_status_category_id";
    private static final String KEY_DB_LAST_UPDATED_DATE = "iptv_db_updated_status_last_updated_date";
    private static final String KEY_DB_SERIES_M3U_STREAM_CAT_ID = "series_m3u_stream_container_cat_id";
    private static final String KEY_DB_SERIES_M3U_STREAM_EXT = "series_m3u_stream_container_ext";
    private static final String KEY_DB_SERIES_M3U_STREAM_ID = "series_m3u_stream_id";
    private static final String KEY_DB_SERIES_M3U_STREAM_IMAGE = "series_m3u_stream_container_image";
    private static final String KEY_DB_SERIES_M3U_STREAM_TITLE = "series_m3u_stream_title";
    private static final String KEY_DB_STATUS_STATE = "iptv_db_updated_status_state";
    private static final String KEY_DEFAULT_SOURCE = "default_source";
    private static final String KEY_DESCRIPTION = "description";
    private static final String KEY_DIRECTOR = "director_series_stream_v2";
    private static final String KEY_DIRECT_SOURCE = "direct_source";
    private static final String KEY_DIRECT_SOURCE_VOD = "directSource";
    private static final String KEY_EPGURL = "epgurl";
    private static final String KEY_EPG_CHANNEL_ID = "epg_channel_id";
    private static final String KEY_GENERE = "genre_series_stream_v2";
    private static final String KEY_ID = "id";
    private static final String KEY_ID_AUTO_EPG = "id_epg_aut0";
    private static final String KEY_ID_AUTO_VOD = "id_auto_vod";
    private static final String KEY_ID_DB_UPDATE_STATUS = "iptv_db_update_status_id";
    private static final String KEY_ID_IMPORT_STATUS = "id";
    private static final String KEY_ID_LIVE = "id_live";
    private static final String KEY_ID_LIVE_STREAMS = "id";
    private static final String KEY_ID_MAG_PORTAL = "id_auto_mag";
    private static final String KEY_ID_MOVIE = "id_movie";
    private static final String KEY_ID_PARENT_ID = "paent_id";
    private static final String KEY_ID_PASWORD = "id_password";
    private static final String KEY_ID_PASWORD_STATUS = "id_password_status";
    private static final String KEY_ID_SERIES_M3U_STREAMS_AUTO_INC = "series_m3u_streams_auto_inc";
    private static final String KEY_ID_SERIES_STREAMS = "id_series_stream_v2";
    private static final String KEY_ID_VOD = "id_series_v2";
    private static final String KEY_LAST_MODIFIED = "last_modified_series_stream_v2";
    private static final String KEY_MAG_PORTAL = "mag_portal";
    private static final String KEY_MOVE_TO = "move_to";
    private static final String KEY_MOVIE_DURTION = "movie_duration";
    private static final String KEY_MOVIE_ELAPSED_TIME = "movie_elapsed_time";
    private static final String KEY_NAME = "name";
    private static final String KEY_NAME_S = "name_series_stream_v2";
    private static final String KEY_NAME_VOD = "name";
    private static final String KEY_NUM_LIVE_STREAMS = "num";
    private static final String KEY_NUM_SERIES_STREAMS = "num_series_stream_v2";
    private static final String KEY_NUM_VOD = "num_";
    private static final String KEY_PASSWORD_STATUS = "password_status";
    private static final String KEY_PASSWORD_STATUS_CAT_ID = "password_status_cat_id";
    private static final String KEY_PASSWORD_USER_DETAIL = "user_detail";
    private static final String KEY_PLOT = "plot_series_stream_v2";
    private static final String KEY_RATING = "rating_series_stream_v2";
    private static final String KEY_RELEASE_DATE = "release_date_series_stream_v2";
    private static final String KEY_SERIAL_NO_VOD = "seriesNo";
    private static final String KEY_SERIES_ID = "stream_id_series_stream_v2";
    private static final String KEY_SOURCE_NAME = "name";
    private static final String KEY_SOURCE_REF_ID = "source_ref_id";
    private static final String KEY_SOURCE_TYPE = "source_type";
    private static final String KEY_START = "start";
    private static final String KEY_STATUS_IMPORT_STATUS = "status";
    private static final String KEY_STOP = "stop";
    private static final String KEY_STREAMTYPE_VOD = "streamType";
    private static final String KEY_STREAM_ICON = "stream_icon";
    private static final String KEY_STREAM_ICON_VOD = "streamIcon";
    private static final String KEY_STREAM_ID = "stream_id";
    private static final String KEY_STREAM_ID_URL = "stream_id_url";
    private static final String KEY_STREAM_ID_VOD = "streamId";
    private static final String KEY_STREAM_TYPE = "stream_type_series_stream_v2";
    private static final String KEY_STRESM_TYPE = "stream_type";
    private static final String KEY_TIME_IMPORT_STATUS = "time";
    private static final String KEY_TITLE = "title";
    private static final String KEY_TV_ARCHIVE = "tv_archive";
    private static final String KEY_TV_ARCHIVE_DURATION = "tv_archive_duration";
    private static final String KEY_TYPE = "type";
    private static final String KEY_TYPE_IMPORT_STATUS = "type";
    private static final String KEY_URL = "url";
    private static final String KEY_USER_DETAIL = "password_user_detail";
    private static final String KEY_USER_ID = "user_id_referred";
    private static final String KEY_USER_PASSWORD = "password";
    private static final String KEY_YOUTUBE_TRAILER = "youtube_trailer";
    private static final String TABLE_DATABASE_IMPORT_STATUS = "iptv_import_status";
    private static final String TABLE_DATABASE_UPDATE_STATUS = "iptv_db_update_status";
    private static final String TABLE_EPG = "epg";
    private static final String TABLE_EPG_M3U = "epg_m3u";
    private static final String TABLE_EPG_SOURCES = "iptv_epg_sources";
    private static final String TABLE_EPG_SOURCES_M3U = "iptv_epg_sources_m3u";
    private static final String TABLE_IPTV_ALL_M3U_CATEGORY = "iptv_m3u_all_category";
    private static final String TABLE_IPTV_AVAILABLE_CHANNNELS = "iptv_live_streams";
    private static final String TABLE_IPTV_AVAILABLE_CHANNNELS_ALL_M3U = "iptv_live_streams_m3u_all";
    private static final String TABLE_IPTV_AVAILABLE_CHANNNELS_M3U = "iptv_live_streams_m3u";
    private static final String TABLE_IPTV_FAVOURITES_M3U = "iptv_m3u_favourites";
    private static final String TABLE_IPTV_LIVE_CATEGORY = "iptv_live_category";
    private static final String TABLE_IPTV_LIVE_CATEGORY_M3U = "iptv_live_category_m3u";
    private static final String TABLE_IPTV_LIVE_STREAMS_CATEGORY = "iptv_live_streams_category";
    private static final String TABLE_IPTV_LIVE_WATCHED = "iptv_live_watched";
    private static final String TABLE_IPTV_MAG_PORTAL = "iptv_mag_portal_table";
    private static final String TABLE_IPTV_MOVIE_CATEGORY = "iptv_movie_category";
    private static final String TABLE_IPTV_MOVIE_CATEGORY_M3U = "iptv_movie_category_m3u";
    private static final String TABLE_IPTV_ONESTREAM_LIVE_CATEGORY = "iptv_onestream_live_category";
    private static final String TABLE_IPTV_ONSESTREAM_MOVIE_CATEGORY = "iptv_onestream_movie_category";
    private static final String TABLE_IPTV_PASSWORD = "iptv_password_table";
    private static final String TABLE_IPTV_PASSWORD_M3U = "iptv_password_table_m3u";
    private static final String TABLE_IPTV_PASSWORD_STATUS = "iptv_password_status_table";
    private static final String TABLE_IPTV_PASSWORD_STATUS_M3U = "iptv_password_status_table_m3u";
    private static final String TABLE_IPTV_RECENT_WATCHED_M3U = "iptv_recent_watched_m3u";
    private static final String TABLE_IPTV_SERIES_CATEGORY = "series_category_v2";
    private static final String TABLE_IPTV_SERIES_CATEGORY_M3U = "iptv_series_category_m3u";
    private static final String TABLE_IPTV_SERIES_STREAMS = "series_streams_v2";
    private static final String TABLE_IPTV_STALKER_ALL_CHANNNELS = "iptv_stalker_live_streams";
    private static final String TABLE_IPTV_STALKER_LIVE_CATEGORY = "iptv_stalker_live_category";
    private static final String TABLE_IPTV_STALKER_MOVIE_CATEGORY = "iptv_stalker_movie_category";
    private static final String TABLE_IPTV_STALKER_SERIES_CATEGORY = "iptv_stalker_series_category";
    private static final String TABLE_IPTV_VOD_STREAMS = "iptv_vod_streams";
    private static final String TABLE_M3U_SERIES_STREAMS = "series_m3u_streams";
    private static final String TABLE_ONESTREAM_IPTV_AVAILABLE_CHANNNELS = "onestream_iptv_live_streams";
    private static final String TABLE_ONESTREAM_IPTV_SERIES_CATEGORY = "onestream_series_category_v2";
    private static final String TABLE_ONESTREAM_IPTV_SERIES_STREAMS = "onestream_series_streams_v2";
    private String ALTER_PASSWORD_STATUS_TABLE_2;
    private String ALTER_PASSWORD_TABLE_1;
    private String ALTER_RATING_COLUMN1;
    private String ALTER_RATING_COLUMN2;
    private String ALTER_TYPE_COLUMN_RECENT_WATCHED_CHANNNELS;
    private String ALTER_URL_FIREBASE_DB_CHANNNELS_ALL_M3U;
    private String ALTER_URL_FIREBASE_DB_CHANNNELS_M3U;
    private String ALTER_URL_FIREBASE_DB_WATCHED_M3U;
    String CREATE_DB_UPDATED_STATUS_TABLE;
    String CREATE_EPG_M3U_TABLE;
    String CREATE_EPG_TABLE;
    String CREATE_FAV_M3U_TABLE;
    String CREATE_LIVE_AVAILABLE_CHANELS;
    String CREATE_LIVE_AVAILABLE_CHANELS_ALL_M3U;
    String CREATE_LIVE_AVAILABLE_CHANELS_M3U;
    String CREATE_LIVE_CATEGORY_TABLE;
    String CREATE_LIVE_CATEGORY_TABLE_M3U;
    String CREATE_LIVE_ONESTREAM_AVAILABLE_CHANELS;
    String CREATE_LIVE_STALKER_AVAILABLE_CHANNELS;
    String CREATE_LIVE_STALKER_CATEGORY_TABLE;
    String CREATE_LIVE_STREAM_CATEGORY_TABLE;
    String CREATE_LIVE_WATCHED_TABLE;
    String CREATE_M3U_CATEGORY_TABLE;
    String CREATE_M3U_SERIES_STREAMS_TABLE;
    String CREATE_MAG_PORTAL_TABLE;
    String CREATE_MOVIE_CATEGORY_TABLE;
    String CREATE_MOVIE_CATEGORY_TABLE_M3U;
    String CREATE_MOVIE_STALKER_CATEGORY_TABLE;
    String CREATE_ONESTREAM_LIVE_CATEGORY_TABLE;
    String CREATE_ONESTREAM_MOVIE_CATEGORY_TABLE;
    String CREATE_ONESTREAM_SERIES_CATEGORY_TABLE;
    String CREATE_ONESTREAM_SERIES_STREAMS;
    String CREATE_PASSWORD_STATUS_TABLE;
    String CREATE_PASSWORD_STATUS_TABLE_M3U;
    String CREATE_PASSWORD_TABLE;
    String CREATE_PASSWORD_TABLE_M3U;
    String CREATE_RECENT_WATCHED_M3U;
    String CREATE_SERIES_CATEGORY_TABLE;
    String CREATE_SERIES_CATEGORY_TABLE_M3U;
    String CREATE_SERIES_STALKER_CATEGORY_TABLE;
    String CREATE_SERIES_STREAMS;
    String CREATE_TABLE_EPG_SOURCES;
    String CREATE_TABLE_EPG_SOURCES_M3U;
    String CREATE_VOD_TABLE;
    Context context;
    SQLiteDatabase db;
    private int totalMilliSec;

    public LiveStreamDBHandler(Context context) {
        super(context, "iptv_live_streams_tv.db", (SQLiteDatabase.CursorFactory) null, 12);
        this.totalMilliSec = 0;
        this.CREATE_LIVE_CATEGORY_TABLE = "CREATE TABLE IF NOT EXISTS iptv_live_category(id_live INTEGER PRIMARY KEY,categoryID_live TEXT,categoryname_live TEXT,paent_id TEXT,user_id_referred TEXT)";
        this.CREATE_MOVIE_CATEGORY_TABLE = "CREATE TABLE IF NOT EXISTS iptv_movie_category(id_movie INTEGER PRIMARY KEY,categoryID_movie TEXT,categoryname_movie TEXT,paent_id TEXT,user_id_referred TEXT)";
        this.CREATE_LIVE_STREAM_CATEGORY_TABLE = "CREATE TABLE IF NOT EXISTS iptv_live_streams_category(id INTEGER PRIMARY KEY,categoryID TEXT,categoryname TEXT)";
        this.CREATE_M3U_CATEGORY_TABLE = "CREATE TABLE IF NOT EXISTS iptv_m3u_all_category(id INTEGER PRIMARY KEY,categoryID TEXT,categoryname TEXT,user_id_referred TEXT)";
        this.CREATE_ONESTREAM_MOVIE_CATEGORY_TABLE = "CREATE TABLE IF NOT EXISTS iptv_onestream_movie_category(id_movie INTEGER PRIMARY KEY,categoryID_movie TEXT,categoryname_movie TEXT,paent_id TEXT,user_id_referred TEXT)";
        this.CREATE_ONESTREAM_LIVE_CATEGORY_TABLE = "CREATE TABLE IF NOT EXISTS iptv_onestream_live_category(id_live INTEGER PRIMARY KEY,categoryID_live TEXT,categoryname_live TEXT,paent_id TEXT,user_id_referred TEXT)";
        this.CREATE_LIVE_CATEGORY_TABLE_M3U = "CREATE TABLE IF NOT EXISTS iptv_live_category_m3u(id INTEGER PRIMARY KEY,categoryID TEXT,categoryname TEXT,user_id_referred TEXT)";
        this.CREATE_MOVIE_CATEGORY_TABLE_M3U = "CREATE TABLE IF NOT EXISTS iptv_movie_category_m3u(id INTEGER PRIMARY KEY,categoryID TEXT,categoryname TEXT,paent_id TEXT,user_id_referred TEXT)";
        this.CREATE_SERIES_CATEGORY_TABLE_M3U = "CREATE TABLE IF NOT EXISTS iptv_series_category_m3u(id INTEGER PRIMARY KEY,categoryID TEXT,categoryname TEXT,user_id_referred TEXT)";
        this.CREATE_PASSWORD_TABLE = "CREATE TABLE IF NOT EXISTS iptv_password_table(id_password INTEGER PRIMARY KEY,user_detail TEXT,password TEXT,user_id_referred TEXT)";
        this.CREATE_PASSWORD_TABLE_M3U = "CREATE TABLE IF NOT EXISTS iptv_password_table_m3u(id_password INTEGER PRIMARY KEY,user_detail TEXT,password TEXT,user_id_referred TEXT)";
        this.ALTER_PASSWORD_TABLE_1 = "ALTER TABLE iptv_password_table ADD COLUMN user_id_referred TEXT;";
        this.CREATE_PASSWORD_STATUS_TABLE = "CREATE TABLE IF NOT EXISTS iptv_password_status_table(id_password_status INTEGER PRIMARY KEY,password_status_cat_id TEXT,password_user_detail TEXT,password_status TEXT,user_id_referred TEXT)";
        this.CREATE_PASSWORD_STATUS_TABLE_M3U = "CREATE TABLE IF NOT EXISTS iptv_password_status_table_m3u(id_password_status INTEGER PRIMARY KEY,password_status_cat_id TEXT,password_user_detail TEXT,password_status TEXT,user_id_referred TEXT)";
        this.ALTER_PASSWORD_STATUS_TABLE_2 = "ALTER TABLE iptv_password_status_table ADD COLUMN user_id_referred TEXT;";
        this.CREATE_LIVE_ONESTREAM_AVAILABLE_CHANELS = "CREATE TABLE IF NOT EXISTS onestream_iptv_live_streams(id INTEGER PRIMARY KEY,num TEXT,name TEXT,stream_type TEXT,stream_id TEXT,stream_icon TEXT,epg_channel_id TEXT,added TEXT,categoryID TEXT,custom_sid TEXT,tv_archive TEXT,direct_source TEXT,tv_archive_duration TEXT,type_name TEXT,category_name TEXT,series_no TEXT,live TEXT,container_extension TEXT,rating_from_ten TEXT,rating_from_five TEXT,links TEXT,is_adult TEXT,user_id_referred TEXT)";
        this.CREATE_LIVE_AVAILABLE_CHANELS = "CREATE TABLE IF NOT EXISTS iptv_live_streams(id INTEGER PRIMARY KEY,num TEXT,name TEXT,stream_type TEXT,stream_id TEXT,stream_icon TEXT,epg_channel_id TEXT,added TEXT,categoryID TEXT,custom_sid TEXT,tv_archive TEXT,direct_source TEXT,tv_archive_duration TEXT,type_name TEXT,category_name TEXT,series_no TEXT,live TEXT,container_extension TEXT,rating_from_ten TEXT,rating_from_five TEXT,user_id_referred TEXT)";
        this.CREATE_LIVE_STALKER_AVAILABLE_CHANNELS = "CREATE TABLE IF NOT EXISTS iptv_stalker_live_streams(id INTEGER PRIMARY KEY,stream_id TEXT,num TEXT,name TEXT,cmd TEXT,stream_icon TEXT,epg_channel_id TEXT,categoryID TEXT,tv_archive TEXT,user_id_referred TEXT)";
        this.CREATE_LIVE_AVAILABLE_CHANELS_M3U = "CREATE TABLE IF NOT EXISTS iptv_live_streams_m3u(id INTEGER PRIMARY KEY,num TEXT,name TEXT,stream_type TEXT,stream_id TEXT,stream_icon TEXT,epg_channel_id TEXT,added TEXT,categoryID TEXT,custom_sid TEXT,tv_archive TEXT,direct_source TEXT,tv_archive_duration TEXT,type_name TEXT,category_name TEXT,series_no TEXT,live TEXT,container_extension TEXT,url TEXT,user_id_referred TEXT,url_fire_db TEXT)";
        this.CREATE_RECENT_WATCHED_M3U = "CREATE TABLE IF NOT EXISTS iptv_recent_watched_m3u(id INTEGER PRIMARY KEY,num TEXT,name TEXT,stream_type TEXT,stream_id TEXT,stream_icon TEXT,epg_channel_id TEXT,added TEXT,categoryID TEXT,custom_sid TEXT,tv_archive TEXT,direct_source TEXT,tv_archive_duration TEXT,type_name TEXT,category_name TEXT,series_no TEXT,live TEXT,container_extension TEXT,url TEXT,user_id_referred TEXT,movie_elapsed_time TEXT,movie_duration TEXT,url_fire_db TEXT)";
        this.CREATE_LIVE_AVAILABLE_CHANELS_ALL_M3U = "CREATE TABLE IF NOT EXISTS iptv_live_streams_m3u_all(id INTEGER PRIMARY KEY,num TEXT,name TEXT,stream_type TEXT,stream_id TEXT,stream_icon TEXT,epg_channel_id TEXT,added TEXT,categoryID TEXT,custom_sid TEXT,tv_archive TEXT,direct_source TEXT,tv_archive_duration TEXT,type_name TEXT,category_name TEXT,series_no TEXT,live TEXT,url TEXT,container_extension TEXT,user_id_referred TEXT,move_to TEXT,url_fire_db TEXT)";
        this.CREATE_EPG_TABLE = "CREATE TABLE IF NOT EXISTS epg(id_epg_aut0 INTEGER PRIMARY KEY,title TEXT,start TEXT,stop TEXT,description TEXT,channel_id TEXT,user_id_referred TEXT,source_ref_id TEXT)";
        this.CREATE_EPG_M3U_TABLE = "CREATE TABLE IF NOT EXISTS epg_m3u(id_epg_aut0 INTEGER PRIMARY KEY,title TEXT,start TEXT,stop TEXT,description TEXT,channel_id TEXT,user_id_referred TEXT,source_ref_id TEXT)";
        this.CREATE_FAV_M3U_TABLE = "CREATE TABLE IF NOT EXISTS iptv_m3u_favourites(id INTEGER PRIMARY KEY,url TEXT,user_id_referred TEXT,name TEXT,categoryID TEXT)";
        this.CREATE_VOD_TABLE = "CREATE TABLE IF NOT EXISTS iptv_vod_streams(id_auto_vod INTEGER PRIMARY KEY,num_ TEXT,name TEXT,streamType TEXT,streamId TEXT,streamIcon TEXT,added TEXT,categoryId TEXT,seriesNo TEXT,containerExtension TEXT,customSid TEXT,directSource TEXT)";
        this.CREATE_DB_UPDATED_STATUS_TABLE = "CREATE TABLE IF NOT EXISTS iptv_import_status(id INTEGER PRIMARY KEY,type TEXT,status TEXT,date TEXT,time TEXT,user_id_referred TEXT,app_type TEXT,source_ref_id TEXT)";
        this.CREATE_MAG_PORTAL_TABLE = "CREATE TABLE IF NOT EXISTS iptv_mag_portal_table(id_auto_mag INTEGER PRIMARY KEY,mag_portal TEXT)";
        this.CREATE_M3U_SERIES_STREAMS_TABLE = "CREATE TABLE IF NOT EXISTS series_m3u_streams(series_m3u_streams_auto_inc INTEGER PRIMARY KEY,series_m3u_stream_id TEXT,series_m3u_stream_title TEXT,series_m3u_stream_container_ext TEXT,series_m3u_stream_container_image TEXT,series_m3u_stream_container_cat_id TEXT)";
        this.ALTER_RATING_COLUMN1 = "ALTER TABLE iptv_live_streams ADD COLUMN rating_from_ten TEXT;";
        this.ALTER_RATING_COLUMN2 = "ALTER TABLE iptv_live_streams ADD COLUMN rating_from_five TEXT;";
        this.ALTER_URL_FIREBASE_DB_CHANNNELS_ALL_M3U = "ALTER TABLE iptv_live_streams_m3u_all ADD COLUMN url_fire_db TEXT;";
        this.ALTER_URL_FIREBASE_DB_WATCHED_M3U = "ALTER TABLE iptv_recent_watched_m3u ADD COLUMN url_fire_db TEXT;";
        this.ALTER_URL_FIREBASE_DB_CHANNNELS_M3U = "ALTER TABLE iptv_live_streams_m3u ADD COLUMN url_fire_db TEXT;";
        this.CREATE_TABLE_EPG_SOURCES = "CREATE TABLE IF NOT EXISTS iptv_epg_sources(auto_id INTEGER PRIMARY KEY,user_id_referred TEXT,name TEXT,source_type TEXT,epgurl TEXT,default_source TEXT)";
        this.CREATE_TABLE_EPG_SOURCES_M3U = "CREATE TABLE IF NOT EXISTS iptv_epg_sources_m3u(auto_id INTEGER PRIMARY KEY,user_id_referred TEXT,name TEXT,source_type TEXT,epgurl TEXT,default_source TEXT)";
        this.CREATE_LIVE_WATCHED_TABLE = "CREATE TABLE IF NOT EXISTS iptv_live_watched(id INTEGER PRIMARY KEY,stream_id_url TEXT,user_id_referred TEXT,app_type TEXT,type TEXT)";
        this.ALTER_TYPE_COLUMN_RECENT_WATCHED_CHANNNELS = "ALTER TABLE iptv_live_watched ADD COLUMN type TEXT;";
        this.CREATE_LIVE_STALKER_CATEGORY_TABLE = "CREATE TABLE IF NOT EXISTS iptv_stalker_live_category(id_live INTEGER PRIMARY KEY,categoryID_live TEXT,categoryname_live TEXT,category_alias_live TEXT,category_censored_live TEXT,user_id_referred TEXT)";
        this.CREATE_MOVIE_STALKER_CATEGORY_TABLE = "CREATE TABLE IF NOT EXISTS iptv_stalker_movie_category(id_movie INTEGER PRIMARY KEY,categoryID_movie TEXT,categoryname_movie TEXT,category_alias_movie TEXT,category_censored_movie TEXT,user_id_referred TEXT)";
        this.CREATE_SERIES_CATEGORY_TABLE = "CREATE TABLE IF NOT EXISTS series_category_v2(id_series_v2 INTEGER PRIMARY KEY,category_name_series_v2 TEXT,category_id_series_v2 TEXT,user_id_referred TEXT)";
        this.CREATE_ONESTREAM_SERIES_STREAMS = "CREATE TABLE IF NOT EXISTS onestream_series_streams_v2(id_series_stream_v2 INTEGER PRIMARY KEY,num_series_stream_v2 TEXT,name_series_stream_v2 TEXT,stream_type_series_stream_v2 TEXT,stream_id_series_stream_v2 TEXT,stream_cover_series_stream_v2 TEXT,plot_series_stream_v2 TEXT,cast_series_stream_v2 TEXT,director_series_stream_v2 TEXT,genre_series_stream_v2 TEXT,release_date_series_stream_v2 TEXT,last_modified_series_stream_v2 TEXT,rating_series_stream_v2 TEXT,category_id_series_stream_v2 TEXT,youtube_trailer TEXT,backdrop TEXT,user_id_referred TEXT)";
        this.CREATE_ONESTREAM_SERIES_CATEGORY_TABLE = "CREATE TABLE IF NOT EXISTS onestream_series_category_v2(id_series_v2 INTEGER PRIMARY KEY,category_name_series_v2 TEXT,category_id_series_v2 TEXT,user_id_referred TEXT)";
        this.CREATE_SERIES_STALKER_CATEGORY_TABLE = "CREATE TABLE IF NOT EXISTS iptv_stalker_series_category(id_series_v2 INTEGER PRIMARY KEY,category_name_series_v2 TEXT,category_id_series_v2 TEXT,category_alias_series_v2 TEXT,category_censored_series_v2 TEXT,user_id_referred TEXT)";
        this.CREATE_SERIES_STREAMS = "CREATE TABLE IF NOT EXISTS series_streams_v2(id_series_stream_v2 INTEGER PRIMARY KEY,num_series_stream_v2 TEXT,name_series_stream_v2 TEXT,stream_type_series_stream_v2 TEXT,stream_id_series_stream_v2 TEXT,stream_cover_series_stream_v2 TEXT,plot_series_stream_v2 TEXT,cast_series_stream_v2 TEXT,director_series_stream_v2 TEXT,genre_series_stream_v2 TEXT,release_date_series_stream_v2 TEXT,last_modified_series_stream_v2 TEXT,rating_series_stream_v2 TEXT,category_id_series_stream_v2 TEXT,youtube_trailer TEXT,backdrop TEXT,user_id_referred TEXT)";
        this.context = context;
    }

    private int checkUnCategoryCountLive(String str) {
        StringBuilder sb;
        String str2;
        int userID = SharepreferenceDBHandler.getUserID(this.context);
        if (SharepreferenceDBHandler.getCurrentAPPType(this.context).equals("onestream_api")) {
            sb = new StringBuilder();
            str2 = "SELECT  * FROM iptv_onestream_live_category WHERE categoryID_live ='";
        } else {
            sb = new StringBuilder();
            str2 = "SELECT  * FROM iptv_live_category WHERE categoryID_live ='";
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
            int count = rawQuery.getCount();
            rawQuery.close();
            return count;
        } catch (SQLiteDatabaseLockedException | Exception unused) {
            return 0;
        }
    }

    private int checkUnCategoryCountMovies(String str) {
        StringBuilder sb;
        String str2;
        int userID = SharepreferenceDBHandler.getUserID(this.context);
        if (SharepreferenceDBHandler.getCurrentAPPType(this.context).equals("onestream_api")) {
            sb = new StringBuilder();
            str2 = "SELECT  * FROM iptv_onestream_movie_category WHERE categoryID_movie ='";
        } else {
            sb = new StringBuilder();
            str2 = "SELECT  * FROM iptv_movie_category WHERE categoryID_movie ='";
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
            int count = rawQuery.getCount();
            rawQuery.close();
            return count;
        } catch (SQLiteDatabaseLockedException | Exception unused) {
            return 0;
        }
    }

    private int checkUnCategoryCountSeries(String str) {
        StringBuilder sb;
        String str2;
        int userID = SharepreferenceDBHandler.getUserID(this.context);
        if (SharepreferenceDBHandler.getCurrentAPPType(this.context).equals("onestream_api")) {
            sb = new StringBuilder();
            str2 = "SELECT  * FROM onestream_series_category_v2 WHERE category_id_series_v2 ='";
        } else {
            sb = new StringBuilder();
            str2 = "SELECT  * FROM series_category_v2 WHERE category_id_series_v2 ='";
        }
        sb.append(str2);
        sb.append(str);
        sb.append("' AND ");
        sb.append("user_id_referred");
        sb.append(" = '");
        sb.append(userID);
        sb.append("'");
        try {
            Cursor rawQuery = getReadableDatabase().rawQuery(sb.toString(), (String[]) null);
            int count = rawQuery.getCount();
            rawQuery.close();
            return count;
        } catch (SQLiteDatabaseLockedException | Exception unused) {
            return 0;
        }
    }

    public void addALLM3UCategories(Map map) {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.beginTransaction();
            try {
                ContentValues contentValues = new ContentValues();
                for (M3UCategoriesModel m3UCategoriesModel : map.values()) {
                    if (m3UCategoriesModel.getCategoryId() != null) {
                        contentValues.put("categoryID", m3UCategoriesModel.getCategoryId());
                    } else {
                        contentValues.put("categoryID", "");
                    }
                    if (m3UCategoriesModel.getCategoryName() != null) {
                        contentValues.put("categoryname", m3UCategoriesModel.getCategoryName());
                    } else {
                        contentValues.put("categoryname", "");
                    }
                    contentValues.put("user_id_referred", Integer.valueOf(SharepreferenceDBHandler.getUserID(this.context)));
                    writableDatabase.insert("iptv_m3u_all_category", (String) null, contentValues);
                }
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
            } catch (SQLiteDatabaseLockedException | Exception unused) {
                writableDatabase.endTransaction();
                Log.w("msg", "exception");
            }
        } catch (Exception unused2) {
        }
    }

    public void addAllAvailableChannel(PanelAvailableChannelsPojo panelAvailableChannelsPojo, String str) {
        String str2;
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.beginTransaction();
            try {
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
                contentValues.put("stream_type", str);
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
                if (panelAvailableChannelsPojo.getUrl() != null) {
                    contentValues.put("url", panelAvailableChannelsPojo.getUrl());
                    contentValues.put("url_fire_db", panelAvailableChannelsPojo.getUrl().replaceAll("/", "").replaceAll("\\.", ""));
                } else {
                    contentValues.put("url", "");
                    contentValues.put("url_fire_db", "");
                }
                contentValues.put("user_id_referred", Integer.valueOf(SharepreferenceDBHandler.getUserID(this.context)));
                writableDatabase.insert("iptv_recent_watched_m3u", (String) null, contentValues);
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
                writableDatabase.close();
            } catch (SQLiteDatabaseLockedException unused) {
                writableDatabase.endTransaction();
                str2 = "msg";
                Log.w(str2, "exception");
            } catch (Exception unused2) {
                writableDatabase.endTransaction();
                str2 = "msg";
                Log.w(str2, "exception");
            }
        } catch (Exception unused3) {
        }
    }

    public void addAllAvailableChannelM3U(ArrayList arrayList, String str) {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.beginTransaction();
            try {
                ContentValues contentValues = new ContentValues();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    LiveStreamsDBModel liveStreamsDBModel = (LiveStreamsDBModel) it.next();
                    if (liveStreamsDBModel.getName() == null) {
                        Log.e("sdsadsd", "addAllAvailableChannel:" + liveStreamsDBModel.getName());
                    }
                    if (liveStreamsDBModel.getNum() != null) {
                        contentValues.put("num", String.valueOf(liveStreamsDBModel.getNum()));
                    } else {
                        contentValues.put("num", "");
                    }
                    if (liveStreamsDBModel.getName() != null) {
                        contentValues.put("name", liveStreamsDBModel.getName());
                    } else {
                        contentValues.put("name", "");
                    }
                    contentValues.put("stream_type", str);
                    if (liveStreamsDBModel.getStreamId() != null) {
                        contentValues.put("stream_id", liveStreamsDBModel.getStreamId());
                    } else {
                        contentValues.put("stream_id", "");
                    }
                    if (liveStreamsDBModel.getStreamIcon() != null) {
                        contentValues.put("stream_icon", liveStreamsDBModel.getStreamIcon());
                    } else {
                        contentValues.put("stream_icon", "");
                    }
                    if (liveStreamsDBModel.getEpgChannelId() != null) {
                        contentValues.put("epg_channel_id", liveStreamsDBModel.getEpgChannelId());
                    } else {
                        contentValues.put("epg_channel_id", "");
                    }
                    if (liveStreamsDBModel.getAdded() != null) {
                        contentValues.put("added", liveStreamsDBModel.getAdded());
                    } else {
                        contentValues.put("added", "");
                    }
                    if (liveStreamsDBModel.getCategoryId() != null) {
                        contentValues.put("categoryID", liveStreamsDBModel.getCategoryId());
                    } else {
                        contentValues.put("categoryID", "");
                    }
                    if (liveStreamsDBModel.getCustomSid() != null) {
                        contentValues.put("custom_sid", liveStreamsDBModel.getCustomSid());
                    } else {
                        contentValues.put("custom_sid", "");
                    }
                    if (liveStreamsDBModel.getTvArchive() != null) {
                        contentValues.put("tv_archive", liveStreamsDBModel.getTvArchive());
                    } else {
                        contentValues.put("tv_archive", "");
                    }
                    if (liveStreamsDBModel.getDirectSource() != null) {
                        contentValues.put("direct_source", liveStreamsDBModel.getDirectSource());
                    } else {
                        contentValues.put("direct_source", "");
                    }
                    if (liveStreamsDBModel.getTvArchiveDuration() != null) {
                        contentValues.put("tv_archive_duration", liveStreamsDBModel.getTvArchiveDuration());
                    } else {
                        contentValues.put("tv_archive_duration", "");
                    }
                    if (liveStreamsDBModel.getTypeName() != null) {
                        contentValues.put("type_name", String.valueOf(liveStreamsDBModel.getTypeName()));
                    } else {
                        contentValues.put("type_name", "");
                    }
                    if (liveStreamsDBModel.getCategoryName() != null) {
                        contentValues.put("category_name", liveStreamsDBModel.getCategoryName());
                    } else {
                        contentValues.put("category_name", "");
                    }
                    if (liveStreamsDBModel.getSeriesNo() != null) {
                        contentValues.put("series_no", String.valueOf(liveStreamsDBModel.getSeriesNo()));
                    } else {
                        contentValues.put("series_no", "");
                    }
                    if (liveStreamsDBModel.getLive() != null) {
                        contentValues.put("live", liveStreamsDBModel.getLive());
                    } else {
                        contentValues.put("live", "");
                    }
                    if (liveStreamsDBModel.getContaiinerExtension() != null) {
                        contentValues.put("container_extension", String.valueOf(liveStreamsDBModel.getContaiinerExtension()));
                    } else {
                        contentValues.put("container_extension", "");
                    }
                    if (liveStreamsDBModel.getUrl() != null) {
                        contentValues.put("url", liveStreamsDBModel.getUrl());
                        contentValues.put("url_fire_db", liveStreamsDBModel.getUrl().replaceAll("/", "").replaceAll("\\.", ""));
                    } else {
                        contentValues.put("url", "");
                        contentValues.put("url_fire_db", "");
                    }
                    contentValues.put("user_id_referred", Integer.valueOf(SharepreferenceDBHandler.getUserID(this.context)));
                    writableDatabase.insert("iptv_live_streams_m3u", (String) null, contentValues);
                }
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
                writableDatabase.close();
                Log.e("sdsadsd", "addAllAvailableChannel: Transaction end");
            } catch (SQLiteDatabaseLockedException | Exception unused) {
                writableDatabase.endTransaction();
                Log.w("msg", "exception");
            }
        } catch (Exception unused2) {
        }
    }

    public boolean addAllAvailableChannelM3U_import(ArrayList arrayList, String str) {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.beginTransaction();
            try {
                try {
                    ContentValues contentValues = new ContentValues();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        LiveStreamsDBModel liveStreamsDBModel = (LiveStreamsDBModel) it.next();
                        if (liveStreamsDBModel.getName() == null) {
                            Log.e("sdsadsd", "addAllAvailableChannel:" + liveStreamsDBModel.getName());
                        }
                        if (liveStreamsDBModel.getNum() != null) {
                            contentValues.put("num", String.valueOf(liveStreamsDBModel.getNum()));
                        } else {
                            contentValues.put("num", "");
                        }
                        if (liveStreamsDBModel.getName() != null) {
                            contentValues.put("name", liveStreamsDBModel.getName());
                        } else {
                            contentValues.put("name", "");
                        }
                        contentValues.put("stream_type", str);
                        if (liveStreamsDBModel.getStreamId() != null) {
                            contentValues.put("stream_id", liveStreamsDBModel.getStreamId());
                        } else {
                            contentValues.put("stream_id", "");
                        }
                        if (liveStreamsDBModel.getStreamIcon() != null) {
                            contentValues.put("stream_icon", liveStreamsDBModel.getStreamIcon());
                        } else {
                            contentValues.put("stream_icon", "");
                        }
                        if (liveStreamsDBModel.getEpgChannelId() != null) {
                            contentValues.put("epg_channel_id", liveStreamsDBModel.getEpgChannelId());
                        } else {
                            contentValues.put("epg_channel_id", "");
                        }
                        if (liveStreamsDBModel.getAdded() != null) {
                            contentValues.put("added", liveStreamsDBModel.getAdded());
                        } else {
                            contentValues.put("added", "");
                        }
                        if (liveStreamsDBModel.getCategoryId() != null) {
                            contentValues.put("categoryID", liveStreamsDBModel.getCategoryId());
                        } else {
                            contentValues.put("categoryID", "");
                        }
                        if (liveStreamsDBModel.getCustomSid() != null) {
                            contentValues.put("custom_sid", liveStreamsDBModel.getCustomSid());
                        } else {
                            contentValues.put("custom_sid", "");
                        }
                        if (liveStreamsDBModel.getTvArchive() != null) {
                            contentValues.put("tv_archive", liveStreamsDBModel.getTvArchive());
                        } else {
                            contentValues.put("tv_archive", "");
                        }
                        if (liveStreamsDBModel.getDirectSource() != null) {
                            contentValues.put("direct_source", liveStreamsDBModel.getDirectSource());
                        } else {
                            contentValues.put("direct_source", "");
                        }
                        if (liveStreamsDBModel.getTvArchiveDuration() != null) {
                            contentValues.put("tv_archive_duration", liveStreamsDBModel.getTvArchiveDuration());
                        } else {
                            contentValues.put("tv_archive_duration", "");
                        }
                        if (liveStreamsDBModel.getTypeName() != null) {
                            contentValues.put("type_name", String.valueOf(liveStreamsDBModel.getTypeName()));
                        } else {
                            contentValues.put("type_name", "");
                        }
                        if (liveStreamsDBModel.getCategoryName() != null) {
                            contentValues.put("category_name", liveStreamsDBModel.getCategoryName());
                        } else {
                            contentValues.put("category_name", "");
                        }
                        if (liveStreamsDBModel.getSeriesNo() != null) {
                            contentValues.put("series_no", String.valueOf(liveStreamsDBModel.getSeriesNo()));
                        } else {
                            contentValues.put("series_no", "");
                        }
                        if (liveStreamsDBModel.getLive() != null) {
                            contentValues.put("live", liveStreamsDBModel.getLive());
                        } else {
                            contentValues.put("live", "");
                        }
                        if (liveStreamsDBModel.getContaiinerExtension() != null) {
                            contentValues.put("container_extension", String.valueOf(liveStreamsDBModel.getContaiinerExtension()));
                        } else {
                            contentValues.put("container_extension", "");
                        }
                        if (liveStreamsDBModel.getUrl() != null) {
                            contentValues.put("url", liveStreamsDBModel.getUrl());
                            contentValues.put("url_fire_db", liveStreamsDBModel.getUrl().replaceAll("/", "").replaceAll("\\.", ""));
                        } else {
                            contentValues.put("url", "");
                            contentValues.put("url_fire_db", "");
                        }
                        contentValues.put("user_id_referred", Integer.valueOf(SharepreferenceDBHandler.getUserID(this.context)));
                        writableDatabase.insert("iptv_live_streams_m3u", (String) null, contentValues);
                    }
                    writableDatabase.setTransactionSuccessful();
                    writableDatabase.endTransaction();
                    writableDatabase.close();
                    Log.e("sdsadsd", "addAllAvailableChannel: Transaction end");
                    return true;
                } catch (Exception unused) {
                    writableDatabase.endTransaction();
                    Log.w("msg", "exception");
                    return false;
                }
            } catch (SQLiteDatabaseLockedException unused2) {
                writableDatabase.endTransaction();
                Log.w("msg", "exception");
                return false;
            }
        } catch (Exception unused3) {
        }
    }

    public boolean addAllAvailableMovies(List list) {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.beginTransaction();
            try {
                try {
                    int userID = SharepreferenceDBHandler.getUserID(this.context);
                    ContentValues contentValues = new ContentValues();
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        VodStreamsCallback vodStreamsCallback = (VodStreamsCallback) it.next();
                        w.q = true;
                        if (vodStreamsCallback.getNum() != null) {
                            contentValues.put("num", String.valueOf(vodStreamsCallback.getNum()));
                        } else {
                            contentValues.put("num", "");
                        }
                        if (vodStreamsCallback.getName() != null) {
                            contentValues.put("name", vodStreamsCallback.getName());
                        } else {
                            contentValues.put("name", "");
                        }
                        if (vodStreamsCallback.getStreamType() != null) {
                            contentValues.put("stream_type", vodStreamsCallback.getStreamType());
                        } else {
                            contentValues.put("stream_type", "");
                        }
                        if (vodStreamsCallback.getStreamId() != null) {
                            contentValues.put("stream_id", vodStreamsCallback.getStreamId());
                        } else {
                            contentValues.put("stream_id", "");
                        }
                        if (vodStreamsCallback.getStreamIcon() != null) {
                            contentValues.put("stream_icon", vodStreamsCallback.getStreamIcon());
                        } else {
                            contentValues.put("stream_icon", "");
                        }
                        contentValues.put("epg_channel_id", "");
                        if (vodStreamsCallback.getAdded() != null) {
                            contentValues.put("added", vodStreamsCallback.getAdded());
                        } else {
                            contentValues.put("added", "");
                        }
                        if (vodStreamsCallback.getCategoryId() == null || checkUnCategoryCountMovies(vodStreamsCallback.getCategoryId()) <= 0) {
                            contentValues.put("categoryID", "-3");
                        } else {
                            contentValues.put("categoryID", vodStreamsCallback.getCategoryId());
                        }
                        if (vodStreamsCallback.getCustomSid() != null) {
                            contentValues.put("custom_sid", vodStreamsCallback.getCustomSid());
                        } else {
                            contentValues.put("custom_sid", "");
                        }
                        contentValues.put("tv_archive", "");
                        if (vodStreamsCallback.getDirectSource() != null) {
                            contentValues.put("direct_source", vodStreamsCallback.getDirectSource());
                        } else {
                            contentValues.put("direct_source", "");
                        }
                        contentValues.put("tv_archive_duration", "");
                        contentValues.put("type_name", "");
                        contentValues.put("category_name", "");
                        if (vodStreamsCallback.getSeriesNo() != null) {
                            contentValues.put("series_no", String.valueOf(vodStreamsCallback.getSeriesNo()));
                        } else {
                            contentValues.put("series_no", "");
                        }
                        contentValues.put("live", "");
                        if (vodStreamsCallback.getContainerExtension() != null) {
                            contentValues.put("container_extension", String.valueOf(vodStreamsCallback.getContainerExtension()));
                        } else {
                            contentValues.put("container_extension", "");
                        }
                        if (vodStreamsCallback.getRating() != null) {
                            contentValues.put("rating_from_ten", vodStreamsCallback.getRating());
                        } else {
                            contentValues.put("rating_from_ten", "");
                        }
                        if (vodStreamsCallback.getRating5based() != null) {
                            contentValues.put("rating_from_five", String.valueOf(vodStreamsCallback.getRating5based()));
                        } else {
                            contentValues.put("rating_from_five", "");
                        }
                        contentValues.put("user_id_referred", Integer.valueOf(userID));
                        writableDatabase.insert("iptv_live_streams", (String) null, contentValues);
                    }
                    writableDatabase.setTransactionSuccessful();
                    writableDatabase.endTransaction();
                    w.q = false;
                    return true;
                } catch (Exception unused) {
                    writableDatabase.endTransaction();
                    w.q = false;
                    Log.w("msg", "exception");
                    return false;
                }
            } catch (SQLiteDatabaseLockedException unused2) {
                writableDatabase.endTransaction();
                w.q = false;
                Log.w("msg", "exception");
                return false;
            }
        } catch (Exception unused3) {
        }
    }

    public boolean addAllAvailableONESTREAMMovies(List list) {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.beginTransaction();
            try {
                int userID = SharepreferenceDBHandler.getUserID(this.context);
                ContentValues contentValues = new ContentValues();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    OneStreamMovieStreamDataModel oneStreamMovieStreamDataModel = (OneStreamMovieStreamDataModel) it.next();
                    w.q = true;
                    if (oneStreamMovieStreamDataModel.getNum() != null) {
                        contentValues.put("num", String.valueOf(oneStreamMovieStreamDataModel.getNum()));
                    } else {
                        contentValues.put("num", "");
                    }
                    if (oneStreamMovieStreamDataModel.getName() != null) {
                        contentValues.put("name", oneStreamMovieStreamDataModel.getName());
                    } else {
                        contentValues.put("name", "");
                    }
                    if (oneStreamMovieStreamDataModel.getStream_type() != null) {
                        contentValues.put("stream_type", oneStreamMovieStreamDataModel.getStream_type());
                    } else {
                        contentValues.put("stream_type", "");
                    }
                    if (oneStreamMovieStreamDataModel.getStream_id() != null) {
                        contentValues.put("stream_id", oneStreamMovieStreamDataModel.getStream_id());
                    } else {
                        contentValues.put("stream_id", "");
                    }
                    if (oneStreamMovieStreamDataModel.getStream_icon() != null) {
                        contentValues.put("stream_icon", oneStreamMovieStreamDataModel.getStream_icon());
                    } else {
                        contentValues.put("stream_icon", "");
                    }
                    contentValues.put("epg_channel_id", "");
                    if (oneStreamMovieStreamDataModel.getAdded() != null) {
                        contentValues.put("added", oneStreamMovieStreamDataModel.getAdded());
                    } else {
                        contentValues.put("added", "");
                    }
                    if (oneStreamMovieStreamDataModel.getIs_adult() != null) {
                        contentValues.put("is_adult", oneStreamMovieStreamDataModel.getIs_adult());
                    } else {
                        contentValues.put("is_adult", "");
                    }
                    if (oneStreamMovieStreamDataModel.getCategories() == null || checkUnCategoryCountMovies(oneStreamMovieStreamDataModel.getCategories()) <= 0) {
                        contentValues.put("categoryID", "-3");
                    } else {
                        contentValues.put("categoryID", oneStreamMovieStreamDataModel.getCategories());
                    }
                    contentValues.put("custom_sid", "");
                    contentValues.put("tv_archive", "");
                    contentValues.put("direct_source", "");
                    contentValues.put("tv_archive_duration", "");
                    contentValues.put("type_name", "");
                    contentValues.put("category_name", "");
                    contentValues.put("series_no", "");
                    contentValues.put("live", "");
                    contentValues.put("container_extension", "");
                    if (oneStreamMovieStreamDataModel.getRating() != null) {
                        contentValues.put("rating_from_ten", oneStreamMovieStreamDataModel.getRating());
                    } else {
                        contentValues.put("rating_from_ten", "");
                    }
                    if (oneStreamMovieStreamDataModel.getRating_5based() != null) {
                        contentValues.put("rating_from_five", String.valueOf(oneStreamMovieStreamDataModel.getRating_5based()));
                    } else {
                        contentValues.put("rating_from_five", "");
                    }
                    if (oneStreamMovieStreamDataModel.getLinks() != null) {
                        contentValues.put("links", String.valueOf(oneStreamMovieStreamDataModel.getLinks()));
                    } else {
                        contentValues.put("links", "");
                    }
                    contentValues.put("user_id_referred", Integer.valueOf(userID));
                    writableDatabase.insert("onestream_iptv_live_streams", (String) null, contentValues);
                }
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
                w.q = false;
                return true;
            } catch (SQLiteDatabaseLockedException unused) {
                writableDatabase.endTransaction();
                w.q = false;
                Log.w("msg", "exception");
                return false;
            } catch (Exception unused2) {
                writableDatabase.endTransaction();
                w.q = false;
                Log.w("msg", "exception");
                return false;
            }
        } catch (Exception unused3) {
        }
    }

    public boolean addAllOneStreamSeriesStreams(List list) {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.beginTransaction();
            try {
                ContentValues contentValues = new ContentValues();
                int size = list.size();
                if (size != 0) {
                    for (int i = 0; i < size; i++) {
                        w.q = true;
                        if (((OneStreamSeriesStreamDataModel) list.get(i)).getNum() != null) {
                            contentValues.put("num_series_stream_v2", String.valueOf(((OneStreamSeriesStreamDataModel) list.get(i)).getNum()));
                        } else {
                            contentValues.put("num_series_stream_v2", "");
                        }
                        if (((OneStreamSeriesStreamDataModel) list.get(i)).getName() != null) {
                            contentValues.put("name_series_stream_v2", ((OneStreamSeriesStreamDataModel) list.get(i)).getName());
                        } else {
                            contentValues.put("name_series_stream_v2", "");
                        }
                        contentValues.put("stream_type_series_stream_v2", "");
                        if (((OneStreamSeriesStreamDataModel) list.get(i)).getSeries_id() != null) {
                            contentValues.put("stream_id_series_stream_v2", ((OneStreamSeriesStreamDataModel) list.get(i)).getSeries_id());
                        } else {
                            contentValues.put("stream_id_series_stream_v2", "");
                        }
                        if (((OneStreamSeriesStreamDataModel) list.get(i)).getCover() != null) {
                            contentValues.put("stream_cover_series_stream_v2", ((OneStreamSeriesStreamDataModel) list.get(i)).getCover());
                        } else {
                            contentValues.put("stream_cover_series_stream_v2", "");
                        }
                        if (((OneStreamSeriesStreamDataModel) list.get(i)).getPlot() != null) {
                            contentValues.put("plot_series_stream_v2", ((OneStreamSeriesStreamDataModel) list.get(i)).getPlot());
                        } else {
                            contentValues.put("plot_series_stream_v2", "");
                        }
                        if (((OneStreamSeriesStreamDataModel) list.get(i)).getCast() != null) {
                            contentValues.put("cast_series_stream_v2", ((OneStreamSeriesStreamDataModel) list.get(i)).getCast());
                        } else {
                            contentValues.put("cast_series_stream_v2", "");
                        }
                        if (((OneStreamSeriesStreamDataModel) list.get(i)).getDirector() != null) {
                            contentValues.put("director_series_stream_v2", String.valueOf(((OneStreamSeriesStreamDataModel) list.get(i)).getDirector()));
                        } else {
                            contentValues.put("director_series_stream_v2", "");
                        }
                        if (((OneStreamSeriesStreamDataModel) list.get(i)).getGenre() != null) {
                            contentValues.put("genre_series_stream_v2", ((OneStreamSeriesStreamDataModel) list.get(i)).getGenre());
                        } else {
                            contentValues.put("genre_series_stream_v2", "");
                        }
                        if (((OneStreamSeriesStreamDataModel) list.get(i)).getRelease_date() != null) {
                            contentValues.put("release_date_series_stream_v2", String.valueOf(((OneStreamSeriesStreamDataModel) list.get(i)).getRelease_date()));
                        } else {
                            contentValues.put("release_date_series_stream_v2", "");
                        }
                        if (((OneStreamSeriesStreamDataModel) list.get(i)).getLast_modified() != null) {
                            contentValues.put("last_modified_series_stream_v2", String.valueOf(((OneStreamSeriesStreamDataModel) list.get(i)).getLast_modified()));
                        } else {
                            contentValues.put("last_modified_series_stream_v2", "");
                        }
                        if (((OneStreamSeriesStreamDataModel) list.get(i)).getRating() != null) {
                            contentValues.put("rating_series_stream_v2", String.valueOf(((OneStreamSeriesStreamDataModel) list.get(i)).getRating()));
                        } else {
                            contentValues.put("rating_series_stream_v2", "");
                        }
                        if (((OneStreamSeriesStreamDataModel) list.get(i)).getRating_5based() != null) {
                            contentValues.put("rating_series_stream_v2", String.valueOf(((OneStreamSeriesStreamDataModel) list.get(i)).getRating_5based()));
                        } else {
                            contentValues.put("rating_series_stream_v2", "");
                        }
                        if (((OneStreamSeriesStreamDataModel) list.get(i)).getCategories() == null || checkUnCategoryCountSeries(((OneStreamSeriesStreamDataModel) list.get(i)).getCategories()) <= 0) {
                            contentValues.put("category_id_series_stream_v2", "-5");
                        } else {
                            contentValues.put("category_id_series_stream_v2", String.valueOf(((OneStreamSeriesStreamDataModel) list.get(i)).getCategories()));
                        }
                        if (((OneStreamSeriesStreamDataModel) list.get(i)).getYoutube_trailer() != null) {
                            contentValues.put("youtube_trailer", String.valueOf(((OneStreamSeriesStreamDataModel) list.get(i)).getYoutube_trailer()));
                        } else {
                            contentValues.put("youtube_trailer", "");
                        }
                        if (((OneStreamSeriesStreamDataModel) list.get(i)).getBackdrop_path() != null) {
                            contentValues.put("backdrop", ((OneStreamSeriesStreamDataModel) list.get(i)).getBackdrop_path().toString());
                        } else {
                            contentValues.put("backdrop", "");
                        }
                        contentValues.put("user_id_referred", Integer.valueOf(SharepreferenceDBHandler.getUserID(this.context)));
                        writableDatabase.insert("onestream_series_streams_v2", (String) null, contentValues);
                    }
                }
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
                w.q = false;
                return true;
            } catch (SQLiteDatabaseLockedException unused) {
                Log.w("msg", "exception");
                writableDatabase.endTransaction();
                w.q = false;
                return false;
            } catch (Exception e) {
                writableDatabase.endTransaction();
                w.q = false;
                Log.w("msg", "exception:" + e.getMessage());
                return false;
            }
        } catch (Exception unused2) {
        }
    }

    public boolean addAllSeriesStreams(ArrayList arrayList) {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.beginTransaction();
            try {
                ContentValues contentValues = new ContentValues();
                int size = arrayList.size();
                if (size != 0) {
                    for (int i = 0; i < size; i++) {
                        w.q = true;
                        if (((GetSeriesStreamCallback) arrayList.get(i)).getNum() != null) {
                            contentValues.put("num_series_stream_v2", String.valueOf(((GetSeriesStreamCallback) arrayList.get(i)).getNum()));
                        } else {
                            contentValues.put("num_series_stream_v2", "");
                        }
                        if (((GetSeriesStreamCallback) arrayList.get(i)).getName() != null) {
                            contentValues.put("name_series_stream_v2", ((GetSeriesStreamCallback) arrayList.get(i)).getName());
                        } else {
                            contentValues.put("name_series_stream_v2", "");
                        }
                        if (((GetSeriesStreamCallback) arrayList.get(i)).getStreamType() != null) {
                            contentValues.put("stream_type_series_stream_v2", String.valueOf(((GetSeriesStreamCallback) arrayList.get(i)).getStreamType()));
                        } else {
                            contentValues.put("stream_type_series_stream_v2", "");
                        }
                        if (((GetSeriesStreamCallback) arrayList.get(i)).getSeriesId() != null) {
                            contentValues.put("stream_id_series_stream_v2", ((GetSeriesStreamCallback) arrayList.get(i)).getSeriesId());
                        } else {
                            contentValues.put("stream_id_series_stream_v2", "");
                        }
                        if (((GetSeriesStreamCallback) arrayList.get(i)).getCover() != null) {
                            contentValues.put("stream_cover_series_stream_v2", ((GetSeriesStreamCallback) arrayList.get(i)).getCover());
                        } else {
                            contentValues.put("stream_cover_series_stream_v2", "");
                        }
                        if (((GetSeriesStreamCallback) arrayList.get(i)).getPlot() != null) {
                            contentValues.put("plot_series_stream_v2", ((GetSeriesStreamCallback) arrayList.get(i)).getPlot());
                        } else {
                            contentValues.put("plot_series_stream_v2", "");
                        }
                        if (((GetSeriesStreamCallback) arrayList.get(i)).getCast() != null) {
                            contentValues.put("cast_series_stream_v2", ((GetSeriesStreamCallback) arrayList.get(i)).getCast());
                        } else {
                            contentValues.put("cast_series_stream_v2", "");
                        }
                        if (((GetSeriesStreamCallback) arrayList.get(i)).getDirector() != null) {
                            contentValues.put("director_series_stream_v2", String.valueOf(((GetSeriesStreamCallback) arrayList.get(i)).getDirector()));
                        } else {
                            contentValues.put("director_series_stream_v2", "");
                        }
                        if (((GetSeriesStreamCallback) arrayList.get(i)).getGenre() != null) {
                            contentValues.put("genre_series_stream_v2", ((GetSeriesStreamCallback) arrayList.get(i)).getGenre());
                        } else {
                            contentValues.put("genre_series_stream_v2", "");
                        }
                        if (((GetSeriesStreamCallback) arrayList.get(i)).getReleaseDate() != null) {
                            contentValues.put("release_date_series_stream_v2", String.valueOf(((GetSeriesStreamCallback) arrayList.get(i)).getReleaseDate()));
                        } else {
                            contentValues.put("release_date_series_stream_v2", "");
                        }
                        if (((GetSeriesStreamCallback) arrayList.get(i)).getLastModified() != null) {
                            contentValues.put("last_modified_series_stream_v2", String.valueOf(((GetSeriesStreamCallback) arrayList.get(i)).getLastModified()));
                        } else {
                            contentValues.put("last_modified_series_stream_v2", "");
                        }
                        if (((GetSeriesStreamCallback) arrayList.get(i)).getRating() != null) {
                            contentValues.put("rating_series_stream_v2", String.valueOf(((GetSeriesStreamCallback) arrayList.get(i)).getRating()));
                        } else {
                            contentValues.put("rating_series_stream_v2", "");
                        }
                        if (((GetSeriesStreamCallback) arrayList.get(i)).getCategoryId() == null || checkUnCategoryCountSeries(((GetSeriesStreamCallback) arrayList.get(i)).getCategoryId()) <= 0) {
                            contentValues.put("category_id_series_stream_v2", "-5");
                        } else {
                            contentValues.put("category_id_series_stream_v2", String.valueOf(((GetSeriesStreamCallback) arrayList.get(i)).getCategoryId()));
                        }
                        if (((GetSeriesStreamCallback) arrayList.get(i)).getYoutubTrailer() != null) {
                            contentValues.put("youtube_trailer", String.valueOf(((GetSeriesStreamCallback) arrayList.get(i)).getYoutubTrailer()));
                        } else {
                            contentValues.put("youtube_trailer", "");
                        }
                        if (((GetSeriesStreamCallback) arrayList.get(i)).getBackdropPath() != null) {
                            contentValues.put("backdrop", ((GetSeriesStreamCallback) arrayList.get(i)).getBackdropPath().toString());
                        } else {
                            contentValues.put("backdrop", "");
                        }
                        contentValues.put("user_id_referred", Integer.valueOf(SharepreferenceDBHandler.getUserID(this.context)));
                        writableDatabase.insert("series_streams_v2", (String) null, contentValues);
                    }
                }
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
                w.q = false;
                return true;
            } catch (Exception e) {
                writableDatabase.endTransaction();
                w.q = false;
                Log.w("msg", "exception:" + e.getMessage());
                return false;
            } catch (SQLiteDatabaseLockedException unused) {
                Log.w("msg", "exception");
                writableDatabase.endTransaction();
                w.q = false;
                return false;
            }
        } catch (Exception unused2) {
        }
    }

    public void addCategoriesM3U(ArrayList arrayList, String str) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.beginTransaction();
        String str2 = str.equals("live") ? "iptv_live_category_m3u" : str.equals("movie") ? "iptv_movie_category_m3u" : str.equals("series") ? "iptv_series_category_m3u" : "";
        try {
            ContentValues contentValues = new ContentValues();
            int userID = SharepreferenceDBHandler.getUserID(this.context);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                M3UCategoriesModel m3UCategoriesModel = (M3UCategoriesModel) it.next();
                contentValues.put("categoryID", m3UCategoriesModel.getCategoryId());
                contentValues.put("categoryname", m3UCategoriesModel.getCategoryName());
                contentValues.put("user_id_referred", Integer.valueOf(userID));
                writableDatabase.insert(str2, (String) null, contentValues);
            }
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
            writableDatabase.close();
        } catch (SQLiteDatabaseLockedException | Exception unused) {
            writableDatabase.endTransaction();
            Log.w("msg", "exception");
        }
    }

    public void addEPG(List list) {
        String str;
        try {
            int userID = SharepreferenceDBHandler.getUserID(this.context);
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.beginTransaction();
            String currentAPPType = SharepreferenceDBHandler.getCurrentAPPType(this.context);
            if (currentAPPType.equals("m3u")) {
                str = "epg_m3u";
            } else {
                currentAPPType.equals("onestream_api");
                str = "epg";
            }
            try {
                ContentValues contentValues = new ContentValues();
                int size = list.size();
                if (size != 0) {
                    for (int i = 0; i < size; i++) {
                        contentValues.put("title", ((XMLTVProgrammePojo) list.get(i)).getTitle());
                        contentValues.put("start", ((XMLTVProgrammePojo) list.get(i)).getStart());
                        contentValues.put("stop", ((XMLTVProgrammePojo) list.get(i)).getStop());
                        contentValues.put("description", ((XMLTVProgrammePojo) list.get(i)).getDesc());
                        contentValues.put("channel_id", ((XMLTVProgrammePojo) list.get(i)).getChannel());
                        contentValues.put("user_id_referred", Integer.valueOf(userID));
                        contentValues.put("source_ref_id", ((XMLTVProgrammePojo) list.get(i)).getSourceRef());
                        writableDatabase.insert(str, (String) null, contentValues);
                    }
                }
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
            } catch (SQLiteDatabaseLockedException | Exception unused) {
                writableDatabase.endTransaction();
                Log.w("msg", "exception");
            }
        } catch (Exception unused2) {
        }
    }

    public void addEPGNew(XMLTVProgrammePojo xMLTVProgrammePojo) {
        String str;
        try {
            int userID = SharepreferenceDBHandler.getUserID(this.context);
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.beginTransaction();
            String currentAPPType = SharepreferenceDBHandler.getCurrentAPPType(this.context);
            if (currentAPPType.equals("m3u")) {
                str = "epg_m3u";
            } else {
                currentAPPType.equals("onestream_api");
                str = "epg";
            }
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("title", xMLTVProgrammePojo.getTitle());
                contentValues.put("start", xMLTVProgrammePojo.getStart());
                contentValues.put("stop", xMLTVProgrammePojo.getStop());
                contentValues.put("description", xMLTVProgrammePojo.getDesc());
                contentValues.put("channel_id", xMLTVProgrammePojo.getChannel());
                contentValues.put("user_id_referred", Integer.valueOf(userID));
                contentValues.put("source_ref_id", xMLTVProgrammePojo.getSourceRef());
                writableDatabase.insert(str, (String) null, contentValues);
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
            } catch (SQLiteDatabaseLockedException | Exception unused) {
                writableDatabase.endTransaction();
                Log.w("msg", "exception");
            }
        } catch (Exception unused2) {
        }
    }

    public void addEPGSource(String str, String str2, String str3, String str4) {
        try {
            String str5 = SharepreferenceDBHandler.getCurrentAPPType(this.context).equals("m3u") ? "iptv_epg_sources_m3u" : "iptv_epg_sources";
            int userID = SharepreferenceDBHandler.getUserID(this.context);
            SQLiteDatabase writableDatabase = getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("user_id_referred", Integer.valueOf(userID));
            contentValues.put("name", str);
            contentValues.put("source_type", str2);
            contentValues.put("epgurl", str3);
            contentValues.put("default_source", str4);
            writableDatabase.insert(str5, (String) null, contentValues);
        } catch (SQLiteDatabaseLockedException | Exception unused) {
        }
    }

    public boolean addEPGTesting2(List list) {
        String str;
        try {
            int userID = SharepreferenceDBHandler.getUserID(this.context);
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.beginTransaction();
            String currentAPPType = SharepreferenceDBHandler.getCurrentAPPType(this.context);
            if (currentAPPType.equals("m3u")) {
                str = "epg_m3u";
            } else {
                currentAPPType.equals("onestream_api");
                str = "epg";
            }
            try {
                ContentValues contentValues = new ContentValues();
                int size = list.size();
                if (size != 0) {
                    for (int i = 0; i < size; i++) {
                        contentValues.put("title", ((XMLTVProgrammePojo) list.get(i)).getTitle());
                        contentValues.put("start", ((XMLTVProgrammePojo) list.get(i)).getStart());
                        contentValues.put("stop", ((XMLTVProgrammePojo) list.get(i)).getStop());
                        contentValues.put("description", ((XMLTVProgrammePojo) list.get(i)).getDesc());
                        contentValues.put("channel_id", ((XMLTVProgrammePojo) list.get(i)).getChannel());
                        contentValues.put("user_id_referred", Integer.valueOf(userID));
                        contentValues.put("source_ref_id", ((XMLTVProgrammePojo) list.get(i)).getSourceRef());
                        writableDatabase.insert(str, (String) null, contentValues);
                    }
                }
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
                return true;
            } catch (Exception unused) {
                writableDatabase.endTransaction();
                Log.w("msg", "exception");
                return false;
            } catch (SQLiteDatabaseLockedException unused2) {
                writableDatabase.endTransaction();
                Log.w("msg", "exception");
                return false;
            }
        } catch (Exception unused3) {
        }
    }

    public boolean addLiveCategories(List list) {
        try {
            int userID = SharepreferenceDBHandler.getUserID(this.context);
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.beginTransaction();
            try {
                try {
                    ContentValues contentValues = new ContentValues();
                    int size = list.size();
                    if (size != 0) {
                        for (int i = 0; i < size; i++) {
                            w.q = true;
                            contentValues.put("categoryID_live", ((LiveStreamCategoriesCallback) list.get(i)).getCategoryId());
                            contentValues.put("categoryname_live", ((LiveStreamCategoriesCallback) list.get(i)).getCategoryName());
                            contentValues.put("paent_id", ((LiveStreamCategoriesCallback) list.get(i)).getParentId());
                            contentValues.put("user_id_referred", Integer.valueOf(userID));
                            writableDatabase.insert("iptv_live_category", (String) null, contentValues);
                        }
                    }
                    writableDatabase.setTransactionSuccessful();
                    writableDatabase.endTransaction();
                    w.q = false;
                    return true;
                } catch (Exception unused) {
                    writableDatabase.endTransaction();
                    w.q = false;
                    Log.w("msg", "exception");
                    return false;
                }
            } catch (SQLiteDatabaseLockedException unused2) {
                writableDatabase.endTransaction();
                w.q = false;
                Log.w("msg", "exception");
                return false;
            }
        } catch (Exception unused3) {
            w.q = false;
            return false;
        }
    }

    public void addLiveCategoriesM3U(M3UCategoriesModel m3UCategoriesModel) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            ContentValues contentValues = new ContentValues();
            int userID = SharepreferenceDBHandler.getUserID(this.context);
            contentValues.put("categoryID", m3UCategoriesModel.getCategoryId());
            contentValues.put("categoryname", m3UCategoriesModel.getCategoryName());
            contentValues.put("user_id_referred", Integer.valueOf(userID));
            writableDatabase.insert("iptv_live_category_m3u", (String) null, contentValues);
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
            writableDatabase.close();
        } catch (SQLiteDatabaseLockedException | Exception unused) {
            writableDatabase.endTransaction();
            Log.w("msg", "exception");
        }
    }

    public void addLiveRecentlyWatched(String str, String str2) {
        try {
            String currentAPPType = SharepreferenceDBHandler.getCurrentAPPType(this.context);
            int userID = SharepreferenceDBHandler.getUserID(this.context);
            SQLiteDatabase writableDatabase = getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("stream_id_url", str);
            contentValues.put("user_id_referred", Integer.valueOf(userID));
            contentValues.put("app_type", currentAPPType);
            contentValues.put("type", str2);
            writableDatabase.insert("iptv_live_watched", (String) null, contentValues);
        } catch (SQLiteDatabaseLockedException | Exception e) {
            e.printStackTrace();
        }
    }

    public void addLiveWatchedFromBackup(ArrayList arrayList) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.beginTransaction();
        int userID = SharepreferenceDBHandler.getUserID(this.context);
        String currentAPPType = SharepreferenceDBHandler.getCurrentAPPType(this.context);
        try {
            ContentValues contentValues = new ContentValues();
            for (int i = 0; i < arrayList.size(); i++) {
                contentValues.put("stream_id_url", ((LiveStreamsDBModel) arrayList.get(i)).getStreamId());
                contentValues.put("user_id_referred", Integer.valueOf(userID));
                contentValues.put("app_type", currentAPPType);
                writableDatabase.insert("iptv_live_watched", (String) null, contentValues);
            }
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
            writableDatabase.close();
        } catch (SQLiteDatabaseLockedException | Exception unused) {
            writableDatabase.endTransaction();
            Log.w("msg", "exception");
        }
    }

    public void addMagPortal(String str) {
        try {
            getReadableDatabase();
            SQLiteDatabase writableDatabase = getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("mag_portal", str);
            writableDatabase.insert("iptv_mag_portal_table", (String) null, contentValues);
            writableDatabase.close();
        } catch (SQLiteDatabaseLockedException | Exception unused) {
            Log.w("msg", "exception");
        }
    }

    public boolean addMovieCategories(List list) {
        try {
            int userID = SharepreferenceDBHandler.getUserID(this.context);
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.beginTransaction();
            try {
                try {
                    ContentValues contentValues = new ContentValues();
                    int size = list.size();
                    if (size != 0) {
                        for (int i = 0; i < size; i++) {
                            w.q = true;
                            contentValues.put("categoryID_movie", ((VodCategoriesCallback) list.get(i)).getCategoryId());
                            contentValues.put("categoryname_movie", ((VodCategoriesCallback) list.get(i)).getCategoryName());
                            contentValues.put("paent_id", ((VodCategoriesCallback) list.get(i)).getParentId());
                            contentValues.put("user_id_referred", Integer.valueOf(userID));
                            writableDatabase.insert("iptv_movie_category", (String) null, contentValues);
                        }
                    }
                    writableDatabase.setTransactionSuccessful();
                    writableDatabase.endTransaction();
                    w.q = false;
                    return true;
                } catch (Exception unused) {
                    writableDatabase.endTransaction();
                    Log.w("msg", "exception");
                    w.q = false;
                    return false;
                }
            } catch (SQLiteDatabaseLockedException unused2) {
                Log.w("msg", "exception");
                writableDatabase.endTransaction();
                w.q = false;
                return false;
            }
        } catch (Exception unused3) {
            w.q = false;
            return false;
        }
    }

    public void addMovieCategoriesM3U(M3UCategoriesModel m3UCategoriesModel) {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.beginTransaction();
            try {
                ContentValues contentValues = new ContentValues();
                int userID = SharepreferenceDBHandler.getUserID(this.context);
                contentValues.put("categoryID", m3UCategoriesModel.getCategoryId());
                contentValues.put("categoryname", m3UCategoriesModel.getCategoryName());
                contentValues.put("paent_id", 0);
                contentValues.put("user_id_referred", Integer.valueOf(userID));
                writableDatabase.insert("iptv_movie_category_m3u", (String) null, contentValues);
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
                writableDatabase.close();
            } catch (SQLiteDatabaseLockedException | Exception unused) {
                writableDatabase.endTransaction();
                Log.w("msg", "exception");
            }
        } catch (Exception unused2) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void addMultipleCategoriesM3U(java.util.ArrayList r9, java.lang.String r10) {
        /*
            r8 = this;
            java.lang.String r0 = "exception"
            java.lang.String r1 = "msg"
            android.database.sqlite.SQLiteDatabase r2 = r8.getWritableDatabase()
            r2.beginTransaction()
            android.content.ContentValues r3 = new android.content.ContentValues     // Catch: java.lang.Throwable -> Lb1
            r3.<init>()     // Catch: java.lang.Throwable -> Lb1
            int r4 = r10.hashCode()     // Catch: java.lang.Throwable -> Lb1
            r5 = -905838985(0xffffffffca01fe77, float:-2129821.8)
            r6 = 2
            r7 = 1
            if (r4 == r5) goto L3a
            r5 = 3322092(0x32b0ec, float:4.655242E-39)
            if (r4 == r5) goto L30
            r5 = 104087344(0x6343f30, float:3.390066E-35)
            if (r4 == r5) goto L26
            goto L44
        L26:
            java.lang.String r4 = "movie"
            boolean r10 = r10.equals(r4)     // Catch: java.lang.Throwable -> Lb1
            if (r10 == 0) goto L44
            r10 = 1
            goto L45
        L30:
            java.lang.String r4 = "live"
            boolean r10 = r10.equals(r4)     // Catch: java.lang.Throwable -> Lb1
            if (r10 == 0) goto L44
            r10 = 0
            goto L45
        L3a:
            java.lang.String r4 = "series"
            boolean r10 = r10.equals(r4)     // Catch: java.lang.Throwable -> Lb1
            if (r10 == 0) goto L44
            r10 = 2
            goto L45
        L44:
            r10 = -1
        L45:
            java.lang.String r4 = ""
            if (r10 == 0) goto L55
            if (r10 == r7) goto L52
            if (r10 == r6) goto L4f
            r10 = r4
            goto L57
        L4f:
            java.lang.String r10 = "iptv_series_category_m3u"
            goto L57
        L52:
            java.lang.String r10 = "iptv_movie_category_m3u"
            goto L57
        L55:
            java.lang.String r10 = "iptv_live_category_m3u"
        L57:
            boolean r5 = r10.equals(r4)     // Catch: java.lang.Throwable -> Lb1 java.lang.Throwable -> Lb1
            if (r5 != 0) goto La7
            java.util.Iterator r9 = r9.iterator()     // Catch: java.lang.Throwable -> Lb1 java.lang.Throwable -> Lb1
        L61:
            boolean r5 = r9.hasNext()     // Catch: java.lang.Throwable -> Lb1 java.lang.Throwable -> Lb1
            if (r5 == 0) goto La7
            java.lang.Object r5 = r9.next()     // Catch: java.lang.Throwable -> Lb1 java.lang.Throwable -> Lb1
            com.nst.iptvsmarterstvbox.model.LiveStreamCategoryIdDBModel r5 = (com.nst.iptvsmarterstvbox.model.LiveStreamCategoryIdDBModel) r5     // Catch: java.lang.Throwable -> Lb1 java.lang.Throwable -> Lb1
            java.lang.String r6 = r5.getLiveStreamCategoryID()     // Catch: java.lang.Throwable -> Lb1 java.lang.Throwable -> Lb1
            java.lang.String r7 = "categoryID"
            if (r6 == 0) goto L7d
            java.lang.String r6 = r5.getLiveStreamCategoryID()     // Catch: java.lang.Throwable -> Lb1 java.lang.Throwable -> Lb1
            r3.put(r7, r6)     // Catch: java.lang.Throwable -> Lb1 java.lang.Throwable -> Lb1
            goto L80
        L7d:
            r3.put(r7, r4)     // Catch: java.lang.Throwable -> Lb1 java.lang.Throwable -> Lb1
        L80:
            java.lang.String r6 = r5.getLiveStreamCategoryName()     // Catch: java.lang.Throwable -> Lb1 java.lang.Throwable -> Lb1
            java.lang.String r7 = "categoryname"
            if (r6 == 0) goto L90
            java.lang.String r5 = r5.getLiveStreamCategoryName()     // Catch: java.lang.Throwable -> Lb1 java.lang.Throwable -> Lb1
            r3.put(r7, r5)     // Catch: java.lang.Throwable -> Lb1 java.lang.Throwable -> Lb1
            goto L93
        L90:
            r3.put(r7, r4)     // Catch: java.lang.Throwable -> Lb1 java.lang.Throwable -> Lb1
        L93:
            java.lang.String r5 = "user_id_referred"
            android.content.Context r6 = r8.context     // Catch: java.lang.Throwable -> Lb1 java.lang.Throwable -> Lb1
            int r6 = com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler.getUserID(r6)     // Catch: java.lang.Throwable -> Lb1 java.lang.Throwable -> Lb1
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch: java.lang.Throwable -> Lb1 java.lang.Throwable -> Lb1
            r3.put(r5, r6)     // Catch: java.lang.Throwable -> Lb1 java.lang.Throwable -> Lb1
            r5 = 0
            r2.insert(r10, r5, r3)     // Catch: java.lang.Throwable -> Lb1 java.lang.Throwable -> Lb1
            goto L61
        La7:
            r2.setTransactionSuccessful()     // Catch: java.lang.Throwable -> Lb1 java.lang.Throwable -> Lb1
            r2.endTransaction()     // Catch: java.lang.Throwable -> Lb1 java.lang.Throwable -> Lb1
            r2.close()     // Catch: java.lang.Throwable -> Lb1 java.lang.Throwable -> Lb1
            goto Lb7
        Lb1:
            r2.endTransaction()
            android.util.Log.w(r1, r0)
        Lb7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler.addMultipleCategoriesM3U(java.util.ArrayList, java.lang.String):void");
    }

    public boolean addOneStreamAllChannels(List list) {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.beginTransaction();
            try {
                try {
                    int userID = SharepreferenceDBHandler.getUserID(this.context);
                    ContentValues contentValues = new ContentValues();
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        OneStreamLiveStreamDataModel oneStreamLiveStreamDataModel = (OneStreamLiveStreamDataModel) it.next();
                        w.q = true;
                        if (oneStreamLiveStreamDataModel.getNum() != null) {
                            contentValues.put("num", String.valueOf(oneStreamLiveStreamDataModel.getNum()));
                        } else {
                            contentValues.put("num", "");
                        }
                        if (oneStreamLiveStreamDataModel.getName() != null) {
                            contentValues.put("name", oneStreamLiveStreamDataModel.getName());
                        } else {
                            contentValues.put("name", "");
                        }
                        if (oneStreamLiveStreamDataModel.getStream_type() != null) {
                            contentValues.put("stream_type", oneStreamLiveStreamDataModel.getStream_type());
                        } else {
                            contentValues.put("stream_type", "");
                        }
                        if (oneStreamLiveStreamDataModel.getStream_id() != null) {
                            contentValues.put("stream_id", oneStreamLiveStreamDataModel.getStream_id());
                        } else {
                            contentValues.put("stream_id", "");
                        }
                        if (oneStreamLiveStreamDataModel.getStream_icon() != null) {
                            contentValues.put("stream_icon", oneStreamLiveStreamDataModel.getStream_icon());
                        } else {
                            contentValues.put("stream_icon", "");
                        }
                        if (oneStreamLiveStreamDataModel.getEpg_channel_id() != null) {
                            contentValues.put("epg_channel_id", oneStreamLiveStreamDataModel.getEpg_channel_id());
                        } else {
                            contentValues.put("epg_channel_id", "");
                        }
                        contentValues.put("added", "");
                        if (oneStreamLiveStreamDataModel.getCategories() == null || checkUnCategoryCountLive(oneStreamLiveStreamDataModel.getCategories()) <= 0) {
                            contentValues.put("categoryID", "-2");
                        } else {
                            contentValues.put("categoryID", oneStreamLiveStreamDataModel.getCategories());
                        }
                        contentValues.put("custom_sid", "");
                        if (oneStreamLiveStreamDataModel.getTv_archive() != null) {
                            contentValues.put("tv_archive", oneStreamLiveStreamDataModel.getTv_archive());
                        } else {
                            contentValues.put("tv_archive", "");
                        }
                        if (oneStreamLiveStreamDataModel.getLinks() != null) {
                            contentValues.put("links", oneStreamLiveStreamDataModel.getLinks());
                        } else {
                            contentValues.put("links", "");
                        }
                        if (oneStreamLiveStreamDataModel.getIs_adult() != null) {
                            contentValues.put("is_adult", oneStreamLiveStreamDataModel.getIs_adult());
                        } else {
                            contentValues.put("is_adult", "");
                        }
                        contentValues.put("direct_source", "");
                        if (oneStreamLiveStreamDataModel.getTv_archive_duration() != null) {
                            contentValues.put("tv_archive_duration", oneStreamLiveStreamDataModel.getTv_archive_duration());
                        } else {
                            contentValues.put("tv_archive_duration", "");
                        }
                        contentValues.put("type_name", "");
                        if (oneStreamLiveStreamDataModel.getCategories() != null) {
                            contentValues.put("category_name", oneStreamLiveStreamDataModel.getCategories());
                        } else {
                            contentValues.put("category_name", "");
                        }
                        contentValues.put("category_name", "");
                        contentValues.put("series_no", "");
                        contentValues.put("live", "");
                        contentValues.put("container_extension", "");
                        contentValues.put("rating_from_ten", "");
                        contentValues.put("rating_from_five", "");
                        contentValues.put("user_id_referred", Integer.valueOf(userID));
                        writableDatabase.insert("onestream_iptv_live_streams", (String) null, contentValues);
                    }
                    writableDatabase.setTransactionSuccessful();
                    writableDatabase.endTransaction();
                    w.q = false;
                    return true;
                } catch (Exception unused) {
                    writableDatabase.endTransaction();
                    w.q = false;
                    Log.w("msg", "exception");
                    return false;
                }
            } catch (SQLiteDatabaseLockedException unused2) {
                Log.w("msg", "exception");
                writableDatabase.endTransaction();
                w.q = false;
                return false;
            }
        } catch (Exception unused3) {
        }
    }

    public boolean addOneStreamLiveCategories(List list) {
        try {
            int userID = SharepreferenceDBHandler.getUserID(this.context);
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.beginTransaction();
            try {
                try {
                    ContentValues contentValues = new ContentValues();
                    int size = list.size();
                    if (size != 0) {
                        for (int i = 0; i < size; i++) {
                            w.q = true;
                            contentValues.put("categoryID_live", ((LiveDataModel) list.get(i)).getCategory_id());
                            contentValues.put("categoryname_live", ((LiveDataModel) list.get(i)).getCategory_name());
                            contentValues.put("paent_id", ((LiveDataModel) list.get(i)).getParent_id());
                            contentValues.put("user_id_referred", Integer.valueOf(userID));
                            writableDatabase.insert("iptv_onestream_live_category", (String) null, contentValues);
                        }
                    }
                    writableDatabase.setTransactionSuccessful();
                    writableDatabase.endTransaction();
                    w.q = false;
                    return true;
                } catch (Exception unused) {
                    writableDatabase.endTransaction();
                    w.q = false;
                    Log.w("msg", "exception");
                    return false;
                }
            } catch (SQLiteDatabaseLockedException unused2) {
                writableDatabase.endTransaction();
                w.q = false;
                Log.w("msg", "exception");
                return false;
            }
        } catch (Exception unused3) {
            w.q = false;
            return false;
        }
    }

    public boolean addOnestreamMovieCategories(List list) {
        try {
            int userID = SharepreferenceDBHandler.getUserID(this.context);
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.beginTransaction();
            try {
                try {
                    ContentValues contentValues = new ContentValues();
                    int size = list.size();
                    if (size != 0) {
                        for (int i = 0; i < size; i++) {
                            w.q = true;
                            contentValues.put("categoryID_movie", ((LiveDataModel) list.get(i)).getCategory_id());
                            contentValues.put("categoryname_movie", ((LiveDataModel) list.get(i)).getCategory_name());
                            contentValues.put("paent_id", ((LiveDataModel) list.get(i)).getParent_id());
                            contentValues.put("user_id_referred", Integer.valueOf(userID));
                            writableDatabase.insert("iptv_onestream_movie_category", (String) null, contentValues);
                        }
                    }
                    writableDatabase.setTransactionSuccessful();
                    writableDatabase.endTransaction();
                    w.q = false;
                    return true;
                } catch (Exception unused) {
                    writableDatabase.endTransaction();
                    Log.w("msg", "exception");
                    w.q = false;
                    return false;
                }
            } catch (SQLiteDatabaseLockedException unused2) {
                Log.w("msg", "exception");
                writableDatabase.endTransaction();
                w.q = false;
                return false;
            }
        } catch (Exception unused3) {
            w.q = false;
            return false;
        }
    }

    public void addPassword(PasswordDBModel passwordDBModel) {
        String currentAPPType = SharepreferenceDBHandler.getCurrentAPPType(this.context);
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("user_detail", passwordDBModel.getUserDetail());
            contentValues.put("password", passwordDBModel.getUserPassword());
            contentValues.put("user_id_referred", Integer.valueOf(passwordDBModel.getUserId()));
            if (currentAPPType.equals("m3u")) {
                writableDatabase.insert("iptv_password_table_m3u", (String) null, contentValues);
            } else {
                currentAPPType.equals("onestream_api");
                writableDatabase.insert("iptv_password_table", (String) null, contentValues);
            }
            writableDatabase.close();
        } catch (SQLiteDatabaseLockedException | Exception unused) {
            Log.w("msg", "exception");
        }
    }

    public void addPasswordStatus(PasswordStatusDBModel passwordStatusDBModel) {
        String str = SharepreferenceDBHandler.getCurrentAPPType(this.context).equals("m3u") ? "iptv_password_status_table_m3u" : "iptv_password_status_table";
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("password_status_cat_id", passwordStatusDBModel.getPasswordStatusCategoryId());
            contentValues.put("password_user_detail", passwordStatusDBModel.getPasswordStatusUserDetail());
            contentValues.put("password_status", passwordStatusDBModel.getPasswordStatus());
            contentValues.put("user_id_referred", Integer.valueOf(passwordStatusDBModel.getUserID()));
            writableDatabase.insert(str, (String) null, contentValues);
            writableDatabase.close();
        } catch (SQLiteDatabaseLockedException | Exception unused) {
            Log.w("msg", "exception");
        }
    }

    public boolean addSeriesCategories(ArrayList arrayList) {
        try {
            int userID = SharepreferenceDBHandler.getUserID(this.context);
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.beginTransaction();
            try {
                ContentValues contentValues = new ContentValues();
                int size = arrayList.size();
                if (size != 0) {
                    for (int i = 0; i < size; i++) {
                        w.q = true;
                        contentValues.put("category_id_series_v2", ((GetSeriesStreamCategoriesCallback) arrayList.get(i)).getCategoryId());
                        contentValues.put("category_name_series_v2", ((GetSeriesStreamCategoriesCallback) arrayList.get(i)).getCategoryName());
                        contentValues.put("user_id_referred", Integer.valueOf(userID));
                        writableDatabase.insert("series_category_v2", (String) null, contentValues);
                    }
                }
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
                w.q = false;
                return true;
            } catch (SQLiteDatabaseLockedException unused) {
                Log.w("msg", "exception");
                writableDatabase.endTransaction();
                w.q = false;
                return false;
            } catch (Exception e) {
                Log.w("msg", "exception: " + e.getMessage());
                writableDatabase.endTransaction();
                w.q = false;
                return false;
            }
        } catch (Exception unused2) {
            w.q = false;
            return false;
        }
    }

    public void addSeriesCategoriesM3U(M3UCategoriesModel m3UCategoriesModel) {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.beginTransaction();
            try {
                ContentValues contentValues = new ContentValues();
                int userID = SharepreferenceDBHandler.getUserID(this.context);
                contentValues.put("categoryID", m3UCategoriesModel.getCategoryId());
                contentValues.put("categoryname", m3UCategoriesModel.getCategoryName());
                contentValues.put("user_id_referred", Integer.valueOf(userID));
                writableDatabase.insert("iptv_series_category_m3u", (String) null, contentValues);
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
                writableDatabase.close();
            } catch (SQLiteDatabaseLockedException | Exception unused) {
                writableDatabase.endTransaction();
                Log.w("msg", "exception");
            }
        } catch (Exception unused2) {
        }
    }

    public boolean addSeriesCategoriesStalker(StalkerGetSeriesCategoriesCallback stalkerGetSeriesCategoriesCallback) {
        try {
            int userID = SharepreferenceDBHandler.getUserID(this.context);
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.beginTransaction();
            try {
                ContentValues contentValues = new ContentValues();
                int size = stalkerGetSeriesCategoriesCallback.getJs().size();
                if (size != 0) {
                    for (int i = 0; i < size; i++) {
                        if (!((StalkerGetSeriesCategoriesPojo) stalkerGetSeriesCategoriesCallback.getJs().get(i)).getId().equals("*")) {
                            contentValues.put("category_id_series_v2", ((StalkerGetSeriesCategoriesPojo) stalkerGetSeriesCategoriesCallback.getJs().get(i)).getId());
                            contentValues.put("category_name_series_v2", ((StalkerGetSeriesCategoriesPojo) stalkerGetSeriesCategoriesCallback.getJs().get(i)).getTitle());
                            contentValues.put("category_alias_series_v2", ((StalkerGetSeriesCategoriesPojo) stalkerGetSeriesCategoriesCallback.getJs().get(i)).getAlias());
                            contentValues.put("category_censored_series_v2", ((StalkerGetSeriesCategoriesPojo) stalkerGetSeriesCategoriesCallback.getJs().get(i)).getCensored());
                            contentValues.put("user_id_referred", Integer.valueOf(userID));
                            writableDatabase.insert("iptv_stalker_series_category", (String) null, contentValues);
                        }
                    }
                }
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
                return true;
            } catch (SQLiteDatabaseLockedException unused) {
                Log.w("msg", "exception");
                writableDatabase.endTransaction();
                return false;
            } catch (Exception e) {
                Log.w("msg", "exception: " + e.getMessage());
                writableDatabase.endTransaction();
                return false;
            }
        } catch (Exception unused2) {
        }
    }

    public boolean addStalkerAllChannels(List list) {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.beginTransaction();
            try {
                int userID = SharepreferenceDBHandler.getUserID(this.context);
                ContentValues contentValues = new ContentValues();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    StalkerGetAllChannelsPojo2 stalkerGetAllChannelsPojo2 = (StalkerGetAllChannelsPojo2) it.next();
                    if (stalkerGetAllChannelsPojo2.getNumber() != null) {
                        contentValues.put("num", String.valueOf(stalkerGetAllChannelsPojo2.getNumber()));
                    } else {
                        contentValues.put("num", "");
                    }
                    if (stalkerGetAllChannelsPojo2.getName() != null) {
                        contentValues.put("name", stalkerGetAllChannelsPojo2.getName());
                    } else {
                        contentValues.put("name", "");
                    }
                    if (stalkerGetAllChannelsPojo2.getId() != null) {
                        contentValues.put("stream_id", stalkerGetAllChannelsPojo2.getId());
                    } else {
                        contentValues.put("stream_id", "");
                    }
                    if (stalkerGetAllChannelsPojo2.getLogo() != null) {
                        contentValues.put("stream_icon", stalkerGetAllChannelsPojo2.getLogo());
                    } else {
                        contentValues.put("stream_icon", "");
                    }
                    if (stalkerGetAllChannelsPojo2.getXmltvId() != null) {
                        contentValues.put("epg_channel_id", stalkerGetAllChannelsPojo2.getXmltvId());
                    } else {
                        contentValues.put("epg_channel_id", "");
                    }
                    contentValues.put("categoryID", stalkerGetAllChannelsPojo2.getTvGenreId() != null ? stalkerGetAllChannelsPojo2.getTvGenreId() : "-2");
                    if (stalkerGetAllChannelsPojo2.getArchive() != null) {
                        contentValues.put("tv_archive", stalkerGetAllChannelsPojo2.getArchive());
                    } else {
                        contentValues.put("tv_archive", "");
                    }
                    if (stalkerGetAllChannelsPojo2.getCmd() != null) {
                        contentValues.put("cmd", stalkerGetAllChannelsPojo2.getCmd());
                    } else {
                        contentValues.put("cmd", "");
                    }
                    contentValues.put("user_id_referred", Integer.valueOf(userID));
                    writableDatabase.insert("iptv_stalker_live_streams", (String) null, contentValues);
                }
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
                return true;
            } catch (Exception unused) {
                writableDatabase.endTransaction();
                Log.w("msg", "exception");
                return false;
            } catch (SQLiteDatabaseLockedException unused2) {
                Log.w("msg", "exception");
                writableDatabase.endTransaction();
                return false;
            }
        } catch (Exception unused3) {
        }
    }

    public boolean addStalkerLiveCategories(StalkerGetGenresCallback stalkerGetGenresCallback) {
        try {
            int userID = SharepreferenceDBHandler.getUserID(this.context);
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.beginTransaction();
            try {
                ContentValues contentValues = new ContentValues();
                int size = stalkerGetGenresCallback.getJs().size();
                if (size != 0) {
                    for (int i = 0; i < size; i++) {
                        if (!((StalkerGetGenresPojo) stalkerGetGenresCallback.getJs().get(i)).getId().equals("*")) {
                            contentValues.put("categoryID_live", ((StalkerGetGenresPojo) stalkerGetGenresCallback.getJs().get(i)).getId());
                            contentValues.put("categoryname_live", ((StalkerGetGenresPojo) stalkerGetGenresCallback.getJs().get(i)).getTitle());
                            contentValues.put("category_alias_live", ((StalkerGetGenresPojo) stalkerGetGenresCallback.getJs().get(i)).getAlias());
                            contentValues.put("category_censored_live", ((StalkerGetGenresPojo) stalkerGetGenresCallback.getJs().get(i)).getCensored());
                            contentValues.put("user_id_referred", Integer.valueOf(userID));
                            writableDatabase.insert("iptv_stalker_live_category", (String) null, contentValues);
                        }
                    }
                }
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
                return true;
            } catch (Exception unused) {
                writableDatabase.endTransaction();
                Log.w("msg", "exception");
                return false;
            } catch (SQLiteDatabaseLockedException unused2) {
                writableDatabase.endTransaction();
                Log.w("msg", "exception");
                return false;
            }
        } catch (Exception unused3) {
        }
    }

    public boolean addStalkerMoviesCategories(StalkerGetVodCategoriesCallback stalkerGetVodCategoriesCallback) {
        try {
            int userID = SharepreferenceDBHandler.getUserID(this.context);
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.beginTransaction();
            try {
                ContentValues contentValues = new ContentValues();
                int size = stalkerGetVodCategoriesCallback.getJs().size();
                if (size != 0) {
                    for (int i = 0; i < size; i++) {
                        if (!((StalkerGetVodCategoriesPojo) stalkerGetVodCategoriesCallback.getJs().get(i)).getId().equals("*")) {
                            contentValues.put("categoryID_movie", ((StalkerGetVodCategoriesPojo) stalkerGetVodCategoriesCallback.getJs().get(i)).getId());
                            contentValues.put("categoryname_movie", ((StalkerGetVodCategoriesPojo) stalkerGetVodCategoriesCallback.getJs().get(i)).getTitle());
                            contentValues.put("category_alias_movie", ((StalkerGetVodCategoriesPojo) stalkerGetVodCategoriesCallback.getJs().get(i)).getAlias());
                            contentValues.put("category_censored_movie", ((StalkerGetVodCategoriesPojo) stalkerGetVodCategoriesCallback.getJs().get(i)).getCensored());
                            contentValues.put("user_id_referred", Integer.valueOf(userID));
                            writableDatabase.insert("iptv_stalker_movie_category", (String) null, contentValues);
                        }
                    }
                }
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
                return true;
            } catch (Exception unused) {
                writableDatabase.endTransaction();
                Log.w("msg", "exception");
                return false;
            } catch (SQLiteDatabaseLockedException unused2) {
                Log.w("msg", "exception");
                writableDatabase.endTransaction();
                return false;
            }
        } catch (Exception unused3) {
        }
    }

    public void addToFavourite(FavouriteM3UModel favouriteM3UModel) {
        try {
            this.db = getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("url", favouriteM3UModel.getUrl());
            contentValues.put("user_id_referred", Integer.valueOf(favouriteM3UModel.getUserID()));
            contentValues.put("name", favouriteM3UModel.getName());
            contentValues.put("categoryID", favouriteM3UModel.getCategoryID());
            this.db.insert("iptv_m3u_favourites", (String) null, contentValues);
        } catch (SQLiteDatabaseLockedException | Exception unused) {
        }
    }

    public boolean addonestreamSeriesCategories(List list) {
        try {
            int userID = SharepreferenceDBHandler.getUserID(this.context);
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.beginTransaction();
            try {
                ContentValues contentValues = new ContentValues();
                int size = list.size();
                if (size != 0) {
                    for (int i = 0; i < size; i++) {
                        w.q = true;
                        contentValues.put("category_id_series_v2", ((LiveDataModel) list.get(i)).getCategory_id());
                        contentValues.put("category_name_series_v2", ((LiveDataModel) list.get(i)).getCategory_name());
                        contentValues.put("user_id_referred", Integer.valueOf(userID));
                        writableDatabase.insert("onestream_series_category_v2", (String) null, contentValues);
                    }
                }
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
                w.q = false;
                return true;
            } catch (SQLiteDatabaseLockedException unused) {
                Log.w("msg", "exception");
                writableDatabase.endTransaction();
                w.q = false;
                return false;
            } catch (Exception e) {
                Log.w("msg", "exception: " + e.getMessage());
                writableDatabase.endTransaction();
                w.q = false;
                return false;
            }
        } catch (Exception unused2) {
            w.q = false;
            return false;
        }
    }

    public boolean checkCategoryExistsM3U(String str, String str2) {
        StringBuilder sb;
        String str3;
        int userID = SharepreferenceDBHandler.getUserID(this.context);
        str2.hashCode();
        if (str2.equals("live")) {
            sb = new StringBuilder();
            str3 = "SELECT  COUNT(*) FROM iptv_live_category_m3u WHERE categoryID='";
        } else if (str2.equals("movie")) {
            sb = new StringBuilder();
            str3 = "SELECT  COUNT(*) FROM iptv_movie_category_m3u WHERE categoryID='";
        } else {
            sb = new StringBuilder();
            str3 = "SELECT  COUNT(*) FROM iptv_series_category_m3u WHERE categoryID='";
        }
        sb.append(str3);
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
            return i > 0;
        } catch (SQLiteDatabaseLockedException | Exception unused) {
            return false;
        }
    }

    public ArrayList checkFavourite(String str, int i) {
        ArrayList arrayList = new ArrayList();
        try {
            SQLiteDatabase readableDatabase = getReadableDatabase();
            this.db = readableDatabase;
            Cursor rawQuery = readableDatabase.rawQuery("SELECT  * FROM iptv_m3u_favourites WHERE url='" + str + "' AND user_id_referred=" + i + "", (String[]) null);
            if (rawQuery.moveToFirst()) {
                do {
                    FavouriteM3UModel favouriteM3UModel = new FavouriteM3UModel();
                    favouriteM3UModel.setId(Integer.parseInt(rawQuery.getString(0)));
                    favouriteM3UModel.setUrl(str);
                    favouriteM3UModel.setUserID(i);
                    favouriteM3UModel.setName(rawQuery.getString(3));
                    favouriteM3UModel.setCategoryID(rawQuery.getString(4));
                    arrayList.add(favouriteM3UModel);
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
            return arrayList;
        } catch (SQLiteDatabaseLockedException | Exception unused) {
            Log.w("msg", "exception");
            return arrayList;
        }
    }

    public int checkIfEPGSourceAlreadyExists(String str) {
        int userID = SharepreferenceDBHandler.getUserID(this.context);
        try {
            Cursor rawQuery = getReadableDatabase().rawQuery("SELECT * FROM " + (SharepreferenceDBHandler.getCurrentAPPType(this.context).equals("m3u") ? "iptv_epg_sources_m3u" : "iptv_epg_sources") + " WHERE user_id_referred ='" + userID + "' AND epgurl = '" + str + "'", (String[]) null);
            int count = rawQuery.getCount();
            rawQuery.close();
            return count;
        } catch (SQLiteDatabaseLockedException | Exception unused) {
            return 0;
        }
    }

    public void deleteALLLiveRecentlyWatched() {
        try {
            String currentAPPType = SharepreferenceDBHandler.getCurrentAPPType(this.context);
            int userID = SharepreferenceDBHandler.getUserID(this.context);
            getWritableDatabase().execSQL("DELETE FROM iptv_live_watched WHERE user_id_referred = '" + userID + "' AND app_type = '" + currentAPPType + "'");
        } catch (SQLiteDatabaseLockedException | Exception unused) {
            Log.w("msg", "exception");
        }
    }

    public void deleteALLRecentwatch(String str, int i) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        this.db = writableDatabase;
        writableDatabase.delete("iptv_recent_watched_m3u", "stream_type='" + str + "' AND user_id_referred=" + i + "", (String[]) null);
        this.db.close();
    }

    public void deleteAllEPGSources(int i, String str) {
        try {
            String str2 = str.equals("m3u") ? "iptv_epg_sources_m3u" : "iptv_epg_sources";
            getWritableDatabase().execSQL("DELETE FROM " + str2 + " WHERE user_id_referred = '" + i + "'");
        } catch (SQLiteDatabaseLockedException | Exception unused) {
            Log.w("msg", "exception");
        }
    }

    public void deleteAllPasswordData() {
        SQLiteClosable writableDatabase;
        String str = SharepreferenceDBHandler.getCurrentAPPType(this.context).equals("m3u") ? "iptv_password_table_m3u" : "iptv_password_table";
        SQLiteClosable sQLiteClosable = null;
        try {
            writableDatabase = getWritableDatabase();
        } catch (Exception unused) {
        } catch (SQLiteDatabaseLockedException unused2) {
        } catch (Throwable th) {
            th = th;
        }
        try {
            writableDatabase.delete(str, (String) null, (String[]) null);
            writableDatabase.close();
        } catch (SQLiteDatabaseLockedException unused3) {
            sQLiteClosable = writableDatabase;
            if (sQLiteClosable == null) {
                return;
            }
            sQLiteClosable.close();
        } catch (Exception unused4) {
            sQLiteClosable = writableDatabase;
            if (sQLiteClosable == null) {
                return;
            }
            sQLiteClosable.close();
        } catch (Throwable th2) {
            th = th2;
            sQLiteClosable = writableDatabase;
            if (sQLiteClosable != null) {
                sQLiteClosable.close();
            }
            throw th;
        }
    }

    public void deleteAndRecreateAllTables() {
        try {
            getReadableDatabase();
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.execSQL("DROP TABLE IF EXISTS iptv_live_category");
            writableDatabase.execSQL("DROP TABLE IF EXISTS iptv_movie_category");
            writableDatabase.execSQL("DROP TABLE IF EXISTS epg");
            writableDatabase.execSQL("DROP TABLE IF EXISTS iptv_live_streams_category");
            writableDatabase.execSQL("DROP TABLE IF EXISTS iptv_live_streams");
            writableDatabase.execSQL("DROP TABLE IF EXISTS iptv_vod_streams");
            writableDatabase.execSQL("DROP TABLE IF EXISTS iptv_mag_portal_table");
            onCreate(writableDatabase);
            writableDatabase.close();
        } catch (SQLiteDatabaseLockedException | SQLiteException unused) {
            Log.w("msg", "exception");
        }
    }

    public void deleteChannelsHistoryDuplicate() {
        try {
            int userID = SharepreferenceDBHandler.getUserID(this.context);
            String currentAPPType = SharepreferenceDBHandler.getCurrentAPPType(this.context);
            getWritableDatabase().execSQL("DELETE FROM iptv_live_watched WHERE stream_id_url NOT IN (SELECT stream_id FROM iptv_live_streams WHERE stream_type LIKE '%live%' AND user_id_referred ='" + userID + "' ) AND user_id_referred = '" + userID + "' AND app_type = '" + currentAPPType + "'");
        } catch (SQLiteDatabaseLockedException | Exception unused) {
            Log.w("msg", "exception");
        }
    }

    public void deleteChannelsHistoryDuplicateM3U() {
        try {
            int userID = SharepreferenceDBHandler.getUserID(this.context);
            String currentAPPType = SharepreferenceDBHandler.getCurrentAPPType(this.context);
            getWritableDatabase().execSQL("DELETE FROM iptv_live_watched WHERE stream_id_url NOT IN (SELECT url FROM iptv_live_streams_m3u WHERE stream_type LIKE '%live%' AND user_id_referred ='" + userID + "' ) AND user_id_referred = '" + userID + "' AND app_type = '" + currentAPPType + "'");
        } catch (SQLiteDatabaseLockedException | Exception unused) {
            Log.w("msg", "exception");
        }
    }

    public void deleteEPGSource(int i) {
        try {
            int userID = SharepreferenceDBHandler.getUserID(this.context);
            String str = SharepreferenceDBHandler.getCurrentAPPType(this.context).equals("m3u") ? "iptv_epg_sources_m3u" : "iptv_epg_sources";
            getWritableDatabase().execSQL("DELETE FROM " + str + " WHERE user_id_referred = '" + userID + "' AND auto_id = '" + i + "'");
        } catch (SQLiteDatabaseLockedException | Exception unused) {
            Log.w("msg", "exception");
        }
    }

    public void deleteExtraLiveRecentlyWatched() {
        try {
            a aVar = new a(this.context);
            String currentAPPType = SharepreferenceDBHandler.getCurrentAPPType(this.context);
            int userID = SharepreferenceDBHandler.getUserID(this.context);
            getWritableDatabase().execSQL("DELETE FROM iptv_live_watched WHERE user_id_referred = '" + userID + "' AND app_type = '" + currentAPPType + "' AND id NOT IN ( SELECT id FROM iptv_live_watched WHERE user_id_referred = '" + userID + "' AND app_type = '" + currentAPPType + "' ORDER BY id DESC LIMIT " + aVar.z() + ")");
        } catch (SQLiteDatabaseLockedException | Exception unused) {
            Log.w("msg", "exception");
        }
    }

    public void deleteFavDuplicateM3U() {
        try {
            int userID = SharepreferenceDBHandler.getUserID(this.context);
            SharepreferenceDBHandler.getCurrentAPPType(this.context);
            getWritableDatabase().execSQL("DELETE FROM iptv_m3u_favourites WHERE url NOT IN (SELECT url FROM iptv_live_streams_m3u WHERE user_id_referred ='" + userID + "' ) AND user_id_referred = '" + userID + "'");
        } catch (SQLiteDatabaseLockedException | Exception unused) {
            Log.w("msg", "exception");
        }
    }

    public void deleteFavourite(String str, int i) {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            this.db = writableDatabase;
            writableDatabase.delete("iptv_m3u_favourites", "url='" + str + "' AND user_id_referred=" + i, (String[]) null);
            this.db.close();
        } catch (SQLiteDatabaseLockedException | Exception unused) {
        }
    }

    public void deleteImportStatusForUser(int i, String str) {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            this.db = writableDatabase;
            writableDatabase.delete("iptv_import_status", "user_id_referred='" + i + "' AND app_type='" + str + "'", (String[]) null);
        } catch (SQLiteDatabaseLockedException | Exception unused) {
        }
    }

    public void deleteLiveRecentlyWatched(String str) {
        StringBuilder sb;
        try {
            String currentAPPType = SharepreferenceDBHandler.getCurrentAPPType(this.context);
            int userID = SharepreferenceDBHandler.getUserID(this.context);
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (SharepreferenceDBHandler.getCurrentAPPType(this.context).equals("onestream_api")) {
                sb = new StringBuilder();
                sb.append("DELETE FROM iptv_live_watched WHERE stream_id_url = '");
                sb.append(str);
                sb.append("' AND ");
                sb.append("user_id_referred");
                sb.append(" = '");
                sb.append(userID);
                sb.append("' AND ");
                sb.append("app_type");
                sb.append(" = '");
                sb.append(currentAPPType);
                sb.append("'");
            } else {
                sb = new StringBuilder();
                sb.append("DELETE FROM iptv_live_watched WHERE stream_id_url = '");
                sb.append(str);
                sb.append("' AND ");
                sb.append("user_id_referred");
                sb.append(" = '");
                sb.append(userID);
                sb.append("' AND ");
                sb.append("app_type");
                sb.append(" = '");
                sb.append(currentAPPType);
                sb.append("'");
            }
            writableDatabase.execSQL(sb.toString());
        } catch (SQLiteDatabaseLockedException | Exception unused) {
            Log.w("msg", "exception");
        }
    }

    public void deletePasswordDataForUser(int i) {
        String str;
        String str2;
        if (SharepreferenceDBHandler.getCurrentAPPType(this.context).equals("m3u")) {
            str = "iptv_password_table_m3u";
            str2 = "iptv_password_status_table_m3u";
        } else {
            str = "iptv_password_table";
            str2 = "iptv_password_status_table";
        }
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            this.db = writableDatabase;
            writableDatabase.delete(str, "user_id_referred='" + i + "'", (String[]) null);
            this.db.delete(str2, "user_id_referred='" + i + "'", (String[]) null);
            this.db.close();
        } catch (SQLiteDatabaseLockedException | SQLiteException unused) {
        }
    }

    public void deleteRecentwatch(String str, String str2, String str3, int i) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        this.db = writableDatabase;
        writableDatabase.delete("iptv_recent_watched_m3u", "url='" + str + "'  AND stream_type='" + str2 + "' AND user_id_referred=" + i + "", (String[]) null);
        this.db.close();
    }

    public ArrayList getALLFavouritesWithSeriesIDs(String str) {
        String str2 = "SELECT stream_id_series_stream_v2,category_id_series_stream_v2,name_series_stream_v2,num_series_stream_v2 FROM series_streams_v2 WHERE stream_id_series_stream_v2 IN(" + str + ") AND user_id_referred = '" + SharepreferenceDBHandler.getUserID(this.context) + "'";
        ArrayList arrayList = new ArrayList();
        try {
            Cursor rawQuery = getReadableDatabase().rawQuery(str2, (String[]) null);
            if (rawQuery.moveToFirst()) {
                do {
                    LiveStreamsDBModel liveStreamsDBModel = new LiveStreamsDBModel();
                    liveStreamsDBModel.setStreamType("series");
                    liveStreamsDBModel.setStreamId(rawQuery.getString(0));
                    liveStreamsDBModel.setStreamIdOneStream(rawQuery.getString(0));
                    liveStreamsDBModel.setCategoryId(rawQuery.getString(1));
                    liveStreamsDBModel.setName(rawQuery.getString(2));
                    liveStreamsDBModel.setNum(rawQuery.getString(3));
                    arrayList.add(liveStreamsDBModel);
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
            return arrayList;
        } catch (SQLiteDatabaseLockedException | Exception unused) {
            return null;
        }
    }

    public ArrayList getALLFavouritesWithStreamIDs(String str) {
        String str2 = "SELECT stream_type,stream_id,categoryID,name,num FROM iptv_live_streams WHERE stream_id IN(" + str + ") AND user_id_referred = '" + SharepreferenceDBHandler.getUserID(this.context) + "'";
        ArrayList arrayList = new ArrayList();
        try {
            Cursor rawQuery = getReadableDatabase().rawQuery(str2, (String[]) null);
            if (rawQuery.moveToFirst()) {
                do {
                    LiveStreamsDBModel liveStreamsDBModel = new LiveStreamsDBModel();
                    liveStreamsDBModel.setStreamType(rawQuery.getString(0));
                    liveStreamsDBModel.setStreamId(rawQuery.getString(1));
                    liveStreamsDBModel.setStreamIdOneStream(rawQuery.getString(1));
                    liveStreamsDBModel.setCategoryId(rawQuery.getString(2));
                    liveStreamsDBModel.setName(rawQuery.getString(3));
                    liveStreamsDBModel.setNum(rawQuery.getString(4));
                    arrayList.add(liveStreamsDBModel);
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
            return arrayList;
        } catch (SQLiteDatabaseLockedException | Exception unused) {
            return null;
        }
    }

    public ArrayList getALLLiveWatchedWithStreamIDs(String str) {
        String str2 = "SELECT stream_id FROM iptv_live_streams WHERE stream_id IN(" + str + ") AND user_id_referred = '" + SharepreferenceDBHandler.getUserID(this.context) + "'";
        ArrayList arrayList = new ArrayList();
        try {
            Cursor rawQuery = getReadableDatabase().rawQuery(str2, (String[]) null);
            if (rawQuery.moveToFirst()) {
                do {
                    LiveStreamsDBModel liveStreamsDBModel = new LiveStreamsDBModel();
                    liveStreamsDBModel.setStreamId(rawQuery.getString(0));
                    liveStreamsDBModel.setStreamIdOneStream(rawQuery.getString(0));
                    arrayList.add(liveStreamsDBModel);
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
            return arrayList;
        } catch (SQLiteDatabaseLockedException | Exception unused) {
            return null;
        }
    }

    public ArrayList getALLMoviesWatchedWithStreamIDs(String str) {
        String str2 = "SELECT num,name,stream_type,stream_id,stream_icon,added,categoryID,container_extension,rating_from_ten,rating_from_five FROM iptv_live_streams WHERE stream_id IN(" + str + ") AND user_id_referred = '" + SharepreferenceDBHandler.getUserID(this.context) + "' AND stream_type LIKE '%movie%'";
        ArrayList arrayList = new ArrayList();
        try {
            Cursor rawQuery = getReadableDatabase().rawQuery(str2, (String[]) null);
            if (rawQuery.moveToFirst()) {
                do {
                    LiveStreamsDBModel liveStreamsDBModel = new LiveStreamsDBModel();
                    liveStreamsDBModel.setNum(rawQuery.getString(0));
                    liveStreamsDBModel.setName(rawQuery.getString(1));
                    liveStreamsDBModel.setStreamType(rawQuery.getString(2));
                    liveStreamsDBModel.setStreamId(rawQuery.getString(3));
                    liveStreamsDBModel.setStreamIdOneStream(rawQuery.getString(3));
                    liveStreamsDBModel.setStreamIcon(rawQuery.getString(4));
                    liveStreamsDBModel.setAdded(rawQuery.getString(5));
                    liveStreamsDBModel.setCategoryId(rawQuery.getString(6));
                    liveStreamsDBModel.setContaiinerExtension(rawQuery.getString(7));
                    liveStreamsDBModel.setRatingFromTen(rawQuery.getString(8));
                    liveStreamsDBModel.setRatingFromFive(rawQuery.getString(9));
                    liveStreamsDBModel.setUrl(rawQuery.getString(10));
                    arrayList.add(liveStreamsDBModel);
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
            return arrayList;
        } catch (SQLiteDatabaseLockedException | Exception unused) {
            return null;
        }
    }

    public ArrayList getALLSeriesWatchedWithSeriesIDs(String str) {
        StringBuilder sb;
        String str2;
        int userID = SharepreferenceDBHandler.getUserID(this.context);
        if (SharepreferenceDBHandler.getCurrentAPPType(this.context).equals("onestream_api")) {
            sb = new StringBuilder();
            str2 = "SELECT  category_id_series_stream_v2,stream_cover_series_stream_v2,num_series_stream_v2,name_series_stream_v2,stream_id_series_stream_v2 FROM onestream_series_streams_v2 WHERE stream_id_series_stream_v2 IN(";
        } else {
            sb = new StringBuilder();
            str2 = "SELECT  category_id_series_stream_v2,stream_cover_series_stream_v2,num_series_stream_v2,name_series_stream_v2,stream_id_series_stream_v2 FROM series_streams_v2 WHERE stream_id_series_stream_v2 IN(";
        }
        sb.append(str2);
        sb.append(str);
        sb.append(") AND ");
        sb.append("user_id_referred");
        sb.append(" = '");
        sb.append(userID);
        sb.append("'");
        String sb2 = sb.toString();
        ArrayList arrayList = new ArrayList();
        try {
            Cursor rawQuery = getReadableDatabase().rawQuery(sb2, (String[]) null);
            if (rawQuery.moveToFirst()) {
                do {
                    GetEpisdoeDetailsCallback getEpisdoeDetailsCallback = new GetEpisdoeDetailsCallback();
                    getEpisdoeDetailsCallback.setCategoryId(rawQuery.getString(0));
                    getEpisdoeDetailsCallback.setSeriesCover(rawQuery.getString(1));
                    getEpisdoeDetailsCallback.setSeriesNum(rawQuery.getString(2));
                    getEpisdoeDetailsCallback.setSeriesName(rawQuery.getString(3));
                    getEpisdoeDetailsCallback.setSeriesId(rawQuery.getString(4));
                    arrayList.add(getEpisdoeDetailsCallback);
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
            return arrayList;
        } catch (SQLiteDatabaseLockedException | Exception unused) {
            return null;
        }
    }

    public ArrayList getActiveEPGSource() {
        int userID = SharepreferenceDBHandler.getUserID(this.context);
        String str = "SELECT  * FROM " + (SharepreferenceDBHandler.getCurrentAPPType(this.context).equals("m3u") ? "iptv_epg_sources_m3u" : "iptv_epg_sources") + " WHERE user_id_referred ='" + userID + "' AND default_source = '1' LIMIT 1";
        try {
            ArrayList arrayList = new ArrayList();
            Cursor rawQuery = getReadableDatabase().rawQuery(str, (String[]) null);
            if (rawQuery.moveToFirst()) {
                do {
                    EPGSourcesModel ePGSourcesModel = new EPGSourcesModel();
                    ePGSourcesModel.setIdAuto(w.r0(rawQuery.getString(0)));
                    ePGSourcesModel.setUser_id(rawQuery.getString(1));
                    ePGSourcesModel.setName(rawQuery.getString(2));
                    ePGSourcesModel.setSource_type(rawQuery.getString(3));
                    ePGSourcesModel.setEpgurl(rawQuery.getString(4));
                    ePGSourcesModel.setDefault_source(rawQuery.getString(5));
                    arrayList.add(ePGSourcesModel);
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
            return arrayList;
        } catch (SQLiteDatabaseLockedException | Exception unused) {
            return null;
        }
    }

    /*  JADX ERROR: ConcurrentModificationException in pass: ConstructorVisitor
        java.util.ConcurrentModificationException
        	at java.util.ArrayList$Itr.next(ArrayList.java:860)
        	at jadx.core.dex.visitors.ConstructorVisitor.insertPhiInsn(Unknown Source:39)
        	at jadx.core.dex.visitors.ConstructorVisitor.processInvoke(Unknown Source:123)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(Unknown Source:59)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(Unknown Source:7)
        */
    public java.util.ArrayList getAllFavourites(
    /*  JADX ERROR: ConcurrentModificationException in pass: ConstructorVisitor
        java.util.ConcurrentModificationException
        	at java.util.ArrayList$Itr.next(ArrayList.java:860)
        	at jadx.core.dex.visitors.ConstructorVisitor.insertPhiInsn(Unknown Source:39)
        	at jadx.core.dex.visitors.ConstructorVisitor.processInvoke(Unknown Source:123)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(Unknown Source:59)
        */
    /*  JADX ERROR: Method generation error
        LL1ili1iI1iI.IIiLliI1l1li1: Code variable not set in r13v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(Unknown Source:28)
        	at l111lLIIl11iL.L111LiLLi1iiliL.lILLi11Li1lll(Unknown Source:44)
        	at l111lLIIl11iL.L111LiLLi1iiliL.iliLiI1iLLIL(Unknown Source:469)
        	at l111lLIIl11iL.l1LII1ii11LI11.iLIi1LlIlIil1(Unknown Source:61)
        	at l111lLIIl11iL.l1LII1ii11LI11.LIi1LL1Ilill1l(Unknown Source:22)
        	at l111lLIIl11iL.l1LII1ii11LI11.lL111llILliLi(Unknown Source:12)
        	at l111lLIIl11iL.l1LII1ii11LI11.LlIIlIliLlL1IiL(Unknown Source:0)
        	at l111lLIIl11iL.IIiLliI1l1li1.accept(Unknown Source:6)
        	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
        	at java.util.stream.-$$Lambda$Abl7XfE0Z4AgkViLas9vhsO9mjw.accept(Unknown Source:2)
        	at java.util.ArrayList.forEach(ArrayList.java:1262)
        	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:390)
        	at java.util.stream.Sink$ChainedReference.end(Sink.java:260)
        */

    public ArrayList getAllLiveMoviesStreamIDs(String str) {
        StringBuilder sb;
        String str2;
        int i;
        int userID = SharepreferenceDBHandler.getUserID(this.context);
        ArrayList arrayList = new ArrayList();
        if (SharepreferenceDBHandler.getCurrentAPPType(this.context).equals("onestream_api")) {
            sb = new StringBuilder();
            sb.append("SELECT stream_id FROM onestream_iptv_live_streams WHERE stream_type LIKE '%");
            sb.append(str);
            sb.append("%'  AND ");
            str2 = "onestream_iptv_live_streams";
        } else {
            sb = new StringBuilder();
            sb.append("SELECT stream_id FROM iptv_live_streams WHERE stream_type LIKE '%");
            sb.append(str);
            sb.append("%'  AND ");
            str2 = "iptv_live_streams";
        }
        sb.append(str2);
        sb.append(".");
        sb.append("user_id_referred");
        sb.append("='");
        sb.append(userID);
        sb.append("'");
        try {
            Cursor rawQuery = getReadableDatabase().rawQuery(sb.toString(), (String[]) null);
            if (rawQuery.moveToFirst()) {
                do {
                    try {
                        i = Integer.parseInt(rawQuery.getString(0));
                    } catch (NumberFormatException unused) {
                        i = 0;
                    }
                    String string = rawQuery.getString(0);
                    LiveStreamsDBModel liveStreamsDBModel = new LiveStreamsDBModel();
                    liveStreamsDBModel.setStreamId(String.valueOf(i));
                    liveStreamsDBModel.setStreamIdOneStream(string);
                    arrayList.add(liveStreamsDBModel);
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
            return arrayList;
        } catch (SQLiteDatabaseLockedException | Exception unused2) {
            return null;
        }
    }

    public ArrayList getAllLiveStreamsArchive(String str) {
        String str2;
        String str3;
        StringBuilder sb;
        StringBuilder sb2;
        String sb3;
        ArrayList arrayList;
        int userID = SharepreferenceDBHandler.getUserID(this.context);
        String liveSubCatSort = SharepreferenceDBHandler.getLiveSubCatSort(this.context);
        if (!str.equals("0")) {
            ArrayList arrayList2 = new ArrayList();
            if (SharepreferenceDBHandler.getCurrentAPPType(this.context).equals("onestream_api")) {
                str2 = "SELECT  * FROM onestream_iptv_live_streams WHERE stream_type LIKE '%live%' AND user_id_referred='" + userID + "' AND tv_archive='1' AND categoryID ='" + str + "'";
            } else {
                str2 = "SELECT  * FROM iptv_live_streams WHERE stream_type LIKE '%live%' AND user_id_referred='" + userID + "' AND tv_archive='1' AND categoryID ='" + str + "' AND epg_channel_id IS NOT NULL AND epg_channel_id !='' ORDER BY added DESC";
            }
            try {
                try {
                    Cursor rawQuery = getReadableDatabase().rawQuery(str2, (String[]) null);
                    if (rawQuery.moveToFirst()) {
                        do {
                            LiveStreamsDBModel liveStreamsDBModel = new LiveStreamsDBModel();
                            liveStreamsDBModel.setIdAuto(Integer.parseInt(rawQuery.getString(0)));
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
                            liveStreamsDBModel.setUrl(rawQuery.getString(18));
                            arrayList2.add(liveStreamsDBModel);
                        } while (rawQuery.moveToNext());
                    }
                    rawQuery.close();
                    return arrayList2;
                } catch (SQLiteDatabaseLockedException unused) {
                    return null;
                } catch (Exception unused2) {
                    return null;
                }
            } catch (Exception unused3) {
                return null;
            } catch (SQLiteDatabaseLockedException unused4) {
                return null;
            }
        }
        ArrayList arrayList3 = new ArrayList();
        if (!SharepreferenceDBHandler.getCurrentAPPType(this.context).equals("onestream_api")) {
            str3 = " ASC";
            if (liveSubCatSort.equals("0")) {
                sb2 = new StringBuilder();
                sb2.append("SELECT  * FROM iptv_live_streams WHERE stream_type LIKE '%live%' AND user_id_referred='");
                sb2.append(userID);
                sb2.append("' AND ");
                sb2.append("tv_archive");
                sb2.append("='1' AND ");
                sb2.append("epg_channel_id");
                sb2.append(" IS NOT NULL AND ");
                sb2.append("epg_channel_id");
                sb2.append(" !='' ");
                sb3 = sb2.toString();
            } else if (liveSubCatSort.equals("1")) {
                sb2 = new StringBuilder();
                sb2.append("SELECT  * FROM iptv_live_streams WHERE stream_type LIKE '%live%' AND user_id_referred='");
                sb2.append(userID);
                sb2.append("' AND ");
                sb2.append("tv_archive");
                sb2.append("='1' AND ");
                sb2.append("epg_channel_id");
                sb2.append(" IS NOT NULL AND ");
                sb2.append("epg_channel_id");
                sb2.append(" !='' ORDER BY ");
                sb2.append("added");
                sb2.append(" DESC");
                sb3 = sb2.toString();
            } else if (liveSubCatSort.equals("3")) {
                sb = new StringBuilder();
                sb.append("SELECT  * FROM iptv_live_streams WHERE stream_type LIKE '%live%' AND user_id_referred='");
                sb.append(userID);
                sb.append("' AND ");
                sb.append("tv_archive");
                sb.append("='1' AND ");
                sb.append("epg_channel_id");
                sb.append(" IS NOT NULL AND ");
                sb.append("epg_channel_id");
                sb.append(" !='' ORDER BY ");
                sb.append("name");
                sb.append(" DESC");
                sb3 = sb.toString();
            } else {
                sb = new StringBuilder();
                sb.append("SELECT  * FROM iptv_live_streams WHERE stream_type LIKE '%live%' AND user_id_referred='");
                sb.append(userID);
                sb.append("' AND ");
                sb.append("tv_archive");
                sb.append("='1' AND ");
                sb.append("epg_channel_id");
                sb.append(" IS NOT NULL AND ");
                sb.append("epg_channel_id");
                sb.append(" !='' ORDER BY ");
                sb.append("name");
                sb.append(str3);
                sb3 = sb.toString();
            }
        } else if (liveSubCatSort.equals("0")) {
            sb2 = new StringBuilder();
            sb2.append("SELECT  * FROM onestream_iptv_live_streams WHERE stream_type LIKE '%live%' AND user_id_referred='");
            sb2.append(userID);
            sb2.append("' AND ");
            sb2.append("tv_archive");
            sb2.append("='1' AND ");
            sb2.append("epg_channel_id");
            sb2.append(" IS NOT NULL AND ");
            sb2.append("epg_channel_id");
            sb2.append(" !='' ");
            sb3 = sb2.toString();
        } else if (liveSubCatSort.equals("1")) {
            sb2 = new StringBuilder();
            sb2.append("SELECT  * FROM onestream_iptv_live_streams WHERE stream_type LIKE '%live%' AND user_id_referred='");
            sb2.append(userID);
            sb2.append("' AND ");
            sb2.append("tv_archive");
            sb2.append("='1' AND ");
            sb2.append("epg_channel_id");
            sb2.append(" IS NOT NULL AND ");
            sb2.append("epg_channel_id");
            sb2.append(" !='' ORDER BY ");
            sb2.append("added");
            sb2.append(" DESC");
            sb3 = sb2.toString();
        } else if (liveSubCatSort.equals("3")) {
            sb = new StringBuilder();
            sb.append("SELECT  * FROM onestream_iptv_live_streams WHERE stream_type LIKE '%live%' AND user_id_referred='");
            sb.append(userID);
            sb.append("' AND ");
            sb.append("tv_archive");
            sb.append("='1' AND ");
            sb.append("epg_channel_id");
            sb.append(" IS NOT NULL AND ");
            sb.append("epg_channel_id");
            sb.append(" !='' ORDER BY ");
            sb.append("name");
            sb.append(" DESC");
            sb3 = sb.toString();
        } else {
            sb = new StringBuilder();
            sb.append("SELECT  * FROM onestream_iptv_live_streams WHERE stream_type LIKE '%live%' AND user_id_referred='");
            sb.append(userID);
            sb.append("' AND ");
            sb.append("tv_archive");
            sb.append("='1' AND ");
            sb.append("epg_channel_id");
            sb.append(" IS NOT NULL AND ");
            sb.append("epg_channel_id");
            sb.append(" !='' ORDER BY ");
            sb.append("name");
            str3 = " ASC";
            sb.append(str3);
            sb3 = sb.toString();
        }
        try {
            try {
                Cursor rawQuery2 = getReadableDatabase().rawQuery(sb3, (String[]) null);
                if (rawQuery2.moveToFirst()) {
                    while (true) {
                        LiveStreamsDBModel liveStreamsDBModel2 = new LiveStreamsDBModel();
                        liveStreamsDBModel2.setIdAuto(Integer.parseInt(rawQuery2.getString(0)));
                        liveStreamsDBModel2.setNum(rawQuery2.getString(1));
                        liveStreamsDBModel2.setName(rawQuery2.getString(2));
                        liveStreamsDBModel2.setStreamType(rawQuery2.getString(3));
                        liveStreamsDBModel2.setStreamId(rawQuery2.getString(4));
                        liveStreamsDBModel2.setStreamIdOneStream(rawQuery2.getString(4));
                        liveStreamsDBModel2.setStreamIcon(rawQuery2.getString(5));
                        liveStreamsDBModel2.setEpgChannelId(rawQuery2.getString(6));
                        liveStreamsDBModel2.setAdded(rawQuery2.getString(7));
                        liveStreamsDBModel2.setCategoryId(rawQuery2.getString(8));
                        liveStreamsDBModel2.setCustomSid(rawQuery2.getString(9));
                        liveStreamsDBModel2.setTvArchive(rawQuery2.getString(10));
                        liveStreamsDBModel2.setDirectSource(rawQuery2.getString(11));
                        liveStreamsDBModel2.setTvArchiveDuration(rawQuery2.getString(12));
                        liveStreamsDBModel2.setTypeName(rawQuery2.getString(13));
                        liveStreamsDBModel2.setCategoryName(rawQuery2.getString(14));
                        liveStreamsDBModel2.setSeriesNo(rawQuery2.getString(15));
                        liveStreamsDBModel2.setLive(rawQuery2.getString(16));
                        liveStreamsDBModel2.setContaiinerExtension(rawQuery2.getString(17));
                        liveStreamsDBModel2.setUrl(rawQuery2.getString(18));
                        arrayList = arrayList3;
                        arrayList.add(liveStreamsDBModel2);
                        if (!rawQuery2.moveToNext()) {
                            break;
                        }
                        arrayList3 = arrayList;
                    }
                } else {
                    arrayList = arrayList3;
                }
                rawQuery2.close();
                return arrayList;
            } catch (Exception unused5) {
                return null;
            } catch (SQLiteDatabaseLockedException unused6) {
                return null;
            }
        } catch (SQLiteDatabaseLockedException unused7) {
            return null;
        } catch (Exception unused8) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x00c5 A[Catch: SQLiteDatabaseLockedException | Exception -> 0x01a0, LOOP:0: B:11:0x00c5->B:19:?, LOOP_START, TRY_LEAVE, TryCatch #1 {SQLiteDatabaseLockedException | Exception -> 0x01a0, blocks: (B:9:0x00b7, B:11:0x00c5, B:14:0x00cb, B:14:0x00cb, B:16:0x00d7, B:16:0x00d7, B:22:0x019c, B:22:0x019c), top: B:8:0x00b7 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.ArrayList getAllLiveStreasWithCategoryId(java.lang.String r8, int r9, java.lang.String r10) {
        /*
            Method dump skipped, instructions count: 417
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler.getAllLiveStreasWithCategoryId(java.lang.String, int, java.lang.String):java.util.ArrayList");
    }

    public ArrayList getAllLiveStreasWithSkyId(String str, String str2) {
        String str3;
        ArrayList arrayList;
        String str4;
        ArrayList arrayList2;
        String str5;
        ArrayList arrayList3 = new ArrayList();
        int userID = SharepreferenceDBHandler.getUserID(this.context);
        String currentAPPType = SharepreferenceDBHandler.getCurrentAPPType(this.context);
        if (currentAPPType.equals("m3u")) {
            if (str.equals("0")) {
                str5 = "SELECT  * FROM iptv_live_streams_m3u WHERE stream_type ='" + str2 + "' AND user_id_referred='" + userID + "'";
            } else if (str.equals("-2") || str.equals("-3") || str.equals("null")) {
                str5 = "";
            } else {
                str5 = "SELECT  * FROM iptv_live_streams_m3u WHERE stream_type ='" + str2 + "' AND categoryID ='" + str + "' AND user_id_referred='" + userID + "'";
            }
            try {
                try {
                    Cursor rawQuery = getReadableDatabase().rawQuery(str5, (String[]) null);
                    if (rawQuery.moveToFirst()) {
                        do {
                            LiveStreamsDBModel liveStreamsDBModel = new LiveStreamsDBModel();
                            liveStreamsDBModel.setIdAuto(Integer.parseInt(rawQuery.getString(0)));
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
                            liveStreamsDBModel.setUrl(rawQuery.getString(18));
                            arrayList3.add(liveStreamsDBModel);
                        } while (rawQuery.moveToNext());
                    }
                    rawQuery.close();
                    return arrayList3;
                } catch (SQLiteDatabaseLockedException unused) {
                    return null;
                } catch (Exception unused2) {
                    return null;
                }
            } catch (SQLiteDatabaseLockedException unused3) {
                return null;
            } catch (Exception unused4) {
                return null;
            }
        }
        ArrayList arrayList4 = arrayList3;
        if (currentAPPType.equals("onestream_api")) {
            if (str.equals("0") && str2.equals("live")) {
                str4 = "SELECT  * FROM onestream_iptv_live_streams WHERE (stream_type LIKE '%" + str2 + "%' OR stream_type LIKE '%radio%' ) AND user_id_referred='" + userID + "'";
            } else if (str.equals("-2") || str.equals("-3")) {
                str4 = "SELECT  * FROM onestream_iptv_live_streams WHERE (stream_type LIKE '%" + str2 + "%' OR stream_type LIKE '%radio%' ) AND categoryID ='" + str + "' AND user_id_referred='" + userID + "'";
            } else {
                StringBuilder sb = str.equals("null") ? new StringBuilder() : new StringBuilder();
                sb.append("SELECT  * FROM onestream_iptv_live_streams WHERE categoryID ='");
                sb.append(str);
                sb.append("' AND ");
                sb.append("user_id_referred");
                sb.append("='");
                sb.append(userID);
                sb.append("'");
                str4 = sb.toString();
            }
            try {
                try {
                    Cursor rawQuery2 = getReadableDatabase().rawQuery(str4, (String[]) null);
                    if (rawQuery2.moveToFirst()) {
                        while (true) {
                            LiveStreamsDBModel liveStreamsDBModel2 = new LiveStreamsDBModel();
                            liveStreamsDBModel2.setIdAuto(Integer.parseInt(rawQuery2.getString(0)));
                            liveStreamsDBModel2.setNum(rawQuery2.getString(1));
                            liveStreamsDBModel2.setName(rawQuery2.getString(2));
                            liveStreamsDBModel2.setStreamType(rawQuery2.getString(3));
                            liveStreamsDBModel2.setStreamId(rawQuery2.getString(4));
                            liveStreamsDBModel2.setStreamIdOneStream(rawQuery2.getString(4));
                            liveStreamsDBModel2.setStreamIcon(rawQuery2.getString(5));
                            liveStreamsDBModel2.setEpgChannelId(rawQuery2.getString(6));
                            liveStreamsDBModel2.setAdded(rawQuery2.getString(7));
                            liveStreamsDBModel2.setCategoryId(rawQuery2.getString(8));
                            liveStreamsDBModel2.setCustomSid(rawQuery2.getString(9));
                            liveStreamsDBModel2.setTvArchive(rawQuery2.getString(10));
                            liveStreamsDBModel2.setDirectSource(rawQuery2.getString(11));
                            liveStreamsDBModel2.setTvArchiveDuration(rawQuery2.getString(12));
                            liveStreamsDBModel2.setTypeName(rawQuery2.getString(13));
                            liveStreamsDBModel2.setCategoryName(rawQuery2.getString(14));
                            liveStreamsDBModel2.setSeriesNo(rawQuery2.getString(15));
                            liveStreamsDBModel2.setLive(rawQuery2.getString(16));
                            liveStreamsDBModel2.setContaiinerExtension(rawQuery2.getString(17));
                            liveStreamsDBModel2.setUrl(rawQuery2.getString(20));
                            arrayList2 = arrayList4;
                            arrayList2.add(liveStreamsDBModel2);
                            if (!rawQuery2.moveToNext()) {
                                break;
                            }
                            arrayList4 = arrayList2;
                        }
                    } else {
                        arrayList2 = arrayList4;
                    }
                    rawQuery2.close();
                    return arrayList2;
                } catch (SQLiteDatabaseLockedException unused5) {
                    return null;
                } catch (Exception unused6) {
                    return null;
                }
            } catch (Exception unused7) {
                return null;
            } catch (SQLiteDatabaseLockedException unused8) {
                return null;
            }
        }
        if (str.equals("0") && str2.equals("live")) {
            str3 = "SELECT  * FROM iptv_live_streams WHERE (stream_type LIKE '%" + str2 + "%' OR stream_type LIKE '%radio%' ) AND user_id_referred='" + userID + "'";
        } else if (str.equals("-2") || str.equals("-3")) {
            str3 = "SELECT  * FROM iptv_live_streams WHERE (stream_type LIKE '%" + str2 + "%' OR stream_type LIKE '%radio%' ) AND categoryID ='" + str + "' AND user_id_referred='" + userID + "'";
        } else {
            StringBuilder sb2 = str.equals("null") ? new StringBuilder() : new StringBuilder();
            sb2.append("SELECT  * FROM iptv_live_streams WHERE categoryID ='");
            sb2.append(str);
            sb2.append("' AND ");
            sb2.append("user_id_referred");
            sb2.append("='");
            sb2.append(userID);
            sb2.append("'");
            str3 = sb2.toString();
        }
        try {
            try {
                Cursor rawQuery3 = getReadableDatabase().rawQuery(str3, (String[]) null);
                if (rawQuery3.moveToFirst()) {
                    while (true) {
                        LiveStreamsDBModel liveStreamsDBModel3 = new LiveStreamsDBModel();
                        liveStreamsDBModel3.setIdAuto(Integer.parseInt(rawQuery3.getString(0)));
                        liveStreamsDBModel3.setNum(rawQuery3.getString(1));
                        liveStreamsDBModel3.setName(rawQuery3.getString(2));
                        liveStreamsDBModel3.setStreamType(rawQuery3.getString(3));
                        liveStreamsDBModel3.setStreamId(rawQuery3.getString(4));
                        liveStreamsDBModel3.setStreamIdOneStream(rawQuery3.getString(4));
                        liveStreamsDBModel3.setStreamIcon(rawQuery3.getString(5));
                        liveStreamsDBModel3.setEpgChannelId(rawQuery3.getString(6));
                        liveStreamsDBModel3.setAdded(rawQuery3.getString(7));
                        liveStreamsDBModel3.setCategoryId(rawQuery3.getString(8));
                        liveStreamsDBModel3.setCustomSid(rawQuery3.getString(9));
                        liveStreamsDBModel3.setTvArchive(rawQuery3.getString(10));
                        liveStreamsDBModel3.setDirectSource(rawQuery3.getString(11));
                        liveStreamsDBModel3.setTvArchiveDuration(rawQuery3.getString(12));
                        liveStreamsDBModel3.setTypeName(rawQuery3.getString(13));
                        liveStreamsDBModel3.setCategoryName(rawQuery3.getString(14));
                        liveStreamsDBModel3.setSeriesNo(rawQuery3.getString(15));
                        liveStreamsDBModel3.setLive(rawQuery3.getString(16));
                        liveStreamsDBModel3.setContaiinerExtension(rawQuery3.getString(17));
                        liveStreamsDBModel3.setUrl(rawQuery3.getString(18));
                        arrayList = arrayList4;
                        arrayList.add(liveStreamsDBModel3);
                        if (!rawQuery3.moveToNext()) {
                            break;
                        }
                        arrayList4 = arrayList;
                    }
                } else {
                    arrayList = arrayList4;
                }
                rawQuery3.close();
                return arrayList;
            } catch (SQLiteDatabaseLockedException unused9) {
                return null;
            } catch (Exception unused10) {
                return null;
            }
        } catch (SQLiteDatabaseLockedException unused11) {
            return null;
        } catch (Exception unused12) {
            return null;
        }
    }

    public ArrayList getAllLiveWatchedIDString() {
        String str = "SELECT GROUP_CONCAT(stream_id_url) AS stream_id_url , app_type FROM iptv_live_watched WHERE user_id_referred=" + SharepreferenceDBHandler.getUserID(this.context) + " GROUP BY app_type";
        ArrayList arrayList = new ArrayList();
        try {
            SQLiteDatabase readableDatabase = getReadableDatabase();
            this.db = readableDatabase;
            Cursor rawQuery = readableDatabase.rawQuery(str, (String[]) null);
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

    public ArrayList getAllMovieCategoriesHavingParentIdNotZero(String str) {
        StringBuilder sb;
        String str2;
        ArrayList arrayList = new ArrayList();
        int userID = SharepreferenceDBHandler.getUserID(this.context);
        if (SharepreferenceDBHandler.getCurrentAPPType(this.context).equals("onestream_api")) {
            sb = new StringBuilder();
            str2 = "SELECT * FROM iptv_onestream_movie_category WHERE paent_id='";
        } else {
            sb = new StringBuilder();
            str2 = "SELECT * FROM iptv_movie_category WHERE paent_id='";
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
            if (rawQuery.moveToFirst()) {
                do {
                    LiveStreamCategoryIdDBModel liveStreamCategoryIdDBModel = new LiveStreamCategoryIdDBModel();
                    liveStreamCategoryIdDBModel.setId(Integer.parseInt(rawQuery.getString(0)));
                    liveStreamCategoryIdDBModel.setLiveStreamCategoryID(rawQuery.getString(1));
                    liveStreamCategoryIdDBModel.setLiveStreamCategoryName(rawQuery.getString(2));
                    liveStreamCategoryIdDBModel.setParentId(Integer.parseInt(rawQuery.getString(3)));
                    arrayList.add(liveStreamCategoryIdDBModel);
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
            return arrayList;
        } catch (SQLiteDatabaseLockedException | Exception unused) {
            return null;
        }
    }

    public ArrayList getAllMovieCategoriesHavingParentIdZero() {
        int i;
        ArrayList arrayList;
        int i2;
        ArrayList arrayList2;
        ArrayList arrayList3 = new ArrayList();
        int userID = SharepreferenceDBHandler.getUserID(this.context);
        String currentAPPType = SharepreferenceDBHandler.getCurrentAPPType(this.context);
        if (currentAPPType.equals("m3u")) {
            StringBuilder sb = new StringBuilder();
            ArrayList arrayList4 = arrayList3;
            sb.append("SELECT iptv_movie_category_m3u.* , COUNT(iptv_live_streams_m3u.id) AS TOTAL_COUNT FROM iptv_movie_category_m3u,iptv_live_streams_m3u WHERE iptv_movie_category_m3u.categoryID = iptv_live_streams_m3u.categoryID AND iptv_movie_category_m3u.user_id_referred = '");
            sb.append(userID);
            sb.append("' AND ");
            sb.append("iptv_live_streams_m3u");
            sb.append(".");
            sb.append("user_id_referred");
            sb.append(" = '");
            sb.append(userID);
            sb.append("' AND ");
            sb.append("iptv_live_streams_m3u");
            sb.append(".");
            sb.append("stream_type");
            sb.append(" = 'movie' AND ");
            sb.append("iptv_live_streams_m3u");
            sb.append(".");
            sb.append("categoryID");
            sb.append(" NOT IN (SELECT ");
            sb.append("iptv_password_status_table_m3u");
            sb.append(".");
            sb.append("password_status_cat_id");
            sb.append(" FROM ");
            sb.append("iptv_password_status_table_m3u");
            sb.append(" WHERE ");
            sb.append("iptv_password_status_table_m3u");
            sb.append(".");
            sb.append("user_id_referred");
            sb.append(" ='");
            sb.append(userID);
            sb.append("' AND ");
            sb.append("iptv_password_status_table_m3u");
            sb.append(".");
            sb.append("password_status");
            sb.append(" ='1') GROUP BY ");
            sb.append("iptv_live_streams_m3u");
            sb.append(".");
            sb.append("categoryID");
            sb.append(" ORDER BY ");
            sb.append("iptv_movie_category_m3u");
            sb.append(".");
            sb.append("id");
            try {
                try {
                    Cursor rawQuery = getReadableDatabase().rawQuery(sb.toString(), (String[]) null);
                    if (rawQuery.moveToFirst()) {
                        while (true) {
                            LiveStreamCategoryIdDBModel liveStreamCategoryIdDBModel = new LiveStreamCategoryIdDBModel();
                            liveStreamCategoryIdDBModel.setId(Integer.parseInt(rawQuery.getString(0)));
                            liveStreamCategoryIdDBModel.setLiveStreamCategoryID(rawQuery.getString(1));
                            liveStreamCategoryIdDBModel.setLiveStreamCategoryName(rawQuery.getString(2));
                            liveStreamCategoryIdDBModel.setLiveStreamCounter(w.r0(rawQuery.getString(5)));
                            arrayList2 = arrayList4;
                            arrayList2.add(liveStreamCategoryIdDBModel);
                            if (!rawQuery.moveToNext()) {
                                break;
                            }
                            arrayList4 = arrayList2;
                        }
                    } else {
                        arrayList2 = arrayList4;
                    }
                    rawQuery.close();
                    return arrayList2;
                } catch (SQLiteDatabaseLockedException unused) {
                    return null;
                } catch (Exception unused2) {
                    return null;
                }
            } catch (Exception unused3) {
                return null;
            } catch (SQLiteDatabaseLockedException unused4) {
                return null;
            }
        }
        ArrayList arrayList5 = arrayList3;
        if (currentAPPType.equals("onestream_api")) {
            try {
                try {
                    Cursor rawQuery2 = getReadableDatabase().rawQuery("SELECT iptv_onestream_movie_category.* , COUNT(onestream_iptv_live_streams.id) AS TOTAL_COUNT FROM iptv_onestream_movie_category,onestream_iptv_live_streams WHERE iptv_onestream_movie_category.categoryID_movie = onestream_iptv_live_streams.categoryID AND iptv_onestream_movie_category.user_id_referred = '" + userID + "' AND onestream_iptv_live_streams.user_id_referred = '" + userID + "' AND onestream_iptv_live_streams.stream_type = 'movie' AND onestream_iptv_live_streams.categoryID NOT IN (SELECT iptv_password_status_table.password_status_cat_id FROM iptv_password_status_table WHERE iptv_password_status_table.user_id_referred ='" + userID + "' AND iptv_password_status_table.password_status ='1') GROUP BY onestream_iptv_live_streams.categoryID ORDER BY iptv_onestream_movie_category.id_movie", (String[]) null);
                    if (rawQuery2.moveToFirst()) {
                        while (true) {
                            try {
                                i2 = Integer.parseInt(rawQuery2.getString(3));
                            } catch (NumberFormatException unused5) {
                                i2 = 0;
                            }
                            LiveStreamCategoryIdDBModel liveStreamCategoryIdDBModel2 = new LiveStreamCategoryIdDBModel();
                            liveStreamCategoryIdDBModel2.setId(Integer.parseInt(rawQuery2.getString(0)));
                            liveStreamCategoryIdDBModel2.setLiveStreamCategoryID(rawQuery2.getString(1));
                            liveStreamCategoryIdDBModel2.setLiveStreamCategoryName(rawQuery2.getString(2));
                            liveStreamCategoryIdDBModel2.setParentId(i2);
                            liveStreamCategoryIdDBModel2.setLiveStreamCounter(w.r0(rawQuery2.getString(5)));
                            arrayList = arrayList5;
                            arrayList.add(liveStreamCategoryIdDBModel2);
                            if (!rawQuery2.moveToNext()) {
                                break;
                            }
                            arrayList5 = arrayList;
                        }
                    } else {
                        arrayList = arrayList5;
                    }
                    rawQuery2.close();
                    return arrayList;
                } catch (SQLiteDatabaseLockedException unused6) {
                    return null;
                } catch (Exception unused7) {
                    return null;
                }
            } catch (SQLiteDatabaseLockedException unused8) {
                return null;
            } catch (Exception unused9) {
                return null;
            }
        }
        if (currentAPPType.equals("stalker_api")) {
            try {
                try {
                    Cursor rawQuery3 = getReadableDatabase().rawQuery("SELECT iptv_stalker_movie_category.* FROM iptv_stalker_movie_category WHERE iptv_stalker_movie_category.user_id_referred = '" + userID + "' AND iptv_stalker_movie_category.categoryID_movie NOT IN (SELECT iptv_password_status_table.password_status_cat_id FROM iptv_password_status_table WHERE iptv_password_status_table.user_id_referred ='" + userID + "' AND iptv_password_status_table.password_status ='1') ORDER BY iptv_stalker_movie_category.id_movie", (String[]) null);
                    if (rawQuery3.moveToFirst()) {
                        do {
                            LiveStreamCategoryIdDBModel liveStreamCategoryIdDBModel3 = new LiveStreamCategoryIdDBModel();
                            liveStreamCategoryIdDBModel3.setId(Integer.parseInt(rawQuery3.getString(0)));
                            liveStreamCategoryIdDBModel3.setLiveStreamCategoryID(rawQuery3.getString(1));
                            liveStreamCategoryIdDBModel3.setLiveStreamCategoryName(rawQuery3.getString(2));
                            liveStreamCategoryIdDBModel3.setAlias(rawQuery3.getString(3));
                            liveStreamCategoryIdDBModel3.setCensored(rawQuery3.getString(4));
                            arrayList5.add(liveStreamCategoryIdDBModel3);
                        } while (rawQuery3.moveToNext());
                    }
                    rawQuery3.close();
                    return arrayList5;
                } catch (Exception unused10) {
                    return null;
                } catch (SQLiteDatabaseLockedException unused11) {
                    return null;
                }
            } catch (SQLiteDatabaseLockedException unused12) {
                return null;
            } catch (Exception unused13) {
                return null;
            }
        }
        try {
            try {
                Cursor rawQuery4 = getReadableDatabase().rawQuery("SELECT iptv_movie_category.* , COUNT(iptv_live_streams.id) AS TOTAL_COUNT FROM iptv_movie_category,iptv_live_streams WHERE iptv_movie_category.categoryID_movie = iptv_live_streams.categoryID AND iptv_movie_category.user_id_referred = '" + userID + "' AND iptv_live_streams.user_id_referred = '" + userID + "' AND iptv_live_streams.stream_type = 'movie' AND iptv_live_streams.categoryID NOT IN (SELECT iptv_password_status_table.password_status_cat_id FROM iptv_password_status_table WHERE iptv_password_status_table.user_id_referred ='" + userID + "' AND iptv_password_status_table.password_status ='1') GROUP BY iptv_live_streams.categoryID ORDER BY iptv_movie_category.id_movie", (String[]) null);
                if (rawQuery4.moveToFirst()) {
                    do {
                        try {
                            i = Integer.parseInt(rawQuery4.getString(3));
                        } catch (NumberFormatException unused14) {
                            i = 0;
                        }
                        LiveStreamCategoryIdDBModel liveStreamCategoryIdDBModel4 = new LiveStreamCategoryIdDBModel();
                        liveStreamCategoryIdDBModel4.setId(Integer.parseInt(rawQuery4.getString(0)));
                        liveStreamCategoryIdDBModel4.setLiveStreamCategoryID(rawQuery4.getString(1));
                        liveStreamCategoryIdDBModel4.setLiveStreamCategoryName(rawQuery4.getString(2));
                        liveStreamCategoryIdDBModel4.setParentId(i);
                        liveStreamCategoryIdDBModel4.setLiveStreamCounter(w.r0(rawQuery4.getString(5)));
                        arrayList5.add(liveStreamCategoryIdDBModel4);
                    } while (rawQuery4.moveToNext());
                }
                rawQuery4.close();
                return arrayList5;
            } catch (SQLiteDatabaseLockedException unused15) {
                return null;
            } catch (Exception unused16) {
                return null;
            }
        } catch (SQLiteDatabaseLockedException unused17) {
            return null;
        } catch (Exception unused18) {
            return null;
        }
    }

    public ArrayList getAllMovieCategoriesHavingParentIdZeroForParental() {
        StringBuilder sb;
        String str;
        int i;
        ArrayList arrayList = new ArrayList();
        int userID = SharepreferenceDBHandler.getUserID(this.context);
        String currentAPPType = SharepreferenceDBHandler.getCurrentAPPType(this.context);
        if (currentAPPType.equals("m3u")) {
            sb = new StringBuilder();
            sb.append("SELECT * FROM iptv_movie_category_m3u WHERE user_id_referred='");
            sb.append(userID);
            sb.append("' AND ");
            sb.append("categoryID");
            sb.append(" IS NOT NULL");
        } else {
            if (currentAPPType.equals("onestream_api")) {
                sb = new StringBuilder();
                sb.append("SELECT iptv_onestream_movie_category.* , COUNT(onestream_iptv_live_streams.id) AS TOTAL_COUNT FROM iptv_onestream_movie_category,onestream_iptv_live_streams WHERE iptv_onestream_movie_category.categoryID_movie = onestream_iptv_live_streams.categoryID AND iptv_onestream_movie_category.user_id_referred = '");
                sb.append(userID);
                sb.append("' AND ");
                sb.append("onestream_iptv_live_streams");
                sb.append(".");
                sb.append("stream_type");
                sb.append(" = 'movie' GROUP BY ");
                sb.append("onestream_iptv_live_streams");
                sb.append(".");
                sb.append("categoryID");
                sb.append(" ORDER BY ");
                str = "iptv_onestream_movie_category";
            } else {
                sb = new StringBuilder();
                sb.append("SELECT iptv_movie_category.* , COUNT(iptv_live_streams.id) AS TOTAL_COUNT FROM iptv_movie_category,iptv_live_streams WHERE iptv_movie_category.categoryID_movie = iptv_live_streams.categoryID AND iptv_movie_category.user_id_referred = '");
                sb.append(userID);
                sb.append("' AND ");
                sb.append("iptv_live_streams");
                sb.append(".");
                sb.append("stream_type");
                sb.append(" = 'movie' GROUP BY ");
                sb.append("iptv_live_streams");
                sb.append(".");
                sb.append("categoryID");
                sb.append(" ORDER BY ");
                str = "iptv_movie_category";
            }
            sb.append(str);
            sb.append(".");
            sb.append("id_movie");
        }
        try {
            Cursor rawQuery = getReadableDatabase().rawQuery(sb.toString(), (String[]) null);
            if (rawQuery.moveToFirst()) {
                do {
                    try {
                        i = Integer.parseInt(rawQuery.getString(3));
                    } catch (NumberFormatException unused) {
                        i = 0;
                    }
                    LiveStreamCategoryIdDBModel liveStreamCategoryIdDBModel = new LiveStreamCategoryIdDBModel();
                    liveStreamCategoryIdDBModel.setId(Integer.parseInt(rawQuery.getString(0)));
                    liveStreamCategoryIdDBModel.setLiveStreamCategoryID(rawQuery.getString(1));
                    liveStreamCategoryIdDBModel.setLiveStreamCategoryName(rawQuery.getString(2));
                    liveStreamCategoryIdDBModel.setParentId(i);
                    liveStreamCategoryIdDBModel.setLiveStreamCounter(w.r0(rawQuery.getString(5)));
                    arrayList.add(liveStreamCategoryIdDBModel);
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
            return arrayList;
        } catch (SQLiteDatabaseLockedException | Exception unused2) {
            return null;
        }
    }

    public ArrayList getAllPassword(int i) {
        StringBuilder sb;
        String str;
        ArrayList arrayList = new ArrayList();
        if (SharepreferenceDBHandler.getCurrentAPPType(this.context).equals("m3u")) {
            sb = new StringBuilder();
            str = "SELECT * FROM iptv_password_table_m3u WHERE user_id_referred=";
        } else {
            sb = new StringBuilder();
            str = "SELECT * FROM iptv_password_table WHERE user_id_referred=";
        }
        sb.append(str);
        sb.append(i);
        sb.append("");
        try {
            Cursor rawQuery = getReadableDatabase().rawQuery(sb.toString(), (String[]) null);
            if (rawQuery.moveToFirst()) {
                do {
                    PasswordDBModel passwordDBModel = new PasswordDBModel();
                    passwordDBModel.setId(Integer.parseInt(rawQuery.getString(0)));
                    passwordDBModel.setUserDetail(rawQuery.getString(1));
                    passwordDBModel.setUserPassword(rawQuery.getString(2));
                    arrayList.add(passwordDBModel);
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
            return arrayList;
        } catch (SQLiteDatabaseLockedException | Exception unused) {
            return null;
        }
    }

    public ArrayList getAllPasswordStatus(int i) {
        String str;
        ArrayList arrayList = new ArrayList();
        String currentAPPType = SharepreferenceDBHandler.getCurrentAPPType(this.context);
        if (currentAPPType.equals("m3u")) {
            str = "iptv_password_status_table_m3u";
        } else {
            currentAPPType.equals("onestream_api");
            str = "iptv_password_status_table";
        }
        try {
            Cursor rawQuery = getReadableDatabase().rawQuery("SELECT * FROM " + str + " WHERE user_id_referred=" + i + "", (String[]) null);
            if (rawQuery.moveToFirst()) {
                do {
                    PasswordStatusDBModel passwordStatusDBModel = new PasswordStatusDBModel();
                    passwordStatusDBModel.setIdPaswordStaus(Integer.parseInt(rawQuery.getString(0)));
                    passwordStatusDBModel.setPasswordStatusCategoryId(rawQuery.getString(1));
                    passwordStatusDBModel.setPasswordStatusUserDetail(rawQuery.getString(2));
                    passwordStatusDBModel.setPasswordStatus(rawQuery.getString(3));
                    arrayList.add(passwordStatusDBModel);
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
            return arrayList;
        } catch (SQLiteDatabaseLockedException | Exception unused) {
            return null;
        }
    }

    public int getAllRecentlyMoviesStreamCount(int i) {
        StringBuilder sb;
        String str;
        int i2;
        int userID = SharepreferenceDBHandler.getUserID(this.context);
        if (SharepreferenceDBHandler.getCurrentAPPType(this.context).equals("onestream_api")) {
            sb = new StringBuilder();
            str = "SELECT * FROM onestream_iptv_live_streams WHERE stream_type ='movie' AND user_id_referred = '";
        } else {
            sb = new StringBuilder();
            str = "SELECT * FROM iptv_live_streams WHERE stream_type ='movie' AND user_id_referred = '";
        }
        sb.append(str);
        sb.append(userID);
        sb.append("'  ORDER BY ");
        sb.append("id");
        sb.append(" DESC LIMIT ");
        sb.append(i);
        try {
            Cursor rawQuery = getReadableDatabase().rawQuery(sb.toString(), (String[]) null);
            if (rawQuery.moveToFirst()) {
                i2 = 0;
                while (true) {
                    AsyncTask asyncTask = w.m;
                    if (asyncTask != null && asyncTask.isCancelled()) {
                        Log.e("honey", "stopped");
                        break;
                    }
                    i2++;
                    if (!rawQuery.moveToNext()) {
                        break;
                    }
                }
            } else {
                i2 = 0;
            }
            rawQuery.close();
            return i2;
        } catch (SQLiteDatabaseLockedException | Exception unused) {
            return 0;
        }
    }

    public int getAllRecentlySeriesStreamCount(int i) {
        StringBuilder sb;
        String str;
        int i2;
        int userID = SharepreferenceDBHandler.getUserID(this.context);
        if (SharepreferenceDBHandler.getCurrentAPPType(this.context).equals("onestream_api")) {
            sb = new StringBuilder();
            str = "SELECT * FROM onestream_series_streams_v2 WHERE user_id_referred = '";
        } else {
            sb = new StringBuilder();
            str = "SELECT * FROM series_streams_v2 WHERE user_id_referred = '";
        }
        sb.append(str);
        sb.append(userID);
        sb.append("' ORDER BY ");
        sb.append("id_series_stream_v2");
        sb.append(" DESC LIMIT ");
        sb.append(i);
        try {
            Cursor rawQuery = getReadableDatabase().rawQuery(sb.toString(), (String[]) null);
            if (rawQuery.moveToFirst()) {
                i2 = 0;
                while (true) {
                    AsyncTask asyncTask = w.m;
                    if (asyncTask != null && asyncTask.isCancelled()) {
                        Log.e("honey", "stopped");
                        break;
                    }
                    i2++;
                    if (!rawQuery.moveToNext()) {
                        break;
                    }
                }
            } else {
                i2 = 0;
            }
            rawQuery.close();
            return i2;
        } catch (SQLiteDatabaseLockedException | Exception unused) {
            return 0;
        }
    }

    public ArrayList getAllRecentlyWatchedLiveStreams(String str) {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        int userID = SharepreferenceDBHandler.getUserID(this.context);
        String currentAPPType = SharepreferenceDBHandler.getCurrentAPPType(this.context);
        ArrayList arrayList4 = new ArrayList();
        if (currentAPPType.equals("m3u")) {
            try {
                try {
                    Cursor rawQuery = getReadableDatabase().rawQuery("SELECT iptv_live_streams_m3u.* FROM iptv_live_streams_m3u INNER JOIN iptv_live_watched ON iptv_live_streams_m3u.url = iptv_live_watched.stream_id_url AND iptv_live_streams_m3u.stream_type LIKE '%live%'  AND iptv_live_streams_m3u.user_id_referred ='" + userID + "' AND iptv_live_watched.user_id_referred ='" + userID + "' AND iptv_live_watched.app_type ='m3u' AND iptv_live_streams_m3u.categoryID NOT IN (SELECT iptv_password_status_table_m3u.password_status_cat_id FROM iptv_password_status_table_m3u WHERE iptv_password_status_table_m3u.user_id_referred ='" + userID + "' AND iptv_password_status_table_m3u.password_status ='1') ORDER BY iptv_live_watched.id DESC", (String[]) null);
                    if (rawQuery.moveToFirst()) {
                        while (SharepreferenceDBHandler.getAsyncTaskStatus(this.context) != 1) {
                            try {
                                LiveStreamsDBModel liveStreamsDBModel = new LiveStreamsDBModel();
                                liveStreamsDBModel.setIdAuto(Integer.parseInt(rawQuery.getString(0)));
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
                                liveStreamsDBModel.setUrl(rawQuery.getString(18));
                                arrayList3 = arrayList4;
                                arrayList3.add(liveStreamsDBModel);
                                if (!rawQuery.moveToNext()) {
                                    break;
                                }
                                arrayList4 = arrayList3;
                            } catch (Exception unused) {
                                return null;
                            } catch (SQLiteDatabaseLockedException unused2) {
                                return null;
                            }
                        }
                        SharepreferenceDBHandler.setAsyncTaskStatus(0, this.context);
                        arrayList3 = arrayList4;
                    } else {
                        arrayList3 = arrayList4;
                    }
                    rawQuery.close();
                    return arrayList3;
                } catch (SQLiteDatabaseLockedException unused3) {
                    return null;
                } catch (Exception unused4) {
                    return null;
                }
            } catch (SQLiteDatabaseLockedException unused5) {
            } catch (Exception unused6) {
            }
        } else {
            ArrayList arrayList5 = arrayList4;
            if (currentAPPType.equals("onestream_api")) {
                try {
                    try {
                        Cursor rawQuery2 = getReadableDatabase().rawQuery("SELECT onestream_iptv_live_streams.* FROM onestream_iptv_live_streams INNER JOIN iptv_live_watched ON onestream_iptv_live_streams.stream_id = iptv_live_watched.stream_id_url AND onestream_iptv_live_streams.stream_type LIKE '%live%'  AND onestream_iptv_live_streams.user_id_referred ='" + userID + "' AND iptv_live_watched.user_id_referred ='" + userID + "' AND iptv_live_watched.type ='" + str + "' AND iptv_live_watched.app_type ='onestream_api' AND onestream_iptv_live_streams.categoryID NOT IN (SELECT iptv_password_status_table.password_status_cat_id FROM iptv_password_status_table WHERE iptv_password_status_table.user_id_referred ='" + userID + "' AND iptv_password_status_table.password_status ='1') ORDER BY iptv_live_watched.id DESC", (String[]) null);
                        if (rawQuery2.moveToFirst()) {
                            while (SharepreferenceDBHandler.getAsyncTaskStatus(this.context) != 1) {
                                try {
                                    LiveStreamsDBModel liveStreamsDBModel2 = new LiveStreamsDBModel();
                                    liveStreamsDBModel2.setIdAuto(Integer.parseInt(rawQuery2.getString(0)));
                                    liveStreamsDBModel2.setNum(rawQuery2.getString(1));
                                    liveStreamsDBModel2.setName(rawQuery2.getString(2));
                                    liveStreamsDBModel2.setStreamType(rawQuery2.getString(3));
                                    liveStreamsDBModel2.setStreamId(rawQuery2.getString(4));
                                    liveStreamsDBModel2.setStreamIdOneStream(rawQuery2.getString(4));
                                    liveStreamsDBModel2.setStreamIcon(rawQuery2.getString(5));
                                    liveStreamsDBModel2.setEpgChannelId(rawQuery2.getString(6));
                                    liveStreamsDBModel2.setAdded(rawQuery2.getString(7));
                                    liveStreamsDBModel2.setCategoryId(rawQuery2.getString(8));
                                    liveStreamsDBModel2.setCustomSid(rawQuery2.getString(9));
                                    liveStreamsDBModel2.setTvArchive(rawQuery2.getString(10));
                                    liveStreamsDBModel2.setDirectSource(rawQuery2.getString(11));
                                    liveStreamsDBModel2.setTvArchiveDuration(rawQuery2.getString(12));
                                    liveStreamsDBModel2.setTypeName(rawQuery2.getString(13));
                                    liveStreamsDBModel2.setCategoryName(rawQuery2.getString(14));
                                    liveStreamsDBModel2.setSeriesNo(rawQuery2.getString(15));
                                    liveStreamsDBModel2.setLive(rawQuery2.getString(16));
                                    liveStreamsDBModel2.setContaiinerExtension(rawQuery2.getString(17));
                                    liveStreamsDBModel2.setRatingFromTen(rawQuery2.getString(18));
                                    liveStreamsDBModel2.setRatingFromFive(rawQuery2.getString(19));
                                    liveStreamsDBModel2.setUrl(rawQuery2.getString(20));
                                    arrayList2 = arrayList5;
                                    arrayList2.add(liveStreamsDBModel2);
                                    if (!rawQuery2.moveToNext()) {
                                        break;
                                    }
                                    arrayList5 = arrayList2;
                                } catch (SQLiteDatabaseLockedException unused7) {
                                    return null;
                                } catch (Exception unused8) {
                                    return null;
                                }
                            }
                            SharepreferenceDBHandler.setAsyncTaskStatus(0, this.context);
                        }
                        arrayList2 = arrayList5;
                        rawQuery2.close();
                        return arrayList2;
                    } catch (Exception unused9) {
                        return null;
                    } catch (SQLiteDatabaseLockedException unused10) {
                        return null;
                    }
                } catch (Exception unused11) {
                } catch (SQLiteDatabaseLockedException unused12) {
                }
            } else {
                ArrayList arrayList6 = arrayList5;
                try {
                    try {
                        Cursor rawQuery3 = getReadableDatabase().rawQuery("SELECT iptv_live_streams.* FROM iptv_live_streams INNER JOIN iptv_live_watched ON iptv_live_streams.stream_id = iptv_live_watched.stream_id_url AND iptv_live_streams.stream_type LIKE '%live%'  AND iptv_live_streams.user_id_referred ='" + userID + "' AND iptv_live_watched.user_id_referred ='" + userID + "' AND iptv_live_watched.type ='" + str + "' AND iptv_live_watched.app_type ='api' AND iptv_live_streams.categoryID NOT IN (SELECT iptv_password_status_table.password_status_cat_id FROM iptv_password_status_table WHERE iptv_password_status_table.user_id_referred ='" + userID + "' AND iptv_password_status_table.password_status ='1') ORDER BY iptv_live_watched.id DESC", (String[]) null);
                        if (rawQuery3.moveToFirst()) {
                            while (SharepreferenceDBHandler.getAsyncTaskStatus(this.context) != 1) {
                                try {
                                    LiveStreamsDBModel liveStreamsDBModel3 = new LiveStreamsDBModel();
                                    liveStreamsDBModel3.setIdAuto(Integer.parseInt(rawQuery3.getString(0)));
                                    liveStreamsDBModel3.setNum(rawQuery3.getString(1));
                                    liveStreamsDBModel3.setName(rawQuery3.getString(2));
                                    liveStreamsDBModel3.setStreamType(rawQuery3.getString(3));
                                    liveStreamsDBModel3.setStreamId(rawQuery3.getString(4));
                                    liveStreamsDBModel3.setStreamIdOneStream(rawQuery3.getString(4));
                                    liveStreamsDBModel3.setStreamIcon(rawQuery3.getString(5));
                                    liveStreamsDBModel3.setEpgChannelId(rawQuery3.getString(6));
                                    liveStreamsDBModel3.setAdded(rawQuery3.getString(7));
                                    liveStreamsDBModel3.setCategoryId(rawQuery3.getString(8));
                                    liveStreamsDBModel3.setCustomSid(rawQuery3.getString(9));
                                    liveStreamsDBModel3.setTvArchive(rawQuery3.getString(10));
                                    liveStreamsDBModel3.setDirectSource(rawQuery3.getString(11));
                                    liveStreamsDBModel3.setTvArchiveDuration(rawQuery3.getString(12));
                                    liveStreamsDBModel3.setTypeName(rawQuery3.getString(13));
                                    liveStreamsDBModel3.setCategoryName(rawQuery3.getString(14));
                                    liveStreamsDBModel3.setSeriesNo(rawQuery3.getString(15));
                                    liveStreamsDBModel3.setLive(rawQuery3.getString(16));
                                    liveStreamsDBModel3.setContaiinerExtension(rawQuery3.getString(17));
                                    liveStreamsDBModel3.setRatingFromTen(rawQuery3.getString(18));
                                    liveStreamsDBModel3.setRatingFromFive(rawQuery3.getString(19));
                                    liveStreamsDBModel3.setUrl(rawQuery3.getString(20));
                                    arrayList = arrayList6;
                                    arrayList.add(liveStreamsDBModel3);
                                    if (!rawQuery3.moveToNext()) {
                                        break;
                                    }
                                    arrayList6 = arrayList;
                                } catch (SQLiteDatabaseLockedException unused13) {
                                    return null;
                                } catch (Exception unused14) {
                                    return null;
                                }
                            }
                            SharepreferenceDBHandler.setAsyncTaskStatus(0, this.context);
                        }
                        arrayList = arrayList6;
                        rawQuery3.close();
                        return arrayList;
                    } catch (Exception unused15) {
                        return null;
                    } catch (SQLiteDatabaseLockedException unused16) {
                        return null;
                    }
                } catch (Exception unused17) {
                } catch (SQLiteDatabaseLockedException unused18) {
                }
            }
        }
    }

    public ArrayList getAllSeriesCategories() {
        ArrayList arrayList = new ArrayList();
        try {
            Cursor rawQuery = getReadableDatabase().rawQuery("SELECT * FROM iptv_series_category_m3u WHERE user_id_referred='" + SharepreferenceDBHandler.getUserID(this.context) + "' AND categoryID IS NOT NULL", (String[]) null);
            if (rawQuery.moveToFirst()) {
                do {
                    LiveStreamCategoryIdDBModel liveStreamCategoryIdDBModel = new LiveStreamCategoryIdDBModel();
                    liveStreamCategoryIdDBModel.setId(Integer.parseInt(rawQuery.getString(0)));
                    liveStreamCategoryIdDBModel.setLiveStreamCategoryID(rawQuery.getString(1));
                    liveStreamCategoryIdDBModel.setLiveStreamCategoryName(rawQuery.getString(2));
                    liveStreamCategoryIdDBModel.setParentId(0);
                    arrayList.add(liveStreamCategoryIdDBModel);
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
            return arrayList;
        } catch (SQLiteDatabaseLockedException | Exception unused) {
            return null;
        }
    }

    public ArrayList getAllSeriesCategoriesForParental() {
        StringBuilder sb;
        String str;
        int userID = SharepreferenceDBHandler.getUserID(this.context);
        ArrayList arrayList = new ArrayList();
        if (SharepreferenceDBHandler.getCurrentAPPType(this.context).equals("onestream_api")) {
            sb = new StringBuilder();
            sb.append("SELECT onestream_series_category_v2.* FROM onestream_series_category_v2,onestream_series_streams_v2 WHERE onestream_series_category_v2.category_id_series_v2 = onestream_series_streams_v2.category_id_series_stream_v2 AND onestream_series_category_v2.user_id_referred = '");
            sb.append(userID);
            sb.append("' GROUP BY ");
            sb.append("onestream_series_streams_v2");
            sb.append(".");
            sb.append("category_id_series_stream_v2");
            sb.append(" ORDER BY ");
            str = "onestream_series_category_v2";
        } else {
            sb = new StringBuilder();
            sb.append("SELECT series_category_v2.* FROM series_category_v2,series_streams_v2 WHERE series_category_v2.category_id_series_v2 = series_streams_v2.category_id_series_stream_v2 AND series_category_v2.user_id_referred = '");
            sb.append(userID);
            sb.append("' GROUP BY ");
            sb.append("series_streams_v2");
            sb.append(".");
            sb.append("category_id_series_stream_v2");
            sb.append(" ORDER BY ");
            str = "series_category_v2";
        }
        sb.append(str);
        sb.append(".");
        sb.append("id_series_v2");
        try {
            Cursor rawQuery = getReadableDatabase().rawQuery(sb.toString(), (String[]) null);
            if (rawQuery.moveToFirst()) {
                do {
                    LiveStreamCategoryIdDBModel liveStreamCategoryIdDBModel = new LiveStreamCategoryIdDBModel();
                    liveStreamCategoryIdDBModel.setId(Integer.parseInt(rawQuery.getString(0)));
                    liveStreamCategoryIdDBModel.setLiveStreamCategoryName(rawQuery.getString(1));
                    liveStreamCategoryIdDBModel.setLiveStreamCategoryID(rawQuery.getString(2));
                    arrayList.add(liveStreamCategoryIdDBModel);
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
            return arrayList;
        } catch (SQLiteDatabaseLockedException | Exception unused) {
            return null;
        }
    }

    public ArrayList getAllSeriesCategoriesMain() {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3 = new ArrayList();
        int userID = SharepreferenceDBHandler.getUserID(this.context);
        String currentAPPType = SharepreferenceDBHandler.getCurrentAPPType(this.context);
        if (currentAPPType.equals("m3u")) {
            try {
                try {
                    Cursor rawQuery = getReadableDatabase().rawQuery("SELECT iptv_series_category_m3u.* , COUNT(iptv_live_streams_m3u.id) AS TOTAL_COUNT FROM iptv_series_category_m3u,iptv_live_streams_m3u WHERE iptv_series_category_m3u.categoryID = iptv_live_streams_m3u.categoryID AND iptv_series_category_m3u.user_id_referred = '" + userID + "' AND iptv_live_streams_m3u.user_id_referred = '" + userID + "' AND iptv_live_streams_m3u.stream_type = 'series' AND iptv_live_streams_m3u.categoryID NOT IN (SELECT iptv_password_status_table_m3u.password_status_cat_id FROM iptv_password_status_table_m3u WHERE iptv_password_status_table_m3u.user_id_referred ='" + userID + "' AND iptv_password_status_table_m3u.password_status ='1') GROUP BY iptv_live_streams_m3u.categoryID ORDER BY iptv_series_category_m3u.id", (String[]) null);
                    if (rawQuery.moveToFirst()) {
                        do {
                            LiveStreamCategoryIdDBModel liveStreamCategoryIdDBModel = new LiveStreamCategoryIdDBModel();
                            liveStreamCategoryIdDBModel.setId(Integer.parseInt(rawQuery.getString(0)));
                            liveStreamCategoryIdDBModel.setLiveStreamCategoryID(rawQuery.getString(1));
                            liveStreamCategoryIdDBModel.setLiveStreamCategoryName(rawQuery.getString(2));
                            liveStreamCategoryIdDBModel.setLiveStreamCounter(w.r0(rawQuery.getString(4)));
                            arrayList3.add(liveStreamCategoryIdDBModel);
                        } while (rawQuery.moveToNext());
                    }
                    rawQuery.close();
                    return arrayList3;
                } catch (Exception unused) {
                    return null;
                } catch (SQLiteDatabaseLockedException unused2) {
                    return null;
                }
            } catch (Exception unused3) {
                return null;
            } catch (SQLiteDatabaseLockedException unused4) {
                return null;
            }
        }
        if (currentAPPType.equals("stalker_api")) {
            try {
                try {
                    Cursor rawQuery2 = getReadableDatabase().rawQuery("SELECT iptv_stalker_series_category.* FROM iptv_stalker_series_category WHERE iptv_stalker_series_category.user_id_referred = '" + userID + "' AND iptv_stalker_series_category.category_id_series_v2 NOT IN (SELECT iptv_password_status_table.password_status_cat_id FROM iptv_password_status_table WHERE iptv_password_status_table.user_id_referred ='" + userID + "' AND iptv_password_status_table.password_status ='1') ORDER BY iptv_stalker_series_category.id_series_v2", (String[]) null);
                    if (rawQuery2.moveToFirst()) {
                        do {
                            LiveStreamCategoryIdDBModel liveStreamCategoryIdDBModel2 = new LiveStreamCategoryIdDBModel();
                            liveStreamCategoryIdDBModel2.setId(Integer.parseInt(rawQuery2.getString(0)));
                            liveStreamCategoryIdDBModel2.setLiveStreamCategoryName(rawQuery2.getString(1));
                            liveStreamCategoryIdDBModel2.setLiveStreamCategoryID(rawQuery2.getString(2));
                            liveStreamCategoryIdDBModel2.setAlias(rawQuery2.getString(3));
                            liveStreamCategoryIdDBModel2.setCensored(rawQuery2.getString(4));
                            arrayList3.add(liveStreamCategoryIdDBModel2);
                        } while (rawQuery2.moveToNext());
                    }
                    rawQuery2.close();
                    return arrayList3;
                } catch (SQLiteDatabaseLockedException unused5) {
                    return null;
                } catch (Exception unused6) {
                    return null;
                }
            } catch (Exception unused7) {
                return null;
            } catch (SQLiteDatabaseLockedException unused8) {
                return null;
            }
        }
        if (currentAPPType.equals("onestream_api")) {
            StringBuilder sb = new StringBuilder();
            ArrayList arrayList4 = arrayList3;
            sb.append("SELECT onestream_series_category_v2.* , COUNT(onestream_series_streams_v2.id_series_stream_v2) AS TOTAL_COUNT FROM onestream_series_category_v2,onestream_series_streams_v2 WHERE onestream_series_category_v2.category_id_series_v2 = onestream_series_streams_v2.category_id_series_stream_v2 AND onestream_series_category_v2.user_id_referred = '");
            sb.append(userID);
            sb.append("' AND ");
            sb.append("onestream_series_streams_v2");
            sb.append(".");
            sb.append("user_id_referred");
            sb.append(" = '");
            sb.append(userID);
            sb.append("' AND ");
            sb.append("onestream_series_streams_v2");
            sb.append(".");
            sb.append("category_id_series_stream_v2");
            sb.append(" NOT IN (SELECT ");
            sb.append("iptv_password_status_table");
            sb.append(".");
            sb.append("password_status_cat_id");
            sb.append(" FROM ");
            sb.append("iptv_password_status_table");
            sb.append(" WHERE ");
            sb.append("iptv_password_status_table");
            sb.append(".");
            sb.append("user_id_referred");
            sb.append(" ='");
            sb.append(userID);
            sb.append("' AND ");
            sb.append("iptv_password_status_table");
            sb.append(".");
            sb.append("password_status");
            sb.append(" ='1') GROUP BY ");
            sb.append("onestream_series_streams_v2");
            sb.append(".");
            sb.append("category_id_series_stream_v2");
            sb.append(" ORDER BY ");
            sb.append("onestream_series_category_v2");
            sb.append(".");
            sb.append("id_series_v2");
            try {
                try {
                    Cursor rawQuery3 = getReadableDatabase().rawQuery(sb.toString(), (String[]) null);
                    if (rawQuery3.moveToFirst()) {
                        while (true) {
                            LiveStreamCategoryIdDBModel liveStreamCategoryIdDBModel3 = new LiveStreamCategoryIdDBModel();
                            liveStreamCategoryIdDBModel3.setId(Integer.parseInt(rawQuery3.getString(0)));
                            liveStreamCategoryIdDBModel3.setLiveStreamCategoryName(rawQuery3.getString(1));
                            liveStreamCategoryIdDBModel3.setLiveStreamCategoryID(rawQuery3.getString(2));
                            liveStreamCategoryIdDBModel3.setLiveStreamCounter(w.r0(rawQuery3.getString(4)));
                            arrayList2 = arrayList4;
                            arrayList2.add(liveStreamCategoryIdDBModel3);
                            if (!rawQuery3.moveToNext()) {
                                break;
                            }
                            arrayList4 = arrayList2;
                        }
                    } else {
                        arrayList2 = arrayList4;
                    }
                    rawQuery3.close();
                    return arrayList2;
                } catch (SQLiteDatabaseLockedException unused9) {
                    return null;
                } catch (Exception unused10) {
                    return null;
                }
            } catch (SQLiteDatabaseLockedException unused11) {
                return null;
            } catch (Exception unused12) {
                return null;
            }
        }
        ArrayList arrayList5 = arrayList3;
        try {
            try {
                Cursor rawQuery4 = getReadableDatabase().rawQuery("SELECT series_category_v2.* , COUNT(series_streams_v2.id_series_stream_v2) AS TOTAL_COUNT FROM series_category_v2,series_streams_v2 WHERE series_category_v2.category_id_series_v2 = series_streams_v2.category_id_series_stream_v2 AND series_category_v2.user_id_referred = '" + userID + "' AND series_streams_v2.user_id_referred = '" + userID + "' AND series_streams_v2.category_id_series_stream_v2 NOT IN (SELECT iptv_password_status_table.password_status_cat_id FROM iptv_password_status_table WHERE iptv_password_status_table.user_id_referred ='" + userID + "' AND iptv_password_status_table.password_status ='1') GROUP BY series_streams_v2.category_id_series_stream_v2 ORDER BY series_category_v2.id_series_v2", (String[]) null);
                if (rawQuery4.moveToFirst()) {
                    while (true) {
                        LiveStreamCategoryIdDBModel liveStreamCategoryIdDBModel4 = new LiveStreamCategoryIdDBModel();
                        liveStreamCategoryIdDBModel4.setId(Integer.parseInt(rawQuery4.getString(0)));
                        liveStreamCategoryIdDBModel4.setLiveStreamCategoryName(rawQuery4.getString(1));
                        liveStreamCategoryIdDBModel4.setLiveStreamCategoryID(rawQuery4.getString(2));
                        liveStreamCategoryIdDBModel4.setLiveStreamCounter(w.r0(rawQuery4.getString(4)));
                        arrayList = arrayList5;
                        arrayList.add(liveStreamCategoryIdDBModel4);
                        if (!rawQuery4.moveToNext()) {
                            break;
                        }
                        arrayList5 = arrayList;
                    }
                } else {
                    arrayList = arrayList5;
                }
                rawQuery4.close();
                return arrayList;
            } catch (Exception unused13) {
                return null;
            } catch (SQLiteDatabaseLockedException unused14) {
                return null;
            }
        } catch (SQLiteDatabaseLockedException unused15) {
            return null;
        } catch (Exception unused16) {
            return null;
        }
    }

    public ArrayList getAllSeriesIDs() {
        StringBuilder sb;
        String str;
        int i;
        int userID = SharepreferenceDBHandler.getUserID(this.context);
        ArrayList arrayList = new ArrayList();
        if (SharepreferenceDBHandler.getCurrentAPPType(this.context).equals("onestream_api")) {
            sb = new StringBuilder();
            str = "SELECT stream_id_series_stream_v2 FROM onestream_series_streams_v2 WHERE onestream_series_streams_v2.user_id_referred='";
        } else {
            sb = new StringBuilder();
            str = "SELECT stream_id_series_stream_v2 FROM series_streams_v2 WHERE series_streams_v2.user_id_referred='";
        }
        sb.append(str);
        sb.append(userID);
        sb.append("'");
        try {
            Cursor rawQuery = getReadableDatabase().rawQuery(sb.toString(), (String[]) null);
            if (rawQuery.moveToFirst()) {
                do {
                    try {
                        i = Integer.parseInt(rawQuery.getString(0));
                    } catch (NumberFormatException unused) {
                        i = 0;
                    }
                    String string = rawQuery.getString(0);
                    SeriesDBModel seriesDBModel = new SeriesDBModel();
                    seriesDBModel.setseriesID(i);
                    seriesDBModel.setOneStreamseriesID(string);
                    arrayList.add(seriesDBModel);
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
            return arrayList;
        } catch (SQLiteDatabaseLockedException | Exception unused2) {
            return null;
        }
    }

    public int getAllSeriesStreamCount() {
        StringBuilder sb;
        String str;
        int userID = SharepreferenceDBHandler.getUserID(this.context);
        String currentAPPType = SharepreferenceDBHandler.getCurrentAPPType(this.context);
        if (currentAPPType.equals("m3u")) {
            sb = new StringBuilder();
            str = "SELECT  COUNT(*) FROM iptv_live_streams_m3u WHERE stream_type='series' AND user_id_referred='";
        } else if (currentAPPType.equals("onestream_api")) {
            sb = new StringBuilder();
            str = "SELECT  COUNT(*) FROM onestream_series_streams_v2 WHERE user_id_referred = '";
        } else {
            sb = new StringBuilder();
            str = "SELECT  COUNT(*) FROM series_streams_v2 WHERE user_id_referred = '";
        }
        sb.append(str);
        sb.append(userID);
        sb.append("'");
        try {
            Cursor rawQuery = getReadableDatabase().rawQuery(sb.toString(), (String[]) null);
            rawQuery.moveToFirst();
            int i = rawQuery.getInt(0);
            rawQuery.close();
            return i;
        } catch (SQLiteDatabaseLockedException | Exception unused) {
            return 0;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:104:0x0c6a, code lost:
    
        android.util.Log.e("honey", "stopped");
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0749, code lost:
    
        android.util.Log.e("honey", "stopped");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.ArrayList getAllSeriesStreamsWithCategoryId(java.lang.String r36) {
        /*
            Method dump skipped, instructions count: 3428
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler.getAllSeriesStreamsWithCategoryId(java.lang.String):java.util.ArrayList");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x00ac. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:5:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0325  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.ArrayList getAllSeriesStreamsWithCategoryIdM3U(java.lang.String r41) {
        /*
            Method dump skipped, instructions count: 1794
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler.getAllSeriesStreamsWithCategoryIdM3U(java.lang.String):java.util.ArrayList");
    }

    public ArrayList getAllliveCategories() {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        int i;
        ArrayList arrayList4;
        int i2;
        ArrayList arrayList5 = new ArrayList();
        int userID = SharepreferenceDBHandler.getUserID(this.context);
        String currentAPPType = SharepreferenceDBHandler.getCurrentAPPType(this.context);
        ArrayList arrayList6 = arrayList5;
        if (currentAPPType.equals("m3u")) {
            try {
                try {
                    Cursor rawQuery = getReadableDatabase().rawQuery("SELECT iptv_live_category_m3u.* , COUNT(iptv_live_streams_m3u.id) AS TOTAL_COUNT FROM iptv_live_category_m3u,iptv_live_streams_m3u WHERE iptv_live_category_m3u.categoryID = iptv_live_streams_m3u.categoryID AND iptv_live_category_m3u.user_id_referred = '" + userID + "' AND iptv_live_streams_m3u.user_id_referred = '" + userID + "' AND iptv_live_streams_m3u.stream_type = 'live' AND iptv_live_streams_m3u.categoryID NOT IN (SELECT iptv_password_status_table_m3u.password_status_cat_id FROM iptv_password_status_table_m3u WHERE iptv_password_status_table_m3u.user_id_referred ='" + userID + "' AND iptv_password_status_table_m3u.password_status ='1') GROUP BY iptv_live_streams_m3u.categoryID ORDER BY iptv_live_category_m3u.id", (String[]) null);
                    if (rawQuery.moveToFirst()) {
                        while (true) {
                            LiveStreamCategoryIdDBModel liveStreamCategoryIdDBModel = new LiveStreamCategoryIdDBModel();
                            liveStreamCategoryIdDBModel.setId(Integer.parseInt(rawQuery.getString(0)));
                            liveStreamCategoryIdDBModel.setLiveStreamCategoryID(rawQuery.getString(1));
                            liveStreamCategoryIdDBModel.setLiveStreamCategoryName(rawQuery.getString(2));
                            liveStreamCategoryIdDBModel.setLiveStreamCounter(w.r0(rawQuery.getString(4)));
                            arrayList = arrayList6;
                            arrayList.add(liveStreamCategoryIdDBModel);
                            if (!rawQuery.moveToNext()) {
                                break;
                            }
                            arrayList6 = arrayList;
                        }
                    } else {
                        arrayList = arrayList6;
                    }
                    rawQuery.close();
                    return arrayList;
                } catch (Exception unused) {
                    return null;
                } catch (SQLiteDatabaseLockedException unused2) {
                    return null;
                }
            } catch (SQLiteDatabaseLockedException unused3) {
                return null;
            } catch (Exception unused4) {
                return null;
            }
        }
        ArrayList arrayList7 = arrayList6;
        if (currentAPPType.equals("stalker_api")) {
            try {
                try {
                    Cursor rawQuery2 = getReadableDatabase().rawQuery("SELECT iptv_stalker_live_category.* , COUNT(iptv_stalker_live_streams.id) AS TOTAL_COUNT FROM iptv_stalker_live_category,iptv_stalker_live_streams WHERE iptv_stalker_live_category.categoryID_live = iptv_stalker_live_streams.categoryID AND iptv_stalker_live_category.user_id_referred = '" + userID + "' AND iptv_stalker_live_streams.user_id_referred = '" + userID + "' AND iptv_stalker_live_streams.categoryID NOT IN (SELECT iptv_password_status_table.password_status_cat_id FROM iptv_password_status_table WHERE iptv_password_status_table.user_id_referred ='" + userID + "' AND iptv_password_status_table.password_status ='1') GROUP BY iptv_stalker_live_streams.categoryID ORDER BY iptv_stalker_live_category.id_live", (String[]) null);
                    if (rawQuery2.moveToFirst()) {
                        while (true) {
                            LiveStreamCategoryIdDBModel liveStreamCategoryIdDBModel2 = new LiveStreamCategoryIdDBModel();
                            liveStreamCategoryIdDBModel2.setId(Integer.parseInt(rawQuery2.getString(0)));
                            liveStreamCategoryIdDBModel2.setLiveStreamCategoryID(rawQuery2.getString(1));
                            liveStreamCategoryIdDBModel2.setLiveStreamCategoryName(rawQuery2.getString(2));
                            liveStreamCategoryIdDBModel2.setAlias(rawQuery2.getString(3));
                            liveStreamCategoryIdDBModel2.setCensored(rawQuery2.getString(4));
                            liveStreamCategoryIdDBModel2.setLiveStreamCounter(w.r0(rawQuery2.getString(6)));
                            arrayList2 = arrayList7;
                            arrayList2.add(liveStreamCategoryIdDBModel2);
                            if (!rawQuery2.moveToNext()) {
                                break;
                            }
                            arrayList7 = arrayList2;
                        }
                    } else {
                        arrayList2 = arrayList7;
                    }
                    rawQuery2.close();
                    return arrayList2;
                } catch (Exception unused5) {
                    return null;
                } catch (SQLiteDatabaseLockedException unused6) {
                    return null;
                }
            } catch (SQLiteDatabaseLockedException unused7) {
                return null;
            } catch (Exception unused8) {
                return null;
            }
        }
        if (currentAPPType.equals("onestream_api")) {
            try {
                try {
                    Cursor rawQuery3 = getReadableDatabase().rawQuery("SELECT iptv_onestream_live_category.* , COUNT(onestream_iptv_live_streams.id) AS TOTAL_COUNT FROM iptv_onestream_live_category,onestream_iptv_live_streams WHERE iptv_onestream_live_category.categoryID_live = onestream_iptv_live_streams.categoryID AND iptv_onestream_live_category.user_id_referred = '" + userID + "' AND onestream_iptv_live_streams.user_id_referred = '" + userID + "' AND onestream_iptv_live_streams.categoryID NOT IN (SELECT iptv_password_status_table.password_status_cat_id FROM iptv_password_status_table WHERE iptv_password_status_table.user_id_referred ='" + userID + "' AND iptv_password_status_table.password_status ='1') GROUP BY onestream_iptv_live_streams.categoryID ORDER BY iptv_onestream_live_category.id_live", (String[]) null);
                    if (rawQuery3.moveToFirst()) {
                        while (true) {
                            try {
                                i = Integer.parseInt(rawQuery3.getString(3));
                            } catch (NumberFormatException unused9) {
                                i = 0;
                            }
                            LiveStreamCategoryIdDBModel liveStreamCategoryIdDBModel3 = new LiveStreamCategoryIdDBModel();
                            liveStreamCategoryIdDBModel3.setId(Integer.parseInt(rawQuery3.getString(0)));
                            liveStreamCategoryIdDBModel3.setLiveStreamCategoryID(rawQuery3.getString(1));
                            liveStreamCategoryIdDBModel3.setLiveStreamCategoryName(rawQuery3.getString(2));
                            liveStreamCategoryIdDBModel3.setParentId(i);
                            liveStreamCategoryIdDBModel3.setLiveStreamCounter(w.r0(rawQuery3.getString(5)));
                            arrayList3 = arrayList7;
                            arrayList3.add(liveStreamCategoryIdDBModel3);
                            if (!rawQuery3.moveToNext()) {
                                break;
                            }
                            arrayList7 = arrayList3;
                        }
                    } else {
                        arrayList3 = arrayList7;
                    }
                    rawQuery3.close();
                    return arrayList3;
                } catch (SQLiteDatabaseLockedException unused10) {
                    return null;
                } catch (Exception unused11) {
                    return null;
                }
            } catch (SQLiteDatabaseLockedException unused12) {
                return null;
            } catch (Exception unused13) {
                return null;
            }
        }
        try {
            try {
                Cursor rawQuery4 = getReadableDatabase().rawQuery("SELECT iptv_live_category.* , COUNT(iptv_live_streams.id) AS TOTAL_COUNT FROM iptv_live_category,iptv_live_streams WHERE iptv_live_category.categoryID_live = iptv_live_streams.categoryID AND iptv_live_category.user_id_referred = '" + userID + "' AND iptv_live_streams.user_id_referred = '" + userID + "' AND ( iptv_live_streams.stream_type = 'live' OR iptv_live_streams.stream_type = 'created_live' ) AND iptv_live_streams.categoryID NOT IN (SELECT iptv_password_status_table.password_status_cat_id FROM iptv_password_status_table WHERE iptv_password_status_table.user_id_referred ='" + userID + "' AND iptv_password_status_table.password_status ='1') GROUP BY iptv_live_streams.categoryID ORDER BY iptv_live_category.id_live", (String[]) null);
                if (rawQuery4.moveToFirst()) {
                    while (true) {
                        try {
                            i2 = Integer.parseInt(rawQuery4.getString(3));
                        } catch (NumberFormatException unused14) {
                            i2 = 0;
                        }
                        LiveStreamCategoryIdDBModel liveStreamCategoryIdDBModel4 = new LiveStreamCategoryIdDBModel();
                        liveStreamCategoryIdDBModel4.setId(Integer.parseInt(rawQuery4.getString(0)));
                        liveStreamCategoryIdDBModel4.setLiveStreamCategoryID(rawQuery4.getString(1));
                        liveStreamCategoryIdDBModel4.setLiveStreamCategoryName(rawQuery4.getString(2));
                        liveStreamCategoryIdDBModel4.setParentId(i2);
                        liveStreamCategoryIdDBModel4.setLiveStreamCounter(w.r0(rawQuery4.getString(5)));
                        arrayList4 = arrayList7;
                        arrayList4.add(liveStreamCategoryIdDBModel4);
                        if (!rawQuery4.moveToNext()) {
                            break;
                        }
                        arrayList7 = arrayList4;
                    }
                } else {
                    arrayList4 = arrayList7;
                }
                rawQuery4.close();
                return arrayList4;
            } catch (SQLiteDatabaseLockedException unused15) {
                return null;
            } catch (Exception unused16) {
                return null;
            }
        } catch (Exception unused17) {
            return null;
        } catch (SQLiteDatabaseLockedException unused18) {
            return null;
        }
    }

    public ArrayList getAllliveCategoriesForParental(String str) {
        StringBuilder sb;
        String str2;
        String sb2;
        int i;
        ArrayList arrayList = new ArrayList();
        int userID = SharepreferenceDBHandler.getUserID(this.context);
        String currentAPPType = SharepreferenceDBHandler.getCurrentAPPType(this.context);
        System.currentTimeMillis();
        if (currentAPPType.equals("m3u")) {
            sb2 = "SELECT * FROM iptv_live_category_m3u WHERE user_id_referred='" + userID + "' AND categoryID IS NOT NULL";
        } else {
            if (currentAPPType.equals("onestream_api")) {
                sb = new StringBuilder();
                sb.append("SELECT iptv_onestream_live_category.* , COUNT(onestream_iptv_live_streams.id) AS TOTAL_COUNT FROM iptv_onestream_live_category,onestream_iptv_live_streams WHERE iptv_onestream_live_category.categoryID_live = onestream_iptv_live_streams.categoryID AND iptv_onestream_live_category.user_id_referred = '");
                sb.append(userID);
                sb.append("' AND ");
                sb.append("onestream_iptv_live_streams");
                sb.append(".");
                sb.append("stream_type");
                sb.append(" LIKE '%");
                sb.append(str);
                sb.append("%'  GROUP BY ");
                sb.append("onestream_iptv_live_streams");
                sb.append(".");
                sb.append("categoryID");
                sb.append(" ORDER BY ");
                str2 = "iptv_onestream_live_category";
            } else {
                sb = new StringBuilder();
                sb.append("SELECT iptv_live_category.* , COUNT(iptv_live_streams.id) AS TOTAL_COUNT FROM iptv_live_category,iptv_live_streams WHERE iptv_live_category.categoryID_live = iptv_live_streams.categoryID AND iptv_live_category.user_id_referred = '");
                sb.append(userID);
                sb.append("' AND ");
                sb.append("iptv_live_streams");
                sb.append(".");
                sb.append("stream_type");
                sb.append(" LIKE '%");
                sb.append(str);
                sb.append("%'  GROUP BY ");
                sb.append("iptv_live_streams");
                sb.append(".");
                sb.append("categoryID");
                sb.append(" ORDER BY ");
                str2 = "iptv_live_category";
            }
            sb.append(str2);
            sb.append(".");
            sb.append("id_live");
            sb2 = sb.toString();
        }
        try {
            Cursor rawQuery = getReadableDatabase().rawQuery(sb2, (String[]) null);
            if (rawQuery.moveToFirst()) {
                System.currentTimeMillis();
                do {
                    try {
                        i = Integer.parseInt(rawQuery.getString(3));
                    } catch (NumberFormatException unused) {
                        i = 0;
                    }
                    LiveStreamCategoryIdDBModel liveStreamCategoryIdDBModel = new LiveStreamCategoryIdDBModel();
                    liveStreamCategoryIdDBModel.setId(Integer.parseInt(rawQuery.getString(0)));
                    liveStreamCategoryIdDBModel.setLiveStreamCategoryID(rawQuery.getString(1));
                    liveStreamCategoryIdDBModel.setLiveStreamCategoryName(rawQuery.getString(2));
                    liveStreamCategoryIdDBModel.setParentId(i);
                    arrayList.add(liveStreamCategoryIdDBModel);
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
            return arrayList;
        } catch (SQLiteDatabaseLockedException | Exception unused2) {
            return null;
        }
    }

    public ArrayList getAllliveRadioCategories() {
        StringBuilder sb;
        String str;
        ArrayList arrayList;
        int i;
        ArrayList arrayList2 = new ArrayList();
        int userID = SharepreferenceDBHandler.getUserID(this.context);
        String currentAPPType = SharepreferenceDBHandler.getCurrentAPPType(this.context);
        System.currentTimeMillis();
        ArrayList arrayList3 = arrayList2;
        if (currentAPPType.equals("onestream_api")) {
            sb = new StringBuilder();
            sb.append("SELECT iptv_onestream_live_category.* , COUNT(onestream_iptv_live_streams.id) AS TOTAL_COUNT FROM iptv_onestream_live_category,onestream_iptv_live_streams WHERE iptv_onestream_live_category.categoryID_live = onestream_iptv_live_streams.categoryID AND iptv_onestream_live_category.user_id_referred = '");
            sb.append(userID);
            sb.append("' AND ");
            sb.append("onestream_iptv_live_streams");
            sb.append(".");
            sb.append("user_id_referred");
            sb.append(" = '");
            sb.append(userID);
            sb.append("' AND ");
            sb.append("onestream_iptv_live_streams");
            sb.append(".");
            sb.append("stream_type");
            sb.append(" = 'radio_streams' AND ");
            sb.append("onestream_iptv_live_streams");
            sb.append(".");
            sb.append("categoryID");
            sb.append(" NOT IN (SELECT ");
            sb.append("iptv_password_status_table");
            sb.append(".");
            sb.append("password_status_cat_id");
            sb.append(" FROM ");
            sb.append("iptv_password_status_table");
            sb.append(" WHERE ");
            sb.append("iptv_password_status_table");
            sb.append(".");
            sb.append("user_id_referred");
            sb.append(" ='");
            sb.append(userID);
            sb.append("' AND ");
            sb.append("iptv_password_status_table");
            sb.append(".");
            sb.append("password_status");
            sb.append(" ='1') GROUP BY ");
            sb.append("onestream_iptv_live_streams");
            sb.append(".");
            sb.append("categoryID");
            sb.append(" ORDER BY ");
            str = "iptv_onestream_live_category";
        } else {
            sb = new StringBuilder();
            sb.append("SELECT iptv_live_category.* , COUNT(iptv_live_streams.id) AS TOTAL_COUNT FROM iptv_live_category,iptv_live_streams WHERE iptv_live_category.categoryID_live = iptv_live_streams.categoryID AND iptv_live_category.user_id_referred = '");
            sb.append(userID);
            sb.append("' AND ");
            sb.append("iptv_live_streams");
            sb.append(".");
            sb.append("user_id_referred");
            sb.append(" = '");
            sb.append(userID);
            sb.append("' AND ");
            sb.append("iptv_live_streams");
            sb.append(".");
            sb.append("stream_type");
            sb.append(" = 'radio_streams' AND ");
            sb.append("iptv_live_streams");
            sb.append(".");
            sb.append("categoryID");
            sb.append(" NOT IN (SELECT ");
            sb.append("iptv_password_status_table");
            sb.append(".");
            sb.append("password_status_cat_id");
            sb.append(" FROM ");
            sb.append("iptv_password_status_table");
            sb.append(" WHERE ");
            sb.append("iptv_password_status_table");
            sb.append(".");
            sb.append("user_id_referred");
            sb.append(" ='");
            sb.append(userID);
            sb.append("' AND ");
            sb.append("iptv_password_status_table");
            sb.append(".");
            sb.append("password_status");
            sb.append(" ='1') GROUP BY ");
            sb.append("iptv_live_streams");
            sb.append(".");
            sb.append("categoryID");
            sb.append(" ORDER BY ");
            str = "iptv_live_category";
        }
        sb.append(str);
        sb.append(".");
        sb.append("id_live");
        try {
            Cursor rawQuery = getReadableDatabase().rawQuery(sb.toString(), (String[]) null);
            if (rawQuery.moveToFirst()) {
                System.currentTimeMillis();
                while (true) {
                    try {
                        i = Integer.parseInt(rawQuery.getString(3));
                    } catch (NumberFormatException unused) {
                        i = 0;
                    }
                    LiveStreamCategoryIdDBModel liveStreamCategoryIdDBModel = new LiveStreamCategoryIdDBModel();
                    liveStreamCategoryIdDBModel.setId(Integer.parseInt(rawQuery.getString(0)));
                    liveStreamCategoryIdDBModel.setLiveStreamCategoryID(rawQuery.getString(1));
                    liveStreamCategoryIdDBModel.setLiveStreamCategoryName(rawQuery.getString(2));
                    liveStreamCategoryIdDBModel.setParentId(i);
                    liveStreamCategoryIdDBModel.setLiveStreamCounter(w.r0(rawQuery.getString(5)));
                    arrayList = arrayList3;
                    arrayList.add(liveStreamCategoryIdDBModel);
                    if (!rawQuery.moveToNext()) {
                        break;
                    }
                    arrayList3 = arrayList;
                }
            } else {
                arrayList = arrayList3;
            }
            rawQuery.close();
            return arrayList;
        } catch (SQLiteDatabaseLockedException | Exception unused2) {
            return null;
        }
    }

    public ArrayList getAllm3uCategories() {
        ArrayList arrayList = new ArrayList();
        int userID = SharepreferenceDBHandler.getUserID(this.context);
        new ArrayList();
        try {
            Cursor rawQuery = getReadableDatabase().rawQuery("SELECT * FROM iptv_m3u_all_category WHERE user_id_referred='" + userID + "'", (String[]) null);
            if (rawQuery.moveToFirst()) {
                do {
                    LiveStreamCategoryIdDBModel liveStreamCategoryIdDBModel = new LiveStreamCategoryIdDBModel();
                    liveStreamCategoryIdDBModel.setId(Integer.parseInt(rawQuery.getString(0)));
                    liveStreamCategoryIdDBModel.setLiveStreamCategoryID(rawQuery.getString(1));
                    liveStreamCategoryIdDBModel.setLiveStreamCategoryName(rawQuery.getString(2));
                    liveStreamCategoryIdDBModel.setParentId(Integer.parseInt(rawQuery.getString(3)));
                    arrayList.add(liveStreamCategoryIdDBModel);
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
            return arrayList;
        } catch (SQLiteDatabaseLockedException | Exception unused) {
            return null;
        }
    }

    public ArrayList getAllm3uCategoriesWithType(String str) {
        int userID = SharepreferenceDBHandler.getUserID(this.context);
        ArrayList arrayList = new ArrayList();
        try {
            Cursor rawQuery = getReadableDatabase().rawQuery("SELECT  iptv_m3u_all_category.* FROM iptv_m3u_all_category,iptv_live_streams_m3u WHERE iptv_live_streams_m3u.user_id_referred = " + userID + " AND iptv_live_streams_m3u.stream_type = '" + str + "' AND iptv_live_streams_m3u.categoryID=iptv_m3u_all_category.categoryID GROUP BY iptv_m3u_all_category.categoryID", (String[]) null);
            if (rawQuery.moveToFirst()) {
                do {
                    M3UCategoriesModel m3UCategoriesModel = new M3UCategoriesModel();
                    m3UCategoriesModel.setCategoryId(rawQuery.getString(1));
                    m3UCategoriesModel.setCategoryName(rawQuery.getString(2));
                    arrayList.add(m3UCategoriesModel);
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
            return arrayList;
        } catch (SQLiteDatabaseLockedException | Exception unused) {
            return null;
        }
    }

    public int getAvailableCountM3U(String str, String str2) {
        String str3;
        int userID = SharepreferenceDBHandler.getUserID(this.context);
        if (str.equals("0")) {
            str3 = "SELECT  COUNT(*) FROM iptv_live_streams_m3u WHERE user_id_referred='" + userID + "' AND stream_type='" + str2 + "'";
        } else if (str.equals("-1")) {
            str3 = "";
        } else {
            str3 = "SELECT  COUNT(*) FROM iptv_live_streams_m3u WHERE categoryID='" + str + "' AND user_id_referred='" + userID + "' AND stream_type='" + str2 + "'";
        }
        try {
            Cursor rawQuery = getReadableDatabase().rawQuery(str3, (String[]) null);
            rawQuery.moveToFirst();
            int i = rawQuery.getInt(0);
            rawQuery.close();
            return i;
        } catch (SQLiteDatabaseLockedException | Exception unused) {
            return 0;
        }
    }

    public M3UCategoriesModel getCatByCatIDALLM3U(String str) {
        String str2 = "SELECT  * FROM iptv_m3u_all_category WHERE categoryID='" + str + "' AND user_id_referred='" + SharepreferenceDBHandler.getUserID(this.context) + "'";
        M3UCategoriesModel m3UCategoriesModel = new M3UCategoriesModel();
        try {
            Cursor rawQuery = getReadableDatabase().rawQuery(str2, (String[]) null);
            if (rawQuery.moveToFirst()) {
                do {
                    m3UCategoriesModel.setCategoryId(rawQuery.getString(1));
                    m3UCategoriesModel.setCategoryName(rawQuery.getString(2));
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
            return m3UCategoriesModel;
        } catch (SQLiteDatabaseLockedException | Exception unused) {
            return null;
        }
    }

    public LiveStreamCategoryIdDBModel getChannelCatNameFromSelectedCatId(String str) {
        StringBuilder sb;
        String str2;
        StringBuilder sb2;
        int userID = SharepreferenceDBHandler.getUserID(this.context);
        if (SharepreferenceDBHandler.getCurrentAPPType(this.context).equals("m3u")) {
            sb = new StringBuilder();
            sb.append("SELECT  * FROM iptv_live_category_m3u WHERE user_id_referred='");
            sb.append(userID);
            sb.append("' AND ");
            sb.append("categoryID");
        } else {
            if (SharepreferenceDBHandler.getCurrentAPPType(this.context).equals("onestream_api")) {
                sb = new StringBuilder();
                str2 = "SELECT  * FROM iptv_onestream_live_category WHERE user_id_referred='";
            } else {
                sb = new StringBuilder();
                str2 = "SELECT  * FROM iptv_live_category WHERE user_id_referred='";
            }
            sb.append(str2);
            sb.append(userID);
            sb.append("' AND ");
            sb.append("categoryID_live");
        }
        sb.append("='");
        sb.append(str);
        sb.append("'");
        try {
            Cursor rawQuery = getReadableDatabase().rawQuery(sb.toString(), (String[]) null);
            if (!rawQuery.moveToFirst()) {
                rawQuery.close();
                return null;
            }
            if (SharepreferenceDBHandler.getCurrentAPPType(this.context).equals("m3u")) {
                LiveStreamCategoryIdDBModel liveStreamCategoryIdDBModel = new LiveStreamCategoryIdDBModel();
                liveStreamCategoryIdDBModel.setId(Integer.parseInt(rawQuery.getString(0)));
                liveStreamCategoryIdDBModel.setLiveStreamCategoryID(rawQuery.getString(1));
                liveStreamCategoryIdDBModel.setLiveStreamCategoryName(rawQuery.getString(2));
                return liveStreamCategoryIdDBModel;
            }
            LiveStreamCategoryIdDBModel liveStreamCategoryIdDBModel2 = new LiveStreamCategoryIdDBModel();
            liveStreamCategoryIdDBModel2.setId(Integer.parseInt(rawQuery.getString(0)));
            liveStreamCategoryIdDBModel2.setLiveStreamCategoryID(rawQuery.getString(1));
            liveStreamCategoryIdDBModel2.setLiveStreamCategoryName(rawQuery.getString(2));
            liveStreamCategoryIdDBModel2.setLiveStreamCounter(w.r0(rawQuery.getString(4)));
            return liveStreamCategoryIdDBModel2;
        } catch (SQLiteDatabaseLockedException e) {
            e = e;
            sb2 = new StringBuilder();
            sb2.append("msg");
            sb2.append(e);
            Log.e("msg", sb2.toString());
            return null;
        } catch (Exception e2) {
            e = e2;
            sb2 = new StringBuilder();
            sb2.append("msg");
            sb2.append(e);
            Log.e("msg", sb2.toString());
            return null;
        }
    }

    public LiveStreamCategoryIdDBModel getChannelCatNameFromSelectedCatIdForM3U(String str) {
        StringBuilder sb;
        try {
            Cursor rawQuery = getReadableDatabase().rawQuery("SELECT  * FROM iptv_live_category_m3u WHERE user_id_referred='" + SharepreferenceDBHandler.getUserID(this.context) + "' AND categoryID_live='" + str + "'", (String[]) null);
            if (!rawQuery.moveToFirst()) {
                rawQuery.close();
                return null;
            }
            LiveStreamCategoryIdDBModel liveStreamCategoryIdDBModel = new LiveStreamCategoryIdDBModel();
            liveStreamCategoryIdDBModel.setId(Integer.parseInt(rawQuery.getString(0)));
            liveStreamCategoryIdDBModel.setLiveStreamCategoryID(rawQuery.getString(1));
            liveStreamCategoryIdDBModel.setLiveStreamCategoryName(rawQuery.getString(2));
            liveStreamCategoryIdDBModel.setLiveStreamCounter(w.r0(rawQuery.getString(4)));
            return liveStreamCategoryIdDBModel;
        } catch (Exception e) {
            e = e;
            sb = new StringBuilder();
            sb.append("msg");
            sb.append(e);
            Log.e("msg", sb.toString());
            return null;
        } catch (SQLiteDatabaseLockedException e2) {
            e = e2;
            sb = new StringBuilder();
            sb.append("msg");
            sb.append(e);
            Log.e("msg", sb.toString());
            return null;
        }
    }

    public ArrayList getChannelDetails(String str, String str2) {
        if (str != null) {
            ArrayList arrayList = new ArrayList();
            int userID = SharepreferenceDBHandler.getUserID(this.context);
            String currentAPPType = SharepreferenceDBHandler.getCurrentAPPType(this.context);
            if (currentAPPType.equals("m3u")) {
                try {
                    Cursor rawQuery = getReadableDatabase().rawQuery("SELECT  * FROM iptv_live_streams_m3u WHERE stream_type LIKE '%live%' AND num='" + str + "' AND user_id_referred='" + userID + "' LIMIT 1", (String[]) null);
                    if (rawQuery.moveToFirst()) {
                        do {
                            LiveStreamsDBModel liveStreamsDBModel = new LiveStreamsDBModel();
                            liveStreamsDBModel.setIdAuto(Integer.parseInt(rawQuery.getString(0)));
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
                            liveStreamsDBModel.setUrl(rawQuery.getString(18));
                            arrayList.add(liveStreamsDBModel);
                        } while (rawQuery.moveToNext());
                    }
                    rawQuery.close();
                    return arrayList;
                } catch (SQLiteDatabaseLockedException | Exception unused) {
                    return null;
                }
            }
            if (currentAPPType.equals("onestream_api")) {
                try {
                    Cursor rawQuery2 = getReadableDatabase().rawQuery("SELECT  * FROM onestream_iptv_live_streams WHERE stream_type LIKE '%" + str2 + "%' AND num='" + str + "' AND user_id_referred='" + userID + "' LIMIT 1", (String[]) null);
                    if (rawQuery2.moveToFirst()) {
                        do {
                            LiveStreamsDBModel liveStreamsDBModel2 = new LiveStreamsDBModel();
                            liveStreamsDBModel2.setIdAuto(Integer.parseInt(rawQuery2.getString(0)));
                            liveStreamsDBModel2.setNum(rawQuery2.getString(1));
                            liveStreamsDBModel2.setName(rawQuery2.getString(2));
                            liveStreamsDBModel2.setStreamType(rawQuery2.getString(3));
                            liveStreamsDBModel2.setStreamId(rawQuery2.getString(4));
                            liveStreamsDBModel2.setStreamIdOneStream(rawQuery2.getString(4));
                            liveStreamsDBModel2.setStreamIcon(rawQuery2.getString(5));
                            liveStreamsDBModel2.setEpgChannelId(rawQuery2.getString(6));
                            liveStreamsDBModel2.setAdded(rawQuery2.getString(7));
                            liveStreamsDBModel2.setCategoryId(rawQuery2.getString(8));
                            liveStreamsDBModel2.setCustomSid(rawQuery2.getString(9));
                            liveStreamsDBModel2.setTvArchive(rawQuery2.getString(10));
                            liveStreamsDBModel2.setDirectSource(rawQuery2.getString(11));
                            liveStreamsDBModel2.setTvArchiveDuration(rawQuery2.getString(12));
                            liveStreamsDBModel2.setTypeName(rawQuery2.getString(13));
                            liveStreamsDBModel2.setCategoryName(rawQuery2.getString(14));
                            liveStreamsDBModel2.setSeriesNo(rawQuery2.getString(15));
                            liveStreamsDBModel2.setLive(rawQuery2.getString(16));
                            liveStreamsDBModel2.setContaiinerExtension(rawQuery2.getString(17));
                            liveStreamsDBModel2.setUrl(rawQuery2.getString(20));
                            arrayList.add(liveStreamsDBModel2);
                        } while (rawQuery2.moveToNext());
                    }
                    rawQuery2.close();
                    return arrayList;
                } catch (SQLiteDatabaseLockedException | Exception unused2) {
                    return null;
                }
            }
            try {
                Cursor rawQuery3 = getReadableDatabase().rawQuery("SELECT  * FROM iptv_live_streams WHERE stream_type LIKE '%" + str2 + "%' AND num='" + str + "' AND user_id_referred='" + userID + "' LIMIT 1", (String[]) null);
                if (rawQuery3.moveToFirst()) {
                    do {
                        LiveStreamsDBModel liveStreamsDBModel3 = new LiveStreamsDBModel();
                        liveStreamsDBModel3.setIdAuto(Integer.parseInt(rawQuery3.getString(0)));
                        liveStreamsDBModel3.setNum(rawQuery3.getString(1));
                        liveStreamsDBModel3.setName(rawQuery3.getString(2));
                        liveStreamsDBModel3.setStreamType(rawQuery3.getString(3));
                        liveStreamsDBModel3.setStreamId(rawQuery3.getString(4));
                        liveStreamsDBModel3.setStreamIdOneStream(rawQuery3.getString(4));
                        liveStreamsDBModel3.setStreamIcon(rawQuery3.getString(5));
                        liveStreamsDBModel3.setEpgChannelId(rawQuery3.getString(6));
                        liveStreamsDBModel3.setAdded(rawQuery3.getString(7));
                        liveStreamsDBModel3.setCategoryId(rawQuery3.getString(8));
                        liveStreamsDBModel3.setCustomSid(rawQuery3.getString(9));
                        liveStreamsDBModel3.setTvArchive(rawQuery3.getString(10));
                        liveStreamsDBModel3.setDirectSource(rawQuery3.getString(11));
                        liveStreamsDBModel3.setTvArchiveDuration(rawQuery3.getString(12));
                        liveStreamsDBModel3.setTypeName(rawQuery3.getString(13));
                        liveStreamsDBModel3.setCategoryName(rawQuery3.getString(14));
                        liveStreamsDBModel3.setSeriesNo(rawQuery3.getString(15));
                        liveStreamsDBModel3.setLive(rawQuery3.getString(16));
                        liveStreamsDBModel3.setContaiinerExtension(rawQuery3.getString(17));
                        liveStreamsDBModel3.setUrl(rawQuery3.getString(18));
                        arrayList.add(liveStreamsDBModel3);
                    } while (rawQuery3.moveToNext());
                }
                rawQuery3.close();
                return arrayList;
            } catch (SQLiteDatabaseLockedException | Exception unused3) {
            }
        }
        return null;
    }

    public int getCountMovedItems(String str, String str2) {
        String str3;
        int userID = SharepreferenceDBHandler.getUserID(this.context);
        if (str.equals("0")) {
            str3 = "SELECT  COUNT(*) FROM iptv_live_streams_m3u_all WHERE user_id_referred='" + userID + "' AND move_to='" + str2 + "'";
        } else {
            str3 = "SELECT  COUNT(*) FROM iptv_live_streams_m3u_all WHERE categoryID='" + str + "' AND user_id_referred='" + userID + "' AND move_to='" + str2 + "'";
        }
        try {
            Cursor rawQuery = getReadableDatabase().rawQuery(str3, (String[]) null);
            rawQuery.moveToFirst();
            int i = rawQuery.getInt(0);
            rawQuery.close();
            return i;
        } catch (SQLiteDatabaseLockedException | Exception unused) {
            return 0;
        }
    }

    public ArrayList getEPG(String str) {
        String str2;
        int userID = SharepreferenceDBHandler.getUserID(this.context);
        ArrayList arrayList = new ArrayList();
        String currentAPPType = SharepreferenceDBHandler.getCurrentAPPType(this.context);
        if (currentAPPType.equals("m3u")) {
            str2 = "epg_m3u";
        } else {
            currentAPPType.equals("onestream_api");
            str2 = "epg";
        }
        ArrayList activeEPGSource = getActiveEPGSource();
        try {
            Cursor rawQuery = getReadableDatabase().rawQuery("SELECT  * FROM " + str2 + " WHERE channel_id='" + str + "' AND user_id_referred='" + userID + "' AND source_ref_id='" + ((activeEPGSource == null || activeEPGSource.size() <= 0) ? "0" : String.valueOf(((EPGSourcesModel) activeEPGSource.get(0)).getIdAuto())) + "'", (String[]) null);
            if (rawQuery.moveToFirst()) {
                do {
                    XMLTVProgrammePojo xMLTVProgrammePojo = new XMLTVProgrammePojo();
                    xMLTVProgrammePojo.setTitle(rawQuery.getString(1));
                    xMLTVProgrammePojo.setStart(rawQuery.getString(2));
                    xMLTVProgrammePojo.setStop(rawQuery.getString(3));
                    xMLTVProgrammePojo.setDesc(rawQuery.getString(4));
                    xMLTVProgrammePojo.setChannel(rawQuery.getString(5));
                    xMLTVProgrammePojo.setSourceRef(rawQuery.getString(7));
                    arrayList.add(xMLTVProgrammePojo);
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
            return arrayList;
        } catch (SQLiteDatabaseLockedException | Exception unused) {
            return null;
        }
    }

    public int getEPGCount() {
        String str;
        StringBuilder sb;
        int userID = SharepreferenceDBHandler.getUserID(this.context);
        String currentAPPType = SharepreferenceDBHandler.getCurrentAPPType(this.context);
        ArrayList activeEPGSource = getActiveEPGSource();
        String valueOf = (activeEPGSource == null || activeEPGSource.size() <= 0) ? "0" : String.valueOf(((EPGSourcesModel) activeEPGSource.get(0)).getIdAuto());
        if (currentAPPType.equals("m3u")) {
            sb = new StringBuilder();
            str = "SELECT  * FROM epg_m3u WHERE user_id_referred='";
        } else {
            str = "SELECT  * FROM epg WHERE user_id_referred='";
            sb = currentAPPType.equals("onestream_api") ? new StringBuilder() : new StringBuilder();
        }
        sb.append(str);
        sb.append(userID);
        sb.append("' AND ");
        sb.append("source_ref_id");
        sb.append("='");
        sb.append(valueOf);
        sb.append("'");
        try {
            Cursor rawQuery = getReadableDatabase().rawQuery(sb.toString(), (String[]) null);
            int count = rawQuery.getCount();
            rawQuery.close();
            return count;
        } catch (SQLiteDatabaseLockedException | Exception unused) {
            return 0;
        }
    }

    public int getEPGCountWithSourceRef(String str) {
        String str2;
        StringBuilder sb;
        int userID = SharepreferenceDBHandler.getUserID(this.context);
        String currentAPPType = SharepreferenceDBHandler.getCurrentAPPType(this.context);
        if (currentAPPType.equals("m3u")) {
            sb = new StringBuilder();
            str2 = "SELECT  * FROM epg_m3u WHERE user_id_referred='";
        } else {
            str2 = "SELECT  * FROM epg WHERE user_id_referred='";
            sb = currentAPPType.equals("onestream_api") ? new StringBuilder() : new StringBuilder();
        }
        sb.append(str2);
        sb.append(userID);
        sb.append("' AND ");
        sb.append("source_ref_id");
        sb.append("='");
        sb.append(str);
        sb.append("'");
        try {
            Cursor rawQuery = getReadableDatabase().rawQuery(sb.toString(), (String[]) null);
            int count = rawQuery.getCount();
            rawQuery.close();
            return count;
        } catch (SQLiteDatabaseLockedException | Exception unused) {
            return 0;
        }
    }

    public ArrayList getEPGSearch(String str, String str2) {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        int userID = SharepreferenceDBHandler.getUserID(this.context);
        ArrayList arrayList4 = new ArrayList();
        String currentAPPType = SharepreferenceDBHandler.getCurrentAPPType(this.context);
        ArrayList activeEPGSource = getActiveEPGSource();
        String valueOf = (activeEPGSource == null || activeEPGSource.size() <= 0) ? "0" : String.valueOf(((EPGSourcesModel) activeEPGSource.get(0)).getIdAuto());
        ArrayList arrayList5 = arrayList4;
        if (currentAPPType.equals("m3u")) {
            try {
                try {
                    Cursor rawQuery = getReadableDatabase().rawQuery("SELECT DISTINCT title,start,stop,description,channel_id,num,name,stream_icon,categoryID,url FROM epg_m3u , iptv_live_streams_m3u WHERE epg_m3u.user_id_referred = '" + userID + "' AND iptv_live_streams_m3u.user_id_referred = '" + userID + "' AND epg_m3u.source_ref_id = '" + valueOf + "' AND epg_m3u.channel_id = iptv_live_streams_m3u.epg_channel_id AND epg_m3u.title LIKE '%" + str + "%' AND stop>='" + str2 + "' AND iptv_live_streams_m3u.categoryID NOT IN (SELECT iptv_password_status_table_m3u.password_status_cat_id FROM iptv_password_status_table_m3u WHERE iptv_password_status_table_m3u.user_id_referred ='" + userID + "' AND iptv_password_status_table_m3u.password_status ='1') ORDER BY epg_m3u.stop ASC", (String[]) null);
                    if (rawQuery.moveToFirst()) {
                        while (true) {
                            AsyncTask asyncTask = w.p;
                            if (asyncTask != null && asyncTask.isCancelled()) {
                                Log.e("honey", "stopped epg");
                                break;
                            }
                            XMLTVProgrammePojo xMLTVProgrammePojo = new XMLTVProgrammePojo();
                            xMLTVProgrammePojo.setTitle(rawQuery.getString(0));
                            xMLTVProgrammePojo.setStart(rawQuery.getString(1));
                            xMLTVProgrammePojo.setStop(rawQuery.getString(2));
                            xMLTVProgrammePojo.setDesc(rawQuery.getString(3));
                            xMLTVProgrammePojo.setChannel(rawQuery.getString(4));
                            xMLTVProgrammePojo.setLiveNum(rawQuery.getString(5));
                            xMLTVProgrammePojo.setLiveName(rawQuery.getString(6));
                            xMLTVProgrammePojo.setLiveStreamID("");
                            xMLTVProgrammePojo.setLiveLogo(rawQuery.getString(7));
                            xMLTVProgrammePojo.setLiveCategoryId(rawQuery.getString(8));
                            xMLTVProgrammePojo.setUrl(rawQuery.getString(9));
                            arrayList3 = arrayList5;
                            arrayList3.add(xMLTVProgrammePojo);
                            if (!rawQuery.moveToNext()) {
                                break;
                            }
                            arrayList5 = arrayList3;
                        }
                    } else {
                        arrayList3 = arrayList5;
                    }
                    rawQuery.close();
                    return arrayList3;
                } catch (SQLiteDatabaseLockedException unused) {
                    return null;
                } catch (Exception unused2) {
                    return null;
                }
            } catch (SQLiteDatabaseLockedException unused3) {
                return null;
            } catch (Exception unused4) {
                return null;
            }
        }
        if (currentAPPType.equals("onestream_api")) {
            try {
                try {
                    Cursor rawQuery2 = getReadableDatabase().rawQuery("SELECT DISTINCT title,start,stop,description,channel_id,num,name,stream_id,stream_icon,categoryID FROM epg , onestream_iptv_live_streams WHERE epg.user_id_referred = '" + userID + "' AND onestream_iptv_live_streams.user_id_referred = '" + userID + "' AND epg.source_ref_id = '" + valueOf + "' AND epg.channel_id = onestream_iptv_live_streams.epg_channel_id AND epg.title LIKE '%" + str + "%' AND stop>='" + str2 + "' AND onestream_iptv_live_streams.categoryID NOT IN (SELECT iptv_password_status_table.password_status_cat_id FROM iptv_password_status_table WHERE iptv_password_status_table.user_id_referred ='" + userID + "' AND iptv_password_status_table.password_status ='1') ORDER BY epg.stop ASC", (String[]) null);
                    if (rawQuery2.moveToFirst()) {
                        while (true) {
                            AsyncTask asyncTask2 = w.p;
                            if (asyncTask2 != null && asyncTask2.isCancelled()) {
                                Log.e("honey", "stopped epg");
                                break;
                            }
                            XMLTVProgrammePojo xMLTVProgrammePojo2 = new XMLTVProgrammePojo();
                            xMLTVProgrammePojo2.setTitle(rawQuery2.getString(0));
                            xMLTVProgrammePojo2.setStart(rawQuery2.getString(1));
                            xMLTVProgrammePojo2.setStop(rawQuery2.getString(2));
                            xMLTVProgrammePojo2.setDesc(rawQuery2.getString(3));
                            xMLTVProgrammePojo2.setChannel(rawQuery2.getString(4));
                            xMLTVProgrammePojo2.setLiveNum(rawQuery2.getString(5));
                            xMLTVProgrammePojo2.setLiveName(rawQuery2.getString(6));
                            xMLTVProgrammePojo2.setLiveStreamID(rawQuery2.getString(7));
                            xMLTVProgrammePojo2.setLiveLogo(rawQuery2.getString(8));
                            xMLTVProgrammePojo2.setLiveCategoryId(rawQuery2.getString(9));
                            arrayList2 = arrayList5;
                            arrayList2.add(xMLTVProgrammePojo2);
                            if (!rawQuery2.moveToNext()) {
                                break;
                            }
                            arrayList5 = arrayList2;
                        }
                    } else {
                        arrayList2 = arrayList5;
                    }
                    rawQuery2.close();
                    return arrayList2;
                } catch (Exception unused5) {
                    return null;
                } catch (SQLiteDatabaseLockedException unused6) {
                    return null;
                }
            } catch (Exception unused7) {
                return null;
            } catch (SQLiteDatabaseLockedException unused8) {
                return null;
            }
        }
        try {
            try {
                Cursor rawQuery3 = getReadableDatabase().rawQuery("SELECT DISTINCT title,start,stop,description,channel_id,num,name,stream_id,stream_icon,categoryID FROM epg , iptv_live_streams WHERE epg.user_id_referred = '" + userID + "' AND iptv_live_streams.user_id_referred = '" + userID + "' AND epg.source_ref_id = '" + valueOf + "' AND epg.channel_id = iptv_live_streams.epg_channel_id AND epg.title LIKE '%" + str + "%' AND stop>='" + str2 + "' AND iptv_live_streams.categoryID NOT IN (SELECT iptv_password_status_table.password_status_cat_id FROM iptv_password_status_table WHERE iptv_password_status_table.user_id_referred ='" + userID + "' AND iptv_password_status_table.password_status ='1') ORDER BY epg.stop ASC", (String[]) null);
                if (rawQuery3.moveToFirst()) {
                    while (true) {
                        AsyncTask asyncTask3 = w.p;
                        if (asyncTask3 != null && asyncTask3.isCancelled()) {
                            Log.e("honey", "stopped epg");
                            break;
                        }
                        XMLTVProgrammePojo xMLTVProgrammePojo3 = new XMLTVProgrammePojo();
                        xMLTVProgrammePojo3.setTitle(rawQuery3.getString(0));
                        xMLTVProgrammePojo3.setStart(rawQuery3.getString(1));
                        xMLTVProgrammePojo3.setStop(rawQuery3.getString(2));
                        xMLTVProgrammePojo3.setDesc(rawQuery3.getString(3));
                        xMLTVProgrammePojo3.setChannel(rawQuery3.getString(4));
                        xMLTVProgrammePojo3.setLiveNum(rawQuery3.getString(5));
                        xMLTVProgrammePojo3.setLiveName(rawQuery3.getString(6));
                        xMLTVProgrammePojo3.setLiveStreamID(rawQuery3.getString(7));
                        xMLTVProgrammePojo3.setLiveLogo(rawQuery3.getString(8));
                        xMLTVProgrammePojo3.setLiveCategoryId(rawQuery3.getString(9));
                        arrayList = arrayList5;
                        arrayList.add(xMLTVProgrammePojo3);
                        if (!rawQuery3.moveToNext()) {
                            break;
                        }
                        arrayList5 = arrayList;
                    }
                } else {
                    arrayList = arrayList5;
                }
                rawQuery3.close();
                return arrayList;
            } catch (SQLiteDatabaseLockedException unused9) {
                return null;
            } catch (Exception unused10) {
                return null;
            }
        } catch (SQLiteDatabaseLockedException unused11) {
            return null;
        } catch (Exception unused12) {
            return null;
        }
    }

    public ArrayList getEPGSources() {
        int userID = SharepreferenceDBHandler.getUserID(this.context);
        String str = "SELECT  * FROM " + (SharepreferenceDBHandler.getCurrentAPPType(this.context).equals("m3u") ? "iptv_epg_sources_m3u" : "iptv_epg_sources") + " WHERE user_id_referred ='" + userID + "' ORDER BY source_type DESC , auto_id DESC";
        try {
            ArrayList arrayList = new ArrayList();
            Cursor rawQuery = getReadableDatabase().rawQuery(str, (String[]) null);
            if (rawQuery.moveToFirst()) {
                do {
                    EPGSourcesModel ePGSourcesModel = new EPGSourcesModel();
                    ePGSourcesModel.setIdAuto(w.r0(rawQuery.getString(0)));
                    ePGSourcesModel.setUser_id(rawQuery.getString(1));
                    ePGSourcesModel.setName(rawQuery.getString(2));
                    ePGSourcesModel.setSource_type(rawQuery.getString(3));
                    ePGSourcesModel.setEpgurl(rawQuery.getString(4));
                    ePGSourcesModel.setDefault_source(rawQuery.getString(5));
                    arrayList.add(ePGSourcesModel);
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
            return arrayList;
        } catch (SQLiteDatabaseLockedException | Exception unused) {
            return null;
        }
    }

    public ArrayList getEPGTesting(String str, String str2) {
        String str3;
        int userID = SharepreferenceDBHandler.getUserID(this.context);
        String currentAPPType = SharepreferenceDBHandler.getCurrentAPPType(this.context);
        if (currentAPPType.equals("m3u")) {
            str3 = "epg_m3u";
        } else {
            currentAPPType.equals("onestream_api");
            str3 = "epg";
        }
        ArrayList activeEPGSource = getActiveEPGSource();
        String valueOf = (activeEPGSource == null || activeEPGSource.size() <= 0) ? "0" : String.valueOf(((EPGSourcesModel) activeEPGSource.get(0)).getIdAuto());
        ArrayList arrayList = new ArrayList();
        try {
            Cursor rawQuery = getReadableDatabase().rawQuery("SELECT  * FROM " + str3 + " WHERE user_id_referred='" + userID + "' AND source_ref_id='" + valueOf + "' AND '" + str2 + "' BETWEEN start AND stop", (String[]) null);
            if (rawQuery.moveToFirst()) {
                do {
                    XMLTVProgrammePojo xMLTVProgrammePojo = new XMLTVProgrammePojo();
                    xMLTVProgrammePojo.setTitle(rawQuery.getString(1));
                    xMLTVProgrammePojo.setStart(rawQuery.getString(2));
                    xMLTVProgrammePojo.setStop(rawQuery.getString(3));
                    xMLTVProgrammePojo.setDesc(rawQuery.getString(4));
                    xMLTVProgrammePojo.setChannel(rawQuery.getString(5));
                    xMLTVProgrammePojo.setSourceRef(rawQuery.getString(7));
                    arrayList.add(xMLTVProgrammePojo);
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
            return arrayList;
        } catch (SQLiteDatabaseLockedException | Exception unused) {
            return null;
        }
    }

    public int getFavouriteCount(int i) {
        try {
            Cursor rawQuery = getReadableDatabase().rawQuery("SELECT  COUNT(*) FROM iptv_m3u_favourites WHERE  (SELECT iptv_live_streams_m3u_all.id FROM iptv_live_streams_m3u_all WHERE iptv_m3u_favourites.url = iptv_live_streams_m3u_all.url AND iptv_live_streams_m3u_all.user_id_referred=iptv_m3u_favourites.user_id_referred AND iptv_live_streams_m3u_all.move_to<>'live' AND iptv_live_streams_m3u_all.move_to<>'series' AND iptv_live_streams_m3u_all.move_to<>'movie' AND iptv_m3u_favourites.user_id_referred ='" + i + "')", (String[]) null);
            rawQuery.moveToFirst();
            int i2 = rawQuery.getInt(0);
            rawQuery.close();
            return i2;
        } catch (SQLiteDatabaseLockedException | Exception unused) {
            return 0;
        }
    }

    public int getFavouriteCountM3U(String str) {
        try {
            Cursor rawQuery = getReadableDatabase().rawQuery("SELECT iptv_live_streams_m3u.id FROM iptv_live_streams_m3u , iptv_m3u_favourites WHERE iptv_m3u_favourites.url = iptv_live_streams_m3u.url AND iptv_live_streams_m3u.stream_type='" + str + "' AND iptv_live_streams_m3u.user_id_referred=iptv_m3u_favourites.user_id_referred AND iptv_m3u_favourites.user_id_referred ='" + SharepreferenceDBHandler.getUserID(this.context) + "'", (String[]) null);
            int count = rawQuery.getCount();
            rawQuery.close();
            return count;
        } catch (SQLiteDatabaseLockedException | Exception unused) {
            return 0;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x00a7. Please report as an issue. */
    public ArrayList getFavouriteM3U(String str) {
        String str2;
        StringBuilder sb;
        String str3;
        ArrayList arrayList;
        int i;
        String liveSubCatSort = str.equals("live") ? SharepreferenceDBHandler.getLiveSubCatSort(this.context) : str.equals("series") ? SharepreferenceDBHandler.getSeriesSubCatSort(this.context) : SharepreferenceDBHandler.getVODSubCatSort(this.context);
        int userID = SharepreferenceDBHandler.getUserID(this.context);
        ArrayList arrayList2 = new ArrayList();
        liveSubCatSort.hashCode();
        ArrayList arrayList3 = arrayList2;
        char c = 65535;
        switch (liveSubCatSort.hashCode()) {
            case 48:
                str2 = "') ORDER BY ";
                if (liveSubCatSort.equals("0")) {
                    c = 0;
                    break;
                }
                break;
            case 49:
            default:
                str2 = "') ORDER BY ";
                break;
            case 50:
                str2 = "') ORDER BY ";
                if (liveSubCatSort.equals("2")) {
                    c = 1;
                    break;
                }
                break;
            case 51:
                str2 = "') ORDER BY ";
                if (liveSubCatSort.equals("3")) {
                    c = 2;
                    break;
                }
                break;
            case 52:
                str2 = "') ORDER BY ";
                if (liveSubCatSort.equals("4")) {
                    c = 3;
                    break;
                }
                break;
            case 53:
                str2 = "') ORDER BY ";
                if (liveSubCatSort.equals("5")) {
                    c = 4;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                sb = new StringBuilder();
                sb.append("SELECT  * FROM iptv_m3u_favourites WHERE  (SELECT iptv_live_streams_m3u.id FROM iptv_live_streams_m3u WHERE iptv_m3u_favourites.url = iptv_live_streams_m3u.url AND iptv_live_streams_m3u.stream_type='");
                sb.append(str);
                sb.append("' AND ");
                sb.append("iptv_live_streams_m3u");
                sb.append(".");
                sb.append("user_id_referred");
                sb.append("=");
                sb.append("iptv_m3u_favourites");
                sb.append(".");
                sb.append("user_id_referred");
                sb.append(" AND ");
                sb.append("iptv_m3u_favourites");
                sb.append(".");
                sb.append("user_id_referred");
                sb.append(" ='");
                sb.append(userID);
                sb.append("')");
                break;
            case 1:
                sb = new StringBuilder();
                sb.append("SELECT  * FROM iptv_m3u_favourites WHERE  (SELECT iptv_live_streams_m3u.id FROM iptv_live_streams_m3u WHERE iptv_m3u_favourites.url = iptv_live_streams_m3u.url AND iptv_live_streams_m3u.stream_type='");
                sb.append(str);
                sb.append("' AND ");
                sb.append("iptv_live_streams_m3u");
                sb.append(".");
                sb.append("user_id_referred");
                sb.append("=");
                sb.append("iptv_m3u_favourites");
                sb.append(".");
                sb.append("user_id_referred");
                sb.append(" AND ");
                sb.append("iptv_m3u_favourites");
                sb.append(".");
                sb.append("user_id_referred");
                sb.append(" ='");
                sb.append(userID);
                sb.append(str2);
                sb.append("iptv_m3u_favourites");
                sb.append(".");
                sb.append("name");
                str3 = " ASC ";
                sb.append(str3);
                break;
            case 2:
                sb = new StringBuilder();
                sb.append("SELECT  * FROM iptv_m3u_favourites WHERE  (SELECT iptv_live_streams_m3u.id FROM iptv_live_streams_m3u WHERE iptv_m3u_favourites.url = iptv_live_streams_m3u.url AND iptv_live_streams_m3u.stream_type='");
                sb.append(str);
                sb.append("' AND ");
                sb.append("iptv_live_streams_m3u");
                sb.append(".");
                sb.append("user_id_referred");
                sb.append("=");
                sb.append("iptv_m3u_favourites");
                sb.append(".");
                sb.append("user_id_referred");
                sb.append(" AND ");
                sb.append("iptv_m3u_favourites");
                sb.append(".");
                sb.append("user_id_referred");
                sb.append(" ='");
                sb.append(userID);
                sb.append(str2);
                sb.append("iptv_m3u_favourites");
                sb.append(".");
                sb.append("name");
                str3 = " DESC ";
                sb.append(str3);
                break;
            case 3:
                sb = new StringBuilder();
                sb.append("SELECT  * FROM iptv_m3u_favourites WHERE  (SELECT iptv_live_streams_m3u.id FROM iptv_live_streams_m3u WHERE iptv_m3u_favourites.url = iptv_live_streams_m3u.url AND iptv_live_streams_m3u.stream_type='");
                sb.append(str);
                sb.append("' AND ");
                sb.append("iptv_live_streams_m3u");
                sb.append(".");
                sb.append("user_id_referred");
                sb.append("=");
                sb.append("iptv_m3u_favourites");
                sb.append(".");
                sb.append("user_id_referred");
                sb.append(" AND ");
                sb.append("iptv_m3u_favourites");
                sb.append(".");
                sb.append("user_id_referred");
                sb.append(" ='");
                sb.append(userID);
                sb.append("' ORDER BY cast(");
                sb.append("iptv_live_streams_m3u");
                sb.append(".");
                sb.append("num");
                str3 = " as REAL) ASC)";
                sb.append(str3);
                break;
            case 4:
                sb = new StringBuilder();
                sb.append("SELECT  * FROM iptv_m3u_favourites WHERE  (SELECT iptv_live_streams_m3u.id FROM iptv_live_streams_m3u WHERE iptv_m3u_favourites.url = iptv_live_streams_m3u.url AND iptv_live_streams_m3u.stream_type='");
                sb.append(str);
                sb.append("' AND ");
                sb.append("iptv_live_streams_m3u");
                sb.append(".");
                sb.append("user_id_referred");
                sb.append("=");
                sb.append("iptv_m3u_favourites");
                sb.append(".");
                sb.append("user_id_referred");
                sb.append(" AND ");
                sb.append("iptv_m3u_favourites");
                sb.append(".");
                sb.append("user_id_referred");
                sb.append(" ='");
                sb.append(userID);
                sb.append("' ORDER BY cast(");
                sb.append("iptv_live_streams_m3u");
                sb.append(".");
                sb.append("num");
                str3 = " as REAL) DESC)";
                sb.append(str3);
                break;
            default:
                sb = new StringBuilder();
                sb.append("SELECT  * FROM iptv_m3u_favourites WHERE  (SELECT iptv_live_streams_m3u.id FROM iptv_live_streams_m3u WHERE iptv_m3u_favourites.url = iptv_live_streams_m3u.url AND iptv_live_streams_m3u.stream_type='");
                sb.append(str);
                sb.append("' AND ");
                sb.append("iptv_live_streams_m3u");
                sb.append(".");
                sb.append("user_id_referred");
                sb.append("=");
                sb.append("iptv_m3u_favourites");
                sb.append(".");
                sb.append("user_id_referred");
                sb.append(" AND ");
                sb.append("iptv_m3u_favourites");
                sb.append(".");
                sb.append("user_id_referred");
                sb.append(" ='");
                sb.append(userID);
                sb.append("')");
                break;
        }
        String sb2 = sb.toString();
        try {
            SQLiteDatabase readableDatabase = getReadableDatabase();
            try {
                this.db = readableDatabase;
                Cursor rawQuery = readableDatabase.rawQuery(sb2, (String[]) null);
                if (rawQuery.moveToFirst()) {
                    while (true) {
                        FavouriteM3UModel favouriteM3UModel = new FavouriteM3UModel();
                        try {
                            i = Integer.parseInt(rawQuery.getString(0));
                        } catch (NumberFormatException unused) {
                            i = 0;
                        }
                        favouriteM3UModel.setId(i);
                        favouriteM3UModel.setUrl(rawQuery.getString(1));
                        favouriteM3UModel.setUserID(Integer.parseInt(rawQuery.getString(2)));
                        favouriteM3UModel.setName(rawQuery.getString(3));
                        favouriteM3UModel.setCategoryID(rawQuery.getString(4));
                        arrayList = arrayList3;
                        try {
                            arrayList.add(favouriteM3UModel);
                            if (rawQuery.moveToNext()) {
                                arrayList3 = arrayList;
                            }
                        } catch (SQLiteDatabaseLockedException unused2) {
                            return arrayList;
                        } catch (Exception unused3) {
                            return arrayList;
                        }
                    }
                } else {
                    arrayList = arrayList3;
                }
                rawQuery.close();
                return arrayList;
            } catch (Exception unused4) {
                return arrayList3;
            } catch (SQLiteDatabaseLockedException unused5) {
                return arrayList3;
            }
        } catch (SQLiteDatabaseLockedException unused6) {
        } catch (Exception unused7) {
        }
    }

    public int getImportTableCount(String str) {
        try {
            Cursor rawQuery = getReadableDatabase().rawQuery("SELECT  * FROM iptv_import_status WHERE user_id_referred = '" + SharepreferenceDBHandler.getUserID(this.context) + "' AND app_type = '" + str + "'", (String[]) null);
            int count = rawQuery.getCount();
            rawQuery.close();
            return count;
        } catch (SQLiteDatabaseLockedException | Exception unused) {
            return 0;
        }
    }

    public ArrayList getLiveFavStalker(String str) {
        int userID = SharepreferenceDBHandler.getUserID(this.context);
        ArrayList arrayList = new ArrayList();
        try {
            Cursor rawQuery = getReadableDatabase().rawQuery("SELECT  * FROM iptv_stalker_live_streams WHERE iptv_stalker_live_streams.user_id_referred='" + userID + "' AND iptv_stalker_live_streams.stream_id IN (" + str + ") AND iptv_stalker_live_streams.categoryID NOT IN (SELECT iptv_password_status_table.password_status_cat_id FROM iptv_password_status_table WHERE iptv_password_status_table.user_id_referred ='" + userID + "' AND iptv_password_status_table.password_status ='1')", (String[]) null);
            if (rawQuery.moveToFirst()) {
                while (true) {
                    if (SharepreferenceDBHandler.getAsyncTaskStatus(this.context) == 1) {
                        SharepreferenceDBHandler.setAsyncTaskStatus(0, this.context);
                        break;
                    }
                    LiveStreamsDBModel liveStreamsDBModel = new LiveStreamsDBModel();
                    liveStreamsDBModel.setIdAuto(Integer.parseInt(rawQuery.getString(0)));
                    liveStreamsDBModel.setStreamId(rawQuery.getString(1));
                    liveStreamsDBModel.setNum(rawQuery.getString(2));
                    liveStreamsDBModel.setName(rawQuery.getString(3));
                    liveStreamsDBModel.setCmd(rawQuery.getString(4));
                    liveStreamsDBModel.setStreamIcon(rawQuery.getString(5));
                    liveStreamsDBModel.setEpgChannelId(rawQuery.getString(6));
                    liveStreamsDBModel.setCategoryId(rawQuery.getString(7));
                    liveStreamsDBModel.setTvArchive(rawQuery.getString(8));
                    arrayList.add(liveStreamsDBModel);
                    if (!rawQuery.moveToNext()) {
                        break;
                    }
                }
            }
            rawQuery.close();
            return arrayList;
        } catch (SQLiteDatabaseLockedException | Exception unused) {
            return null;
        }
    }

    public LiveStreamsDBModel getLiveStreamFavouriteRow(String str, String str2, String str3, String str4) {
        StringBuilder sb;
        String str5;
        String sb2;
        Cursor rawQuery;
        LiveStreamsDBModel liveStreamsDBModel;
        StringBuilder sb3;
        String str6;
        int userID = SharepreferenceDBHandler.getUserID(this.context);
        new ArrayList();
        String currentAPPType = SharepreferenceDBHandler.getCurrentAPPType(this.context);
        if (str4.equalsIgnoreCase("radio_streams") || str4.equalsIgnoreCase("live")) {
            if (currentAPPType.equals("onestream_api")) {
                sb = new StringBuilder();
                str5 = "SELECT  * FROM onestream_iptv_live_streams WHERE stream_type LIKE '%";
            } else {
                sb = new StringBuilder();
                str5 = "SELECT  * FROM iptv_live_streams WHERE stream_type LIKE '%";
            }
            sb.append(str5);
            sb.append(str4);
            sb.append("%' AND ");
            sb.append("categoryID");
            sb.append("='");
            sb.append(str);
            sb.append("'  AND ");
            sb.append("user_id_referred");
            sb.append(" = '");
            sb.append(userID);
            sb.append("' AND ");
            sb.append("stream_id");
            sb.append("='");
            sb.append(str2);
            sb.append("' LIMIT 1");
            sb2 = sb.toString();
        } else {
            if (currentAPPType.equals("onestream_api")) {
                sb3 = new StringBuilder();
                str6 = "SELECT  * FROM onestream_iptv_live_streams WHERE categoryID='";
            } else {
                sb3 = new StringBuilder();
                str6 = "SELECT  * FROM iptv_live_streams WHERE categoryID='";
            }
            sb3.append(str6);
            sb3.append(str);
            sb3.append("'  AND ");
            sb3.append("user_id_referred");
            sb3.append(" = '");
            sb3.append(userID);
            sb3.append("' AND ");
            sb3.append("stream_id");
            sb3.append("='");
            sb3.append(str2);
            sb3.append("' LIMIT 1");
            sb2 = sb3.toString();
        }
        try {
            rawQuery = getReadableDatabase().rawQuery(sb2, (String[]) null);
            liveStreamsDBModel = new LiveStreamsDBModel();
        } catch (SQLiteDatabaseLockedException | Exception unused) {
        }
        if (!rawQuery.moveToFirst()) {
            rawQuery.close();
            return null;
        }
        do {
            liveStreamsDBModel.setIdAuto(Integer.parseInt(rawQuery.getString(0)));
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
            liveStreamsDBModel.setRatingFromTen(rawQuery.getString(18));
            liveStreamsDBModel.setRatingFromFive(rawQuery.getString(19));
            liveStreamsDBModel.setUrl(rawQuery.getString(20));
            liveStreamsDBModel.setTimestamp(str3);
        } while (rawQuery.moveToNext());
        rawQuery.close();
        return liveStreamsDBModel;
    }

    public int getLiveStreamsCount(String str) {
        StringBuilder sb;
        String str2;
        int userID = SharepreferenceDBHandler.getUserID(this.context);
        if (SharepreferenceDBHandler.getCurrentAPPType(this.context).equals("onestream_api")) {
            sb = new StringBuilder();
            str2 = "SELECT  COUNT(*) FROM onestream_iptv_live_streams WHERE categoryID='";
        } else {
            sb = new StringBuilder();
            str2 = "SELECT  COUNT(*) FROM iptv_live_streams WHERE categoryID='";
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
        } catch (SQLiteDatabaseLockedException | Exception unused) {
            return 0;
        }
    }

    public int getM3UCount(String str) {
        String str2;
        int userID = SharepreferenceDBHandler.getUserID(this.context);
        if (str.equals("0")) {
            str2 = "SELECT  COUNT(*) FROM iptv_live_streams_m3u_all WHERE user_id_referred='" + userID + "' AND move_to NOT IN ('live','movie','series') OR move_to IS NULL";
        } else {
            str2 = "SELECT  COUNT(*) FROM iptv_live_streams_m3u_all WHERE categoryID='" + str + "' AND user_id_referred='" + userID + "' AND move_to NOT IN ('live','movie','series') OR move_to IS NULL";
        }
        try {
            Cursor rawQuery = getReadableDatabase().rawQuery(str2, (String[]) null);
            rawQuery.moveToFirst();
            int i = rawQuery.getInt(0);
            rawQuery.close();
            return i;
        } catch (SQLiteDatabaseLockedException | Exception unused) {
            return 0;
        }
    }

    public ArrayList getM3UFavouriteRow(String str, String str2, String str3) {
        Cursor rawQuery;
        LiveStreamsDBModel liveStreamsDBModel;
        ArrayList arrayList = new ArrayList();
        try {
            rawQuery = getReadableDatabase().rawQuery("SELECT  * FROM iptv_live_streams_m3u WHERE categoryID='" + str + "' AND url='" + str2 + "' AND user_id_referred='" + SharepreferenceDBHandler.getUserID(this.context) + "'", (String[]) null);
            liveStreamsDBModel = new LiveStreamsDBModel();
        } catch (SQLiteDatabaseLockedException | Exception unused) {
        }
        if (!rawQuery.moveToFirst()) {
            rawQuery.close();
            return null;
        }
        do {
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
            liveStreamsDBModel.setDirectSource(rawQuery.getString(11));
            liveStreamsDBModel.setTvArchiveDuration(rawQuery.getString(12));
            liveStreamsDBModel.setTypeName(rawQuery.getString(13));
            liveStreamsDBModel.setCategoryName(rawQuery.getString(14));
            liveStreamsDBModel.setSeriesNo(rawQuery.getString(15));
            liveStreamsDBModel.setLive(rawQuery.getString(16));
            liveStreamsDBModel.setContaiinerExtension(rawQuery.getString(17));
            liveStreamsDBModel.setUrl(rawQuery.getString(18));
            liveStreamsDBModel.setTimestamp(str3);
            arrayList.add(liveStreamsDBModel);
        } while (rawQuery.moveToNext());
        rawQuery.close();
        return arrayList;
    }

    public SeriesDBModel getM3UFavouriteRowSeries(String str, String str2, String str3) {
        String str4 = "SELECT  * FROM iptv_live_streams_m3u WHERE categoryID='" + str + "' AND url='" + str2 + "' AND user_id_referred='" + SharepreferenceDBHandler.getUserID(this.context) + "'";
        SeriesDBModel seriesDBModel = new SeriesDBModel();
        try {
            Cursor rawQuery = getReadableDatabase().rawQuery(str4, (String[]) null);
            if (rawQuery.moveToFirst()) {
                do {
                    seriesDBModel.setIdAuto(Integer.parseInt(rawQuery.getString(0)));
                    seriesDBModel.setNum(rawQuery.getString(1));
                    seriesDBModel.setName(rawQuery.getString(2));
                    seriesDBModel.setStreamType(rawQuery.getString(3));
                    seriesDBModel.setseriesID(w.r0(rawQuery.getString(4)));
                    seriesDBModel.setOneStreamseriesID(rawQuery.getString(4));
                    seriesDBModel.setcover(rawQuery.getString(5));
                    seriesDBModel.setplot("");
                    seriesDBModel.setcast("");
                    seriesDBModel.setdirector("");
                    seriesDBModel.setgenre("");
                    seriesDBModel.setreleaseDate("");
                    seriesDBModel.setlast_modified("");
                    seriesDBModel.setrating("");
                    seriesDBModel.setCategoryId(rawQuery.getString(8));
                    seriesDBModel.setYouTubeTrailer("");
                    seriesDBModel.setBackdrop("");
                    seriesDBModel.setUrl(rawQuery.getString(18));
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
            return seriesDBModel;
        } catch (SQLiteDatabaseLockedException | Exception unused) {
            return null;
        }
    }

    public int getMagportal(String str) {
        try {
            Cursor rawQuery = getReadableDatabase().rawQuery("SELECT  COUNT(*) FROM iptv_mag_portal_table WHERE mag_portal='" + str + "'", (String[]) null);
            rawQuery.moveToFirst();
            int i = rawQuery.getInt(0);
            rawQuery.close();
            return i;
        } catch (SQLiteDatabaseLockedException | Exception unused) {
            return 0;
        }
    }

    public ArrayList getOneStreamAllSeriesStreamsWithCategoryId(String str) {
        StringBuilder sb;
        String str2;
        StringBuilder sb2;
        String str3;
        String sb3;
        String str4 = str;
        long currentTimeMillis = System.currentTimeMillis();
        String seriesSubCatSort = SharepreferenceDBHandler.getSeriesSubCatSort(this.context);
        int userID = SharepreferenceDBHandler.getUserID(this.context);
        if (str4.equals("") || str4.equals("0")) {
            if (seriesSubCatSort.equals("0")) {
                sb = new StringBuilder();
                sb.append("SELECT  * FROM onestream_series_streams_v2 WHERE onestream_series_streams_v2.user_id_referred = '");
                sb.append(userID);
                sb.append("' AND ");
                sb.append("onestream_series_streams_v2");
                sb.append(".");
                sb.append("category_id_series_stream_v2");
                sb.append(" NOT IN (SELECT ");
                sb.append("iptv_password_status_table");
                sb.append(".");
                sb.append("password_status_cat_id");
                sb.append(" FROM ");
                sb.append("iptv_password_status_table");
                sb.append(" WHERE ");
                sb.append("iptv_password_status_table");
                sb.append(".");
                sb.append("user_id_referred");
                sb.append(" ='");
                sb.append(userID);
                sb.append("' AND ");
                sb.append("iptv_password_status_table");
                sb.append(".");
                sb.append("password_status");
                str2 = " ='1')";
            } else if (seriesSubCatSort.equals("3")) {
                sb = new StringBuilder();
                sb.append("SELECT  * FROM onestream_series_streams_v2 WHERE onestream_series_streams_v2.user_id_referred = '");
                sb.append(userID);
                sb.append("' AND ");
                sb.append("onestream_series_streams_v2");
                sb.append(".");
                sb.append("category_id_series_stream_v2");
                sb.append(" NOT IN (SELECT ");
                sb.append("iptv_password_status_table");
                sb.append(".");
                sb.append("password_status_cat_id");
                sb.append(" FROM ");
                sb.append("iptv_password_status_table");
                sb.append(" WHERE ");
                sb.append("iptv_password_status_table");
                sb.append(".");
                sb.append("user_id_referred");
                sb.append(" ='");
                sb.append(userID);
                sb.append("' AND ");
                sb.append("iptv_password_status_table");
                sb.append(".");
                sb.append("password_status");
                sb.append(" ='1') ORDER BY ");
                sb.append("name_series_stream_v2");
                str2 = " DESC";
            } else if (seriesSubCatSort.equals("2")) {
                sb = new StringBuilder();
                sb.append("SELECT  * FROM onestream_series_streams_v2 WHERE onestream_series_streams_v2.user_id_referred = '");
                sb.append(userID);
                sb.append("' AND ");
                sb.append("onestream_series_streams_v2");
                sb.append(".");
                sb.append("category_id_series_stream_v2");
                sb.append(" NOT IN (SELECT ");
                sb.append("iptv_password_status_table");
                sb.append(".");
                sb.append("password_status_cat_id");
                sb.append(" FROM ");
                sb.append("iptv_password_status_table");
                sb.append(" WHERE ");
                sb.append("iptv_password_status_table");
                sb.append(".");
                sb.append("user_id_referred");
                sb.append(" ='");
                sb.append(userID);
                sb.append("' AND ");
                sb.append("iptv_password_status_table");
                sb.append(".");
                sb.append("password_status");
                sb.append(" ='1') ORDER BY ");
                sb.append("name_series_stream_v2");
                str2 = " ASC";
            } else if (seriesSubCatSort.equals("6")) {
                sb = new StringBuilder();
                sb.append("SELECT  * FROM onestream_series_streams_v2 WHERE onestream_series_streams_v2.user_id_referred = '");
                sb.append(userID);
                sb.append("' AND ");
                sb.append("onestream_series_streams_v2");
                sb.append(".");
                sb.append("category_id_series_stream_v2");
                sb.append(" NOT IN (SELECT ");
                sb.append("iptv_password_status_table");
                sb.append(".");
                sb.append("password_status_cat_id");
                sb.append(" FROM ");
                sb.append("iptv_password_status_table");
                sb.append(" WHERE ");
                sb.append("iptv_password_status_table");
                sb.append(".");
                sb.append("user_id_referred");
                sb.append(" ='");
                sb.append(userID);
                sb.append("' AND ");
                sb.append("iptv_password_status_table");
                sb.append(".");
                sb.append("password_status");
                sb.append(" ='1') ORDER BY cast(");
                sb.append("rating_series_stream_v2");
                str2 = " as REAL) DESC ";
            } else if (seriesSubCatSort.equals("1")) {
                sb = new StringBuilder();
                sb.append("SELECT  * FROM onestream_series_streams_v2 WHERE onestream_series_streams_v2.user_id_referred = '");
                sb.append(userID);
                sb.append("' AND ");
                sb.append("onestream_series_streams_v2");
                sb.append(".");
                sb.append("category_id_series_stream_v2");
                sb.append(" NOT IN (SELECT ");
                sb.append("iptv_password_status_table");
                sb.append(".");
                sb.append("password_status_cat_id");
                sb.append(" FROM ");
                sb.append("iptv_password_status_table");
                sb.append(" WHERE ");
                sb.append("iptv_password_status_table");
                sb.append(".");
                sb.append("user_id_referred");
                sb.append(" ='");
                sb.append(userID);
                sb.append("' AND ");
                sb.append("iptv_password_status_table");
                sb.append(".");
                sb.append("password_status");
                sb.append(" ='1') ORDER BY ");
                sb.append("last_modified_series_stream_v2");
                str2 = " DESC ";
            } else {
                sb = new StringBuilder();
                sb.append("SELECT * FROM onestream_series_streams_v2 WHERE onestream_series_streams_v2.user_id_referred = '");
                sb.append(userID);
                sb.append("' AND ");
                sb.append("onestream_series_streams_v2");
                sb.append(".");
                sb.append("category_id_series_stream_v2");
                sb.append(" NOT IN (SELECT ");
                sb.append("iptv_password_status_table");
                sb.append(".");
                sb.append("password_status_cat_id");
                sb.append(" FROM ");
                sb.append("iptv_password_status_table");
                sb.append(" WHERE ");
                sb.append("iptv_password_status_table");
                sb.append(".");
                sb.append("user_id_referred");
                sb.append(" ='");
                sb.append(userID);
                sb.append("' AND ");
                sb.append("iptv_password_status_table");
                sb.append(".");
                sb.append("password_status");
                sb.append(" ='1') ORDER BY ");
                sb.append("id_series_stream_v2");
                str2 = " DESC";
            }
            sb.append(str2);
            String sb4 = sb.toString();
            ArrayList arrayList = new ArrayList();
            try {
                try {
                    Cursor rawQuery = getReadableDatabase().rawQuery(sb4, (String[]) null);
                    if (rawQuery.moveToFirst()) {
                        while (true) {
                            AsyncTask asyncTask = w.m;
                            if (asyncTask != null && asyncTask.isCancelled()) {
                                Log.e("honey", "stopped");
                                break;
                            }
                            SeriesDBModel seriesDBModel = new SeriesDBModel();
                            seriesDBModel.setIdAuto(Integer.parseInt(rawQuery.getString(0)));
                            seriesDBModel.setNum(rawQuery.getString(1));
                            seriesDBModel.setName(rawQuery.getString(2));
                            seriesDBModel.setStreamType(rawQuery.getString(3));
                            seriesDBModel.setseriesID(w.r0(rawQuery.getString(4)));
                            seriesDBModel.setOneStreamseriesID(rawQuery.getString(4));
                            seriesDBModel.setcover(rawQuery.getString(5));
                            seriesDBModel.setplot(rawQuery.getString(6));
                            seriesDBModel.setcast(rawQuery.getString(7));
                            seriesDBModel.setdirector(rawQuery.getString(8));
                            seriesDBModel.setgenre(rawQuery.getString(9));
                            seriesDBModel.setreleaseDate(rawQuery.getString(10));
                            seriesDBModel.setlast_modified(rawQuery.getString(11));
                            seriesDBModel.setrating(rawQuery.getString(12));
                            seriesDBModel.setCategoryId(rawQuery.getString(13));
                            seriesDBModel.setYouTubeTrailer(rawQuery.getString(14));
                            seriesDBModel.setBackdrop(rawQuery.getString(15));
                            arrayList.add(seriesDBModel);
                            if (!rawQuery.moveToNext()) {
                                break;
                            }
                        }
                    }
                    rawQuery.close();
                    Log.e("honey testing", "milli: " + (System.currentTimeMillis() - currentTimeMillis));
                    return arrayList;
                } catch (Exception unused) {
                    return null;
                } catch (SQLiteDatabaseLockedException unused2) {
                    return null;
                }
            } catch (SQLiteDatabaseLockedException unused3) {
                return null;
            } catch (Exception unused4) {
                return null;
            }
        }
        if (str4.equals("-5")) {
            sb3 = "SELECT * FROM onestream_series_streams_v2 WHERE onestream_series_streams_v2.user_id_referred = '" + userID + "' AND onestream_series_streams_v2.category_id_series_stream_v2 NOT IN (SELECT iptv_password_status_table.password_status_cat_id FROM iptv_password_status_table WHERE iptv_password_status_table.user_id_referred ='" + userID + "' AND iptv_password_status_table.password_status ='1') ORDER BY last_modified_series_stream_v2 DESC LIMIT " + new a(this.context).y();
        } else {
            if (str4.equals("-6")) {
                str4 = "-5";
            }
            if (seriesSubCatSort.equals("0")) {
                sb2 = new StringBuilder();
                sb2.append("SELECT * FROM onestream_series_streams_v2 WHERE onestream_series_streams_v2.user_id_referred = '");
                sb2.append(userID);
                sb2.append("' AND ");
                sb2.append("category_id_series_stream_v2");
                sb2.append(" ='");
                sb2.append(str4);
                sb2.append("' AND ");
                sb2.append("onestream_series_streams_v2");
                sb2.append(".");
                sb2.append("category_id_series_stream_v2");
                sb2.append(" NOT IN (SELECT ");
                sb2.append("iptv_password_status_table");
                sb2.append(".");
                sb2.append("password_status_cat_id");
                sb2.append(" FROM ");
                sb2.append("iptv_password_status_table");
                sb2.append(" WHERE ");
                sb2.append("iptv_password_status_table");
                sb2.append(".");
                sb2.append("user_id_referred");
                sb2.append(" ='");
                sb2.append(userID);
                sb2.append("' AND ");
                sb2.append("iptv_password_status_table");
                sb2.append(".");
                sb2.append("password_status");
                str3 = " ='1')";
            } else if (seriesSubCatSort.equals("3")) {
                sb2 = new StringBuilder();
                sb2.append("SELECT * FROM onestream_series_streams_v2 WHERE onestream_series_streams_v2.user_id_referred = '");
                sb2.append(userID);
                sb2.append("' AND ");
                sb2.append("category_id_series_stream_v2");
                sb2.append(" ='");
                sb2.append(str4);
                sb2.append("' AND ");
                sb2.append("onestream_series_streams_v2");
                sb2.append(".");
                sb2.append("category_id_series_stream_v2");
                sb2.append(" NOT IN (SELECT ");
                sb2.append("iptv_password_status_table");
                sb2.append(".");
                sb2.append("password_status_cat_id");
                sb2.append(" FROM ");
                sb2.append("iptv_password_status_table");
                sb2.append(" WHERE ");
                sb2.append("iptv_password_status_table");
                sb2.append(".");
                sb2.append("user_id_referred");
                sb2.append(" ='");
                sb2.append(userID);
                sb2.append("' AND ");
                sb2.append("iptv_password_status_table");
                sb2.append(".");
                sb2.append("password_status");
                sb2.append(" ='1') ORDER BY ");
                sb2.append("name_series_stream_v2");
                str3 = " DESC";
            } else if (seriesSubCatSort.equals("2")) {
                sb2 = new StringBuilder();
                sb2.append("SELECT * FROM onestream_series_streams_v2 WHERE onestream_series_streams_v2.user_id_referred = '");
                sb2.append(userID);
                sb2.append("' AND ");
                sb2.append("category_id_series_stream_v2");
                sb2.append(" ='");
                sb2.append(str4);
                sb2.append("' AND ");
                sb2.append("onestream_series_streams_v2");
                sb2.append(".");
                sb2.append("category_id_series_stream_v2");
                sb2.append(" NOT IN (SELECT ");
                sb2.append("iptv_password_status_table");
                sb2.append(".");
                sb2.append("password_status_cat_id");
                sb2.append(" FROM ");
                sb2.append("iptv_password_status_table");
                sb2.append(" WHERE ");
                sb2.append("iptv_password_status_table");
                sb2.append(".");
                sb2.append("user_id_referred");
                sb2.append(" ='");
                sb2.append(userID);
                sb2.append("' AND ");
                sb2.append("iptv_password_status_table");
                sb2.append(".");
                sb2.append("password_status");
                sb2.append(" ='1') ORDER BY ");
                sb2.append("name_series_stream_v2");
                str3 = " ASC";
            } else if (seriesSubCatSort.equals("6")) {
                sb2 = new StringBuilder();
                sb2.append("SELECT * FROM onestream_series_streams_v2 WHERE onestream_series_streams_v2.user_id_referred = '");
                sb2.append(userID);
                sb2.append("' AND ");
                sb2.append("category_id_series_stream_v2");
                sb2.append(" ='");
                sb2.append(str4);
                sb2.append("' AND ");
                sb2.append("onestream_series_streams_v2");
                sb2.append(".");
                sb2.append("category_id_series_stream_v2");
                sb2.append(" NOT IN (SELECT ");
                sb2.append("iptv_password_status_table");
                sb2.append(".");
                sb2.append("password_status_cat_id");
                sb2.append(" FROM ");
                sb2.append("iptv_password_status_table");
                sb2.append(" WHERE ");
                sb2.append("iptv_password_status_table");
                sb2.append(".");
                sb2.append("user_id_referred");
                sb2.append(" ='");
                sb2.append(userID);
                sb2.append("' AND ");
                sb2.append("iptv_password_status_table");
                sb2.append(".");
                sb2.append("password_status");
                sb2.append(" ='1') ORDER BY cast(");
                sb2.append("rating_series_stream_v2");
                str3 = " as REAL) DESC ";
            } else if (seriesSubCatSort.equals("1")) {
                sb2 = new StringBuilder();
                sb2.append("SELECT * FROM onestream_series_streams_v2 WHERE onestream_series_streams_v2.user_id_referred = '");
                sb2.append(userID);
                sb2.append("' AND ");
                sb2.append("category_id_series_stream_v2");
                sb2.append(" ='");
                sb2.append(str4);
                sb2.append("' AND ");
                sb2.append("onestream_series_streams_v2");
                sb2.append(".");
                sb2.append("category_id_series_stream_v2");
                sb2.append(" NOT IN (SELECT ");
                sb2.append("iptv_password_status_table");
                sb2.append(".");
                sb2.append("password_status_cat_id");
                sb2.append(" FROM ");
                sb2.append("iptv_password_status_table");
                sb2.append(" WHERE ");
                sb2.append("iptv_password_status_table");
                sb2.append(".");
                sb2.append("user_id_referred");
                sb2.append(" ='");
                sb2.append(userID);
                sb2.append("' AND ");
                sb2.append("iptv_password_status_table");
                sb2.append(".");
                sb2.append("password_status");
                sb2.append(" ='1') ORDER BY ");
                sb2.append("last_modified_series_stream_v2");
                str3 = " DESC ";
            } else {
                sb2 = new StringBuilder();
                sb2.append("SELECT * FROM onestream_series_streams_v2 WHERE onestream_series_streams_v2.user_id_referred = '");
                sb2.append(userID);
                sb2.append("' AND ");
                sb2.append("category_id_series_stream_v2");
                sb2.append(" ='");
                sb2.append(str4);
                sb2.append("' AND ");
                sb2.append("onestream_series_streams_v2");
                sb2.append(".");
                sb2.append("category_id_series_stream_v2");
                sb2.append(" NOT IN (SELECT ");
                sb2.append("iptv_password_status_table");
                sb2.append(".");
                sb2.append("password_status_cat_id");
                sb2.append(" FROM ");
                sb2.append("iptv_password_status_table");
                sb2.append(" WHERE ");
                sb2.append("iptv_password_status_table");
                sb2.append(".");
                sb2.append("user_id_referred");
                sb2.append(" ='");
                sb2.append(userID);
                sb2.append("' AND ");
                sb2.append("iptv_password_status_table");
                sb2.append(".");
                sb2.append("password_status");
                sb2.append(" ='1') ORDER BY ");
                sb2.append("id_series_stream_v2");
                str3 = " DESC";
            }
            sb2.append(str3);
            sb3 = sb2.toString();
        }
        ArrayList arrayList2 = new ArrayList();
        try {
            try {
                Cursor rawQuery2 = getReadableDatabase().rawQuery(sb3, (String[]) null);
                if (rawQuery2.moveToFirst()) {
                    while (true) {
                        AsyncTask asyncTask2 = w.m;
                        if (asyncTask2 != null && asyncTask2.isCancelled()) {
                            Log.e("honey", "stopped");
                            break;
                        }
                        SeriesDBModel seriesDBModel2 = new SeriesDBModel();
                        seriesDBModel2.setIdAuto(Integer.parseInt(rawQuery2.getString(0)));
                        seriesDBModel2.setNum(rawQuery2.getString(1));
                        seriesDBModel2.setName(rawQuery2.getString(2));
                        seriesDBModel2.setStreamType(rawQuery2.getString(3));
                        seriesDBModel2.setseriesID(w.r0(rawQuery2.getString(4)));
                        seriesDBModel2.setOneStreamseriesID(rawQuery2.getString(4));
                        seriesDBModel2.setcover(rawQuery2.getString(5));
                        seriesDBModel2.setplot(rawQuery2.getString(6));
                        seriesDBModel2.setcast(rawQuery2.getString(7));
                        seriesDBModel2.setdirector(rawQuery2.getString(8));
                        seriesDBModel2.setgenre(rawQuery2.getString(9));
                        seriesDBModel2.setreleaseDate(rawQuery2.getString(10));
                        seriesDBModel2.setlast_modified(rawQuery2.getString(11));
                        seriesDBModel2.setrating(rawQuery2.getString(12));
                        seriesDBModel2.setCategoryId(rawQuery2.getString(13));
                        seriesDBModel2.setYouTubeTrailer(rawQuery2.getString(14));
                        seriesDBModel2.setBackdrop(rawQuery2.getString(15));
                        arrayList2.add(seriesDBModel2);
                        if (!rawQuery2.moveToNext()) {
                            break;
                        }
                    }
                }
                rawQuery2.close();
                return arrayList2;
            } catch (Exception unused5) {
                return null;
            } catch (SQLiteDatabaseLockedException unused6) {
                return null;
            }
        } catch (Exception unused7) {
            return null;
        } catch (SQLiteDatabaseLockedException unused8) {
            return null;
        }
    }

    public int getPanelEPGSource() {
        int userID = SharepreferenceDBHandler.getUserID(this.context);
        try {
            Cursor rawQuery = getReadableDatabase().rawQuery("SELECT  * FROM " + (SharepreferenceDBHandler.getCurrentAPPType(this.context).equals("m3u") ? "iptv_epg_sources_m3u" : "iptv_epg_sources") + " WHERE user_id_referred='" + userID + "' AND source_type = 'panel'", (String[]) null);
            int count = rawQuery.getCount();
            rawQuery.close();
            return count;
        } catch (SQLiteDatabaseLockedException | Exception unused) {
            return 0;
        }
    }

    public int getParentalStatusCount(int i) {
        try {
            Cursor rawQuery = getReadableDatabase().rawQuery("SELECT  * FROM " + (SharepreferenceDBHandler.getCurrentAPPType(this.context).equals("m3u") ? "iptv_password_status_table_m3u" : "iptv_password_status_table") + " WHERE user_id_referred=" + i + "", (String[]) null);
            int count = rawQuery.getCount();
            rawQuery.close();
            return count;
        } catch (SQLiteDatabaseLockedException | Exception unused) {
            return 0;
        }
    }

    public PasswordStatusDBModel getPasswordStatus(String str, String str2, int i) {
        try {
            Cursor rawQuery = getReadableDatabase().rawQuery("SELECT * FROM " + (SharepreferenceDBHandler.getCurrentAPPType(this.context).equals("m3u") ? "iptv_password_status_table_m3u" : "iptv_password_status_table") + " WHERE password_user_detail = '" + str + "' AND password_status_cat_id = '" + str2 + "' AND user_id_referred = " + i + "", (String[]) null);
            PasswordStatusDBModel passwordStatusDBModel = new PasswordStatusDBModel();
            if (rawQuery.moveToFirst()) {
                do {
                    passwordStatusDBModel.setIdPaswordStaus(Integer.parseInt(rawQuery.getString(0)));
                    passwordStatusDBModel.setPasswordStatusCategoryId(rawQuery.getString(1));
                    passwordStatusDBModel.setPasswordStatusUserDetail(rawQuery.getString(2));
                    passwordStatusDBModel.setPasswordStatus(rawQuery.getString(3));
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
            return passwordStatusDBModel;
        } catch (SQLiteDatabaseLockedException | Exception unused) {
            return null;
        }
    }

    public int getRecentwatchCount(int i, String str) {
        try {
            Cursor rawQuery = getReadableDatabase().rawQuery("SELECT  COUNT(*) FROM iptv_recent_watched_m3u WHERE user_id_referred=" + i + " AND stream_type='" + str + "'", (String[]) null);
            rawQuery.moveToFirst();
            int i2 = rawQuery.getInt(0);
            rawQuery.close();
            return i2;
        } catch (SQLiteDatabaseLockedException | Exception unused) {
            return 0;
        }
    }

    public ArrayList getSearchRecords(String str) {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        int userID = SharepreferenceDBHandler.getUserID(this.context);
        String currentAPPType = SharepreferenceDBHandler.getCurrentAPPType(this.context);
        ArrayList arrayList4 = new ArrayList();
        String str2 = "stopped live movies";
        if (currentAPPType.equals("m3u")) {
            StringBuilder sb = new StringBuilder();
            String str3 = "honey";
            sb.append("SELECT  * FROM iptv_live_streams_m3u WHERE name LIKE '%");
            sb.append(str);
            sb.append("%'  AND ");
            sb.append("iptv_live_streams_m3u");
            sb.append(".");
            sb.append("user_id_referred");
            sb.append("='");
            sb.append(userID);
            sb.append("' AND ");
            sb.append("iptv_live_streams_m3u");
            sb.append(".");
            sb.append("stream_type");
            sb.append(" IN ('movie','live') AND ");
            sb.append("iptv_live_streams_m3u");
            sb.append(".");
            sb.append("categoryID");
            sb.append(" NOT IN (SELECT ");
            sb.append("iptv_password_status_table_m3u");
            sb.append(".");
            sb.append("password_status_cat_id");
            sb.append(" FROM ");
            sb.append("iptv_password_status_table_m3u");
            sb.append(" WHERE ");
            sb.append("iptv_password_status_table_m3u");
            sb.append(".");
            sb.append("user_id_referred");
            sb.append(" ='");
            sb.append(userID);
            sb.append("' AND ");
            sb.append("iptv_password_status_table_m3u");
            sb.append(".");
            sb.append("password_status");
            sb.append(" ='1')");
            try {
                try {
                    Cursor rawQuery = getReadableDatabase().rawQuery(sb.toString(), (String[]) null);
                    if (rawQuery.moveToFirst()) {
                        while (true) {
                            AsyncTask asyncTask = w.p;
                            if (asyncTask != null && asyncTask.isCancelled()) {
                                Log.e(str3, str2);
                                break;
                            }
                            String str4 = str2;
                            String str5 = str3;
                            LiveStreamsDBModel liveStreamsDBModel = new LiveStreamsDBModel();
                            liveStreamsDBModel.setIdAuto(Integer.parseInt(rawQuery.getString(0)));
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
                            liveStreamsDBModel.setUrl(rawQuery.getString(18));
                            arrayList3 = arrayList4;
                            arrayList3.add(liveStreamsDBModel);
                            if (!rawQuery.moveToNext()) {
                                break;
                            }
                            arrayList4 = arrayList3;
                            str2 = str4;
                            str3 = str5;
                        }
                    } else {
                        arrayList3 = arrayList4;
                    }
                    rawQuery.close();
                    return arrayList3;
                } catch (SQLiteDatabaseLockedException unused) {
                    return null;
                } catch (Exception unused2) {
                    return null;
                }
            } catch (Exception unused3) {
                return null;
            } catch (SQLiteDatabaseLockedException unused4) {
                return null;
            }
        }
        ArrayList arrayList5 = arrayList4;
        String str6 = "honey";
        if (currentAPPType.equals("onestream_api")) {
            try {
                try {
                    Cursor rawQuery2 = getReadableDatabase().rawQuery("SELECT  * FROM onestream_iptv_live_streams WHERE name LIKE '%" + str + "%'  AND onestream_iptv_live_streams.user_id_referred = '" + userID + "' AND onestream_iptv_live_streams.categoryID NOT IN (SELECT iptv_password_status_table.password_status_cat_id FROM iptv_password_status_table WHERE iptv_password_status_table.user_id_referred ='" + userID + "' AND iptv_password_status_table.password_status ='1')", (String[]) null);
                    if (rawQuery2.moveToFirst()) {
                        while (true) {
                            AsyncTask asyncTask2 = w.p;
                            if (asyncTask2 != null && asyncTask2.isCancelled()) {
                                Log.e(str6, str2);
                                break;
                            }
                            String str7 = str2;
                            String str8 = str6;
                            LiveStreamsDBModel liveStreamsDBModel2 = new LiveStreamsDBModel();
                            liveStreamsDBModel2.setIdAuto(Integer.parseInt(rawQuery2.getString(0)));
                            liveStreamsDBModel2.setNum(rawQuery2.getString(1));
                            liveStreamsDBModel2.setName(rawQuery2.getString(2));
                            liveStreamsDBModel2.setStreamType(rawQuery2.getString(3));
                            liveStreamsDBModel2.setStreamId(rawQuery2.getString(4));
                            liveStreamsDBModel2.setStreamIdOneStream(rawQuery2.getString(4));
                            liveStreamsDBModel2.setStreamIcon(rawQuery2.getString(5));
                            liveStreamsDBModel2.setEpgChannelId(rawQuery2.getString(6));
                            liveStreamsDBModel2.setAdded(rawQuery2.getString(7));
                            liveStreamsDBModel2.setCategoryId(rawQuery2.getString(8));
                            liveStreamsDBModel2.setCustomSid(rawQuery2.getString(9));
                            liveStreamsDBModel2.setTvArchive(rawQuery2.getString(10));
                            liveStreamsDBModel2.setDirectSource(rawQuery2.getString(11));
                            liveStreamsDBModel2.setTvArchiveDuration(rawQuery2.getString(12));
                            liveStreamsDBModel2.setTypeName(rawQuery2.getString(13));
                            liveStreamsDBModel2.setCategoryName(rawQuery2.getString(14));
                            liveStreamsDBModel2.setSeriesNo(rawQuery2.getString(15));
                            liveStreamsDBModel2.setLive(rawQuery2.getString(16));
                            liveStreamsDBModel2.setContaiinerExtension(rawQuery2.getString(17));
                            liveStreamsDBModel2.setRatingFromTen(rawQuery2.getString(18));
                            liveStreamsDBModel2.setRatingFromFive(rawQuery2.getString(19));
                            liveStreamsDBModel2.setUrl(rawQuery2.getString(20));
                            arrayList2 = arrayList5;
                            arrayList2.add(liveStreamsDBModel2);
                            if (!rawQuery2.moveToNext()) {
                                break;
                            }
                            str6 = str8;
                            arrayList5 = arrayList2;
                            str2 = str7;
                        }
                    } else {
                        arrayList2 = arrayList5;
                    }
                    rawQuery2.close();
                    return arrayList2;
                } catch (Exception unused5) {
                    return null;
                } catch (SQLiteDatabaseLockedException unused6) {
                    return null;
                }
            } catch (SQLiteDatabaseLockedException unused7) {
                return null;
            } catch (Exception unused8) {
                return null;
            }
        }
        String str9 = str6;
        ArrayList arrayList6 = arrayList5;
        try {
            try {
                Cursor rawQuery3 = getReadableDatabase().rawQuery("SELECT  * FROM iptv_live_streams WHERE name LIKE '%" + str + "%'  AND iptv_live_streams.user_id_referred = '" + userID + "' AND iptv_live_streams.categoryID NOT IN (SELECT iptv_password_status_table.password_status_cat_id FROM iptv_password_status_table WHERE iptv_password_status_table.user_id_referred ='" + userID + "' AND iptv_password_status_table.password_status ='1')", (String[]) null);
                if (rawQuery3.moveToFirst()) {
                    while (true) {
                        AsyncTask asyncTask3 = w.p;
                        if (asyncTask3 != null && asyncTask3.isCancelled()) {
                            Log.e(str9, str2);
                            break;
                        }
                        String str10 = str2;
                        String str11 = str9;
                        LiveStreamsDBModel liveStreamsDBModel3 = new LiveStreamsDBModel();
                        liveStreamsDBModel3.setIdAuto(Integer.parseInt(rawQuery3.getString(0)));
                        liveStreamsDBModel3.setNum(rawQuery3.getString(1));
                        liveStreamsDBModel3.setName(rawQuery3.getString(2));
                        liveStreamsDBModel3.setStreamType(rawQuery3.getString(3));
                        liveStreamsDBModel3.setStreamId(rawQuery3.getString(4));
                        liveStreamsDBModel3.setStreamIdOneStream(rawQuery3.getString(4));
                        liveStreamsDBModel3.setStreamIcon(rawQuery3.getString(5));
                        liveStreamsDBModel3.setEpgChannelId(rawQuery3.getString(6));
                        liveStreamsDBModel3.setAdded(rawQuery3.getString(7));
                        liveStreamsDBModel3.setCategoryId(rawQuery3.getString(8));
                        liveStreamsDBModel3.setCustomSid(rawQuery3.getString(9));
                        liveStreamsDBModel3.setTvArchive(rawQuery3.getString(10));
                        liveStreamsDBModel3.setDirectSource(rawQuery3.getString(11));
                        liveStreamsDBModel3.setTvArchiveDuration(rawQuery3.getString(12));
                        liveStreamsDBModel3.setTypeName(rawQuery3.getString(13));
                        liveStreamsDBModel3.setCategoryName(rawQuery3.getString(14));
                        liveStreamsDBModel3.setSeriesNo(rawQuery3.getString(15));
                        liveStreamsDBModel3.setLive(rawQuery3.getString(16));
                        liveStreamsDBModel3.setContaiinerExtension(rawQuery3.getString(17));
                        liveStreamsDBModel3.setRatingFromTen(rawQuery3.getString(18));
                        liveStreamsDBModel3.setRatingFromFive(rawQuery3.getString(19));
                        liveStreamsDBModel3.setUrl(rawQuery3.getString(20));
                        arrayList = arrayList6;
                        arrayList.add(liveStreamsDBModel3);
                        if (!rawQuery3.moveToNext()) {
                            break;
                        }
                        str2 = str10;
                        str9 = str11;
                        arrayList6 = arrayList;
                    }
                } else {
                    arrayList = arrayList6;
                }
                rawQuery3.close();
                return arrayList;
            } catch (Exception unused9) {
                return null;
            } catch (SQLiteDatabaseLockedException unused10) {
                return null;
            }
        } catch (SQLiteDatabaseLockedException unused11) {
            return null;
        } catch (Exception unused12) {
            return null;
        }
    }

    public ArrayList getSearchRecordsSeries(String str) {
        int userID = SharepreferenceDBHandler.getUserID(this.context);
        String currentAPPType = SharepreferenceDBHandler.getCurrentAPPType(this.context);
        String str2 = "";
        if (currentAPPType.equals("m3u")) {
            StringBuilder sb = new StringBuilder();
            String str3 = "stopped series";
            sb.append("SELECT  * FROM iptv_live_streams_m3u WHERE name LIKE '%");
            sb.append(str);
            sb.append("%'  AND ");
            sb.append("iptv_live_streams_m3u");
            sb.append(".");
            sb.append("user_id_referred");
            sb.append("='");
            sb.append(userID);
            sb.append("' AND ");
            sb.append("iptv_live_streams_m3u");
            sb.append(".");
            sb.append("stream_type");
            sb.append("='series' AND ");
            sb.append("iptv_live_streams_m3u");
            sb.append(".");
            sb.append("categoryID");
            sb.append(" NOT IN (SELECT ");
            sb.append("iptv_password_status_table_m3u");
            sb.append(".");
            sb.append("password_status_cat_id");
            sb.append(" FROM ");
            sb.append("iptv_password_status_table_m3u");
            sb.append(" WHERE ");
            sb.append("iptv_password_status_table_m3u");
            sb.append(".");
            sb.append("user_id_referred");
            sb.append(" ='");
            sb.append(userID);
            sb.append("' AND ");
            sb.append("iptv_password_status_table_m3u");
            sb.append(".");
            sb.append("password_status");
            sb.append(" ='1')");
            String sb2 = sb.toString();
            ArrayList arrayList = new ArrayList();
            try {
                try {
                    Cursor rawQuery = getReadableDatabase().rawQuery(sb2, (String[]) null);
                    if (rawQuery.moveToFirst()) {
                        while (true) {
                            AsyncTask asyncTask = w.p;
                            if (asyncTask != null && asyncTask.isCancelled()) {
                                Log.e("honey", str3);
                                break;
                            }
                            String str4 = str3;
                            SeriesDBModel seriesDBModel = new SeriesDBModel();
                            seriesDBModel.setIdAuto(Integer.parseInt(rawQuery.getString(0)));
                            seriesDBModel.setNum(rawQuery.getString(1));
                            seriesDBModel.setName(rawQuery.getString(2));
                            seriesDBModel.setStreamType(rawQuery.getString(3));
                            seriesDBModel.setseriesID(w.r0(rawQuery.getString(4)));
                            seriesDBModel.setOneStreamseriesID(rawQuery.getString(4));
                            seriesDBModel.setcover(rawQuery.getString(5));
                            String str5 = str2;
                            seriesDBModel.setplot(str5);
                            seriesDBModel.setcast(str5);
                            seriesDBModel.setdirector(str5);
                            seriesDBModel.setgenre(str5);
                            seriesDBModel.setreleaseDate(str5);
                            seriesDBModel.setlast_modified(str5);
                            seriesDBModel.setrating(str5);
                            seriesDBModel.setCategoryId(rawQuery.getString(8));
                            seriesDBModel.setYouTubeTrailer(str5);
                            seriesDBModel.setBackdrop(str5);
                            seriesDBModel.setUrl(rawQuery.getString(18));
                            arrayList.add(seriesDBModel);
                            if (!rawQuery.moveToNext()) {
                                break;
                            }
                            str2 = str5;
                            str3 = str4;
                        }
                    }
                    rawQuery.close();
                    return arrayList;
                } catch (SQLiteDatabaseLockedException unused) {
                    return null;
                } catch (Exception unused2) {
                    return null;
                }
            } catch (SQLiteDatabaseLockedException unused3) {
                return null;
            } catch (Exception unused4) {
                return null;
            }
        }
        String str6 = "stopped series";
        if (currentAPPType.equals("onestream_api")) {
            StringBuilder sb3 = new StringBuilder();
            String str7 = "honey";
            sb3.append("SELECT  * FROM onestream_series_streams_v2 WHERE name_series_stream_v2 LIKE '%");
            sb3.append(str);
            sb3.append("%'  AND ");
            sb3.append("onestream_series_streams_v2");
            sb3.append(".");
            sb3.append("user_id_referred");
            sb3.append(" = '");
            sb3.append(userID);
            sb3.append("' AND ");
            sb3.append("onestream_series_streams_v2");
            sb3.append(".");
            sb3.append("category_id_series_stream_v2");
            sb3.append(" NOT IN (SELECT ");
            sb3.append("iptv_password_status_table");
            sb3.append(".");
            sb3.append("password_status_cat_id");
            sb3.append(" FROM ");
            sb3.append("iptv_password_status_table");
            sb3.append(" WHERE ");
            sb3.append("iptv_password_status_table");
            sb3.append(".");
            sb3.append("user_id_referred");
            sb3.append(" ='");
            sb3.append(userID);
            sb3.append("' AND ");
            sb3.append("iptv_password_status_table");
            sb3.append(".");
            sb3.append("password_status");
            sb3.append(" ='1')");
            String sb4 = sb3.toString();
            ArrayList arrayList2 = new ArrayList();
            try {
                try {
                    Cursor rawQuery2 = getReadableDatabase().rawQuery(sb4, (String[]) null);
                    if (rawQuery2.moveToFirst()) {
                        while (true) {
                            AsyncTask asyncTask2 = w.p;
                            if (asyncTask2 != null && asyncTask2.isCancelled()) {
                                Log.e(str7, str6);
                                break;
                            }
                            String str8 = str7;
                            String str9 = str6;
                            SeriesDBModel seriesDBModel2 = new SeriesDBModel();
                            seriesDBModel2.setIdAuto(Integer.parseInt(rawQuery2.getString(0)));
                            seriesDBModel2.setNum(rawQuery2.getString(1));
                            seriesDBModel2.setName(rawQuery2.getString(2));
                            seriesDBModel2.setStreamType(rawQuery2.getString(3));
                            seriesDBModel2.setseriesID(w.r0(rawQuery2.getString(4)));
                            seriesDBModel2.setOneStreamseriesID(rawQuery2.getString(4));
                            seriesDBModel2.setcover(rawQuery2.getString(5));
                            seriesDBModel2.setplot(rawQuery2.getString(6));
                            seriesDBModel2.setcast(rawQuery2.getString(7));
                            seriesDBModel2.setdirector(rawQuery2.getString(8));
                            seriesDBModel2.setgenre(rawQuery2.getString(9));
                            seriesDBModel2.setreleaseDate(rawQuery2.getString(10));
                            seriesDBModel2.setlast_modified(rawQuery2.getString(11));
                            seriesDBModel2.setrating(rawQuery2.getString(12));
                            seriesDBModel2.setCategoryId(rawQuery2.getString(13));
                            seriesDBModel2.setYouTubeTrailer(rawQuery2.getString(14));
                            seriesDBModel2.setBackdrop(rawQuery2.getString(15));
                            arrayList2.add(seriesDBModel2);
                            if (!rawQuery2.moveToNext()) {
                                break;
                            }
                            str6 = str9;
                            str7 = str8;
                        }
                    }
                    rawQuery2.close();
                    return arrayList2;
                } catch (SQLiteDatabaseLockedException unused5) {
                    return null;
                } catch (Exception unused6) {
                    return null;
                }
            } catch (Exception unused7) {
                return null;
            } catch (SQLiteDatabaseLockedException unused8) {
                return null;
            }
        }
        StringBuilder sb5 = new StringBuilder();
        String str10 = "honey";
        sb5.append("SELECT  * FROM series_streams_v2 WHERE name_series_stream_v2 LIKE '%");
        sb5.append(str);
        sb5.append("%'  AND ");
        sb5.append("series_streams_v2");
        sb5.append(".");
        sb5.append("user_id_referred");
        sb5.append(" = '");
        sb5.append(userID);
        sb5.append("' AND ");
        sb5.append("series_streams_v2");
        sb5.append(".");
        sb5.append("category_id_series_stream_v2");
        sb5.append(" NOT IN (SELECT ");
        sb5.append("iptv_password_status_table");
        sb5.append(".");
        sb5.append("password_status_cat_id");
        sb5.append(" FROM ");
        sb5.append("iptv_password_status_table");
        sb5.append(" WHERE ");
        sb5.append("iptv_password_status_table");
        sb5.append(".");
        sb5.append("user_id_referred");
        sb5.append(" ='");
        sb5.append(userID);
        sb5.append("' AND ");
        sb5.append("iptv_password_status_table");
        sb5.append(".");
        sb5.append("password_status");
        sb5.append(" ='1')");
        String sb6 = sb5.toString();
        ArrayList arrayList3 = new ArrayList();
        try {
            try {
                Cursor rawQuery3 = getReadableDatabase().rawQuery(sb6, (String[]) null);
                if (rawQuery3.moveToFirst()) {
                    while (true) {
                        AsyncTask asyncTask3 = w.p;
                        if (asyncTask3 != null && asyncTask3.isCancelled()) {
                            Log.e(str10, str6);
                            break;
                        }
                        String str11 = str10;
                        String str12 = str6;
                        SeriesDBModel seriesDBModel3 = new SeriesDBModel();
                        seriesDBModel3.setIdAuto(Integer.parseInt(rawQuery3.getString(0)));
                        seriesDBModel3.setNum(rawQuery3.getString(1));
                        seriesDBModel3.setName(rawQuery3.getString(2));
                        seriesDBModel3.setStreamType(rawQuery3.getString(3));
                        seriesDBModel3.setseriesID(w.r0(rawQuery3.getString(4)));
                        seriesDBModel3.setOneStreamseriesID(rawQuery3.getString(4));
                        seriesDBModel3.setcover(rawQuery3.getString(5));
                        seriesDBModel3.setplot(rawQuery3.getString(6));
                        seriesDBModel3.setcast(rawQuery3.getString(7));
                        seriesDBModel3.setdirector(rawQuery3.getString(8));
                        seriesDBModel3.setgenre(rawQuery3.getString(9));
                        seriesDBModel3.setreleaseDate(rawQuery3.getString(10));
                        seriesDBModel3.setlast_modified(rawQuery3.getString(11));
                        seriesDBModel3.setrating(rawQuery3.getString(12));
                        seriesDBModel3.setCategoryId(rawQuery3.getString(13));
                        seriesDBModel3.setYouTubeTrailer(rawQuery3.getString(14));
                        seriesDBModel3.setBackdrop(rawQuery3.getString(15));
                        arrayList3.add(seriesDBModel3);
                        if (!rawQuery3.moveToNext()) {
                            break;
                        }
                        str6 = str12;
                        str10 = str11;
                    }
                }
                rawQuery3.close();
                return arrayList3;
            } catch (SQLiteDatabaseLockedException unused9) {
                return null;
            } catch (Exception unused10) {
                return null;
            }
        } catch (SQLiteDatabaseLockedException unused11) {
            return null;
        } catch (Exception unused12) {
            return null;
        }
    }

    public int getSeriesCount(String str) {
        StringBuilder sb;
        String str2;
        if (SharepreferenceDBHandler.getCurrentAPPType(this.context).equals("onestream_api")) {
            sb = new StringBuilder();
            str2 = "SELECT  COUNT(*) FROM onestream_series_streams_v2 WHERE category_id_series_stream_v2='";
        } else {
            sb = new StringBuilder();
            str2 = "SELECT  COUNT(*) FROM series_streams_v2 WHERE category_id_series_stream_v2='";
        }
        sb.append(str2);
        sb.append(str);
        sb.append("'");
        try {
            Cursor rawQuery = getReadableDatabase().rawQuery(sb.toString(), (String[]) null);
            rawQuery.moveToFirst();
            int i = rawQuery.getInt(0);
            rawQuery.close();
            return i;
        } catch (SQLiteDatabaseLockedException | Exception unused) {
            return 0;
        }
    }

    public SeriesDBModel getSeriesStreamsWithSeriesId(String str) {
        StringBuilder sb;
        String str2;
        int userID = SharepreferenceDBHandler.getUserID(this.context);
        if (SharepreferenceDBHandler.getCurrentAPPType(this.context).equals("onestream_api")) {
            sb = new StringBuilder();
            str2 = "SELECT  * FROM onestream_series_streams_v2 WHERE stream_id_series_stream_v2 ='";
        } else {
            sb = new StringBuilder();
            str2 = "SELECT  * FROM series_streams_v2 WHERE stream_id_series_stream_v2 ='";
        }
        sb.append(str2);
        sb.append(str);
        sb.append("' AND ");
        sb.append("user_id_referred");
        sb.append(" = '");
        sb.append(userID);
        sb.append("'");
        String sb2 = sb.toString();
        new ArrayList();
        SeriesDBModel seriesDBModel = new SeriesDBModel();
        try {
            Cursor rawQuery = getReadableDatabase().rawQuery(sb2, (String[]) null);
            if (rawQuery.moveToFirst()) {
                do {
                    seriesDBModel.setIdAuto(Integer.parseInt(rawQuery.getString(0)));
                    seriesDBModel.setNum(rawQuery.getString(1));
                    seriesDBModel.setName(rawQuery.getString(2));
                    seriesDBModel.setStreamType(rawQuery.getString(3));
                    seriesDBModel.setseriesID(w.r0(rawQuery.getString(4)));
                    seriesDBModel.setOneStreamseriesID(rawQuery.getString(4));
                    seriesDBModel.setcover(rawQuery.getString(5));
                    seriesDBModel.setplot(rawQuery.getString(6));
                    seriesDBModel.setcast(rawQuery.getString(7));
                    seriesDBModel.setdirector(rawQuery.getString(8));
                    seriesDBModel.setgenre(rawQuery.getString(9));
                    seriesDBModel.setreleaseDate(rawQuery.getString(10));
                    seriesDBModel.setlast_modified(rawQuery.getString(11));
                    seriesDBModel.setrating(rawQuery.getString(12));
                    seriesDBModel.setCategoryId(rawQuery.getString(13));
                    seriesDBModel.setYouTubeTrailer(rawQuery.getString(14));
                    seriesDBModel.setBackdrop(rawQuery.getString(15));
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
            return seriesDBModel;
        } catch (SQLiteDatabaseLockedException | Exception unused) {
            return null;
        }
    }

    public LiveStreamsDBModel getStreamStatus(String str, int i) {
        try {
            Cursor rawQuery = getReadableDatabase().rawQuery("SELECT * FROM iptv_recent_watched_m3u WHERE url = '" + str + "' AND user_id_referred = '" + i + "'", (String[]) null);
            LiveStreamsDBModel liveStreamsDBModel = new LiveStreamsDBModel();
            if (rawQuery.moveToFirst()) {
                do {
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
                    liveStreamsDBModel.setUrl(rawQuery.getString(18));
                    liveStreamsDBModel.setUserIdReffered(rawQuery.getInt(19));
                    liveStreamsDBModel.setMovieElapsedTime(rawQuery.getLong(20));
                    liveStreamsDBModel.setMovieDuraton(rawQuery.getLong(21));
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
            return liveStreamsDBModel;
        } catch (SQLiteDatabaseLockedException | Exception unused2) {
            return null;
        }
    }

    public int getStreamsCount(String str) {
        StringBuilder sb;
        String str2;
        String str3;
        int userID = SharepreferenceDBHandler.getUserID(this.context);
        String currentAPPType = SharepreferenceDBHandler.getCurrentAPPType(this.context);
        try {
            if (currentAPPType.equals("m3u")) {
                sb = new StringBuilder();
                sb.append("SELECT  COUNT(*) FROM iptv_live_streams_m3u WHERE stream_type='");
                sb.append(str);
                sb.append("' AND ");
            } else {
                if (currentAPPType.equals("stalker_api")) {
                    str3 = "SELECT  COUNT(*) FROM iptv_stalker_live_streams WHERE user_id_referred='" + userID + "'";
                    Cursor rawQuery = getReadableDatabase().rawQuery(str3, (String[]) null);
                    rawQuery.moveToFirst();
                    int i = rawQuery.getInt(0);
                    rawQuery.close();
                    return i;
                }
                if (currentAPPType.equals("onestream_api")) {
                    sb = new StringBuilder();
                    str2 = "SELECT  COUNT(*) FROM onestream_iptv_live_streams WHERE stream_type LIKE '%";
                } else {
                    sb = new StringBuilder();
                    str2 = "SELECT  COUNT(*) FROM iptv_live_streams WHERE stream_type LIKE '%";
                }
                sb.append(str2);
                sb.append(str);
                sb.append("%' AND ");
            }
            Cursor rawQuery2 = getReadableDatabase().rawQuery(str3, (String[]) null);
            rawQuery2.moveToFirst();
            int i2 = rawQuery2.getInt(0);
            rawQuery2.close();
            return i2;
        } catch (SQLiteDatabaseLockedException | Exception unused) {
            return 0;
        }
        sb.append("user_id_referred");
        sb.append("='");
        sb.append(userID);
        sb.append("'");
        str3 = sb.toString();
    }

    public int getSubCatMovieCount(String str, String str2) {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        int userID = SharepreferenceDBHandler.getUserID(this.context);
        String currentAPPType = SharepreferenceDBHandler.getCurrentAPPType(this.context);
        if (str2.equals("live")) {
            if (currentAPPType.equals("onestream_api")) {
                sb3 = new StringBuilder();
                sb3.append("SELECT  COUNT(*) FROM onestream_iptv_live_streams WHERE ( stream_type LIKE '%");
            } else {
                sb3 = new StringBuilder();
                sb3.append("SELECT  COUNT(*) FROM iptv_live_streams WHERE ( stream_type LIKE '%");
            }
            sb3.append(str2);
            sb3.append("%' OR ");
            sb3.append("stream_type");
            sb3.append(" LIKE '%radio%' )  AND ");
            sb3.append("categoryID");
            sb3.append("='");
            sb3.append(str);
            sb3.append("' AND ");
            sb3.append("user_id_referred");
            sb3.append("='");
            sb3.append(userID);
            sb3.append("'");
            try {
                Cursor rawQuery = getReadableDatabase().rawQuery(sb3.toString(), (String[]) null);
                rawQuery.moveToFirst();
                int i = rawQuery.getInt(0);
                rawQuery.close();
                return i;
            } catch (SQLiteDatabaseLockedException unused) {
                return 0;
            } catch (Exception unused2) {
                return 0;
            }
        }
        boolean equals = str2.equals("movie");
        boolean equals2 = currentAPPType.equals("onestream_api");
        if (equals) {
            if (equals2) {
                sb2 = new StringBuilder();
                sb2.append("SELECT  COUNT(*) FROM onestream_iptv_live_streams WHERE ( stream_type LIKE '%");
            } else {
                sb2 = new StringBuilder();
                sb2.append("SELECT  COUNT(*) FROM iptv_live_streams WHERE ( stream_type LIKE '%");
            }
            sb2.append(str2);
            sb2.append("%' OR ");
            sb2.append("stream_type");
            sb2.append(" LIKE '%radio%' )  AND ");
            sb2.append("categoryID");
            sb2.append("='");
            sb2.append(str);
            sb2.append("' AND ");
            sb2.append("user_id_referred");
            sb2.append("='");
            sb2.append(userID);
            sb2.append("'");
            try {
                Cursor rawQuery2 = getReadableDatabase().rawQuery(sb2.toString(), (String[]) null);
                rawQuery2.moveToFirst();
                int i2 = rawQuery2.getInt(0);
                rawQuery2.close();
                return i2;
            } catch (SQLiteDatabaseLockedException unused3) {
                return 0;
            } catch (Exception unused4) {
                return 0;
            }
        }
        if (equals2) {
            sb = new StringBuilder();
            sb.append("SELECT  COUNT(*) FROM onestream_iptv_live_streams WHERE ( stream_type LIKE '%");
        } else {
            sb = new StringBuilder();
            sb.append("SELECT  COUNT(*) FROM iptv_live_streams WHERE ( stream_type LIKE '%");
        }
        sb.append(str2);
        sb.append("%' OR ");
        sb.append("stream_type");
        sb.append(" LIKE '%radio%' )  AND ");
        sb.append("categoryID");
        sb.append("='");
        sb.append(str);
        sb.append("' AND ");
        sb.append("user_id_referred");
        sb.append("='");
        sb.append(userID);
        sb.append("'");
        try {
            Cursor rawQuery3 = getReadableDatabase().rawQuery(sb.toString(), (String[]) null);
            rawQuery3.moveToFirst();
            int i3 = rawQuery3.getInt(0);
            rawQuery3.close();
            return i3;
        } catch (Exception unused5) {
            return 0;
        } catch (SQLiteDatabaseLockedException unused6) {
            return 0;
        }
    }

    public int getTotalNumberOFChannelsWithEPG(String str) {
        StringBuilder sb;
        String str2;
        String str3;
        int userID = SharepreferenceDBHandler.getUserID(this.context);
        String currentAPPType = SharepreferenceDBHandler.getCurrentAPPType(this.context);
        if (currentAPPType.equals("m3u")) {
            sb = new StringBuilder();
            sb.append("SELECT iptv_live_streams_m3u.url  FROM epg_m3u , iptv_live_streams_m3u WHERE iptv_live_streams_m3u.user_id_referred = '");
            sb.append(userID);
            sb.append("' AND ");
            sb.append("epg_m3u");
            sb.append(".");
            sb.append("source_ref_id");
            sb.append(" = '");
            sb.append(str);
            sb.append("' AND ");
            sb.append("epg_m3u");
            sb.append(".");
            sb.append("channel_id");
            sb.append(" = ");
            sb.append("iptv_live_streams_m3u");
            sb.append(".");
            sb.append("epg_channel_id");
            sb.append(" AND ");
            sb.append("iptv_live_streams_m3u");
            sb.append(".");
            sb.append("categoryID");
            sb.append(" NOT IN (SELECT ");
            sb.append("iptv_password_status_table_m3u");
            sb.append(".");
            sb.append("password_status_cat_id");
            sb.append(" FROM ");
            sb.append("iptv_password_status_table_m3u");
            sb.append(" WHERE ");
            sb.append("iptv_password_status_table_m3u");
            sb.append(".");
            sb.append("user_id_referred");
            sb.append(" ='");
            sb.append(userID);
            sb.append("' AND ");
            sb.append("iptv_password_status_table_m3u");
            sb.append(".");
            sb.append("password_status");
            sb.append(" ='1') GROUP BY ");
            sb.append("iptv_live_streams_m3u");
            sb.append(".");
            str3 = "url";
        } else {
            if (currentAPPType.equals("onestream_api")) {
                sb = new StringBuilder();
                sb.append("SELECT onestream_iptv_live_streams.stream_id  FROM epg , onestream_iptv_live_streams WHERE onestream_iptv_live_streams.user_id_referred = '");
                sb.append(userID);
                sb.append("' AND ");
                sb.append("epg");
                sb.append(".");
                sb.append("source_ref_id");
                sb.append(" = '");
                sb.append(str);
                sb.append("' AND ");
                sb.append("epg");
                sb.append(".");
                sb.append("channel_id");
                sb.append(" = ");
                str2 = "onestream_iptv_live_streams";
                sb.append("onestream_iptv_live_streams");
                sb.append(".");
                sb.append("epg_channel_id");
                sb.append(" AND ");
                sb.append("onestream_iptv_live_streams");
                sb.append(".");
                sb.append("categoryID");
                sb.append(" NOT IN (SELECT ");
                sb.append("iptv_password_status_table");
                sb.append(".");
                sb.append("password_status_cat_id");
                sb.append(" FROM ");
                sb.append("iptv_password_status_table");
                sb.append(" WHERE ");
                sb.append("iptv_password_status_table");
                sb.append(".");
                sb.append("user_id_referred");
                sb.append(" ='");
                sb.append(userID);
                sb.append("' AND ");
                sb.append("iptv_password_status_table");
                sb.append(".");
                sb.append("password_status");
                sb.append(" ='1') GROUP BY ");
            } else {
                sb = new StringBuilder();
                sb.append("SELECT iptv_live_streams.stream_id  FROM epg , iptv_live_streams WHERE iptv_live_streams.user_id_referred = '");
                sb.append(userID);
                sb.append("' AND ");
                sb.append("epg");
                sb.append(".");
                sb.append("source_ref_id");
                sb.append(" = '");
                sb.append(str);
                sb.append("' AND ");
                sb.append("epg");
                sb.append(".");
                sb.append("channel_id");
                sb.append(" = ");
                sb.append("iptv_live_streams");
                sb.append(".");
                sb.append("epg_channel_id");
                sb.append(" AND ");
                sb.append("iptv_live_streams");
                sb.append(".");
                sb.append("categoryID");
                sb.append(" NOT IN (SELECT ");
                sb.append("iptv_password_status_table");
                sb.append(".");
                sb.append("password_status_cat_id");
                sb.append(" FROM ");
                sb.append("iptv_password_status_table");
                sb.append(" WHERE ");
                sb.append("iptv_password_status_table");
                sb.append(".");
                sb.append("user_id_referred");
                sb.append(" ='");
                sb.append(userID);
                sb.append("' AND ");
                sb.append("iptv_password_status_table");
                sb.append(".");
                sb.append("password_status");
                sb.append(" ='1') GROUP BY ");
                str2 = "iptv_live_streams";
            }
            sb.append(str2);
            sb.append(".");
            str3 = "stream_id";
        }
        sb.append(str3);
        try {
            Cursor rawQuery = getReadableDatabase().rawQuery(sb.toString(), (String[]) null);
            int count = rawQuery.getCount();
            rawQuery.close();
            return count;
        } catch (SQLiteDatabaseLockedException unused) {
            return 0;
        } catch (Exception unused2) {
            return 0;
        }
    }

    public int getUncatCount(String str, String str2) {
        try {
            Cursor rawQuery = getReadableDatabase().rawQuery("SELECT  COUNT(*) FROM iptv_live_streams WHERE ( stream_type LIKE '%" + str2 + "%' )  AND categoryID='" + str + "' AND user_id_referred = '" + SharepreferenceDBHandler.getUserID(this.context) + "'", (String[]) null);
            rawQuery.moveToFirst();
            int i = rawQuery.getInt(0);
            rawQuery.close();
            return i;
        } catch (SQLiteDatabaseLockedException | Exception unused) {
            return 0;
        }
    }

    public int getUncatCountM3U(String str) {
        try {
            Cursor rawQuery = getReadableDatabase().rawQuery("SELECT COUNT(*) FROM series_m3u_streams WHERE series_m3u_stream_container_cat_id ='" + str + "'", (String[]) null);
            rawQuery.moveToFirst();
            int i = rawQuery.getInt(0);
            rawQuery.close();
            return i;
        } catch (SQLiteDatabaseLockedException | Exception unused) {
            return 0;
        }
    }

    public int getUncatCountM3UALL(Boolean bool) {
        StringBuilder sb;
        String str;
        int userID = SharepreferenceDBHandler.getUserID(this.context);
        if (bool.booleanValue()) {
            sb = new StringBuilder();
            sb.append("SELECT  COUNT(*) FROM iptv_live_streams_m3u WHERE categoryID='' AND user_id_referred='");
            sb.append(userID);
            sb.append("' AND ");
            sb.append("move_to");
            sb.append(" NOT IN ('live','movie','series') OR ");
            sb.append("move_to");
            str = " IS NULL";
        } else {
            sb = new StringBuilder();
            sb.append("SELECT  COUNT(*) FROM iptv_live_streams_m3u WHERE categoryID='' AND user_id_referred='");
            sb.append(userID);
            str = "'";
        }
        sb.append(str);
        try {
            Cursor rawQuery = getReadableDatabase().rawQuery(sb.toString(), (String[]) null);
            rawQuery.moveToFirst();
            int i = rawQuery.getInt(0);
            rawQuery.close();
            return i;
        } catch (SQLiteDatabaseLockedException | Exception unused) {
            return 0;
        }
    }

    public int getUncatCountM3UByType(String str) {
        try {
            Cursor rawQuery = getReadableDatabase().rawQuery("SELECT  COUNT(*) FROM iptv_live_streams_m3u WHERE categoryID='' AND user_id_referred='" + SharepreferenceDBHandler.getUserID(this.context) + "' AND stream_type='" + str + "'", (String[]) null);
            rawQuery.moveToFirst();
            int i = rawQuery.getInt(0);
            rawQuery.close();
            return i;
        } catch (SQLiteDatabaseLockedException | Exception unused) {
            return 0;
        }
    }

    public int getUncatCountSeries(String str) {
        StringBuilder sb;
        String str2;
        int userID = SharepreferenceDBHandler.getUserID(this.context);
        if (SharepreferenceDBHandler.getCurrentAPPType(this.context).equals("onestream_api")) {
            sb = new StringBuilder();
            str2 = "SELECT COUNT(*) FROM onestream_series_streams_v2 WHERE category_id_series_stream_v2 ='";
        } else {
            sb = new StringBuilder();
            str2 = "SELECT COUNT(*) FROM series_streams_v2 WHERE category_id_series_stream_v2 ='";
        }
        sb.append(str2);
        sb.append(str);
        sb.append("' AND ");
        sb.append("user_id_referred");
        sb.append(" = '");
        sb.append(userID);
        sb.append("'");
        try {
            Cursor rawQuery = getReadableDatabase().rawQuery(sb.toString(), (String[]) null);
            rawQuery.moveToFirst();
            int i = rawQuery.getInt(0);
            rawQuery.close();
            return i;
        } catch (SQLiteDatabaseLockedException | Exception unused) {
            return 0;
        }
    }

    public ImportStatusModel getdateDBStatus(String str) {
        String str2;
        int userID = SharepreferenceDBHandler.getUserID(this.context);
        String currentAPPType = SharepreferenceDBHandler.getCurrentAPPType(this.context);
        if (str.equals("epg")) {
            ArrayList activeEPGSource = getActiveEPGSource();
            str2 = "SELECT * FROM iptv_import_status WHERE type = '" + str + "' AND user_id_referred = '" + userID + "' AND app_type = '" + currentAPPType + "' AND source_ref_id = '" + ((activeEPGSource == null || activeEPGSource.size() <= 0) ? "0" : String.valueOf(((EPGSourcesModel) activeEPGSource.get(0)).getIdAuto())) + "'";
        } else {
            str2 = "SELECT * FROM iptv_import_status WHERE type = '" + str + "' AND user_id_referred = '" + userID + "' AND app_type = '" + currentAPPType + "'";
        }
        try {
            Cursor rawQuery = getReadableDatabase().rawQuery(str2, (String[]) null);
            ImportStatusModel importStatusModel = new ImportStatusModel();
            if (rawQuery.moveToFirst()) {
                do {
                    importStatusModel.setIdAuto(w.r0(rawQuery.getString(0)));
                    importStatusModel.setType(rawQuery.getString(1));
                    importStatusModel.setStatus(rawQuery.getString(2));
                    importStatusModel.setDate(rawQuery.getString(3));
                    importStatusModel.setTime(rawQuery.getString(4));
                    importStatusModel.setSourceRef(rawQuery.getString(7));
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
            return importStatusModel;
        } catch (SQLiteDatabaseLockedException | Exception unused) {
            return null;
        }
    }

    public void importDataStatusArrayList(ArrayList arrayList, String str) {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.beginTransaction();
            try {
                int userID = SharepreferenceDBHandler.getUserID(this.context);
                ContentValues contentValues = new ContentValues();
                int size = arrayList.size();
                if (size != 0) {
                    for (int i = 0; i < size; i++) {
                        contentValues.put("type", ((ImportStatusModel) arrayList.get(i)).getType());
                        contentValues.put("status", ((ImportStatusModel) arrayList.get(i)).getStatus());
                        contentValues.put("date", ((ImportStatusModel) arrayList.get(i)).getDate());
                        contentValues.put("time", ((ImportStatusModel) arrayList.get(i)).getTime());
                        contentValues.put("user_id_referred", Integer.valueOf(userID));
                        contentValues.put("app_type", str);
                        contentValues.put("source_ref_id", ((ImportStatusModel) arrayList.get(i)).getSourceRef());
                        writableDatabase.insert("iptv_import_status", (String) null, contentValues);
                    }
                }
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
            } catch (SQLiteDatabaseLockedException | Exception unused) {
                writableDatabase.endTransaction();
                Log.w("msg", "exception");
            }
        } catch (Exception unused2) {
        }
    }

    public int isStreamAvailable(String str, int i) {
        try {
            Cursor rawQuery = getReadableDatabase().rawQuery("SELECT  COUNT(*) FROM iptv_recent_watched_m3u WHERE url='" + str + "' AND user_id_referred='" + i + "'", (String[]) null);
            rawQuery.moveToFirst();
            int i2 = rawQuery.getInt(0);
            rawQuery.close();
            return i2;
        } catch (SQLiteDatabaseLockedException | Exception unused) {
            return 0;
        }
    }

    public int liveRecentlyWatchedCount(String str) {
        try {
            String currentAPPType = SharepreferenceDBHandler.getCurrentAPPType(this.context);
            Cursor rawQuery = getReadableDatabase().rawQuery("SELECT  COUNT(*) FROM iptv_live_watched WHERE user_id_referred='" + SharepreferenceDBHandler.getUserID(this.context) + "' AND app_type='" + currentAPPType + "' AND type='" + str + "'", (String[]) null);
            rawQuery.moveToFirst();
            int i = rawQuery.getInt(0);
            rawQuery.close();
            return i;
        } catch (SQLiteDatabaseLockedException | Exception unused) {
            return 0;
        }
    }

    public void makeEmptyAllTablesRecordsM3U() {
        int userID = SharepreferenceDBHandler.getUserID(this.context);
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.execSQL("DELETE FROM iptv_m3u_all_category WHERE user_id_referred='" + userID + "'");
            writableDatabase.close();
        } catch (SQLiteDatabaseLockedException | Exception unused) {
            Log.w("msg", "exception");
        }
    }

    public void makeEmptyEPG() {
        try {
            getReadableDatabase();
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.execSQL("delete from epg");
            writableDatabase.close();
        } catch (SQLiteDatabaseLockedException | SQLiteException unused) {
            Log.w("msg", "exception");
        }
    }

    public void makeEmptyEPGWithSourceRef(int i, String str) {
        try {
            String str2 = str.equals("m3u") ? "epg_m3u" : "epg";
            getWritableDatabase().execSQL("DELETE FROM " + str2 + " WHERE user_id_referred = '" + i + "'");
        } catch (SQLiteDatabaseLockedException | Exception unused) {
            Log.w("msg", "exception");
        }
    }

    public void makeEmptyLiveCategory() {
        try {
            int userID = SharepreferenceDBHandler.getUserID(this.context);
            getWritableDatabase().execSQL("DELETE FROM iptv_live_category WHERE user_id_referred = '" + userID + "'");
        } catch (SQLiteDatabaseLockedException | Exception unused) {
            Log.w("msg", "exception");
        }
    }

    public void makeEmptyLiveCategoryOneStream() {
        try {
            int userID = SharepreferenceDBHandler.getUserID(this.context);
            getWritableDatabase().execSQL("DELETE FROM iptv_onestream_live_category WHERE user_id_referred = '" + userID + "'");
        } catch (SQLiteDatabaseLockedException | Exception unused) {
            Log.w("msg", "exception");
        }
    }

    public void makeEmptyLiveCategoryStalker() {
        try {
            int userID = SharepreferenceDBHandler.getUserID(this.context);
            getWritableDatabase().execSQL("DELETE FROM iptv_stalker_live_category WHERE user_id_referred = '" + userID + "'");
        } catch (SQLiteDatabaseLockedException | Exception unused) {
            Log.w("msg", "exception");
        }
    }

    public void makeEmptyLiveStreams() {
        try {
            int userID = SharepreferenceDBHandler.getUserID(this.context);
            getReadableDatabase();
            getWritableDatabase().execSQL("delete from iptv_live_streams WHERE (stream_type LIKE '%live%' OR stream_type LIKE '%radio%' ) AND user_id_referred = '" + userID + "'");
        } catch (SQLiteDatabaseLockedException | Exception unused) {
            Log.w("msg", "exception");
        }
    }

    public void makeEmptyLiveStreamsOneStream() {
        try {
            int userID = SharepreferenceDBHandler.getUserID(this.context);
            getReadableDatabase();
            getWritableDatabase().execSQL("delete from onestream_iptv_live_streams WHERE (stream_type LIKE '%live%' OR stream_type LIKE '%radio%' ) AND user_id_referred = '" + userID + "'");
        } catch (SQLiteDatabaseLockedException | Exception unused) {
            Log.w("msg", "exception");
        }
    }

    public void makeEmptyLiveStreamsStalker() {
        try {
            int userID = SharepreferenceDBHandler.getUserID(this.context);
            getWritableDatabase().execSQL("delete from iptv_stalker_live_streams WHERE user_id_referred = '" + userID + "'");
        } catch (SQLiteDatabaseLockedException | Exception unused) {
            Log.w("msg", "exception");
        }
    }

    public void makeEmptyMovieCategory() {
        try {
            int userID = SharepreferenceDBHandler.getUserID(this.context);
            getWritableDatabase().execSQL("DELETE FROM iptv_movie_category WHERE user_id_referred = '" + userID + "'");
        } catch (SQLiteDatabaseLockedException | Exception unused) {
            Log.w("msg", "exception");
        }
    }

    public void makeEmptyMovieCategoryStalker() {
        try {
            int userID = SharepreferenceDBHandler.getUserID(this.context);
            getWritableDatabase().execSQL("DELETE FROM iptv_stalker_movie_category WHERE user_id_referred = '" + userID + "'");
        } catch (SQLiteDatabaseLockedException | Exception unused) {
            Log.w("msg", "exception");
        }
    }

    public void makeEmptyONESTREAMMovieCategory() {
        try {
            int userID = SharepreferenceDBHandler.getUserID(this.context);
            getReadableDatabase();
            getWritableDatabase().execSQL("delete from onestream_iptv_live_streams WHERE stream_type LIKE '%movie%' AND user_id_referred = '" + userID + "'");
        } catch (SQLiteDatabaseLockedException | Exception unused) {
            Log.w("msg", "exception");
        }
    }

    public void makeEmptyOneStreamSeriesCategories() {
        try {
            int userID = SharepreferenceDBHandler.getUserID(this.context);
            getWritableDatabase().execSQL("DELETE FROM onestream_series_category_v2 WHERE user_id_referred = '" + userID + "'");
        } catch (SQLiteDatabaseLockedException | Exception unused) {
            Log.w("msg", "exception");
        }
    }

    public void makeEmptyOneStreamSeriesStreams() {
        try {
            int userID = SharepreferenceDBHandler.getUserID(this.context);
            getWritableDatabase().execSQL("DELETE FROM onestream_series_streams_v2 WHERE user_id_referred = '" + userID + "'");
        } catch (SQLiteDatabaseLockedException | Exception unused) {
            Log.w("msg", "exception");
        }
    }

    public void makeEmptySeriesCategories() {
        try {
            int userID = SharepreferenceDBHandler.getUserID(this.context);
            getWritableDatabase().execSQL("DELETE FROM series_category_v2 WHERE user_id_referred = '" + userID + "'");
        } catch (SQLiteDatabaseLockedException | Exception unused) {
            Log.w("msg", "exception");
        }
    }

    public void makeEmptySeriesCategoriesStalker() {
        try {
            int userID = SharepreferenceDBHandler.getUserID(this.context);
            getWritableDatabase().execSQL("DELETE FROM iptv_stalker_series_category WHERE user_id_referred = '" + userID + "'");
        } catch (SQLiteDatabaseLockedException | Exception unused) {
            Log.w("msg", "exception");
        }
    }

    public void makeEmptySeriesStreams() {
        StringBuilder sb;
        try {
            int userID = SharepreferenceDBHandler.getUserID(this.context);
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (SharepreferenceDBHandler.getCurrentAPPType(this.context).equals("onestream_api")) {
                sb = new StringBuilder();
                sb.append("DELETE FROM onestream_series_streams_v2 WHERE user_id_referred = '");
                sb.append(userID);
                sb.append("'");
            } else {
                sb = new StringBuilder();
                sb.append("DELETE FROM series_streams_v2 WHERE user_id_referred = '");
                sb.append(userID);
                sb.append("'");
            }
            writableDatabase.execSQL(sb.toString());
        } catch (SQLiteDatabaseLockedException | Exception unused) {
            Log.w("msg", "exception");
        }
    }

    public void makeEmptyVODStreams() {
        try {
            int userID = SharepreferenceDBHandler.getUserID(this.context);
            getReadableDatabase();
            getWritableDatabase().execSQL("delete from iptv_live_streams WHERE stream_type LIKE '%movie%' AND user_id_referred = '" + userID + "'");
        } catch (SQLiteDatabaseLockedException | Exception unused) {
            Log.w("msg", "exception");
        }
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(this.CREATE_LIVE_CATEGORY_TABLE);
        sQLiteDatabase.execSQL(this.CREATE_MOVIE_CATEGORY_TABLE);
        sQLiteDatabase.execSQL(this.CREATE_EPG_TABLE);
        sQLiteDatabase.execSQL(this.CREATE_PASSWORD_TABLE);
        sQLiteDatabase.execSQL(this.CREATE_PASSWORD_STATUS_TABLE);
        sQLiteDatabase.execSQL(this.CREATE_LIVE_STREAM_CATEGORY_TABLE);
        sQLiteDatabase.execSQL(this.CREATE_LIVE_AVAILABLE_CHANELS);
        sQLiteDatabase.execSQL(this.CREATE_VOD_TABLE);
        sQLiteDatabase.execSQL(this.CREATE_MAG_PORTAL_TABLE);
        sQLiteDatabase.execSQL(this.CREATE_LIVE_AVAILABLE_CHANELS_ALL_M3U);
        sQLiteDatabase.execSQL(this.CREATE_M3U_CATEGORY_TABLE);
        sQLiteDatabase.execSQL(this.CREATE_FAV_M3U_TABLE);
        sQLiteDatabase.execSQL(this.CREATE_M3U_SERIES_STREAMS_TABLE);
        sQLiteDatabase.execSQL(this.CREATE_LIVE_AVAILABLE_CHANELS_M3U);
        sQLiteDatabase.execSQL(this.CREATE_LIVE_CATEGORY_TABLE_M3U);
        sQLiteDatabase.execSQL(this.CREATE_MOVIE_CATEGORY_TABLE_M3U);
        sQLiteDatabase.execSQL(this.CREATE_SERIES_CATEGORY_TABLE_M3U);
        sQLiteDatabase.execSQL(this.CREATE_PASSWORD_STATUS_TABLE_M3U);
        sQLiteDatabase.execSQL(this.CREATE_PASSWORD_TABLE_M3U);
        sQLiteDatabase.execSQL(this.CREATE_RECENT_WATCHED_M3U);
        sQLiteDatabase.execSQL(this.CREATE_SERIES_CATEGORY_TABLE);
        sQLiteDatabase.execSQL(this.CREATE_SERIES_STREAMS);
        sQLiteDatabase.execSQL(this.CREATE_PASSWORD_TABLE_M3U);
        sQLiteDatabase.execSQL(this.CREATE_DB_UPDATED_STATUS_TABLE);
        sQLiteDatabase.execSQL(this.CREATE_EPG_M3U_TABLE);
        sQLiteDatabase.execSQL(this.CREATE_TABLE_EPG_SOURCES);
        sQLiteDatabase.execSQL(this.CREATE_TABLE_EPG_SOURCES_M3U);
        sQLiteDatabase.execSQL(this.CREATE_LIVE_WATCHED_TABLE);
        sQLiteDatabase.execSQL(this.CREATE_LIVE_STALKER_CATEGORY_TABLE);
        sQLiteDatabase.execSQL(this.CREATE_LIVE_STALKER_AVAILABLE_CHANNELS);
        sQLiteDatabase.execSQL(this.CREATE_MOVIE_STALKER_CATEGORY_TABLE);
        sQLiteDatabase.execSQL(this.CREATE_SERIES_STALKER_CATEGORY_TABLE);
        sQLiteDatabase.execSQL(this.CREATE_ONESTREAM_SERIES_STREAMS);
        sQLiteDatabase.execSQL(this.CREATE_ONESTREAM_SERIES_CATEGORY_TABLE);
        sQLiteDatabase.execSQL(this.CREATE_LIVE_ONESTREAM_AVAILABLE_CHANELS);
        sQLiteDatabase.execSQL(this.CREATE_ONESTREAM_MOVIE_CATEGORY_TABLE);
        sQLiteDatabase.execSQL(this.CREATE_ONESTREAM_LIVE_CATEGORY_TABLE);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i < 3) {
            sQLiteDatabase.execSQL(this.ALTER_PASSWORD_TABLE_1);
            sQLiteDatabase.execSQL(this.ALTER_PASSWORD_STATUS_TABLE_2);
        }
        if (i < 4) {
            sQLiteDatabase.execSQL(this.CREATE_LIVE_AVAILABLE_CHANELS_ALL_M3U);
            sQLiteDatabase.execSQL(this.CREATE_M3U_CATEGORY_TABLE);
            sQLiteDatabase.execSQL(this.CREATE_FAV_M3U_TABLE);
            sQLiteDatabase.execSQL(this.CREATE_M3U_SERIES_STREAMS_TABLE);
            sQLiteDatabase.execSQL(this.CREATE_LIVE_AVAILABLE_CHANELS_M3U);
            sQLiteDatabase.execSQL(this.CREATE_LIVE_CATEGORY_TABLE_M3U);
            sQLiteDatabase.execSQL(this.CREATE_MOVIE_CATEGORY_TABLE_M3U);
            sQLiteDatabase.execSQL(this.CREATE_SERIES_CATEGORY_TABLE_M3U);
            sQLiteDatabase.execSQL(this.CREATE_PASSWORD_STATUS_TABLE_M3U);
            sQLiteDatabase.execSQL(this.CREATE_PASSWORD_TABLE_M3U);
            sQLiteDatabase.execSQL(this.CREATE_RECENT_WATCHED_M3U);
        }
        if (i < 5) {
            sQLiteDatabase.execSQL(this.ALTER_RATING_COLUMN1);
            sQLiteDatabase.execSQL(this.ALTER_RATING_COLUMN2);
        }
        if (i < 6) {
            sQLiteDatabase.execSQL(this.CREATE_DB_UPDATED_STATUS_TABLE);
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS iptv_live_category");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS iptv_movie_category");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS series_category_v2");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS iptv_live_streams");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS series_streams_v2");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS epg");
            sQLiteDatabase.execSQL(this.CREATE_LIVE_CATEGORY_TABLE);
            sQLiteDatabase.execSQL(this.CREATE_MOVIE_CATEGORY_TABLE);
            sQLiteDatabase.execSQL(this.CREATE_SERIES_CATEGORY_TABLE);
            sQLiteDatabase.execSQL(this.CREATE_LIVE_AVAILABLE_CHANELS);
            sQLiteDatabase.execSQL(this.CREATE_SERIES_STREAMS);
            sQLiteDatabase.execSQL(this.CREATE_EPG_TABLE);
            sQLiteDatabase.execSQL(this.CREATE_EPG_M3U_TABLE);
            sQLiteDatabase.execSQL(this.CREATE_TABLE_EPG_SOURCES);
            sQLiteDatabase.execSQL(this.CREATE_TABLE_EPG_SOURCES_M3U);
        }
        if (i < 7) {
            sQLiteDatabase.execSQL(this.CREATE_LIVE_WATCHED_TABLE);
        }
        if (i < 8) {
            sQLiteDatabase.execSQL(this.CREATE_LIVE_STALKER_CATEGORY_TABLE);
            sQLiteDatabase.execSQL(this.CREATE_LIVE_STALKER_AVAILABLE_CHANNELS);
            sQLiteDatabase.execSQL(this.CREATE_MOVIE_STALKER_CATEGORY_TABLE);
            sQLiteDatabase.execSQL(this.CREATE_SERIES_STALKER_CATEGORY_TABLE);
        }
        if (i < 9) {
            sQLiteDatabase.execSQL(this.CREATE_ONESTREAM_SERIES_STREAMS);
            sQLiteDatabase.execSQL(this.CREATE_ONESTREAM_SERIES_CATEGORY_TABLE);
            sQLiteDatabase.execSQL(this.CREATE_LIVE_ONESTREAM_AVAILABLE_CHANELS);
            sQLiteDatabase.execSQL(this.CREATE_ONESTREAM_MOVIE_CATEGORY_TABLE);
            sQLiteDatabase.execSQL(this.CREATE_ONESTREAM_LIVE_CATEGORY_TABLE);
        }
        if (i < 11) {
            sQLiteDatabase.execSQL(this.ALTER_URL_FIREBASE_DB_CHANNNELS_ALL_M3U);
            sQLiteDatabase.execSQL(this.ALTER_URL_FIREBASE_DB_WATCHED_M3U);
            sQLiteDatabase.execSQL(this.ALTER_URL_FIREBASE_DB_CHANNNELS_M3U);
        }
        if (i < 12) {
            sQLiteDatabase.execSQL(this.ALTER_TYPE_COLUMN_RECENT_WATCHED_CHANNNELS);
        }
    }

    public void removeAvailableChannelM3U(String str) {
        String str2;
        try {
            int userID = SharepreferenceDBHandler.getUserID(this.context);
            getReadableDatabase();
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (str.equals("0")) {
                str2 = "DELETE FROM iptv_live_streams_m3u WHERE user_id_referred='" + userID + "'";
            } else {
                str2 = "DELETE FROM iptv_live_streams_m3u WHERE categoryID ='" + str + "' AND user_id_referred='" + userID + "'";
            }
            writableDatabase.execSQL(str2);
        } catch (SQLiteDatabaseLockedException | Exception unused) {
            Log.w("msg", "exception");
        }
    }

    public void removeLiveCategoriesM3U(String str) {
        String str2;
        try {
            int userID = SharepreferenceDBHandler.getUserID(this.context);
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (str.equals("0")) {
                str2 = "DELETE FROM iptv_live_category_m3u WHERE user_id_referred='" + userID + "'";
            } else {
                str2 = "DELETE FROM iptv_live_category_m3u WHERE categoryID ='" + str + "' AND user_id_referred='" + userID + "'";
            }
            writableDatabase.execSQL(str2);
        } catch (SQLiteDatabaseLockedException | Exception unused) {
            Log.w("msg", "exception");
        }
    }

    public void removeMovieCategoriesM3U(String str) {
        String str2;
        try {
            int userID = SharepreferenceDBHandler.getUserID(this.context);
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (str.equals("0")) {
                str2 = "DELETE FROM iptv_movie_category_m3u WHERE user_id_referred='" + userID + "'";
            } else {
                str2 = "DELETE FROM iptv_movie_category_m3u WHERE categoryID ='" + str + "' AND user_id_referred='" + userID + "'";
            }
            writableDatabase.execSQL(str2);
        } catch (SQLiteDatabaseLockedException | Exception unused) {
            Log.w("msg", "exception");
        }
    }

    public void removeSeriesCategoriesM3U(String str) {
        String str2;
        try {
            int userID = SharepreferenceDBHandler.getUserID(this.context);
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (str.equals("0")) {
                str2 = "DELETE FROM iptv_series_category_m3u WHERE user_id_referred='" + userID + "'";
            } else {
                str2 = "DELETE FROM iptv_series_category_m3u WHERE categoryID ='" + str + "' AND user_id_referred='" + userID + "'";
            }
            writableDatabase.execSQL(str2);
        } catch (SQLiteDatabaseLockedException | Exception unused) {
            Log.w("msg", "exception");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0094 A[Catch: Exception -> 0x00b3, SQLiteDatabaseLockedException -> 0x00b7, TryCatch #2 {SQLiteDatabaseLockedException -> 0x00b7, Exception -> 0x00b3, blocks: (B:6:0x001a, B:8:0x0061, B:10:0x0067, B:14:0x008e, B:16:0x0094, B:18:0x00a9, B:22:0x00af, B:26:0x0080, B:28:0x0084), top: B:5:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00ad  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean upDatePassword(java.lang.String r9, java.lang.String r10, int r11) {
        /*
            r8 = this;
            java.lang.String r0 = "exception"
            java.lang.String r1 = "msg"
            java.lang.String r2 = ""
            android.content.Context r3 = r8.context
            java.lang.String r3 = com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler.getCurrentAPPType(r3)
            java.lang.String r4 = "m3u"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L17
            java.lang.String r3 = "iptv_password_table_m3u"
            goto L19
        L17:
            java.lang.String r3 = "iptv_password_table"
        L19:
            r4 = 0
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lb3 android.database.sqlite.SQLiteDatabaseLockedException -> Lb7
            r5.<init>()     // Catch: java.lang.Exception -> Lb3 android.database.sqlite.SQLiteDatabaseLockedException -> Lb7
            java.lang.String r6 = "SELECT rowid FROM "
            r5.append(r6)     // Catch: java.lang.Exception -> Lb3 android.database.sqlite.SQLiteDatabaseLockedException -> Lb7
            r5.append(r3)     // Catch: java.lang.Exception -> Lb3 android.database.sqlite.SQLiteDatabaseLockedException -> Lb7
            java.lang.String r6 = " WHERE "
            r5.append(r6)     // Catch: java.lang.Exception -> Lb3 android.database.sqlite.SQLiteDatabaseLockedException -> Lb7
            java.lang.String r6 = "user_detail"
            r5.append(r6)     // Catch: java.lang.Exception -> Lb3 android.database.sqlite.SQLiteDatabaseLockedException -> Lb7
            java.lang.String r6 = " = '"
            r5.append(r6)     // Catch: java.lang.Exception -> Lb3 android.database.sqlite.SQLiteDatabaseLockedException -> Lb7
            r5.append(r9)     // Catch: java.lang.Exception -> Lb3 android.database.sqlite.SQLiteDatabaseLockedException -> Lb7
            java.lang.String r9 = "' AND "
            r5.append(r9)     // Catch: java.lang.Exception -> Lb3 android.database.sqlite.SQLiteDatabaseLockedException -> Lb7
            java.lang.String r9 = "user_id_referred"
            r5.append(r9)     // Catch: java.lang.Exception -> Lb3 android.database.sqlite.SQLiteDatabaseLockedException -> Lb7
            java.lang.String r9 = " = "
            r5.append(r9)     // Catch: java.lang.Exception -> Lb3 android.database.sqlite.SQLiteDatabaseLockedException -> Lb7
            r5.append(r11)     // Catch: java.lang.Exception -> Lb3 android.database.sqlite.SQLiteDatabaseLockedException -> Lb7
            r5.append(r2)     // Catch: java.lang.Exception -> Lb3 android.database.sqlite.SQLiteDatabaseLockedException -> Lb7
            java.lang.String r9 = r5.toString()     // Catch: java.lang.Exception -> Lb3 android.database.sqlite.SQLiteDatabaseLockedException -> Lb7
            r8.getReadableDatabase()     // Catch: java.lang.Exception -> Lb3 android.database.sqlite.SQLiteDatabaseLockedException -> Lb7
            android.database.sqlite.SQLiteDatabase r11 = r8.getWritableDatabase()     // Catch: java.lang.Exception -> Lb3 android.database.sqlite.SQLiteDatabaseLockedException -> Lb7
            r5 = 0
            android.database.Cursor r9 = r11.rawQuery(r9, r5)     // Catch: java.lang.Exception -> Lb3 android.database.sqlite.SQLiteDatabaseLockedException -> Lb7
            r5 = 1
            if (r9 == 0) goto L80
            boolean r6 = r9.moveToFirst()     // Catch: java.lang.Exception -> Lb3 android.database.sqlite.SQLiteDatabaseLockedException -> Lb7
            if (r6 == 0) goto L8d
        L67:
            java.lang.String r6 = "id_password"
            int r6 = r9.getColumnIndex(r6)     // Catch: java.lang.Exception -> Lb3 android.database.sqlite.SQLiteDatabaseLockedException -> Lb7
            java.lang.String r6 = r9.getString(r6)     // Catch: java.lang.Exception -> Lb3 android.database.sqlite.SQLiteDatabaseLockedException -> Lb7
            int r6 = java.lang.Integer.parseInt(r6)     // Catch: java.lang.Exception -> Lb3 android.database.sqlite.SQLiteDatabaseLockedException -> Lb7
            java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch: java.lang.Exception -> Lb3 android.database.sqlite.SQLiteDatabaseLockedException -> Lb7
            boolean r7 = r9.moveToNext()     // Catch: java.lang.Exception -> Lb3 android.database.sqlite.SQLiteDatabaseLockedException -> Lb7
            if (r7 != 0) goto L67
            goto L8e
        L80:
            android.content.Context r6 = r8.context     // Catch: java.lang.Exception -> Lb3 android.database.sqlite.SQLiteDatabaseLockedException -> Lb7
            if (r6 == 0) goto L8d
            java.lang.String r7 = "cursor is null"
            android.widget.Toast r6 = android.widget.Toast.makeText(r6, r7, r5)     // Catch: java.lang.Exception -> Lb3 android.database.sqlite.SQLiteDatabaseLockedException -> Lb7
            r6.show()     // Catch: java.lang.Exception -> Lb3 android.database.sqlite.SQLiteDatabaseLockedException -> Lb7
        L8d:
            r6 = r2
        L8e:
            boolean r2 = r6.equals(r2)     // Catch: java.lang.Exception -> Lb3 android.database.sqlite.SQLiteDatabaseLockedException -> Lb7
            if (r2 != 0) goto Lad
            android.content.ContentValues r2 = new android.content.ContentValues     // Catch: java.lang.Exception -> Lb3 android.database.sqlite.SQLiteDatabaseLockedException -> Lb7
            r2.<init>()     // Catch: java.lang.Exception -> Lb3 android.database.sqlite.SQLiteDatabaseLockedException -> Lb7
            java.lang.String r7 = "password"
            r2.put(r7, r10)     // Catch: java.lang.Exception -> Lb3 android.database.sqlite.SQLiteDatabaseLockedException -> Lb7
            java.lang.String r10 = "id_password= ?"
            java.lang.String[] r6 = new java.lang.String[]{r6}     // Catch: java.lang.Exception -> Lb3 android.database.sqlite.SQLiteDatabaseLockedException -> Lb7
            r11.update(r3, r2, r10, r6)     // Catch: java.lang.Exception -> Lb3 android.database.sqlite.SQLiteDatabaseLockedException -> Lb7
            if (r9 == 0) goto Lac
            r9.close()     // Catch: java.lang.Exception -> Lb3 android.database.sqlite.SQLiteDatabaseLockedException -> Lb7
        Lac:
            return r5
        Lad:
            if (r9 == 0) goto Lb2
            r9.close()     // Catch: java.lang.Exception -> Lb3 android.database.sqlite.SQLiteDatabaseLockedException -> Lb7
        Lb2:
            return r4
        Lb3:
            android.util.Log.w(r1, r0)
            return r4
        Lb7:
            android.util.Log.w(r1, r0)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler.upDatePassword(java.lang.String, java.lang.String, int):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0071 A[Catch: SQLiteException -> 0x0097, SQLiteDatabaseLockedException -> 0x009b, TryCatch #2 {SQLiteException -> 0x0097, SQLiteDatabaseLockedException -> 0x009b, blocks: (B:3:0x0005, B:6:0x003e, B:8:0x0044, B:12:0x006b, B:14:0x0071, B:16:0x008d, B:20:0x0093, B:24:0x005d, B:26:0x0061), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0091  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean updateDBStatusAndDate(java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.String r11) {
        /*
            r7 = this;
            java.lang.String r0 = "exception"
            java.lang.String r1 = "msg"
            r2 = 0
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: android.database.sqlite.SQLiteException -> L97 android.database.sqlite.SQLiteDatabaseLockedException -> L9b
            r3.<init>()     // Catch: android.database.sqlite.SQLiteException -> L97 android.database.sqlite.SQLiteDatabaseLockedException -> L9b
            java.lang.String r4 = "SELECT rowid FROM iptv_db_update_status WHERE iptv_db_updated_status_category = '"
            r3.append(r4)     // Catch: android.database.sqlite.SQLiteException -> L97 android.database.sqlite.SQLiteDatabaseLockedException -> L9b
            r3.append(r8)     // Catch: android.database.sqlite.SQLiteException -> L97 android.database.sqlite.SQLiteDatabaseLockedException -> L9b
            java.lang.String r8 = "' AND "
            r3.append(r8)     // Catch: android.database.sqlite.SQLiteException -> L97 android.database.sqlite.SQLiteDatabaseLockedException -> L9b
            java.lang.String r8 = "iptv_db_updated_status_category_id"
            r3.append(r8)     // Catch: android.database.sqlite.SQLiteException -> L97 android.database.sqlite.SQLiteDatabaseLockedException -> L9b
            java.lang.String r8 = " = '"
            r3.append(r8)     // Catch: android.database.sqlite.SQLiteException -> L97 android.database.sqlite.SQLiteDatabaseLockedException -> L9b
            r3.append(r9)     // Catch: android.database.sqlite.SQLiteException -> L97 android.database.sqlite.SQLiteDatabaseLockedException -> L9b
            java.lang.String r8 = "'"
            r3.append(r8)     // Catch: android.database.sqlite.SQLiteException -> L97 android.database.sqlite.SQLiteDatabaseLockedException -> L9b
            java.lang.String r8 = r3.toString()     // Catch: android.database.sqlite.SQLiteException -> L97 android.database.sqlite.SQLiteDatabaseLockedException -> L9b
            r7.getReadableDatabase()     // Catch: android.database.sqlite.SQLiteException -> L97 android.database.sqlite.SQLiteDatabaseLockedException -> L9b
            android.database.sqlite.SQLiteDatabase r9 = r7.getWritableDatabase()     // Catch: android.database.sqlite.SQLiteException -> L97 android.database.sqlite.SQLiteDatabaseLockedException -> L9b
            r3 = 0
            android.database.Cursor r8 = r9.rawQuery(r8, r3)     // Catch: android.database.sqlite.SQLiteException -> L97 android.database.sqlite.SQLiteDatabaseLockedException -> L9b
            r3 = 1
            java.lang.String r4 = ""
            if (r8 == 0) goto L5d
            boolean r5 = r8.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L97 android.database.sqlite.SQLiteDatabaseLockedException -> L9b
            if (r5 == 0) goto L6a
        L44:
            java.lang.String r5 = "iptv_db_update_status_id"
            int r5 = r8.getColumnIndex(r5)     // Catch: android.database.sqlite.SQLiteException -> L97 android.database.sqlite.SQLiteDatabaseLockedException -> L9b
            java.lang.String r5 = r8.getString(r5)     // Catch: android.database.sqlite.SQLiteException -> L97 android.database.sqlite.SQLiteDatabaseLockedException -> L9b
            int r5 = java.lang.Integer.parseInt(r5)     // Catch: android.database.sqlite.SQLiteException -> L97 android.database.sqlite.SQLiteDatabaseLockedException -> L9b
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch: android.database.sqlite.SQLiteException -> L97 android.database.sqlite.SQLiteDatabaseLockedException -> L9b
            boolean r6 = r8.moveToNext()     // Catch: android.database.sqlite.SQLiteException -> L97 android.database.sqlite.SQLiteDatabaseLockedException -> L9b
            if (r6 != 0) goto L44
            goto L6b
        L5d:
            android.content.Context r5 = r7.context     // Catch: android.database.sqlite.SQLiteException -> L97 android.database.sqlite.SQLiteDatabaseLockedException -> L9b
            if (r5 == 0) goto L6a
            java.lang.String r6 = "cursor is null"
            android.widget.Toast r5 = android.widget.Toast.makeText(r5, r6, r3)     // Catch: android.database.sqlite.SQLiteException -> L97 android.database.sqlite.SQLiteDatabaseLockedException -> L9b
            r5.show()     // Catch: android.database.sqlite.SQLiteException -> L97 android.database.sqlite.SQLiteDatabaseLockedException -> L9b
        L6a:
            r5 = r4
        L6b:
            boolean r4 = r5.equals(r4)     // Catch: android.database.sqlite.SQLiteException -> L97 android.database.sqlite.SQLiteDatabaseLockedException -> L9b
            if (r4 != 0) goto L91
            android.content.ContentValues r4 = new android.content.ContentValues     // Catch: android.database.sqlite.SQLiteException -> L97 android.database.sqlite.SQLiteDatabaseLockedException -> L9b
            r4.<init>()     // Catch: android.database.sqlite.SQLiteException -> L97 android.database.sqlite.SQLiteDatabaseLockedException -> L9b
            java.lang.String r6 = "iptv_db_updated_status_state"
            r4.put(r6, r10)     // Catch: android.database.sqlite.SQLiteException -> L97 android.database.sqlite.SQLiteDatabaseLockedException -> L9b
            java.lang.String r10 = "iptv_db_updated_status_last_updated_date"
            r4.put(r10, r11)     // Catch: android.database.sqlite.SQLiteException -> L97 android.database.sqlite.SQLiteDatabaseLockedException -> L9b
            java.lang.String r10 = "iptv_db_update_status"
            java.lang.String r11 = "iptv_db_update_status_id= ?"
            java.lang.String[] r5 = new java.lang.String[]{r5}     // Catch: android.database.sqlite.SQLiteException -> L97 android.database.sqlite.SQLiteDatabaseLockedException -> L9b
            r9.update(r10, r4, r11, r5)     // Catch: android.database.sqlite.SQLiteException -> L97 android.database.sqlite.SQLiteDatabaseLockedException -> L9b
            if (r8 == 0) goto L90
            r8.close()     // Catch: android.database.sqlite.SQLiteException -> L97 android.database.sqlite.SQLiteDatabaseLockedException -> L9b
        L90:
            return r3
        L91:
            if (r8 == 0) goto L96
            r8.close()     // Catch: android.database.sqlite.SQLiteException -> L97 android.database.sqlite.SQLiteDatabaseLockedException -> L9b
        L96:
            return r2
        L97:
            android.util.Log.w(r1, r0)
            return r2
        L9b:
            android.util.Log.w(r1, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler.updateDBStatusAndDate(java.lang.String, java.lang.String, java.lang.String, java.lang.String):boolean");
    }

    public void updateEPGSource(String str, String str2, String str3, String str4, int i) {
        int userID = SharepreferenceDBHandler.getUserID(this.context);
        String str5 = SharepreferenceDBHandler.getCurrentAPPType(this.context).equals("m3u") ? "iptv_epg_sources_m3u" : "iptv_epg_sources";
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("user_id_referred", Integer.valueOf(userID));
            contentValues2.put("name", str);
            contentValues2.put("source_type", str2);
            contentValues2.put("epgurl", str3);
            contentValues2.put("default_source", str4);
            if (str4.equals("1")) {
                contentValues.put("default_source", "0");
                writableDatabase.update(str5, contentValues, "user_id_referred = ?", new String[]{String.valueOf(userID)});
            }
            writableDatabase.update(str5, contentValues2, "auto_id = ? AND user_id_referred = ?", new String[]{String.valueOf(i), String.valueOf(userID)});
        } catch (SQLiteDatabaseLockedException | Exception unused) {
        }
    }

    public void updateImportStatus(String str, String str2) {
        try {
            int userID = SharepreferenceDBHandler.getUserID(this.context);
            String currentAPPType = SharepreferenceDBHandler.getCurrentAPPType(this.context);
            SQLiteDatabase writableDatabase = getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("status", str2);
            contentValues.put("date", w.q());
            contentValues.put("time", Long.valueOf(System.currentTimeMillis()));
            writableDatabase.update("iptv_import_status", contentValues, "type = ? AND user_id_referred = ? AND app_type = ?", new String[]{String.valueOf(str), String.valueOf(userID), String.valueOf(currentAPPType)});
        } catch (SQLiteDatabaseLockedException | Exception unused) {
            Log.w("msg", "exception");
        }
    }

    public void updatePanelEPGSourceToDefault() {
        int userID = SharepreferenceDBHandler.getUserID(this.context);
        String str = SharepreferenceDBHandler.getCurrentAPPType(this.context).equals("m3u") ? "iptv_epg_sources_m3u" : "iptv_epg_sources";
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("default_source", "1");
            writableDatabase.update(str, contentValues, "user_id_referred = ? AND source_type = ?", new String[]{String.valueOf(userID), "panel"});
        } catch (SQLiteDatabaseLockedException | Exception unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00a7 A[Catch: Exception -> 0x00c6, SQLiteDatabaseLockedException -> 0x00ca, TryCatch #2 {SQLiteDatabaseLockedException -> 0x00ca, Exception -> 0x00c6, blocks: (B:6:0x0023, B:8:0x0074, B:10:0x007a, B:14:0x00a1, B:16:0x00a7, B:18:0x00bc, B:22:0x00c2, B:26:0x0093, B:28:0x0097), top: B:5:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00c0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean updatePasswordStatus(java.lang.String r10, java.lang.String r11, java.lang.String r12, int r13) {
        /*
            r9 = this;
            java.lang.String r0 = "exception"
            java.lang.String r1 = "msg"
            java.lang.String r2 = "' AND "
            java.lang.String r3 = " = '"
            java.lang.String r4 = ""
            android.content.Context r5 = r9.context
            java.lang.String r5 = com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler.getCurrentAPPType(r5)
            java.lang.String r6 = "m3u"
            boolean r6 = r5.equals(r6)
            if (r6 == 0) goto L1b
            java.lang.String r5 = "iptv_password_status_table_m3u"
            goto L22
        L1b:
            java.lang.String r6 = "onestream_api"
            r5.equals(r6)
            java.lang.String r5 = "iptv_password_status_table"
        L22:
            r6 = 0
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lc6 android.database.sqlite.SQLiteDatabaseLockedException -> Lca
            r7.<init>()     // Catch: java.lang.Exception -> Lc6 android.database.sqlite.SQLiteDatabaseLockedException -> Lca
            java.lang.String r8 = "SELECT rowid FROM "
            r7.append(r8)     // Catch: java.lang.Exception -> Lc6 android.database.sqlite.SQLiteDatabaseLockedException -> Lca
            r7.append(r5)     // Catch: java.lang.Exception -> Lc6 android.database.sqlite.SQLiteDatabaseLockedException -> Lca
            java.lang.String r8 = " WHERE "
            r7.append(r8)     // Catch: java.lang.Exception -> Lc6 android.database.sqlite.SQLiteDatabaseLockedException -> Lca
            java.lang.String r8 = "password_user_detail"
            r7.append(r8)     // Catch: java.lang.Exception -> Lc6 android.database.sqlite.SQLiteDatabaseLockedException -> Lca
            r7.append(r3)     // Catch: java.lang.Exception -> Lc6 android.database.sqlite.SQLiteDatabaseLockedException -> Lca
            r7.append(r10)     // Catch: java.lang.Exception -> Lc6 android.database.sqlite.SQLiteDatabaseLockedException -> Lca
            r7.append(r2)     // Catch: java.lang.Exception -> Lc6 android.database.sqlite.SQLiteDatabaseLockedException -> Lca
            java.lang.String r10 = "password_status_cat_id"
            r7.append(r10)     // Catch: java.lang.Exception -> Lc6 android.database.sqlite.SQLiteDatabaseLockedException -> Lca
            r7.append(r3)     // Catch: java.lang.Exception -> Lc6 android.database.sqlite.SQLiteDatabaseLockedException -> Lca
            r7.append(r11)     // Catch: java.lang.Exception -> Lc6 android.database.sqlite.SQLiteDatabaseLockedException -> Lca
            r7.append(r2)     // Catch: java.lang.Exception -> Lc6 android.database.sqlite.SQLiteDatabaseLockedException -> Lca
            java.lang.String r10 = "user_id_referred"
            r7.append(r10)     // Catch: java.lang.Exception -> Lc6 android.database.sqlite.SQLiteDatabaseLockedException -> Lca
            java.lang.String r10 = " ="
            r7.append(r10)     // Catch: java.lang.Exception -> Lc6 android.database.sqlite.SQLiteDatabaseLockedException -> Lca
            r7.append(r13)     // Catch: java.lang.Exception -> Lc6 android.database.sqlite.SQLiteDatabaseLockedException -> Lca
            r7.append(r4)     // Catch: java.lang.Exception -> Lc6 android.database.sqlite.SQLiteDatabaseLockedException -> Lca
            java.lang.String r10 = r7.toString()     // Catch: java.lang.Exception -> Lc6 android.database.sqlite.SQLiteDatabaseLockedException -> Lca
            r9.getReadableDatabase()     // Catch: java.lang.Exception -> Lc6 android.database.sqlite.SQLiteDatabaseLockedException -> Lca
            android.database.sqlite.SQLiteDatabase r11 = r9.getWritableDatabase()     // Catch: java.lang.Exception -> Lc6 android.database.sqlite.SQLiteDatabaseLockedException -> Lca
            r13 = 0
            android.database.Cursor r10 = r11.rawQuery(r10, r13)     // Catch: java.lang.Exception -> Lc6 android.database.sqlite.SQLiteDatabaseLockedException -> Lca
            r13 = 1
            if (r10 == 0) goto L93
            boolean r2 = r10.moveToFirst()     // Catch: java.lang.Exception -> Lc6 android.database.sqlite.SQLiteDatabaseLockedException -> Lca
            if (r2 == 0) goto La0
        L7a:
            java.lang.String r2 = "id_password_status"
            int r2 = r10.getColumnIndex(r2)     // Catch: java.lang.Exception -> Lc6 android.database.sqlite.SQLiteDatabaseLockedException -> Lca
            java.lang.String r2 = r10.getString(r2)     // Catch: java.lang.Exception -> Lc6 android.database.sqlite.SQLiteDatabaseLockedException -> Lca
            int r2 = java.lang.Integer.parseInt(r2)     // Catch: java.lang.Exception -> Lc6 android.database.sqlite.SQLiteDatabaseLockedException -> Lca
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch: java.lang.Exception -> Lc6 android.database.sqlite.SQLiteDatabaseLockedException -> Lca
            boolean r3 = r10.moveToNext()     // Catch: java.lang.Exception -> Lc6 android.database.sqlite.SQLiteDatabaseLockedException -> Lca
            if (r3 != 0) goto L7a
            goto La1
        L93:
            android.content.Context r2 = r9.context     // Catch: java.lang.Exception -> Lc6 android.database.sqlite.SQLiteDatabaseLockedException -> Lca
            if (r2 == 0) goto La0
            java.lang.String r3 = "cursor is null"
            android.widget.Toast r2 = android.widget.Toast.makeText(r2, r3, r13)     // Catch: java.lang.Exception -> Lc6 android.database.sqlite.SQLiteDatabaseLockedException -> Lca
            r2.show()     // Catch: java.lang.Exception -> Lc6 android.database.sqlite.SQLiteDatabaseLockedException -> Lca
        La0:
            r2 = r4
        La1:
            boolean r3 = r2.equals(r4)     // Catch: java.lang.Exception -> Lc6 android.database.sqlite.SQLiteDatabaseLockedException -> Lca
            if (r3 != 0) goto Lc0
            android.content.ContentValues r3 = new android.content.ContentValues     // Catch: java.lang.Exception -> Lc6 android.database.sqlite.SQLiteDatabaseLockedException -> Lca
            r3.<init>()     // Catch: java.lang.Exception -> Lc6 android.database.sqlite.SQLiteDatabaseLockedException -> Lca
            java.lang.String r4 = "password_status"
            r3.put(r4, r12)     // Catch: java.lang.Exception -> Lc6 android.database.sqlite.SQLiteDatabaseLockedException -> Lca
            java.lang.String r12 = "id_password_status= ?"
            java.lang.String[] r2 = new java.lang.String[]{r2}     // Catch: java.lang.Exception -> Lc6 android.database.sqlite.SQLiteDatabaseLockedException -> Lca
            r11.update(r5, r3, r12, r2)     // Catch: java.lang.Exception -> Lc6 android.database.sqlite.SQLiteDatabaseLockedException -> Lca
            if (r10 == 0) goto Lbf
            r10.close()     // Catch: java.lang.Exception -> Lc6 android.database.sqlite.SQLiteDatabaseLockedException -> Lca
        Lbf:
            return r13
        Lc0:
            if (r10 == 0) goto Lc5
            r10.close()     // Catch: java.lang.Exception -> Lc6 android.database.sqlite.SQLiteDatabaseLockedException -> Lca
        Lc5:
            return r6
        Lc6:
            android.util.Log.w(r1, r0)
            return r6
        Lca:
            android.util.Log.w(r1, r0)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler.updatePasswordStatus(java.lang.String, java.lang.String, java.lang.String, int):boolean");
    }

    public void updatePasswordStatusForAll() {
        String str;
        SQLiteClosable writableDatabase;
        String currentAPPType = SharepreferenceDBHandler.getCurrentAPPType(this.context);
        if (currentAPPType.equals("m3u")) {
            str = "iptv_password_status_table_m3u";
        } else {
            currentAPPType.equals("onestream_api");
            str = "iptv_password_status_table";
        }
        SQLiteClosable sQLiteClosable = null;
        try {
            writableDatabase = getWritableDatabase();
        } catch (Exception unused) {
        } catch (SQLiteDatabaseLockedException unused2) {
        } catch (Throwable th) {
            th = th;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("password_status", "0");
            writableDatabase.update(str, contentValues, (String) null, (String[]) null);
            writableDatabase.close();
        } catch (Exception unused3) {
            sQLiteClosable = writableDatabase;
            if (sQLiteClosable == null) {
                return;
            }
            sQLiteClosable.close();
        } catch (SQLiteDatabaseLockedException unused4) {
            sQLiteClosable = writableDatabase;
            if (sQLiteClosable == null) {
                return;
            }
            sQLiteClosable.close();
        } catch (Throwable th2) {
            th = th2;
            sQLiteClosable = writableDatabase;
            if (sQLiteClosable != null) {
                sQLiteClosable.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0081 A[Catch: Exception -> 0x00af, SQLiteDatabaseLockedException -> 0x00b3, TryCatch #3 {Exception -> 0x00af, SQLiteDatabaseLockedException -> 0x00b3, blocks: (B:3:0x0009, B:6:0x004c, B:20:0x0052, B:21:0x0066, B:9:0x007b, B:11:0x0081, B:13:0x00a5, B:17:0x00ab, B:28:0x006d, B:30:0x0071), top: B:2:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00a9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean updateResumePlayerStatuTimes(java.lang.String r7, java.lang.String r8, boolean r9, long r10, long r12, int r14) {
        /*
            r6 = this;
            java.lang.String r9 = "exception"
            java.lang.String r0 = "msg"
            java.lang.String r1 = " = '"
            java.lang.String r2 = "' AND "
            r3 = 0
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Laf android.database.sqlite.SQLiteDatabaseLockedException -> Lb3
            r4.<init>()     // Catch: java.lang.Exception -> Laf android.database.sqlite.SQLiteDatabaseLockedException -> Lb3
            java.lang.String r5 = "SELECT rowid FROM iptv_recent_watched_m3u WHERE stream_type = '"
            r4.append(r5)     // Catch: java.lang.Exception -> Laf android.database.sqlite.SQLiteDatabaseLockedException -> Lb3
            r4.append(r8)     // Catch: java.lang.Exception -> Laf android.database.sqlite.SQLiteDatabaseLockedException -> Lb3
            r4.append(r2)     // Catch: java.lang.Exception -> Laf android.database.sqlite.SQLiteDatabaseLockedException -> Lb3
            java.lang.String r8 = "user_id_referred"
            r4.append(r8)     // Catch: java.lang.Exception -> Laf android.database.sqlite.SQLiteDatabaseLockedException -> Lb3
            r4.append(r1)     // Catch: java.lang.Exception -> Laf android.database.sqlite.SQLiteDatabaseLockedException -> Lb3
            r4.append(r14)     // Catch: java.lang.Exception -> Laf android.database.sqlite.SQLiteDatabaseLockedException -> Lb3
            r4.append(r2)     // Catch: java.lang.Exception -> Laf android.database.sqlite.SQLiteDatabaseLockedException -> Lb3
            java.lang.String r8 = "url"
            r4.append(r8)     // Catch: java.lang.Exception -> Laf android.database.sqlite.SQLiteDatabaseLockedException -> Lb3
            r4.append(r1)     // Catch: java.lang.Exception -> Laf android.database.sqlite.SQLiteDatabaseLockedException -> Lb3
            r4.append(r7)     // Catch: java.lang.Exception -> Laf android.database.sqlite.SQLiteDatabaseLockedException -> Lb3
            java.lang.String r7 = "'"
            r4.append(r7)     // Catch: java.lang.Exception -> Laf android.database.sqlite.SQLiteDatabaseLockedException -> Lb3
            java.lang.String r7 = r4.toString()     // Catch: java.lang.Exception -> Laf android.database.sqlite.SQLiteDatabaseLockedException -> Lb3
            r6.getReadableDatabase()     // Catch: java.lang.Exception -> Laf android.database.sqlite.SQLiteDatabaseLockedException -> Lb3
            android.database.sqlite.SQLiteDatabase r8 = r6.getWritableDatabase()     // Catch: java.lang.Exception -> Laf android.database.sqlite.SQLiteDatabaseLockedException -> Lb3
            r14 = 0
            android.database.Cursor r7 = r8.rawQuery(r7, r14)     // Catch: java.lang.Exception -> Laf android.database.sqlite.SQLiteDatabaseLockedException -> Lb3
            r14 = 1
            java.lang.String r1 = ""
            if (r7 == 0) goto L6d
            boolean r2 = r7.moveToFirst()     // Catch: java.lang.Exception -> Laf android.database.sqlite.SQLiteDatabaseLockedException -> Lb3
            if (r2 == 0) goto L7a
        L52:
            java.lang.String r2 = "id"
            int r2 = r7.getColumnIndex(r2)     // Catch: java.lang.NumberFormatException -> L65 java.lang.Exception -> Laf android.database.sqlite.SQLiteDatabaseLockedException -> Lb3
            java.lang.String r2 = r7.getString(r2)     // Catch: java.lang.NumberFormatException -> L65 java.lang.Exception -> Laf android.database.sqlite.SQLiteDatabaseLockedException -> Lb3
            int r2 = java.lang.Integer.parseInt(r2)     // Catch: java.lang.NumberFormatException -> L65 java.lang.Exception -> Laf android.database.sqlite.SQLiteDatabaseLockedException -> Lb3
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch: java.lang.NumberFormatException -> L65 java.lang.Exception -> Laf android.database.sqlite.SQLiteDatabaseLockedException -> Lb3
            goto L66
        L65:
            r2 = r1
        L66:
            boolean r4 = r7.moveToNext()     // Catch: java.lang.Exception -> Laf android.database.sqlite.SQLiteDatabaseLockedException -> Lb3
            if (r4 != 0) goto L52
            goto L7b
        L6d:
            android.content.Context r2 = r6.context     // Catch: java.lang.Exception -> Laf android.database.sqlite.SQLiteDatabaseLockedException -> Lb3
            if (r2 == 0) goto L7a
            java.lang.String r4 = "cursor is null"
            android.widget.Toast r2 = android.widget.Toast.makeText(r2, r4, r14)     // Catch: java.lang.Exception -> Laf android.database.sqlite.SQLiteDatabaseLockedException -> Lb3
            r2.show()     // Catch: java.lang.Exception -> Laf android.database.sqlite.SQLiteDatabaseLockedException -> Lb3
        L7a:
            r2 = r1
        L7b:
            boolean r1 = r2.equals(r1)     // Catch: java.lang.Exception -> Laf android.database.sqlite.SQLiteDatabaseLockedException -> Lb3
            if (r1 != 0) goto La9
            android.content.ContentValues r1 = new android.content.ContentValues     // Catch: java.lang.Exception -> Laf android.database.sqlite.SQLiteDatabaseLockedException -> Lb3
            r1.<init>()     // Catch: java.lang.Exception -> Laf android.database.sqlite.SQLiteDatabaseLockedException -> Lb3
            java.lang.String r4 = "movie_elapsed_time"
            java.lang.Long r12 = java.lang.Long.valueOf(r12)     // Catch: java.lang.Exception -> Laf android.database.sqlite.SQLiteDatabaseLockedException -> Lb3
            r1.put(r4, r12)     // Catch: java.lang.Exception -> Laf android.database.sqlite.SQLiteDatabaseLockedException -> Lb3
            java.lang.String r12 = "movie_duration"
            java.lang.Long r10 = java.lang.Long.valueOf(r10)     // Catch: java.lang.Exception -> Laf android.database.sqlite.SQLiteDatabaseLockedException -> Lb3
            r1.put(r12, r10)     // Catch: java.lang.Exception -> Laf android.database.sqlite.SQLiteDatabaseLockedException -> Lb3
            java.lang.String r10 = "iptv_recent_watched_m3u"
            java.lang.String r11 = "id= ?"
            java.lang.String[] r12 = new java.lang.String[]{r2}     // Catch: java.lang.Exception -> Laf android.database.sqlite.SQLiteDatabaseLockedException -> Lb3
            r8.update(r10, r1, r11, r12)     // Catch: java.lang.Exception -> Laf android.database.sqlite.SQLiteDatabaseLockedException -> Lb3
            if (r7 == 0) goto La8
            r7.close()     // Catch: java.lang.Exception -> Laf android.database.sqlite.SQLiteDatabaseLockedException -> Lb3
        La8:
            return r14
        La9:
            if (r7 == 0) goto Lae
            r7.close()     // Catch: java.lang.Exception -> Laf android.database.sqlite.SQLiteDatabaseLockedException -> Lb3
        Lae:
            return r3
        Laf:
            android.util.Log.w(r0, r9)
            return r3
        Lb3:
            android.util.Log.w(r0, r9)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler.updateResumePlayerStatuTimes(java.lang.String, java.lang.String, boolean, long, long, int):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0087 A[Catch: Exception -> 0x00ac, SQLiteDatabaseLockedException -> 0x00b0, TryCatch #3 {Exception -> 0x00ac, SQLiteDatabaseLockedException -> 0x00b0, blocks: (B:3:0x000f, B:6:0x0052, B:20:0x0058, B:21:0x006c, B:9:0x0081, B:11:0x0087, B:13:0x00a2, B:17:0x00a8, B:28:0x0073, B:30:0x0077), top: B:2:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean updateResumePlayerStatus(java.lang.String r8, java.lang.String r9, boolean r10, long r11) {
        /*
            r7 = this;
            java.lang.String r10 = "exception"
            java.lang.String r0 = "msg"
            java.lang.String r1 = " = '"
            java.lang.String r2 = "' AND "
            android.content.Context r3 = r7.context
            int r3 = com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler.getUserID(r3)
            r4 = 0
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lac android.database.sqlite.SQLiteDatabaseLockedException -> Lb0
            r5.<init>()     // Catch: java.lang.Exception -> Lac android.database.sqlite.SQLiteDatabaseLockedException -> Lb0
            java.lang.String r6 = "SELECT rowid FROM iptv_recent_watched_m3u WHERE stream_type = '"
            r5.append(r6)     // Catch: java.lang.Exception -> Lac android.database.sqlite.SQLiteDatabaseLockedException -> Lb0
            r5.append(r9)     // Catch: java.lang.Exception -> Lac android.database.sqlite.SQLiteDatabaseLockedException -> Lb0
            r5.append(r2)     // Catch: java.lang.Exception -> Lac android.database.sqlite.SQLiteDatabaseLockedException -> Lb0
            java.lang.String r9 = "user_id_referred"
            r5.append(r9)     // Catch: java.lang.Exception -> Lac android.database.sqlite.SQLiteDatabaseLockedException -> Lb0
            r5.append(r1)     // Catch: java.lang.Exception -> Lac android.database.sqlite.SQLiteDatabaseLockedException -> Lb0
            r5.append(r3)     // Catch: java.lang.Exception -> Lac android.database.sqlite.SQLiteDatabaseLockedException -> Lb0
            r5.append(r2)     // Catch: java.lang.Exception -> Lac android.database.sqlite.SQLiteDatabaseLockedException -> Lb0
            java.lang.String r9 = "url"
            r5.append(r9)     // Catch: java.lang.Exception -> Lac android.database.sqlite.SQLiteDatabaseLockedException -> Lb0
            r5.append(r1)     // Catch: java.lang.Exception -> Lac android.database.sqlite.SQLiteDatabaseLockedException -> Lb0
            r5.append(r8)     // Catch: java.lang.Exception -> Lac android.database.sqlite.SQLiteDatabaseLockedException -> Lb0
            java.lang.String r8 = "'"
            r5.append(r8)     // Catch: java.lang.Exception -> Lac android.database.sqlite.SQLiteDatabaseLockedException -> Lb0
            java.lang.String r8 = r5.toString()     // Catch: java.lang.Exception -> Lac android.database.sqlite.SQLiteDatabaseLockedException -> Lb0
            r7.getReadableDatabase()     // Catch: java.lang.Exception -> Lac android.database.sqlite.SQLiteDatabaseLockedException -> Lb0
            android.database.sqlite.SQLiteDatabase r9 = r7.getWritableDatabase()     // Catch: java.lang.Exception -> Lac android.database.sqlite.SQLiteDatabaseLockedException -> Lb0
            r1 = 0
            android.database.Cursor r8 = r9.rawQuery(r8, r1)     // Catch: java.lang.Exception -> Lac android.database.sqlite.SQLiteDatabaseLockedException -> Lb0
            r1 = 1
            java.lang.String r2 = ""
            if (r8 == 0) goto L73
            boolean r3 = r8.moveToFirst()     // Catch: java.lang.Exception -> Lac android.database.sqlite.SQLiteDatabaseLockedException -> Lb0
            if (r3 == 0) goto L80
        L58:
            java.lang.String r3 = "id"
            int r3 = r8.getColumnIndex(r3)     // Catch: java.lang.NumberFormatException -> L6b java.lang.Exception -> Lac android.database.sqlite.SQLiteDatabaseLockedException -> Lb0
            java.lang.String r3 = r8.getString(r3)     // Catch: java.lang.NumberFormatException -> L6b java.lang.Exception -> Lac android.database.sqlite.SQLiteDatabaseLockedException -> Lb0
            int r3 = java.lang.Integer.parseInt(r3)     // Catch: java.lang.NumberFormatException -> L6b java.lang.Exception -> Lac android.database.sqlite.SQLiteDatabaseLockedException -> Lb0
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch: java.lang.NumberFormatException -> L6b java.lang.Exception -> Lac android.database.sqlite.SQLiteDatabaseLockedException -> Lb0
            goto L6c
        L6b:
            r3 = r2
        L6c:
            boolean r5 = r8.moveToNext()     // Catch: java.lang.Exception -> Lac android.database.sqlite.SQLiteDatabaseLockedException -> Lb0
            if (r5 != 0) goto L58
            goto L81
        L73:
            android.content.Context r3 = r7.context     // Catch: java.lang.Exception -> Lac android.database.sqlite.SQLiteDatabaseLockedException -> Lb0
            if (r3 == 0) goto L80
            java.lang.String r5 = "cursor is null"
            android.widget.Toast r3 = android.widget.Toast.makeText(r3, r5, r1)     // Catch: java.lang.Exception -> Lac android.database.sqlite.SQLiteDatabaseLockedException -> Lb0
            r3.show()     // Catch: java.lang.Exception -> Lac android.database.sqlite.SQLiteDatabaseLockedException -> Lb0
        L80:
            r3 = r2
        L81:
            boolean r2 = r3.equals(r2)     // Catch: java.lang.Exception -> Lac android.database.sqlite.SQLiteDatabaseLockedException -> Lb0
            if (r2 != 0) goto La6
            android.content.ContentValues r2 = new android.content.ContentValues     // Catch: java.lang.Exception -> Lac android.database.sqlite.SQLiteDatabaseLockedException -> Lb0
            r2.<init>()     // Catch: java.lang.Exception -> Lac android.database.sqlite.SQLiteDatabaseLockedException -> Lb0
            java.lang.String r5 = "movie_elapsed_time"
            java.lang.Long r11 = java.lang.Long.valueOf(r11)     // Catch: java.lang.Exception -> Lac android.database.sqlite.SQLiteDatabaseLockedException -> Lb0
            r2.put(r5, r11)     // Catch: java.lang.Exception -> Lac android.database.sqlite.SQLiteDatabaseLockedException -> Lb0
            java.lang.String r11 = "iptv_recent_watched_m3u"
            java.lang.String r12 = "id= ?"
            java.lang.String[] r3 = new java.lang.String[]{r3}     // Catch: java.lang.Exception -> Lac android.database.sqlite.SQLiteDatabaseLockedException -> Lb0
            r9.update(r11, r2, r12, r3)     // Catch: java.lang.Exception -> Lac android.database.sqlite.SQLiteDatabaseLockedException -> Lb0
            if (r8 == 0) goto La5
            r8.close()     // Catch: java.lang.Exception -> Lac android.database.sqlite.SQLiteDatabaseLockedException -> Lb0
        La5:
            return r1
        La6:
            if (r8 == 0) goto Lab
            r8.close()     // Catch: java.lang.Exception -> Lac android.database.sqlite.SQLiteDatabaseLockedException -> Lb0
        Lab:
            return r4
        Lac:
            android.util.Log.w(r0, r10)
            return r4
        Lb0:
            android.util.Log.w(r0, r10)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler.updateResumePlayerStatus(java.lang.String, java.lang.String, boolean, long):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01ca A[Catch: Exception -> 0x0229, TryCatch #0 {Exception -> 0x0229, blocks: (B:4:0x0007, B:5:0x001a, B:7:0x0020, B:10:0x0030, B:11:0x003f, B:14:0x0047, B:15:0x0052, B:18:0x005c, B:19:0x0060, B:20:0x00a0, B:23:0x00a8, B:24:0x00b3, B:27:0x00bb, B:28:0x00c6, B:31:0x00ce, B:32:0x00d9, B:35:0x00e1, B:36:0x00ec, B:39:0x00f6, B:41:0x00fc, B:44:0x0104, B:47:0x010f, B:48:0x011a, B:51:0x0122, B:52:0x012d, B:55:0x0135, B:56:0x0140, B:59:0x0148, B:60:0x0153, B:63:0x015b, B:64:0x0166, B:67:0x016e, B:68:0x017d, B:71:0x0185, B:72:0x0190, B:75:0x0198, B:76:0x01a7, B:78:0x01ad, B:79:0x01bc, B:81:0x01c2, B:82:0x01cd, B:85:0x01d5, B:86:0x01e4, B:89:0x01ec, B:90:0x01f7, B:93:0x01ff, B:95:0x020e, B:96:0x020b, B:98:0x01f4, B:99:0x01e1, B:100:0x01ca, B:101:0x01b9, B:102:0x01a4, B:103:0x018d, B:104:0x017a, B:105:0x0163, B:106:0x0150, B:107:0x013d, B:108:0x012a, B:109:0x0117, B:110:0x00e9, B:111:0x00d6, B:112:0x00c3, B:113:0x00b0, B:114:0x0064, B:116:0x006a, B:118:0x0070, B:120:0x0082, B:122:0x007a, B:125:0x0088, B:129:0x0092, B:131:0x009d, B:132:0x004f, B:133:0x003c, B:135:0x021f), top: B:3:0x0007, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:101:0x01b9 A[Catch: Exception -> 0x0229, TryCatch #0 {Exception -> 0x0229, blocks: (B:4:0x0007, B:5:0x001a, B:7:0x0020, B:10:0x0030, B:11:0x003f, B:14:0x0047, B:15:0x0052, B:18:0x005c, B:19:0x0060, B:20:0x00a0, B:23:0x00a8, B:24:0x00b3, B:27:0x00bb, B:28:0x00c6, B:31:0x00ce, B:32:0x00d9, B:35:0x00e1, B:36:0x00ec, B:39:0x00f6, B:41:0x00fc, B:44:0x0104, B:47:0x010f, B:48:0x011a, B:51:0x0122, B:52:0x012d, B:55:0x0135, B:56:0x0140, B:59:0x0148, B:60:0x0153, B:63:0x015b, B:64:0x0166, B:67:0x016e, B:68:0x017d, B:71:0x0185, B:72:0x0190, B:75:0x0198, B:76:0x01a7, B:78:0x01ad, B:79:0x01bc, B:81:0x01c2, B:82:0x01cd, B:85:0x01d5, B:86:0x01e4, B:89:0x01ec, B:90:0x01f7, B:93:0x01ff, B:95:0x020e, B:96:0x020b, B:98:0x01f4, B:99:0x01e1, B:100:0x01ca, B:101:0x01b9, B:102:0x01a4, B:103:0x018d, B:104:0x017a, B:105:0x0163, B:106:0x0150, B:107:0x013d, B:108:0x012a, B:109:0x0117, B:110:0x00e9, B:111:0x00d6, B:112:0x00c3, B:113:0x00b0, B:114:0x0064, B:116:0x006a, B:118:0x0070, B:120:0x0082, B:122:0x007a, B:125:0x0088, B:129:0x0092, B:131:0x009d, B:132:0x004f, B:133:0x003c, B:135:0x021f), top: B:3:0x0007, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:102:0x01a4 A[Catch: Exception -> 0x0229, TryCatch #0 {Exception -> 0x0229, blocks: (B:4:0x0007, B:5:0x001a, B:7:0x0020, B:10:0x0030, B:11:0x003f, B:14:0x0047, B:15:0x0052, B:18:0x005c, B:19:0x0060, B:20:0x00a0, B:23:0x00a8, B:24:0x00b3, B:27:0x00bb, B:28:0x00c6, B:31:0x00ce, B:32:0x00d9, B:35:0x00e1, B:36:0x00ec, B:39:0x00f6, B:41:0x00fc, B:44:0x0104, B:47:0x010f, B:48:0x011a, B:51:0x0122, B:52:0x012d, B:55:0x0135, B:56:0x0140, B:59:0x0148, B:60:0x0153, B:63:0x015b, B:64:0x0166, B:67:0x016e, B:68:0x017d, B:71:0x0185, B:72:0x0190, B:75:0x0198, B:76:0x01a7, B:78:0x01ad, B:79:0x01bc, B:81:0x01c2, B:82:0x01cd, B:85:0x01d5, B:86:0x01e4, B:89:0x01ec, B:90:0x01f7, B:93:0x01ff, B:95:0x020e, B:96:0x020b, B:98:0x01f4, B:99:0x01e1, B:100:0x01ca, B:101:0x01b9, B:102:0x01a4, B:103:0x018d, B:104:0x017a, B:105:0x0163, B:106:0x0150, B:107:0x013d, B:108:0x012a, B:109:0x0117, B:110:0x00e9, B:111:0x00d6, B:112:0x00c3, B:113:0x00b0, B:114:0x0064, B:116:0x006a, B:118:0x0070, B:120:0x0082, B:122:0x007a, B:125:0x0088, B:129:0x0092, B:131:0x009d, B:132:0x004f, B:133:0x003c, B:135:0x021f), top: B:3:0x0007, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:103:0x018d A[Catch: Exception -> 0x0229, TryCatch #0 {Exception -> 0x0229, blocks: (B:4:0x0007, B:5:0x001a, B:7:0x0020, B:10:0x0030, B:11:0x003f, B:14:0x0047, B:15:0x0052, B:18:0x005c, B:19:0x0060, B:20:0x00a0, B:23:0x00a8, B:24:0x00b3, B:27:0x00bb, B:28:0x00c6, B:31:0x00ce, B:32:0x00d9, B:35:0x00e1, B:36:0x00ec, B:39:0x00f6, B:41:0x00fc, B:44:0x0104, B:47:0x010f, B:48:0x011a, B:51:0x0122, B:52:0x012d, B:55:0x0135, B:56:0x0140, B:59:0x0148, B:60:0x0153, B:63:0x015b, B:64:0x0166, B:67:0x016e, B:68:0x017d, B:71:0x0185, B:72:0x0190, B:75:0x0198, B:76:0x01a7, B:78:0x01ad, B:79:0x01bc, B:81:0x01c2, B:82:0x01cd, B:85:0x01d5, B:86:0x01e4, B:89:0x01ec, B:90:0x01f7, B:93:0x01ff, B:95:0x020e, B:96:0x020b, B:98:0x01f4, B:99:0x01e1, B:100:0x01ca, B:101:0x01b9, B:102:0x01a4, B:103:0x018d, B:104:0x017a, B:105:0x0163, B:106:0x0150, B:107:0x013d, B:108:0x012a, B:109:0x0117, B:110:0x00e9, B:111:0x00d6, B:112:0x00c3, B:113:0x00b0, B:114:0x0064, B:116:0x006a, B:118:0x0070, B:120:0x0082, B:122:0x007a, B:125:0x0088, B:129:0x0092, B:131:0x009d, B:132:0x004f, B:133:0x003c, B:135:0x021f), top: B:3:0x0007, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:104:0x017a A[Catch: Exception -> 0x0229, TryCatch #0 {Exception -> 0x0229, blocks: (B:4:0x0007, B:5:0x001a, B:7:0x0020, B:10:0x0030, B:11:0x003f, B:14:0x0047, B:15:0x0052, B:18:0x005c, B:19:0x0060, B:20:0x00a0, B:23:0x00a8, B:24:0x00b3, B:27:0x00bb, B:28:0x00c6, B:31:0x00ce, B:32:0x00d9, B:35:0x00e1, B:36:0x00ec, B:39:0x00f6, B:41:0x00fc, B:44:0x0104, B:47:0x010f, B:48:0x011a, B:51:0x0122, B:52:0x012d, B:55:0x0135, B:56:0x0140, B:59:0x0148, B:60:0x0153, B:63:0x015b, B:64:0x0166, B:67:0x016e, B:68:0x017d, B:71:0x0185, B:72:0x0190, B:75:0x0198, B:76:0x01a7, B:78:0x01ad, B:79:0x01bc, B:81:0x01c2, B:82:0x01cd, B:85:0x01d5, B:86:0x01e4, B:89:0x01ec, B:90:0x01f7, B:93:0x01ff, B:95:0x020e, B:96:0x020b, B:98:0x01f4, B:99:0x01e1, B:100:0x01ca, B:101:0x01b9, B:102:0x01a4, B:103:0x018d, B:104:0x017a, B:105:0x0163, B:106:0x0150, B:107:0x013d, B:108:0x012a, B:109:0x0117, B:110:0x00e9, B:111:0x00d6, B:112:0x00c3, B:113:0x00b0, B:114:0x0064, B:116:0x006a, B:118:0x0070, B:120:0x0082, B:122:0x007a, B:125:0x0088, B:129:0x0092, B:131:0x009d, B:132:0x004f, B:133:0x003c, B:135:0x021f), top: B:3:0x0007, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0163 A[Catch: Exception -> 0x0229, TryCatch #0 {Exception -> 0x0229, blocks: (B:4:0x0007, B:5:0x001a, B:7:0x0020, B:10:0x0030, B:11:0x003f, B:14:0x0047, B:15:0x0052, B:18:0x005c, B:19:0x0060, B:20:0x00a0, B:23:0x00a8, B:24:0x00b3, B:27:0x00bb, B:28:0x00c6, B:31:0x00ce, B:32:0x00d9, B:35:0x00e1, B:36:0x00ec, B:39:0x00f6, B:41:0x00fc, B:44:0x0104, B:47:0x010f, B:48:0x011a, B:51:0x0122, B:52:0x012d, B:55:0x0135, B:56:0x0140, B:59:0x0148, B:60:0x0153, B:63:0x015b, B:64:0x0166, B:67:0x016e, B:68:0x017d, B:71:0x0185, B:72:0x0190, B:75:0x0198, B:76:0x01a7, B:78:0x01ad, B:79:0x01bc, B:81:0x01c2, B:82:0x01cd, B:85:0x01d5, B:86:0x01e4, B:89:0x01ec, B:90:0x01f7, B:93:0x01ff, B:95:0x020e, B:96:0x020b, B:98:0x01f4, B:99:0x01e1, B:100:0x01ca, B:101:0x01b9, B:102:0x01a4, B:103:0x018d, B:104:0x017a, B:105:0x0163, B:106:0x0150, B:107:0x013d, B:108:0x012a, B:109:0x0117, B:110:0x00e9, B:111:0x00d6, B:112:0x00c3, B:113:0x00b0, B:114:0x0064, B:116:0x006a, B:118:0x0070, B:120:0x0082, B:122:0x007a, B:125:0x0088, B:129:0x0092, B:131:0x009d, B:132:0x004f, B:133:0x003c, B:135:0x021f), top: B:3:0x0007, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0150 A[Catch: Exception -> 0x0229, TryCatch #0 {Exception -> 0x0229, blocks: (B:4:0x0007, B:5:0x001a, B:7:0x0020, B:10:0x0030, B:11:0x003f, B:14:0x0047, B:15:0x0052, B:18:0x005c, B:19:0x0060, B:20:0x00a0, B:23:0x00a8, B:24:0x00b3, B:27:0x00bb, B:28:0x00c6, B:31:0x00ce, B:32:0x00d9, B:35:0x00e1, B:36:0x00ec, B:39:0x00f6, B:41:0x00fc, B:44:0x0104, B:47:0x010f, B:48:0x011a, B:51:0x0122, B:52:0x012d, B:55:0x0135, B:56:0x0140, B:59:0x0148, B:60:0x0153, B:63:0x015b, B:64:0x0166, B:67:0x016e, B:68:0x017d, B:71:0x0185, B:72:0x0190, B:75:0x0198, B:76:0x01a7, B:78:0x01ad, B:79:0x01bc, B:81:0x01c2, B:82:0x01cd, B:85:0x01d5, B:86:0x01e4, B:89:0x01ec, B:90:0x01f7, B:93:0x01ff, B:95:0x020e, B:96:0x020b, B:98:0x01f4, B:99:0x01e1, B:100:0x01ca, B:101:0x01b9, B:102:0x01a4, B:103:0x018d, B:104:0x017a, B:105:0x0163, B:106:0x0150, B:107:0x013d, B:108:0x012a, B:109:0x0117, B:110:0x00e9, B:111:0x00d6, B:112:0x00c3, B:113:0x00b0, B:114:0x0064, B:116:0x006a, B:118:0x0070, B:120:0x0082, B:122:0x007a, B:125:0x0088, B:129:0x0092, B:131:0x009d, B:132:0x004f, B:133:0x003c, B:135:0x021f), top: B:3:0x0007, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x013d A[Catch: Exception -> 0x0229, TryCatch #0 {Exception -> 0x0229, blocks: (B:4:0x0007, B:5:0x001a, B:7:0x0020, B:10:0x0030, B:11:0x003f, B:14:0x0047, B:15:0x0052, B:18:0x005c, B:19:0x0060, B:20:0x00a0, B:23:0x00a8, B:24:0x00b3, B:27:0x00bb, B:28:0x00c6, B:31:0x00ce, B:32:0x00d9, B:35:0x00e1, B:36:0x00ec, B:39:0x00f6, B:41:0x00fc, B:44:0x0104, B:47:0x010f, B:48:0x011a, B:51:0x0122, B:52:0x012d, B:55:0x0135, B:56:0x0140, B:59:0x0148, B:60:0x0153, B:63:0x015b, B:64:0x0166, B:67:0x016e, B:68:0x017d, B:71:0x0185, B:72:0x0190, B:75:0x0198, B:76:0x01a7, B:78:0x01ad, B:79:0x01bc, B:81:0x01c2, B:82:0x01cd, B:85:0x01d5, B:86:0x01e4, B:89:0x01ec, B:90:0x01f7, B:93:0x01ff, B:95:0x020e, B:96:0x020b, B:98:0x01f4, B:99:0x01e1, B:100:0x01ca, B:101:0x01b9, B:102:0x01a4, B:103:0x018d, B:104:0x017a, B:105:0x0163, B:106:0x0150, B:107:0x013d, B:108:0x012a, B:109:0x0117, B:110:0x00e9, B:111:0x00d6, B:112:0x00c3, B:113:0x00b0, B:114:0x0064, B:116:0x006a, B:118:0x0070, B:120:0x0082, B:122:0x007a, B:125:0x0088, B:129:0x0092, B:131:0x009d, B:132:0x004f, B:133:0x003c, B:135:0x021f), top: B:3:0x0007, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x012a A[Catch: Exception -> 0x0229, TryCatch #0 {Exception -> 0x0229, blocks: (B:4:0x0007, B:5:0x001a, B:7:0x0020, B:10:0x0030, B:11:0x003f, B:14:0x0047, B:15:0x0052, B:18:0x005c, B:19:0x0060, B:20:0x00a0, B:23:0x00a8, B:24:0x00b3, B:27:0x00bb, B:28:0x00c6, B:31:0x00ce, B:32:0x00d9, B:35:0x00e1, B:36:0x00ec, B:39:0x00f6, B:41:0x00fc, B:44:0x0104, B:47:0x010f, B:48:0x011a, B:51:0x0122, B:52:0x012d, B:55:0x0135, B:56:0x0140, B:59:0x0148, B:60:0x0153, B:63:0x015b, B:64:0x0166, B:67:0x016e, B:68:0x017d, B:71:0x0185, B:72:0x0190, B:75:0x0198, B:76:0x01a7, B:78:0x01ad, B:79:0x01bc, B:81:0x01c2, B:82:0x01cd, B:85:0x01d5, B:86:0x01e4, B:89:0x01ec, B:90:0x01f7, B:93:0x01ff, B:95:0x020e, B:96:0x020b, B:98:0x01f4, B:99:0x01e1, B:100:0x01ca, B:101:0x01b9, B:102:0x01a4, B:103:0x018d, B:104:0x017a, B:105:0x0163, B:106:0x0150, B:107:0x013d, B:108:0x012a, B:109:0x0117, B:110:0x00e9, B:111:0x00d6, B:112:0x00c3, B:113:0x00b0, B:114:0x0064, B:116:0x006a, B:118:0x0070, B:120:0x0082, B:122:0x007a, B:125:0x0088, B:129:0x0092, B:131:0x009d, B:132:0x004f, B:133:0x003c, B:135:0x021f), top: B:3:0x0007, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0117 A[Catch: Exception -> 0x0229, TryCatch #0 {Exception -> 0x0229, blocks: (B:4:0x0007, B:5:0x001a, B:7:0x0020, B:10:0x0030, B:11:0x003f, B:14:0x0047, B:15:0x0052, B:18:0x005c, B:19:0x0060, B:20:0x00a0, B:23:0x00a8, B:24:0x00b3, B:27:0x00bb, B:28:0x00c6, B:31:0x00ce, B:32:0x00d9, B:35:0x00e1, B:36:0x00ec, B:39:0x00f6, B:41:0x00fc, B:44:0x0104, B:47:0x010f, B:48:0x011a, B:51:0x0122, B:52:0x012d, B:55:0x0135, B:56:0x0140, B:59:0x0148, B:60:0x0153, B:63:0x015b, B:64:0x0166, B:67:0x016e, B:68:0x017d, B:71:0x0185, B:72:0x0190, B:75:0x0198, B:76:0x01a7, B:78:0x01ad, B:79:0x01bc, B:81:0x01c2, B:82:0x01cd, B:85:0x01d5, B:86:0x01e4, B:89:0x01ec, B:90:0x01f7, B:93:0x01ff, B:95:0x020e, B:96:0x020b, B:98:0x01f4, B:99:0x01e1, B:100:0x01ca, B:101:0x01b9, B:102:0x01a4, B:103:0x018d, B:104:0x017a, B:105:0x0163, B:106:0x0150, B:107:0x013d, B:108:0x012a, B:109:0x0117, B:110:0x00e9, B:111:0x00d6, B:112:0x00c3, B:113:0x00b0, B:114:0x0064, B:116:0x006a, B:118:0x0070, B:120:0x0082, B:122:0x007a, B:125:0x0088, B:129:0x0092, B:131:0x009d, B:132:0x004f, B:133:0x003c, B:135:0x021f), top: B:3:0x0007, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:110:0x00e9 A[Catch: Exception -> 0x0229, TryCatch #0 {Exception -> 0x0229, blocks: (B:4:0x0007, B:5:0x001a, B:7:0x0020, B:10:0x0030, B:11:0x003f, B:14:0x0047, B:15:0x0052, B:18:0x005c, B:19:0x0060, B:20:0x00a0, B:23:0x00a8, B:24:0x00b3, B:27:0x00bb, B:28:0x00c6, B:31:0x00ce, B:32:0x00d9, B:35:0x00e1, B:36:0x00ec, B:39:0x00f6, B:41:0x00fc, B:44:0x0104, B:47:0x010f, B:48:0x011a, B:51:0x0122, B:52:0x012d, B:55:0x0135, B:56:0x0140, B:59:0x0148, B:60:0x0153, B:63:0x015b, B:64:0x0166, B:67:0x016e, B:68:0x017d, B:71:0x0185, B:72:0x0190, B:75:0x0198, B:76:0x01a7, B:78:0x01ad, B:79:0x01bc, B:81:0x01c2, B:82:0x01cd, B:85:0x01d5, B:86:0x01e4, B:89:0x01ec, B:90:0x01f7, B:93:0x01ff, B:95:0x020e, B:96:0x020b, B:98:0x01f4, B:99:0x01e1, B:100:0x01ca, B:101:0x01b9, B:102:0x01a4, B:103:0x018d, B:104:0x017a, B:105:0x0163, B:106:0x0150, B:107:0x013d, B:108:0x012a, B:109:0x0117, B:110:0x00e9, B:111:0x00d6, B:112:0x00c3, B:113:0x00b0, B:114:0x0064, B:116:0x006a, B:118:0x0070, B:120:0x0082, B:122:0x007a, B:125:0x0088, B:129:0x0092, B:131:0x009d, B:132:0x004f, B:133:0x003c, B:135:0x021f), top: B:3:0x0007, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:111:0x00d6 A[Catch: Exception -> 0x0229, TryCatch #0 {Exception -> 0x0229, blocks: (B:4:0x0007, B:5:0x001a, B:7:0x0020, B:10:0x0030, B:11:0x003f, B:14:0x0047, B:15:0x0052, B:18:0x005c, B:19:0x0060, B:20:0x00a0, B:23:0x00a8, B:24:0x00b3, B:27:0x00bb, B:28:0x00c6, B:31:0x00ce, B:32:0x00d9, B:35:0x00e1, B:36:0x00ec, B:39:0x00f6, B:41:0x00fc, B:44:0x0104, B:47:0x010f, B:48:0x011a, B:51:0x0122, B:52:0x012d, B:55:0x0135, B:56:0x0140, B:59:0x0148, B:60:0x0153, B:63:0x015b, B:64:0x0166, B:67:0x016e, B:68:0x017d, B:71:0x0185, B:72:0x0190, B:75:0x0198, B:76:0x01a7, B:78:0x01ad, B:79:0x01bc, B:81:0x01c2, B:82:0x01cd, B:85:0x01d5, B:86:0x01e4, B:89:0x01ec, B:90:0x01f7, B:93:0x01ff, B:95:0x020e, B:96:0x020b, B:98:0x01f4, B:99:0x01e1, B:100:0x01ca, B:101:0x01b9, B:102:0x01a4, B:103:0x018d, B:104:0x017a, B:105:0x0163, B:106:0x0150, B:107:0x013d, B:108:0x012a, B:109:0x0117, B:110:0x00e9, B:111:0x00d6, B:112:0x00c3, B:113:0x00b0, B:114:0x0064, B:116:0x006a, B:118:0x0070, B:120:0x0082, B:122:0x007a, B:125:0x0088, B:129:0x0092, B:131:0x009d, B:132:0x004f, B:133:0x003c, B:135:0x021f), top: B:3:0x0007, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x00c3 A[Catch: Exception -> 0x0229, TryCatch #0 {Exception -> 0x0229, blocks: (B:4:0x0007, B:5:0x001a, B:7:0x0020, B:10:0x0030, B:11:0x003f, B:14:0x0047, B:15:0x0052, B:18:0x005c, B:19:0x0060, B:20:0x00a0, B:23:0x00a8, B:24:0x00b3, B:27:0x00bb, B:28:0x00c6, B:31:0x00ce, B:32:0x00d9, B:35:0x00e1, B:36:0x00ec, B:39:0x00f6, B:41:0x00fc, B:44:0x0104, B:47:0x010f, B:48:0x011a, B:51:0x0122, B:52:0x012d, B:55:0x0135, B:56:0x0140, B:59:0x0148, B:60:0x0153, B:63:0x015b, B:64:0x0166, B:67:0x016e, B:68:0x017d, B:71:0x0185, B:72:0x0190, B:75:0x0198, B:76:0x01a7, B:78:0x01ad, B:79:0x01bc, B:81:0x01c2, B:82:0x01cd, B:85:0x01d5, B:86:0x01e4, B:89:0x01ec, B:90:0x01f7, B:93:0x01ff, B:95:0x020e, B:96:0x020b, B:98:0x01f4, B:99:0x01e1, B:100:0x01ca, B:101:0x01b9, B:102:0x01a4, B:103:0x018d, B:104:0x017a, B:105:0x0163, B:106:0x0150, B:107:0x013d, B:108:0x012a, B:109:0x0117, B:110:0x00e9, B:111:0x00d6, B:112:0x00c3, B:113:0x00b0, B:114:0x0064, B:116:0x006a, B:118:0x0070, B:120:0x0082, B:122:0x007a, B:125:0x0088, B:129:0x0092, B:131:0x009d, B:132:0x004f, B:133:0x003c, B:135:0x021f), top: B:3:0x0007, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x00b0 A[Catch: Exception -> 0x0229, TryCatch #0 {Exception -> 0x0229, blocks: (B:4:0x0007, B:5:0x001a, B:7:0x0020, B:10:0x0030, B:11:0x003f, B:14:0x0047, B:15:0x0052, B:18:0x005c, B:19:0x0060, B:20:0x00a0, B:23:0x00a8, B:24:0x00b3, B:27:0x00bb, B:28:0x00c6, B:31:0x00ce, B:32:0x00d9, B:35:0x00e1, B:36:0x00ec, B:39:0x00f6, B:41:0x00fc, B:44:0x0104, B:47:0x010f, B:48:0x011a, B:51:0x0122, B:52:0x012d, B:55:0x0135, B:56:0x0140, B:59:0x0148, B:60:0x0153, B:63:0x015b, B:64:0x0166, B:67:0x016e, B:68:0x017d, B:71:0x0185, B:72:0x0190, B:75:0x0198, B:76:0x01a7, B:78:0x01ad, B:79:0x01bc, B:81:0x01c2, B:82:0x01cd, B:85:0x01d5, B:86:0x01e4, B:89:0x01ec, B:90:0x01f7, B:93:0x01ff, B:95:0x020e, B:96:0x020b, B:98:0x01f4, B:99:0x01e1, B:100:0x01ca, B:101:0x01b9, B:102:0x01a4, B:103:0x018d, B:104:0x017a, B:105:0x0163, B:106:0x0150, B:107:0x013d, B:108:0x012a, B:109:0x0117, B:110:0x00e9, B:111:0x00d6, B:112:0x00c3, B:113:0x00b0, B:114:0x0064, B:116:0x006a, B:118:0x0070, B:120:0x0082, B:122:0x007a, B:125:0x0088, B:129:0x0092, B:131:0x009d, B:132:0x004f, B:133:0x003c, B:135:0x021f), top: B:3:0x0007, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00a8 A[Catch: Exception -> 0x0229, TRY_ENTER, TryCatch #0 {Exception -> 0x0229, blocks: (B:4:0x0007, B:5:0x001a, B:7:0x0020, B:10:0x0030, B:11:0x003f, B:14:0x0047, B:15:0x0052, B:18:0x005c, B:19:0x0060, B:20:0x00a0, B:23:0x00a8, B:24:0x00b3, B:27:0x00bb, B:28:0x00c6, B:31:0x00ce, B:32:0x00d9, B:35:0x00e1, B:36:0x00ec, B:39:0x00f6, B:41:0x00fc, B:44:0x0104, B:47:0x010f, B:48:0x011a, B:51:0x0122, B:52:0x012d, B:55:0x0135, B:56:0x0140, B:59:0x0148, B:60:0x0153, B:63:0x015b, B:64:0x0166, B:67:0x016e, B:68:0x017d, B:71:0x0185, B:72:0x0190, B:75:0x0198, B:76:0x01a7, B:78:0x01ad, B:79:0x01bc, B:81:0x01c2, B:82:0x01cd, B:85:0x01d5, B:86:0x01e4, B:89:0x01ec, B:90:0x01f7, B:93:0x01ff, B:95:0x020e, B:96:0x020b, B:98:0x01f4, B:99:0x01e1, B:100:0x01ca, B:101:0x01b9, B:102:0x01a4, B:103:0x018d, B:104:0x017a, B:105:0x0163, B:106:0x0150, B:107:0x013d, B:108:0x012a, B:109:0x0117, B:110:0x00e9, B:111:0x00d6, B:112:0x00c3, B:113:0x00b0, B:114:0x0064, B:116:0x006a, B:118:0x0070, B:120:0x0082, B:122:0x007a, B:125:0x0088, B:129:0x0092, B:131:0x009d, B:132:0x004f, B:133:0x003c, B:135:0x021f), top: B:3:0x0007, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00bb A[Catch: Exception -> 0x0229, TRY_ENTER, TryCatch #0 {Exception -> 0x0229, blocks: (B:4:0x0007, B:5:0x001a, B:7:0x0020, B:10:0x0030, B:11:0x003f, B:14:0x0047, B:15:0x0052, B:18:0x005c, B:19:0x0060, B:20:0x00a0, B:23:0x00a8, B:24:0x00b3, B:27:0x00bb, B:28:0x00c6, B:31:0x00ce, B:32:0x00d9, B:35:0x00e1, B:36:0x00ec, B:39:0x00f6, B:41:0x00fc, B:44:0x0104, B:47:0x010f, B:48:0x011a, B:51:0x0122, B:52:0x012d, B:55:0x0135, B:56:0x0140, B:59:0x0148, B:60:0x0153, B:63:0x015b, B:64:0x0166, B:67:0x016e, B:68:0x017d, B:71:0x0185, B:72:0x0190, B:75:0x0198, B:76:0x01a7, B:78:0x01ad, B:79:0x01bc, B:81:0x01c2, B:82:0x01cd, B:85:0x01d5, B:86:0x01e4, B:89:0x01ec, B:90:0x01f7, B:93:0x01ff, B:95:0x020e, B:96:0x020b, B:98:0x01f4, B:99:0x01e1, B:100:0x01ca, B:101:0x01b9, B:102:0x01a4, B:103:0x018d, B:104:0x017a, B:105:0x0163, B:106:0x0150, B:107:0x013d, B:108:0x012a, B:109:0x0117, B:110:0x00e9, B:111:0x00d6, B:112:0x00c3, B:113:0x00b0, B:114:0x0064, B:116:0x006a, B:118:0x0070, B:120:0x0082, B:122:0x007a, B:125:0x0088, B:129:0x0092, B:131:0x009d, B:132:0x004f, B:133:0x003c, B:135:0x021f), top: B:3:0x0007, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ce A[Catch: Exception -> 0x0229, TRY_ENTER, TryCatch #0 {Exception -> 0x0229, blocks: (B:4:0x0007, B:5:0x001a, B:7:0x0020, B:10:0x0030, B:11:0x003f, B:14:0x0047, B:15:0x0052, B:18:0x005c, B:19:0x0060, B:20:0x00a0, B:23:0x00a8, B:24:0x00b3, B:27:0x00bb, B:28:0x00c6, B:31:0x00ce, B:32:0x00d9, B:35:0x00e1, B:36:0x00ec, B:39:0x00f6, B:41:0x00fc, B:44:0x0104, B:47:0x010f, B:48:0x011a, B:51:0x0122, B:52:0x012d, B:55:0x0135, B:56:0x0140, B:59:0x0148, B:60:0x0153, B:63:0x015b, B:64:0x0166, B:67:0x016e, B:68:0x017d, B:71:0x0185, B:72:0x0190, B:75:0x0198, B:76:0x01a7, B:78:0x01ad, B:79:0x01bc, B:81:0x01c2, B:82:0x01cd, B:85:0x01d5, B:86:0x01e4, B:89:0x01ec, B:90:0x01f7, B:93:0x01ff, B:95:0x020e, B:96:0x020b, B:98:0x01f4, B:99:0x01e1, B:100:0x01ca, B:101:0x01b9, B:102:0x01a4, B:103:0x018d, B:104:0x017a, B:105:0x0163, B:106:0x0150, B:107:0x013d, B:108:0x012a, B:109:0x0117, B:110:0x00e9, B:111:0x00d6, B:112:0x00c3, B:113:0x00b0, B:114:0x0064, B:116:0x006a, B:118:0x0070, B:120:0x0082, B:122:0x007a, B:125:0x0088, B:129:0x0092, B:131:0x009d, B:132:0x004f, B:133:0x003c, B:135:0x021f), top: B:3:0x0007, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00e1 A[Catch: Exception -> 0x0229, TRY_ENTER, TryCatch #0 {Exception -> 0x0229, blocks: (B:4:0x0007, B:5:0x001a, B:7:0x0020, B:10:0x0030, B:11:0x003f, B:14:0x0047, B:15:0x0052, B:18:0x005c, B:19:0x0060, B:20:0x00a0, B:23:0x00a8, B:24:0x00b3, B:27:0x00bb, B:28:0x00c6, B:31:0x00ce, B:32:0x00d9, B:35:0x00e1, B:36:0x00ec, B:39:0x00f6, B:41:0x00fc, B:44:0x0104, B:47:0x010f, B:48:0x011a, B:51:0x0122, B:52:0x012d, B:55:0x0135, B:56:0x0140, B:59:0x0148, B:60:0x0153, B:63:0x015b, B:64:0x0166, B:67:0x016e, B:68:0x017d, B:71:0x0185, B:72:0x0190, B:75:0x0198, B:76:0x01a7, B:78:0x01ad, B:79:0x01bc, B:81:0x01c2, B:82:0x01cd, B:85:0x01d5, B:86:0x01e4, B:89:0x01ec, B:90:0x01f7, B:93:0x01ff, B:95:0x020e, B:96:0x020b, B:98:0x01f4, B:99:0x01e1, B:100:0x01ca, B:101:0x01b9, B:102:0x01a4, B:103:0x018d, B:104:0x017a, B:105:0x0163, B:106:0x0150, B:107:0x013d, B:108:0x012a, B:109:0x0117, B:110:0x00e9, B:111:0x00d6, B:112:0x00c3, B:113:0x00b0, B:114:0x0064, B:116:0x006a, B:118:0x0070, B:120:0x0082, B:122:0x007a, B:125:0x0088, B:129:0x0092, B:131:0x009d, B:132:0x004f, B:133:0x003c, B:135:0x021f), top: B:3:0x0007, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0122 A[Catch: Exception -> 0x0229, TRY_ENTER, TryCatch #0 {Exception -> 0x0229, blocks: (B:4:0x0007, B:5:0x001a, B:7:0x0020, B:10:0x0030, B:11:0x003f, B:14:0x0047, B:15:0x0052, B:18:0x005c, B:19:0x0060, B:20:0x00a0, B:23:0x00a8, B:24:0x00b3, B:27:0x00bb, B:28:0x00c6, B:31:0x00ce, B:32:0x00d9, B:35:0x00e1, B:36:0x00ec, B:39:0x00f6, B:41:0x00fc, B:44:0x0104, B:47:0x010f, B:48:0x011a, B:51:0x0122, B:52:0x012d, B:55:0x0135, B:56:0x0140, B:59:0x0148, B:60:0x0153, B:63:0x015b, B:64:0x0166, B:67:0x016e, B:68:0x017d, B:71:0x0185, B:72:0x0190, B:75:0x0198, B:76:0x01a7, B:78:0x01ad, B:79:0x01bc, B:81:0x01c2, B:82:0x01cd, B:85:0x01d5, B:86:0x01e4, B:89:0x01ec, B:90:0x01f7, B:93:0x01ff, B:95:0x020e, B:96:0x020b, B:98:0x01f4, B:99:0x01e1, B:100:0x01ca, B:101:0x01b9, B:102:0x01a4, B:103:0x018d, B:104:0x017a, B:105:0x0163, B:106:0x0150, B:107:0x013d, B:108:0x012a, B:109:0x0117, B:110:0x00e9, B:111:0x00d6, B:112:0x00c3, B:113:0x00b0, B:114:0x0064, B:116:0x006a, B:118:0x0070, B:120:0x0082, B:122:0x007a, B:125:0x0088, B:129:0x0092, B:131:0x009d, B:132:0x004f, B:133:0x003c, B:135:0x021f), top: B:3:0x0007, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0135 A[Catch: Exception -> 0x0229, TRY_ENTER, TryCatch #0 {Exception -> 0x0229, blocks: (B:4:0x0007, B:5:0x001a, B:7:0x0020, B:10:0x0030, B:11:0x003f, B:14:0x0047, B:15:0x0052, B:18:0x005c, B:19:0x0060, B:20:0x00a0, B:23:0x00a8, B:24:0x00b3, B:27:0x00bb, B:28:0x00c6, B:31:0x00ce, B:32:0x00d9, B:35:0x00e1, B:36:0x00ec, B:39:0x00f6, B:41:0x00fc, B:44:0x0104, B:47:0x010f, B:48:0x011a, B:51:0x0122, B:52:0x012d, B:55:0x0135, B:56:0x0140, B:59:0x0148, B:60:0x0153, B:63:0x015b, B:64:0x0166, B:67:0x016e, B:68:0x017d, B:71:0x0185, B:72:0x0190, B:75:0x0198, B:76:0x01a7, B:78:0x01ad, B:79:0x01bc, B:81:0x01c2, B:82:0x01cd, B:85:0x01d5, B:86:0x01e4, B:89:0x01ec, B:90:0x01f7, B:93:0x01ff, B:95:0x020e, B:96:0x020b, B:98:0x01f4, B:99:0x01e1, B:100:0x01ca, B:101:0x01b9, B:102:0x01a4, B:103:0x018d, B:104:0x017a, B:105:0x0163, B:106:0x0150, B:107:0x013d, B:108:0x012a, B:109:0x0117, B:110:0x00e9, B:111:0x00d6, B:112:0x00c3, B:113:0x00b0, B:114:0x0064, B:116:0x006a, B:118:0x0070, B:120:0x0082, B:122:0x007a, B:125:0x0088, B:129:0x0092, B:131:0x009d, B:132:0x004f, B:133:0x003c, B:135:0x021f), top: B:3:0x0007, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0148 A[Catch: Exception -> 0x0229, TRY_ENTER, TryCatch #0 {Exception -> 0x0229, blocks: (B:4:0x0007, B:5:0x001a, B:7:0x0020, B:10:0x0030, B:11:0x003f, B:14:0x0047, B:15:0x0052, B:18:0x005c, B:19:0x0060, B:20:0x00a0, B:23:0x00a8, B:24:0x00b3, B:27:0x00bb, B:28:0x00c6, B:31:0x00ce, B:32:0x00d9, B:35:0x00e1, B:36:0x00ec, B:39:0x00f6, B:41:0x00fc, B:44:0x0104, B:47:0x010f, B:48:0x011a, B:51:0x0122, B:52:0x012d, B:55:0x0135, B:56:0x0140, B:59:0x0148, B:60:0x0153, B:63:0x015b, B:64:0x0166, B:67:0x016e, B:68:0x017d, B:71:0x0185, B:72:0x0190, B:75:0x0198, B:76:0x01a7, B:78:0x01ad, B:79:0x01bc, B:81:0x01c2, B:82:0x01cd, B:85:0x01d5, B:86:0x01e4, B:89:0x01ec, B:90:0x01f7, B:93:0x01ff, B:95:0x020e, B:96:0x020b, B:98:0x01f4, B:99:0x01e1, B:100:0x01ca, B:101:0x01b9, B:102:0x01a4, B:103:0x018d, B:104:0x017a, B:105:0x0163, B:106:0x0150, B:107:0x013d, B:108:0x012a, B:109:0x0117, B:110:0x00e9, B:111:0x00d6, B:112:0x00c3, B:113:0x00b0, B:114:0x0064, B:116:0x006a, B:118:0x0070, B:120:0x0082, B:122:0x007a, B:125:0x0088, B:129:0x0092, B:131:0x009d, B:132:0x004f, B:133:0x003c, B:135:0x021f), top: B:3:0x0007, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x015b A[Catch: Exception -> 0x0229, TRY_ENTER, TryCatch #0 {Exception -> 0x0229, blocks: (B:4:0x0007, B:5:0x001a, B:7:0x0020, B:10:0x0030, B:11:0x003f, B:14:0x0047, B:15:0x0052, B:18:0x005c, B:19:0x0060, B:20:0x00a0, B:23:0x00a8, B:24:0x00b3, B:27:0x00bb, B:28:0x00c6, B:31:0x00ce, B:32:0x00d9, B:35:0x00e1, B:36:0x00ec, B:39:0x00f6, B:41:0x00fc, B:44:0x0104, B:47:0x010f, B:48:0x011a, B:51:0x0122, B:52:0x012d, B:55:0x0135, B:56:0x0140, B:59:0x0148, B:60:0x0153, B:63:0x015b, B:64:0x0166, B:67:0x016e, B:68:0x017d, B:71:0x0185, B:72:0x0190, B:75:0x0198, B:76:0x01a7, B:78:0x01ad, B:79:0x01bc, B:81:0x01c2, B:82:0x01cd, B:85:0x01d5, B:86:0x01e4, B:89:0x01ec, B:90:0x01f7, B:93:0x01ff, B:95:0x020e, B:96:0x020b, B:98:0x01f4, B:99:0x01e1, B:100:0x01ca, B:101:0x01b9, B:102:0x01a4, B:103:0x018d, B:104:0x017a, B:105:0x0163, B:106:0x0150, B:107:0x013d, B:108:0x012a, B:109:0x0117, B:110:0x00e9, B:111:0x00d6, B:112:0x00c3, B:113:0x00b0, B:114:0x0064, B:116:0x006a, B:118:0x0070, B:120:0x0082, B:122:0x007a, B:125:0x0088, B:129:0x0092, B:131:0x009d, B:132:0x004f, B:133:0x003c, B:135:0x021f), top: B:3:0x0007, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x016e A[Catch: Exception -> 0x0229, TRY_ENTER, TryCatch #0 {Exception -> 0x0229, blocks: (B:4:0x0007, B:5:0x001a, B:7:0x0020, B:10:0x0030, B:11:0x003f, B:14:0x0047, B:15:0x0052, B:18:0x005c, B:19:0x0060, B:20:0x00a0, B:23:0x00a8, B:24:0x00b3, B:27:0x00bb, B:28:0x00c6, B:31:0x00ce, B:32:0x00d9, B:35:0x00e1, B:36:0x00ec, B:39:0x00f6, B:41:0x00fc, B:44:0x0104, B:47:0x010f, B:48:0x011a, B:51:0x0122, B:52:0x012d, B:55:0x0135, B:56:0x0140, B:59:0x0148, B:60:0x0153, B:63:0x015b, B:64:0x0166, B:67:0x016e, B:68:0x017d, B:71:0x0185, B:72:0x0190, B:75:0x0198, B:76:0x01a7, B:78:0x01ad, B:79:0x01bc, B:81:0x01c2, B:82:0x01cd, B:85:0x01d5, B:86:0x01e4, B:89:0x01ec, B:90:0x01f7, B:93:0x01ff, B:95:0x020e, B:96:0x020b, B:98:0x01f4, B:99:0x01e1, B:100:0x01ca, B:101:0x01b9, B:102:0x01a4, B:103:0x018d, B:104:0x017a, B:105:0x0163, B:106:0x0150, B:107:0x013d, B:108:0x012a, B:109:0x0117, B:110:0x00e9, B:111:0x00d6, B:112:0x00c3, B:113:0x00b0, B:114:0x0064, B:116:0x006a, B:118:0x0070, B:120:0x0082, B:122:0x007a, B:125:0x0088, B:129:0x0092, B:131:0x009d, B:132:0x004f, B:133:0x003c, B:135:0x021f), top: B:3:0x0007, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0185 A[Catch: Exception -> 0x0229, TRY_ENTER, TryCatch #0 {Exception -> 0x0229, blocks: (B:4:0x0007, B:5:0x001a, B:7:0x0020, B:10:0x0030, B:11:0x003f, B:14:0x0047, B:15:0x0052, B:18:0x005c, B:19:0x0060, B:20:0x00a0, B:23:0x00a8, B:24:0x00b3, B:27:0x00bb, B:28:0x00c6, B:31:0x00ce, B:32:0x00d9, B:35:0x00e1, B:36:0x00ec, B:39:0x00f6, B:41:0x00fc, B:44:0x0104, B:47:0x010f, B:48:0x011a, B:51:0x0122, B:52:0x012d, B:55:0x0135, B:56:0x0140, B:59:0x0148, B:60:0x0153, B:63:0x015b, B:64:0x0166, B:67:0x016e, B:68:0x017d, B:71:0x0185, B:72:0x0190, B:75:0x0198, B:76:0x01a7, B:78:0x01ad, B:79:0x01bc, B:81:0x01c2, B:82:0x01cd, B:85:0x01d5, B:86:0x01e4, B:89:0x01ec, B:90:0x01f7, B:93:0x01ff, B:95:0x020e, B:96:0x020b, B:98:0x01f4, B:99:0x01e1, B:100:0x01ca, B:101:0x01b9, B:102:0x01a4, B:103:0x018d, B:104:0x017a, B:105:0x0163, B:106:0x0150, B:107:0x013d, B:108:0x012a, B:109:0x0117, B:110:0x00e9, B:111:0x00d6, B:112:0x00c3, B:113:0x00b0, B:114:0x0064, B:116:0x006a, B:118:0x0070, B:120:0x0082, B:122:0x007a, B:125:0x0088, B:129:0x0092, B:131:0x009d, B:132:0x004f, B:133:0x003c, B:135:0x021f), top: B:3:0x0007, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0198 A[Catch: Exception -> 0x0229, TRY_ENTER, TryCatch #0 {Exception -> 0x0229, blocks: (B:4:0x0007, B:5:0x001a, B:7:0x0020, B:10:0x0030, B:11:0x003f, B:14:0x0047, B:15:0x0052, B:18:0x005c, B:19:0x0060, B:20:0x00a0, B:23:0x00a8, B:24:0x00b3, B:27:0x00bb, B:28:0x00c6, B:31:0x00ce, B:32:0x00d9, B:35:0x00e1, B:36:0x00ec, B:39:0x00f6, B:41:0x00fc, B:44:0x0104, B:47:0x010f, B:48:0x011a, B:51:0x0122, B:52:0x012d, B:55:0x0135, B:56:0x0140, B:59:0x0148, B:60:0x0153, B:63:0x015b, B:64:0x0166, B:67:0x016e, B:68:0x017d, B:71:0x0185, B:72:0x0190, B:75:0x0198, B:76:0x01a7, B:78:0x01ad, B:79:0x01bc, B:81:0x01c2, B:82:0x01cd, B:85:0x01d5, B:86:0x01e4, B:89:0x01ec, B:90:0x01f7, B:93:0x01ff, B:95:0x020e, B:96:0x020b, B:98:0x01f4, B:99:0x01e1, B:100:0x01ca, B:101:0x01b9, B:102:0x01a4, B:103:0x018d, B:104:0x017a, B:105:0x0163, B:106:0x0150, B:107:0x013d, B:108:0x012a, B:109:0x0117, B:110:0x00e9, B:111:0x00d6, B:112:0x00c3, B:113:0x00b0, B:114:0x0064, B:116:0x006a, B:118:0x0070, B:120:0x0082, B:122:0x007a, B:125:0x0088, B:129:0x0092, B:131:0x009d, B:132:0x004f, B:133:0x003c, B:135:0x021f), top: B:3:0x0007, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01ad A[Catch: Exception -> 0x0229, TryCatch #0 {Exception -> 0x0229, blocks: (B:4:0x0007, B:5:0x001a, B:7:0x0020, B:10:0x0030, B:11:0x003f, B:14:0x0047, B:15:0x0052, B:18:0x005c, B:19:0x0060, B:20:0x00a0, B:23:0x00a8, B:24:0x00b3, B:27:0x00bb, B:28:0x00c6, B:31:0x00ce, B:32:0x00d9, B:35:0x00e1, B:36:0x00ec, B:39:0x00f6, B:41:0x00fc, B:44:0x0104, B:47:0x010f, B:48:0x011a, B:51:0x0122, B:52:0x012d, B:55:0x0135, B:56:0x0140, B:59:0x0148, B:60:0x0153, B:63:0x015b, B:64:0x0166, B:67:0x016e, B:68:0x017d, B:71:0x0185, B:72:0x0190, B:75:0x0198, B:76:0x01a7, B:78:0x01ad, B:79:0x01bc, B:81:0x01c2, B:82:0x01cd, B:85:0x01d5, B:86:0x01e4, B:89:0x01ec, B:90:0x01f7, B:93:0x01ff, B:95:0x020e, B:96:0x020b, B:98:0x01f4, B:99:0x01e1, B:100:0x01ca, B:101:0x01b9, B:102:0x01a4, B:103:0x018d, B:104:0x017a, B:105:0x0163, B:106:0x0150, B:107:0x013d, B:108:0x012a, B:109:0x0117, B:110:0x00e9, B:111:0x00d6, B:112:0x00c3, B:113:0x00b0, B:114:0x0064, B:116:0x006a, B:118:0x0070, B:120:0x0082, B:122:0x007a, B:125:0x0088, B:129:0x0092, B:131:0x009d, B:132:0x004f, B:133:0x003c, B:135:0x021f), top: B:3:0x0007, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01c2 A[Catch: Exception -> 0x0229, TryCatch #0 {Exception -> 0x0229, blocks: (B:4:0x0007, B:5:0x001a, B:7:0x0020, B:10:0x0030, B:11:0x003f, B:14:0x0047, B:15:0x0052, B:18:0x005c, B:19:0x0060, B:20:0x00a0, B:23:0x00a8, B:24:0x00b3, B:27:0x00bb, B:28:0x00c6, B:31:0x00ce, B:32:0x00d9, B:35:0x00e1, B:36:0x00ec, B:39:0x00f6, B:41:0x00fc, B:44:0x0104, B:47:0x010f, B:48:0x011a, B:51:0x0122, B:52:0x012d, B:55:0x0135, B:56:0x0140, B:59:0x0148, B:60:0x0153, B:63:0x015b, B:64:0x0166, B:67:0x016e, B:68:0x017d, B:71:0x0185, B:72:0x0190, B:75:0x0198, B:76:0x01a7, B:78:0x01ad, B:79:0x01bc, B:81:0x01c2, B:82:0x01cd, B:85:0x01d5, B:86:0x01e4, B:89:0x01ec, B:90:0x01f7, B:93:0x01ff, B:95:0x020e, B:96:0x020b, B:98:0x01f4, B:99:0x01e1, B:100:0x01ca, B:101:0x01b9, B:102:0x01a4, B:103:0x018d, B:104:0x017a, B:105:0x0163, B:106:0x0150, B:107:0x013d, B:108:0x012a, B:109:0x0117, B:110:0x00e9, B:111:0x00d6, B:112:0x00c3, B:113:0x00b0, B:114:0x0064, B:116:0x006a, B:118:0x0070, B:120:0x0082, B:122:0x007a, B:125:0x0088, B:129:0x0092, B:131:0x009d, B:132:0x004f, B:133:0x003c, B:135:0x021f), top: B:3:0x0007, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01d5 A[Catch: Exception -> 0x0229, TRY_ENTER, TryCatch #0 {Exception -> 0x0229, blocks: (B:4:0x0007, B:5:0x001a, B:7:0x0020, B:10:0x0030, B:11:0x003f, B:14:0x0047, B:15:0x0052, B:18:0x005c, B:19:0x0060, B:20:0x00a0, B:23:0x00a8, B:24:0x00b3, B:27:0x00bb, B:28:0x00c6, B:31:0x00ce, B:32:0x00d9, B:35:0x00e1, B:36:0x00ec, B:39:0x00f6, B:41:0x00fc, B:44:0x0104, B:47:0x010f, B:48:0x011a, B:51:0x0122, B:52:0x012d, B:55:0x0135, B:56:0x0140, B:59:0x0148, B:60:0x0153, B:63:0x015b, B:64:0x0166, B:67:0x016e, B:68:0x017d, B:71:0x0185, B:72:0x0190, B:75:0x0198, B:76:0x01a7, B:78:0x01ad, B:79:0x01bc, B:81:0x01c2, B:82:0x01cd, B:85:0x01d5, B:86:0x01e4, B:89:0x01ec, B:90:0x01f7, B:93:0x01ff, B:95:0x020e, B:96:0x020b, B:98:0x01f4, B:99:0x01e1, B:100:0x01ca, B:101:0x01b9, B:102:0x01a4, B:103:0x018d, B:104:0x017a, B:105:0x0163, B:106:0x0150, B:107:0x013d, B:108:0x012a, B:109:0x0117, B:110:0x00e9, B:111:0x00d6, B:112:0x00c3, B:113:0x00b0, B:114:0x0064, B:116:0x006a, B:118:0x0070, B:120:0x0082, B:122:0x007a, B:125:0x0088, B:129:0x0092, B:131:0x009d, B:132:0x004f, B:133:0x003c, B:135:0x021f), top: B:3:0x0007, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01ec A[Catch: Exception -> 0x0229, TRY_ENTER, TryCatch #0 {Exception -> 0x0229, blocks: (B:4:0x0007, B:5:0x001a, B:7:0x0020, B:10:0x0030, B:11:0x003f, B:14:0x0047, B:15:0x0052, B:18:0x005c, B:19:0x0060, B:20:0x00a0, B:23:0x00a8, B:24:0x00b3, B:27:0x00bb, B:28:0x00c6, B:31:0x00ce, B:32:0x00d9, B:35:0x00e1, B:36:0x00ec, B:39:0x00f6, B:41:0x00fc, B:44:0x0104, B:47:0x010f, B:48:0x011a, B:51:0x0122, B:52:0x012d, B:55:0x0135, B:56:0x0140, B:59:0x0148, B:60:0x0153, B:63:0x015b, B:64:0x0166, B:67:0x016e, B:68:0x017d, B:71:0x0185, B:72:0x0190, B:75:0x0198, B:76:0x01a7, B:78:0x01ad, B:79:0x01bc, B:81:0x01c2, B:82:0x01cd, B:85:0x01d5, B:86:0x01e4, B:89:0x01ec, B:90:0x01f7, B:93:0x01ff, B:95:0x020e, B:96:0x020b, B:98:0x01f4, B:99:0x01e1, B:100:0x01ca, B:101:0x01b9, B:102:0x01a4, B:103:0x018d, B:104:0x017a, B:105:0x0163, B:106:0x0150, B:107:0x013d, B:108:0x012a, B:109:0x0117, B:110:0x00e9, B:111:0x00d6, B:112:0x00c3, B:113:0x00b0, B:114:0x0064, B:116:0x006a, B:118:0x0070, B:120:0x0082, B:122:0x007a, B:125:0x0088, B:129:0x0092, B:131:0x009d, B:132:0x004f, B:133:0x003c, B:135:0x021f), top: B:3:0x0007, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01ff A[Catch: Exception -> 0x0229, TRY_ENTER, TryCatch #0 {Exception -> 0x0229, blocks: (B:4:0x0007, B:5:0x001a, B:7:0x0020, B:10:0x0030, B:11:0x003f, B:14:0x0047, B:15:0x0052, B:18:0x005c, B:19:0x0060, B:20:0x00a0, B:23:0x00a8, B:24:0x00b3, B:27:0x00bb, B:28:0x00c6, B:31:0x00ce, B:32:0x00d9, B:35:0x00e1, B:36:0x00ec, B:39:0x00f6, B:41:0x00fc, B:44:0x0104, B:47:0x010f, B:48:0x011a, B:51:0x0122, B:52:0x012d, B:55:0x0135, B:56:0x0140, B:59:0x0148, B:60:0x0153, B:63:0x015b, B:64:0x0166, B:67:0x016e, B:68:0x017d, B:71:0x0185, B:72:0x0190, B:75:0x0198, B:76:0x01a7, B:78:0x01ad, B:79:0x01bc, B:81:0x01c2, B:82:0x01cd, B:85:0x01d5, B:86:0x01e4, B:89:0x01ec, B:90:0x01f7, B:93:0x01ff, B:95:0x020e, B:96:0x020b, B:98:0x01f4, B:99:0x01e1, B:100:0x01ca, B:101:0x01b9, B:102:0x01a4, B:103:0x018d, B:104:0x017a, B:105:0x0163, B:106:0x0150, B:107:0x013d, B:108:0x012a, B:109:0x0117, B:110:0x00e9, B:111:0x00d6, B:112:0x00c3, B:113:0x00b0, B:114:0x0064, B:116:0x006a, B:118:0x0070, B:120:0x0082, B:122:0x007a, B:125:0x0088, B:129:0x0092, B:131:0x009d, B:132:0x004f, B:133:0x003c, B:135:0x021f), top: B:3:0x0007, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x020b A[Catch: Exception -> 0x0229, TryCatch #0 {Exception -> 0x0229, blocks: (B:4:0x0007, B:5:0x001a, B:7:0x0020, B:10:0x0030, B:11:0x003f, B:14:0x0047, B:15:0x0052, B:18:0x005c, B:19:0x0060, B:20:0x00a0, B:23:0x00a8, B:24:0x00b3, B:27:0x00bb, B:28:0x00c6, B:31:0x00ce, B:32:0x00d9, B:35:0x00e1, B:36:0x00ec, B:39:0x00f6, B:41:0x00fc, B:44:0x0104, B:47:0x010f, B:48:0x011a, B:51:0x0122, B:52:0x012d, B:55:0x0135, B:56:0x0140, B:59:0x0148, B:60:0x0153, B:63:0x015b, B:64:0x0166, B:67:0x016e, B:68:0x017d, B:71:0x0185, B:72:0x0190, B:75:0x0198, B:76:0x01a7, B:78:0x01ad, B:79:0x01bc, B:81:0x01c2, B:82:0x01cd, B:85:0x01d5, B:86:0x01e4, B:89:0x01ec, B:90:0x01f7, B:93:0x01ff, B:95:0x020e, B:96:0x020b, B:98:0x01f4, B:99:0x01e1, B:100:0x01ca, B:101:0x01b9, B:102:0x01a4, B:103:0x018d, B:104:0x017a, B:105:0x0163, B:106:0x0150, B:107:0x013d, B:108:0x012a, B:109:0x0117, B:110:0x00e9, B:111:0x00d6, B:112:0x00c3, B:113:0x00b0, B:114:0x0064, B:116:0x006a, B:118:0x0070, B:120:0x0082, B:122:0x007a, B:125:0x0088, B:129:0x0092, B:131:0x009d, B:132:0x004f, B:133:0x003c, B:135:0x021f), top: B:3:0x0007, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01f4 A[Catch: Exception -> 0x0229, TryCatch #0 {Exception -> 0x0229, blocks: (B:4:0x0007, B:5:0x001a, B:7:0x0020, B:10:0x0030, B:11:0x003f, B:14:0x0047, B:15:0x0052, B:18:0x005c, B:19:0x0060, B:20:0x00a0, B:23:0x00a8, B:24:0x00b3, B:27:0x00bb, B:28:0x00c6, B:31:0x00ce, B:32:0x00d9, B:35:0x00e1, B:36:0x00ec, B:39:0x00f6, B:41:0x00fc, B:44:0x0104, B:47:0x010f, B:48:0x011a, B:51:0x0122, B:52:0x012d, B:55:0x0135, B:56:0x0140, B:59:0x0148, B:60:0x0153, B:63:0x015b, B:64:0x0166, B:67:0x016e, B:68:0x017d, B:71:0x0185, B:72:0x0190, B:75:0x0198, B:76:0x01a7, B:78:0x01ad, B:79:0x01bc, B:81:0x01c2, B:82:0x01cd, B:85:0x01d5, B:86:0x01e4, B:89:0x01ec, B:90:0x01f7, B:93:0x01ff, B:95:0x020e, B:96:0x020b, B:98:0x01f4, B:99:0x01e1, B:100:0x01ca, B:101:0x01b9, B:102:0x01a4, B:103:0x018d, B:104:0x017a, B:105:0x0163, B:106:0x0150, B:107:0x013d, B:108:0x012a, B:109:0x0117, B:110:0x00e9, B:111:0x00d6, B:112:0x00c3, B:113:0x00b0, B:114:0x0064, B:116:0x006a, B:118:0x0070, B:120:0x0082, B:122:0x007a, B:125:0x0088, B:129:0x0092, B:131:0x009d, B:132:0x004f, B:133:0x003c, B:135:0x021f), top: B:3:0x0007, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01e1 A[Catch: Exception -> 0x0229, TryCatch #0 {Exception -> 0x0229, blocks: (B:4:0x0007, B:5:0x001a, B:7:0x0020, B:10:0x0030, B:11:0x003f, B:14:0x0047, B:15:0x0052, B:18:0x005c, B:19:0x0060, B:20:0x00a0, B:23:0x00a8, B:24:0x00b3, B:27:0x00bb, B:28:0x00c6, B:31:0x00ce, B:32:0x00d9, B:35:0x00e1, B:36:0x00ec, B:39:0x00f6, B:41:0x00fc, B:44:0x0104, B:47:0x010f, B:48:0x011a, B:51:0x0122, B:52:0x012d, B:55:0x0135, B:56:0x0140, B:59:0x0148, B:60:0x0153, B:63:0x015b, B:64:0x0166, B:67:0x016e, B:68:0x017d, B:71:0x0185, B:72:0x0190, B:75:0x0198, B:76:0x01a7, B:78:0x01ad, B:79:0x01bc, B:81:0x01c2, B:82:0x01cd, B:85:0x01d5, B:86:0x01e4, B:89:0x01ec, B:90:0x01f7, B:93:0x01ff, B:95:0x020e, B:96:0x020b, B:98:0x01f4, B:99:0x01e1, B:100:0x01ca, B:101:0x01b9, B:102:0x01a4, B:103:0x018d, B:104:0x017a, B:105:0x0163, B:106:0x0150, B:107:0x013d, B:108:0x012a, B:109:0x0117, B:110:0x00e9, B:111:0x00d6, B:112:0x00c3, B:113:0x00b0, B:114:0x0064, B:116:0x006a, B:118:0x0070, B:120:0x0082, B:122:0x007a, B:125:0x0088, B:129:0x0092, B:131:0x009d, B:132:0x004f, B:133:0x003c, B:135:0x021f), top: B:3:0x0007, outer: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void addAllAvailableChannel(java.util.Map r11) {
        /*
            Method dump skipped, instructions count: 564
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler.addAllAvailableChannel(java.util.Map):void");
    }

    public void deleteALLLiveRecentlyWatched(int i, String str) {
        try {
            getWritableDatabase().execSQL("DELETE FROM iptv_live_watched WHERE user_id_referred = '" + i + "' AND app_type = '" + str + "'");
        } catch (SQLiteDatabaseLockedException | Exception unused) {
            Log.w("msg", "exception");
        }
    }

    public void deleteImportStatusForUser(int i, String str, String str2) {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            this.db = writableDatabase;
            writableDatabase.delete("iptv_import_status", "user_id_referred='" + i + "' AND app_type='" + str2 + "' AND source_ref_id='" + str + "'", (String[]) null);
        } catch (SQLiteDatabaseLockedException | Exception unused) {
        }
    }

    public void deletePasswordDataForUser(int i, String str) {
        String str2;
        String str3;
        if (str.equals("m3u")) {
            str2 = "iptv_password_table_m3u";
            str3 = "iptv_password_status_table_m3u";
        } else {
            str2 = "iptv_password_table";
            str3 = "iptv_password_status_table";
        }
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            this.db = writableDatabase;
            writableDatabase.delete(str2, "user_id_referred='" + i + "'", (String[]) null);
            this.db.delete(str3, "user_id_referred='" + i + "'", (String[]) null);
            this.db.close();
        } catch (SQLiteDatabaseLockedException | Exception unused) {
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:400:0x1d63, code lost:
    
        r38 = " FROM ";
        r37 = " WHERE ";
     */
    /* JADX WARN: Code restructure failed: missing block: B:411:0x1d6b, code lost:
    
        r37 = " WHERE ";
        r38 = " FROM ";
     */
    /* JADX WARN: Code restructure failed: missing block: B:414:0x1d80, code lost:
    
        r38 = " FROM ";
        r37 = " WHERE ";
     */
    /* JADX WARN: Code restructure failed: missing block: B:417:0x1d92, code lost:
    
        r38 = " FROM ";
        r37 = " WHERE ";
     */
    /* JADX WARN: Code restructure failed: missing block: B:420:0x1da4, code lost:
    
        r38 = " FROM ";
        r37 = " WHERE ";
     */
    /* JADX WARN: Code restructure failed: missing block: B:423:0x1db6, code lost:
    
        r38 = " FROM ";
        r37 = " WHERE ";
     */
    /* JADX WARN: Code restructure failed: missing block: B:426:0x1dc8, code lost:
    
        r38 = " FROM ";
        r37 = " WHERE ";
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:237:0x0ff7. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:117:0x08b7  */
    /* JADX WARN: Removed duplicated region for block: B:11:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0b00  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x0d8e  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x0fcb  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x1304 A[PHI: r78
      0x1304: PHI (r78v2 java.lang.String) = (r78v1 java.lang.String), (r78v1 java.lang.String), (r78v3 java.lang.String) binds: [B:334:0x1302, B:330:0x12f4, B:261:0x12e3] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:264:0x130e  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x24e3 A[PHI: r72
      0x24e3: PHI (r72v3 java.util.ArrayList) = (r72v0 java.util.ArrayList), (r72v1 java.util.ArrayList) binds: [B:276:0x24d2, B:296:0x24dd] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:287:0x24d4 A[EXC_TOP_SPLITTER, LOOP:2: B:287:0x24d4->B:292:0x25be, LOOP_START, PHI: r72
      0x24d4: PHI (r72v1 java.util.ArrayList) = (r72v0 java.util.ArrayList), (r72v2 java.util.ArrayList) binds: [B:276:0x24d2, B:292:0x25be] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:341:0x1647  */
    /* JADX WARN: Removed duplicated region for block: B:372:0x19b9  */
    /* JADX WARN: Removed duplicated region for block: B:401:0x1d67 A[PHI: r37 r38
      0x1d67: PHI (r37v19 java.lang.String) = 
      (r37v12 java.lang.String)
      (r37v13 java.lang.String)
      (r37v14 java.lang.String)
      (r37v15 java.lang.String)
      (r37v16 java.lang.String)
      (r37v17 java.lang.String)
      (r37v20 java.lang.String)
     binds: [B:427:0x1dd4, B:424:0x1dc2, B:421:0x1db0, B:418:0x1d9e, B:415:0x1d8c, B:412:0x1d77, B:400:0x1d63] A[DONT_GENERATE, DONT_INLINE]
      0x1d67: PHI (r38v20 java.lang.String) = 
      (r38v13 java.lang.String)
      (r38v14 java.lang.String)
      (r38v15 java.lang.String)
      (r38v16 java.lang.String)
      (r38v17 java.lang.String)
      (r38v18 java.lang.String)
      (r38v21 java.lang.String)
     binds: [B:427:0x1dd4, B:424:0x1dc2, B:421:0x1db0, B:418:0x1d9e, B:415:0x1d8c, B:412:0x1d77, B:400:0x1d63] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:432:0x214a  */
    /* JADX WARN: Removed duplicated region for block: B:461:0x2630 A[PHI: r18
      0x2630: PHI (r18v7 java.lang.String) = (r18v3 java.lang.String), (r18v3 java.lang.String), (r18v8 java.lang.String) binds: [B:532:0x262e, B:528:0x2620, B:460:0x260f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:463:0x263a  */
    /* JADX WARN: Removed duplicated region for block: B:474:0x37d8  */
    /* JADX WARN: Removed duplicated region for block: B:495:0x38c8  */
    /* JADX WARN: Removed duplicated region for block: B:539:0x296b  */
    /* JADX WARN: Removed duplicated region for block: B:570:0x2cc2  */
    /* JADX WARN: Removed duplicated region for block: B:602:0x3074 A[PHI: r37 r38
      0x3074: PHI (r37v9 java.lang.String) = 
      (r37v2 java.lang.String)
      (r37v3 java.lang.String)
      (r37v4 java.lang.String)
      (r37v5 java.lang.String)
      (r37v6 java.lang.String)
      (r37v7 java.lang.String)
      (r37v10 java.lang.String)
     binds: [B:629:0x30e1, B:626:0x30cf, B:623:0x30bd, B:620:0x30ab, B:617:0x3099, B:614:0x3084, B:601:0x3070] A[DONT_GENERATE, DONT_INLINE]
      0x3074: PHI (r38v10 java.lang.String) = 
      (r38v3 java.lang.String)
      (r38v4 java.lang.String)
      (r38v5 java.lang.String)
      (r38v6 java.lang.String)
      (r38v7 java.lang.String)
      (r38v8 java.lang.String)
      (r38v11 java.lang.String)
     binds: [B:629:0x30e1, B:626:0x30cf, B:623:0x30bd, B:620:0x30ab, B:617:0x3099, B:614:0x3084, B:601:0x3070] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:634:0x3457  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x03f9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.ArrayList getAllLiveStreasWithCategoryId(java.lang.String r184, java.lang.String r185) {
        /*
            Method dump skipped, instructions count: 15030
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler.getAllLiveStreasWithCategoryId(java.lang.String, java.lang.String):java.util.ArrayList");
    }

    public String getMagportal() {
        String str;
        new ArrayList();
        try {
            Cursor rawQuery = getReadableDatabase().rawQuery("SELECT  * FROM iptv_mag_portal_table", (String[]) null);
            if (rawQuery.moveToFirst()) {
                do {
                    str = rawQuery.getString(1);
                } while (rawQuery.moveToNext());
            } else {
                str = "";
            }
            rawQuery.close();
            return str;
        } catch (SQLiteDatabaseLockedException | Exception unused) {
            return "";
        }
    }

    public ImportStatusModel getdateDBStatus(String str, String str2) {
        try {
            Cursor rawQuery = getReadableDatabase().rawQuery("SELECT * FROM iptv_import_status WHERE type = '" + str + "' AND user_id_referred = '" + SharepreferenceDBHandler.getUserID(this.context) + "' AND app_type = '" + SharepreferenceDBHandler.getCurrentAPPType(this.context) + "' AND source_ref_id = '" + str2 + "'", (String[]) null);
            ImportStatusModel importStatusModel = new ImportStatusModel();
            if (rawQuery.moveToFirst()) {
                do {
                    importStatusModel.setIdAuto(w.r0(rawQuery.getString(0)));
                    importStatusModel.setType(rawQuery.getString(1));
                    importStatusModel.setStatus(rawQuery.getString(2));
                    importStatusModel.setDate(rawQuery.getString(3));
                    importStatusModel.setTime(rawQuery.getString(4));
                    importStatusModel.setSourceRef(rawQuery.getString(7));
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
            return importStatusModel;
        } catch (SQLiteDatabaseLockedException | Exception unused) {
            return null;
        }
    }

    public void makeEmptyAllTablesRecordsM3U(int i) {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.execSQL("DELETE FROM iptv_movie_category_m3u WHERE user_id_referred='" + i + "'");
            writableDatabase.execSQL("DELETE FROM iptv_series_category_m3u WHERE user_id_referred='" + i + "'");
            writableDatabase.execSQL("DELETE FROM iptv_live_category_m3u WHERE user_id_referred='" + i + "'");
            writableDatabase.execSQL("DELETE FROM iptv_live_streams_m3u WHERE user_id_referred='" + i + "'");
            writableDatabase.execSQL("DELETE FROM iptv_m3u_all_category WHERE user_id_referred='" + i + "'");
            writableDatabase.execSQL("DELETE FROM iptv_m3u_favourites WHERE user_id_referred='" + i + "'");
            writableDatabase.close();
        } catch (SQLiteDatabaseLockedException | Exception unused) {
            Log.w("msg", "exception");
        }
    }

    public void makeEmptyEPGWithSourceRef(String str) {
        try {
            int userID = SharepreferenceDBHandler.getUserID(this.context);
            String str2 = SharepreferenceDBHandler.getCurrentAPPType(this.context).equals("m3u") ? "epg_m3u" : "epg";
            getWritableDatabase().execSQL("DELETE FROM " + str2 + " WHERE user_id_referred = '" + userID + "' AND source_ref_id = '" + str + "'");
        } catch (SQLiteDatabaseLockedException | Exception unused) {
            Log.w("msg", "exception");
        }
    }

    public void updateImportStatus(String str, String str2, String str3) {
        try {
            int userID = SharepreferenceDBHandler.getUserID(this.context);
            String currentAPPType = SharepreferenceDBHandler.getCurrentAPPType(this.context);
            SQLiteDatabase writableDatabase = getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("status", str2);
            contentValues.put("date", w.q());
            contentValues.put("time", Long.valueOf(System.currentTimeMillis()));
            writableDatabase.update("iptv_import_status", contentValues, "type = ? AND user_id_referred = ? AND app_type = ? AND source_ref_id = ?", new String[]{String.valueOf(str), String.valueOf(userID), String.valueOf(currentAPPType), String.valueOf(str3)});
        } catch (SQLiteDatabaseLockedException | Exception unused) {
            Log.w("msg", "exception");
        }
    }

    public boolean addAllAvailableChannel(List list) {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.beginTransaction();
            try {
                try {
                    int userID = SharepreferenceDBHandler.getUserID(this.context);
                    ContentValues contentValues = new ContentValues();
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        LiveStreamsCallback liveStreamsCallback = (LiveStreamsCallback) it.next();
                        w.q = true;
                        if (liveStreamsCallback.getNum() != null) {
                            contentValues.put("num", String.valueOf(liveStreamsCallback.getNum()));
                        } else {
                            contentValues.put("num", "");
                        }
                        if (liveStreamsCallback.getName() != null) {
                            contentValues.put("name", liveStreamsCallback.getName());
                        } else {
                            contentValues.put("name", "");
                        }
                        if (liveStreamsCallback.getStreamType() != null) {
                            contentValues.put("stream_type", liveStreamsCallback.getStreamType());
                        } else {
                            contentValues.put("stream_type", "");
                        }
                        if (liveStreamsCallback.getStreamId() != null) {
                            contentValues.put("stream_id", liveStreamsCallback.getStreamId());
                        } else {
                            contentValues.put("stream_id", "");
                        }
                        if (liveStreamsCallback.getStreamIcon() != null) {
                            contentValues.put("stream_icon", liveStreamsCallback.getStreamIcon());
                        } else {
                            contentValues.put("stream_icon", "");
                        }
                        if (liveStreamsCallback.getEpgChannelId() != null) {
                            contentValues.put("epg_channel_id", liveStreamsCallback.getEpgChannelId());
                        } else {
                            contentValues.put("epg_channel_id", "");
                        }
                        if (liveStreamsCallback.getAdded() != null) {
                            contentValues.put("added", liveStreamsCallback.getAdded());
                        } else {
                            contentValues.put("added", "");
                        }
                        if (liveStreamsCallback.getCategoryId() == null || checkUnCategoryCountLive(liveStreamsCallback.getCategoryId()) <= 0) {
                            contentValues.put("categoryID", "-2");
                        } else {
                            contentValues.put("categoryID", liveStreamsCallback.getCategoryId());
                        }
                        if (liveStreamsCallback.getCustomSid() != null) {
                            contentValues.put("custom_sid", liveStreamsCallback.getCustomSid());
                        } else {
                            contentValues.put("custom_sid", "");
                        }
                        if (liveStreamsCallback.getTvArchive() != null) {
                            contentValues.put("tv_archive", liveStreamsCallback.getTvArchive());
                        } else {
                            contentValues.put("tv_archive", "");
                        }
                        if (liveStreamsCallback.getDirectSource() != null) {
                            contentValues.put("direct_source", liveStreamsCallback.getDirectSource());
                        } else {
                            contentValues.put("direct_source", "");
                        }
                        if (liveStreamsCallback.getTvArchiveDuration() != null) {
                            contentValues.put("tv_archive_duration", liveStreamsCallback.getTvArchiveDuration());
                        } else {
                            contentValues.put("tv_archive_duration", "");
                        }
                        contentValues.put("type_name", "");
                        contentValues.put("category_name", "");
                        contentValues.put("series_no", "");
                        contentValues.put("live", "");
                        contentValues.put("container_extension", "");
                        contentValues.put("rating_from_ten", "");
                        contentValues.put("rating_from_five", "");
                        contentValues.put("user_id_referred", Integer.valueOf(userID));
                        writableDatabase.insert("iptv_live_streams", (String) null, contentValues);
                    }
                    writableDatabase.setTransactionSuccessful();
                    writableDatabase.endTransaction();
                    w.q = false;
                    return true;
                } catch (Exception unused) {
                    writableDatabase.endTransaction();
                    w.q = false;
                    Log.w("msg", "exception");
                    return false;
                }
            } catch (SQLiteDatabaseLockedException unused2) {
                Log.w("msg", "exception");
                writableDatabase.endTransaction();
                w.q = false;
                return false;
            }
        } catch (Exception unused3) {
        }
    }

    public ArrayList getdateDBStatus() {
        int userID = SharepreferenceDBHandler.getUserID(this.context);
        String currentAPPType = SharepreferenceDBHandler.getCurrentAPPType(this.context);
        ArrayList arrayList = new ArrayList();
        try {
            Cursor rawQuery = getReadableDatabase().rawQuery("SELECT * FROM iptv_import_status WHERE user_id_referred = '" + userID + "' AND app_type = '" + currentAPPType + "'", (String[]) null);
            if (rawQuery.moveToFirst()) {
                do {
                    ImportStatusModel importStatusModel = new ImportStatusModel();
                    importStatusModel.setIdAuto(w.r0(rawQuery.getString(0)));
                    importStatusModel.setType(rawQuery.getString(1));
                    importStatusModel.setStatus(rawQuery.getString(2));
                    importStatusModel.setDate(rawQuery.getString(3));
                    importStatusModel.setTime(rawQuery.getString(4));
                    importStatusModel.setSourceRef(rawQuery.getString(7));
                    arrayList.add(importStatusModel);
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
            return arrayList;
        } catch (SQLiteDatabaseLockedException | Exception unused) {
            return null;
        }
    }
}
