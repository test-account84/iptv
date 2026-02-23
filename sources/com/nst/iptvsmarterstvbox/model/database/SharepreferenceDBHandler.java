package com.nst.iptvsmarterstvbox.model.database;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import m7.a;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class SharepreferenceDBHandler {

    public class 1 extends TypeToken {
    }

    public class 2 extends TypeToken {
    }

    public static Map getAccessData(Context context) {
        String string = context.getSharedPreferences("OvpnPrefs", 0).getString("access_data", (String) null);
        if (string != null) {
            return (Map) new Gson().fromJson(string, new 2().getType());
        }
        return null;
    }

    public static String getActCode(Context context) {
        return context.getSharedPreferences("auto_start", 0).getString("act_code", "");
    }

    public static List getAnnouncementsList(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("loginsharedsbp", 0);
        Gson gson = new Gson();
        String string = sharedPreferences.getString("announcements", (String) null);
        ArrayList arrayList = new ArrayList();
        return (string == null || string.equalsIgnoreCase("null") || string.length() == 0) ? arrayList : (List) gson.fromJson(string, new 1().getType());
    }

    public static int getAsyncTaskStatus(Context context) {
        return context.getSharedPreferences("loginprefsmultiuser", 0).getInt("async_status", 0);
    }

    public static int getCacheClearCount(Context context) {
        return context.getSharedPreferences("cacheClearCount", 0).getInt("cacheClearCount", 0);
    }

    public static String getCatchUpPlayerAppName(Context context) {
        return context.getSharedPreferences("MyPrefPlayer", 0).getString("CatchUpAppName", "");
    }

    public static String getCatchUpPlayerPkgName(Context context) {
        return context.getSharedPreferences("MyPrefPlayer", 0).getString("CatchUpPkgName", "default");
    }

    public static String getClientSecurityUrl(Context context) {
        return context.getSharedPreferences("aws_credentials", 0).getString("client_security_url", "");
    }

    public static String getCurrentAPPType(Context context) {
        return context.getSharedPreferences("loginprefsmultiuser", 0).getString("current_app_type", "api");
    }

    public static List getDashboardImageList(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("loginsharedsbp", 0);
        Gson gson = new Gson();
        String string = sharedPreferences.getString("adsdashboardimagelist", (String) null);
        ArrayList arrayList = new ArrayList();
        return (string == null || string.equalsIgnoreCase("null") || string.length() == 0) ? arrayList : Arrays.asList((String[]) gson.fromJson(string, String[].class));
    }

    public static List getDashboardTextList(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("loginsharedsbp", 0);
        Gson gson = new Gson();
        String string = sharedPreferences.getString("adsdashboardtextlist", (String) null);
        ArrayList arrayList = new ArrayList();
        return (string == null || string.equalsIgnoreCase("null") || string.length() == 0) ? arrayList : Arrays.asList((String[]) gson.fromJson(string, String[].class));
    }

    public static boolean getDemoAppMessageShow(Context context) {
        return context.getSharedPreferences("MyPref", 0).getBoolean("isShow", false);
    }

    public static String getDemoPassword(Context context) {
        return context.getSharedPreferences("aws_credentials", 0).getString("demo_password", "");
    }

    public static String getDemoUsername(Context context) {
        return context.getSharedPreferences("aws_credentials", 0).getString("demo_username", "");
    }

    public static String getDeviceUUID(Context context) {
        return context.getSharedPreferences("loginsharedsbp", 0).getString("deviceuudid", "");
    }

    public static boolean getDontaskagain(Context context) {
        return context.getSharedPreferences("SplashAppUpdate", 0).getBoolean("Dontask", false);
    }

    public static String getDownloadingPath(Context context) {
        return context.getSharedPreferences("MyPref", 0).getString("downloadpath", "0");
    }

    public static String getEPGPlayerAppName(Context context) {
        return context.getSharedPreferences("MyPrefPlayer", 0).getString("EPGAppName", "");
    }

    public static String getEPGPlayerPKGName(Context context) {
        return context.getSharedPreferences("MyPrefPlayer", 0).getString("EPGPkgName", "default");
    }

    public static int getEventAdsView(Context context) {
        return context.getSharedPreferences("evetview", 0).getInt("eventview", 0);
    }

    public static String getFirebaseM3uNode(Context context) {
        return context.getSharedPreferences("firebase_node", 0).getString("node", "");
    }

    public static String getFirebaseOneStreamNode(Context context) {
        return context.getSharedPreferences("firebase_node_one_stream", 0).getString("node", "");
    }

    public static String getFirebaseToken(Context context) {
        return context.getSharedPreferences("loginsharedsbp", 0).getString("firebasetoken", "");
    }

    public static boolean getFirstTimeAdsShow(Context context) {
        return context.getSharedPreferences("firsttimeads", 0).getBoolean("FirstTimeAds", true);
    }

    public static String getFreeTrailStatus(Context context) {
        return context.getSharedPreferences("MyPref", 0).getString("FreeTrailStatus", "0");
    }

    public static int getID(Context context) {
        return context.getSharedPreferences("loginprefsmultiuser", 0).getInt("VPNID", 0);
    }

    public static boolean getIsAppExistOnPlayStore(Context context) {
        return context.getSharedPreferences("MyPref", 0).getBoolean("AppExist", false);
    }

    public static boolean getIsupdate(Context context) {
        return context.getSharedPreferences("SplashAppUpdate", 0).getBoolean("Update", false);
    }

    public static int getLastUpdate(Context context) {
        return context.getSharedPreferences("loginsharedsbp", 0).getInt("nextRequest", 0);
    }

    public static String getLastUpdateTime(Context context) {
        return context.getSharedPreferences("loginsharedsbp", 0).getString("lastpublishpanel", "");
    }

    public static String getLiveActivitynewFlowSort(Context context) {
        return context.getSharedPreferences(a.J, 0).getString("livecatsort", "0");
    }

    public static String getLivePlayerAppName(Context context) {
        return context.getSharedPreferences("MyPrefPlayer", 0).getString("LiveAppName", "");
    }

    public static String getLivePlayerPkgName(Context context) {
        return context.getSharedPreferences("MyPrefPlayer", 0).getString("LivePkgName", "default");
    }

    public static String getLiveSubCatSort(Context context) {
        return context.getSharedPreferences(a.J, 0).getString("LiveSort", "0");
    }

    public static String getLoggedInMacAddress(Context context) {
        return context.getSharedPreferences("loginPrefs", 0).getString("mac_address", "");
    }

    public static String getMacAddress(Context context) {
        return context.getSharedPreferences("loginPrefs", 0).getString("mac_address", "");
    }

    public static String getMaintanceModeFooterMessage(Context context) {
        return context.getSharedPreferences("loginsharedsbp", 0).getString("footerMesg", "");
    }

    public static String getMaintanceModeMessage(Context context) {
        return context.getSharedPreferences("loginsharedsbp", 0).getString("msg", "");
    }

    public static boolean getMaintanceModeState(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("maintanenceshareddb", 0);
        Log.e("honey", "getMaintanceModeState: " + sharedPreferences.getBoolean("maintancemodestate", false));
        return sharedPreferences.getBoolean("maintancemodestate", false);
    }

    public static String getOneStreamExp(Context context) {
        return context.getSharedPreferences("loginPrefs", 0).getString("exp", "");
    }

    public static String getOneStreamToken(Context context) {
        return context.getSharedPreferences("loginPrefs", 0).getString("onestream_token", "");
    }

    public static String getOneStreamVideourl(Context context) {
        return context.getSharedPreferences("loginPrefs", 0).getString("URL", "");
    }

    public static boolean getOpenSubtitle(Context context) {
        return context.getSharedPreferences("pref_open_subtitle", 0).getBoolean("subtitle_status", true);
    }

    public static String getPlayListCategorySort(Context context) {
        return context.getSharedPreferences(a.J, 0).getString("Playlistcatsort", "0");
    }

    public static String getPlaylistSort(Context context) {
        return context.getSharedPreferences(a.J, 0).getString("PlaylistSort", "0");
    }

    public static String getPrefAdsStatus(Context context) {
        return context.getSharedPreferences("loginsharedsbp", 0).getString("adsstatus", "0");
    }

    public static String getRadioSort(Context context) {
        return context.getSharedPreferences(a.J, 0).getString("RadioSort", "0");
    }

    public static int getRateUsCount(Context context) {
        return context.getSharedPreferences("SplashAppUpdate", 0).getInt("RateUsCount", 0);
    }

    public static boolean getRateUsDontaskagain(Context context) {
        return context.getSharedPreferences("SplashAppUpdate", 0).getBoolean("RateUsDontask", false);
    }

    public static String getRecordingsPlayerAppName(Context context) {
        return context.getSharedPreferences("MyPrefPlayer", 0).getString("RecordingsAppName", "");
    }

    public static String getRecordingsPlayerPkgName(Context context) {
        return context.getSharedPreferences("MyPrefPlayer", 0).getString("RecordingsPkgName", "default");
    }

    public static List getRewardedImageList(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("loginsharedsbp", 0);
        Gson gson = new Gson();
        String string = sharedPreferences.getString("adsrewardedimagelist", (String) null);
        ArrayList arrayList = new ArrayList();
        return (string == null || string.equalsIgnoreCase("null") || string.length() == 0) ? arrayList : Arrays.asList((String[]) gson.fromJson(string, String[].class));
    }

    public static List getRewardedTextList(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("loginsharedsbp", 0);
        Gson gson = new Gson();
        String string = sharedPreferences.getString("adsrewardedtextlist", (String) null);
        ArrayList arrayList = new ArrayList();
        return (string == null || string.equalsIgnoreCase("null") || string.length() == 0) ? arrayList : Arrays.asList((String[]) gson.fromJson(string, String[].class));
    }

    public static String getSBPDemoAndClientUrl(Context context) {
        return context.getSharedPreferences("aws_credentials", 0).getString("demo_and_client_url", "");
    }

    public static String getScreenTYPE(Context context) {
        return context.getSharedPreferences("loginprefsmultiuser", 0).getString("screenType", "default");
    }

    public static String getSelectedLanguage(Context context) {
        return context.getSharedPreferences("LanguageSelectionPref", 0).getString("SelectedLanguage", "");
    }

    public static String getSeriesPlayerAppName(Context context) {
        return context.getSharedPreferences("MyPrefPlayer", 0).getString("SeriesAppName", "");
    }

    public static String getSeriesPlayerPkgName(Context context) {
        return context.getSharedPreferences("MyPrefPlayer", 0).getString("SeriesPkgName", "default");
    }

    public static String getSeriesSubCatSort(Context context) {
        return context.getSharedPreferences(a.J, 0).getString("SeriesSort", "0");
    }

    public static String getServerUrl(Context context) {
        return context.getSharedPreferences("loginPrefs", 0).getString("serverUrl", "");
    }

    public static boolean getShowPopup(Context context) {
        return context.getSharedPreferences("showPopup", 0).getBoolean("popshow", true);
    }

    public static String getStalkerToken(Context context) {
        return context.getSharedPreferences("loginprefsmultiuser", 0).getString("stalker_token", "");
    }

    public static int getTooltip(Context context) {
        return context.getSharedPreferences("loginprefsmultiuser", 0).getInt("tooltip", 0);
    }

    public static String getTrial(Context context) {
        return context.getSharedPreferences("loginPrefs", 0).getString("isTrial", "");
    }

    public static String getType(Context context) {
        return context.getSharedPreferences("loginprefsmultiuser", 0).getString("type", "");
    }

    public static String getTypeLogin(Context context) {
        return context.getSharedPreferences("loginPrefs", 0).getString("in_which", "");
    }

    public static String getUpdateVersionCode(Context context) {
        return context.getSharedPreferences("update_version", 0).getString("pref_update_version_code", "");
    }

    public static String getUpdateVersionName(Context context) {
        return context.getSharedPreferences("update_version", 0).getString("pref_update_version_name", "");
    }

    public static String getUpdateVersionUrl(Context context) {
        return context.getSharedPreferences("update_version", 0).getString("pref_update_version_url", "");
    }

    public static int getUserID(Context context) {
        return context.getSharedPreferences("loginprefsmultiuser", 0).getInt("userID", -1);
    }

    public static String getUserName(Context context) {
        return context.getSharedPreferences("loginPrefs", 0).getString("username", "");
    }

    public static String getUserPassword(Context context) {
        return context.getSharedPreferences("loginPrefs", 0).getString("password", "");
    }

    public static String getVODPlayerAppName(Context context) {
        return context.getSharedPreferences("MyPrefPlayer", 0).getString("VODAppName", "");
    }

    public static String getVODPlayerPkgName(Context context) {
        return context.getSharedPreferences("MyPrefPlayer", 0).getString("VODPkgName", "default");
    }

    public static String getVODSubCatSort(Context context) {
        return context.getSharedPreferences(a.J, 0).getString("VODSort", "0");
    }

    public static String getVPNFilePath(Context context) {
        return context.getSharedPreferences("MyPrefPlayer", 0).getString("vpnfilepath", "");
    }

    public static boolean getVPNLastUpdate(Context context) {
        return context.getSharedPreferences("loginsharedsbp", 0).getBoolean("vpnlastpublishpanel", true);
    }

    public static boolean getVPNStatus(Context context) {
        return context.getSharedPreferences("OvpnPrefs", 0).getBoolean("vpn_status_on_off", false);
    }

    public static String getVPNUrl(Context context) {
        return context.getSharedPreferences("OvpnPrefs", 0).getString("vpn_download_url", "");
    }

    public static int getViewableRate(Context context) {
        return context.getSharedPreferences("loginsharedsbp", 0).getInt("adsviewablerate", 0);
    }

    public static String getVodActivitynewFlowSort(Context context) {
        return context.getSharedPreferences(a.J, 0).getString("vodcatsort", "0");
    }

    public static boolean getisAutoPlayVideos(Context context) {
        return context.getSharedPreferences("auto_start", 0).getBoolean("autoplay", true);
    }

    public static boolean getisPlayerReleasedLarge(Context context) {
        return context.getSharedPreferences("isPlayerReleasedLargePref", 0).getBoolean("isPlayerReleasedLarge", false);
    }

    public static boolean getisPlayerReleasedSmall(Context context) {
        return context.getSharedPreferences("isPlayerReleasedSmallPref", 0).getBoolean("isPlayerReleasedSmall", false);
    }

    public static String getseriesActivitynewFlowSort(Context context) {
        return context.getSharedPreferences(a.J, 0).getString("seriescatsort", "0");
    }

    public static boolean isChecked(Context context) {
        return context.getSharedPreferences("showPopup", 0).getBoolean("check_box", true);
    }

    public static boolean isLocalDb(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("pref_local_db", 0);
        return a.o.booleanValue() ? sharedPreferences.getBoolean("fav_db", false) : sharedPreferences.getBoolean("fav_db", true);
    }

    public static boolean isShowPopup(Context context) {
        return context.getSharedPreferences("pref_open_popup", 0).getBoolean("popup_status", true);
    }

    public static boolean isStorageAccessServerUpdated(Context context) {
        return context.getSharedPreferences("pref_update_storage_access", 0).getBoolean("storage_update_server", false);
    }

    public static void saveAccessData(Context context, Map map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        SharedPreferences.Editor edit = context.getSharedPreferences("OvpnPrefs", 0).edit();
        edit.putString("access_data", new Gson().toJson(map));
        edit.apply();
    }

    public static void setActivationCode(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("auto_start", 0).edit();
        edit.putString("act_code", str);
        edit.apply();
    }

    public static void setAnnouncementsList(List list, Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("loginsharedsbp", 0).edit();
        edit.putString("announcements", new Gson().toJson(list));
        edit.apply();
    }

    public static void setAsyncTaskStatus(int i, Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("loginprefsmultiuser", 0).edit();
        edit.putInt("async_status", i);
        edit.apply();
    }

    public static void setCacheClearCount(int i, Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("cacheClearCount", 0).edit();
        edit.putInt("cacheClearCount", i);
        edit.apply();
    }

    public static void setCatchUpPlayer(String str, String str2, Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("MyPrefPlayer", 0).edit();
        edit.putString("CatchUpPkgName", str);
        edit.putString("CatchUpAppName", str2);
        edit.apply();
    }

    public static void setClientSecurityCred(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("aws_credentials", 0).edit();
        edit.putString("client_security_url", str);
        edit.apply();
    }

    public static void setCurrentAPPType(String str, Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("loginprefsmultiuser", 0).edit();
        edit.putString("current_app_type", str);
        edit.apply();
    }

    public static void setDashboardImageList(ArrayList arrayList, Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("loginsharedsbp", 0).edit();
        edit.putString("adsdashboardimagelist", new Gson().toJson(arrayList));
        edit.apply();
    }

    public static void setDashboardTextList(ArrayList arrayList, Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("loginsharedsbp", 0).edit();
        edit.putString("adsdashboardtextlist", new Gson().toJson(arrayList));
        edit.apply();
    }

    public static void setDemoAWSCredentials(Context context, String str, String str2, String str3) {
        SharedPreferences.Editor edit = context.getSharedPreferences("aws_credentials", 0).edit();
        edit.putString("demo_and_client_url", str);
        edit.putString("demo_username", str2);
        edit.putString("demo_password", str3);
        edit.apply();
    }

    public static void setDemoAppMessageShow(boolean z, Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("MyPref", 0).edit();
        edit.putBoolean("AppExist", z);
        edit.apply();
    }

    public static void setDeviceUUID(String str, Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("loginsharedsbp", 0).edit();
        edit.putString("deviceuudid", str);
        edit.apply();
    }

    public static void setDontaskagain(boolean z, Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("SplashAppUpdate", 0).edit();
        edit.putBoolean("Dontask", z);
        edit.apply();
    }

    public static void setDownloadingPath(String str, Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("MyPref", 0).edit();
        edit.putString("downloadpath", str);
        edit.apply();
    }

    public static void setEPGPlayer(String str, String str2, Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("MyPrefPlayer", 0).edit();
        edit.putString("EPGPkgName", str);
        edit.putString("EPGAppName", str2);
        edit.apply();
    }

    public static void setEventAdsView(int i, Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("evetview", 0).edit();
        edit.putInt("eventview", i);
        edit.apply();
    }

    public static void setFirebaseM3uNode(String str, Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("firebase_node", 0).edit();
        edit.putString("node", str);
        edit.apply();
    }

    public static void setFirebaseOneStreamNode(String str, Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("firebase_node_one_stream", 0).edit();
        edit.putString("node", str);
        edit.apply();
    }

    public static void setFirebaseToken(String str, Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("loginsharedsbp", 0).edit();
        edit.putString("firebasetoken", str);
        edit.apply();
    }

    public static void setFirstTimeAdsShow(boolean z, Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("firsttimeads", 0).edit();
        edit.putBoolean("FirstTimeAds", z);
        edit.apply();
    }

    public static void setFreeTrailStatus(String str, Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("MyPref", 0).edit();
        edit.putString("FreeTrailStatus", str);
        edit.apply();
    }

    public static void setID(int i, Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("loginprefsmultiuser", 0).edit();
        edit.putInt("VPNID", i);
        edit.apply();
    }

    public static void setIsAppExistOnPlayStore(boolean z, Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("MyPref", 0).edit();
        edit.putBoolean("AppExist", z);
        edit.apply();
    }

    public static void setIsupdate(boolean z, Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("SplashAppUpdate", 0).edit();
        edit.putBoolean("Update", z);
        edit.apply();
    }

    public static void setLastUpdate(int i, Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("loginsharedsbp", 0).edit();
        edit.putInt("nextRequest", i);
        edit.apply();
    }

    public static void setLastUpdateTime(String str, Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("loginsharedsbp", 0).edit();
        edit.putString("lastpublishpanel", str);
        edit.apply();
    }

    public static void setLiveActivitynewFlowSort(String str, Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences(a.J, 0).edit();
        edit.putString("livecatsort", str);
        edit.apply();
    }

    public static void setLivePlayer(String str, String str2, Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("MyPrefPlayer", 0).edit();
        edit.putString("LivePkgName", str);
        edit.putString("LiveAppName", str2);
        edit.apply();
    }

    public static void setLiveSubCatSort(String str, Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences(a.J, 0).edit();
        edit.putString("LiveSort", str);
        edit.apply();
    }

    public static void setLocalDb(Context context, boolean z) {
        SharedPreferences.Editor edit = context.getSharedPreferences("pref_local_db", 0).edit();
        edit.putBoolean("fav_db", z);
        edit.apply();
    }

    public static void setMaintanceModeFooterMessage(String str, Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("loginsharedsbp", 0).edit();
        edit.putString("footerMesg", str);
        edit.apply();
    }

    public static void setMaintanceModeMessage(String str, Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("loginsharedsbp", 0).edit();
        edit.putString("msg", str);
        edit.apply();
    }

    public static void setMaintanceModeState(boolean z, Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("maintanenceshareddb", 0).edit();
        Log.e("honey", "setMaintanceModeState: " + z);
        edit.putBoolean("maintancemodestate", z);
        edit.apply();
    }

    public static void setOneStreamExp(String str, Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("loginPrefs", 0).edit();
        edit.putString("exp", str);
        edit.apply();
    }

    public static void setOneStreamToken(String str, Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("loginPrefs", 0).edit();
        edit.putString("onestream_token", str);
        edit.apply();
    }

    public static void setOneStreamVideourl(String str, Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("loginPrefs", 0).edit();
        edit.putString("URL", str);
        edit.apply();
    }

    public static void setOpenSubtitle(Context context, boolean z) {
        SharedPreferences.Editor edit = context.getSharedPreferences("pref_open_subtitle", 0).edit();
        edit.putBoolean("subtitle_status", z);
        edit.apply();
    }

    public static void setPlayListCategorySort(String str, Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences(a.J, 0).edit();
        edit.putString("Playlistcatsort", str);
        edit.apply();
    }

    public static void setPlaylistSort(String str, Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences(a.J, 0).edit();
        edit.putString("PlaylistSort", str);
        edit.apply();
    }

    public static void setPrefAdsStatus(String str, Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("loginsharedsbp", 0).edit();
        edit.putString("adsstatus", str);
        edit.apply();
    }

    public static void setRadioSort(String str, Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences(a.J, 0).edit();
        edit.putString("RadioSort", str);
        edit.apply();
    }

    public static void setRateUsCount(int i, Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("SplashAppUpdate", 0).edit();
        edit.putInt("RateUsCount", i);
        edit.apply();
    }

    public static void setRateUsDontaskagain(boolean z, Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("SplashAppUpdate", 0).edit();
        edit.putBoolean("RateUsDontask", z);
        edit.apply();
    }

    public static void setRecordingsPlayer(String str, String str2, Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("MyPrefPlayer", 0).edit();
        edit.putString("RecordingsPkgName", str);
        edit.putString("RecordingsAppName", str2);
        edit.apply();
    }

    public static void setRewardedImageList(ArrayList arrayList, Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("loginsharedsbp", 0).edit();
        edit.putString("adsrewardedimagelist", new Gson().toJson(arrayList));
        edit.apply();
    }

    public static void setRewardedTextList(ArrayList arrayList, Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("loginsharedsbp", 0).edit();
        edit.putString("adsrewardedtextlist", new Gson().toJson(arrayList));
        edit.apply();
    }

    public static void setSBPBaseCredentials(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("aws_credentials", 0).edit();
        edit.putString("demo_and_client_url", str);
        edit.apply();
    }

    public static void setScreenTYPE(String str, Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("loginprefsmultiuser", 0).edit();
        edit.putString("screenType", str);
        edit.apply();
    }

    public static void setSelectedLanguage(String str, Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("LanguageSelectionPref", 0).edit();
        edit.putString("SelectedLanguage", str);
        edit.apply();
    }

    public static void setSeriesPlayer(String str, String str2, Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("MyPrefPlayer", 0).edit();
        edit.putString("SeriesPkgName", str);
        edit.putString("SeriesAppName", str2);
        edit.apply();
    }

    public static void setSeriesSubCatSort(String str, Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences(a.J, 0).edit();
        edit.putString("SeriesSort", str);
        edit.apply();
    }

    public static void setServerUrl(String str, Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("loginPrefs", 0).edit();
        edit.putString("serverUrl", str);
        edit.apply();
    }

    public static void setShowPop(Boolean bool, Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("showPopup", 0).edit();
        edit.putBoolean("popshow", bool.booleanValue());
        edit.apply();
    }

    public static void setShowPopup(Context context, boolean z) {
        SharedPreferences.Editor edit = context.getSharedPreferences("pref_open_popup", 0).edit();
        edit.putBoolean("popup_status", z);
        edit.apply();
    }

    public static void setStalkerToken(String str, Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("loginprefsmultiuser", 0).edit();
        edit.putString("stalker_token", str);
        edit.apply();
    }

    public static void setStorageAccessToServer(Context context, boolean z) {
        SharedPreferences.Editor edit = context.getSharedPreferences("pref_update_storage_access", 0).edit();
        edit.putBoolean("storage_update_server", z);
        edit.apply();
    }

    public static void setTooltip(int i, Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("loginprefsmultiuser", 0).edit();
        edit.putInt("tooltip", i);
        edit.apply();
    }

    public static void setTrial(String str, Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("loginPrefs", 0).edit();
        edit.putString("isTrial", str);
        edit.apply();
    }

    public static void setType(String str, Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("loginprefsmultiuser", 0).edit();
        edit.putString("type", str);
        edit.apply();
    }

    public static void setTypeLogin(String str, Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("loginPrefs", 0).edit();
        edit.putString("in_which", str);
        edit.apply();
    }

    public static void setUpdateVersionCode(Context context, String str, String str2, String str3) {
        SharedPreferences.Editor edit = context.getSharedPreferences("update_version", 0).edit();
        edit.putString("pref_update_version_code", str);
        edit.putString("pref_update_version_name", str3);
        edit.putString("pref_update_version_url", str2);
        edit.apply();
    }

    public static void setUserID(int i, Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("loginprefsmultiuser", 0).edit();
        edit.putInt("userID", i);
        edit.apply();
    }

    public static void setUserName(String str, Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("loginPrefs", 0).edit();
        edit.putString("username", str);
        edit.apply();
    }

    public static void setUserPassword(String str, Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("loginPrefs", 0).edit();
        edit.putString("password", str);
        edit.apply();
    }

    public static void setVODPlayer(String str, String str2, Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("MyPrefPlayer", 0).edit();
        edit.putString("VODPkgName", str);
        edit.putString("VODAppName", str2);
        edit.apply();
    }

    public static void setVODSubCatSort(String str, Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences(a.J, 0).edit();
        edit.putString("VODSort", str);
        edit.apply();
    }

    public static void setVPNFilePath(String str, Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("MyPrefPlayer", 0).edit();
        edit.putString("vpnfilepath", str);
        edit.apply();
    }

    public static void setVPNLastUpdate(boolean z, Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("loginsharedsbp", 0).edit();
        edit.putBoolean("vpnlastpublishpanel", z);
        edit.apply();
    }

    public static void setVPNStatus(Context context, boolean z) {
        SharedPreferences.Editor edit = context.getSharedPreferences("OvpnPrefs", 0).edit();
        edit.putBoolean("vpn_status_on_off", z);
        edit.apply();
    }

    public static void setVPNUrl(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("OvpnPrefs", 0).edit();
        edit.putString("vpn_download_url", str);
        edit.apply();
    }

    public static void setValueChecked(Boolean bool, Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("showPopup", 0).edit();
        edit.putBoolean("check_box", bool.booleanValue());
        edit.apply();
    }

    public static void setViewableRate(int i, Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("loginsharedsbp", 0).edit();
        edit.putInt("adsviewablerate", i);
        edit.apply();
    }

    public static void setVodActivitynewFlowSort(String str, Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences(a.J, 0).edit();
        edit.putString("vodcatsort", str);
        edit.apply();
    }

    public static void setisAutoPlayVideos(boolean z, Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("auto_start", 0).edit();
        edit.putBoolean("autoplay", z);
        edit.apply();
    }

    public static void setisPlayerReleasedLarge(boolean z, Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("isPlayerReleasedLargePref", 0).edit();
        edit.putBoolean("isPlayerReleasedLarge", z);
        edit.apply();
    }

    public static void setisPlayerReleasedSmall(boolean z, Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("isPlayerReleasedSmallPref", 0).edit();
        edit.putBoolean("isPlayerReleasedSmall", z);
        edit.apply();
    }

    public static void setseriesActivitynewFlowSort(String str, Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences(a.J, 0).edit();
        edit.putString("seriescatsort", str);
        edit.apply();
    }
}
