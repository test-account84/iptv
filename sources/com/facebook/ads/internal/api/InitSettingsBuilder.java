package com.facebook.ads.internal.api;

import android.content.Context;
import androidx.annotation.Keep;
import com.facebook.ads.AdSettings;
import com.facebook.ads.AudienceNetworkAds;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;
import com.facebook.ads.internal.settings.MultithreadedBundleWrapper;
import java.util.ArrayList;
import java.util.List;

@Keep
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class InitSettingsBuilder implements AudienceNetworkAds.InitSettingsBuilder {
    public static final String PLACEMENTS_KEY = "PLACEMENTS_KEY";
    private final Context mContext;
    private final MultithreadedBundleWrapper mInitSettings = new MultithreadedBundleWrapper();
    private AudienceNetworkAds.InitListener mInitializationListener;

    public InitSettingsBuilder(Context context) {
        this.mContext = context;
    }

    public void initialize() {
        DynamicLoaderFactory.initialize(this.mContext, this.mInitSettings, this.mInitializationListener, false);
    }

    public InitSettingsBuilder withInitListener(AudienceNetworkAds.InitListener initListener) {
        this.mInitializationListener = initListener;
        return this;
    }

    public InitSettingsBuilder withMediationService(String str) {
        AdSettings.setMediationService(str);
        return this;
    }

    public InitSettingsBuilder withPlacementIds(List list) {
        this.mInitSettings.putStringArrayList("PLACEMENTS_KEY", new ArrayList(list));
        return this;
    }
}
