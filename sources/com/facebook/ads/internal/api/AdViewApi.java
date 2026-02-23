package com.facebook.ads.internal.api;

import android.content.res.Configuration;
import androidx.annotation.Keep;
import com.facebook.ads.Ad;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdView;
import com.facebook.ads.ExtraHints;

@Keep
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public interface AdViewApi extends AdViewParentApi, Ad {
    AdView.AdViewLoadConfigBuilder buildLoadAdConfig();

    void loadAd(AdView.AdViewLoadConfig adViewLoadConfig);

    void onConfigurationChanged(Configuration configuration);

    void setAdListener(AdListener adListener);

    @Deprecated
    void setExtraHints(ExtraHints extraHints);
}
