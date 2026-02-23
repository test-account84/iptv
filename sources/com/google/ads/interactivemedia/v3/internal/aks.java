package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.util.Log;
import com.google.ads.interactivemedia.v3.api.AdEvent;
import com.google.ads.interactivemedia.v3.api.CuePoint;
import com.google.ads.interactivemedia.v3.api.StreamDisplayContainer;
import com.google.ads.interactivemedia.v3.api.StreamManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class aks extends ajc implements StreamManager {
    private final String a;
    private List b;

    public aks(String str, ajx ajxVar, StreamDisplayContainer streamDisplayContainer, akv akvVar, aid aidVar, akn aknVar, ajj ajjVar, Context context, String str2, boolean z) {
        super(str, ajxVar, akvVar, streamDisplayContainer, aidVar, aknVar, ajjVar, context, z);
        this.b = new ArrayList();
        this.a = str2;
        akvVar.k();
    }

    public final void b(aju ajuVar) {
        akv akvVar = (akv) c();
        AdEvent.AdEventType adEventType = AdEvent.AdEventType.ALL_ADS_COMPLETED;
        int ordinal = ajuVar.a.ordinal();
        if (ordinal == 3) {
            akvVar.n();
        } else if (ordinal == 4) {
            this.b = ajuVar.d;
        } else if (ordinal == 14) {
            Log.i("IMASDK", "Seek time when ad is skipped: " + ajuVar.f);
            akvVar.l(Math.round(ajuVar.f * 1000.0d));
        } else if (ordinal != 15) {
            switch (ordinal) {
                case 23:
                    akvVar.e();
                    break;
                case 24:
                    akvVar.b();
                    break;
                case 25:
                    akvVar.j();
                    break;
                case 26:
                    akvVar.i();
                    break;
            }
        } else {
            akvVar.m(ajuVar.b);
        }
        super.b(ajuVar);
    }

    public final void destroy() {
        super.destroy();
        n(ajq.contentComplete);
        l();
    }

    public final double getContentTimeForStreamTime(double d) {
        double d2 = d;
        for (CuePoint cuePoint : this.b) {
            if (cuePoint.getStartTime() > cuePoint.getEndTime()) {
                return 0.0d;
            }
            double endTime = cuePoint.getEndTime();
            double endTime2 = cuePoint.getEndTime();
            if (d >= endTime) {
                d2 -= endTime2 - cuePoint.getStartTime();
            } else if (d < endTime2 && d > cuePoint.getStartTime()) {
                d2 -= d - cuePoint.getStartTime();
            }
        }
        return d2;
    }

    public final long getContentTimeMsForStreamTimeMs(long j) {
        long j2 = j;
        for (CuePoint cuePoint : this.b) {
            if (cuePoint.getStartTimeMs() > cuePoint.getEndTimeMs()) {
                return 0L;
            }
            long endTimeMs = cuePoint.getEndTimeMs();
            long endTimeMs2 = cuePoint.getEndTimeMs();
            if (j >= endTimeMs) {
                j2 -= endTimeMs2 - cuePoint.getStartTimeMs();
            } else if (j < endTimeMs2 && j > cuePoint.getStartTimeMs()) {
                j2 -= j - cuePoint.getStartTimeMs();
            }
        }
        return j2;
    }

    public final List getCuePoints() {
        return Collections.unmodifiableList(this.b);
    }

    public final CuePoint getPreviousCuePointForStreamTime(double d) {
        CuePoint cuePoint = null;
        for (CuePoint cuePoint2 : this.b) {
            if (cuePoint2.getStartTime() < d) {
                cuePoint = cuePoint2;
            }
        }
        return cuePoint;
    }

    public final CuePoint getPreviousCuePointForStreamTimeMs(long j) {
        CuePoint cuePoint = null;
        for (CuePoint cuePoint2 : this.b) {
            if (cuePoint2.getStartTimeMs() < j) {
                cuePoint = cuePoint2;
            }
        }
        return cuePoint;
    }

    public final String getStreamId() {
        return this.a;
    }

    public final double getStreamTimeForContentTime(double d) {
        double d2 = d;
        double d3 = 0.0d;
        double d4 = 0.0d;
        for (CuePoint cuePoint : this.b) {
            if (cuePoint.getStartTime() > cuePoint.getEndTime()) {
                return 0.0d;
            }
            d3 += cuePoint.getStartTime() - d4;
            if (d3 > d) {
                return d2;
            }
            d2 += cuePoint.getEndTime() - cuePoint.getStartTime();
            d4 = cuePoint.getEndTime();
        }
        return d2;
    }

    public final long getStreamTimeMsForContentTimeMs(long j) {
        long j2 = j;
        long j3 = 0;
        long j4 = 0;
        for (CuePoint cuePoint : this.b) {
            if (cuePoint.getStartTimeMs() > cuePoint.getEndTimeMs()) {
                return 0L;
            }
            j3 += cuePoint.getStartTimeMs() - j4;
            if (j3 > j) {
                return j2;
            }
            j2 += cuePoint.getEndTimeMs() - cuePoint.getStartTimeMs();
            j4 = cuePoint.getEndTimeMs();
        }
        return j2;
    }

    public final boolean isCustomPlaybackUsed() {
        return true;
    }

    public final void replaceAdTagParameters(Map map) {
        if (map == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("adTagParameters", map);
        m(ajp.adsManager, ajq.replaceAdTagParameters, hashMap);
    }
}
