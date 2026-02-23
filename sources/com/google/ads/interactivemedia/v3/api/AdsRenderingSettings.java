package com.google.ads.interactivemedia.v3.api;

import com.google.android.gms.common.internal.Hide;
import java.util.List;
import java.util.Set;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public interface AdsRenderingSettings {
    int getBitrateKbps();

    @Hide
    boolean getDisableUi();

    boolean getEnableCustomTabs();

    boolean getEnablePreloading();

    boolean getFocusSkipButtonWhenAvailable();

    List getMimeTypes();

    void setBitrateKbps(int i);

    @Hide
    void setDisableUi(boolean z);

    void setEnableCustomTabs(boolean z);

    void setEnablePreloading(boolean z);

    void setFocusSkipButtonWhenAvailable(boolean z);

    void setLoadVideoTimeout(int i);

    void setMimeTypes(List list);

    void setPlayAdsAfterTime(double d);

    void setUiElements(Set set);
}
