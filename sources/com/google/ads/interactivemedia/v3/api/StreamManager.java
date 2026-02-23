package com.google.ads.interactivemedia.v3.api;

import java.util.List;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public interface StreamManager extends BaseManager {
    @Deprecated
    double getContentTimeForStreamTime(double d);

    long getContentTimeMsForStreamTimeMs(long j);

    List getCuePoints();

    @Deprecated
    CuePoint getPreviousCuePointForStreamTime(double d);

    CuePoint getPreviousCuePointForStreamTimeMs(long j);

    String getStreamId();

    @Deprecated
    double getStreamTimeForContentTime(double d);

    long getStreamTimeMsForContentTimeMs(long j);

    void replaceAdTagParameters(Map map);
}
