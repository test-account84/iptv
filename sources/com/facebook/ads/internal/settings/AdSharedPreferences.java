package com.facebook.ads.internal.settings;

import android.content.Context;
import android.content.SharedPreferences;
import com.facebook.ads.internal.util.process.ProcessUtils;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class AdSharedPreferences {
    public static final String PREFS_NAME = "FBAdPrefs";

    public static SharedPreferences getSharedPreferences(Context context) {
        return context.getSharedPreferences(ProcessUtils.getProcessSpecificName("FBAdPrefs", context), 0);
    }
}
