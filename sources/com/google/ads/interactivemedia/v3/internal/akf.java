package com.google.ads.interactivemedia.v3.internal;

import com.google.ads.interactivemedia.v3.api.AdDisplayContainer;
import com.google.ads.interactivemedia.v3.api.AdError;
import com.google.ads.interactivemedia.v3.api.player.AdMediaInfo;
import com.google.ads.interactivemedia.v3.api.player.ResizablePlayer;
import com.google.ads.interactivemedia.v3.api.player.VideoAdPlayer;
import com.google.ads.interactivemedia.v3.api.player.VideoProgressUpdate;
import com.google.ads.interactivemedia.v3.impl.data.ResizeAndPositionVideoMsgData;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class akf implements akw, aih {
    private final AdDisplayContainer a;
    private final VideoAdPlayer b;
    private final ajj c;
    private final ajx d;
    private final String e;
    private final aii f;
    private final avf g = avf.p();

    public akf(String str, ajx ajxVar, ajj ajjVar, AdDisplayContainer adDisplayContainer) {
        this.a = adDisplayContainer;
        VideoAdPlayer player = adDisplayContainer.getPlayer();
        this.b = player;
        this.c = ajjVar;
        this.d = ajxVar;
        this.e = str;
        aii aiiVar = new aii();
        this.f = aiiVar;
        aiiVar.a(this);
        player.addCallback(aiiVar);
    }

    public final void a(ajp ajpVar, ajq ajqVar) {
        this.d.o(new ajr(ajpVar, ajqVar, "*"));
    }

    public final void b(ajq ajqVar, AdMediaInfo adMediaInfo, Object obj) {
        ajp ajpVar = (ajp) this.g.g().get(adMediaInfo);
        if (ajpVar != null) {
            this.d.o(new ajr(ajpVar, ajqVar, this.e, obj));
            return;
        }
        com.google.ads.interactivemedia.v3.impl.data.m.d("The adMediaInfo for the " + String.valueOf(ajqVar) + " event is not active. This may occur if callbacks are triggered after the ad is unloaded.");
    }

    public final void c() {
        com.google.ads.interactivemedia.v3.impl.data.m.c("Destroying NativeVideoDisplay");
        this.b.removeCallback(this.f);
        this.b.release();
    }

    public final void d() {
    }

    public final void e() {
        this.f.c();
    }

    public final void f(ajp ajpVar, ajq ajqVar, com.google.ads.interactivemedia.v3.impl.data.bm bmVar) {
        AdMediaInfo adMediaInfo = (AdMediaInfo) this.g.get(ajpVar);
        ajq ajqVar2 = ajq.activate;
        int ordinal = ajqVar.ordinal();
        if (ordinal != 34) {
            if (ordinal == 43) {
                if (bmVar == null || bmVar.videoUrl == null) {
                    this.c.c(new aif(new AdError(AdError.AdErrorType.LOAD, AdError.AdErrorCode.INTERNAL_ERROR, "Load message must contain video url.")));
                    return;
                }
                this.f.b();
                AdMediaInfo adMediaInfo2 = new AdMediaInfo(bmVar.videoUrl);
                com.google.ads.interactivemedia.v3.impl.data.d dVar = bmVar.adPodInfo;
                if (dVar == null) {
                    dVar = null;
                }
                this.g.put(ajpVar, adMediaInfo2);
                this.b.loadAd(adMediaInfo2, dVar);
                return;
            }
            if (ordinal != 72) {
                if (ordinal == 52) {
                    this.b.pauseAd(adMediaInfo);
                    return;
                } else {
                    if (ordinal != 53) {
                        return;
                    }
                    this.b.playAd(adMediaInfo);
                    this.f.b();
                    return;
                }
            }
        }
        this.b.stopAd(adMediaInfo);
        this.g.remove(ajpVar);
    }

    public final void g(ResizeAndPositionVideoMsgData resizeAndPositionVideoMsgData) {
        if (!(this.b instanceof ResizablePlayer)) {
            com.google.ads.interactivemedia.v3.impl.data.m.a("Video player does not support resizing.");
            return;
        }
        if (!com.google.ads.interactivemedia.v3.impl.data.v.a(this.a, resizeAndPositionVideoMsgData)) {
            com.google.ads.interactivemedia.v3.impl.data.m.a("Creative resize parameters were not within the containers bounds.");
            return;
        }
        int width = this.a.getAdContainer().getWidth();
        int height = this.a.getAdContainer().getHeight();
        int intValue = resizeAndPositionVideoMsgData.x().intValue();
        int intValue2 = resizeAndPositionVideoMsgData.width().intValue();
        int intValue3 = resizeAndPositionVideoMsgData.y().intValue();
        ((ResizablePlayer) this.b).resize(resizeAndPositionVideoMsgData.x().intValue(), resizeAndPositionVideoMsgData.y().intValue(), (width - intValue) - intValue2, (height - intValue3) - resizeAndPositionVideoMsgData.height().intValue());
    }

    public final VideoProgressUpdate getAdProgress() {
        return this.b.getAdProgress();
    }

    public final void h() {
        VideoAdPlayer videoAdPlayer = this.b;
        if (videoAdPlayer instanceof ResizablePlayer) {
            ((ResizablePlayer) videoAdPlayer).resize(0, 0, 0, 0);
        }
    }

    public final boolean i() {
        return this.b instanceof ald;
    }
}
