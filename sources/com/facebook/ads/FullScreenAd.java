package com.facebook.ads;

import androidx.annotation.Keep;
import com.facebook.ads.Ad;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public interface FullScreenAd extends Ad {

    @Keep
    public interface ShowAdConfig {
    }

    @Keep
    public interface ShowConfigBuilder {
        ShowAdConfig build();
    }

    Ad.LoadConfigBuilder buildLoadAdConfig();

    ShowConfigBuilder buildShowAdConfig();

    boolean show();
}
