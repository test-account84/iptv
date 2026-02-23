package com.google.ads.interactivemedia.v3.impl.data;

import com.google.ads.interactivemedia.v3.api.player.VideoProgressUpdate;
import com.google.ads.interactivemedia.v3.internal.atf;

@atf(a = as.class)
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class bz {
    private static final String DEFAULT_TIME_UNIT = "ms";

    public static bz create(VideoProgressUpdate videoProgressUpdate) {
        return new as(videoProgressUpdate.getCurrentTimeMs(), videoProgressUpdate.getDurationMs(), "ms");
    }

    public abstract long currentTime();

    public abstract long duration();

    public abstract String timeUnit();
}
