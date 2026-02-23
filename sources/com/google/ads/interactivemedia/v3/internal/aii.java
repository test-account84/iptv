package com.google.ads.interactivemedia.v3.internal;

import com.google.ads.interactivemedia.v3.api.player.AdMediaInfo;
import com.google.ads.interactivemedia.v3.api.player.VideoAdPlayer;
import com.google.ads.interactivemedia.v3.api.player.VideoProgressUpdate;
import java.util.HashMap;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class aii implements VideoAdPlayer.VideoAdPlayerCallback {
    private aih b;
    private boolean c = false;
    private final HashMap a = axo.p(2);

    private final void d(ajq ajqVar, AdMediaInfo adMediaInfo) {
        e(ajqVar, adMediaInfo, null);
    }

    private final void e(ajq ajqVar, AdMediaInfo adMediaInfo, Object obj) {
        aih aihVar = this.b;
        if (aihVar != null) {
            aihVar.b(ajqVar, adMediaInfo, obj);
        }
    }

    public final void a(aih aihVar) {
        this.b = aihVar;
    }

    public final void b() {
        this.c = true;
    }

    public final void c() {
        this.c = false;
    }

    public final void onAdProgress(AdMediaInfo adMediaInfo, VideoProgressUpdate videoProgressUpdate) {
        if (this.c && videoProgressUpdate != null && videoProgressUpdate.getDuration() > 0.0f) {
            if (this.a.get(adMediaInfo) == null && videoProgressUpdate.getCurrentTime() > 0.0f) {
                d(ajq.start, adMediaInfo);
                this.a.put(adMediaInfo, Boolean.TRUE);
            }
            e(ajq.timeupdate, adMediaInfo, com.google.ads.interactivemedia.v3.impl.data.bz.create(videoProgressUpdate));
        }
    }

    public final void onBuffering(AdMediaInfo adMediaInfo) {
        if (this.c) {
            d(ajq.waiting, adMediaInfo);
        }
    }

    public final void onContentComplete() {
        aih aihVar = this.b;
        if (aihVar != null) {
            aihVar.a(ajp.adsLoader, ajq.contentComplete);
        }
    }

    public final void onEnded(AdMediaInfo adMediaInfo) {
        if (this.c) {
            d(ajq.end, adMediaInfo);
            this.a.remove(adMediaInfo);
        }
    }

    public final void onError(AdMediaInfo adMediaInfo) {
        if (this.c) {
            d(ajq.error, adMediaInfo);
            this.a.remove(adMediaInfo);
        }
    }

    public final void onLoaded(AdMediaInfo adMediaInfo) {
        if (this.c) {
            d(ajq.loaded, adMediaInfo);
        }
    }

    public final void onPause(AdMediaInfo adMediaInfo) {
        if (this.c) {
            d(ajq.pause, adMediaInfo);
        }
    }

    public final void onPlay(AdMediaInfo adMediaInfo) {
    }

    public final void onResume(AdMediaInfo adMediaInfo) {
        if (this.c) {
            d(ajq.play, adMediaInfo);
        }
    }

    public final void onVolumeChanged(AdMediaInfo adMediaInfo, int i) {
        if (this.c) {
            e(ajq.volumeChange, adMediaInfo, com.google.ads.interactivemedia.v3.impl.data.cf.builder().volumePercentage(i).build());
        }
    }
}
