package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import com.google.ads.interactivemedia.v3.api.AdDisplayContainer;
import com.google.ads.interactivemedia.v3.api.AdErrorEvent;
import com.google.ads.interactivemedia.v3.api.AdEvent;
import com.google.ads.interactivemedia.v3.api.AdsManager;
import com.google.ads.interactivemedia.v3.api.AdsRenderingSettings;
import com.google.ads.interactivemedia.v3.api.player.VideoProgressUpdate;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class air extends ajc implements AdsManager, AdErrorEvent.AdErrorListener {
    private final List a;
    private ajh b;
    private akq c;
    private final aeq d;

    public air(String str, ajx ajxVar, AdDisplayContainer adDisplayContainer, akq akqVar, List list, SortedSet sortedSet, akn aknVar, ajj ajjVar, Context context, boolean z) {
        akf akfVar = new akf(str, ajxVar, ajjVar, adDisplayContainer);
        aid aidVar = new aid(str, ajxVar, adDisplayContainer.getAdContainer());
        aeq aeqVar = new aeq(ajxVar.a(), adDisplayContainer.getAdContainer());
        super(str, ajxVar, akfVar, adDisplayContainer, aidVar, aknVar, ajjVar, context, z);
        this.a = list;
        this.c = akqVar;
        this.d = aeqVar;
        if (akqVar != null) {
            ajh ajhVar = new ajh(ajxVar, sortedSet, str);
            this.b = ajhVar;
            akqVar.b(ajhVar);
            akqVar.d();
        }
        addAdErrorListener(this);
    }

    public final Map a(AdsRenderingSettings adsRenderingSettings) {
        Map a = super.a(adsRenderingSettings);
        akq akqVar = this.c;
        if (akqVar != null) {
            if (!akqVar.f().equals(VideoProgressUpdate.VIDEO_TIME_NOT_READY)) {
                double currentTimeMs = r0.getCurrentTimeMs() / 1000.0f;
                com.google.ads.interactivemedia.v3.impl.data.m.c("AdsManager.init -> Setting contentStartTime " + currentTimeMs);
                a.put("contentStartTime", Double.valueOf(currentTimeMs));
            }
        }
        return a;
    }

    public final void b(aju ajuVar) {
        akf akfVar = (akf) c();
        AdEvent.AdEventType adEventType = ajuVar.a;
        AdEvent.AdEventType adEventType2 = AdEvent.AdEventType.ALL_ADS_COMPLETED;
        int ordinal = adEventType.ordinal();
        if (ordinal == 0) {
            super.destroy();
            akq akqVar = this.c;
            if (akqVar != null) {
                akqVar.e();
                this.c = null;
            }
            this.d.c();
            n(ajq.destroy);
            super.b(ajuVar);
            l();
            return;
        }
        if (ordinal == 5) {
            akq akqVar2 = this.c;
            if (akqVar2 != null) {
                akqVar2.e();
            }
        } else if (ordinal == 6) {
            this.d.c();
            akfVar.e();
            akq akqVar3 = this.c;
            if (akqVar3 != null) {
                akqVar3.d();
            }
        } else if (ordinal == 14) {
            this.d.c();
        } else if (ordinal == 15) {
            this.d.d();
        }
        super.b(ajuVar);
    }

    public final void clicked() {
        n(ajq.click);
    }

    public final void destroy() {
        super.destroy();
        akq akqVar = this.c;
        if (akqVar != null) {
            akqVar.e();
            this.c = null;
        }
        this.d.c();
        n(ajq.destroy);
    }

    public final void discardAdBreak() {
        n(ajq.discardAdBreak);
    }

    public final List getAdCuePoints() {
        return this.a;
    }

    public final boolean isCustomPlaybackUsed() {
        return ((akf) c()).i();
    }

    public final void onAdError(AdErrorEvent adErrorEvent) {
        this.d.c();
    }

    public final void pause() {
        n(ajq.pause);
    }

    public final void requestNextAdBreak() {
        akq akqVar = this.c;
        if (akqVar != null) {
            m(ajp.contentTimeUpdate, ajq.contentTimeUpdate, com.google.ads.interactivemedia.v3.impl.data.bz.create(akqVar.f()));
            n(ajq.requestNextAdBreak);
        }
    }

    public final void resume() {
        n(ajq.resume);
    }

    public final void skip() {
        n(ajq.skip);
    }

    public final void start() {
        n(ajq.start);
    }
}
