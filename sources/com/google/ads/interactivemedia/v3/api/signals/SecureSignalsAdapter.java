package com.google.ads.interactivemedia.v3.api.signals;

import android.content.Context;
import com.google.ads.interactivemedia.v3.api.VersionInfo;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public interface SecureSignalsAdapter {
    void collectSignals(Context context, SecureSignalsCollectSignalsCallback secureSignalsCollectSignalsCallback);

    VersionInfo getSDKVersion();

    VersionInfo getVersion();

    void initialize(Context context, SecureSignalsInitializeCallback secureSignalsInitializeCallback);
}
