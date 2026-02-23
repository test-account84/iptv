package com.google.ads.interactivemedia.v3.internal;

import com.google.ads.interactivemedia.v3.api.ImaSdkSettings;
import com.google.ads.interactivemedia.v3.impl.data.TestingConfiguration;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class ajl implements ImaSdkSettings {
    private Map featureFlags;
    private String playerType;
    private String playerVersion;
    private String ppid;
    private transient boolean restrictToCustomPlayer;
    private String sessionId;
    private TestingConfiguration testingConfig;
    private final boolean supportsMultipleVideoDisplayChannels = true;
    private int numRedirects = 4;
    private boolean autoPlayAdBreaks = true;
    private boolean debugMode = false;
    private transient String language = "en";

    public boolean doesRestrictToCustomPlayer() {
        return this.restrictToCustomPlayer;
    }

    public boolean getAutoPlayAdBreaks() {
        return this.autoPlayAdBreaks;
    }

    public Map getFeatureFlags() {
        return this.featureFlags;
    }

    public String getLanguage() {
        return this.language;
    }

    public int getMaxRedirects() {
        return this.numRedirects;
    }

    public String getPlayerType() {
        return this.playerType;
    }

    public String getPlayerVersion() {
        return this.playerVersion;
    }

    public String getPpid() {
        return this.ppid;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public TestingConfiguration getTestingConfig() {
        return this.testingConfig;
    }

    public boolean isDebugMode() {
        return this.debugMode;
    }

    public void setAutoPlayAdBreaks(boolean z) {
        this.autoPlayAdBreaks = z;
    }

    public void setDebugMode(boolean z) {
        this.debugMode = z;
    }

    public void setFeatureFlags(Map map) {
        this.featureFlags = map;
    }

    public void setLanguage(String str) {
        this.language = str;
    }

    public void setMaxRedirects(int i) {
        this.numRedirects = i;
    }

    public void setPlayerType(String str) {
        this.playerType = str;
    }

    public void setPlayerVersion(String str) {
        this.playerVersion = str;
    }

    public void setPpid(String str) {
        this.ppid = str;
    }

    public void setRestrictToCustomPlayer(boolean z) {
        this.restrictToCustomPlayer = z;
    }

    public void setSessionId(String str) {
        this.sessionId = str;
    }

    public void setTestingConfig(TestingConfiguration testingConfiguration) {
        this.testingConfig = testingConfiguration;
    }

    public String toString() {
        return "ImaSdkSettings [ppid=" + this.ppid + ", numRedirects=" + this.numRedirects + ", playerType=" + this.playerType + ", playerVersion=" + this.playerVersion + ", language=" + this.language + ", restrictToCustom=" + this.restrictToCustomPlayer + ", autoPlayAdBreaks=" + this.autoPlayAdBreaks + ", sessionId=" + this.sessionId + "]";
    }
}
