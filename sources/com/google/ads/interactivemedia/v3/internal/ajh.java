package com.google.ads.interactivemedia.v3.internal;

import com.google.ads.interactivemedia.v3.api.player.VideoProgressUpdate;
import java.util.SortedSet;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class ajh implements akp {
    private final SortedSet a;
    private final ajx b;
    private final String c;
    private long d;
    private VideoProgressUpdate e;
    private final com.google.ads.interactivemedia.v3.impl.data.k f;

    public ajh(ajx ajxVar, SortedSet sortedSet, String str) {
        com.google.ads.interactivemedia.v3.impl.data.k kVar = new com.google.ads.interactivemedia.v3.impl.data.k();
        this.d = 0L;
        this.e = new VideoProgressUpdate(0L, 0L);
        this.a = sortedSet;
        this.f = kVar;
        this.b = ajxVar;
        this.c = str;
    }

    public final void a(VideoProgressUpdate videoProgressUpdate) {
        if (videoProgressUpdate == null || videoProgressUpdate.getDuration() < 0.0f || videoProgressUpdate.equals(this.e)) {
            return;
        }
        float currentTime = this.e.getCurrentTime();
        float currentTime2 = videoProgressUpdate.getCurrentTime();
        if (!(currentTime < currentTime2 ? this.a.subSet(Float.valueOf(currentTime), Float.valueOf(currentTime2)) : this.a.subSet(Float.valueOf(currentTime2), Float.valueOf(currentTime))).isEmpty() || this.a.contains(Float.valueOf(videoProgressUpdate.getCurrentTime())) || System.currentTimeMillis() - this.d >= 1000) {
            this.d = System.currentTimeMillis();
            this.e = videoProgressUpdate;
            this.b.o(new ajr(ajp.contentTimeUpdate, ajq.contentTimeUpdate, this.c, com.google.ads.interactivemedia.v3.impl.data.bz.create(videoProgressUpdate)));
        }
    }
}
