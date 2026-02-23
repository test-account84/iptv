package com.nst.iptvsmarterstvbox.model.webrequest;

import com.google.gson.JsonObject;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public interface RetrofitPost {
    @POST("api")
    Call SbpCombinedRequest(@Body JsonObject jsonObject);

    @POST("api")
    Call addDeviceFirebase(@Body JsonObject jsonObject);

    @GET("portal.php")
    Call addLiveFavStalker(@Header("Cookie") String str, @Header("Authorization") String str2, @Query("type") String str3, @Query("action") String str4, @Query("fav_ch") String str5);

    @FormUrlEncoded
    @POST("/includes/smartersapi/api.php")
    Call addOrder(@Field("a") String str, @Field("e") String str2, @Field("sc") String str3, @Field("s") String str4, @Field("r") String str5, @Field("m") String str6, @Field("p") String str7, @Field("action") String str8, @Field("d") String str9, @Field("u") int i, @Field("is_purchased") String str10, @Field("order_id") String str11, @Field("v") String str12);

    @GET("portal.php")
    Call addVODFavStalker(@Header("Cookie") String str, @Header("Authorization") String str2, @Query("type") String str3, @Query("action") String str4, @Query("video_id") String str5);

    @GET("player_api.php")
    Call allSeriesStreams(@Header("Content-Type") String str, @Query("username") String str2, @Query("password") String str3, @Query("action") String str4);

    @GET("player_api.php")
    Call allVODStreams(@Header("Content-Type") String str, @Query("username") String str2, @Query("password") String str3, @Query("action") String str4);

    @FormUrlEncoded
    @POST("/includes/smartersapi/api.php")
    Call checkGPA(@Field("a") String str, @Field("order_id") String str2, @Field("sc") String str3, @Field("s") String str4, @Field("r") String str5, @Field("action") String str6);

    @FormUrlEncoded
    @POST("/includes/smartersapi/api.php")
    Call clearDevices(@Field("a") String str, @Field("e") String str2, @Field("sc") String str3, @Field("s") String str4, @Field("r") String str5, @Field("m") String str6, @Field("p") String str7, @Field("action") String str8, @Field("d") String str9, @Field("u") int i);

    @POST("api")
    Call clientsFeedbackRequest(@Body JsonObject jsonObject);

    @POST("api")
    Call clientsReportRequest(@Body JsonObject jsonObject);

    @GET("portal.php")
    Call createPlayerLinkStalker(@Header("Cookie") String str, @Header("Authorization") String str2, @Query("type") String str3, @Query("cmd") String str4, @Query("action") String str5, @Query("series") String str6);

    @GET("portal.php")
    Call deletePlayerLink(@Header("Cookie") String str, @Header("Authorization") String str2, @Query("type") String str3, @Query("item") String str4, @Query("action") String str5);

    @GET("xmltv.php")
    Call epgXMLTV(@Header("Content-Type") String str, @Query("username") String str2, @Query("password") String str3);

    @GET("portal.php")
    Call getAdStalker(@Header("Cookie") String str, @Header("Authorization") String str2, @Query("type") String str3, @Query("action") String str4);

    @POST("api")
    Call getAdsDataFromPanelApi(@Body JsonObject jsonObject);

    @POST("api")
    Call getAdsSpeedsControl(@Body JsonObject jsonObject);

    @GET("portal.php")
    Call getAllChannelsStalker(@Header("Cookie") String str, @Header("Authorization") String str2, @Query("type") String str3, @Query("action") String str4);

    @POST("api")
    Call getAnnouncementsFirebase(@Body JsonObject jsonObject);

    @POST("api")
    Call getAppStorageAccess(@Body JsonObject jsonObject);

    @GET("movie/{movie_id}/credits")
    Call getCasts(@Path("movie_id") int i, @Query("api_key") String str);

    @POST("api")
    Call getDeviceID(@Body JsonObject jsonObject);

    @FormUrlEncoded
    @POST("/includes/smartersapi/api.php")
    Call getDevices(@Field("a") String str, @Field("e") String str2, @Field("sc") String str3, @Field("s") String str4, @Field("r") String str5, @Field("p") String str6, @Field("u") int i, @Field("action") String str7);

    @POST("api")
    Call getDownloadInfo(@Body JsonObject jsonObject);

    @POST("api")
    Call getFirebaseVPNUrl(@Body JsonObject jsonObject);

    @GET("movie/{movie_id}")
    Call getGenre(@Path("movie_id") int i, @Query("api_key") String str);

    @GET("portal.php")
    Call getGenresStalker(@Header("Cookie") String str, @Header("Authorization") String str2, @Query("type") String str3, @Query("action") String str4);

    @POST("api")
    Call getLastUpdateApi(@Body JsonObject jsonObject);

    @GET("portal.php")
    Call getLiveFavIdsStalker(@Header("Cookie") String str, @Header("Authorization") String str2, @Query("type") String str3, @Query("action") String str4);

    @GET("search/movie")
    Call getMoviesInfo(@Query("api_key") String str, @Query("query") String str2);

    @GET("person/{person_id}")
    Call getPersonInfo(@Path("person_id") String str, @Query("api_key") String str2, @Query("append_to_response") String str3);

    @POST("api")
    Call getSBPAdvertisements(@Body JsonObject jsonObject);

    @POST("api")
    Call getSBPAdvertisementsMaintance(@Body JsonObject jsonObject);

    @GET("portal.php")
    Call getSeasonsStalker(@Header("Cookie") String str, @Header("Authorization") String str2, @Query("type") String str3, @Query("category") String str4, @Query("p") String str5, @Query("action") String str6, @Query("movie_id") String str7);

    @GET("portal.php")
    Call getSeriesCategoriesStalker(@Header("Cookie") String str, @Header("Authorization") String str2, @Query("type") String str3, @Query("action") String str4);

    @FormUrlEncoded
    @POST("/request_api.php")
    Call getServers(@Field("m") String str, @Field("ak") String str2, @Field("r") String str3, @Field("allowedKey") String str4, @Field("sc") String str5);

    @GET("portal.php")
    Call getShortEPGStalker(@Header("Cookie") String str, @Header("Authorization") String str2, @Query("type") String str3, @Query("ch_id") String str4, @Query("action") String str5);

    @GET("player_api.php")
    Call getTVArchive(@Header("Content-Type") String str, @Query("username") String str2, @Query("password") String str3, @Query("action") String str4, @Query("stream_id") int i);

    @GET("tv/{show_id}/credits")
    Call getTVShowCasts(@Path("show_id") int i, @Query("api_key") String str);

    @GET("tv/{show_id}")
    Call getTVShowsGenreAndDirector(@Path("show_id") int i, @Query("api_key") String str);

    @GET("search/tv")
    Call getTVShowsInfo(@Query("api_key") String str, @Query("query") String str2);

    @GET("movie/{movie_id}/videos")
    Call getTrailer(@Path("movie_id") int i, @Query("api_key") String str);

    @GET("tv/{show_id}/videos")
    Call getTrailerTVShows(@Path("show_id") int i, @Query("api_key") String str);

    @GET("portal.php")
    Call getVODByCatIDStalker(@Header("Cookie") String str, @Header("Authorization") String str2, @Query("type") String str3, @Query("category") String str4, @Query("p") String str5, @Query("action") String str6);

    @GET("portal.php")
    Call getVODFavStalker(@Header("Cookie") String str, @Header("Authorization") String str2, @Query("type") String str3, @Query("action") String str4, @Query("fav") String str5, @Query("p") String str6);

    @GET("portal.php")
    Call getVodCategoriesStalker(@Header("Cookie") String str, @Header("Authorization") String str2, @Query("type") String str3, @Query("action") String str4);

    @FormUrlEncoded
    @POST("/includes/smartersapi/api.php")
    Call isPurchasedCheck(@Field("a") String str, @Field("e") String str2, @Field("sc") String str3, @Field("s") String str4, @Field("r") String str5, @Field("m") String str6, @Field("p") String str7, @Field("action") String str8, @Field("d") String str9, @Field("u") int i, @Field("is_purchased") String str10, @Field("order_id") String str11);

    @GET("player_api.php")
    Call liveStreamCategories(@Header("Content-Type") String str, @Query("username") String str2, @Query("password") String str3, @Query("action") String str4);

    @GET("player_api.php")
    Call liveStreams(@Header("Content-Type") String str, @Query("username") String str2, @Query("password") String str3, @Query("action") String str4);

    @GET("player_api.php")
    Call liveStreams(@Header("Content-Type") String str, @Query("username") String str2, @Query("password") String str3, @Query("action") String str4, @Query("category_id") String str5);

    @GET("player_api.php")
    Call liveStreamsEpg(@Header("Content-Type") String str, @Query("username") String str2, @Query("password") String str3, @Query("action") String str4, @Query("stream_id") Integer num);

    @FormUrlEncoded
    @POST("/includes/smartersapi/api.php")
    Call loginClient(@Field("a") String str, @Field("e") String str2, @Field("sc") String str3, @Field("s") String str4, @Field("r") String str5, @Field("m") String str6, @Field("p") String str7, @Field("action") String str8, @Field("d") String str9);

    @POST("api")
    Call mobileCodeActivate(@Body JsonObject jsonObject);

    @POST("api")
    Call readAnnouncementFirebase(@Body JsonObject jsonObject);

    @FormUrlEncoded
    @POST("/includes/smartersapi/api.php")
    Call registerClient(@Field("e") String str, @Field("sc") String str2, @Field("a") String str3, @Field("r") String str4, @Field("p") String str5, @Field("s") String str6, @Field("action") String str7, @Field("d") String str8, @Field("m") String str9);

    @GET("portal.php")
    Call removeVODFavStalker(@Header("Cookie") String str, @Header("Authorization") String str2, @Query("type") String str3, @Query("action") String str4, @Query("video_id") String str5);

    @GET("portal.php")
    Call searchVODStalker(@Header("Cookie") String str, @Header("Authorization") String str2, @Query("type") String str3, @Query("action") String str4, @Query("category") String str5, @Query("search") String str6, @Query("fav") String str7, @Query("p") String str8);

    @GET("player_api.php")
    Call seasonsEpisode(@Header("Content-Type") String str, @Query("username") String str2, @Query("password") String str3, @Query("action") String str4, @Query("series_id") String str5);

    @GET("play/b2c/v1/content/series/{stream_id}")
    Call seasonsEpisodeOneStream(@Header("Content-Type") String str, @Path("stream_id") String str2, @Query("token") String str3);

    @GET("player_api.php")
    Call seriesCategories(@Header("Content-Type") String str, @Query("username") String str2, @Query("password") String str3, @Query("action") String str4);

    @POST("api")
    Call tvCodeGenerate(@Body JsonObject jsonObject);

    @POST("api")
    Call tvCodeVerify(@Body JsonObject jsonObject);

    @POST("api")
    Call updateAppStorageAccess(@Body JsonObject jsonObject);

    @FormUrlEncoded
    @POST("/includes/smartersapi/api.php")
    Call updateDevice(@Field("a") String str, @Field("e") String str2, @Field("sc") String str3, @Field("s") String str4, @Field("r") String str5, @Field("u") int i, @Field("action") String str6, @Field("m") String str7, @Field("newmac") String str8, @Field("newdevicename") String str9);

    @POST("modules/addons/ActivationCoder/response.php")
    Call validateAct(@Body JsonObject jsonObject);

    @GET("player_api.php")
    Call validateLogin(@Header("Content-Type") String str, @Query("username") String str2, @Query("password") String str3);

    @GET("portal.php")
    Call validateLoginAccessTokenStalker(@Header("Cookie") String str, @Query("type") String str2, @Query("action") String str3);

    @GET("portal.php")
    Call validateLoginProfilesStalker(@Header("Cookie") String str, @Header("Authorization") String str2, @Query("type") String str3, @Query("action") String str4);

    @GET("player_api.php")
    Call vodCategories(@Header("Content-Type") String str, @Query("username") String str2, @Query("password") String str3, @Query("action") String str4);

    @GET("player_api.php")
    Call vodInfo(@Header("Content-Type") String str, @Query("username") String str2, @Query("password") String str3, @Query("action") String str4, @Query("vod_id") int i);

    @GET("player_api.php")
    Call vodStreams(@Header("Content-Type") String str, @Query("username") String str2, @Query("password") String str3, @Query("action") String str4, @Query("category_id") String str5);
}
