package com.facebook.ads.internal.api;

import android.content.Context;
import androidx.annotation.Keep;

@Keep
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public interface AdSettingsApi {
    boolean isTestMode(Context context);

    void turnOnDebugger();
}
