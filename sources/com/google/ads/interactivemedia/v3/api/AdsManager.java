package com.google.ads.interactivemedia.v3.api;

import com.google.android.gms.common.internal.Hide;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public interface AdsManager extends BaseManager {
    @Hide
    void clicked();

    void discardAdBreak();

    List getAdCuePoints();

    void pause();

    @Deprecated
    void requestNextAdBreak();

    void resume();

    void skip();

    void start();
}
