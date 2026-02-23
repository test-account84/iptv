package com.google.ads.interactivemedia.v3.impl.data;

import android.util.Log;
import com.google.ads.interactivemedia.v3.internal.bur;
import com.google.ads.interactivemedia.v3.internal.but;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bm {
    public double adBreakDuration;
    public String adBreakTime;
    public List adCuePoints;
    public c adData;
    public double adPeriodDuration;
    public d adPodInfo;
    public int adPosition;
    public long adTimeUpdateMs;
    public long appSetIdTimeoutMs;
    public double bufferedTime;
    public Map companions;
    public List cuepoints;
    public double currentTime;
    public boolean disableAppSetId;
    public double duration;
    public boolean enableGks;
    public boolean enableInstrumentation;
    public int errorCode;
    public String errorMessage;
    public Integer espAdapterTimeoutMs;
    public List espAdapters;
    public String eventId;
    public String innerError;
    public SortedSet internalCuePoints;
    public String ln;
    public bl logData;
    public String m;
    public boolean monitorAppLifecycle;
    public String n;
    public bq networkRequest;
    public Integer platformSignalCollectorTimeoutMs;
    public String queryId;
    public ResizeAndPositionVideoMsgData resizeAndPositionVideo;
    public double seekTime;
    public String streamId;
    public String streamUrl;
    public List subtitles;
    public int totalAds;
    public String url;
    public String vastEvent;
    public String videoUrl;

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        return bur.c(this, obj, new String[0]);
    }

    public int hashCode() {
        return but.a(this, new String[0]);
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("JavaScriptMsgData[");
        for (Field field : bm.class.getFields()) {
            try {
                Object obj = field.get(this);
                sb.append(field.getName());
                sb.append(":");
                sb.append(obj);
                sb.append(",");
            } catch (IllegalArgumentException e) {
                e = e;
                str = "IllegalArgumentException occurred";
                Log.e("IMASDK", str, e);
            } catch (IllegalAccessException e2) {
                e = e2;
                str = "IllegalAccessException occurred";
                Log.e("IMASDK", str, e);
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
