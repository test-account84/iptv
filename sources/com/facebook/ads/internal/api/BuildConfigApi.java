package com.facebook.ads.internal.api;

import android.content.Context;
import androidx.annotation.Keep;
import com.facebook.ads.BuildConfig;

@Keep
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class BuildConfigApi {
    static final String UNITY_SHARED_PREFERENCES_SUFIX = ".v2.playerprefs";
    static final String UNITY_TAG = "an_isUnitySDK";
    static final String UNITY_VERSION_SUFIX = "-unity";

    public static String getVersionName(Context context) {
        if (!isUnity(context)) {
            return BuildConfig.VERSION_NAME;
        }
        return BuildConfig.VERSION_NAME + "-unity";
    }

    public static boolean isDebug() {
        return BuildConfig.DEBUG;
    }

    private static boolean isUnity(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append(context.getPackageName());
        sb.append(".v2.playerprefs");
        return context.getSharedPreferences(sb.toString(), 0).contains("an_isUnitySDK") || context.getSharedPreferences(context.getPackageName(), 0).contains("an_isUnitySDK");
    }
}
