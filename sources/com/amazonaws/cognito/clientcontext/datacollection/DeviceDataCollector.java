package com.amazonaws.cognito.clientcontext.datacollection;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.Display;
import android.view.WindowManager;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class DeviceDataCollector extends DataCollector {
    protected static final String LOCAL_STORAGE_DEVICE_ID_KEY = "CognitoDeviceId";
    protected static final String LOCAL_STORAGE_PATH = "AWS.Cognito.ContextData";
    private static final String PLATFORM = "ANDROID";

    private Display getDisplay(Context context) {
        return ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
    }

    private String getTimezoneOffset() {
        int rawOffset = getTimezone().getRawOffset();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        long j = rawOffset;
        long hours = timeUnit.toHours(j);
        long minutes = timeUnit.toMinutes(j) - TimeUnit.HOURS.toMinutes(hours);
        StringBuilder sb = new StringBuilder();
        sb.append(hours < 0 ? "-" : "");
        sb.append(String.format(Locale.US, "%02d:%02d", new Object[]{Long.valueOf(Math.abs(hours)), Long.valueOf(minutes)}));
        return sb.toString();
    }

    public Map collect(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("ClientTimezone", getTimezoneOffset());
        hashMap.put("Platform", "ANDROID");
        hashMap.put("ThirdPartyDeviceId", getThirdPartyDeviceAgent());
        hashMap.put("DeviceId", getCognitoDeviceAgent(context));
        hashMap.put("DeviceLanguage", getLanguage());
        Display display = getDisplay(context);
        hashMap.put("ScreenHeightPixels", String.valueOf(display.getHeight()));
        hashMap.put("ScreenWidthPixels", String.valueOf(display.getWidth()));
        return hashMap;
    }

    public String getCognitoDeviceAgent(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("AWS.Cognito.ContextData", 0);
        if (sharedPreferences == null) {
            return null;
        }
        String string = sharedPreferences.getString("CognitoDeviceId", (String) null);
        if (string != null) {
            return string;
        }
        String str = UUID.randomUUID().toString() + ":" + new Date().getTime();
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString("CognitoDeviceId", str);
        edit.apply();
        return str;
    }

    public String getLanguage() {
        return Locale.getDefault().toString();
    }

    public String getThirdPartyDeviceAgent() {
        return "android_id";
    }

    public TimeZone getTimezone() {
        return TimeZone.getDefault();
    }
}
