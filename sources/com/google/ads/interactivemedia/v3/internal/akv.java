package com.google.ads.interactivemedia.v3.internal;

import android.net.Uri;
import com.google.ads.interactivemedia.v3.api.AdError;
import com.google.ads.interactivemedia.v3.api.StreamDisplayContainer;
import com.google.ads.interactivemedia.v3.api.player.ResizablePlayer;
import com.google.ads.interactivemedia.v3.api.player.VideoProgressUpdate;
import com.google.ads.interactivemedia.v3.api.player.VideoStreamPlayer;
import com.google.ads.interactivemedia.v3.impl.data.ResizeAndPositionVideoMsgData;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class akv implements VideoStreamPlayer.VideoStreamPlayerCallback, akw, akp {
    private final VideoStreamPlayer a;
    private final ajx b;
    private final ajj c;
    private boolean d;
    private final String e;
    private final String f;
    private final StreamDisplayContainer g;
    private final akq h;
    private final aeq i;

    public akv(String str, ajx ajxVar, ajj ajjVar, StreamDisplayContainer streamDisplayContainer, String str2) {
        akq akqVar = new akq(streamDisplayContainer.getVideoStreamPlayer());
        aeq aeqVar = new aeq(ajxVar.a(), streamDisplayContainer.getAdContainer());
        this.d = false;
        this.a = streamDisplayContainer.getVideoStreamPlayer();
        this.c = ajjVar;
        this.e = str;
        this.b = ajxVar;
        this.f = str2;
        this.d = false;
        this.g = streamDisplayContainer;
        this.h = akqVar;
        this.i = aeqVar;
    }

    private final void o(ajq ajqVar, Object obj) {
        this.b.o(new ajr(ajp.videoDisplay1, ajqVar, this.e, obj));
    }

    public final void a(VideoProgressUpdate videoProgressUpdate) {
        if (!this.d) {
            o(ajq.start, com.google.ads.interactivemedia.v3.impl.data.cf.builder().volumePercentage(this.a.getVolume()).build());
            this.d = true;
        }
        o(ajq.timeupdate, com.google.ads.interactivemedia.v3.impl.data.bz.create(videoProgressUpdate));
    }

    public final void b() {
        this.a.onAdBreakEnded();
        n();
    }

    public final void c() {
        com.google.ads.interactivemedia.v3.impl.data.m.c("Destroying StreamVideoDisplay");
        this.a.removeCallback(this);
        this.h.e();
        this.h.c(this);
        this.i.c();
    }

    public final void d() {
        this.h.b(this);
        this.h.d();
    }

    public final void e() {
        this.a.onAdBreakStarted();
    }

    public final void f(ajp ajpVar, ajq ajqVar, com.google.ads.interactivemedia.v3.impl.data.bm bmVar) {
        String str;
        ajq ajqVar2 = ajq.activate;
        int ordinal = ajqVar.ordinal();
        if (ordinal != 45) {
            if (ordinal == 52) {
                this.a.pause();
                return;
            } else {
                if (ordinal != 53) {
                    return;
                }
                this.a.resume();
                return;
            }
        }
        if (bmVar == null || (str = bmVar.streamUrl) == null) {
            this.c.c(new aif(new AdError(AdError.AdErrorType.LOAD, AdError.AdErrorCode.INTERNAL_ERROR, "Load message must contain video url.")));
            return;
        }
        int i = 0;
        this.d = false;
        String str2 = this.f;
        if (str2 != null && str2.length() != 0) {
            String str3 = "";
            String replaceAll = this.f.trim().replaceAll("\\s+", "");
            if (replaceAll.charAt(0) == '?') {
                replaceAll = replaceAll.substring(1);
            }
            if (replaceAll.length() != 0) {
                Map a = com.google.ads.interactivemedia.v3.impl.data.aj.a(Uri.parse(str));
                HashMap hashMap = new HashMap();
                Uri.Builder buildUpon = Uri.parse(str).buildUpon();
                buildUpon.clearQuery();
                Map a2 = com.google.ads.interactivemedia.v3.impl.data.aj.a(Uri.parse("http://www.dom.com/path?".concat(replaceAll)));
                hashMap.putAll(a2);
                if (!a.isEmpty()) {
                    for (String str4 : a.keySet()) {
                        if (!a2.containsKey(str4)) {
                            hashMap.put(str4, (String) a.get(str4));
                        }
                    }
                }
                if (!hashMap.isEmpty()) {
                    StringBuilder sb = new StringBuilder();
                    for (Map.Entry entry : hashMap.entrySet()) {
                        String str5 = (String) entry.getKey();
                        String str6 = (String) entry.getValue();
                        sb.append(str5);
                        sb.append("=");
                        sb.append(str6);
                        if (i < hashMap.size() - 1) {
                            sb.append("&");
                        }
                        i++;
                    }
                    str3 = sb.toString();
                }
                buildUpon.encodedQuery(str3);
                str = buildUpon.build().toString();
            }
        }
        this.a.loadUrl(str, bmVar.subtitles);
    }

    public final void g(ResizeAndPositionVideoMsgData resizeAndPositionVideoMsgData) {
        if (!(this.a instanceof ResizablePlayer)) {
            com.google.ads.interactivemedia.v3.impl.data.m.a("Stream player does not support resizing.");
            return;
        }
        if (!com.google.ads.interactivemedia.v3.impl.data.v.a(this.g, resizeAndPositionVideoMsgData)) {
            com.google.ads.interactivemedia.v3.impl.data.m.a("Video resize parameters were not within the container bounds.");
            return;
        }
        int width = this.g.getAdContainer().getWidth();
        int height = this.g.getAdContainer().getHeight();
        int intValue = resizeAndPositionVideoMsgData.x().intValue();
        int intValue2 = resizeAndPositionVideoMsgData.width().intValue();
        int intValue3 = resizeAndPositionVideoMsgData.y().intValue();
        ((ResizablePlayer) this.a).resize(resizeAndPositionVideoMsgData.x().intValue(), resizeAndPositionVideoMsgData.y().intValue(), (width - intValue) - intValue2, (height - intValue3) - resizeAndPositionVideoMsgData.height().intValue());
    }

    public final VideoProgressUpdate getAdProgress() {
        return this.a.getContentProgress();
    }

    public final void h() {
        VideoStreamPlayer videoStreamPlayer = this.a;
        if (videoStreamPlayer instanceof ResizablePlayer) {
            ((ResizablePlayer) videoStreamPlayer).resize(0, 0, 0, 0);
        }
    }

    public final void i() {
        this.a.onAdPeriodEnded();
    }

    public final void j() {
        this.a.onAdPeriodStarted();
    }

    public final void k() {
        this.a.addCallback(this);
    }

    public final void l(long j) {
        this.a.seek(j);
    }

    public final void m(com.google.ads.interactivemedia.v3.impl.data.c cVar) {
        if (cVar.isLinear()) {
            this.i.d();
        }
    }

    public final void n() {
        this.i.c();
    }

    public final void onContentComplete() {
        this.b.o(new ajr(ajp.adsLoader, ajq.contentComplete, "*"));
    }

    public final void onPause() {
        o(ajq.pause, null);
    }

    public final void onResume() {
        o(ajq.play, null);
    }

    public final void onUserTextReceived(String str) {
        o(ajq.timedMetadata, aku.create(str));
    }

    public final void onVolumeChanged(int i) {
        o(ajq.volumeChange, com.google.ads.interactivemedia.v3.impl.data.cf.builder().volumePercentage(i).build());
    }
}
