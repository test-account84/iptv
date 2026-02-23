package com.google.ads.interactivemedia.v3.internal;

import android.util.Log;
import com.google.ads.interactivemedia.v3.api.player.AdMediaInfo;
import com.google.ads.interactivemedia.v3.api.player.VideoAdPlayer;
import java.util.Iterator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class ala implements hw {
    final /* synthetic */ alc a;

    public ala(alc alcVar) {
        this.a = alcVar;
    }

    private final void j(AdMediaInfo adMediaInfo) {
        if (adMediaInfo == null || alc.g(this.a).contains(adMediaInfo)) {
            return;
        }
        Iterator it = alc.h(this.a).iterator();
        while (it.hasNext()) {
            ((VideoAdPlayer.VideoAdPlayerCallback) it.next()).onEnded(adMediaInfo);
        }
        alc.g(this.a).add(adMediaInfo);
    }

    public final /* synthetic */ void a(hv hvVar, tb tbVar) {
    }

    public final void b(hv hvVar, at atVar) {
        AdMediaInfo e = alc.e(this.a, hvVar.c);
        alc.g(this.a).add(e);
        Iterator it = alc.h(this.a).iterator();
        while (it.hasNext()) {
            ((VideoAdPlayer.VideoAdPlayerCallback) it.next()).onError(e);
        }
        Log.e("IMASDK", "Player Error:".concat(String.valueOf(atVar)));
    }

    public final /* synthetic */ void c(hv hvVar, int i, long j) {
    }

    public final /* synthetic */ void d(tb tbVar) {
    }

    public final void e(int i) {
        AdMediaInfo f = alc.f(this.a);
        if (f == null) {
            return;
        }
        if (i == 2) {
            Iterator it = alc.h(this.a).iterator();
            while (it.hasNext()) {
                ((VideoAdPlayer.VideoAdPlayerCallback) it.next()).onBuffering(f);
            }
        } else if (i != 3) {
            if (i != 4) {
                return;
            }
            j(f);
        } else {
            Iterator it2 = alc.h(this.a).iterator();
            while (it2.hasNext()) {
                ((VideoAdPlayer.VideoAdPlayerCallback) it2.next()).onLoaded(f);
            }
        }
    }

    public final void f(int i) {
        if (i != 0) {
            return;
        }
        alc alcVar = this.a;
        if (alc.c(alcVar) == null) {
            Log.d("IMASDK", "Position discontinuity occurred when there is no active media source.");
            return;
        }
        int h = alc.b(alcVar).h();
        for (int i2 = 0; i2 < h; i2++) {
            j(alc.e(this.a, i2));
        }
        AdMediaInfo e = alc.e(this.a, h);
        if (e != null) {
            for (VideoAdPlayer.VideoAdPlayerCallback videoAdPlayerCallback : alc.h(this.a)) {
                videoAdPlayerCallback.onLoaded(e);
                videoAdPlayerCallback.onPlay(e);
            }
        }
    }

    public final /* synthetic */ void g(ep epVar) {
    }

    public final /* synthetic */ void h(bl blVar) {
    }

    public final /* synthetic */ void i(az azVar, aeq aeqVar) {
    }
}
