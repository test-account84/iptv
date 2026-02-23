package com.google.ads.interactivemedia.v3.api;

import com.google.ads.interactivemedia.v3.impl.data.TestingConfiguration;
import com.google.android.gms.common.internal.Hide;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public interface ImaSdkSettings {
    public static final int DEFAULT_MAX_REDIRECTS = 4;

    @Hide
    boolean doesRestrictToCustomPlayer();

    boolean getAutoPlayAdBreaks();

    Map getFeatureFlags();

    String getLanguage();

    int getMaxRedirects();

    String getPlayerType();

    String getPlayerVersion();

    String getPpid();

    String getSessionId();

    @Hide
    TestingConfiguration getTestingConfig();

    boolean isDebugMode();

    void setAutoPlayAdBreaks(boolean z);

    void setDebugMode(boolean z);

    void setFeatureFlags(Map map);

    void setLanguage(String str);

    void setMaxRedirects(int i);

    void setPlayerType(String str);

    void setPlayerVersion(String str);

    void setPpid(String str);

    @Hide
    void setRestrictToCustomPlayer(boolean z);

    void setSessionId(String str);

    @Hide
    void setTestingConfig(TestingConfiguration testingConfiguration);

    String toString();
}
